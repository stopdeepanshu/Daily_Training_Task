package com.dbconnection.www;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Question2 {
	public static void main(String[] args) {

//				-------------------------------Question-2-----------------------------

//				Write a JDBC program to insert multiple values into the product table.
//				Conditions:
//							1.Use the stored procedure that was created in the last session.
//							2.Use CallableStatement to call the stored procedure.

		String url = "jdbc:postgresql://localhost:5432/sbs_db";
		String username = "postgres";
		String password = "root";

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter how many products you want to add: ");
		int addNProd = Integer.parseInt(sc.nextLine());

		for (int i = 1; i <= addNProd; i++) {

			System.out.print("Enter the Id of the Product: ");
			int prodId = Integer.parseInt(sc.nextLine());
			
			System.out.print("Enter the name of the Product Name: ");
			String prodName = sc.nextLine();
			

			System.out.print("Enter the name of the Product Description: ");
			String prodDesc = sc.nextLine();
			
			System.out.print("Enter the Category of the Product:");
			String prodCategory = sc.nextLine();
		

			System.out.print("Enter the price of the Product:");

			int prodPrice = Integer.parseInt(sc.nextLine());

			try (Connection conn = DriverManager.getConnection(url, username, password);) {
				if (!conn.equals(null)) {
					String procedureCallToInsert = "CALL INSERTPRODUCT(?,?,?,?,?)";
					CallableStatement spc = conn.prepareCall(procedureCallToInsert);
					spc.setInt(1, prodId);
					spc.setString(2, prodName);
					spc.setString(3, prodDesc);
					spc.setInt(4, prodPrice);
					spc.setString(5, prodCategory);

					spc.execute();
					System.out.println("Data inserted successfully.");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
}
