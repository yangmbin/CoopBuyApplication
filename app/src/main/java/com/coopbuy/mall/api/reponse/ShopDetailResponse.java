package com.coopbuy.mall.api.reponse;

import java.io.Serializable;

/**
 * @author yangmbin
 * Create at 2017/11/16 15:17
 */
public class ShopDetailResponse implements Serializable {

    /**
     * shopId : 0
     * shopName : string
     * logoUrl : string
     * isFavorite : true
     * slogan : string
     * totalProductCount : 0
     */

    private int shopId;
    private String shopName;
    private String logoUrl;
    private boolean isFavorite;
    private String slogan;
    private int totalProductCount;

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public boolean isIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public int getTotalProductCount() {
        return totalProductCount;
    }

    public void setTotalProductCount(int totalProductCount) {
        this.totalProductCount = totalProductCount;
    }
}
