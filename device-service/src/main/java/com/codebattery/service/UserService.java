package com.codebattery.service;

import com.codebattery.domain.entity.Organization;
import com.codebattery.domain.model.LoginInfo;
import com.codebattery.domain.model.TokenInfo;
import com.codebattery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codebattery.domain.entity.User;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrganizationService organizationService;

    public LoginInfo login(Long id) {

        LoginInfo loginInfo = new LoginInfo();

        User user = userRepository.findById(id).get();

        loginInfo.setMember(user);

        TokenInfo tokenInfo = new TokenInfo(
                "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIiLCJhdWQiOiIiLCJpYXQiOjE1ODE3MDY2NTIsIm5iZiI6MTU4MTcwNjY1MiwiZGF0YSI6eyJjb2RlIjoiNnY3YmUxOXB3bWFuMmZpcmQwNGdxdTUzIn0sInNjb3BlcyI6ImFjY2VzcyIsImV4cCI6MTU4MjMxMTQ1Mn0.SH6bYDQ3uXKHyVUehR_J9yIwT74ktQUJ45RqIkJUnw4",
        "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIiLCJhdWQiOiIiLCJpYXQiOjE1ODE3MDY2NTIsIm5iZiI6MTU4MTcwNjY1MiwiZGF0YSI6eyJjb2RlIjoiNnY3YmUxOXB3bWFuMmZpcmQwNGdxdTUzIn0sInNjb3BlcyI6InJlZnJlc2giLCJleHAiOjE1ODIzMTE0NTJ9.8B4f-1Tm2AgYZFfhv-xCOYklX916WqbeJQGlPBDINQg",
        "bearer",
        1582311452L
        );

        loginInfo.setTokenList(tokenInfo);

        List<Organization> organizations = organizationService.listAll();
        loginInfo.setOrganizationList(organizations);

        return loginInfo;
    }
    
}
