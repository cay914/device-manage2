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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @RequestMapping(value="/test-string",method = RequestMethod.POST)
    @ResponseBody
    public String testString() {


        return "123";
    }

    @RequestMapping(value="/test-Integer",method = RequestMethod.POST)
    @ResponseBody
    public Integer testInteger() {


        return 1;
    }

    @RequestMapping(value="/test-emptylist",method = RequestMethod.POST)
    @ResponseBody
    public List testEmptylist() {

        List<String> list = new ArrayList<>();

        return list;
    }

    @RequestMapping(value="/test-emptyobject",method = RequestMethod.POST)
    @ResponseBody
    public Map testEmptyObject() {

        Map m = new HashMap();

        return m;
    }

}
