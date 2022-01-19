package com.thuexcursion.crud.payload;

import javax.validation.constraints.NotBlank;

/**
 * LoginRequest class - one of the response payloads for SpringController
 * 
 */
public class LoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

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
}
