package com.coopbuy.mall.api.login;

import com.guinong.net.verify.NotNull;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/3 0003 8:59
 * @content
 */
public class ImageCodeRequest implements Serializable {
    //这个key不知道是干什么的 就是哟啊输入 可以随便输入
    @NotNull(friendlyName = "key不能为空")
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
