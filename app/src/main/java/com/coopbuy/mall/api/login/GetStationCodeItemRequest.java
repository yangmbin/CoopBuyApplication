package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/14 0014 14:37
 * @content
 */
public class GetStationCodeItemRequest implements Serializable{

    /**
     * siteId : 0
     * stationUserId : 0
     */

    private int siteId;
    private int stationUserId;

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public int getStationUserId() {
        return stationUserId;
    }

    public void setStationUserId(int stationUserId) {
        this.stationUserId = stationUserId;
    }
}
