package com.coopbuy.mall.bean;

import java.io.Serializable;

/**
 * @author yangmbin
 * Create at 2017/11/16 9:42
 */
public class HomeExtendData implements Serializable{
    private String keyword;
    private String categoryId;
    private String link;

    public HomeExtendData() {
        this.keyword = "";
        this.categoryId = "";
        this.link = "";
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
