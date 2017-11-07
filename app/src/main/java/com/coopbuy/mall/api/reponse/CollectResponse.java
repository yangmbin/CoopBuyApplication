package com.coopbuy.mall.api.reponse;

import java.io.Serializable;

/**
 * Created by niu on 2017/11/7- 9:23
 */

public class CollectResponse implements Serializable {
    private String name;
    private String version;
    private String price;
    private String oldPrice;
    private String saleCounts;
    private String imagesUrl;
    private boolean isSelect;
    private int count;
    /**
     * 可以添加数量
     */
    private int countAvailable;

    public int getCountAvailable() {
        return countAvailable;
    }

    public void setCountAvailable(int countAvailable) {
        this.countAvailable = countAvailable;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getSaleCounts() {
        return saleCounts;
    }

    public void setSaleCounts(String saleCounts) {
        this.saleCounts = saleCounts;
    }

    public String getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
