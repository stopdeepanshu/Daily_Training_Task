package com.dbconnection.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Question3 {
	public static void main(String[] args) {
//		-------------------------------Question-2-----------------------------

// 3. Write a JDBC program that: - Create a pojo class for ProductReport
// Fetches top 3 products based on number of orders
//          Display:
//		    prodName
//		    orderCount
//		    totalRevenue

		List<Product> list = new ArrayList<Product>();

		String url = "jdbc:postgresql://localhost:5432/sbs_db";
		String username = "postgres";
		String password = "root";

		try (Connection conn = DriverManager.getConnection(url, username, password);) {

			String query = "\r\n"
					+ "select p.prod_name, count(o.product_id) as orderCount,sum(p.price) as totalRevenue\r\n"
					+ "from orders o\r\n" + "inner join product p\r\n" + "on o.product_id=p.prod_id\r\n"
					+ "group by prod_name;";

			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String product_name = rs.getString("prod_name");
				int order_count = rs.getInt("orderCount");
				int total_revenue = rs.getInt("totalRevenue");

				Product prod = new Product(product_name, order_count, total_revenue);
				list.add(prod);
			}
			list.forEach(System.out::println);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
