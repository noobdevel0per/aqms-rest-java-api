package com.aqms.app.rest.Models;

public class jwtResponse {

    String Token;

    public jwtResponse(){

    }

    public jwtResponse(String token) {
        Token = token;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
