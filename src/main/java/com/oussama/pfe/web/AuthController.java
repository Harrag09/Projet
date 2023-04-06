package com.oussama.pfe.web;



import com.oussama.pfe.entity.User;

import com.oussama.pfe.models.SignInRequest;
import com.oussama.pfe.models.SignUpRequest;
import com.oussama.pfe.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Void> registerUser(@RequestBody SignUpRequest signUpRequest) {
        userService.register(signUpRequest);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody  SignInRequest SignInRequest) {
        // Retrieve user from database
     userService.login(SignInRequest);

        // Return successful response
        return ResponseEntity.ok("  ");
    }

}
