package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn   图文和详情请求都是一个id
 * @date 2017/8/9 0009 9:13
 * @content
 */
public class GoodsDetailRequest implements Serializable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
