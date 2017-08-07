package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/4 0004 15:53
 * @content
 */
public class LoginQuitRespsonse implements Serializable {

    /**
     * sussess : true
     * msg : 退出成功
     */

    private boolean sussess;
    private String msg;

    public boolean isSussess() {
        return sussess;
    }

    public void setSussess(boolean sussess) {
        this.sussess = sussess;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
