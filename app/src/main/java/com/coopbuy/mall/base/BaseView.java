package com.coopbuy.mall.base;

/**
 * View接口
 *
 * @author ymb
 *         Create at 2017/7/13 14:09
 */
public interface BaseView {
    void showFillLoading();

    void showTransLoading();

    void stopAll();

    void showNoDataLayout();

    void showNetOffLayout();

    void showNetErrorLayout();
}
