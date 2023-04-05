package com.oussama.pfe.service;

import com.oussama.pfe.entity.User;
import com.oussama.pfe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //TODO: Do not use @Autowired on fields, use constructor injection instead do the same for all other services,
    //TODO: take a look at the constructor injection in the DatabaseBootstrap class
    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean existsByEmail(String email) {
        //passwordEncoder.matches("raw password", "encdoded password");
        return userRepository.existsByEmail(email);
    }


    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
