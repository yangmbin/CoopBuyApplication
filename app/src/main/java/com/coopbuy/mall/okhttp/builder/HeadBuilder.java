package com.coopbuy.mall.okhttp.builder;


import com.coopbuy.mall.okhttp.OkHttpUtils;
import com.coopbuy.mall.okhttp.request.OtherRequest;
import com.coopbuy.mall.okhttp.request.RequestCall;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,id).build();
    }
}
