package com.codebattery.repository;

import com.codebattery.domain.entity.Organization;
import com.codebattery.domain.entity.User;
import com.codebattery.domain.model.OrganizationInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long>  {

//    @Query(value = "SELECT new com.codebattery.domain.entity.OrganizationInfo "
//            +"( id, name, null, null, String ownerCode,\n" +
//            "                            Date createTime, Boolean personal, String code, \n" +
//            "                            String address, String province, String city, String area) "
//            +"FROM com.codebattery.domain.entity.Organization o "
//    )
//    List<OrganizationInfo> listAllOrganizationInfos();

}
