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
  
//import com.example.demo.modal.Book; 
//  
//import com.example.demo.service.BookServiceImpl; 
  
@RestController
public class APIController { 
  
	@Autowired
    private UserService userService; // Inject UserService

    // Other mappings...

    @PostMapping("/signup")
    public void signUp(@RequestBody User user) {
        // Implement logic to register a new user
        userService.signUp(user);
    }

    @PostMapping("/signin")
    public void signIn(@RequestBody User user) {
        // Implement logic to authenticate the user
        userService.signIn(user);
    }
    
	@GetMapping("/")
	public String  hello() {
		return "Hello World";
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
	
  
}