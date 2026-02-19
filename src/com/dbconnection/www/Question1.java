package com.dbconnection.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Question1 {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/sbs_db";
		String username = "postgres";
		String password = "root";

		Scanner sc = new Scanner(System.in);

// //		--------------------------Question-1---------------------------------

		System.out.println("Enter the Product ID you want to check for delete: ");
		int idToDelete = sc.nextInt();
		sc.nextLine();

		try (Connection conn = DriverManager.getConnection(url, username, password);) {
			if (conn !=null) {

				String checkOrder = "select order_id from orders where product_id=?";// count(*)- aggregate kr rha hai isliye order_id hi liya hai.
				PreparedStatement co = conn.prepareStatement(checkOrder);// create a statement
				co.setInt(1, idToDelete);// value assign
				ResultSet rs = co.executeQuery();// get the result

				if (!rs.next()) {
					String delQuery = "delete from product where prod_id =?;";
					PreparedStatement ps = conn.prepareStatement(delQuery);
					ps.setInt(1, idToDelete);
					ps.executeUpdate();

					System.out.println("delete successfully");

				} else {
					System.out.println("Cannot delete product with existing orders");
				}

			}
		}
	}
}
