package com.seocndlambdatask.www;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Employee> empList = new ArrayList<>();

        System.out.println("Enter the number of employees:");
        int empCount = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < empCount; i++) {

            System.out.println("\nEmployee " + (i + 1));

            System.out.print("Enter the Employee Name: ");
            String eName = sc.nextLine();

            System.out.print("Enter the Employee Age: ");
            int eAge = sc.nextInt();

            System.out.print("Enter the Employee Salary: ");
            double eSal = sc.nextDouble();
            sc.nextLine();

            empList.add(new Employee(eName, eAge, eSal));
        }

        System.out.println("\nAll Employees:");
        empList.forEach(System.out::println);

        System.out.println("\n Employees with Salary > 5000:");
        empList.stream()
               .filter(emp -> emp.getSalary() > 5000).forEach(System.out::println);

        System.out.println("\nSorted Employees by Age:");
        empList.stream().sorted(Comparator.comparing(Employee::getAge)).forEach(System.out::println);

        System.out.println("\nEmployee Bonus (10%):");
        empList.stream().map(emp -> emp.getName() + " -> Bonus: " + (emp.getSalary() * 0.10)).forEach(System.out::println);

        sc.close();
    }
}
