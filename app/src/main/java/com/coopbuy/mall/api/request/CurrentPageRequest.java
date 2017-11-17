package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * Created by niu on 2017/11/17- 14:42
 */

public class CurrentPageRequest implements Serializable {

    /**
     * currentPage : 1     0=全部，1=待审核，2=已审核，3=已发放，4=已作废
     */
    private int settlementStatus;
    private int currentPage;

    public int getSettlementStatus() {
        return settlementStatus;
    }

    public void setSettlementStatus(int settlementStatus) {
        this.settlementStatus = settlementStatus;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
