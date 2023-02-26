package com.love2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.love2code.springboot.cruddemo.dao.EmployeeDAO;
import com.love2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
     
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theemployeeDao) {
		
		employeeDAO=theemployeeDao;
	}
	
	
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theid) {
		// TODO Auto-generated method stub
		return employeeDAO.findById(theid);
	}

	@Override
	@Transactional
	public void save(Employee theemployee) {
		employeeDAO.save(theemployee);

	}

	@Override
	@Transactional
	public void deleteById(int theid) {
		employeeDAO.deleteById(theid);

	}

}
