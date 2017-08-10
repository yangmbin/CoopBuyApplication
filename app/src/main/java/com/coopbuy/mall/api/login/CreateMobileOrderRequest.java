package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/9 0009 10:15
 * @content
 */
public class CreateMobileOrderRequest implements Serializable {

    /**
     * phone : 18286882993
     * cartId : 10
     */

    private String phone;
    private String cartId;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }
}
