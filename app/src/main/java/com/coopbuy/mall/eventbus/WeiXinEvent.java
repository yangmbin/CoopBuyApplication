package com.coopbuy.mall.eventbus;

import com.coopbuy.mall.eventbus.base.BaseEvent;

/**
 * @author csn
 * @date 2017/6/19 0019 13:33
 * @content
 */
public class WeiXinEvent extends BaseEvent {
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
