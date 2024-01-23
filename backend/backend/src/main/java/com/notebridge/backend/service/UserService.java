package com.notebridge.backend.service;

import com.notebridge.backend.modal.User;

public interface UserService {
    void signUp(User user);
    boolean signIn(User user);
    void messages(User user);
}