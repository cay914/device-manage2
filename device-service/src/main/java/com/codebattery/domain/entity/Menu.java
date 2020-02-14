package com.codebattery.domain.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "menu", schema = "device")
public class Menu {
    private long id;
    private long pid;
    private String title;
    private String icon;
    private String url;
    private String filePath;
    private String params;
    private String node;
    private Integer sort;
    private Byte status;
    private long createBy;
    private String createAt;
    private Byte isInner;
    private String values;
    private Byte showSlider;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "pid")
    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "file_path")
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Basic
    @Column(name = "params")
    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    @Basic
    @Column(name = "node")
    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    @Basic
    @Column(name = "sort")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
    @Column(name = "create_by")
    public long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(long createBy) {
        this.createBy = createBy;
    }

    @Basic
    @Column(name = "create_at")
    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    @Basic
    @Column(name = "is_inner")
    public Byte getIsInner() {
        return isInner;
    }

    public void setIsInner(Byte isInner) {
        this.isInner = isInner;
    }

    @Basic
    @Column(name = "values")
    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    @Basic
    @Column(name = "show_slider")
    public Byte getShowSlider() {
        return showSlider;
    }

    public void setShowSlider(Byte showSlider) {
        this.showSlider = showSlider;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu that = (Menu) o;
        return id == that.id &&
                pid == that.pid &&
                createBy == that.createBy &&
                Objects.equals(title, that.title) &&
                Objects.equals(icon, that.icon) &&
                Objects.equals(url, that.url) &&
                Objects.equals(filePath, that.filePath) &&
                Objects.equals(params, that.params) &&
                Objects.equals(node, that.node) &&
                Objects.equals(sort, that.sort) &&
                Objects.equals(status, that.status) &&
                Objects.equals(createAt, that.createAt) &&
                Objects.equals(isInner, that.isInner) &&
                Objects.equals(values, that.values) &&
                Objects.equals(showSlider, that.showSlider);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pid, title, icon, url, filePath, params, node, sort, status, createBy, createAt, isInner, values, showSlider);
    }
}
