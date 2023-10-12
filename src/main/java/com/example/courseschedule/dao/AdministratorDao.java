package com.example.courseschedule.dao;
import com.example.courseschedule.domain.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "administrator", path = "administrator")
public interface AdministratorDao extends PagingAndSortingRepository<Administrator, String>, CrudRepository<Administrator, String>{
    Administrator findByAdminId(int adminId);
    Administrator findByAdminName(String adminName);
}
