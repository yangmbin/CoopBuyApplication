package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * @author ymb
 * Create at 2017/10/16 15:39
 */
public class CheckUpdateRequest implements Serializable {

    /**
     * type : 0
     * version : string
     */

    private int type;
    private String version;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
