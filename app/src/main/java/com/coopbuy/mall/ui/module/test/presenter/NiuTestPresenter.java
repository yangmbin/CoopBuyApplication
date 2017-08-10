package com.coopbuy.mall.ui.module.test.presenter;

import android.content.Context;

import com.coopbuy.mall.api.classify.CategorysResponse;
import com.coopbuy.mall.api.login.AddGoodsRequest;
import com.coopbuy.mall.api.login.CartListResponse;
import com.coopbuy.mall.api.login.CreateShipAddressRequest;
import com.coopbuy.mall.api.login.DeleteShipAddressRequest;
import com.coopbuy.mall.api.login.GetDefaultAddressResponse;
import com.coopbuy.mall.api.login.GetShopIdRequest;
import com.coopbuy.mall.api.login.GetShopIdResponse;
import com.coopbuy.mall.api.login.GetStationRecommendResponse;
import com.coopbuy.mall.api.login.GoodsDetailDescResponse;
import com.coopbuy.mall.api.login.GoodsDetailInfoResponse;
import com.coopbuy.mall.api.login.GoodsDetailRequest;
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
import com.coopbuy.mall.api.login.MobifyShipAddressRequest;
import com.coopbuy.mall.api.login.NewUserGoodsOrderRequest;
import com.coopbuy.mall.api.login.NewUserGoodsOrderresponse;
import com.coopbuy.mall.api.login.OperateSuccessResponse;
import com.coopbuy.mall.api.login.OrderConfirmRequest;
import com.coopbuy.mall.api.login.OrderConfirmResponse;
import com.coopbuy.mall.api.login.OrderFreightRequest;
import com.coopbuy.mall.api.login.OrderFreightResponse;
import com.coopbuy.mall.api.login.QuantityResponse;
import com.coopbuy.mall.api.login.RegionsByParentIdRequest;
import com.coopbuy.mall.api.login.RegionsByParentIdResponse;
import com.coopbuy.mall.api.login.RegionsResponse;
import com.coopbuy.mall.api.login.RegisterRequest;
import com.coopbuy.mall.api.login.RegisterResponse;
import com.coopbuy.mall.api.login.RemoveGoodsRequest;
import com.coopbuy.mall.api.login.SendSmsCodeRequest;
import com.coopbuy.mall.api.login.SendSmsCodeResponse;
import com.coopbuy.mall.api.login.SetDefaultAddressRequest;
import com.coopbuy.mall.api.login.SmsResetPasswordGetCodeRequest;
import com.coopbuy.mall.api.login.SmsResetPasswordGetCodeResponse;
import com.coopbuy.mall.api.login.SmsResetPasswordRequest;
import com.coopbuy.mall.api.login.SmsResetPasswordResponse;
import com.coopbuy.mall.api.login.StationListByRegionIdRequest;
import com.coopbuy.mall.api.login.StationListByRegionIdResponse;
import com.coopbuy.mall.api.login.UpdateGoodsQuantityRequest;
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
                    parentIdResponse.setParentId("520522003003");
                    params.clear();
                    params.add(parentIdResponse);
                } else {
                    parentIdResponse = (StationListByRegionIdRequest) params.get(0);
                }
                mModel.getRegionsStationByParentId(parentIdResponse, new IAsyncResultCallback<StationListByRegionIdResponse>() {
                    @Override
                    public void onComplete(StationListByRegionIdResponse categorysResponses, Object userState) {
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
                CreateShipAddressRequest createShipAddressRequest = new CreateShipAddressRequest();
                if (params.isEmpty()) {
                    createShipAddressRequest.setCustomerName("niuniu");
                    createShipAddressRequest.setPhone("18286882993");
                    createShipAddressRequest.setAddress("测试地址");
                    createShipAddressRequest.setTel("注意 少任何一个都会提示该站点没有创建");
                    createShipAddressRequest.setIsDefault(false);
                    createShipAddressRequest.setRegionId("520522003003");
                    createShipAddressRequest.setRegionFullName("贵州省 毕节市 黔西县文峰街道兴黔社区居民委员会");
                    createShipAddressRequest.setNameUsedBefore("");
                    createShipAddressRequest.setSiteName("兴黔社区电商服务站");
                    createShipAddressRequest.setSiteId(60);
                    createShipAddressRequest.setStationUserId(510);
                    params.clear();
                    params.add(createShipAddressRequest);
                } else {
                    createShipAddressRequest = (CreateShipAddressRequest) params.get(0);
                }
                mModel.createShipAddress(createShipAddressRequest, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("新建收货地址");
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
            case "删除收货地址":
                DeleteShipAddressRequest deleteShipAddressRequest = new DeleteShipAddressRequest();
                if (params.isEmpty()) {
                    deleteShipAddressRequest.setId(3470);
                    params.clear();
                    params.add(deleteShipAddressRequest);
                } else {
                    deleteShipAddressRequest = (DeleteShipAddressRequest) params.get(0);
                }
                mModel.deleteShipAddress(deleteShipAddressRequest, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("删除收货地址");
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
            case "修改收货地址":
                MobifyShipAddressRequest mobifyShipAddressRequest = new MobifyShipAddressRequest();
                if (params.isEmpty()) {
                    mobifyShipAddressRequest.setCustomerName("修改了");
                    mobifyShipAddressRequest.setPhone("18286886332");
                    mobifyShipAddressRequest.setAddress("xxxxxx");
                    mobifyShipAddressRequest.setTel("请根据地址的id来修改");
                    mobifyShipAddressRequest.setIsDefault(false);
                    mobifyShipAddressRequest.setRegionId("110101001001");
                    mobifyShipAddressRequest.setRegionFullName("北京市 市辖区 东城区东华门街道办事处多福巷社区居委会");
                    mobifyShipAddressRequest.setNameUsedBefore("");
                    mobifyShipAddressRequest.setId("3410");
                    params.clear();
                    params.add(mobifyShipAddressRequest);
                } else {
                    mobifyShipAddressRequest = (MobifyShipAddressRequest) params.get(0);
                }
                mModel.mobifyShipAddress(mobifyShipAddressRequest, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("删除收货地址");
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
            case "设置默认收货地址":
                SetDefaultAddressRequest setDefaultAddressRequest = new SetDefaultAddressRequest();
                if (params.isEmpty()) {
                    setDefaultAddressRequest.setId(3410);
                    params.clear();
                    params.add(setDefaultAddressRequest);
                } else {
                    setDefaultAddressRequest = (SetDefaultAddressRequest) params.get(0);
                }
                mModel.setDefaultShipAddress(setDefaultAddressRequest, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("设置默认收货地址");
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
            case "代付款 待处理 付款数量":
                mModel.getQuantityNumber(new IAsyncResultCallback<QuantityResponse>() {
                    @Override
                    public void onComplete(QuantityResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("代付款 待处理 付款数量");
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
            case "商品详情添加商品到购物车":
                AddGoodsRequest addGoodsRequest = new AddGoodsRequest();
                if (params.isEmpty()) {
                    AddGoodsRequest.GoodsBean bean = new AddGoodsRequest.GoodsBean();
                    bean.setQuantity(2);
                    bean.setSkuId(2776);
                    List<AddGoodsRequest.GoodsBean> data = new ArrayList<>();
                    addGoodsRequest.setGoods(data);
                    params.clear();
                    params.add(addGoodsRequest);
                    ToastUtils.toastLong("请根据具体商品添加");
                } else {
                    addGoodsRequest = (AddGoodsRequest) params.get(0);
                }
                mModel.addGoods(addGoodsRequest, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("商品详情添加商品到购物车");
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
            case "购物车列表":
                mModel.getCartList(new IAsyncResultCallback<CartListResponse>() {
                    @Override
                    public void onComplete(CartListResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("购物车列表");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "购物车列表");
                break;
            case "购物车商品数量更新":
                UpdateGoodsQuantityRequest updateGoods = new UpdateGoodsQuantityRequest();
                if (params.isEmpty()) {
                    updateGoods.setSkuId(2776);
                    updateGoods.setQuantity(2);
                    params.clear();
                    params.add(updateGoods);
                } else {
                    updateGoods = (UpdateGoodsQuantityRequest) params.get(0);
                }
                mModel.updateGoodsQuantity(updateGoods, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("商品详情添加商品到购物车");
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
            case "购物车商品删除":
                RemoveGoodsRequest removeGoodsRequest = new RemoveGoodsRequest();
                if (params.isEmpty()) {
                    List<Integer> data = new ArrayList<>();
                    data.add(2776);
                    removeGoodsRequest.setSkuId(data);
                    ToastUtils.toastLong("请根据具体商品删除");
                    params.clear();
                    params.add(removeGoodsRequest);
                } else {
                    removeGoodsRequest = (RemoveGoodsRequest) params.get(0);
                }
                mModel.removeGoods(removeGoodsRequest, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("购物车商品删除");
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
            case "购物车提交订单 订单确认":
                OrderConfirmRequest orderConfirmRequest = new OrderConfirmRequest();
                if (params.isEmpty()) {
                    List<OrderConfirmRequest.SkusBean> data = new ArrayList<>();
                    OrderConfirmRequest.SkusBean bean = new OrderConfirmRequest.SkusBean();
                    bean.setSkuId(2776);
                    bean.setQuantity(1);
                    orderConfirmRequest.setSkus(data);
                    params.clear();
                    params.add(orderConfirmRequest);
                } else {
                    orderConfirmRequest = (OrderConfirmRequest) params.get(0);
                }
                mModel.orderConfirm(orderConfirmRequest, new IAsyncResultCallback<OrderConfirmResponse>() {
                    @Override
                    public void onComplete(OrderConfirmResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("购物车提交订单 订单确认");
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
            case "购物车订单确认 商品运费 同时也是修改数量的接口":
                OrderFreightRequest orderFreightRequest = new OrderFreightRequest();
                if (params.isEmpty()) {
                    List<OrderFreightRequest.SkuItemsBean> data = new ArrayList<>();
                    OrderFreightRequest.SkuItemsBean bean = new OrderFreightRequest.SkuItemsBean();
                    bean.setQuantity(1);
                    bean.setSkuId(2776);
                    data.add(bean);
                    orderFreightRequest.setRegionId("110102010001");
                    orderFreightRequest.setSkuItems(data);
                    params.clear();
                    params.add(orderFreightRequest);
                } else {
                    orderFreightRequest = (OrderFreightRequest) params.get(0);
                }
                mModel.getOrderFreightAndUpdateOrderCounts(orderFreightRequest, new IAsyncResultCallback<OrderFreightResponse>() {
                    @Override
                    public void onComplete(OrderFreightResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("购物车订单确认 商品运费 同时也是修改数量的接口");
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
            case "购物车订单提交  创建新订单":
                NewUserGoodsOrderRequest newUserGoodsOrderRequest = new NewUserGoodsOrderRequest();
                if (params.isEmpty()) {
                    List<NewUserGoodsOrderRequest.SkusBean> data = new ArrayList<>();
                    NewUserGoodsOrderRequest.SkusBean bean = new NewUserGoodsOrderRequest.SkusBean();
                    bean.setQuantity(1);
                    bean.setSkuId(2776);
                    data.add(bean);
                    newUserGoodsOrderRequest.setSkus(data);
                    params.clear();
                    params.add(newUserGoodsOrderRequest);
                } else {
                    newUserGoodsOrderRequest = (NewUserGoodsOrderRequest) params.get(0);
                }
                mModel.newUserGoodsOrder(newUserGoodsOrderRequest, new IAsyncResultCallback<NewUserGoodsOrderresponse>() {
                    @Override
                    public void onComplete(NewUserGoodsOrderresponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("购物车订单提交  创建新订单");
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
            case "商品详情描述":
                GoodsDetailRequest goodsDetailRequest = new GoodsDetailRequest();
                if (params.isEmpty()) {
                    goodsDetailRequest.setId(393);
                    params.clear();
                    params.add(goodsDetailRequest);
                } else {
                    goodsDetailRequest = (GoodsDetailRequest) params.get(0);
                }
                mModel.goodsDetailImage(goodsDetailRequest, new IAsyncResultCallback<GoodsDetailDescResponse>() {
                    @Override
                    public void onComplete(GoodsDetailDescResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("商品详情描述");
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
            case "用户商品详情获取商品信息":
                GoodsDetailRequest goodsDetailRequestinfo = new GoodsDetailRequest();
                if (params.isEmpty()) {
                    goodsDetailRequestinfo.setId(393);
                    params.clear();
                    params.add(goodsDetailRequestinfo);
                } else {
                    goodsDetailRequestinfo = (GoodsDetailRequest) params.get(0);
                }
                mModel.goodsDeatailInfo(goodsDetailRequestinfo, new IAsyncResultCallback<GoodsDetailInfoResponse>() {
                    @Override
                    public void onComplete(GoodsDetailInfoResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("商品详情描述");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "goodsDeatailInfo");

                break;
            case "获取店铺信息":
                GetShopIdRequest shopIdRequest = new GetShopIdRequest();
                if (params.isEmpty()) {
                    shopIdRequest.setShopId(56);
                    params.clear();
                    params.add(shopIdRequest);
                } else {
                    shopIdRequest = (GetShopIdRequest) params.get(0);
                }
                mModel.getShopInfo(shopIdRequest, new IAsyncResultCallback<GetShopIdResponse>() {
                    @Override
                    public void onComplete(GetShopIdResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("获取店铺信息");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "goodsDeatailInfo");

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
