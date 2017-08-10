package com.guinong.net;

import com.google.gson.Gson;
import com.guinong.net.callback.AsyncEmptyCallbackHandle;
import com.guinong.net.callback.AsyncResultCallbackHandle;
import com.guinong.net.callback.AsyncTypeResultCallbackHandle;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncMessageCallback;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.callback.NetworkJsonCallback;
import com.guinong.net.request.AsyncRequestState;
import com.guinong.net.request.IAsyncRequestState;
import com.guinong.net.verify.VerifyManager;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Map;

import okhttp3.Call;
import okhttp3.FormBody;
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
    /**
     *
     */
    public static final MediaType APPLICATION_JSON = MediaType.parse("application/json; charset=utf-8");

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
    }

    public RequestClient() {
        this.isUnitTest = false;
    }

    /**
     * api 调用请求
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState apiRequest(Request request, IAsyncMessageCallback callback, Object userState) {
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
     /*   RequestParams params = new RequestParams();
        params.put("skuIds","1388");
        url = "http://dev.guinong.com:8810/api/Cart/PostDeleteCartProduct";
        FormBody.Builder mFormBodybuilder = new FormBody.Builder();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
                // 将请求参数逐一添加到请求体中
                mFormBodybuilder.add(entry.getKey(), entry.getValue());
            }
        }
        FormBody mFormBody = mFormBodybuilder.build();
        return new Request.Builder()
                .url(url)
                .post(mFormBody)
                .build();
       *//**/
        if (model != null) {
            String json = gson.toJson(model);
            RequestBody body = RequestBody.create(APPLICATION_JSON, json);
            return new Request.Builder().url(url).post(body).build();
        } else {
            RequestBody body = RequestBody.create(APPLICATION_JSON, "{}");
            return new Request.Builder().url(url).post(body)
                    .addHeader("Cookie","ASP.NET_SessionId=5gkjkpy03xc3qz0hfjvng0xt; path=/; HttpOnly" )
                    .addHeader("Cookie","oG8uj03OhS-3kifE2iLb39Jzs2gmo8uvoPmWRFXB6h8iI5-n3sfaMnOYSPIHPNJkPrHO7tCSd6hn_mhYUSjRB51IIhX1dWwsKQ9fyQ1E5pAhxmzcAOvFaHw9HHhB8Ywt0JCz-5_TubfeySfTVHDuDVID_n5LdWOKMRFG5Jd8pDpyPuB1de5D-aRZgMaJUioW3rFE1fX3cINun6B7sPEU_3ape2DnGwGuqBlFJpHahflDYl-PV8NKeQvZXyaZUD0Nj_yVYdoB7KBe16Qarz73ckWRzt0GJB3FsQOqRLHBjHBVVvUrYp7PxyYMphvJ-a3ilUD9euXgGJ22oTScNhXSbThfGyAocUKReRlZIa4xJDVDrUFFwN2A5V3eh2aw7ZGQhWEaVk_VljbvELV9Ecgazfbrhpf9JHaHxd62woqZYlQvU76UghkzB1vZ-AtNZ_gjHw1b8ZtolvSK_O_ZE7hHXQ; path=/; HttpOnly")
                    .addHeader("Cookie",".AspNet.Cookies=hBlnP5aDMjk7hbF5QxQe3z6-stsdfrdeFuAGn5seEq1URUBlaMH8SvFANnFy1Fleji7oe1TsT5JMMytAuUPW7e1z_UeIj8sJA34KH7mPV-KN7rcc8yLpE_UzcLA15uS_y3RGCnARjMVQWjYsKzLs1iC6TVfRgqtdvYmrKE5o2Xf6fC3HMIc1SxaIPeerqWSP7E5veAXJGjWIqskokgdfr2foZYRn2wrt_czANkXGF2gyH-I6RiZ99XY5410HAwV-FB85RWK8K-uDdIV8rb0CBxwMRv_w7DWXSbVErGnvrzpXFgiRWuJOtDUAknPSmorlCDNdFLVMdHzQGb8qr3c3YICSX0M8O6LkirV6yGP9A7YIkANL4I70BuVYz2TFKmyybI1kPQUznmPiKy2T2gsn71nbz14l5wZ4mUZ_yYajEsQhUVKSZVR6z1V29hVT3bJF6en5lBdO11lCLP3tMarJIA; path=/; HttpOnly")
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
      /*  url = "http://dev.guinong.com:8810/api/Login/GetUser";
        RequestParams params = new RequestParams();
        params.put("userName", "18089697084");
        params.put("password", "wy235479");
       *//**/
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
            return new Request.Builder().url(urlBuilder.substring(0, urlBuilder.length())).get().build();
        } else {
            return new Request.Builder().url(url).get().build();
        }/*
        StringBuilder urlBuilder = new StringBuilder(url).append("?");
        if (params != null) {
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
                // 将请求参数逐一添加到请求体中
                urlBuilder.append(entry.getKey()).append("=")
                        .append(entry.getValue())
                        .append("&");
            }
        }
        return new Request.Builder()
                .url(urlBuilder.substring(0, urlBuilder.length() - 1)) //要把最后的&符号去掉
                .get()
                .build();*/
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
