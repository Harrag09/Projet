package com.oussama.pfe.service;

import com.oussama.pfe.entity.User;
import com.oussama.pfe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }


    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
