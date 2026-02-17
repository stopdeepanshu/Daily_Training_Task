package com.lambdatask.www;

import java.util.Scanner;
import java.util.function.Function;

public class EmployeeDriver {

	static double salary;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Employee Id: ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter Employee Name: ");
		String name = sc.nextLine();

		System.out.println("Enter employee salary: ");
		salary = sc.nextDouble();

		Employee e1 = new Employee(id, name, salary);

		e1.setEmpSalary(updatedSalary(salary));

		System.out.println("\nThis is the updated details\n");
		System.out.println(e1);
		sc.close();
	}

	private static Double updatedSalary(double salary) {
		Function<Double, Double> newSalary = n -> n + (n * 0.15);
		return newSalary.apply(salary);
	}

}
