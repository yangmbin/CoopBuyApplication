package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/14 0014 16:50
 * @content
 */
public class PayApplyQuantityResponse implements Serializable{

    /**
     * waitAuditQuantity : 0
     */

    private int waitAuditQuantity;

    public int getWaitAuditQuantity() {
        return waitAuditQuantity;
    }

    public void setWaitAuditQuantity(int waitAuditQuantity) {
        this.waitAuditQuantity = waitAuditQuantity;
    }
}
