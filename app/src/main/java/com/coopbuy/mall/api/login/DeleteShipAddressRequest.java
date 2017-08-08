package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/8 0008 15:19
 * @content
 */
public class DeleteShipAddressRequest implements Serializable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
