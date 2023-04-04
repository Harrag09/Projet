package com.oussama.pfe.web;

import com.oussama.pfe.entity.User;
import com.oussama.pfe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserRepository userRepository;


    @GetMapping
    public ResponseEntity<List<User>> hello(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostConstruct
    public void init(){
        User user = new User();
        user.setNom("Oussamma");
        user.setPrenom("Oussamma");
        user.setAdress("Oussamma");
        user.setEmail("Oussamma");
        user.setPassword("Oussamma");
        userRepository.save(user);
    }
}
