package com.oussama.pfe.models;
import com.oussama.pfe.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Setter
@Getter
public class SignUpRequest {
    @Size(max = 20, message = "Email name must be less than or equal to 20 characters")
    @NotEmpty
    @Email(message = "Invalid email format")
    private String email;

    @NotEmpty
    @Size(min = 8, message = "Password must have at least 8 characters")
    private String password;
    @Size(max = 20, message = "Firstname must be less than or equal to 20 characters")
    @NotEmpty
    private String firstName;
    @Size(max = 20, message = "lastname must be less than or equal to 20 characters")
    @NotEmpty
    private String lastName;
    @Size(max = 20, message = "Address name must be less than or equal to 20 characters")
    @NotEmpty
    private String address;
    @NotEmpty
    private UserRole role ;


}
