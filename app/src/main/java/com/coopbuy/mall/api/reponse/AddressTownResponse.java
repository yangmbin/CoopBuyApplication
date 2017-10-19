package com.coopbuy.mall.api.reponse;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/14.
 */
public class AddressTownResponse implements Serializable {


    /**
     * id : 408
     * name : 拉萨市
     * shortName : null
     */

    private long value;
    private String text;
    private Object shortName;
    private boolean hasBindSite;

    public boolean isHasBindSite() {
        return hasBindSite;
    }

    public void setHasBindSite(boolean hasBindSite) {
        this.hasBindSite = hasBindSite;
    }

    public long getId() {
        return value;
    }

    public void setId(long id) {
        this.value = id;
    }

    public String getName() {
        return text;
    }

    public void setName(String name) {
        this.text = name;
    }

    public Object getShortName() {
        return shortName;
    }

    public void setShortName(Object shortName) {
        this.shortName = shortName;
    }
}
