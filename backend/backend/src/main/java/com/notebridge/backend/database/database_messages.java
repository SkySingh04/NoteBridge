package com.notebridge.backend.database;


	import java.util.ArrayList;
	import java.util.List;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
	import java.util.Set;

//	import com.notebridge.backend.modal.User;

	public class database_messages{
		
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
			comm="CREATE TABLE IF NOT EXISTS MESSAGES(MESSAGE_ID INT PRIMARY KEY AUTO_INCREMENT,SENDER  VARCHAR(50) NOT NULL,RECEIVER VARCHAR(50) NOT NULL,TIME VARCHAR(30) NOT NULL,MESSAGE TEXT NOT NULL, LINK TEXT,SENDER_IP VARCHAR(20) NOT NULL);";
			execution(comm);
			
		}
		public static boolean insertvalues(String a,String b,String c, String d,String e,String f) {
			String sender=a;
			String receiver=b;
			String time=c;
			String message =d;
			String link =e;
			String sender_ip=f;
			String command ="INSERT INTO MESSAGES(SENDER,RECEIVER,TIME,MESSAGE,LINK,SENDER_IP) VALUES ('"+a+"', '"+b+"', '"+time+"', '"+message+"', '"+link+"','"+sender_ip+"');";
			return execution(command);
			
		}
		
		public boolean getdata(List<String> a) {
		    String sender = a.get(0);
		    String receiver = a.get(1);
		    String time = a.get(2);
		    String message = a.get(3);
		    String link = a.get(4);
		    String sender_ip=a.get(5);
		        create();
		        boolean sol = insertvalues(sender,receiver,time,message,link,sender_ip);
		        return sol; // Return true if successful
		}
		
		public static String get_name(String a) throws SQLException {
			String email=a;
			String url = "jdbc:mysql://localhost:3306/Notessharing";
		    String userDB = "root";
		    String pwdDB = "hariambika";
		    List<List<String>> output;
		    try (Connection connection = DriverManager.getConnection(url, userDB, pwdDB)) {
		        String query = "SELECT CONCAT(FNAME,' ',LNAME) FROM MEMBERS WHERE EMAIL =?";
		        String value1="";
		        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		            preparedStatement.setString(1, email);
		            
		                  try( ResultSet resultSet = preparedStatement.executeQuery()) {

		                   // Check if there is a result
		                   if (resultSet.next()) {
		                       // Get the value from the result set
		                       String value = resultSet.getString("concat(fname,' ',lname)"); // Replace "your_column" with your actual column name

				                  value1=value;
		                   }

		               } catch (SQLException e) {
		                   e.printStackTrace();
		               }
		                 
		            return value1;
		            

			
		}}}
		
		public static List<List<String>>  getmessages_by_user_id(String userprof,String receiver) throws SQLException {
//            Map<Integer, StringBuilder> conversations = new HashMap<>();
			List<List<String>> finallist = new ArrayList<>();
			boolean truth =false;
		    String url = "jdbc:mysql://localhost:3306/Notessharing";
		    String userDB = "root";
		    String pwdDB = "hariambika";

		    try (Connection connection = DriverManager.getConnection(url, userDB, pwdDB)) {
		        String query = "SELECT * FROM MESSAGES WHERE (SENDER =? AND RECEIVER=?) OR  (SENDER=? AND RECEIVER=?) ORDER BY TIME";
		        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		            preparedStatement.setString(1, userprof);
		            preparedStatement.setString(2, receiver);
		            preparedStatement.setString(3, receiver);
		            preparedStatement.setString(4, userprof);
		            
		            

		            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                    while (resultSet.next()) {
	                    	
	                    	List<String> datalist=new ArrayList<>();
	                        String messageId = resultSet.getString("MESSAGE_ID");
	                        String senderId = resultSet.getString("SENDER");
	                        String receiverId = resultSet.getString("RECEIVER");
	                        String messageText = resultSet.getString("message");
	                        String link=resultSet.getString("LINK");
	                        String time=resultSet.getString("TIME");
	                        String ip=resultSet.getString("SENDER_IP");
	                        datalist.add(messageId);
	                        datalist.add(messageText);
	                        datalist.add(senderId);
	                        datalist.add(receiverId);
	                        datalist.add(time);
	                        datalist.add(link);
	                        datalist.add(ip);
	                        finallist.add(datalist);
	                        
	                        

	                        // Determine the conversation key based on sender and receiver
	                       
	                    }
	                }
	            }
		        
	            // Print the conversations
		
		}
	
		return finallist;}
	public static List<List<String>> get_contacts(String userprof) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/Notessharing";
	    String userDB = "root";
	    String pwdDB = "hariambika";
	    
	    List<List<String>> finallist = new ArrayList<>();
	    List<String> datalist=new ArrayList<>();
		Set<String> stringSet = new HashSet<>();
		
	    try (Connection connection = DriverManager.getConnection(url, userDB, pwdDB)) {
	        String query = "SELECT * FROM MESSAGES WHERE SENDER =? OR  RECEIVER=?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, userprof);
	            preparedStatement.setString(2, userprof);

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                    	
                     
                        String senderId = resultSet.getString("SENDER");
                        String receiverId = resultSet.getString("RECEIVER");
                        datalist.add(receiverId);
                        datalist.add(senderId);
                    }
                        
                        Set<String> stringSet1 = new HashSet<>(datalist);
                        stringSet1.remove(userprof);
                       
                        
                        //return stringSet1;
                        for (String element : stringSet1) {
                        	List<String> datalist1=new ArrayList<>();
                            datalist1.add(element);
                            datalist1.add(get_name(element));
                            
                            finallist.add(datalist1);
                        }
                        return finallist;
                        // Determine the conversation key based on sender and receiver
                       
                    
                }
            }
	        
            // Print the conversations
	
	}
	    
	    
	
	
	}
		
	public static void main(String args[]) throws SQLException {
		System.out.println(getmessages_by_user_id("john_doe","adsfaqwerqewt123"));
		
	}
	}
