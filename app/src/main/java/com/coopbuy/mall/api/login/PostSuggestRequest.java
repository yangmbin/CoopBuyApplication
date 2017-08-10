package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/9 0009 11:38
 * @content
 */
public class PostSuggestRequest implements Serializable {
    private String SuggestContent;

    public String getSuggestContent() {
        return SuggestContent;
    }

    public void setSuggestContent(String suggestContent) {
        SuggestContent = suggestContent;
    }
}
