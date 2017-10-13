package com.coopbuy.mall.api.center;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/10/13 0013 10:48
 * @content
 */
public class StationRecommendResponse implements Serializable {
    private String time;
    private String name;
    private String salePrice;
    private String oldPirce;
    private String version;
    private String saleCount;
    private String Images;

    public StationRecommendResponse(String time, String name, String salePrice, String oldPirce, String version, String saleCount, String images) {
        this.time = time;
        this.name = name;
        this.salePrice = salePrice;
        this.oldPirce = oldPirce;
        this.version = version;
        this.saleCount = saleCount;
        Images = images;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getOldPirce() {
        return oldPirce;
    }

    public void setOldPirce(String oldPirce) {
        this.oldPirce = oldPirce;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(String saleCount) {
        this.saleCount = saleCount;
    }

    public String getImages() {
        return Images;
    }

    public void setImages(String images) {
        Images = images;
    }
}
