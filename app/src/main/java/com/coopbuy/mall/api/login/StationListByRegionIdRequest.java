package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/8 0008 14:23
 * @content
 */
public class StationListByRegionIdRequest implements Serializable {
    private String id;

    public String getParentId() {
        return id;
    }

    public void setParentId(String parentId) {
        this.id = parentId;
    }
}
