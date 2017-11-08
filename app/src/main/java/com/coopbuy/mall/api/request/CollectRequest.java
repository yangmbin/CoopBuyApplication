package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * Created by niu on 2017/11/8- 10:30
 */

public class CollectRequest implements Serializable {

    /**
     publishStatus (integer, optional): 发布状态（0=全部，1=未发布，2=发布） ,
     currentPage (integer)
     */

    private int publishStatus;
    private int currentPage;

    public int getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(int publishStatus) {
        this.publishStatus = publishStatus;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
