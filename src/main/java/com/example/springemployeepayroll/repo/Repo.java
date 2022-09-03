package com.example.springemployeepayroll.repo;

import com.example.springemployeepayroll.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo extends JpaRepository<EmployeeEntity, Long> {
    @Query(value="SELECT * FROM employee_data, employee_department WHERE employee_id = id AND department = :department", nativeQuery=true)
    List<EmployeeEntity> findEmployeesByDepartment(String department);
}

/*
@Query
Annotation for Native Queries.

In order to define SQL to execute for a Spring Data repository method, we can annotate the method with the @Query annotation
 */
