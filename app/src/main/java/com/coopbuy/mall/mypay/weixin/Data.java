package com.coopbuy.mall.mypay.weixin;

import java.io.Serializable;

/**
 * @说明：
 * @创建人： niuniu
 * @创建时间： 2017/1/21 0021 17:20
 * @版本：v1.0
 * @修改人：
 * @修改时间：
 * @修改备注：
 * @作用：
 */

public class Data implements Serializable {
    private String code ;
    private String message;
    private Info data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Info getData() {
        return data;
    }

    public void setData(Info data) {
        this.data = data;
    }
}
