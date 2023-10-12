package com.example.courseschedule.dao;


import com.example.courseschedule.domain.Experiment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "experiment", path = "experiment")
public interface ExperimentDao extends PagingAndSortingRepository<Experiment, String>, CrudRepository<Experiment, String> {
}
