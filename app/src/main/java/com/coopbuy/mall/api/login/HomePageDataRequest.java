package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/7 0007 9:17
 * @content 首页数据 banner
 */
public class HomePageDataRequest implements Serializable {
    private String pagekey;

    public String getPagekey() {
        return pagekey;
    }

    public void setPagekey(String pagekey) {
        this.pagekey = pagekey;
    }
}
