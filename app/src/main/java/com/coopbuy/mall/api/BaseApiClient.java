package com.coopbuy.mall.api;

import android.content.Context;

import com.guinong.net.RequestClient;
import com.guinong.net.cookie.CookierManager;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;

/**
 * @author csn
 * @date 2017/8/1 0001 11:47
 * @content client 的基类 其他需要继承这个使用
 */
public class BaseApiClient extends RequestClient {

    protected static OkHttpClient mOkHttpClient = null;
    private static final int TIME_OUT = 35;

    public static void contextInit(Context context) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClientBuilder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
        if (context != null) {
            //这里有个限制 我使用的添加请求头来添加cookie 目前还没有找到为什么cookie不保存
            // okHttpClientBuilder.cookieJar(new CookierManager(context));
            baseContext = context;
        }

        okHttpClientBuilder.followRedirects(true); //设置重定向 其实默认也是true
        okHttpClientBuilder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        });
        mOkHttpClient = okHttpClientBuilder.build();
    }

    static {
        if (mOkHttpClient == null) {
            contextInit(null);

        }
    }

    public BaseApiClient() {

    }

    @Override
    protected OkHttpClient getHttpClient() {
        return mOkHttpClient;
    }
}
