package com.example.courseschedule.dao;

import com.example.courseschedule.domain.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "course", path = "course")
public interface CourseDao extends PagingAndSortingRepository<Course, String>, CrudRepository<Course, String> {
}
