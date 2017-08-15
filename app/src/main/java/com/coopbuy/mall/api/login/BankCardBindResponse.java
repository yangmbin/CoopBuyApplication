package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/14 0014 11:09
 * @content
 */
public class BankCardBindResponse implements Serializable{

    /**
     * id : 0
     * bankNo : string
     * bankName : string
     * bankLogoUrl : string
     * cardLastNo : string
     * cardType : 0
     * state : 0
     */

    private int id;
    private String bankNo;
    private String bankName;
    private String bankLogoUrl;
    private String cardLastNo;
    private int cardType;
    private int state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankLogoUrl() {
        return bankLogoUrl;
    }

    public void setBankLogoUrl(String bankLogoUrl) {
        this.bankLogoUrl = bankLogoUrl;
    }

    public String getCardLastNo() {
        return cardLastNo;
    }

    public void setCardLastNo(String cardLastNo) {
        this.cardLastNo = cardLastNo;
    }

    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
