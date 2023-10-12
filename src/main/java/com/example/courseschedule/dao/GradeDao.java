package com.example.courseschedule.dao;

import com.example.courseschedule.domain.Grade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "grade", path = "grade")
public interface GradeDao extends PagingAndSortingRepository<Grade, String>, CrudRepository<Grade, String> {
}
