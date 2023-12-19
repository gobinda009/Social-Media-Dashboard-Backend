package com.infotrixs.Social.Media.Dashboard.Backned;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    IRepo iRepo;

    public String signup(User user) {
        //Method for signup by new user
        String newEmail = user.getEmail();
        User existUser = iRepo.findFirstByEmail(newEmail);   // check whether user has already existed or not in repository
        if (existUser != null) {                                    // if user has already sign up than unable to signup again
            return "User already Exist";
        }

        // Encrypt the password and save in the table
        String newPassword = user.getPassword();

        try {
            String encryptedPassword = PasswordEncrpytor.encryptPassword(newPassword);   //getting encrypted password
            user.setPassword(encryptedPassword);                                    // set encrypted password
            iRepo.save(user);                                                       // save user details by repo in mysql
            return "user registered";
        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }

    }

    public List<User> getUser() {
        return iRepo.findAll();
    }
}
