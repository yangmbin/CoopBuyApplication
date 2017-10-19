package com.coopbuy.mall.ui.module.center.adapter;

import java.io.Serializable;

/**
 * @说明：
 * @创建人： niuniu
 * @创建时间： 2017/2/4 0004 18:23
 * @版本：v1.0
 * @修改人：
 * @修改时间：
 * @修改备注：
 * @作用：
 */

public class Shuizhui implements Serializable {

    /**
     * id : 20
     * name : 女孩子
     * price : 258
     * remark : 泰式按摩
     * service_type : shuizhu101
     * create_time : 2017-01-04 10:08:14
     * update_time : 2017-01-04 10:08:14
     * user_id : 2
     * service_id : 2
     * service_time : 2
     * status : 6
     */

    private String id;
    private String name;
    private String price;
    private String remark;
    private String service_type;
    private String create_time;
    private String update_time;
    private String user_id;
    private String service_id;
    private String service_time;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public String getService_time() {
        return service_time;
    }

    public void setService_time(String service_time) {
        this.service_time = service_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
