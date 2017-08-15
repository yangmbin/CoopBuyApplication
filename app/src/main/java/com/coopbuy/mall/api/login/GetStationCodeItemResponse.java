package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/14 0014 14:38
 * @content
 */
public class GetStationCodeItemResponse implements Serializable{

    /**
     * siteName : string
     * stationConnectName : string
     * stationConnectPhone : string
     */

    private String siteName;
    private String stationConnectName;
    private String stationConnectPhone;

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getStationConnectName() {
        return stationConnectName;
    }

    public void setStationConnectName(String stationConnectName) {
        this.stationConnectName = stationConnectName;
    }

    public String getStationConnectPhone() {
        return stationConnectPhone;
    }

    public void setStationConnectPhone(String stationConnectPhone) {
        this.stationConnectPhone = stationConnectPhone;
    }

}
