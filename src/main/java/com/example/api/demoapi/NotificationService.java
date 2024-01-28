package com.example.api.demoapi;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    public void notifyUserAdded(User user) {
        System.out.println("User " + user.getName() + " has been added. Notification sent.");
    }
}
