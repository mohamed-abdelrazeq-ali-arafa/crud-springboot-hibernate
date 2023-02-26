package com.love2code.springboot.cruddemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.love2code.springboot.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;

@Repository

public class EmploueeDAOHibernateImpl implements EmployeeDAO {
     
	//define entity manager
	private EntityManager entityManager;
	
	//constructor injection
	@Autowired
	public EmploueeDAOHibernateImpl(EntityManager theentitymanager) {
	      entityManager=theentitymanager;
	}
	
	
	
	@Override
	public List<Employee> findAll() {
		//get curretn session 
		Session currentSession=entityManager.unwrap(Session.class);
		
		//create query 
			Query<Employee> theQuery=currentSession.createQuery("from Employee",Employee.class);
			
			
		//execute query
			List<Employee> employees=theQuery.getResultList();
		return employees;
	}



	@Override
	public Employee findById(int theid) {
		        //get curretn session 
				Session currentSession=entityManager.unwrap(Session.class);
				
				//create query 
				Employee theemployee=currentSession.get(Employee.class, theid);
					
				//execute query
				return theemployee;
	}



	@Override
	public void save(Employee theemployee) {
		 //get curretn session 
		Session currentSession=entityManager.unwrap(Session.class);
		
		//create query 
		currentSession.saveOrUpdate(theemployee);
			
		
	}



	@Override
	public void deleteById(int theid) {
         Session currentSession=entityManager.unwrap(Session.class);
		
		//create query 
         Query<Employee> theQuery=currentSession.createQuery("delete from Employee where id =:employeeid");
         theQuery.setParameter("employeeid", theid);
		 theQuery.executeUpdate();	
		
	}

}
