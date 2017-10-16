package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.request.IAsyncRequestState;

/**
 * @author csn
 * @date 2017/10/16 0016 14:04
 * @content
 */
public class SettingModel implements BaseModel {
    public IAsyncRequestState quit(IAsyncEmptyCallback callback, Object userState) {
        return client.quit(callback, userState);
    }
}
