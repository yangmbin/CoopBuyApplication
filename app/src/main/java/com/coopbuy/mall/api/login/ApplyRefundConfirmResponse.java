package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/14 0014 14:12
 * @content
 */
public class ApplyRefundConfirmResponse implements Serializable{

    /**
     * refundAmount : 0
     */

    private int refundAmount;

    public int getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(int refundAmount) {
        this.refundAmount = refundAmount;
    }
}
