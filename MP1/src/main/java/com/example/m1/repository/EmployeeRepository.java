package com.example.m1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.m1.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
