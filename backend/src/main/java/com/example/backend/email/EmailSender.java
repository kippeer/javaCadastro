package com.example.backend.email;

public interface EmailSender {
    void send(String to, String email);
}