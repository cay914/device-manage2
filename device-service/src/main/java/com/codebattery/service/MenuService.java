package com.codebattery.service;

import com.codebattery.domain.entity.Menu;
import com.codebattery.domain.model.MenuInfo;
import com.codebattery.repository.MenuRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    /**
     * 查询菜单
     *
     * @return
     * @author Eric
     * @date 2020-02-09
     */
    public List<MenuInfo> queryAllMenus() {

        List<MenuInfo> menuInfos = menuRepository.queryAllMenus();

        return createMenuTree(menuInfos);
    }

    private List<MenuInfo> createMenuTree(List<MenuInfo> menuInfos) {
        LinkedList<MenuInfo> result = new LinkedList<MenuInfo>();  //结果
        List<MenuInfo> record = new ArrayList<MenuInfo>();  //记录已经处理的菜单

        for (MenuInfo info : menuInfos) {
            initMenu(result, menuInfos, record, info);
        }

        return result;
    }

    private void initMenu(LinkedList<MenuInfo> result, List<MenuInfo> source, List<MenuInfo> record, MenuInfo info) {
        if (!record.contains(info)) {
            if (info.getPid() != 0L) {
                MenuInfo pInfo = getMenuInfo(source, info.getPid());
                initMenu(result, source, record, pInfo);

                addSortMenu(pInfo.getChildren(), info);
            } else {
                addSortMenu(result, info);
            }

            record.add(info);
        }
    }

    private MenuInfo getMenuInfo(List<MenuInfo> menuInfos, Long id) {
        MenuInfo menuInfo = null;
        for (MenuInfo info : menuInfos) {
            if (info.getId().equals(id)) {
                menuInfo = info;
                break;
            }
        }

        return menuInfo;
    }

    private void addSortMenu(LinkedList<MenuInfo> list, MenuInfo info) {
        int num = list.size();
        if (list.isEmpty()) {
            list.add(info);
        } else {
            for (int i = 0; i < num; i++) {
                MenuInfo m = list.get(i);
                if (m.getSort() > info.getSort()) {
                    list.add(i, info);
                    break;
                } else {
                    if (i == num - 1) {
                        list.add(info); //到最后
                    }
                }
            }
        }
    }


}
