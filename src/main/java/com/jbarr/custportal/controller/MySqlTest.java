package com.jbarr.custportal.controller;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlTest {
	public static void main(String[] argv) throws SQLException {

		System.out.println("-------- MySQL JDBC Connection Testing ------------");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;

		try {
			connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/sakila","jbarr", "jb088287");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			
			// Run SQL query
			try {
				Statement stmt = connection.createStatement();
				String sql;
				sql = "SELECT customer_id, first_name, last_name, email FROM customer WHERE customer_id = 9";
				
				// Extract data
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()){
			         //Retrieve by column name
			         int id  = rs.getInt("customer_id");
			         String first = rs.getString("first_name");
			         String last = rs.getString("last_name");
			         String email = rs.getString("email");
			         
			         System.out.println(id + "  " + first + "  " + last + "  " + email);
				}
			         
			    rs.close();
			    stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("You made it, take control your database now!");
			connection.close();
		} else {
			System.out.println("Failed to make connection!");
		}
	  }
	}
