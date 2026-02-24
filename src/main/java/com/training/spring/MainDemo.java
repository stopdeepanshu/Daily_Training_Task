package com.training.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.training.spring.config.AppConfig;
import com.training.spring.dao.EmployeeDao;
import com.training.spring.entity.Department;
import com.training.spring.entity.Employee;

public class MainDemo {
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//		
//		Person person1 = (Person) context.getBean("person");
//
//		System.out.println(person1.getFirstName());
//
//		Person person2 = (Person) context.getBean("person");
//
//		System.out.println(person2.getFirstName());
//
//		person2.setFirstName("Peter");
//  
//		System.out.println(person2.getPersonDetails());

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		EmployeeDao dao = context.getBean(EmployeeDao.class);

		Employee emp = new Employee("David", 20000);
		Department dept = new Department("Sales");
		emp.setDept(dept);
		dao.addEmployee(emp);
		context.close();
//		Person person1=(Person)context.getBean(Person.class);
//		System.out.println(person1.getPersonDetails());
//		
//		System.out.println("Person 1 name is: "+person1.getFirstName());
//		System.out.println("Person 2 name is: "+person2.getFirstName());
	}
}
