package com.oussama.pfe.boostrap;

import com.oussama.pfe.entity.User;
import com.oussama.pfe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "DATABASE BOOTSTRAP")
@Profile("initialize-database")
@RequiredArgsConstructor
public class DatabaseBootstrap implements CommandLineRunner {
    private final UserRepository userRepository;

    @Override
    public void run(String... args) {
        log.error("Database bootstrap started");
        User user = new User();
        user.setFirstName("admin");
        user.setLastName("admin");
        user.setEmail("admin.pfe.oussama@yopmail.com");
        user.setPassword("root");
        user.setAddress("Tunis");
        userRepository.save(user);
        log.warn("Admin user created");
        log.info("Database bootstrap finished");
    }
}
