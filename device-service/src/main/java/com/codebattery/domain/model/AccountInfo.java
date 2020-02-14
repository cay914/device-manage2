package com.codebattery.domain.model;

public class AccountInfo {
    private String avatar;
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
    private String position;

    public AccountInfo() {
    }

    private String department;

    public AccountInfo(String avatar, String code, String memberCode, String organizationCode, String departmentCode, String authorize, Byte isOwner, String name, String mobile, String email, String createTime, String lastLoginTime, Byte status, String description, String position, String department) {
        this.avatar = avatar;
        this.code = code;
        this.memberCode = memberCode;
        this.organizationCode = organizationCode;
        this.departmentCode = departmentCode;
        this.authorize = authorize;
        this.isOwner = isOwner;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.createTime = createTime;
        this.lastLoginTime = lastLoginTime;
        this.status = status;
        this.description = description;
        this.position = position;
        this.department = department;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getAuthorize() {
        return authorize;
    }

    public void setAuthorize(String authorize) {
        this.authorize = authorize;
    }

    public Byte getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(Byte isOwner) {
        this.isOwner = isOwner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
