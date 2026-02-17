package com.array.www;

import java.util.*;

//Create a program that asks user to input the student marks 
//and then calculate the average and dispaly the result

public class StudentMark {
	public static void main(String[] args) {
		int[] marks=new int[5];
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the marks of the Student: ");

		for (int i = 0; i < marks.length; i++) {
			marks[i]=sc.nextInt();
		}
		
		System.out.println(Arrays.toString(marks));
		
		int marksTotal=0;
		for (int i = 0; i < marks.length; i++) {
			marksTotal+=marks[i];
		}
		int averageMarks=marksTotal / marks.length;
		System.out.println("Total marks of the Student is "+marksTotal+".");
		System.out.println("Average marks of the Student is "+averageMarks+".");
		
		System.out.println(marks.length);
	}
}
