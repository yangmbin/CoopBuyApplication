package com.coopbuy.mall.api.reponse;

import java.io.Serializable;

/**
 * @author ymb
 * Create at 2017/10/16 15:41
 */
public class CalculateFreightResponse implements Serializable {

    /**
     * freightAmount : 0.0
     * hasSecondLogistic : false
     * secondFreight : 0.0
     * secondLogisticComName :
     * totalFreightAmount : 0.0
     */

    private double freightAmount;
    private boolean hasSecondLogistic;
    private double secondFreight;
    private String secondLogisticComName;
    private double totalFreightAmount;

    public double getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(double freightAmount) {
        this.freightAmount = freightAmount;
    }

    public boolean isHasSecondLogistic() {
        return hasSecondLogistic;
    }

    public void setHasSecondLogistic(boolean hasSecondLogistic) {
        this.hasSecondLogistic = hasSecondLogistic;
    }

    public double getSecondFreight() {
        return secondFreight;
    }

    public void setSecondFreight(double secondFreight) {
        this.secondFreight = secondFreight;
    }

    public String getSecondLogisticComName() {
        return secondLogisticComName;
    }

    public void setSecondLogisticComName(String secondLogisticComName) {
        this.secondLogisticComName = secondLogisticComName;
    }

    public double getTotalFreightAmount() {
        return totalFreightAmount;
    }

    public void setTotalFreightAmount(double totalFreightAmount) {
        this.totalFreightAmount = totalFreightAmount;
    }
}
