package com.coopbuy.mall.bean;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/9/30 0030 14:43
 * @content
 */
public class CenterData implements Serializable{
    private String name;
    private int images;

    public CenterData(String name, int images) {
        this.name = name;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
