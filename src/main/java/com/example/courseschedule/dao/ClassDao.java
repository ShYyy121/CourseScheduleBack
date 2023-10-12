package com.example.courseschedule.dao;

import com.example.courseschedule.domain.*;
import com.example.courseschedule.domain.Class;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "class", path = "class")
public interface ClassDao extends PagingAndSortingRepository<Class, String>, CrudRepository<Class, String>{
    List<Class> findByTeacher(Teacher teacher);
}
