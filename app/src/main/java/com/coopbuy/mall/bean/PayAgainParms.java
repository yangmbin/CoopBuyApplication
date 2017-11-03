package com.coopbuy.mall.bean;

import java.io.Serializable;

/**
 * Created by niu on 2017/11/3- 11:34
 */

/**
 * @author niu
 * @time 2017/11/3 11:34
 * @content 重新支付参数
 */
public class PayAgainParms implements Serializable {
    private String mWaitOrderId;
    private String mChannelId;
    private String mCountsTotal;
    private String mCountsTotalPrice;

    public String getmWaitOrderId() {
        return mWaitOrderId;
    }

    public void setmWaitOrderId(String mWaitOrderId) {
        this.mWaitOrderId = mWaitOrderId;
    }

    public String getmChannelId() {
        return mChannelId;
    }

    public void setmChannelId(String mChannelId) {
        this.mChannelId = mChannelId;
    }

    public String getmCountsTotal() {
        return mCountsTotal;
    }

    public void setmCountsTotal(String mCountsTotal) {
        this.mCountsTotal = mCountsTotal;
    }

    public String getmCountsTotalPrice() {
        return mCountsTotalPrice;
    }

    public void setmCountsTotalPrice(String mCountsTotalPrice) {
        this.mCountsTotalPrice = mCountsTotalPrice;
    }
}
