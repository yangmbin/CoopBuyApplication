package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/10/18 0018 16:01
 * @content 根据省市区值获取对应的村  社区
 */
public class GetChildProvincesRequest implements Serializable {

    /**
     * parentId : 110101001000
     */

    private long parentId;

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
}
