package com.example.m1.Service;

import java.util.*;

import com.example.m1.Model.Employee;
public interface EmployeeService {

	List<Employee> getAllEmployee();
	void addEmployee(Employee emp);
	Employee getemployeeByID(long id);
}
