package com.guinong.net;

import android.content.Context;
import android.os.Handler;

import com.google.gson.Gson;
import com.guinong.net.callback.AsyncEmptyCallbackHandle;
import com.guinong.net.callback.AsyncResultCallbackHandle;
import com.guinong.net.callback.AsyncTypeResultCallbackHandle;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncMessageCallback;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.callback.NetworkJsonCallback;
import com.guinong.net.cookie.SharedPreferencesUtils;
import com.guinong.net.request.AsyncRequestState;
import com.guinong.net.request.IAsyncRequestState;
import com.guinong.net.utils.NetWorkUtil;
import com.guinong.net.verify.VerifyManager;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * @author csn
 * @date 2017/7/25 0025 18:42
 * @content
 */
public abstract class RequestClient {
    //获得context 拿到cookie
    public static Context baseContext;
    /**
     *
     */
    public static final MediaType APPLICATION_JSON = MediaType.parse("application/json; charset=utf-8");
    public SharedPreferencesUtils utils;

    /**
     * @return
     */
    protected abstract OkHttpClient getHttpClient();

    /**
     * @return
     */
    protected Gson createGson() {
        return new Gson();
    }

    private boolean isUnitTest;

    public boolean isUnitTest() {
        return isUnitTest;
    }

    public void setUnitTest(boolean unitTest) {
        isUnitTest = unitTest;
        if (baseContext != null)
            utils = SharedPreferencesUtils.getInstance(baseContext);
    }


    public RequestClient() {
        this.isUnitTest = false;
    }

    private Handler mHandler = new Handler();


