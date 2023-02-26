package com.love2code.springboot.cruddemo.dao;

import java.util.List;

import com.love2code.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();
	public Employee findById(int theid);
	
	public void save(Employee theemployee);
	public void deleteById(int theid );

}
