package com.oussama.pfe.models;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Setter
@Getter
public class SignInRequest {
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must have at least 8 characters")
    private String password;


    public SignInRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }


}
