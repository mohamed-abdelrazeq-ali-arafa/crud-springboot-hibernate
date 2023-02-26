package com.love2code.springboot.cruddemo.service;

import java.util.List;

import com.love2code.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findById(int theid);
	
	public void save(Employee theemployee);
	public void deleteById(int theid );


}
