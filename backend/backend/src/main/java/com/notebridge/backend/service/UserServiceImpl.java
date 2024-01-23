package com.notebridge.backend.service;

import java.net.UnknownHostException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;

import com.notebridge.backend.database.DatabaseConfig;
import com.notebridge.backend.database.databaseforsignin;
import com.notebridge.backend.database.database_messages;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.notebridge.backend.modal.User;
import java.io.*;
import java.net.*;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    // You might inject a UserRepository here to interact with a database
    // @Autowired
    // private UserRepository userRepository;

    // For the example, let's use a simple in-memory list to manage users
    private List<User> users = new ArrayList<>();
    
    public String random(){
    	final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    	 Random random = new Random();
         StringBuilder stringBuilder = new StringBuilder();

         for (int i = 0; i < 10; i++) {
             int randomIndex = random.nextInt(CHARACTERS.length());
             char randomChar = CHARACTERS.charAt(randomIndex);
             stringBuilder.append(randomChar);
         }

         return stringBuilder.toString();
    }
    
    public String get_ip() throws UnknownHostException{
    	InetAddress address1=InetAddress.getLocalHost();
    	String address1str=address1.getHostAddress();
    	return address1str;
    	
    	
    	
    	
    }

    @Override
    
    
    public boolean signUp(User user) {
        // Implement logic to save the user to the database or in-memory list
//        users.add(user); Uncomment this
        // userRepository.save(user); // If using a repository
    //For testing
    	System.out.println("Received user data for signUp:");
        System.out.println("Email: " + user.getEmail());
        System.out.println("Password: " + user.getPassword());
        System.out.println("FirstName: " + user.getFirstName());
        System.out.println("LastName: " + user.getLastName());
        System.out.println("Role: " + user.getRole());
        	List<String> variableList= new ArrayList<>();
        	variableList.add(user.getFirstName());
        	variableList.add(user.getLastName());
        	variableList.add(user.getEmail());
        	variableList.add(user.getPassword());
        	variableList.add(user.getRole());
        	
        	DatabaseConfig obj= new DatabaseConfig();
        	obj.getdata(variableList);
        return true;
        	
        }
    	
  
    

    @Override
    public boolean signIn(User user) {
    	
        // Implement logic to authenticate the user from the database or in-memory list
//        return users.stream()
//                .anyMatch(u -> u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword())); Uncomment this
        // For database-based authentication, use userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword())
    	System.out.println("Received user data for signIn:");
        System.out.println("Username: " + user.getEmail());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Role: " + user.getRole());
        DatabaseConfig obj =new DatabaseConfig();
        boolean a=obj.getUserByEmailAndPassword(user.getEmail(),user.getPassword());
         if (a==true){
        	System.out.println("Authenticated!!!!");
        	databaseforsignin obj1= new databaseforsignin();
        	boolean b=obj1.check_trusted_ip(user.getEmail());
        	obj1.create();
        	if(b==true) {
        		System.out.println("Found an existing trusted IP address");
        		
        		List<String> variableList= new ArrayList<>();
            	variableList.add(user.getEmail());
            	try {
					variableList.add(get_ip());
					databaseforsignin obj2 =new databaseforsignin();
					obj2.getdata(variableList);
					return true;
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					
					
					e.printStackTrace();
				}
            	     		
        		
        		
        	}
        	else {
        		System.out.println("Didnt find an existing trusted IP address, This ip address is considered as your trusted!!");
        		List<String> variableList= new ArrayList<>();
        		List<String> variableList1= new ArrayList<>();
            	variableList.add(user.getEmail());
            	variableList1.add(user.getEmail());
            	variableList.add(random());
            	try {
					variableList.add(get_ip());
					variableList1.add(get_ip());
					System.out.println("Setting trusted IP address");
					databaseforsignin obj2 =new databaseforsignin();
					obj2.set_trusted_ip_address(variableList);
					obj2.getdata(variableList1);
					return true;
					
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					System.out.println("Ip address couldnt be accessed!!");
					e.printStackTrace();
					return false;
				}
            	
            	
            	
            	
        		
        	}
        	
        }
        else {
        	System.out.println("Authentication failed!!!");
        	return false;
        	
        }
		return true;
		
        
    }
   
    @Override
    public void messages(User user) {
    	String userprof=user.getEmail();
    	String recieverid;
    	String message;
    	String link;
    	long currentTimestamp = System.currentTimeMillis();

        // Create a Date object using the timestamp
        Date currentDate = new Date(currentTimestamp);

        // Create a SimpleDateFormat object with the desired format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        // Format the Date object to get the timestamp as a string
        String timestampString = dateFormat.format(currentDate);
        System.out.println(timestampString);
    	database_messages obj3=new database_messages();
    	obj3.create();
    	obj3.getmessages_by_user_id(userprof);
    	try {
			obj3.insertvalues(userprof,recieverid,timestampString,message,link,get_ip());
			System.out.println("Message sent successfully!!");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    public static void main(String args[]) {
    	User user=new User();
    	UserServiceImpl obj1=new UserServiceImpl();
    	obj1.messages(user);
    
    }

	
}