    /**
     * api 调用请求
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState apiRequest(Request request, final IAsyncMessageCallback callback, final Object userState) {
        if (!NetWorkUtil.isNetworkConnected(baseContext)) {

            mHandler.postDelayed(new Runnable() { // 解决无网络情况下用户点击重试无反应的不良体验
                @Override
                public void run() {
                    NetworkException exception = new NetworkException(CodeContant.CODE_NET_UNAVAILABLE, "无网络", null);
                    callback.onError(exception, userState);
                }
            }, 800);
            return null;
        }
        ExceptionUtils.checkNotNull(request, "request");
        ExceptionUtils.checkNotNull(callback, "callback");
        OkHttpClient client = getHttpClient();
        Call call = client.newCall(request);
        AsyncRequestState state = new AsyncRequestState(call, userState);
        call.enqueue(new NetworkJsonCallback(isUnitTest(), createGson(), callback, userState));

        return state;
    }

    private boolean checkModel(Object model, IAsyncMessageCallback callBack, Object userState) {
        try {
            VerifyManager.validate(model);

            return true;
        } catch (Exception err) {
            callBack.onError(new NetworkException(CodeContant.CODE_PARMER_ERROR, err.getMessage(), null, err), userState);
            return false;
        }
    }

    private IAsyncRequestState defaultAsyncRequestState(final Object userState) {
        return new IAsyncRequestState() {
            @Override
            public boolean cancel() {
                return false;
            }

            @Override
            public Object getUserState() {
                return userState;
            }
        };
    }

    private Request createPostRequest(Object model, String url, Gson gson) {
        if (model != null) {
            String json = gson.toJson(model);
            RequestBody body = RequestBody.create(APPLICATION_JSON, json);
            if (baseContext == null) {
                return new Request.Builder().url(url).post(body).build();
            }
            return new Request.Builder().url(url).post(body)
                   .build();
        } else {
            RequestBody body = RequestBody.create(APPLICATION_JSON, "{}");
            if (baseContext == null) {
                return new Request.Builder().url(url).post(body)
                        .build();
            }
            return new Request.Builder().url(url).post(body)
                  //  .addHeader("Cookie", utils.getCookier(".AspNet.Cookies=50OPld1mcMGmCTKC8OCSrd5_JiyYY9s5arriYzP7wGzu-f9MvweTzZ2USSENukp_Yz7td9ly_SzDSCN1JTKL7vfdWxGw-JDOsFXuKxXXASqPrNAUmgTahZx9EMbVo6iJxjZYTrnLwcmd-MQMgt8IFE4OOJsZvu6CB6Mfg-j-DYxEFCUCy28z6tbWE7M_wFZI3IKYpv9VKLiP1Q6ZyeWfdh_5mBl91Qj10FOiwf9D-PFbtAe1BLKFNmNU_Gi33f1frSSj7osyGq4i0VefS3IZyIq1RiZKZIcKWB1mFtGMIUs9Ge_rK3StadRWhUZtAKaxqmGr_4BHw_BjOEELcWaSbw; path=/; httponly"))
                    .build();
        }
    }

    /**
     * 创建get访问请求
     *
     * @param model
     * @param url
     * @param gson
     * @return
     */
    private Request createGetRequest(Object model, String url, Gson gson) {
        if (model != null) {
            StringBuilder urlBuilder = new StringBuilder(url).append("?");
            Class modelclass = model.getClass();
            Field[] fields = modelclass.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field f = fields[i];
                f.setAccessible(true);
                Object val = new Object();
                String temp = "&";
                if (i == fields.length - 1) {
                    temp = "";
                }
                try {

                    val = f.get(model);
                    if (val != null) {
                        urlBuilder.append(f.getName()).append("=")
                                .append(val)
                                .append(temp);
                        // 得到此属性的值
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if (baseContext == null) {
                return new Request.Builder().url(urlBuilder.substring(0, urlBuilder.length())).get().build();
            } else {
                return new Request.Builder().url(urlBuilder.substring(0, urlBuilder.length()))
                        .addHeader("Cookie", utils.getCookier("0"))
                        .addHeader("Cookie", utils.getCookier("1"))
                        .addHeader("Cookie", utils.getCookier("2"))
                        .get().build();
            }
        } else {
            if (baseContext == null) {
                return new Request.Builder().url(url).get().build();
            } else {
                return new Request.Builder().url(url).get()
                        .addHeader("Cookie", utils.getCookier("0"))
                        .addHeader("Cookie", utils.getCookier("1"))
                        .addHeader("Cookie", utils.getCookier("2"))
                        .build();
            }
        }
    }

    /**
     * @param url
     * @param callback
     * @param userState
     * @return 无参无返回值post请求
     */
    protected IAsyncRequestState apiPostRequest(String url, final IAsyncEmptyCallback callback, Object userState) {
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncEmptyCallbackHandle msgCallBack = new AsyncEmptyCallbackHandle(callback);
        return apiRequest(createPostRequest(null, url, gson), msgCallBack, userState);
    }

    /**
     * @param resultClass
     * @param url
     * @param callback
     * @param userState
     * @param <TResult>
     * @return 无参带返回对象post请求
     */
    protected <TResult> IAsyncRequestState apiPostRequest(final Class<TResult> resultClass, String url, final IAsyncResultCallback<TResult> callback, Object userState) {
        ExceptionUtils.checkNotNull(resultClass, "resultClass");
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncResultCallbackHandle<TResult> msgCallBack = new AsyncResultCallbackHandle(resultClass, callback, gson);
        return apiRequest(createPostRequest(null, url, gson), msgCallBack, userState);
    }


    /**
     * @param resultType
     * @param url
     * @param callback
     * @param userState
     * @param <TResult>
     * @return 无参带返回数组post请求
     */
    protected <TResult> IAsyncRequestState apiPostRequest(final Type resultType, String url, final IAsyncResultCallback<TResult> callback, Object userState) {
        ExceptionUtils.checkNotNull(resultType, "resultType");
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncTypeResultCallbackHandle<TResult> msgCallBack = new AsyncTypeResultCallbackHandle(resultType, callback, gson);
        return apiRequest(createPostRequest(null, url, gson), msgCallBack, userState);
    }

    /**
     * @param url
     * @param model
     * @param callback
     * @param userState
     * @return 有参无返回值post请求
     */
    protected IAsyncRequestState apiPostRequest(String url, Object model, final IAsyncEmptyCallback callback, Object userState) {
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(model, "model");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncEmptyCallbackHandle msgCallBack = new AsyncEmptyCallbackHandle(callback);
        if (!checkModel(model, msgCallBack, userState)) {
            return defaultAsyncRequestState(userState);
        }
        return apiRequest(createPostRequest(model, url, gson), msgCallBack, userState);
    }

    /**
     * @param resultType
     * @param url
     * @param model
     * @param callback
     * @param userState
     * @param <TResult>
     * @return 有参带返回数组post请求
     */
    protected <TResult> IAsyncRequestState apiPostRequest(final Type resultType, String url,
                                                          Object model, final IAsyncResultCallback<TResult> callback, Object userState) {
        ExceptionUtils.checkNotNull(resultType, "resultType");
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(model, "model");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncTypeResultCallbackHandle<TResult> msgCallBack = new AsyncTypeResultCallbackHandle(resultType, callback, gson);
        if (!checkModel(model, msgCallBack, userState)) {
            return defaultAsyncRequestState(userState);
        }
        return apiRequest(createPostRequest(model, url, gson), msgCallBack, userState);
    }


    /**
     * @param resultClass
     * @param url
     * @param model
     * @param callback
     * @param userState
     * @param <TResult>
     * @return 有参带返回对象post请求
     */
    protected <TResult> IAsyncRequestState apiPostRequest(final Class<TResult> resultClass, String url,
                                                          Object model, final IAsyncResultCallback<TResult> callback, Object userState) {
        ExceptionUtils.checkNotNull(resultClass, "resultClass");
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(model, "model");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncResultCallbackHandle<TResult> msgCallBack = new AsyncResultCallbackHandle(resultClass, callback, gson);
        if (!checkModel(model, msgCallBack, userState)) {
            return defaultAsyncRequestState(userState);
        }
        return apiRequest(createPostRequest(model, url, gson), msgCallBack, userState);
    }

    /**
     * @param resultType
     * @param url
     * @param model
     * @param callback
     * @param userState
     * @param <TResult>
     * @return 有参带返回数组get请求
     */
    protected <TResult> IAsyncRequestState apiGetRequest(final Type resultType, String url,
                                                         Object model, final IAsyncResultCallback<TResult> callback, Object userState) {
        ExceptionUtils.checkNotNull(resultType, "resultType");
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(model, "model");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncTypeResultCallbackHandle<TResult> msgCallBack = new AsyncTypeResultCallbackHandle(resultType, callback, gson);
        if (!checkModel(model, msgCallBack, userState)) {
            return defaultAsyncRequestState(userState);
        }
        return apiRequest(createGetRequest(model, url, gson), msgCallBack, userState);
    }

    /**
     * @param url
     * @param model
     * @param callback
     * @param userState
     * @param <TResult>
     * @return 有参带返回对象get请求
     */
    protected <TResult> IAsyncRequestState apiGetRequest(final Class<TResult> resultClass, String url,
                                                         Object model, final IAsyncResultCallback<TResult> callback, Object userState) {
        ExceptionUtils.checkNotNull(resultClass, "resultClass");
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(model, "model");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncResultCallbackHandle<TResult> msgCallBack = new AsyncResultCallbackHandle(resultClass, callback, gson);
        if (!checkModel(model, msgCallBack, userState)) {
            return defaultAsyncRequestState(userState);
        }
        return apiRequest(createGetRequest(model, url, gson), msgCallBack, userState);
    }


    /**
     * @param url
     * @param model
     * @param callback
     * @param userState
     * @return 有参无返回值get请求
     */
    protected IAsyncRequestState apiGetRequest(String url, Object model, final IAsyncEmptyCallback callback, Object userState) {
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(model, "model");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncEmptyCallbackHandle msgCallBack = new AsyncEmptyCallbackHandle(callback);
        if (!checkModel(model, msgCallBack, userState)) {
            return defaultAsyncRequestState(userState);
        }
        return apiRequest(createGetRequest(model, url, gson), msgCallBack, userState);
    }

    /**
     * @param resultType
     * @param url
     * @param callback
     * @param userState
     * @param <TResult>
     * @return 无参带返回数组get请求
     */
    protected <TResult> IAsyncRequestState apiGetRequest(final Type resultType, String url, final IAsyncResultCallback<TResult> callback, Object userState) {
        ExceptionUtils.checkNotNull(resultType, "resultType");
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncTypeResultCallbackHandle<TResult> msgCallBack = new AsyncTypeResultCallbackHandle(resultType, callback, gson);
        return apiRequest(createGetRequest(null, url, gson), msgCallBack, userState);
    }

    /**
     * @param resultClass
     * @param url
     * @param callback
     * @param userState
     * @param <TResult>
     * @return 无参带返回对象get请求
     */
    protected <TResult> IAsyncRequestState apiGetRequest(final Class<TResult> resultClass, String url, final IAsyncResultCallback<TResult> callback, Object userState) {
        ExceptionUtils.checkNotNull(resultClass, "resultClass");
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncResultCallbackHandle<TResult> msgCallBack = new AsyncResultCallbackHandle(resultClass, callback, gson);
        return apiRequest(createGetRequest(null, url, gson), msgCallBack, userState);
    }

    /**
     * @param url
     * @param callback
     * @param userState
     * @return 无参无返回值get请求
     */
    protected IAsyncRequestState apiGetRequest(String url, final IAsyncEmptyCallback callback, Object userState) {
        ExceptionUtils.checkNotNull(url, "url");
        ExceptionUtils.checkNotNull(callback, "callback");
        Gson gson = createGson();
        AsyncEmptyCallbackHandle msgCallBack = new AsyncEmptyCallbackHandle(callback);
        return apiRequest(createGetRequest(null, url, gson), msgCallBack, userState);
    }
}
