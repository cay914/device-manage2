package com.codebattery.service;

import com.codebattery.domain.entity.Menu;
import com.codebattery.domain.model.MenuInfo;
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
    public List<MenuInfo> queryAllMenus() {

        List<MenuInfo> menuInfos = menuRepository.queryAllMenus();

        return createMenuTree(menuInfos);
    }

    private List<MenuInfo> createMenuTree(List<MenuInfo> menuInfos){
        List<MenuInfo> result = new ArrayList<MenuInfo>();
        List<MenuInfo> record = new ArrayList<MenuInfo>();

        for(MenuInfo info : menuInfos){
            if(!record.contains(info)) {
                if (info.getPid() != 0L) {
                    MenuInfo pInfo = getMenuInfo(menuInfos, info.getPid());
                    initMenu(result, menuInfos, record, pInfo);
                    pInfo.getChildren().add(info);
                } else {
                    initMenu(result, menuInfos, record, info);
                    result.add(info);
                }
            }
        }

        return result;
    }

    private void initMenu(List<MenuInfo> result, List<MenuInfo> source, List<MenuInfo> record, MenuInfo info){
        record.add(info);
    }

    private MenuInfo getMenuInfo(List<MenuInfo> menuInfos, Long id){
        MenuInfo menuInfo = null;
        for(MenuInfo info : menuInfos){
            if(info.getId().equals(id)){
                menuInfo = info;
                break;
            }
        }

        return menuInfo;
    }




    
}
