package com.coopbuy.mall.api.reponse;

import java.io.Serializable;

/**
 * @author yangmbin
 * Create at 2017/11/7 9:43
 */
public class ShippingCompanyResponse implements Serializable {

    /**
     * code : string
     * name : string
     */

    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
