package com.codebattery.domain.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Account {
    private int id;
    private String code;
    private String memberCode;
    private String organizationCode;
    private String departmentCode;
    private String authorize;
    private Byte isOwner;
    private String name;
    private String mobile;
    private String email;
    private String createTime;
    private String lastLoginTime;
    private Byte status;
    private String description;
    private String avatar;
    private String position;
    private String department;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "member_code")
    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    @Basic
    @Column(name = "organization_code")
    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    @Basic
    @Column(name = "department_code")
    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    @Basic
    @Column(name = "authorize")
    public String getAuthorize() {
        return authorize;
    }

    public void setAuthorize(String authorize) {
        this.authorize = authorize;
    }

    @Basic
    @Column(name = "is_owner")
    public Byte getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(Byte isOwner) {
        this.isOwner = isOwner;
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
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "last_login_time")
    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Basic
    @Column(name = "status")
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
    @Column(name = "avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id &&
                Objects.equals(code, account.code) &&
                Objects.equals(memberCode, account.memberCode) &&
                Objects.equals(organizationCode, account.organizationCode) &&
                Objects.equals(departmentCode, account.departmentCode) &&
                Objects.equals(authorize, account.authorize) &&
                Objects.equals(isOwner, account.isOwner) &&
                Objects.equals(name, account.name) &&
                Objects.equals(mobile, account.mobile) &&
                Objects.equals(email, account.email) &&
                Objects.equals(createTime, account.createTime) &&
                Objects.equals(lastLoginTime, account.lastLoginTime) &&
                Objects.equals(status, account.status) &&
                Objects.equals(description, account.description) &&
                Objects.equals(avatar, account.avatar) &&
                Objects.equals(position, account.position) &&
                Objects.equals(department, account.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, memberCode, organizationCode, departmentCode, authorize, isOwner, name, mobile, email, createTime, lastLoginTime, status, description, avatar, position, department);
    }
}
