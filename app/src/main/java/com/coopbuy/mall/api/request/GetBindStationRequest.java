package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/10/19 0019 15:03
 * @content 获取绑定站点的数据 站长 助手
 */
public class GetBindStationRequest implements Serializable {

    /**
     * regionId : 520526103001
     */

    private long regionId;

    public long getRegionId() {
        return regionId;
    }

    public void setRegionId(long regionId) {
        this.regionId = regionId;
    }
}
