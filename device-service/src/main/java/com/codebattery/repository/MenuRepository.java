package com.codebattery.repository;

import com.codebattery.domain.entity.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Long>  {
}
