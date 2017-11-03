package com.coopbuy.mall.api.reponse;

import java.io.Serializable;

/**
 * Created by niu on 2017/11/3- 14:51
 */

public class PhoneRechargeListReponse implements Serializable {

    /**
     * cardId : string
     * faceValue : 0
     * salePrice : 0
     */

    private String cardId;
    private double faceValue;
    private double salePrice;
    private boolean isSelect;
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public double getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(double faceValue) {
        this.faceValue = faceValue;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }


}

