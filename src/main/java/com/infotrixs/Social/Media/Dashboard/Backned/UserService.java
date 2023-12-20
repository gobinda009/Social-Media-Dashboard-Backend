package com.infotrixs.Social.Media.Dashboard.Backned;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    IRepo iRepo;

    @Autowired
    ITokenService tokenService;

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

    public boolean userLogin(SignInputDto signInputDto) {
        String email = signInputDto.getEmail();
        User existingUser = iRepo.findFirstByEmail(email);
        if (existingUser == null) {
            return false;
        }
        //password should be matched
        String password = signInputDto.getPassword();
        try {
            String encryptedPassword = PasswordEncrpytor.encryptPassword(password);

            if (existingUser.getPassword().equals(encryptedPassword)) {
                // return a token for this sign in
                UserAuthenticationToken token = new UserAuthenticationToken(existingUser);
                tokenService.createToken(token);
                return true;
            } else {
                //password was wrong!!!
                return false;
            }

        } catch (NoSuchAlgorithmException e) {

            return false;
        }
    }
}
