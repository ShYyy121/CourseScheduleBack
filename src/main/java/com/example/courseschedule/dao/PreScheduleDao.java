package com.example.courseschedule.dao;

import com.example.courseschedule.domain.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "pre-schedule", path = "pre-schedule")
public interface PreScheduleDao extends PagingAndSortingRepository<PreSchedule, String>, CrudRepository<PreSchedule, String> {

}
