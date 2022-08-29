package com.example.springemployeepayroll.repo;

import com.example.springemployeepayroll.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<EmployeeEntity, Long> {
}
