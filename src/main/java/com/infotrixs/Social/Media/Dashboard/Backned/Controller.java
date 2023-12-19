package com.infotrixs.Social.Media.Dashboard.Backned;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders="*")

@RestController
public class Controller {
    @Autowired
    UserService service;

    //sign up
    @PostMapping("user/signup")
    public String Signup(@Valid @RequestBody User user){
        return service.signup(user);
    }

    @GetMapping("user")
    public List<User> getUser(){
        return service.getUser();
    }


}
