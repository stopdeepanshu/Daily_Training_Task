package com.Streamapi16task.www;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Driver {
	public static void main(String[] args) {

		List<Employee> empList = new ArrayList<>();

		empList.add(new Employee("E101", "Rahul", 50000, 25, "Development"));
		empList.add(new Employee("E102", "Siddharth", 60000, 28, "HR"));
		empList.add(new Employee("E103", "Amit", 55000, 30, "Finance"));
		empList.add(new Employee("E104", "Amit Shah ", 70000, 27, "IT"));
		empList.add(new Employee("E105", "Sunny", 65000, 32, "Sales"));
		empList.add(new Employee("E106", "Bishal", 65000, 32, "IT"));
		empList.add(new Employee("E107", "Mukherjee", 65000, 32, "Sales"));
		empList.add(new Employee("E108", "Arpit", 65000, 32, "IT"));
		empList.add(new Employee("E109", "Mithun Da", 65000, 32, "Sales"));
		empList.add(new Employee("E110", "Johny", 65000, 32, "Finance"));

		// finding the second highest salary
		Employee secondHighest = empList.stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
				.skip(1).findFirst().orElse(null);

		// finding the Oldest Employee using stream
		Optional<Employee> oldestEmp = empList.stream().max((a1, a2) -> Integer.compare(a1.getAge(), a2.getAge()));

		System.out.println("Second Highest Salary: " + secondHighest);
		System.out.println("Oldest Employee: " + oldestEmp.get());

		// finding the count in each Department.
		Map<String, Long> countDept = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("Count employee in each dept: " + countDept);

		// finding the average sal of each Department.
		Map<String, Double> avgDept = empList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("Average sal of each dept: " + avgDept);
		
		// finding the average salary in each department.
		Double avgSalary=empList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println("Average sal of Employees: " + avgSalary);

		// finding the employee having above average salary.
		List<Employee> aboveAvg=empList.stream()
								.filter(e->e.getSalary()>avgSalary)
								.collect(Collectors.toList());
		
		System.out.println("Employee having above average Salary: " + aboveAvg);
		

	}
}
