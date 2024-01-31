package com.example.api.demoapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }


    @RequestMapping(
            method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestParam String name, @RequestParam int age, @RequestParam String email) {
        return new ResponseEntity<>(userService.createUser(name, age, email), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

}
