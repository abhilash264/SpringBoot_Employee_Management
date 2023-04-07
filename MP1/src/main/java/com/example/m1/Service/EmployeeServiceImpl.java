package com.example.m1.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.m1.Model.Employee;
import com.example.m1.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository emp;
	
	public List<Employee> getAllEmployee()
	{
		return emp.findAll();
	}

	@Override
	public void addEmployee(Employee emp) {
		this.emp.save(emp);
		
	}

	@Override
	public Employee getemployeeByID(long id) {
		Optional<Employee> option=emp.findById(id);
		Employee employee;
		if(option.isPresent())
		{
			employee=option.get();
		}
		else
		{
			throw new RuntimeException("employee not found for id "+id);
		}
		return employee;
	}
}
