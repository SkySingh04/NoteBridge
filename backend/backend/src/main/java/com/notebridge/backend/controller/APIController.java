package com.notebridge.backend.controller; 
  
import java.util.ArrayList; 
import java.util.HashSet; 
  
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
    @CrossOrigin(origins = "http://localhost:3001")
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
    @CrossOrigin(origins = "http://localhost:3001")
    public ResponseEntity<String> signIn(@RequestBody User user) {
        // Implement logic to authenticate the user
        boolean isSignInSuccessful = userService.signIn(user);

        if (isSignInSuccessful) {
            return ResponseEntity.ok("User signed in successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }

    // Other methods...

}

	
	
	
//    @Autowired
//    BookServiceImpl bookServiceImpl; 
  
//    @PostMapping("/") 
//    public void addBook(@RequestBody Book book) { 
//        bookServiceImpl.addBook(book); 
//    } 
//  
//    @GetMapping("/findall") 
//    public HashSet<Book> getAllBook() { 
//        return bookServiceImpl.findAllBook(); 
//    } 
//  
//    @GetMapping("/findbyid/{id}") 
//    public Book geBookById(@PathVariable long id) { 
//        return bookServiceImpl.findBookByID(id); 
//    } 
//  
//    @DeleteMapping("/delete") 
//    public void deleteBook() { 
//        bookServiceImpl.deleteAllData(); 
//    } 
	
  