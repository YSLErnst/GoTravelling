package com.hand.ysl.dto;

/**
 * Created by Ernst on 2017/12/5.
 */
public class TokenTransfer {

    private String token;

    public TokenTransfer(String token)
    {
        this.token = token;
    }

    public String getToken()
    {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
