package com.notebridge.backend.service;

import com.notebridge.backend.modal.User;

public interface UserService {
    boolean signUp(User user);
    boolean signIn(User user);
    void messages(User user);
}