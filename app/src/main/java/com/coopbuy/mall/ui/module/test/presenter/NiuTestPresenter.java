package com.coopbuy.mall.ui.module.test.presenter;

import android.content.Context;

import com.coopbuy.mall.api.classify.CategorysResponse;
import com.coopbuy.mall.api.login.GetDefaultAddressResponse;
import com.coopbuy.mall.api.login.GetStationRecommendResponse;
import com.coopbuy.mall.api.login.HomePageDataByIdRequest;
import com.coopbuy.mall.api.login.HomePageDataByIdResponse;
import com.coopbuy.mall.api.login.HomePageDataRequest;
import com.coopbuy.mall.api.login.HomePageDataResponse;
import com.coopbuy.mall.api.login.ImageCodeRequest;
import com.coopbuy.mall.api.login.ImageCodeResponse;
import com.coopbuy.mall.api.login.LoginClient;
import com.coopbuy.mall.api.login.LoginQuitRespsonse;
import com.coopbuy.mall.api.login.LoginRequest;
import com.coopbuy.mall.api.login.LoginResponse;
import com.coopbuy.mall.api.login.RegionsByParentIdRequest;
import com.coopbuy.mall.api.login.RegionsByParentIdResponse;
import com.coopbuy.mall.api.login.RegionsResponse;
import com.coopbuy.mall.api.login.RegisterRequest;
import com.coopbuy.mall.api.login.RegisterResponse;
import com.coopbuy.mall.api.login.SendSmsCodeRequest;
import com.coopbuy.mall.api.login.SendSmsCodeResponse;
import com.coopbuy.mall.api.login.SmsResetPasswordGetCodeRequest;
import com.coopbuy.mall.api.login.SmsResetPasswordGetCodeResponse;
import com.coopbuy.mall.api.login.SmsResetPasswordRequest;
import com.coopbuy.mall.api.login.SmsResetPasswordResponse;
import com.coopbuy.mall.api.login.StationListByRegionIdRequest;
import com.coopbuy.mall.api.login.StationListByRegionIdResponse;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.test.model.NiuTestModel;
import com.coopbuy.mall.ui.module.test.view.NiuTest_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.google.gson.Gson;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/2 0002 17:11
 * @content
 */
public class NiuTestPresenter extends BasePresenter<NiuTest_IView, NiuTestModel> {
    private Gson gson;
    private String sendkey = "";

    public NiuTestPresenter(Context mContext, NiuTestModel mModel, NiuTest_IView mView) {
        super(mContext, mModel, mView);
    }

