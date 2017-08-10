package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/9 0009 10:24
 * @content
 */
public class GetOrderQuantityResponse implements Serializable {

    /**
     * waitPaymentQuantity : 3
     * waitForDispatchQuantity : 0
     * waitForReceiveQuantity : 0
     * waitForCommentQuantity : 0
     * refundOrderQuantity : 0
     */

    private int waitPaymentQuantity;
    private int waitForDispatchQuantity;
    private int waitForReceiveQuantity;
    private int waitForCommentQuantity;
    private int refundOrderQuantity;

    public int getWaitPaymentQuantity() {
        return waitPaymentQuantity;
    }

    public void setWaitPaymentQuantity(int waitPaymentQuantity) {
        this.waitPaymentQuantity = waitPaymentQuantity;
    }

    public int getWaitForDispatchQuantity() {
        return waitForDispatchQuantity;
    }

    public void setWaitForDispatchQuantity(int waitForDispatchQuantity) {
        this.waitForDispatchQuantity = waitForDispatchQuantity;
    }

    public int getWaitForReceiveQuantity() {
        return waitForReceiveQuantity;
    }

    public void setWaitForReceiveQuantity(int waitForReceiveQuantity) {
        this.waitForReceiveQuantity = waitForReceiveQuantity;
    }

    public int getWaitForCommentQuantity() {
        return waitForCommentQuantity;
    }

    public void setWaitForCommentQuantity(int waitForCommentQuantity) {
        this.waitForCommentQuantity = waitForCommentQuantity;
    }

    public int getRefundOrderQuantity() {
        return refundOrderQuantity;
    }

    public void setRefundOrderQuantity(int refundOrderQuantity) {
        this.refundOrderQuantity = refundOrderQuantity;
    }
}
