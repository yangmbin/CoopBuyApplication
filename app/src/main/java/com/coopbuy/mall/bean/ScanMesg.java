package com.coopbuy.mall.bean;

import java.io.Serializable;

/**
 * Created by niu on 2017/11/1- 16:25
 */

/**
 * @author niu
 * @time 2017/11/1 16:25
 * @content 扫描结果
 */
public class ScanMesg implements Serializable {
    private String name;
    private String stationName;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
