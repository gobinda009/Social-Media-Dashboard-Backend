package com.infotrixs.Social.Media.Dashboard.Backned;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    UserService service;

    //sign up
    @PostMapping("user/signup")
    public String Signup(@Valid @RequestBody User user){
        return service.signup(user);
    }
}
