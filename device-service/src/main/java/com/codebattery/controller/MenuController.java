package com.codebattery.controller;


import com.codebattery.model.Member;
import com.codebattery.model.Menu;
import com.codebattery.service.MenuService;
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

@Api("菜单接口")
@RestController
@RequestMapping(value="menu")
public class MenuController {

    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;

    @ApiOperation(value="获取全部菜单列表",notes="获取菜单列表")
    @RequestMapping(value="all-menus",method = RequestMethod.POST)
    @ResponseBody
    public List<Menu> listAll() {
        logger.debug("获取全部菜菜");

        List<Menu> menus = menuService.queryAllMenus();

        return menus;
    }


}
