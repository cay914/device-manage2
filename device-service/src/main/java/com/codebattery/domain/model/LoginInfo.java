package com.codebattery.domain.model;

import com.codebattery.domain.entity.Organization;
import com.codebattery.domain.entity.User;

import java.util.List;

public class LoginInfo {
    private User member;
    private TokenInfo tokenList;
    private List<Organization> organizationList;

    public User getMember() {
        return member;
    }

    public void setMember(User member) {
        this.member = member;
    }

    public TokenInfo getTokenList() {
        return tokenList;
    }

    public void setTokenList(TokenInfo tokenList) {
        this.tokenList = tokenList;
    }

    public List<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(List<Organization> organizationList) {
        this.organizationList = organizationList;
    }
}
