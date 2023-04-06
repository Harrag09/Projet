package com.oussama.pfe.service;

import com.oussama.pfe.Exception.EmailNotExists;
import com.oussama.pfe.Exception.PasswordNotCorrect;
import com.oussama.pfe.Exception.UserAlreadyExists;
import com.oussama.pfe.UserRole;
import com.oussama.pfe.entity.User;
import com.oussama.pfe.models.SignInRequest;
import com.oussama.pfe.models.SignUpRequest;
import com.oussama.pfe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(SignUpRequest signUpRequest)  {
        if(existsByEmail(signUpRequest.getEmail())) {
            throw new UserAlreadyExists("A user with email " + signUpRequest.getEmail() + " already exists");
        }
        User user1 = new User();
        user1.setEmail(signUpRequest.getEmail());
        user1.setPassword(signUpRequest.getPassword());
        user1.setAddress(signUpRequest.getAddress());
        user1.setFirstName(signUpRequest.getFirstName());
        user1.setLastName(signUpRequest.getLastName());
        user1.setRole(UserRole.USER);
        return userRepository.save(user1);
    }
    public String login(SignInRequest  SignInRequest)  {

        User user = findByEmail( SignInRequest.getEmail());
        if(user == null) {
            throw new EmailNotExists("This email :" +  SignInRequest.getEmail() + " not exists");
        }
        if ((!passwordEncoder.matches(SignInRequest.getPassword(), user.getPassword())) == false) {

            throw new PasswordNotCorrect( SignInRequest.getPassword()+"Password  not Correct" + user.getPassword());
        }




return " ze" ;


    }



    public boolean existsByEmail(String email) {
        //;
        return userRepository.existsByEmail(email);
    }


    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
