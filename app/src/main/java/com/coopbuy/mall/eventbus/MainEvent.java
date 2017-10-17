package com.coopbuy.mall.eventbus;

import com.coopbuy.mall.eventbus.base.BaseEvent;

/**
 * @author csn
 * @date 2017/10/17 0017 17:34
 * @content
 */
public class MainEvent extends BaseEvent {
    private int tab;

    public int getTab() {
        return tab;
    }

    public void setTab(int tab) {
        this.tab = tab;
    }
}
