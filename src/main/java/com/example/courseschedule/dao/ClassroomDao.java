package com.example.courseschedule.dao;

import com.example.courseschedule.domain.Classroom;
import com.example.courseschedule.domain.PreSchedule;
import org.springframework.beans.factory.ListableBeanFactoryExtensionsKt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "classroom", path = "classroom")
public interface ClassroomDao extends PagingAndSortingRepository<Classroom, Integer>, CrudRepository<Classroom, Integer> {
    List<Classroom> findAll();
    List<Classroom> findByClassroomName(String name);
}
