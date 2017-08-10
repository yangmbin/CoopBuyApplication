package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/9 0009 11:29
 * @content
 */
public class GetTextCOntentResponse implements Serializable
{

    /**
     * title : 退货流程
     * author : null
     * publishTime : 2017-04-06 00:00:00
     * statu : 2
     * content : <p><strong style="margin: 0px; padding: 0px; color: rgb(102, 102, 102); font-family: Arial, &quot;microsoft yahei&quot;, SimSun; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);"><span style="margin: 0px; padding: 0px; display: inline-block; font-family: 宋体; font-size: 16px;">1.首先进入会员个人中心，查看”我的订单”，对需要退货的订单点击退货：</span></strong></p><p><strong style="margin: 0px; padding: 0px; color: rgb(102, 102, 102); font-family: Arial, &quot;microsoft yahei&quot;, SimSun; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);"><span style="margin: 0px; padding: 0px; display: inline-block; font-size: 16px;">2.<span style="margin: 0px; padding: 0px; display: inline-block; font-family: 宋体;">提交退货申请：</span></span></strong></p><p><strong style="margin: 0px; padding: 0px; color: rgb(102, 102, 102); font-family: Arial, &quot;microsoft yahei&quot;, SimSun; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);"><span style="margin: 0px; padding: 0px; display: inline-block; font-size: 16px;">3.<span style="margin: 0px; padding: 0px; display: inline-block; font-family: 宋体;">填写退货申请：</span></span></strong></p><p><strong style="margin: 0px; padding: 0px; color: rgb(102, 102, 102); font-family: Arial, &quot;microsoft yahei&quot;, SimSun; white-space: normal; background-color: rgb(255, 255, 255);">4.<span style="margin: 0px; padding: 0px; display: inline-block; font-family: 宋体;">等待商家审核：</span></strong></p><p><strong style="margin: 0px; padding: 0px; color: rgb(102, 102, 102); font-family: Arial, &quot;microsoft yahei&quot;, SimSun; white-space: normal; background-color: rgb(255, 255, 255);">5.<span style="margin: 0px; padding: 0px; display: inline-block; font-family: 宋体;">待商家审核后点击退货：</span></strong></p><p><strong style="margin: 0px; padding: 0px; color: rgb(102, 102, 102); font-family: Arial, &quot;microsoft yahei&quot;, SimSun; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);"><span style="margin: 0px; padding: 0px; display: inline-block; font-size: 16px;">6.<span style="margin: 0px; padding: 0px; display: inline-block; font-family: 宋体;">快递公司、物流单号必填：</span></span></strong></p><p><strong style="margin: 0px; padding: 0px; color: rgb(102, 102, 102); font-family: Arial, &quot;microsoft yahei&quot;, SimSun; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);"><span style="margin: 0px; padding: 0px; display: inline-block; font-size: 16px;">7.<span style="margin: 0px; padding: 0px; display: inline-block; font-family: 宋体;">等待商家收货、退款：</span></span></strong></p>
     * categoryId : 1
     */

    private String title;
    private Object author;
    private String publishTime;
    private int statu;
    private String content;
    private int categoryId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getAuthor() {
        return author;
    }

    public void setAuthor(Object author) {
        this.author = author;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
