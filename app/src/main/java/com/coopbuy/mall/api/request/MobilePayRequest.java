package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * Created by niu on 2017/11/3- 14:53
 */
/**
*@time 2017/11/3 14:53
*@author  niu
*@content  手机号归属地查询
*/
public class MobilePayRequest implements Serializable {

    /**
     * cardId : string
     * phone : string
     */

    private String cardId;
    private String phone;
    private String count;
    private String allPrice;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(String allPrice) {
        this.allPrice = allPrice;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
