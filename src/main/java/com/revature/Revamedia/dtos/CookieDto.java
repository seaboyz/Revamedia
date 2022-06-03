/**
 * Author(s): @George Henderson
 * Contributor(s):
 * Purpose: Dto containing data passed about the user cookie.
 */
package com.revature.Revamedia.dtos;

import com.revature.Revamedia.entities.User;

public class CookieDto {

    private Integer userId;
    private String username;


    public CookieDto() {
    }

    public CookieDto(User user) {
        this.username = user.getUsername();
        this.userId = user.getUserId();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
