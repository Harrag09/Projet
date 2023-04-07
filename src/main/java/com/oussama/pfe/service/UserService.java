package com.oussama.pfe.service;

import com.oussama.pfe.Exception.EmailNotExists;
import com.oussama.pfe.Exception.PasswordNotCorrect;
import com.oussama.pfe.Exception.UserAlreadyExists;
import com.oussama.pfe.entity.User;
import com.oussama.pfe.mappers.UserMapper;
import com.oussama.pfe.models.SignInRequest;
import com.oussama.pfe.models.SignUpRequest;
import com.oussama.pfe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    private final UserMapper userMapper;

    public User register(SignUpRequest signUpRequest)  {
        if(existsByEmail(signUpRequest.getEmail())) {
            throw new UserAlreadyExists("A user with email " + signUpRequest.getEmail() + " already exists");
        }
        User user = userMapper.mapToUserEntity(signUpRequest);
        return userRepository.save(user);
    }



    public String login(SignInRequest  SignInRequest)  {

        User user = findByEmail( SignInRequest.getEmail());
        if(user == null) {
            throw new EmailNotExists("This email :" +  SignInRequest.getEmail() + " not exists");
        }
        if ((!passwordEncoder.matches(SignInRequest.getPassword(), user.getPassword())) == true) {

            throw new PasswordNotCorrect( SignInRequest.getPassword()+"Password  not Correct" + user.getPassword());
        }
        //mafhemtesh :3 :(
return " ze" ;
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
