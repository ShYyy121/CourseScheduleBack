package com.example.courseschedule.dao;


import com.example.courseschedule.domain.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "teacher", path = "teacher")
public interface TeacherDao extends PagingAndSortingRepository<Teacher, Integer>, CrudRepository<Teacher, Integer> {
    Teacher findByTeacherId(int teacherId);
    Teacher findByTeacherName(String teacherName);
}
