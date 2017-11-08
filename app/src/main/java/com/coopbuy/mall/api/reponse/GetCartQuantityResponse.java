package com.coopbuy.mall.api.reponse;

import java.io.Serializable;

/**
 * @author ymb
 * Create at 2017/10/16 10:36
 */
public class GetCartQuantityResponse implements Serializable {

    /**
     * cartCount : 0
     */

    private int cartCount;

    public int getCartCount() {
        return cartCount;
    }

    public void setCartCount(int cartCount) {
        this.cartCount = cartCount;
    }
}
