/**
 * Author(s): @George Henderson
 * Contributor(s):
 * Purpose: Dto containing data passed about the user cookie.
 */
package com.revature.Revamedia.dtos;

import com.revature.Revamedia.entities.User;

public class CookieDto {

    private Integer userId;
    private String firstName;
    private String lastName;

    public CookieDto() {
    }

    public CookieDto(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.userId = user.getUserId();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}
