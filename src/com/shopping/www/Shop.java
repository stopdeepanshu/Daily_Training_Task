package com.shopping.www;

import java.util.Arrays;
import java.util.Scanner;

public class Shop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the total number of Product you want to add: ");
		int totalProduct = sc.nextInt();
		sc.nextLine();
		String[] arr = new String[totalProduct];

		for (int i = 0; i < totalProduct; i++) {
			System.out.println("Enter the " + (i + 1) + "th product name: ");
			arr[i] = sc.nextLine();
		}

		System.out.println(Arrays.toString(arr));

		while (true) {
			System.out.println("Enter the product you want to search: ");
			String targetWord = sc.nextLine();
			boolean flag = false;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i].equals(targetWord)) {
					flag = true;
					break;
				}
			}
			if ( flag) {
				System.out.println("Product found");
				System.out.println("Do you wants to quit?(Y/N):");
				String choice = sc.nextLine();
				if (choice.equalsIgnoreCase("Y")) {
					break;
				}
			} else {
				System.out.println("Product Not Found");
				System.out.println("Do you wants to quit?(Y/N):");
				String choice = sc.nextLine();
				if (choice.equalsIgnoreCase("Y")) {
					break;
				}
			}

		}
	}
}
