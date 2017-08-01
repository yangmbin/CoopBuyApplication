package com.coopbuy.mall.eventbus.base;

/**
 * 消息基类
 * @author ymb
 * Create at 2017/8/1 13:56
 */
public abstract class BaseEvent {
    protected String mMsg;

    public BaseEvent() {
    }

    public BaseEvent(String mMsg) {
        this.mMsg = mMsg;
    }

    public String getmMsg() {
        return mMsg;
    }

    public void setmMsg(String mMsg) {
        this.mMsg = mMsg;
    }
}
