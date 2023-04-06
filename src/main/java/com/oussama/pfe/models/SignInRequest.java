package com.oussama.pfe.models;
import com.oussama.pfe.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Setter
@Getter
public class SignInRequest {
    @NotEmpty
    @Email(message = "Invalid email format")
    private String email;

    @NotEmpty
    @Size(min = 8, message = "Password must have at least 8 characters")
    private String password;
    private UserRole role ;

    //TODO: Don't add this constructor : Sbn


}
