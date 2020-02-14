package com.codebattery.domain.model;

import java.util.Date;

public class OrganizationInfo {
    private Long id;
    private String name;
    private String avatar;
    private String description;
    private String ownerCode;
    private Date createTime;
    private Boolean personal;
    private String code;
    private String address;
    private String province;
    private String city;
    private String area;

    public OrganizationInfo() {
    }

    public OrganizationInfo(Long id, String name, String avatar, String description, String ownerCode,
                            Date createTime, Boolean personal, String code,
                            String address, String province, String city, String area) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.description = description;
        this.ownerCode = ownerCode;
        this.createTime = createTime;
        this.personal = personal;
        this.code = code;
        this.address = address;
        this.province = province;
        this.city = city;
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getPersonal() {
        return personal;
    }

    public void setPersonal(Boolean personal) {
        this.personal = personal;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
