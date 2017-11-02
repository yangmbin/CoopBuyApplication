package com.coopbuy.mall.api.reponse;

import java.io.Serializable;

/**
 * Created by niu on 2017/11/2- 15:06
 */

public class TradeChannelResponse implements Serializable {

    /**
     * name : 支付宝
     * channelId : AliPay.APP
     * icon : https://oss.coopbuy.com/admin/images/285c695c-922f-4fe8-b0e8-a700180f32ff.png
     * extendParams : alipay
     */

    private String name;
    private String channelId;
    private String icon;
    private String extendParams;
    /**
     * 是否选中
     */
    private boolean isSelect;

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getExtendParams() {
        return extendParams;
    }

    public void setExtendParams(String extendParams) {
        this.extendParams = extendParams;
    }
}
