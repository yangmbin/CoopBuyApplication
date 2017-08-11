package com.coopbuy.mall.ui.module.test.presenter;

import android.content.Context;

import com.coopbuy.mall.api.classify.CategorysResponse;
import com.coopbuy.mall.api.login.AddGoodsRequest;
import com.coopbuy.mall.api.login.AppNewVersionResponse;
import com.coopbuy.mall.api.login.CartListResponse;
import com.coopbuy.mall.api.login.CreateMobileOrderRequest;
import com.coopbuy.mall.api.login.CreateMobileOrderResponse;
import com.coopbuy.mall.api.login.CreateShipAddressRequest;
import com.coopbuy.mall.api.login.DeleteShipAddressRequest;
import com.coopbuy.mall.api.login.GetDefaultAddressResponse;
import com.coopbuy.mall.api.login.GetGoodsFreightRequest;
import com.coopbuy.mall.api.login.GetGoodsFreightResponse;
import com.coopbuy.mall.api.login.GetHelpCenterContentRequest;
import com.coopbuy.mall.api.login.GetHeplCenterContentResponse;
import com.coopbuy.mall.api.login.GetMemberInfoResponse;
import com.coopbuy.mall.api.login.GetNewCommentRequest;
import com.coopbuy.mall.api.login.GetNewCommentResponse;
import com.coopbuy.mall.api.login.GetOrderAllListRequest;
import com.coopbuy.mall.api.login.GetOrderAllListResponse;
import com.coopbuy.mall.api.login.GetOrderQuantityResponse;
import com.coopbuy.mall.api.login.GetShopIdRequest;
import com.coopbuy.mall.api.login.GetShopIdResponse;
import com.coopbuy.mall.api.login.GetStationRecommendResponse;
import com.coopbuy.mall.api.login.GetTextCOntentResponse;
import com.coopbuy.mall.api.login.GetTextContentRequest;
import com.coopbuy.mall.api.login.GoodsDetailDescResponse;
import com.coopbuy.mall.api.login.GoodsDetailInfoResponse;
import com.coopbuy.mall.api.login.GoodsDetailRequest;
import com.coopbuy.mall.api.login.HomePageDataByIdRequest;
import com.coopbuy.mall.api.login.HomePageDataByIdResponse;
import com.coopbuy.mall.api.login.HomePageDataRequest;
import com.coopbuy.mall.api.login.HomePageDataResponse;
import com.coopbuy.mall.api.login.ImageCodeRequest;
import com.coopbuy.mall.api.login.ImageCodeResponse;
import com.coopbuy.mall.api.login.LoginQuitRespsonse;
import com.coopbuy.mall.api.login.LoginRequest;
import com.coopbuy.mall.api.login.LoginResponse;
import com.coopbuy.mall.api.login.MobifyMemberRequest;
import com.coopbuy.mall.api.login.MobifyOrderPayConfirmRequest;
import com.coopbuy.mall.api.login.MobifyOrderPayConfirmResponse;
import com.coopbuy.mall.api.login.MobifyShipAddressRequest;
import com.coopbuy.mall.api.login.MobileOrderListResponse;
import com.coopbuy.mall.api.login.NetOrderRequest;
import com.coopbuy.mall.api.login.NetOrderResponse;
import com.coopbuy.mall.api.login.NewUserGoodsOrderRequest;
import com.coopbuy.mall.api.login.NewUserGoodsOrderresponse;
import com.coopbuy.mall.api.login.OperateSuccessResponse;
import com.coopbuy.mall.api.login.OrderConfirmRequest;
import com.coopbuy.mall.api.login.OrderConfirmResponse;
import com.coopbuy.mall.api.login.OrderDetailRequest;
import com.coopbuy.mall.api.login.OrderDetailResponse;
import com.coopbuy.mall.api.login.OrderFreightRequest;
import com.coopbuy.mall.api.login.OrderFreightResponse;
import com.coopbuy.mall.api.login.PayApplyAndChannelRequest;
import com.coopbuy.mall.api.login.PayApplyAndChannelResponse;
import com.coopbuy.mall.api.login.PostSuggestRequest;
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
                    homePageDataByIdRequest.setPageId("4");
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
                ToastUtils.toastShort("由于服务器问题 请查看log日志");
                mView.stopAll();
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
                ToastUtils.toastShort("由于服务器问题 请查看log日志");
                mView.stopAll();
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
                ToastUtils.toastShort("由于服务器问题 请查看log日志操作反馈");
                mView.stopAll();
                mModel.mobifyShipAddress(mobifyShipAddressRequest, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("修改收货地址");
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
                ToastUtils.toastShort("由于服务器问题 请查看log日志");
                mView.stopAll();
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
                List<AddGoodsRequest.GoodsBean> data = new ArrayList<>();
                if (params.isEmpty()) {
                    AddGoodsRequest.GoodsBean bean = new AddGoodsRequest.GoodsBean();
                    bean.setQuantity(2);
                    bean.setSkuId(2776);
                    data.add(bean);
                    addGoodsRequest.setGoods(data);
                    params.clear();
                    params.add(bean);
                    ToastUtils.toastLong("请根据具体商品添加");
                } else {
                    AddGoodsRequest.GoodsBean bean = (AddGoodsRequest.GoodsBean) params.get(0);
                    data.add(bean);
                    addGoodsRequest.setGoods(data);
                }
                ToastUtils.toastShort("由于服务器问题 请查看log日志");
                mView.stopAll();
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
                ToastUtils.toastShort("由于服务器问题 请查看log日志");
                mView.stopAll();
                mModel.updateGoodsQuantity(updateGoods, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("购物车商品数量更新");
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

                    List<Integer> da = new ArrayList<>();
                    da.add(2776);
                    removeGoodsRequest.setSkuId(da);
                    ToastUtils.toastLong("请根据具体商品删除");
                    params.clear();
                    params.add(removeGoodsRequest);
                } else {
                    removeGoodsRequest = (RemoveGoodsRequest) params.get(0);
                }
                ToastUtils.toastShort("由于服务器问题 请查看log日志");
                mView.stopAll();
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
                List<OrderConfirmRequest.SkusBean> d1 = new ArrayList<>();
                OrderConfirmRequest orderConfirmRequest = new OrderConfirmRequest();
                if (params.isEmpty()) {

                    OrderConfirmRequest.SkusBean bean = new OrderConfirmRequest.SkusBean();
                    bean.setSkuId(2776);
                    bean.setQuantity(1);
                    d1.add(bean);
                    orderConfirmRequest.setSkus(d1);
                    params.clear();
                    params.add(bean);
                } else {
                    OrderConfirmRequest.SkusBean bean = (OrderConfirmRequest.SkusBean) params.get(0);
                    d1.add(bean);
                    orderConfirmRequest.setSkus(d1);
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
                List<OrderFreightRequest.SkuItemsBean> d2 = new ArrayList<>();
                if (params.isEmpty()) {

                    OrderFreightRequest.SkuItemsBean bean = new OrderFreightRequest.SkuItemsBean();
                    bean.setQuantity(1);
                    bean.setSkuId(2776);
                    d2.add(bean);
                    orderFreightRequest.setRegionId("110102010001");
                    orderFreightRequest.setSkuItems(d2);
                    params.clear();
                    params.add(bean);
                } else {
                    OrderFreightRequest.SkuItemsBean bean = (OrderFreightRequest.SkuItemsBean) params.get(0);
                    d2.add(bean);
                    orderFreightRequest.setSkuItems(d2);
                    orderFreightRequest.setRegionId("110102010001");
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
                List<NewUserGoodsOrderRequest.SkusBean> d3 = new ArrayList<>();
                if (params.isEmpty()) {

                    NewUserGoodsOrderRequest.SkusBean bean = new NewUserGoodsOrderRequest.SkusBean();
                    bean.setQuantity(1);
                    bean.setSkuId(2776);
                    d3.add(bean);
                    newUserGoodsOrderRequest.setSkus(d3);
                    params.clear();
                    params.add(bean);
                } else {
                    NewUserGoodsOrderRequest.SkusBean bean = (NewUserGoodsOrderRequest.SkusBean) params.get(0);
                    d3.add(bean);
                    newUserGoodsOrderRequest.setSkus(d3);
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
                GetNewCommentRequest getNewCommentRequest = new GetNewCommentRequest();
                if (params.isEmpty()) {
                    getNewCommentRequest.setId("2354");
                    params.clear();
                    params.add(getNewCommentRequest);
                } else {
                    getNewCommentRequest = (GetNewCommentRequest) params.get(0);
                }
                mModel.getNetComment(getNewCommentRequest, new IAsyncResultCallback<GetNewCommentResponse>() {
                    @Override
                    public void onComplete(GetNewCommentResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("得到最新评论");
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
            case "单个商品运费":
                GetGoodsFreightRequest getGoodsFreightRequest = new GetGoodsFreightRequest();
                if (params.isEmpty()) {
                    getGoodsFreightRequest.setGoodsId(2354);
                    getGoodsFreightRequest.setRegionId("110102010001");
                    params.clear();
                    params.add(getGoodsFreightRequest);
                } else {
                    getGoodsFreightRequest = (GetGoodsFreightRequest) params.get(0);
                }
                mModel.getGoodsFreight(getGoodsFreightRequest, new IAsyncResultCallback<GetGoodsFreightResponse>() {
                    @Override
                    public void onComplete(GetGoodsFreightResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("单个商品运费");
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
            case "App更新":
                mModel.getAppNewVersion(new IAsyncResultCallback<AppNewVersionResponse>() {
                    @Override
                    public void onComplete(AppNewVersionResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("App更新");
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

            case "电话 充值  的列表":
                mModel.getMobileOrderList(new IAsyncResultCallback<MobileOrderListResponse>() {
                    @Override
                    public void onComplete(MobileOrderListResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("电话 充值  的列表");
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
            case "创建话费订单":
                CreateMobileOrderRequest createMobileOrderRequest = new CreateMobileOrderRequest();
                if (params.isEmpty()) {
                    createMobileOrderRequest.setCartId("10");
                    createMobileOrderRequest.setPhone("18286882993");
                    params.clear();
                    params.add(createMobileOrderRequest);
                } else {
                    createMobileOrderRequest = (CreateMobileOrderRequest) params.get(0);
                }
                mModel.createMobileOrder(createMobileOrderRequest, new IAsyncResultCallback<CreateMobileOrderResponse>() {
                    @Override
                    public void onComplete(CreateMobileOrderResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("话费充值");
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

            case "支付通道申请":
                PayApplyAndChannelRequest payApplyAndChannelRequest = new PayApplyAndChannelRequest();
                if (params.isEmpty()) {
                    payApplyAndChannelRequest.setChannelId("AliPay.APP");
                    payApplyAndChannelRequest.setOrderId("根据上面的订单创建的订单号");
                    params.clear();
                    params.add(payApplyAndChannelRequest);
                } else {
                    payApplyAndChannelRequest = (PayApplyAndChannelRequest) params.get(0);
                }
                ToastUtils.toastShort("由于实际问题 查看参数");
                mView.stopAll();
                mModel.getPayApplyAndChannel(payApplyAndChannelRequest, new IAsyncResultCallback<PayApplyAndChannelResponse>() {
                    @Override
                    public void onComplete(PayApplyAndChannelResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("支付通道申请");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "getPayApplyAndChannel");
                break;
            case "电话订单确认":
                MobifyOrderPayConfirmRequest mobifyOrderPayConfirmRequest = new MobifyOrderPayConfirmRequest();
                if (params.isEmpty()) {
                    mobifyOrderPayConfirmRequest.setOrderId("根据上面的订单创建的订单号");
                    params.clear();
                    params.add(mobifyOrderPayConfirmRequest);
                } else {
                    mobifyOrderPayConfirmRequest = (MobifyOrderPayConfirmRequest) params.get(0);
                }
                ToastUtils.toastShort("由于实际问题 查看参数");
                mView.stopAll();
                mModel.mobifyOrderPayComfirm(mobifyOrderPayConfirmRequest, new IAsyncResultCallback<MobifyOrderPayConfirmResponse>() {
                    @Override
                    public void onComplete(MobifyOrderPayConfirmResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("电话订单确认");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "mobifyOrderPayComfirm");
                break;

            case "获取各订单数量":
                mModel.getOrderQuantityNumber(new IAsyncResultCallback<GetOrderQuantityResponse>() {
                    @Override
                    public void onComplete(GetOrderQuantityResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("获取各订单数量");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "getOrderQuantityNumber");

                break;
            case "订单列表":
                GetOrderAllListRequest getOrderAllListRequest = new GetOrderAllListRequest();
                if (params.isEmpty()) {
                    getOrderAllListRequest.setCurrentPage(2);
                    params.clear();
                    params.add(getOrderAllListRequest);
                } else {
                    getOrderAllListRequest = (GetOrderAllListRequest) params.get(0);
                }
                mModel.getOrderAllList(getOrderAllListRequest, new IAsyncResultCallback<GetOrderAllListResponse>() {
                    @Override
                    public void onComplete(GetOrderAllListResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("订单列表");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "mobifyOrderPayComfirm");
                break;
            case "代付款订单":
                GetOrderAllListRequest waitOrderList = new GetOrderAllListRequest();
                if (params.isEmpty()) {
                    waitOrderList.setCurrentPage(1);
                    params.clear();
                    params.add(waitOrderList);
                } else {
                    waitOrderList = (GetOrderAllListRequest) params.get(0);
                }
                mModel.getOrderListWaitForPayment(waitOrderList, new IAsyncResultCallback<GetOrderAllListResponse>() {

                    @Override
                    public void onComplete(GetOrderAllListResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("订单列表");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "mobifyOrderPayComfirm");
                break;
            case "待发货":
                GetOrderAllListRequest waitDispatch = new GetOrderAllListRequest();
                if (params.isEmpty()) {
                    waitDispatch.setCurrentPage(1);
                    params.clear();
                    params.add(waitDispatch);
                } else {
                    waitDispatch = (GetOrderAllListRequest) params.get(0);
                }
                mModel.getOrderListWaitForDispatch(waitDispatch, new IAsyncResultCallback<GetOrderAllListResponse>() {
                    @Override
                    public void onComplete(GetOrderAllListResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("待发货");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "mobifyOrderPayComfirm");
                break;
            case "待收货":
                GetOrderAllListRequest waitReceive = new GetOrderAllListRequest();
                if (params.isEmpty()) {
                    waitReceive.setCurrentPage(1);
                    params.clear();
                    params.add(waitReceive);
                } else {
                    waitReceive = (GetOrderAllListRequest) params.get(0);
                }
                mModel.getOrderListWaitForReceive(waitReceive, new IAsyncResultCallback<GetOrderAllListResponse>() {
                    @Override
                    public void onComplete(GetOrderAllListResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("待收货");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "mobifyOrderPayComfirm");
                break;
            case "待评价":
                GetOrderAllListRequest waitComment = new GetOrderAllListRequest();
                if (params.isEmpty()) {
                    waitComment.setCurrentPage(1);
                    params.clear();
                    params.add(waitComment);
                } else {
                    waitComment = (GetOrderAllListRequest) params.get(0);
                }

                mModel.getOrderListWaitForComment(waitComment, new IAsyncResultCallback<GetOrderAllListResponse>() {
                    @Override
                    public void onComplete(GetOrderAllListResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("待评价");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "mobifyOrderPayComfirm");
                break;
            case "订单详情":
                OrderDetailRequest orderDetail = new OrderDetailRequest();
                if (params.isEmpty()) {
                    orderDetail.setOrderId("1708107148180227");
                    params.clear();
                    params.add(orderDetail);
                } else {
                    orderDetail = (OrderDetailRequest) params.get(0);
                }
                mModel.getOrderDetail(orderDetail, new IAsyncResultCallback<OrderDetailResponse>() {
                    @Override
                    public void onComplete(OrderDetailResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("待评价");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "mobifyOrderPayComfirm");
                break;
            case "帮助中心":
                GetHelpCenterContentRequest helpCenterContentRequest = new GetHelpCenterContentRequest();
                if (params.isEmpty()) {
                    helpCenterContentRequest.setCurrentPage(1);
                    helpCenterContentRequest.setCategoryKey("HelpCenter");
                    params.clear();
                    params.add(helpCenterContentRequest);
                } else {
                    helpCenterContentRequest = (GetHelpCenterContentRequest) params.get(0);
                }
                mModel.getHeplCenter(helpCenterContentRequest, new IAsyncResultCallback<GetHeplCenterContentResponse>() {
                    @Override
                    public void onComplete(GetHeplCenterContentResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("待评价");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "mobifyOrderPayComfirm");
                break;
            case "退货流程":
                GetTextContentRequest getTextContentRequest = new GetTextContentRequest();
                if (params.isEmpty()) {
                    getTextContentRequest.setId(2);
                    params.clear();
                    params.add(getTextContentRequest);
                } else {
                    getTextContentRequest = (GetTextContentRequest) params.get(0);
                }
                mModel.getTextContent(getTextContentRequest, new IAsyncResultCallback<GetTextCOntentResponse>() {
                    @Override
                    public void onComplete(GetTextCOntentResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("退货流程");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "mobifyOrderPayComfirm");
                break;
            case "网站订单":
                NetOrderRequest netOrderRequest = new NetOrderRequest();
                if (params.isEmpty()) {
                    netOrderRequest.setCurrentPage(1);
                    params.clear();
                    params.add(netOrderRequest);
                } else {
                    netOrderRequest = (NetOrderRequest) params.get(0);
                }
                mModel.getNetOrder(netOrderRequest, new IAsyncResultCallback<NetOrderResponse>() {
                    @Override
                    public void onComplete(NetOrderResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("网站订单");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "mobifyOrderPayComfirm");
                break;

            case "获取用户信息":

                mModel.getMemberInfo(new IAsyncResultCallback<GetMemberInfoResponse>() {
                    @Override
                    public void onComplete(GetMemberInfoResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("获取用户信息");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "mobifyOrderPayComfirm");

                break;
            case "修改用户昵称":
                MobifyMemberRequest mobifyMemberRequest = new MobifyMemberRequest();
                if (params.isEmpty()) {
                    mobifyMemberRequest.setNick("修改昵称");
                    params.clear();
                    params.add(mobifyMemberRequest);
                } else {
                    mobifyMemberRequest = (MobifyMemberRequest) params.get(0);
                }
                ToastUtils.toastShort("由于服务器问题 请查看log日志");
                mView.stopAll();
                mModel.updateMobifyMember(mobifyMemberRequest, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("修改用户昵称");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "mobifyOrderPayComfirm");
                break;
            case "修改性别":
                MobifyMemberRequest updateSex = new MobifyMemberRequest();
                if (params.isEmpty()) {
                    updateSex.setSex(2);
                    params.clear();
                    params.add(updateSex);
                } else {
                    updateSex = (MobifyMemberRequest) params.get(0);
                }
                ToastUtils.toastShort("由于服务器问题 请查看log日志");
                mView.stopAll();
                mModel.updateMobifyMember(updateSex, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("修改性别");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "mobifyOrderPayComfirm");
                break;
            case "意见反馈":
                PostSuggestRequest suggestRequest = new PostSuggestRequest();
                if (params.isEmpty()) {
                    suggestRequest.setSuggestContent("开发测试");
                    params.clear();
                    params.add(suggestRequest);
                } else {
                    suggestRequest = (PostSuggestRequest) params.get(0);
                }
                ToastUtils.toastShort("由于服务器问题 请查看log日志");
                mView.stopAll();
                mModel.postSuggest(suggestRequest, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("意见反馈");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "mobifyOrderPayComfirm");
                break;
            default:
                break;
        }
    }
}
