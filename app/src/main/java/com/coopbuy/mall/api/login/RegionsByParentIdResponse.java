package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/8 0008 14:12
 * @content
 */
public class RegionsByParentIdResponse implements Serializable {

    /**
     * hasBindSite : false
     * isCity : false
     * value : 110101001000
     * text : 东华门街道办事处
     */

    private boolean hasBindSite;
    private boolean isCity;
    private long value;
    private String text;

    public boolean isHasBindSite() {
        return hasBindSite;
    }

    public void setHasBindSite(boolean hasBindSite) {
        this.hasBindSite = hasBindSite;
    }

    public boolean isIsCity() {
        return isCity;
    }

    public void setIsCity(boolean isCity) {
        this.isCity = isCity;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
