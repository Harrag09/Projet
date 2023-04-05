package com.oussama.pfe.web;


import com.oussama.pfe.entity.User;

import com.oussama.pfe.models.SignInRequest;
import com.oussama.pfe.models.SignUpRequest;
import com.oussama.pfe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
        if(userService.existsByEmail(signUpRequest.getEmail())) {
            System.out.println("User with email already exists");

           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User with this email already exists ");
        }

            User user = new User();
            user.setEmail(signUpRequest.getEmail());
            user.setPassword(signUpRequest.getPassword());
            user.setAddress(signUpRequest.getAddress());
            user.setFirstName(signUpRequest.getFirstName());
            user.setLastName(signUpRequest.getLastName());
            userService.save(user);

            System.out.println("success Add");

        return   ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("success Add");
    }
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody SignInRequest signInRequest) {
        // Retrieve user from database
        User user = userService.findByEmail(signInRequest.getEmail());
        if (user == null) {
            System.out.println("Invalid email");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email ");
        }

        // Check if password matches
        if (!signInRequest.getPassword().equals(user.getPassword())) {
            System.out.println("Invalid password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
        }

        // Return successful response
        return ResponseEntity.ok("Login successful");
    }

}
