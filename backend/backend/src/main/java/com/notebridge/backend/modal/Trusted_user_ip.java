package com.notebridge.backend.modal;

public class Trusted_user_ip {
	

    private String email;
    private String session_token;
    private String ip;

    // Constructors (if needed)
    public Trusted_user_ip() {
        // Default constructor
    }

    public Trusted_user_ip( String email, String session_token, String ip) {
        
        this.email = email;
        this.session_token = session_token;
        this.ip= ip;
    }

    // Getters and setters for User properties
    public String getSessionToken() {
        return session_token;
    }

    public void setSessionToken(String session_token) {
        this.session_token = session_token;
    }

    public String getip() {
        return ip;
    }

    public void setip(String ip) {
        this.ip = ip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

}
