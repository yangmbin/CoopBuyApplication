package com.coopbuy.mall.api;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

import com.coopbuy.mall.ui.module.center.activity.LoginActivity;
import com.coopbuy.mall.utils.FinalConstant;
import com.coopbuy.mall.utils.IntentUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.guinong.net.NetworkMessage;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * @author wangyu
 * @time 2017/8/4 0004 on 下午 15:46
 * @desc
 */
public class LoginInterceptor implements Interceptor {

    private Context mContext;
    private Gson mGson = null;
    private Handler mHandler = null;

    public LoginInterceptor(Context context) {
        this.mContext = context;
        mGson = new Gson();
        mHandler = new Handler();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request request = chain.request();
//        long starTime = System.currentTimeMillis();
//        LogUtil.error("mTime",starTime + "-----start----");
        Response response = chain.proceed(request);
//        LogUtil.error("mTime",System.currentTimeMillis() - starTime + "----end----");
        try {
            ResponseBody responseBody = response.body();
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();
            String bodyString = "";
            Charset charset = Charset.forName("UTF-8");
            if (buffer.toString().contains("hex=")) {
                return response;
            } else {
                bodyString = buffer.clone().readString(charset);
            }
            if (bodyString != null) {
                NetworkMessage msg = null;
                JsonParser parser = new JsonParser();
                JsonElement element = parser.parse(bodyString);
                JsonObject jsonObject = (JsonObject) element;
                msg = mGson.fromJson(jsonObject, NetworkMessage.class);
                if (!msg.isSuccess()) {
                    String errorMessage = "未知异常";
                    if (msg.getError() != null) {
                        if (msg.getError().getCode() == 404) {
                            errorMessage = "请求页面路径错误";
                        } else if (msg.getError().getCode() == 500) {
                            errorMessage = "服务器内部错误";
                        } else if (msg.getError().getCode() == 502) {
                            errorMessage = "错误的网关";
                        } else if (msg.getError().getCode() == 504) {
                            errorMessage = "网关超时";
                        } else if (msg.getError().getCode() == 405) {
                            errorMessage = "请求方式不支持(post，get)";
                        } else if (msg.getError().getCode() == -1) {
                            errorMessage = "用户未登录";
                            mContext.getMainLooper();
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if (request.url().url().toString().contains("FindDefault")) {
                                        return;
                                    }
                                    //七鱼聊天  后面再添加
                                    /*if (Unicorn.isServiceAvailable()) {
                                        Unicorn.logout();
                                    }*/
                                    mContext.startActivity(new Intent(mContext, LoginActivity.class).putExtra(IntentUtils.DATA, FinalConstant.login_type_normal).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                                }
                            });
                        }
                        Log.e("Error", "[" + "错误代码" + msg.getError().getCode() + "错误信息" + errorMessage + "]");
                    }
                }
            }
            Log.e("wangyu", "body---------->" + bodyString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}