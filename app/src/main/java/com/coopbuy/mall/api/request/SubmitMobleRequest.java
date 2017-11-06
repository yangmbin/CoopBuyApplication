package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * Created by niu on 2017/11/6- 11:42
 */

public class SubmitMobleRequest implements Serializable {

    /**
     * cardId : string
     * phone : string
     */

    private String cardId;
    private String phone;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
