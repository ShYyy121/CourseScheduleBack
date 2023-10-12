package com.example.courseschedule.dao;

import com.example.courseschedule.domain.Major;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "major", path = "major")
public interface MajorDao extends PagingAndSortingRepository<Major, String>, CrudRepository<Major, String> {

}
