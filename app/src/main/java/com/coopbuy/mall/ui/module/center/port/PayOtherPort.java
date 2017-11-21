package com.coopbuy.mall.ui.module.center.port;

/**
 * Created by niu on 2017/11/20- 19:16
 */

public interface PayOtherPort {
    void call(String phone);

    void detail(int postion);

    void refuse();

    void payMent(int postion);
}
