package com.techelevator.controller;

import javax.validation.Valid;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.authentication.JwtTokenHandler;
import com.techelevator.authentication.UnauthorizedException;
import com.techelevator.authentication.UserCreationException;
import com.techelevator.model.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * AccountController
 */
@RestController
@RequestMapping("/api/clubsports")
@CrossOrigin
public class AccountController {
    @Autowired
    private AuthProvider auth;

    @Autowired
    private JwtTokenHandler tokenHandler;

    @PostMapping("/login")
    public String login(@RequestBody User user, RedirectAttributes flash) throws UnauthorizedException {
        if (auth.signIn(user.getUsername(), user.getPassword())) {
            User currentUser = auth.getCurrentUser();
            return tokenHandler.createToken(user.getUsername(), currentUser.getRole());
        } else {
            throw new UnauthorizedException();
        }
    }

//    @PostMapping("/register")
//    public String register(@Valid @RequestBody User user, BindingResult result) throws UserCreationException {
//        if (result.hasErrors()) {
//            String errorMessages = "";
//            for (ObjectError error : result.getAllErrors()) {
//                errorMessages += error.getDefaultMessage() + "\n";
//            }
//            throw new UserCreationException(errorMessages);
//        }
//        auth.register(user.getUsername(), user.getPassword(), user.getRole());
//        return "{\"success\":true}";
//    }
    
    @PostMapping("/register")
    public String register(@Valid @RequestBody User user, BindingResult result) throws UserCreationException {
        if (result.hasErrors()) {
            String errorMessages = "";
            for (ObjectError error : result.getAllErrors()) {
                errorMessages += error.getDefaultMessage() + "\n";
            }
            throw new UserCreationException(errorMessages);
        }
        auth.register(user);
        return "{\"success\":true}";
    }

}