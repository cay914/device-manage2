package com.codebattery.domain.model;

public class TokenInfo {
    private String accessToken;
    private String refreshToken;
    private String tokenType;
    private Long accessTokenExp;

    public TokenInfo() {
    }

    public TokenInfo(String accessToken, String refreshToken, String tokenType, Long accessTokenExp) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.tokenType = tokenType;
        this.accessTokenExp = accessTokenExp;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Long getAccessTokenExp() {
        return accessTokenExp;
    }

    public void setAccessTokenExp(Long accessTokenExp) {
        this.accessTokenExp = accessTokenExp;
    }
}
