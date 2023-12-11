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

    // For the example, let's use a simple in-memory list to manage users
    private List<User> users = new ArrayList<>();

    @Override
    public void signUp(User user) {
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
