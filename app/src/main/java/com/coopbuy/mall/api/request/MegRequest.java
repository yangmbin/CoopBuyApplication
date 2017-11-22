package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * Created by niu on 2017/11/22- 11:02
 */

public class MegRequest implements Serializable {

    /**
     * groupId : 1.0
     * currentPage : 1
     */

    private double groupId;
    private int currentPage;

    public double getGroupId() {
        return groupId;
    }

    public void setGroupId(double groupId) {
        this.groupId = groupId;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
