package com.codebattery.service;

import com.codebattery.domain.entity.Organization;
import com.codebattery.domain.entity.User;
import com.codebattery.domain.model.LoginInfo;
import com.codebattery.domain.model.TokenInfo;
import com.codebattery.repository.OrganizationRepository;
import com.codebattery.repository.UserRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    public List<Organization> listAll(){
        return Lists.newArrayList(organizationRepository.findAll());
    }
}
