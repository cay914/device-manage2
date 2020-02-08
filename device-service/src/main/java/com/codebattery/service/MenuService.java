package com.codebattery.service;

import com.codebattery.model.Member;
import com.codebattery.model.Menu;
import com.codebattery.repository.MemberRepository;
import com.codebattery.repository.MenuRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    /**
     * 查询菜单
     *
     * @return
     *
     * @author Eric
     * @date 2020-02-09
     */
    public List<Menu> queryAllMenus() {

        Iterable<Menu> all = menuRepository.findAll();

        List<Menu> menusList = Lists.newArrayList(all);

        return menusList;
    }
    
}
