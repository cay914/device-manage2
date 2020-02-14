package com.codebattery.domain.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Organization {
    private int id;
    private String name;
    private String avatar;
    private String description;
    private String ownerCode;
    private String createTime;
    private Byte personal;
    private String code;
    private String address;
    private Integer province;
    private Integer city;
    private Integer area;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "owner_code")
    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    @Basic
    @Column(name = "create_time")
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "personal")
    public Byte getPersonal() {
        return personal;
    }

    public void setPersonal(Byte personal) {
        this.personal = personal;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "province")
    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    @Basic
    @Column(name = "city")
    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    @Basic
    @Column(name = "area")
    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(avatar, that.avatar) &&
                Objects.equals(description, that.description) &&
                Objects.equals(ownerCode, that.ownerCode) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(personal, that.personal) &&
                Objects.equals(code, that.code) &&
                Objects.equals(address, that.address) &&
                Objects.equals(province, that.province) &&
                Objects.equals(city, that.city) &&
                Objects.equals(area, that.area);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, avatar, description, ownerCode, createTime, personal, code, address, province, city, area);
    }
}
