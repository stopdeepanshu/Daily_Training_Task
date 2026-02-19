package com.dbconnection.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Question4 {

//	4. Write a JDBC program that:
//	    Inserts multiple products using batch processing
//	    Then inserts multiple orders for those products using batch
//	    Commit transaction only if all inserts succeed
//	    Rollback entirely if any failure occurs.
//
//	Requirements: --> use addBatch() and executeBatch() methods
//	    con.setAutoCommit(false);
//	    con.commit();
//	    con.rollback();

	public static void main(String[] args) {
		List<Product> list = new ArrayList<Product>();

		String url = "jdbc:postgresql://localhost:5432/sbs_db";
		String username = "postgres";
		String password = "root";
		Connection conn = null;

		try {

			conn = DriverManager.getConnection(url, username, password);

			// commit off.
			conn.setAutoCommit(false);

			String query = "INSERT INTO product(prod_id, prod_name, product_desc, price, prod_category) VALUES (?, ?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, 696);
			ps.setString(2, "Keyboard");
			ps.setString(3, "Mechanical keyboard");
			ps.setInt(4, 4500);
			ps.setString(5, "Accessories");

			ps.addBatch();

			ps.setInt(1, 929);
			ps.setString(2, "Mouse");
			ps.setString(3, "Digital Mouse");
			ps.setInt(4, 7800);
			ps.setString(5, "Digital Accessories");

			ps.addBatch();

			ps.executeBatch();

			//commit on
			conn.commit();
			System.out.println("All Batches added succesfully!!");

		} catch (SQLException e) {

			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				} 
				System.out.println("Error occurred. Transaction rolled back.");
			}

			e.printStackTrace();
		}

		finally {

			if (conn != null) {
				try {
					conn.setAutoCommit(true);
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}
