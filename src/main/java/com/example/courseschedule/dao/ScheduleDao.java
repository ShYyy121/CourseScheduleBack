package com.example.courseschedule.dao;
import com.example.courseschedule.domain.*;
import com.example.courseschedule.domain.Class;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "schedule", path = "schedule")
public interface ScheduleDao extends PagingAndSortingRepository<Schedule, Integer>, CrudRepository<Schedule, Integer>{
    void deleteByWeekAndWeekdayAndPeriod(String week, String weekday, String period);
    List<Schedule> findAll();

    @RestResource(path = "findByClass")
    List<Schedule> findByTeachingClass_ClassId(Integer id);


    @RestResource(path = "findByClassroom")
    List<Schedule> findByClassroom_ClassroomId(Integer id);

    @RestResource(path = "findByTeacher")
    @Query("select sc from Schedule as sc where sc.teachingClass.teacher.teacherId = :id")
    List<Schedule> findScheduleByTeacherId(Integer id);


    List<Schedule> findScheduleByWeek(String week);
}
