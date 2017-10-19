package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/10/18 0018 9:23
 * @content 设置默认地址 删除地址  根据id查找地址
 */
public class SetDefaultOrDeleteOrFindAddressRequest implements Serializable {

    /**
     * addressId : 0
     */

    private int addressId;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
}