    public void sendRequest(String value, List<Object> params) {

        gson = new Gson();
        mView.showFillLoading();
        switch (value) {
            case "登录":
                LoginRequest request = new LoginRequest();
                if (params.isEmpty()) {
                    request.setUserName("18786712371");
                    request.setPassWord("xh123456");
                    params.clear();
                    params.add(request);
                } else {
                    request = (LoginRequest) params.get(0);
                }
                mModel.login(request, new IAsyncResultCallback<LoginResponse>() {
                    @Override
                    public void onComplete(LoginResponse loginResponse, Object userState) {
                        if (loginResponse != null) {
                            if (loginResponse.isIsLoginSuccess()) {
                                mView.showData(gson.toJson(loginResponse));
                                ToastUtils.toastShort("登录成功");
                            } else {
                                mView.showData(gson.toJson(loginResponse));
                                ToastUtils.toastShort("登录失败");
                            }
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        if (error != null) {
                            error.getDetail();
                            mView.showData(error.getDetail());
                            mView.stopAll();
                        }
                    }
                }, "login");
                break;
            case "获取图形验证码":
                ImageCodeRequest imageCodeRequest = new ImageCodeRequest();
                if (params.isEmpty()) {
                    imageCodeRequest.setKey("1");
                    params.clear();
                    params.add(imageCodeRequest);
                } else {
                    imageCodeRequest = (ImageCodeRequest) params.get(0);
                }
                mModel.getImageCode(imageCodeRequest, new IAsyncResultCallback<ImageCodeResponse>() {
                    @Override
                    public void onComplete(ImageCodeResponse imageCodeResponse, Object userState) {
                        if (imageCodeResponse != null) {
                            mView.showData(gson.toJson(imageCodeResponse));
                            mView.showImageCode(imageCodeResponse.getImageArray());
                            ToastUtils.toastShort("获取图形验证码成功");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        if (error != null) {
                            error.getDetail();
                            mView.showData(error.getDetail());
                            mView.stopAll();
                        }
                    }
                }, "imagecode");

                break;
            case "获取短信验证码":
                SendSmsCodeRequest smsCodeRequest = new SendSmsCodeRequest();
                if (params.isEmpty()) {
                    smsCodeRequest.setKey("1");
                    smsCodeRequest.setImageCheckCode("pyn5");
                    smsCodeRequest.setMobilePhone("15982215971");
                    smsCodeRequest.setToken("");
                    params.clear();
                    params.add(smsCodeRequest);
                } else {
                    smsCodeRequest = (SendSmsCodeRequest) params.get(0);
                }
                mModel.sendSmsCode(smsCodeRequest, new IAsyncResultCallback<SendSmsCodeResponse>() {
                    @Override
                    public void onComplete(SendSmsCodeResponse imageCodeResponse, Object userState) {
                        if (imageCodeResponse != null) {
                            mView.showData(gson.toJson(imageCodeResponse));
                            sendkey = imageCodeResponse.getSendKey();
                            ToastUtils.toastShort("短信获取成功");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        if (error != null) {
                            error.getDetail();
                            mView.showData(error.getMessage() + error.getDetail());
                            mView.stopAll();
                        }
                    }
                }, "sendSms");
                break;

            case "注册用户":
                RegisterRequest registerRequest = new RegisterRequest();
                if (params.isEmpty()) {
                    registerRequest.setMobilePhone("18286882993");
                    registerRequest.setCheckCode("看手机");
                    registerRequest.setSendKey(sendkey);
                    registerRequest.setLoginPassword("q");
                    params.clear();
                    params.add(registerRequest);
                } else {
                    registerRequest = (RegisterRequest) params.get(0);
                }
                mModel.registerUser(registerRequest, new IAsyncResultCallback<RegisterResponse>() {
                    @Override
                    public void onComplete(RegisterResponse smsCodeResponse, Object userState) {
                        if (smsCodeResponse != null) {
                            mView.showData(gson.toJson(smsCodeResponse));
                            ToastUtils.toastShort("注册成功");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        if (error != null) {
                            error.getDetail();
                            mView.showData(error.getMessage() + error.getDetail());
                            mView.stopAll();
                        }
                        mView.stopAll();
                    }
                }, "rigister");

                break;

            case "忘记密码获取短信":
                SmsResetPasswordGetCodeRequest sendSmsCodeRequest = new SmsResetPasswordGetCodeRequest();
                if (params.isEmpty()) {
                    sendSmsCodeRequest.setMobilePhone("18286882993");
                    sendSmsCodeRequest.setImageCheckCode("自己添加");
                    sendSmsCodeRequest.setKey("1");
                    params.clear();
                    params.add(sendSmsCodeRequest);
                } else {
                    sendSmsCodeRequest = (SmsResetPasswordGetCodeRequest) params.get(0);
                }
                mModel.smsResetPasswordGetCode(sendSmsCodeRequest, new IAsyncResultCallback<SmsResetPasswordGetCodeResponse>() {
                    @Override
                    public void onComplete(SmsResetPasswordGetCodeResponse smsCodeResponse, Object userState) {
                        if (smsCodeResponse != null) {
                            mView.showData(gson.toJson(smsCodeResponse));
                            ToastUtils.toastShort("短信获取成功");
                            mView.stopAll();
                            sendkey = smsCodeResponse.getSendKey();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        if (error != null) {
                            error.getDetail();
                            mView.showData(error.getMessage() + error.getDetail());
                            mView.stopAll();
                        }
                    }
                }, "sendSmsGetCode");

                break;
            case "修改密码":
                SmsResetPasswordRequest sendSmsRequest = new SmsResetPasswordRequest();
                if (params.isEmpty()) {
                    sendSmsRequest.setMobilePhone("18286882993");
                    sendSmsRequest.setCheckCode("看手机");
                    sendSmsRequest.setNewPassword("q");
                    sendSmsRequest.setSendKey(sendkey);
                    params.clear();
                    params.add(sendSmsRequest);
                } else {
                    sendSmsRequest = (SmsResetPasswordRequest) params.get(0);
                }
                mModel.smsResetPassword(sendSmsRequest, new IAsyncResultCallback<SmsResetPasswordResponse>() {
                    @Override
                    public void onComplete(SmsResetPasswordResponse smsCodeResponse, Object userState) {
                        if (smsCodeResponse != null) {
                            mView.showData(gson.toJson(smsCodeResponse));
                            ToastUtils.toastShort("修改成功");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        if (error != null) {
                            error.getDetail();
                            mView.showData(error.getMessage() + error.getDetail());
                            mView.stopAll();
                        }
                        mView.stopAll();
                    }
                }, "sendSmsGetCode");
                break;
            case "退出登录":
                mModel.loginQuit(new IAsyncResultCallback<LoginQuitRespsonse>() {
                    @Override
                    public void onComplete(LoginQuitRespsonse smsCodeResponse, Object userState) {
                        if (smsCodeResponse != null) {
                            mView.showData(gson.toJson(smsCodeResponse));
                            ToastUtils.toastShort("退出成功");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        if (error != null) {
                            error.getDetail();
                            mView.showData(error.getMessage() + error.getDetail());
                            mView.stopAll();
                        }
                        mView.stopAll();
                    }
                }, "loginquit");

                break;
            case "首页":
                HomePageDataRequest homePageDataRequest = new HomePageDataRequest();
                if (params.isEmpty()) {
                    homePageDataRequest.setPagekey("AppHome");
                    params.clear();
                    params.add(homePageDataRequest);
                } else {
                    homePageDataRequest = (HomePageDataRequest) params.get(0);
                }
                mModel.homePageData(homePageDataRequest, new IAsyncResultCallback<HomePageDataResponse>() {
                    @Override
                    public void onComplete(HomePageDataResponse smsCodeResponse, Object userState) {
                        if (smsCodeResponse != null) {
                            mView.showData(gson.toJson(smsCodeResponse));
                            ToastUtils.toastShort("获取成功");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        if (error != null) {
                            error.getDetail();
                            mView.showData(error.getMessage() + error.getDetail());
                            mView.stopAll();
                        }
                        mView.stopAll();
                    }
                }, "homePage");
                break;
            case "分类":
                mModel.getCategorys(new IAsyncResultCallback<List<CategorysResponse>>() {
                    @Override
                    public void onComplete(List<CategorysResponse> categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("分类测试成功");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail());
                        mView.stopAll();
                    }
                }, "cate");
                break;

            case "获取站长推荐商品":
                mModel.getStationRecommend(new IAsyncResultCallback<List<GetStationRecommendResponse>>() {
                    @Override
                    public void onComplete(List<GetStationRecommendResponse> categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("站长推荐");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "recommend");
                break;
            case "首页banner图点击进入":
                HomePageDataByIdRequest homePageDataByIdRequest = new HomePageDataByIdRequest();
                if (params.isEmpty()) {
                    homePageDataByIdRequest.setPageId("2");
                    params.clear();
                    params.add(homePageDataByIdRequest);
                } else {
                    homePageDataByIdRequest = (HomePageDataByIdRequest) params.get(0);
                }
                mModel.getPageDataById(homePageDataByIdRequest, new IAsyncResultCallback<HomePageDataByIdResponse>() {
                    @Override
                    public void onComplete(HomePageDataByIdResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort(" 首页banner图点击进入");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "banner");

                break;
            case "首页点击（圆形图标）数据":
                ToastUtils.toastShort("调用上一个接口");
                mView.stopAll();
                break;
            case "获取默认收货地址":
                mModel.getDefalutAddress(new IAsyncResultCallback<GetDefaultAddressResponse>() {
                    @Override
                    public void onComplete(GetDefaultAddressResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("获取默认收货地址");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "address");
                break;
            case "获取用户收货地址列表":
                mModel.getDefalutAddressList(new IAsyncResultCallback<List<GetDefaultAddressResponse>>() {
                    @Override
                    public void onComplete(List<GetDefaultAddressResponse> categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("获取默认收货地址列表");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "addressList");
                break;
            case "获取行政区数":
                mModel.getRegions(new IAsyncResultCallback<List<RegionsResponse>>() {
                    @Override
                    public void onComplete(List<RegionsResponse> categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("获取行政区数");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "getRegions");
                break;
            case "根据区域id获取名称":
                RegionsByParentIdRequest regisons = new RegionsByParentIdRequest();
                if (params.isEmpty()) {
                    regisons.setParentId("520522003000");
                    params.clear();
                    params.add(regisons);
                } else {
                    regisons = (RegionsByParentIdRequest) params.get(0);
                }
                mModel.getRegionsByParentId(regisons, new IAsyncResultCallback<List<RegionsByParentIdResponse>>() {
                    @Override
                    public void onComplete(List<RegionsByParentIdResponse> categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("根据区域id获取名称");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "getRegionsByParentId");

                break;
            case "通过行政区域id获取站长列表信息":
                StationListByRegionIdRequest parentIdResponse = new StationListByRegionIdRequest();
                if (params.isEmpty()) {
                    parentIdResponse.setParentId("520522003001");
                    params.clear();
                    params.add(parentIdResponse);
                } else {
                    parentIdResponse = (StationListByRegionIdRequest) params.get(0);
                }
                mModel.getRegionsStationByParentId(parentIdResponse, new IAsyncResultCallback<List<StationListByRegionIdResponse>>() {
                    @Override
                    public void onComplete(List<StationListByRegionIdResponse> categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("根据区域id获取名称");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "getRegionsByParentId");
                break;
            case "新建收货地址":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "删除收货地址":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "修改收货地址":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "设置默认收货地址":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "代付款 待处理 付款数量":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "商品详情添加商品到购物车":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "购物车列表":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "购物车商品数量更新":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "购物车商品删除":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "购物车订单确认 商品运费 同时也是修改数量的接口":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "购物车订单提交  创建新订单":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "商品详情描述":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "用户商品详情获取商品信息":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "获取店铺信息":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "得到最新评论":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "单个商品运费":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "App更新":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "话费充值":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "支付通道申请":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "订单确认":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "创建话费订单":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "获取各订单数量":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "订单列表":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "代付款订单":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "待发货":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "待收货":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "待评价":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "订单详情":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "帮助中心":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "退货流程":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "网站订单":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "获取用户信息":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "修改用户昵称":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "修改性别":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            case "意见反馈":
                ToastUtils.toastShort("开发中");
                mView.stopAll();
                break;
            default:
                break;
        }
    }
}
