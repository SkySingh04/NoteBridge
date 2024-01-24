package com.notebridge.backend.controller; 

import com.notebridge.backend.modal.Trusted_user_ip;

import java.sql.SQLException;
import java.util.ArrayList; 
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RestController;

import com.notebridge.backend.modal.User;
import com.notebridge.backend.service.UserService; 
import org.springframework.web.bind.annotation.*;

//import com.example.demo.modal.Book; 
//  
//import com.example.demo.service.BookServiceImpl; 
  
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class APIController {

    @Autowired
    private UserService userService;

    // Other mappings...

    @PostMapping("/signup")
    @CrossOrigin(origins = "http://localhost:3002")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        // Implement logic to register a new user
        boolean isSignUpSuccessful = userService.signUp(user);

        if (isSignUpSuccessful) {
            return ResponseEntity.status(HttpStatus.CREATED).body("User signed up successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to sign up user");
        }
    }

    @PostMapping("/signin")
    @CrossOrigin(origins = "http://localhost:3002")
    public ResponseEntity<String> signIn(@RequestBody User user) {
        // Implement logic to authenticate the user
        boolean isSignInSuccessful = userService.signIn(user);

        if (isSignInSuccessful) {
            return ResponseEntity.ok("User signed in successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }


    @GetMapping("/info")
    @CrossOrigin(origins = "http://localhost:3002")
    public List<List<String>> getIpAddressInfo() {
        // Call the method in userService to retrieve all IP address information
        List<List<String>> ipAddressInfoList = userService.getAllIpAddressInfo();
        
        
       

        return ipAddressInfoList;
    }
    
    @PostMapping("/get_contacts")
    @CrossOrigin(origins = "http://localhost:3002")
    public ResponseEntity<List<List<String>>> getContacts(@RequestBody User user) {
        try {
            List<List<String>> contacts = userService.get_contacts(user);
            return ResponseEntity.ok(contacts);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @PostMapping("/get_messages")
    @CrossOrigin(origins = "http://localhost:3002")
    public ResponseEntity<List<List<String>>> getMessages(@RequestBody User user) {
        // Validate user object (add more validation as needed)
        if (user == null || user.getEmail() == null || user.getEmail().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        try {
            // Call the method in userService to retrieve messages
            List<List<String>> messages = userService.getmessages_user(user, user.getEmail());

            // Return the messages in the response
            return ResponseEntity.ok(messages);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
}

	
	
