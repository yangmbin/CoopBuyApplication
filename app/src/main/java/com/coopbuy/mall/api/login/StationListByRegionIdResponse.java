package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/8 0008 14:25
 * @content
 */
public class StationListByRegionIdResponse implements Serializable {

    /**
     * siteCode : 8257040307
     * siteName : 田坎社区电商服务站
     * regionId : 0
     * address :
     * regionIdPath : null
     * regionPath : null
     * stationUserName : 杨加琴
     * stationUserPhone : null
     * stationUserId : 511
     * masterName : null
     * masterPhone : null
     * id : 137
     */

    private String siteCode;
    private String siteName;
    private int regionId;
    private String address;
    private String regionIdPath;
    private String regionPath;
    private String stationUserName;
    private String stationUserPhone;
    private int stationUserId;
    private String masterName;
    private String masterPhone;
    private int id;

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegionIdPath() {
        return regionIdPath;
    }

    public void setRegionIdPath(String regionIdPath) {
        this.regionIdPath = regionIdPath;
    }

    public String getRegionPath() {
        return regionPath;
    }

    public void setRegionPath(String regionPath) {
        this.regionPath = regionPath;
    }

    public String getStationUserName() {
        return stationUserName;
    }

    public void setStationUserName(String stationUserName) {
        this.stationUserName = stationUserName;
    }

    public String getStationUserPhone() {
        return stationUserPhone;
    }

    public void setStationUserPhone(String stationUserPhone) {
        this.stationUserPhone = stationUserPhone;
    }

    public int getStationUserId() {
        return stationUserId;
    }

    public void setStationUserId(int stationUserId) {
        this.stationUserId = stationUserId;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getMasterPhone() {
        return masterPhone;
    }

    public void setMasterPhone(String masterPhone) {
        this.masterPhone = masterPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
