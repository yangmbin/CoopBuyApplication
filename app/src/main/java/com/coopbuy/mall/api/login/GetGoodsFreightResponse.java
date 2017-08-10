package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/9 0009 9:39
 * @content
 */
public class GetGoodsFreightResponse implements Serializable {

    /**
     * firstFreight : 0
     * secondFreight : 0
     * totalFreight : 0
     * secondLogisticName : string
     */

    private int firstFreight;
    private int secondFreight;
    private int totalFreight;
    private String secondLogisticName;

    public int getFirstFreight() {
        return firstFreight;
    }

    public void setFirstFreight(int firstFreight) {
        this.firstFreight = firstFreight;
    }

    public int getSecondFreight() {
        return secondFreight;
    }

    public void setSecondFreight(int secondFreight) {
        this.secondFreight = secondFreight;
    }

    public int getTotalFreight() {
        return totalFreight;
    }

    public void setTotalFreight(int totalFreight) {
        this.totalFreight = totalFreight;
    }

    public String getSecondLogisticName() {
        return secondLogisticName;
    }

    public void setSecondLogisticName(String secondLogisticName) {
        this.secondLogisticName = secondLogisticName;
    }
}
