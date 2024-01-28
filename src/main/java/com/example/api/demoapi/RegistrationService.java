package com.example.api.demoapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final UserService userService;
    private final DataProcessingService dataProcessingService;
    private final NotificationService notificationService;

    @Autowired
    public RegistrationService(UserService userService, DataProcessingService dataProcessingService, NotificationService notificationService) {
        this.userService = userService;
        this.dataProcessingService = dataProcessingService;
        this.notificationService = notificationService;
    }

    public void registerUser(String name, int age, String email) {
        // Создаем пользователя с использованием UserService
        User newUser = userService.createUser(name, age, email);

        // Добавляем пользователя в список и выполняем операции над списком с использованием DataProcessingService
        // (Здесь предполагается, что у DataProcessingService есть метод для добавления пользователя в список)
        dataProcessingService.addUserToList(newUser);

        // Выводим информацию о добавлении пользователя с использованием NotificationService
        notificationService.notifyUserAdded(newUser);
    }
}
