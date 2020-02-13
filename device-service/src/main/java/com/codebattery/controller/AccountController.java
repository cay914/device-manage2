package com.codebattery.controller;


import com.codebattery.model.AccountInfo;
import com.codebattery.service.AccountService;
import com.codebattery.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("账户接口")
@RestController
@RequestMapping(value="account")
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @ApiOperation(value="获取所有账户信息",notes="")
    @RequestMapping(value="",method = RequestMethod.POST)
    @ResponseBody
    public List<AccountInfo> listAll() {
        logger.debug("获取所有账户信息");


        return null;
    }

}
