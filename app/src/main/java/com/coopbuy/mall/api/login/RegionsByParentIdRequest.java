package com.coopbuy.mall.api.login;

import com.guinong.net.verify.NotNull;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/8 0008 14:13
 * @content
 */
public class RegionsByParentIdRequest implements Serializable {
    @NotNull
    private String parentId;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
