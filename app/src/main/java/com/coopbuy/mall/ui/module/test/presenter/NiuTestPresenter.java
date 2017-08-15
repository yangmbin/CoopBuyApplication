package com.coopbuy.mall.ui.module.test.presenter;

import android.content.Context;

import com.coopbuy.mall.api.classify.CategorysResponse;
import com.coopbuy.mall.api.login.*;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.test.model.NiuTestModel;
import com.coopbuy.mall.ui.module.test.view.NiuTest_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.google.gson.Gson;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

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
    private IAsyncRequestState state;

    public NiuTestPresenter(Context mContext, NiuTestModel mModel, NiuTest_IView mView) {
        super(mContext, mModel, mView);
    }

    public void cancel() {
        state.cancel();
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
                GetOrderListRequest getOrderListRequest = new GetOrderListRequest();
                if (params.isEmpty()) {
                    getOrderListRequest.setCurrentPage(2);
                    params.clear();
                    params.add(getOrderListRequest);
                } else {
                    getOrderListRequest = (GetOrderListRequest) params.get(0);
                }
                mModel.getOrderAllList(getOrderListRequest, new IAsyncResultCallback<GetOrderListResponse>() {
                    @Override
                    public void onComplete(GetOrderListResponse categorysResponses, Object userState) {
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
                GetOrderListRequest waitOrderList = new GetOrderListRequest();
                if (params.isEmpty()) {
                    waitOrderList.setCurrentPage(1);
                    params.clear();
                    params.add(waitOrderList);
                } else {
                    waitOrderList = (GetOrderListRequest) params.get(0);
                }
                mModel.getOrderListWaitForPayment(waitOrderList, new IAsyncResultCallback<GetOrderListResponse>() {
                    @Override
                    public void onComplete(GetOrderListResponse categorysResponses, Object userState) {
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
                GetOrderListRequest waitDispatch = new GetOrderListRequest();
                if (params.isEmpty()) {
                    waitDispatch.setCurrentPage(1);
                    params.clear();
                    params.add(waitDispatch);
                } else {
                    waitDispatch = (GetOrderListRequest) params.get(0);
                }
                mModel.getOrderListWaitForDispatch(waitDispatch, new IAsyncResultCallback<GetOrderListResponse>() {
                    @Override
                    public void onComplete(GetOrderListResponse categorysResponses, Object userState) {
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
                GetOrderListRequest waitReceive = new GetOrderListRequest();
                if (params.isEmpty()) {
                    waitReceive.setCurrentPage(1);
                    params.clear();
                    params.add(waitReceive);
                } else {
                    waitReceive = (GetOrderListRequest) params.get(0);
                }
                mModel.getOrderListWaitForReceive(waitReceive, new IAsyncResultCallback<GetOrderListResponse>() {
                    @Override
                    public void onComplete(GetOrderListResponse categorysResponses, Object userState) {
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
                GetOrderListRequest waitComment = new GetOrderListRequest();
                if (params.isEmpty()) {
                    waitComment.setCurrentPage(1);
                    params.clear();
                    params.add(waitComment);
                } else {
                    waitComment = (GetOrderListRequest) params.get(0);
                }

                mModel.getOrderListWaitForComment(waitComment, new IAsyncResultCallback<GetOrderListResponse>() {
                    @Override
                    public void onComplete(GetOrderListResponse categorysResponses, Object userState) {
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
                mModel.getHelpCenter(helpCenterContentRequest, new IAsyncResultCallback<GetHeplCenterContentResponse>() {
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
            case "获取活动页面N":

                mModel.getActivePageDataById(new IAsyncResultCallback<List<GetActivePageDataResponse>>() {
                    @Override
                    public void onComplete(List<GetActivePageDataResponse> categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("获取活动页面N");
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
            case "获取sku库N":
                GetSkuStockRequest getSkuStockRequest = new GetSkuStockRequest();
                if (params.isEmpty()) {
                    getSkuStockRequest.setId("20299");
                    params.clear();
                    params.add(getSkuStockRequest);
                } else {
                    getSkuStockRequest = (GetSkuStockRequest) params.get(0);
                }
                mModel.getSkuStock(getSkuStockRequest, new IAsyncResultCallback<GetSkuStockResponse>() {
                    @Override
                    public void onComplete(GetSkuStockResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("获取sku库N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "getSkuStock");
                break;

            case "设置用户头像N":
                //这是是上次头像 等回来再说
                ToastUtils.toastShort("开发中 这个需要图片上传的");
                break;
            case "添加商品评论N":
                AddGoodsCommentRequest addGoodsCommentRequest = new AddGoodsCommentRequest();
                if (params.isEmpty()) {

                    params.clear();
                    params.add(addGoodsCommentRequest);
                } else {
                    addGoodsCommentRequest = (AddGoodsCommentRequest) params.get(0);
                }
                ToastUtils.toastShort("后续开发 参数不明");
                mView.stopAll();
                mModel.addGoodsComment(addGoodsCommentRequest, new IAsyncResultCallback<AddGoodsCommentResponse>() {
                    @Override
                    public void onComplete(AddGoodsCommentResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("添加商品评论N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "addGoodsComment");
                break;
            case "通过商品id得到评论列表N":
                GetGoodsCommentListRequest getGoodsCommentListRequest = new GetGoodsCommentListRequest();
                if (params.isEmpty()) {
                    getGoodsCommentListRequest.setCurrentPage(1);
                    getGoodsCommentListRequest.setProductId(1989);
                    params.clear();
                    params.add(getGoodsCommentListRequest);
                } else {
                    getGoodsCommentListRequest = (GetGoodsCommentListRequest) params.get(0);
                }
                ToastUtils.toastShort(" 参数不明 自行测试");
                mModel.getGoodsCommentList(getGoodsCommentListRequest, new IAsyncResultCallback<GetGoodsCommentListResponse>() {
                    @Override
                    public void onComplete(GetGoodsCommentListResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("通过商品id得到评论列表N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "addGoodsComment");
                break;
            case "追加评论N":
                AppendCommentRequest appendCommentRequest = new AppendCommentRequest();
                if (params.isEmpty()) {

                    params.clear();
                    params.add(appendCommentRequest);
                } else {
                    appendCommentRequest = (AppendCommentRequest) params.get(0);
                }
                ToastUtils.toastShort(" 参数不明 自行测试");
                mModel.appendComment(appendCommentRequest, new IAsyncResultCallback<AppendCommentResponse>() {
                    @Override
                    public void onComplete(AppendCommentResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("追加评论N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "addGoodsComment");
                break;
            case "银行卡列表N":
                mModel.bankCardList(new IAsyncResultCallback<List<BankCardListResponse>>() {
                    @Override
                    public void onComplete(List<BankCardListResponse> categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("银行卡列表N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "bankCardList");
                break;
            case "银行卡绑定申请N":
                BankCardBindApplyRequest bankCardBindApplyRequest = new BankCardBindApplyRequest();
                if (params.isEmpty()) {
                    params.clear();
                    params.add(bankCardBindApplyRequest);
                } else {
                    bankCardBindApplyRequest = (BankCardBindApplyRequest) params.get(0);
                }
                ToastUtils.toastShort(" 参数不明 自行测试");
                mModel.bankCardBindApply(bankCardBindApplyRequest, new IAsyncResultCallback<BankCardBindApplyResponse>() {
                    @Override
                    public void onComplete(BankCardBindApplyResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("银行卡绑定申请N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "addGoodsComment");
                break;
            case "银行卡绑定N":
                BankCardBindRequest bankCardBindRequest = new BankCardBindRequest();
                if (params.isEmpty()) {
                    params.clear();
                    params.add(bankCardBindRequest);
                } else {
                    bankCardBindRequest = (BankCardBindRequest) params.get(0);
                }
                ToastUtils.toastShort(" 参数不明 自行测试");
                mModel.bankCardBind(bankCardBindRequest, new IAsyncResultCallback<BankCardBindResponse>() {
                    @Override
                    public void onComplete(BankCardBindResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("银行卡绑定申请N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "addGoodsComment");
                break;
            case "支付应用申请N":
                PayApplyRequest payApplyRequest = new PayApplyRequest();
                if (params.isEmpty()) {
                    params.clear();
                    params.add(payApplyRequest);
                } else {
                    payApplyRequest = (PayApplyRequest) params.get(0);
                }
                ToastUtils.toastShort(" 参数不明 自行添加测试");
                mModel.payApply(payApplyRequest, new IAsyncResultCallback<PayApplyResponse>() {
                    @Override
                    public void onComplete(PayApplyResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("支付应用申请N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "addGoodsComment");
                break;
            case "协议支付N":
                ProtocolRequest protocolRequest = new ProtocolRequest();
                if (params.isEmpty()) {
                    params.clear();
                    params.add(protocolRequest);
                } else {
                    protocolRequest = (ProtocolRequest) params.get(0);
                }
                ToastUtils.toastShort(" 参数不明 自行添加测试");
                mModel.protocolPay(protocolRequest, new IAsyncResultCallback<ProtocolResponse>() {
                    @Override
                    public void onComplete(ProtocolResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("协议支付N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "addGoodsComment");
                break;
            case "充值查询N":
                QueryCartRequest queryCartRequest = new QueryCartRequest();
                if (params.isEmpty()) {
                    params.clear();
                    params.add(queryCartRequest);
                } else {
                    queryCartRequest = (QueryCartRequest) params.get(0);
                }
                ToastUtils.toastShort(" 参数不明 自行添加测试");
                mModel.queryCart(queryCartRequest, new IAsyncResultCallback<QueryCartResponse>() {
                    @Override
                    public void onComplete(QueryCartResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("充值查询N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "addGoodsComment");
                break;
            case "订单删除N":
                OrderIdOperateRequest orderDelete = new OrderIdOperateRequest();
                if (params.isEmpty()) {
                    orderDelete.setOrderId("1708074920513052");
                    params.clear();
                    params.add(orderDelete);
                } else {
                    orderDelete = (OrderIdOperateRequest) params.get(0);
                }
                ToastUtils.toastShort(" 参数不明 自行添加测试");
                mModel.orderDelete(orderDelete, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("订单删除N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "addGoodsComment");
                break;
            case "订单取消N":
                OrderIdOperateRequest orderCancel = new OrderIdOperateRequest();
                if (params.isEmpty()) {
                    orderCancel.setOrderId("1708155869174725");
                    params.clear();
                    params.add(orderCancel);
                } else {
                    orderDelete = (OrderIdOperateRequest) params.get(0);
                }
                ToastUtils.toastShort(" 参数不明 自行添加测试");
                mModel.orderCancel(orderCancel, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("订单取消N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "addGoodsComment");
                break;
            case "签收订单N":
                OrderIdOperateRequest orderReceive = new OrderIdOperateRequest();
                if (params.isEmpty()) {
                    orderReceive.setOrderId("自己添加订单号");
                    params.clear();
                    params.add(orderReceive);
                } else {
                    orderReceive = (OrderIdOperateRequest) params.get(0);
                }
                ToastUtils.toastShort(" 参数不明 自行添加测试");
                mModel.receiveOreder(orderReceive, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("签收订单N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "addGoodsComment");
                break;
            case "延迟收货N":
                OrderIdOperateRequest orderDelayed = new OrderIdOperateRequest();
                if (params.isEmpty()) {
                    orderDelayed.setOrderId("自己添加订单号");
                    params.clear();
                    params.add(orderDelayed);
                } else {
                    orderDelayed = (OrderIdOperateRequest) params.get(0);
                }
                ToastUtils.toastShort(" 参数不明 自行添加测试");
                mModel.delayedReceive(orderDelayed, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("延迟收货N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "addGoodsComment");
                break;
            case "获取订单物流信息N":
                OrderIdOperateRequest loginstcs = new OrderIdOperateRequest();
                if (params.isEmpty()) {
                    loginstcs.setOrderId("自己添加订单号");
                    params.clear();
                    params.add(loginstcs);
                } else {
                    loginstcs = (OrderIdOperateRequest) params.get(0);
                }
                ToastUtils.toastShort(" 参数不明 自行添加测试");
                mModel.logisticsInfo(loginstcs, new IAsyncResultCallback<LogisticsInfoResponse>() {
                    @Override
                    public void onComplete(LogisticsInfoResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("获取订单物流信息N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "addGoodsComment");
                break;
            case "新售后申请N":
                NewApplyRequest newApplyRequest = new NewApplyRequest();
                if (params.isEmpty()) {
                    params.clear();
                    params.add(newApplyRequest);
                } else {
                    newApplyRequest = (NewApplyRequest) params.get(0);
                }
                ToastUtils.toastShort(" 参数不明 自行添加测试");
                mModel.newApply(newApplyRequest, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("新售后申请N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "addGoodsComment");
                break;
            case "更改售后申请N":
                UpdateApplyRequest updateApplyRequest = new UpdateApplyRequest();
                if (params.isEmpty()) {
                    params.clear();
                    params.add(updateApplyRequest);
                } else {
                    updateApplyRequest = (UpdateApplyRequest) params.get(0);
                }
                ToastUtils.toastShort(" 参数不明 自行添加测试");
                mModel.updateApply(updateApplyRequest, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("更改售后申请N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "updateApply");
                break;
            case "添加退货信息N":
                NewReturnGoodsRequest newReturnGoodsRequest = new NewReturnGoodsRequest();
                if (params.isEmpty()) {
                    params.clear();
                    params.add(newReturnGoodsRequest);
                } else {
                    newReturnGoodsRequest = (NewReturnGoodsRequest) params.get(0);
                }
                ToastUtils.toastShort(" 参数不明 自行添加测试");
                mModel.newReturnGoods(newReturnGoodsRequest, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("添加退货信息N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "newReturnGoods");
                break;
            case "退款售后列表N":
                RefundListRequest refundListRequest = new RefundListRequest();
                if (params.isEmpty()) {
                    params.clear();
                    params.add(refundListRequest);
                } else {
                    refundListRequest = (RefundListRequest) params.get(0);
                }
                ToastUtils.toastShort(" 参数不明 自行添加测试");
                mModel.refundList(refundListRequest, new IAsyncResultCallback<RefundListResponse>() {
                    @Override
                    public void onComplete(RefundListResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("退款售后列表N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "newReturnGoods");
                break;
            case "退款售后明细N":
                RefundDetailRequest refundDetailRequest = new RefundDetailRequest();
                if (params.isEmpty()) {
                    params.clear();
                    params.add(refundDetailRequest);
                } else {
                    refundDetailRequest = (RefundDetailRequest) params.get(0);
                }
                ToastUtils.toastShort(" 参数不明 自行添加测试");
                mModel.refundDetail(refundDetailRequest, new IAsyncResultCallback<RefundDetailResponse>() {
                    @Override
                    public void onComplete(RefundDetailResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("退款售后明细N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "newReturnGoods");
                break;
            case "退款申请确定N":
                ApplyRefundConfirmRequest applyRefundConfirmRequest = new ApplyRefundConfirmRequest();
                if (params.isEmpty()) {
                    params.clear();
                    params.add(applyRefundConfirmRequest);
                } else {
                    applyRefundConfirmRequest = (ApplyRefundConfirmRequest) params.get(0);
                }
                ToastUtils.toastShort(" 参数不明 自行添加测试");
                mModel.applyRefundConfirm(applyRefundConfirmRequest, new IAsyncResultCallback<ApplyRefundConfirmResponse>() {
                    @Override
                    public void onComplete(ApplyRefundConfirmResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("退款申请确定N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "newReturnGoods");
                break;
            case "获取分类中首条文本内容信息":
                GetFirstTextContentRequest getFirstTextContentRequest = new GetFirstTextContentRequest();
                if (params.isEmpty()) {
                    getFirstTextContentRequest.setCategoryKey("1");
                    params.clear();
                    params.add(getFirstTextContentRequest);
                } else {
                    getFirstTextContentRequest = (GetFirstTextContentRequest) params.get(0);
                }
                ToastUtils.toastShort(" 参数不明 自行添加测试");
                mModel.getFirstTextContent(getFirstTextContentRequest, new IAsyncResultCallback<GetFirstTextContentResponse>() {
                    @Override
                    public void onComplete(GetFirstTextContentResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("获取分类中首条文本内容信息");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "getFirstTextContent");
                break;
            case "站长代付申请N":
                OrderIdOperateRequest orderUserApply = new OrderIdOperateRequest();
                if (params.isEmpty()) {
                    params.clear();
                    params.add(orderUserApply);
                } else {
                    orderUserApply = (OrderIdOperateRequest) params.get(0);
                }
                ToastUtils.toastShort(" 参数不明 自行添加测试");
                mModel.userApply(orderUserApply, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("站长代付申请N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "getFirstTextContent");
                break;
            case "拒绝代付N":
                RefuseApplyRequest refuseApplyRequest = new RefuseApplyRequest();
                if (params.isEmpty()) {
                    params.clear();
                    params.add(refuseApplyRequest);
                } else {
                    refuseApplyRequest = (RefuseApplyRequest) params.get(0);
                }
                ToastUtils.toastShort("参数不明 自行添加测试");
                mModel.refuseApply(refuseApplyRequest, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("拒绝代付N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "getFirstTextContent");
                break;
            case "代付款得到申请列表N":
                WaitPayOrderApplyListRequest waitPayOrderApplyListRequest = new WaitPayOrderApplyListRequest();
                if (params.isEmpty()) {
                    waitPayOrderApplyListRequest.setCurrentPage(1);
                    params.clear();
                    params.add(waitPayOrderApplyListRequest);
                } else {
                    waitPayOrderApplyListRequest = (WaitPayOrderApplyListRequest) params.get(0);
                }
                ToastUtils.toastShort("参数不明 自行添加测试");
                mModel.waitPayOrderApplyList(waitPayOrderApplyListRequest, new IAsyncResultCallback<WaitPayOrderApplyListResponse>() {
                    @Override
                    public void onComplete(WaitPayOrderApplyListResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("代付款得到申请列表N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "getFirstTextContent");
                break;
            case "获取申请详细信息N":
                OperateIdRequest operateIdRequest = new OperateIdRequest();
                if (params.isEmpty()) {
                    params.clear();
                    params.add(operateIdRequest);
                } else {
                    operateIdRequest = (OperateIdRequest) params.get(0);
                }
                ToastUtils.toastShort("参数不明 自行添加测试");
                mModel.payApplyDetail(operateIdRequest, new IAsyncResultCallback<PayApplyDetailResponse>() {
                    @Override
                    public void onComplete(PayApplyDetailResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("代付款得到申请列表N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "getFirstTextContent");
                break;
            case "待处理代付数量获取N":
                mModel.payApplyQuantity(new IAsyncResultCallback<PayApplyQuantityResponse>() {
                    @Override
                    public void onComplete(PayApplyQuantityResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("待处理代付数量获取N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "getFirstTextContent");
                break;
            case "用户收货相关信息，若存在记录则进行收货信息更新N":
                BindToStationRequest bindToStationRequest = new BindToStationRequest();
                if (params.isEmpty()) {
                    params.clear();
                    params.add(bindToStationRequest);
                } else {
                    bindToStationRequest = (BindToStationRequest) params.get(0);
                }
                ToastUtils.toastShort("参数不明 自行添加测试");
                mModel.bindToStation(bindToStationRequest, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("用户收货相关信息，若存在记录则进行收货信息更新N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "getFirstTextContent");
                break;
            case "站点用户获取我的站点信息N":
                mModel.getMyStationInfo(new IAsyncResultCallback<GetMyStationInfoResponse>() {
                    @Override
                    public void onComplete(GetMyStationInfoResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("站点用户获取我的站点信息N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "getFirstTextContent");
                break;
            case "获取当前站长用户所在站点的客户列表N":
                GetStationCustomerListRequest getStationCustomerListRequest = new GetStationCustomerListRequest();
                if (params.isEmpty()) {
                    getStationCustomerListRequest.setCurrentPage(1);
                    getStationCustomerListRequest.setKeyword("");
                    params.clear();
                    params.add(getStationCustomerListRequest);
                } else {
                    getStationCustomerListRequest = (GetStationCustomerListRequest) params.get(0);
                }
                ToastUtils.toastShort("参数不明 自行添加测试");
                mModel.getStationCustomerList(getStationCustomerListRequest, new IAsyncResultCallback<GetStationCustomerListResponse>() {
                    @Override
                    public void onComplete(GetStationCustomerListResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("用户收货相关信息，若存在记录则进行收货信息更新N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "getFirstTextContent");
                break;

            case "站点用户添加站点客户N":
                OperateIdRequest idCustomer = new OperateIdRequest();
                if (params.isEmpty()) {
                    params.clear();
                    params.add(idCustomer);
                } else {
                    idCustomer = (OperateIdRequest) params.get(0);
                }
                ToastUtils.toastShort("参数不明 自行添加测试");
                mModel.getStationCustomer(idCustomer, new IAsyncResultCallback<GetStationCustomerResponse>() {
                    @Override
                    public void onComplete(GetStationCustomerResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("获取站点客户信息N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "getFirstTextContent");
                break;
            case "获取站点客户信息N":
                AddNewStationCustomerRequest addNewStationCustomerRequest = new AddNewStationCustomerRequest();
                if (params.isEmpty()) {
                    addNewStationCustomerRequest.setAddress("niuniuniu");
                    addNewStationCustomerRequest.setCustomerName("牛牛");
                    addNewStationCustomerRequest.setMobilePhone("13567867654");
                    params.clear();
                    params.add(addNewStationCustomerRequest);
                } else {
                    addNewStationCustomerRequest = (AddNewStationCustomerRequest) params.get(0);
                }
                mModel.addNewStationCustomer(addNewStationCustomerRequest, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("获取站点客户信息N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "getFirstTextContent");
                break;
            case "更新站点客户信息N":
                UpdateStationCustomerRequest updateStationCustomerRequest = new UpdateStationCustomerRequest();
                if (params.isEmpty()) {
                    updateStationCustomerRequest.setSiteId(2695);
                    updateStationCustomerRequest.setCustomerName("NIU NIU");
                    updateStationCustomerRequest.setMobilePhone("1354454567654");
                    updateStationCustomerRequest.setAddress("更新");
                    updateStationCustomerRequest.setRegionId(1);
                    updateStationCustomerRequest.setRegionPath("贵州省,贵阳市,观山湖区,测试区,测试站点");
                    updateStationCustomerRequest.setSiteName("测试站点01");
                    updateStationCustomerRequest.setId(2888);
                    params.clear();
                    params.add(updateStationCustomerRequest);
                } else {
                    updateStationCustomerRequest = (UpdateStationCustomerRequest) params.get(0);
                }

                mModel.updateStationCustomer(updateStationCustomerRequest, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("更新站点客户信息N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "getFirstTextContent");
                break;
            case "添加商品至站长推荐N":
                AddRecommendRequest addRecommendRequest = new AddRecommendRequest();
                if (params.isEmpty()) {
                    params.clear();
                    params.add(addRecommendRequest);
                } else {
                    addRecommendRequest = (AddRecommendRequest) params.get(0);
                }
                ToastUtils.toastShort("参数不明 自行添加测试");
                mModel.addRecommend(addRecommendRequest, new IAsyncResultCallback<OperateSuccessResponse>() {
                    @Override
                    public void onComplete(OperateSuccessResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("添加商品至站长推荐N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "getFirstTextContent");
                break;
            case "得到站点信息和站点联系人信息N":
                GetStationCodeItemRequest getStationCodeItemRequest = new GetStationCodeItemRequest();
                if (params.isEmpty()) {
                    params.clear();
                    params.add(getStationCodeItemRequest);
                } else {
                    getStationCodeItemRequest = (GetStationCodeItemRequest) params.get(0);
                }
                ToastUtils.toastShort("参数不明 自行添加测试");
                mModel.getStationCodeItem(getStationCodeItemRequest, new IAsyncResultCallback<GetStationCodeItemResponse>() {
                    @Override
                    public void onComplete(GetStationCodeItemResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("得到站点信息和站点联系人信息N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "getFirstTextContent");
                break;
            case "站长客户订单列表N":
                StationListRequest stationListRequest = new StationListRequest();
                if (params.isEmpty()) {
                    stationListRequest.setCurrentPage(1);
                    params.clear();
                    params.add(stationListRequest);
                } else {
                    stationListRequest = (StationListRequest) params.get(0);
                }
                ToastUtils.toastShort("参数不明 自行添加测试");
                mModel.stationList(stationListRequest, new IAsyncResultCallback<StationListResponse>() {
                    @Override
                    public void onComplete(StationListResponse categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("站长客户订单列表N");
                            mView.stopAll();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail() + error.getMessage());
                        mView.stopAll();
                    }
                }, "getFirstTextContent");
                break;
            default:
                break;
        }
    }
}
