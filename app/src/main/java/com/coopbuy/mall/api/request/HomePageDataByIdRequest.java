package com.coopbuy.mall.api.request;

import com.guinong.net.verify.NotNull;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/8 0008 13:47
 * @content  首页点击  通过id单独对应的数据
  */
public class HomePageDataByIdRequest implements Serializable {
    @NotNull
    private String pageId;

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }
}
