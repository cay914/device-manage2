package com.codebattery.domain.model;

import java.util.ArrayList;
import java.util.List;

public class MenuInfo {
    private Long id;
    private Long pid;
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
    private String statusText;
    private String innerText;
    private String fullUrl;
    List<MenuInfo> children = new ArrayList<>();

    public MenuInfo() {
    }

    public MenuInfo(Long id, Long pid, String title, String icon, String url, String filePath,
                    String params, String node, Integer sort, Byte status, long createBy,
                    String createAt, Byte isInner, String values, Byte showSlider) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.icon = icon;
        this.url = url;
        this.filePath = filePath;
        this.params = params;
        this.node = node;
        this.sort = sort;
        this.status = status;
        this.createBy = createBy;
        this.createAt = createAt;
        this.isInner = isInner;
        this.values = values;
        this.showSlider = showSlider;
    }

    public MenuInfo(Long id, Long pid, String title, String icon, String url, String filePath,
                    String params, String node, Integer sort, Byte status, long createBy,
                    String createAt, Byte isInner, String values, Byte showSlider, String statusText, String innerText,
                    String fullUrl, List<MenuInfo> children) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.icon = icon;
        this.url = url;
        this.filePath = filePath;
        this.params = params;
        this.node = node;
        this.sort = sort;
        this.status = status;
        this.createBy = createBy;
        this.createAt = createAt;
        this.isInner = isInner;
        this.values = values;
        this.showSlider = showSlider;
        this.statusText = statusText;
        this.innerText = innerText;
        this.fullUrl = fullUrl;
        if(children!=null) {
            this.children = children;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(long createBy) {
        this.createBy = createBy;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public Byte getIsInner() {
        return isInner;
    }

    public void setIsInner(Byte isInner) {
        this.isInner = isInner;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public Byte getShowSlider() {
        return showSlider;
    }

    public void setShowSlider(Byte showSlider) {
        this.showSlider = showSlider;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getInnerText() {
        return innerText;
    }

    public void setInnerText(String innerText) {
        this.innerText = innerText;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public List<MenuInfo> getChildren() {
        return children;
    }

    public void setChildren(List<MenuInfo> children) {
        this.children = children;
    }
}
