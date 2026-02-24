package com.training.spring.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.training.spring.entity.Employee;

@Repository
public class EmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void addEmployee(Employee emp) {
		entityManager.persist(emp);
        System.out.println("Employee Saved");
	}
}
