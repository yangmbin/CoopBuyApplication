package com.coopbuy.mall.api.reponse;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/10/18 0018 9:32
 * @content
 */
public class FindAddressResponse implements Serializable {

    /**
     * userName : string
     * address : string
     * tel : string
     * isDefault : true
     * regionId : 0
     * regionName : string
     * stationUserId : 0
     * stationId : 0
     * stationName : string
     * hasBindSite : true
     */

    private String userName;
    private String address;
    private String tel;
    private boolean isDefault;
    private int regionId;
    private String regionName;
    private int stationUserId;
    private int stationId;
    private String stationName;
    private boolean hasBindSite;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public boolean isIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public int getStationUserId() {
        return stationUserId;
    }

    public void setStationUserId(int stationUserId) {
        this.stationUserId = stationUserId;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public boolean isHasBindSite() {
        return hasBindSite;
    }

    public void setHasBindSite(boolean hasBindSite) {
        this.hasBindSite = hasBindSite;
    }
}
