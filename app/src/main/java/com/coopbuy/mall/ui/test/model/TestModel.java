package com.coopbuy.mall.ui.test.model;

import com.coopbuy.mall.api.api;
import com.coopbuy.mall.base.BaseModel;
import com.coopbuy.mall.okhttp.callback.StringCallback;


public class TestModel implements BaseModel {
    public void getData(StringCallback callback) {
        api.requestTestData(callback);
    }
}
