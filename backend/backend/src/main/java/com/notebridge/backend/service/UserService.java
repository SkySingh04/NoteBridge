package com.notebridge.backend.service;

import java.util.List;

import com.notebridge.backend.modal.Trusted_user_ip;
import com.notebridge.backend.modal.User;

public interface UserService {
    boolean signUp(User user);
    boolean signIn(User user);
    void messages(User user);
	List<Trusted_user_ip> getAllIpAddressInfo();
    
}