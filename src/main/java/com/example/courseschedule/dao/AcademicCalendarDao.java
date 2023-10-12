package com.example.courseschedule.dao;


import com.example.courseschedule.domain.AcademicCalendar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "academic-calendar", path = "academic-calendar")
public interface AcademicCalendarDao extends PagingAndSortingRepository<AcademicCalendar, String>, CrudRepository<AcademicCalendar, String> {

}
