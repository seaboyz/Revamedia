package com.revature.Revamedia.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UpdateUserDto {

    @NotEmpty(message = "Username can't be empty")
    @Size(min = 2, max = 255, message = "Username should be between 2 and 255 characters")
    private String username;
    private String profilePicture;
    @NotEmpty(message = "First name can't be empty")
    @Pattern(regexp = "([a-zA-ZÀ-ÿ][-,a-z. ']+[ ]*)+", message = "First name should consist of letters only and be a minimum of 2 characters")
    private String firstName;
    @NotEmpty(message = "Last name can't be empty")
    @Pattern(regexp = "([a-zA-ZÀ-ÿ][-,a-z. ']+[ ]*)+", message = "Last name should consist of letters only and be a minimum of 2 characters")
    private String lastName;
    @NotEmpty(message = "Email can't be empty")
    @Email(message = "Not a valid email")
    private String email;

    @NotEmpty(message = "Password can't be empty")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character")
    private String password;

    public UpdateUserDto() {
    }

    public UpdateUserDto(String username, String profilePicture, String firstName, String lastName, String email, String password) {
        this.username = username;
        this.profilePicture = profilePicture;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
