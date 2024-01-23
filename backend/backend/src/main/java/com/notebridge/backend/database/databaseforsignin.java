package com.notebridge.backend.database;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import java.net.*;
import java.util.*;


import com.notebridge.backend.modal.Trusted_user_ip;
import com.notebridge.backend.modal.User;

public class databaseforsignin{
	
	static boolean execution(String comm) {
		String command=comm;
		String url = "jdbc:mysql://localhost:3306/Notessharing";
	    String user = "root";
	    String pwd = "hariambika";
	    
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
	    String pwd = "hariambika";
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
	public static void create() {
		String comm;
		comm="CREATE TABLE IF NOT EXISTS TRUSTED_SIGNIN(EMAIL VARCHAR(50) PRIMARY KEY, SESSION_TOKEN VARCHAR(15) NOT NULL, IP_ADDRESS VARCHAR(20) NOT NULL );";
		execution(comm);
		comm="CREATE TABLE IF NOT EXISTS HISTORY(EMAIL VARCHAR(50), IP_ADDRESS VARCHAR(15) NOT NULL, HISTORY VARCHAR(25) NOT NULL );";
		execution(comm);
		
	}
	
	public boolean check_trusted_ip(String a) {
		String email=a;
		boolean truth =false;
	    String url = "jdbc:mysql://localhost:3306/Notessharing";
	    String userDB = "root";
	    String pwdDB = "hariambika";

	    try (Connection connection = DriverManager.getConnection(url, userDB, pwdDB)) {
	        String query = "SELECT * FROM TRUSTED_SIGNIN WHERE EMAIL=?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, email);
	            

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    // Found a matching user, populate the user object
	                                        
	                    truth=true;
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.err.println("Error retrieving user from the database: " + e.getMessage());
	    }

	    return truth; // Return null if no user found or an exception occurs
	}
		
	
	
	static boolean set_trusted_ip(String a,String b,String c) {
		String email=a;
		String session_token =b;
		String ip=c;
		String command ="INSERT INTO TRUSTED_SIGNIN VALUES ('"+email+"', '"+session_token+"', '"+ip+"');";
		return execution(command);
		
	}
	
	static boolean insert_history(String a,String b,String c) {
		String email=a;
		String ip=b;
		String history=c;
		String command ="INSERT INTO HISTORY VALUES ('"+email+"', '"+ip+"', '"+history+"');";
		return execution(command);
		
	}
	
	public boolean set_trusted_ip_address(List<String> a) {
		 String email = a.get(0);
		 String session_token = a.get(1);
		 String ip = a.get(2);
		 boolean sol=set_trusted_ip(email,session_token,ip);
		 return sol;
		
	}
	
	public boolean getdata(List<String> a) {
	    String email = a.get(0);
	 
	    String ip = a.get(1);
	    
	        create();
	        long currentTimestamp = System.currentTimeMillis();

	        // Create a Date object using the timestamp
	        Date currentDate = new Date(currentTimestamp);

	        // Create a SimpleDateFormat object with the desired format
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	        // Format the Date object to get the timestamp as a string
	        String timestampString = dateFormat.format(currentDate);

	        boolean sol =insert_history(email,ip,timestampString);
	        return sol; // Return true if successful
	}
	
	




	public static void main (String[] args) {
		
		System.out.println("hi");
	}
}
