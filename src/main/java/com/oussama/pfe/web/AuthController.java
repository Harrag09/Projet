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

import javax.validation.Valid;


@RestController
@RequestMapping("/auth")
public class AuthController {
    //TODO: Do not use @Autowired on fields, use constructor injection instead do the same for all other services,
    //TODO: take a look at the constructor injection in the DatabaseBootstrap class
    @Autowired
    private UserService userService;

    /**
     * Move business logic to the service layer
     */

    //TODO: Use @Valid annotation on the request body
    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userService.existsByEmail(signUpRequest.getEmail())) {
            //TODO: use logger instead of System.out.println take a look at DatabaseBootstrap class
            // use @Slf4j(topic = "") annotation on the class
            System.out.println("User with email already exists");

           return ResponseEntity.ok("User with email already exists");
        }

            User user = new User();
            user.setEmail(signUpRequest.getEmail());
            user.setPassword(signUpRequest.getPassword());
            user.setAddress(signUpRequest.getAddress());
            user.setFirstName(signUpRequest.getFirstName());
            user.setLastName(signUpRequest.getLastName());
            userService.register(user);

            System.out.println("success Add");
        //TODO: do not set status manually, use ResponseEntity.ok() instead
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("success Add");
    }
    //Do not use wildcard in return type, use ResponseEntity<String> instead
    //Move all the logic the the service layer
    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody SignInRequest signInRequest) {
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
