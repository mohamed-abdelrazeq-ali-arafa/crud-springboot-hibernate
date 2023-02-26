package com.love2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.love2code.springboot.cruddemo.dao.EmployeeDAO;
import com.love2code.springboot.cruddemo.entity.Employee;
import com.love2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
		
	private EmployeeService employeeservice;
	
	public EmployeeRestController (EmployeeService theemployeeservice ) {
		
		employeeservice=theemployeeservice;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeservice.findAll();
		
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee employee=employeeservice.findById(employeeId);
		if(employee==null) {
			throw new RuntimeException("Employee id is not defind");
		}
		else
			
		return employee;
	}
	
	@RequestMapping(value="/employees",method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		employeeservice.save(employee);
		return employee;
		
	}
	
	@RequestMapping(value="/employees",method = RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeservice.save(employee);
		return employee;
		
	}
	
	@RequestMapping(value="/employees/{employeeid}",method = RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable int employeeid) {
		Employee tempemployee=employeeservice.findById(employeeid);
		if(tempemployee==null) {
			throw new RuntimeException("Employee id is not defind");
		}
		else
			 employeeservice.deleteById(tempemployee.getId());;
		
	   return "Deleted Employee id is  "+ tempemployee.getId();
		
		
	}
	
	
	
	
	
}
