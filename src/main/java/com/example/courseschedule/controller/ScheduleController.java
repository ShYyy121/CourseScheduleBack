//package com.example.courseschedule.controller;
//
//import com.example.courseschedule.dao.ClassDao;
//import com.example.courseschedule.dao.ScheduleDao;
//import com.example.courseschedule.domain.Classroom;
//import com.example.courseschedule.domain.Schedule;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import com.example.courseschedule.domain.Class;
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/schedule")
//public class ScheduleController {
//
//    private final ScheduleDao scheduleDao;
//
//
//    @Autowired
//    public ScheduleController(ScheduleDao scheduleDao, ClassDao classDao) {
//        this.scheduleDao = scheduleDao;
//
//    }
//
//    @GetMapping("/{scheduleId}")
//    public Schedule getScheduleById(@PathVariable int scheduleId) {
//        return scheduleDao.findById(scheduleId)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid schedule ID: " + scheduleId));
//    }
//
//    @PostMapping("/")
//    public Schedule createSchedule(@RequestBody Schedule schedule) {
//        return scheduleDao.save(schedule);
//    }
//
//    @PutMapping("/{scheduleId}")
//    public Schedule updateSchedule(@PathVariable int scheduleId, @RequestBody Schedule updatedSchedule) {
//        return scheduleDao.findById(scheduleId)
//                .map(schedule -> {
//                    schedule.setTeachingClass(updatedSchedule.getTeachingClass());
//                    schedule.setClassroom(updatedSchedule.getClassroom());
//                    schedule.setWeek(updatedSchedule.getWeek());
//                    schedule.setWeekday(updatedSchedule.getWeekday());
//                    schedule.setPeriod(updatedSchedule.getPeriod());
//                    // 设置其他属性
//                    return scheduleDao.save(schedule);
//                })
//                .orElseThrow(() -> new IllegalArgumentException("Invalid schedule ID: " + scheduleId));
//    }
//
//    @DeleteMapping("/{scheduleId}")
//    public void deleteSchedule(@PathVariable int scheduleId) {
//        scheduleDao.deleteById(scheduleId);
//    }
//
//    // 其他自定义的API方法
//
//    @GetMapping("/")
//    public List<Schedule> getAllSchedules() {
//        return scheduleDao.findAll();
//    }
//
//    @GetMapping("/classroom/{classroomId}")
//    public List<Class> getClassroomCourses(@PathVariable int classroomId) {
//        // 根据实验室ID获取实验室课程列表
//        Classroom class0=new Classroom();
//        class0.setClassroomId(classroomId);
//        List<Schedule> byTeachingClass = scheduleDao.findByClassroom(class0);
//        List<Class> classes=new ArrayList<>();
//        for (Schedule teachingClass : byTeachingClass) {
//            classes.add(teachingClass.getTeachingClass());
//        }
//        return classes;
//    }
//}
