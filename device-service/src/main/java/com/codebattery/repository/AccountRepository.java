package com.codebattery.repository;

import com.codebattery.domain.entity.Account;
import com.codebattery.domain.model.AccountInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long>  {


    @Query(value="SELECT new com.codebattery.domain.model.AccountInfo("
            + " avatar, code, memberCode, organizationCode, departmentCode, authorize, isOwner, name, mobile, email, createTime, lastLoginTime, status, description, position, department "
            + ") FROM "
            + " com.codebattery.domain.entity.Account a ")
    List<AccountInfo> queryAllAccountInfo();

}
