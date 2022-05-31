package com.revature.Revamedia.dtos;

import org.springframework.stereotype.Component;

import javax.validation.constraints.*;

@Component
public class UserRegisterDto {

    @NotNull
    @Size(min = 2, max = 255, message = "username should be between 2 and 255 characters")
    private String username;
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
             message = "Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character")
    private String password;
    @NotEmpty
    @Pattern(regexp = "\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+", message = "First name should consist of letters only")
    private String firstName;
    @NotEmpty
    @Pattern(regexp = "\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+", message = "Last name should consist of letters only")
    private String lastName;
    @NotEmpty @Email
    private String email;

    public UserRegisterDto() {
    }

    public UserRegisterDto(String username, String password, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserRegisterDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
