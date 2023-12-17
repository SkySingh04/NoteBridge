package com.notebridge.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.notebridge.backend.database.DatabaseConfig;
import com.notebridge.backend.modal.User;

@Service
public class UserServiceImpl implements UserService {

    // You might inject a UserRepository here to interact with a database
    // @Autowired
    // private UserRepository userRepository;


	 @Override
	    public boolean signUp(User user) {
	        // Simulating a database operation
	        try {
	            // Perform your database insertion logic here
	            // For example:
	            // userRepository.save(user);
	            // If there's an issue while adding to the database, throw an exception or return false
	            // throw new SomeDatabaseException("Failed to add user to the database");

	            // For testing, return false if there's an issue
	            System.out.println("Received user data for signUp:");
	            System.out.println("Email: " + user.getEmail());
	            System.out.println("Password: " + user.getPassword());
	            System.out.println("FirstName: " + user.getFirstName());
	            System.out.println("LastName: " + user.getLastName());
	            System.out.println("Role: " + user.getRole());

	            List<String> variableList = new ArrayList<>();
	            variableList.add(user.getFirstName());
	            variableList.add(user.getLastName());
	            variableList.add(user.getEmail());
	            variableList.add(user.getPassword());
	            variableList.add(user.getRole());

	            DatabaseConfig obj = new DatabaseConfig();
	            boolean success = obj.getdata(variableList);
	            System.out.println(success);
	            return success; // Return the success status based on database operation
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false; // Return false if an exception occurs during database operation
	        }
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
        
        return true;
    	
    }

	
}
