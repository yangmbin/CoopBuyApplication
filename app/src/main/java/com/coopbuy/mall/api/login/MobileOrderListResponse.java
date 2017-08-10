package com.coopbuy.mall.api.login;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/9 0009 9:52
 * @content 电话充值
 */
public class MobileOrderListResponse implements Serializable {


    private List<CartsBean> carts;

    public List<CartsBean> getCarts() {
        return carts;
    }

    public void setCarts(List<CartsBean> carts) {
        this.carts = carts;
    }

    public static class CartsBean {
        /**
         * cartId : 10
         * price : 10.0
         * cartAmount : 10.0
         */

        private String cartId;
        private double price;
        private double cartAmount;

        public String getCartId() {
            return cartId;
        }

        public void setCartId(String cartId) {
            this.cartId = cartId;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getCartAmount() {
            return cartAmount;
        }

        public void setCartAmount(double cartAmount) {
            this.cartAmount = cartAmount;
        }
    }
}
