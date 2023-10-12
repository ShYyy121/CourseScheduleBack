package com.example.courseschedule.service;

import com.example.courseschedule.dao.PreScheduleDao;
import com.example.courseschedule.dao.ScheduleDao;
import com.example.courseschedule.domain.PreSchedule;
import com.example.courseschedule.domain.Schedule;
import com.example.courseschedule.dto.CollisionResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PreScheduleService {
    private final PreScheduleDao preScheduleDao;
    private final ScheduleDao scheduleDao;

    public PreScheduleService(PreScheduleDao preScheduleDao, ScheduleDao scheduleDao) {
        this.preScheduleDao = preScheduleDao;
        this.scheduleDao = scheduleDao;
    }

    public CollisionResult flushToSchedule() {
        CollisionResult collisionResult = new CollisionResult();
        //judge if preSchedule have same week,weekday,period
        //if have, add to collisionResult
        preScheduleDao.findAll().forEach(preSchedule -> {
            collisionResult.getCollisionList().forEach(
                    collision -> {
                        if (Objects.equals(collision.get(0).getWeek(), preSchedule.getWeek()) &&
                                Objects.equals(collision.get(0).getWeekday(), preSchedule.getWeekday()) &&
                                Objects.equals(collision.get(0).getPeriod(), preSchedule.getPeriod())) {
                            collision.add(preSchedule);
                        }else {
                            collisionResult.addCollision(new ArrayList<>() {{
                                add(preSchedule);
                            }});
                        }
                    }
            );
        });
        //check if collisionResult have collision more than 1
        //if have, return collisionResult
        //if not, flush to schedule
        CollisionResult result = new CollisionResult();
        collisionResult.getCollisionList().forEach(
                collision -> {
                    if (collision.size() > 1) {
                        result.addCollision(collision);
                    }
                }
        );
        if (result.getCollisionList().size() > 0) {
            result.setCollision(true);
        }else {
            List<Schedule> schedules = new ArrayList<>();
            preScheduleDao.findAll().forEach(preSchedule -> {

                scheduleDao.deleteByWeekAndWeekdayAndPeriod(preSchedule.getWeek(), preSchedule.getWeekday(), preSchedule.getPeriod());
                Schedule schedule = new Schedule();
                schedule.setWeek(preSchedule.getWeek());
                schedule.setWeekday(preSchedule.getWeekday());
                schedule.setPeriod(preSchedule.getPeriod());
                schedule.setClassroom(preSchedule.getClassroom());
                schedule.setTeachingClass(preSchedule.getTeachingClass());
                schedules.add(schedule);
            });
            scheduleDao.saveAll(schedules);
            result.setCollision(false);
        }
        return result;
    }
}
