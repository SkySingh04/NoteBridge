package com.notebridge.backend.database;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
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
//		try {
//		execution(command);
//		return true;
//		}
//		catch(Exception ef) {
//	        ef.printStackTrace();
//	        return false; // Return false if any exception occurs
//		}
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

	public static void main (String[] args) {
		
		System.out.println("hi");
	}
}



