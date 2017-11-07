package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * @author yangmbin
 * Create at 2017/11/2 10:45
 */
public class RefundExpressInfoRequest implements Serializable {

    /**
     * applyNo : 201709142424081
     */

    private String applyNo;

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }
}
