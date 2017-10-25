package com.coopbuy.mall.api.reponse;

import java.io.Serializable;

/**
 * Created by niu on 2017/10/25- 15:18
 */

public class GoodsUpdateResponse implements Serializable {
    /**
     * cartItemCount : 0
     */
    private int cartItemCount;

    public int getCartItemCount() {
        return cartItemCount;
    }

    public void setCartItemCount(int cartItemCount) {
        this.cartItemCount = cartItemCount;
    }
}
