package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/8 0008 14:23
 * @content
 */
public class StationListByRegionIdRequest implements Serializable {
    private String parentId;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
