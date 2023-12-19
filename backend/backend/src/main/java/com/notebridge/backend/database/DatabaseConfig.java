package com.notebridge.backend.database;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.notebridge.backend.modal.User;

public class DatabaseConfig{
	
	static boolean execution(String comm) {
		String command=comm;
		String url = "jdbc:mysql://localhost:3306/Notessharing";
	    String user = "root";
	    String pwd = "123456";
	    
		try (
	            // Establish a connection to the database server
	            Connection connection = DriverManager.getConnection(url, user, pwd);
	            
	            // Create a statement object
	            Statement statement = connection.createStatement();
	        ) {
	            // Execute the SQL command to create the database
	            statement.executeUpdate(command);

	            return true;

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	
	static void database(){
		String url = "jdbc:mysql://localhost:3306/";
	    String user = "root";
	    String pwd = "123456";
	    String dbName ="Notessharing";
	    String command = "CREATE DATABASE IF NOT EXISTS " + dbName;
		try (
	            // Establish a connection to the database server
	            Connection connection = DriverManager.getConnection(url, user, pwd);
	            
	            // Create a statement object
	            Statement statement = connection.createStatement();
	        ) {
	            // Execute the SQL command to create the database
	            statement.executeUpdate(command);
	            statement.executeUpdate("USE "+dbName);
	            

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    
	     
	}
	static void create() {
		String comm;
		comm="CREATE TABLE IF NOT EXISTS MEMBERS(FNAME VARCHAR(20) NOT NULL, LNAME VARCHAR(20), EMAIL VARCHAR(50) PRIMARY KEY, PASSWORD VARCHAR(50) NOT NULL, ROLE VARCHAR(10) NOT NULL);";
		execution(comm);
		
	}
	static boolean insertvalues(String a,String b,String c, String d,String e) {
		String fname=a;
		String lname=b;
		String email=c;
		String password =d;
		String role =e;
		String command ="INSERT INTO MEMBERS VALUES ('"+fname+"', '"+lname+"', '"+email+"', '"+password+"', '"+role+"');";
		return execution(command);
		
	}
	
	public boolean getdata(List<String> a) {
	    String fname = a.get(0);
	    String lname = a.get(1);
	    String email = a.get(2);
	    String password = a.get(3);
	    String role = a.get(4);
	        create();
	        boolean sol = insertvalues(fname, lname, email, password, role);
	        return sol; // Return true if successful
	}
	
	public User getUserByEmailAndPassword(String email, String password) {
	    User user = null;
	    String url = "jdbc:mysql://localhost:3306/Notessharing";
	    String userDB = "root";
	    String pwdDB = "123456";

	    try (Connection connection = DriverManager.getConnection(url, userDB, pwdDB)) {
	        String query = "SELECT * FROM MEMBERS WHERE EMAIL=? AND PASSWORD=?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, email);
	            preparedStatement.setString(2, password);

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    // Found a matching user, populate the user object
	                    user = new User();
	                    user.setFirstName(resultSet.getString("FNAME"));
	                    user.setLastName(resultSet.getString("LNAME"));
	                    user.setEmail(resultSet.getString("EMAIL"));
	                    user.setPassword(resultSet.getString("PASSWORD"));
	                    user.setRole(resultSet.getString("ROLE"));
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.err.println("Error retrieving user from the database: " + e.getMessage());
	    }

	    return user; // Return null if no user found or an exception occurs
	}




	public static void main (String[] args) {
		
		System.out.println("hi");
	}
}



