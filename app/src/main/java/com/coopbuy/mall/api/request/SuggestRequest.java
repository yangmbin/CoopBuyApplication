package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * Created by niu on 2017/10/31- 17:30
 */

public class SuggestRequest implements Serializable {

    /**
     * tel : string
     * realName : string
     * suggestContent : string
     */

    private String tel;
    private String realName;
    private String suggestContent;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSuggestContent() {
        return suggestContent;
    }

    public void setSuggestContent(String suggestContent) {
        this.suggestContent = suggestContent;
    }
}
