package StudentData;

import java.util.Arrays;
import java.util.Scanner;

public class multiArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of students: ");
		int totalStudents = sc.nextInt();
		System.out.println("Enter the number of Subject: ");
		int totalSubject = sc.nextInt();

		int[][] studentMarks = new int[totalStudents][totalSubject];

		for (int i = 0; i < studentMarks.length; i++) {
			System.out.println("/uEnter the marks of Student " + (i + 1)+":");
			for (int j = 0; j < studentMarks[i].length; j++) {
				System.out.println("Enter the marks of Subject " + (j + 1)+":");
				studentMarks[i][j] = sc.nextInt();
			}
		}
		System.out.println(Arrays.toString(studentMarks));

//		int[][] studentMarks = { { 2, 3, 1 }, { 5, 7, 6 }, { 9, 0, 8 } };
		int totalMarks = 0;

		for (int i = 0; i < studentMarks.length; i++) {
			for (int j = 0; j < studentMarks.length; j++) {
				totalMarks += studentMarks[i][j];
			}
			System.out.println("Total marks of Students are: " + totalMarks);
		}
	}
}
