package com.revature.Revamedia.dtos;

public class ResetPasswordDto {

    private String password;

    public ResetPasswordDto() {
    }

    public ResetPasswordDto(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
