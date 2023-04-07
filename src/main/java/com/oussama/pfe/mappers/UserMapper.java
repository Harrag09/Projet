package com.oussama.pfe.mappers;


import com.oussama.pfe.entity.User;
import com.oussama.pfe.models.SignUpRequest;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Mapper(componentModel = "spring")
public interface UserMapper {
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Mapping(target = "password", source = "password")
    User mapToUserEntity(SignUpRequest SignUpRequest);
    @AfterMapping
    default void encodePassword(@MappingTarget User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

    }
}