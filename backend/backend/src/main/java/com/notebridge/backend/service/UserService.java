package com.notebridge.backend.service;

import java.sql.SQLException;
import java.util.List;

import com.notebridge.backend.modal.Trusted_user_ip;
import com.notebridge.backend.modal.User;

public interface UserService {
    boolean signUp(User user);
    boolean signIn(User user);
    List<List<String>> get_contacts(User user) throws SQLException;
    List<List<String>> getmessages_user(User user,String a) throws SQLException;
    boolean send_message(User user,String a,String b,String c);
    
	List<List<String>> getAllIpAddressInfo();
    
}