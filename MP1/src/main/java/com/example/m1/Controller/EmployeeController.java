package com.example.m1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.m1.Model.Employee;
import com.example.m1.Service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService emp;// Providing the object of Employee to the thymeleaf template so that it can bind(put) the data to that empty object.

	// Providing the object of Employee to the thymeleaf template so that it can bind(put) the data to that empty object.
	
	@RequestMapping("/")
	public String HomepageView(Model model)
	{
		model.addAttribute("ListOfEmployees",emp.getAllEmployee());
		return "index";
	}
	@RequestMapping("/showEmployeeviaform")
	public String addEmployee(Model model)
	{
		
		Employee employee=new Employee();// Providing the object of Employee to the thymeleaf template so that it can bind(put) the data to that empty object.
		model.addAttribute("employee",employee);
		return "new_employee";
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee)
	{
		emp.addEmployee(employee);
		return "redirect:/";
	}
	@RequestMapping("/updateform/{id}")
	public String showformforupdate(@PathVariable long id,Model model)
	{
		Employee employee=emp.getemployeeByID(id);
		model.addAttribute("employee",employee);
		return "updateemployee";
		
		
	}
	
}
