package com.oussama.pfe.models;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
@Setter
@Getter
public class SignUpRequest {

    @Size(max = 20, message = "Email name must be less than or equal to 20 characters")
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must have at least 8 characters")
    private String password;
    @Size(max = 20, message = "Firstname must be less than or equal to 20 characters")
    @NotBlank(message = "firstName cannot be blank")
    private String firstName;
    @Size(max = 20, message = "lastname must be less than or equal to 20 characters")
    @NotBlank(message = "lastName cannot be blank")
    private String lastName;
    @Size(max = 20, message = "Address name must be less than or equal to 20 characters")
    @NotBlank(message = "address cannot be blank")
    private String address;

    //TODO: Don't add this constructor
    public SignUpRequest(String email, String password, String firstName, String lastName, String address) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
}
