package com.librarysystem.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	public static Connection getConnection() {

		String url = "jdbc:postgresql://localhost:5432/testDB";
		String uname = "postgres";
		String pswd = "root";

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, uname, pswd);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

}
