package com.coopbuy.mall.api.reponse;

import java.io.Serializable;

/**
 * Created by niu on 2017/11/3- 14:57
 */

public class CheckPhoneReponse implements Serializable {

    /**
     * canRecharge : true
     * cardId : string
     * cardName : string
     * area : string
     */

    private boolean canRecharge;
    private String cardId;
    private String cardName;
    private String area;

    public boolean isCanRecharge() {
        return canRecharge;
    }

    public void setCanRecharge(boolean canRecharge) {
        this.canRecharge = canRecharge;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
