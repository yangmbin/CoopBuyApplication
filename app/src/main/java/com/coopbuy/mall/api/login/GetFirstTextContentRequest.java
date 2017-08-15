package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/14 0014 14:14
 * @content
 */
public class GetFirstTextContentRequest implements Serializable{

    /**
     * categoryKey : string
     */

    private String categoryKey;

    public String getCategoryKey() {
        return categoryKey;
    }

    public void setCategoryKey(String categoryKey) {
        this.categoryKey = categoryKey;
    }
}
