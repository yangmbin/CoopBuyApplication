package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/10/18 0018 9:18
 * @content
 */
public class AddAddressRequest implements Serializable {

    /**
     * userName : string
     * address : string
     * tel : string
     * regionId : 0
     * stationId : 0
     * stationUserId : 0
     */

    private String userName;
    private String address;
    private String tel;
    private long regionId;
    private int stationId;
    private int stationUserId;
    private long cityCode;
    private String addressDetail;
    /**
     * 省市区地址是否修改过
     */
    private boolean isRevise;
    //五级的省市区街道 村    "regionName": "勤光社区居民委员会,炉山镇,威宁彝族回族苗族自治县,毕节市,贵州省",
    // "regionIdPath": "520526103002,520526103000,520526000000,520500000000,520000000000",
    //对应的是             村             街道         区           市           省      编码是倒的  注意哟
    private String regionIdPath;
    //修改地址使用
    private int addressId;
    //服务器的地址详情
    private String addressDetailOld;
    private String regionName;
    private boolean hasBindStation;

    public boolean isHasBindStation() {
        return hasBindStation;
    }

    public void setHasBindStation(boolean hasBindStation) {
        this.hasBindStation = hasBindStation;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getAddressDetailOld() {
        return addressDetailOld;
    }

    public void setAddressDetailOld(String addressDetailOld) {
        this.addressDetailOld = addressDetailOld;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getRegionIdPath() {
        return regionIdPath;
    }

    public void setRegionIdPath(String regionIdPath) {
        this.regionIdPath = regionIdPath;
    }

    public boolean isRevise() {
        return isRevise;
    }

    public void setRevise(boolean revise) {
        isRevise = revise;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public long getCityCode() {
        return cityCode;
    }

    public void setCityCode(long cityCode) {
        this.cityCode = cityCode;
    }

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

    public long getRegionId() {
        return regionId;
    }

    public void setRegionId(long regionId) {
        this.regionId = regionId;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public int getStationUserId() {
        return stationUserId;
    }

    public void setStationUserId(int stationUserId) {
        this.stationUserId = stationUserId;
    }
}
