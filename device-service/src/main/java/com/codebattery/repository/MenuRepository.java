package com.codebattery.repository;

import com.codebattery.domain.entity.Menu;
import com.codebattery.domain.model.MenuInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Long>  {

    @Query(value="SELECT new com.codebattery.domain.model.MenuInfo("
            +" id, pid, title, icon, url, filePath, "
            +" params,  node,  sort,  status,  createBy, "
            +" createAt,  isInner,  values,  showSlider "
            + ") FROM "
            + " com.codebattery.domain.entity.Menu m ")
    List<MenuInfo> queryAllMenus();

}
