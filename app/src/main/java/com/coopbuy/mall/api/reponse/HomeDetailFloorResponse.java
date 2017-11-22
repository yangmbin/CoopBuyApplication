package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * @author yangmbin
 * Create at 2017/11/22 17:23
 */
public class HomeDetailFloorResponse implements Serializable {
    private String name;
    private List<HomeFloorResponse> floorList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HomeFloorResponse> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<HomeFloorResponse> floorList) {
        this.floorList = floorList;
    }
}