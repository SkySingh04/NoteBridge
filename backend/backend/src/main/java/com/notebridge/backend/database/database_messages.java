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
	import java.util.Map;

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
		
		public void getmessages_by_user_id(String userprof) {
            Map<Integer, StringBuilder> conversations = new HashMap<>();
			boolean truth =false;
		    String url = "jdbc:mysql://localhost:3306/Notessharing";
		    String userDB = "root";
		    String pwdDB = "hariambika";

		    try (Connection connection = DriverManager.getConnection(url, userDB, pwdDB)) {
		        String query = "SELECT * FROM MESSAGES WHERE SENDER =? OR  RECEIVER=?";
		        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		            preparedStatement.setString(1, userprof);
		            preparedStatement.setString(2, userprof);

		            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                    while (resultSet.next()) {
	                        String messageId = resultSet.getString("MESSAGE_ID");
	                        String senderId = resultSet.getString("SENDER");
	                        String receiverId = resultSet.getString("RECEIVER");
	                        String messageText = resultSet.getString("message");

	                        // Determine the conversation key based on sender and receiver
	                        int conversationKey = (senderId.compareTo(receiverId) < 0)
	                                ? (senderId.hashCode() << 16 | receiverId.hashCode())
	                                : (receiverId.hashCode() << 16 | senderId.hashCode());

	                        // Append the message to the conversation
	                        conversations.computeIfAbsent(conversationKey, k -> new StringBuilder())
	                                .append(messageText)
	                                .append("\n");
	                    }
	                }
	            }

	            // Print the conversations
	            for (Map.Entry<Integer, StringBuilder> entry : conversations.entrySet()) {
	                int conversationKey = entry.getKey();
	                StringBuilder conversation = entry.getValue();

	                System.out.println("Conversation between users " +
	                        (conversationKey & 0xFFFF) + " and " +
	                        ((conversationKey >> 16) & 0xFFFF) + ":");
	                System.out.println(conversation.toString());
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		}
	}
