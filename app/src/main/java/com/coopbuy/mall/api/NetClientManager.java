package com.coopbuy.mall.api;

import com.coopbuy.mall.api.reponse.AddressInfoResponse;
import com.coopbuy.mall.api.reponse.AddressTownResponse;
import com.coopbuy.mall.api.reponse.AfterSalesDetailResponse;
import com.coopbuy.mall.api.reponse.AfterSalesResponse;
import com.coopbuy.mall.api.reponse.AreaDataResponse;
import com.coopbuy.mall.api.reponse.BeforeApplyRefundResponse;
import com.coopbuy.mall.api.reponse.CalculateFreightResponse;
import com.coopbuy.mall.api.reponse.CategoryResponse;
import com.coopbuy.mall.api.reponse.ChangeAndForgetPwdResponse;
import com.coopbuy.mall.api.reponse.CheckPhoneReponse;
import com.coopbuy.mall.api.reponse.CollectResponse;
import com.coopbuy.mall.api.reponse.DefaultAddressResponse;
import com.coopbuy.mall.api.reponse.DescriptionResponse;
import com.coopbuy.mall.api.reponse.ExpressInfoResponse;
import com.coopbuy.mall.api.reponse.FootMarkResponse;
import com.coopbuy.mall.api.reponse.GetBindStationReponse;
import com.coopbuy.mall.api.reponse.GetCartQuantityResponse;
import com.coopbuy.mall.api.reponse.GoodsUpdateResponse;
import com.coopbuy.mall.api.reponse.HomePageDataByIdResponse;
import com.coopbuy.mall.api.reponse.HomePageDataResponse;
import com.coopbuy.mall.api.reponse.LoginResponse;
import com.coopbuy.mall.api.reponse.OrderBuildResponse;
import com.coopbuy.mall.api.reponse.OrderDetailResponse;
import com.coopbuy.mall.api.reponse.OrderListResponse;
import com.coopbuy.mall.api.reponse.OrderPayApplyResponse;
import com.coopbuy.mall.api.reponse.OrderSubmitResponse;
import com.coopbuy.mall.api.reponse.PhoneRechargeListReponse;
import com.coopbuy.mall.api.reponse.RegisterResponse;
import com.coopbuy.mall.api.reponse.SMSCodeReponse;
import com.coopbuy.mall.api.reponse.ShippingCompanyResponse;
import com.coopbuy.mall.api.reponse.ShopCartResponse;
import com.coopbuy.mall.api.reponse.ShopStoreReponse;
import com.coopbuy.mall.api.reponse.SkuDetailResponse;
import com.coopbuy.mall.api.reponse.SkuInfoResponse;
import com.coopbuy.mall.api.reponse.TradeChannelResponse;
import com.coopbuy.mall.api.reponse.UploadImageResponse;
import com.coopbuy.mall.api.reponse.UserCenterInfoResponse;
import com.coopbuy.mall.api.request.AddAddressRequest;
import com.coopbuy.mall.api.request.AddToCartRequest;
import com.coopbuy.mall.api.request.AfterSalesDetailRequest;
import com.coopbuy.mall.api.request.ApplyRefundAllRequest;
import com.coopbuy.mall.api.request.ApplyRefundOneRequest;
import com.coopbuy.mall.api.request.ApplyRefundRequest;
import com.coopbuy.mall.api.request.BeforeApplyRefundRequest;
import com.coopbuy.mall.api.request.BuyerSendGoodsRequest;
import com.coopbuy.mall.api.request.CalculateFreightRequest;
import com.coopbuy.mall.api.request.CancelApplyRefundRequest;
import com.coopbuy.mall.api.request.ChangeAndForgetPwdRequest;
import com.coopbuy.mall.api.request.CollectRequest;
import com.coopbuy.mall.api.request.DeleteFootRequest;
import com.coopbuy.mall.api.request.FindSkuInfoRequest;
import com.coopbuy.mall.api.request.GetBindStationRequest;
import com.coopbuy.mall.api.request.GetChildProvincesRequest;
import com.coopbuy.mall.api.request.GoodsDeleteRequest;
import com.coopbuy.mall.api.request.GoodsUpdateRequest;
import com.coopbuy.mall.api.request.HomePageDataByIdRequest;
import com.coopbuy.mall.api.request.HomePageDataRequest;
import com.coopbuy.mall.api.request.ImageCodeRequest;
import com.coopbuy.mall.api.request.LoginRequest;
import com.coopbuy.mall.api.request.MobilePayRequest;
import com.coopbuy.mall.api.request.OrderBuildRequest;
import com.coopbuy.mall.api.request.OrderDetailRequest;
import com.coopbuy.mall.api.request.OrderIdRequest;
import com.coopbuy.mall.api.request.OrderListRequest;
import com.coopbuy.mall.api.request.OrderPayApplyRequest;
import com.coopbuy.mall.api.request.OrderSubmitRequest;
import com.coopbuy.mall.api.request.PageRequest;
import com.coopbuy.mall.api.request.PayListRequest;
import com.coopbuy.mall.api.request.ProductIdRequest;
import com.coopbuy.mall.api.request.PublishProductRequest;
import com.coopbuy.mall.api.request.ReApplyRefundAllRequest;
import com.coopbuy.mall.api.request.ReApplyRefundOneRequest;
import com.coopbuy.mall.api.request.RefundExpressInfoRequest;
import com.coopbuy.mall.api.request.RegisterRequest;
import com.coopbuy.mall.api.request.SetDefaultOrDeleteOrFindAddressRequest;
import com.coopbuy.mall.api.request.ShopCurrentPageRequest;
import com.coopbuy.mall.api.request.ShopSotreCancelRequest;
import com.coopbuy.mall.api.request.SkuDetailRequest;
import com.coopbuy.mall.api.request.SkuIdRequest;
import com.coopbuy.mall.api.request.SuggestRequest;
import com.coopbuy.mall.api.request.UploadImageRequest;
import com.google.gson.reflect.TypeToken;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

import java.util.List;

/**
 * @author csn
 * @date 2017/8/1 0001 14:09
 * @content 这里是登录相关api
 */
public class NetClientManager extends BaseApiClient {
    public NetClientManager() {
        this.setUnitTest(false);
    }

    /**
     * 首页banner图点击进入
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getPageDataById(HomePageDataByIdRequest request, IAsyncResultCallback<HomePageDataByIdResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<HomePageDataByIdResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_PAGE_DATA_BYID, request, callback, userState);
    }

    /**
     * 首页数据
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState homePageData(HomePageDataRequest request, IAsyncResultCallback<HomePageDataResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<HomePageDataResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.HOMO_PAGE_DATA, request, callback, userState);
    }
//    新下行  以前写的没有用了  暂时不删除

    /**
     * 登录
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState login(LoginRequest request, IAsyncResultCallback<LoginResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<LoginResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.LOGIN, request, callback, userState);
    }

    /**
     * 图形验证码
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState imageCode(ImageCodeRequest request, IAsyncResultCallback<String> callback, Object userState) {
        return apiGetRequest(new TypeToken<String>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.IMAGE_CODE, request, callback, userState);
    }

    /**
     * 退出登录
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState quit(IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(Constant.SERVER_URL_NEW + Constant.LOGOUT, callback, userState);
    }

    /**
     * 注册短信验证码
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getSMSCode(ImageCodeRequest request, IAsyncResultCallback<SMSCodeReponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<SMSCodeReponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.SMSCODE, request, callback, userState);
    }

    /**
     * 重置密码的短信
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getSMSCodeUpdate(ImageCodeRequest request, IAsyncResultCallback<SMSCodeReponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<SMSCodeReponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.SMSCODE_UPDATE, request, callback, userState);
    }

    /**
     * 更新 找回密码
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState updatePwd(ChangeAndForgetPwdRequest request, IAsyncResultCallback<ChangeAndForgetPwdResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<ChangeAndForgetPwdResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.UPDATEPASSWORD, request, callback, userState);
    }

    /**
     * 注册
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState register(RegisterRequest request, IAsyncResultCallback<RegisterResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<RegisterResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.REGISTER, request, callback, userState);
    }

    /**
     * 个人中心数据
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getUserInfo(IAsyncResultCallback<UserCenterInfoResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<UserCenterInfoResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.USERCENTERINFO, callback, userState);
    }

    /**
     * 得到地址信息
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getAddressData(IAsyncResultCallback<List<AddressInfoResponse>> callback, Object userState) {
        return apiPostRequest(new TypeToken<List<AddressInfoResponse>>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.ADDRESSLIST, callback, userState);
    }

    /**
     * 添加地址
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState addAddress(AddAddressRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(Constant.SERVER_URL_NEW + Constant.ADDADDRESSS, request, callback, userState);
    }

    /**
     * 修改地址
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState updateAddress(AddAddressRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(Constant.SERVER_URL_NEW + Constant.UPDATE, request, callback, userState);
    }

    /**
     * 设置默认地址
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState setDefault(SetDefaultOrDeleteOrFindAddressRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(Constant.SERVER_URL_NEW + Constant.SETDEFAULT, request, callback, userState);
    }

    /**
     * 删除地址
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState deleteAddress(SetDefaultOrDeleteOrFindAddressRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(Constant.SERVER_URL_NEW + Constant.REMOVE, request, callback, userState);
    }

    /**
     * 得到省市区地址数据
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getProvinces(IAsyncResultCallback<List<AreaDataResponse>> callback, Object userState) {
        return apiPostRequest(new TypeToken<List<AreaDataResponse>>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.PROVINCES, callback, userState);
    }

    /**
     * 获取村  社区数据
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getChildProvinces(GetChildProvincesRequest request, IAsyncResultCallback<List<AddressTownResponse>> callback, Object userState) {
        return apiPostRequest(new TypeToken<List<AddressTownResponse>>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.CHILD_PROVINCES, request, callback, userState);
    }

    /**
     * 获取站点数据
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getStationData(GetBindStationRequest request, IAsyncResultCallback<List<GetBindStationReponse>> callback, Object userState) {
        return apiPostRequest(new TypeToken<List<GetBindStationReponse>>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.FIND_LIST_BY_REGION, request, callback, userState);
    }

    /**
     * 购物车数据
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getShopCartData(IAsyncResultCallback<ShopCartResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<ShopCartResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.SHOPCART_DATA, callback, userState);
    }

    /**
     * 更新商品的数量 skuinfo
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState updateAddOrSubSkuinfo(GoodsUpdateRequest request, IAsyncResultCallback<GoodsUpdateResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GoodsUpdateResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.UPDATEPRODUCT, request, callback, userState);
    }

    /**
     * 删除商品
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState deleteGoods(GoodsDeleteRequest request, IAsyncResultCallback<GoodsUpdateResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GoodsUpdateResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.REMOVEPRODUCT, request, callback, userState);
    }


    /**
     * 获取分类数据
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getCategoryData(IAsyncResultCallback<List<CategoryResponse>> callback, Object userState) {
        return apiPostRequest(new TypeToken<List<CategoryResponse>>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.GET_CATEGORY_DATA, callback, userState);
    }

    /**
     * 获取SKU详情
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getSkuDetailData(SkuDetailRequest request, IAsyncResultCallback<SkuDetailResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<SkuDetailResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.GET_SKU_DETAIL, request, callback, userState);
    }

    /**
     * 获取用户默认地址
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getDefaultAddressData(IAsyncResultCallback<DefaultAddressResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<DefaultAddressResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.DEFAULT_ADDRESS, callback, userState);
    }

    /**
     * 计算运费
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState calculateFreight(CalculateFreightRequest request, IAsyncResultCallback<CalculateFreightResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<CalculateFreightResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.CALCULATE_FREIGHT, request, callback, userState);
    }

    /**
     * 获取商品描述
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getDescriptionData(ProductIdRequest request, IAsyncResultCallback<DescriptionResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<DescriptionResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.GET_DESCRIPTION, request, callback, userState);
    }


    /**
     * 获取商品Sku列表
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getSkuInfoListData(ProductIdRequest request, IAsyncResultCallback<List<SkuInfoResponse>> callback, Object userState) {
        return apiPostRequest(new TypeToken<List<SkuInfoResponse>>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.GET_SKU_INFO_LIST, request, callback, userState);
    }

    /**
     * 获取指定规格值或属性值的sku信息
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState findSkuInfoData(FindSkuInfoRequest request, IAsyncResultCallback<SkuDetailResponse.SkuInfoBean> callback, Object userState) {
        return apiPostRequest(new TypeToken<SkuDetailResponse.SkuInfoBean>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.FIND_SKU_INFO, request, callback, userState);
    }

    /**
     * 加入商品到购物车
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState addToCart(AddToCartRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(Constant.SERVER_URL_NEW + Constant.ADD_TO_CART, request, callback, userState);
    }

    /**
     * 推荐商品收藏
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState addFavorite(SkuIdRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(Constant.SERVER_URL_NEW + Constant.ADD_FAVORITE, request, callback, userState);
    }

    /**
     * 取消推荐商品收藏
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState removeFavorite(SkuIdRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(Constant.SERVER_URL_NEW + Constant.REMOVE_FAVORITE, request, callback, userState);
    }

    /**
     * 获取购物车数量
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getCartQuantity(IAsyncResultCallback<GetCartQuantityResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GetCartQuantityResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.GET_CART_QUANTITY, callback, userState);
    }

    /**
     * 订单创建
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */

    public IAsyncRequestState getOrderBuildData(OrderBuildRequest request, IAsyncResultCallback<OrderBuildResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OrderBuildResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.SETTLEMENT, request, callback, userState);
    }

    /**
     * 订单提交
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState orderSubmit(OrderSubmitRequest request, IAsyncResultCallback<OrderSubmitResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OrderSubmitResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.SUBMIT, request, callback, userState);
    }

    /**
     * 获取可支付渠道
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getPayTradeChannel(PayListRequest request, IAsyncResultCallback<List<TradeChannelResponse>> callback, Object userState) {
        return apiPostRequest(new TypeToken<List<TradeChannelResponse>>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.ENABLEDLIST, request, callback, userState);
    }

    /**
     * 支付参数的调用
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getPayParms(OrderPayApplyRequest request, IAsyncResultCallback<OrderPayApplyResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OrderPayApplyResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.APPAPPLY, request, callback, userState);
    }

    /**
     * 店铺收藏
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getShopStoreList(ShopCurrentPageRequest request, IAsyncResultCallback<ShopStoreReponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<ShopStoreReponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.PAGESHOPLIST, request, callback, userState);
    }

    /**
     * 取消收藏
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState shopStoreCancel(ShopSotreCancelRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(Constant.SERVER_URL_NEW + Constant.CANCELSHOP, request, callback, userState);
    }

    /**
     * 足迹
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState footMarkData(ShopCurrentPageRequest request, IAsyncResultCallback<FootMarkResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<FootMarkResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.FOOTMARKPAGELIST, request, callback, userState);
    }

    /**
     * 删除足迹 单个
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState deletefootMarkone(DeleteFootRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(Constant.SERVER_URL_NEW + Constant.REMOVE_FOOTMARK, request, callback, userState);
    }

    /**
     * 建议
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState suggestion(SuggestRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(Constant.SERVER_URL_NEW + Constant.NEWSUGGEST, request, callback, userState);
    }

    /**
     * 电话充值列表
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getMobileCardList(IAsyncResultCallback<List<PhoneRechargeListReponse>> callback, Object userState) {
        return apiPostRequest(new TypeToken<List<PhoneRechargeListReponse>>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.MOBILECARDLIST, callback, userState);
    }


    /**
     * 电话充值归属地查询
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState checkPhone(MobilePayRequest request, IAsyncResultCallback<CheckPhoneReponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<CheckPhoneReponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.CHECKPHONE, request, callback, userState);
    }

    /**
     * 话费订单提交
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState submitMobile(MobilePayRequest request, IAsyncResultCallback<OrderSubmitResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OrderSubmitResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.SUBMITORDER, request, callback, userState);
    }

    /**
     * 站长推荐列表
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getCollectData(CollectRequest request, IAsyncResultCallback<CollectResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<CollectResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.RECOMMENDPRODUCTS, request, callback, userState);

    }

    /**
     * 更新推荐的商品是否选中
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState updateStatus(SkuDetailRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(Constant.SERVER_URL_NEW + Constant.UPDATESELECTSTATUS, request, callback, userState);
    }

    /**
     * 站长发布商品
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState publishProduct(PublishProductRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(Constant.SERVER_URL_NEW + Constant.PUBLISHPRODUCT, request, callback, userState);
    }

    /**
     * 移除发布的商品
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState removeFovorite(SkuDetailRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(Constant.SERVER_URL_NEW + Constant.REMOVEFAVORITESKU, request, callback, userState);
    }


    /**
     * 订单列表
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getOrderList(OrderListRequest request, IAsyncResultCallback<OrderListResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OrderListResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.ORDER_LIST, request, callback, userState);
    }

    /**
     * 订单详情
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getOrderDetail(OrderDetailRequest request, IAsyncResultCallback<OrderDetailResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OrderDetailResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.ORDER_DETAIL, request, callback, userState);
    }

    /**
     * 图片上传
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState uploadImage(UploadImageRequest request, IAsyncResultCallback<UploadImageResponse> callback, Object userState) {
        return apiImagePostRequest(UploadImageResponse.class, Constant.SERVER_URL_NEW + Constant.UPLOAD_IMAGE, request.getType(), request.getImage(), callback, userState);
    }

    /**
     * 删除订单
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState deleteOrder(OrderIdRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(Constant.SERVER_URL_NEW + Constant.DELETE_ORDER, request, callback, userState);
    }

    /**
     * 取消订单
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState cancelOrder(OrderIdRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(Constant.SERVER_URL_NEW + Constant.CANCEL_ORDER, request, callback, userState);
    }

    /**
     * 物流查询
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getExpressInfo(OrderIdRequest request, IAsyncResultCallback<ExpressInfoResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<ExpressInfoResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.FIND_EXPRESS_INFO, request, callback, userState);
    }

    /**
     * 延长收货
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState delayedReceipt(OrderIdRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(Constant.SERVER_URL_NEW + Constant.DELAY_RECEIPT, request, callback, userState);
    }

    /**
     * 确认收货
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState receipt(OrderIdRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(Constant.SERVER_URL_NEW + Constant.RECEIPT, request, callback, userState);
    }

    /**
     * 提醒商家发货
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState remindShipment(OrderIdRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(Constant.SERVER_URL_NEW + Constant.REMIND_SHIPMENT, request, callback, userState);
    }

    /**
     * 获取售后列表
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getAfterSalesList(PageRequest request, IAsyncResultCallback<AfterSalesResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<AfterSalesResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.GET_AFTER_SALES_LIST, request, callback, userState);
    }

    /**
     * 获取售后详情
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getAfterSalesDetail(AfterSalesDetailRequest request, IAsyncResultCallback<AfterSalesDetailResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<AfterSalesDetailResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.GET_AFTER_SALES_DETAIL, request, callback, userState);
    }

    /**
     * 进入退款页面获取数据（整单退）
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState beforeApplyRefund(BeforeApplyRefundRequest request, IAsyncResultCallback<BeforeApplyRefundResponse> callback, Object userState) {
        // 整单退
        if (request.getSkuId() == -1) {
            OrderIdRequest orderIdRequest = new OrderIdRequest();
            orderIdRequest.setOrderId(request.getOrderId());
            return apiPostRequest(new TypeToken<BeforeApplyRefundResponse>() {
            }.getType(), Constant.SERVER_URL_NEW + Constant.BEFORE_APPLY_REFUND, orderIdRequest, callback, userState);
        }
        // 单品退
        else {
            return apiPostRequest(new TypeToken<BeforeApplyRefundResponse>() {
            }.getType(), Constant.SERVER_URL_NEW + Constant.BEFORE_APPLY_REFUND, request, callback, userState);
        }
    }

    /**
     * 首次提交退款申请
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState submitApplyRefund(ApplyRefundRequest request, IAsyncEmptyCallback callback, Object userState) {
        // 整单退
        if (request.getSkuId() == -1) {
            ApplyRefundAllRequest applyRefundAllRequest = new ApplyRefundAllRequest();
            applyRefundAllRequest.setIsNeedReturnGoods(request.isIsNeedReturnGoods());
            applyRefundAllRequest.setReason(request.getReason());
            applyRefundAllRequest.setExplain(request.getExplain());
            applyRefundAllRequest.setVoucherImageUrls(request.getVoucherImageUrls());
            applyRefundAllRequest.setOrderId(request.getOrderId());
            return apiPostRequest(Constant.SERVER_URL_NEW + Constant.APPLY_REFUND, applyRefundAllRequest, callback, userState);

        }
        // 单品退
        else {
            ApplyRefundOneRequest applyRefundOneRequest = new ApplyRefundOneRequest();
            applyRefundOneRequest.setIsNeedReturnGoods(request.isIsNeedReturnGoods());
            applyRefundOneRequest.setReason(request.getReason());
            applyRefundOneRequest.setExplain(request.getExplain());
            applyRefundOneRequest.setVoucherImageUrls(request.getVoucherImageUrls());
            applyRefundOneRequest.setSkuId(request.getSkuId());
            applyRefundOneRequest.setOrderId(request.getOrderId());
            return apiPostRequest(Constant.SERVER_URL_NEW + Constant.APPLY_REFUND, applyRefundOneRequest, callback, userState);

        }
    }


    /**
     * 重新提交退款申请
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState submitReApplyRefund(ApplyRefundRequest request, IAsyncEmptyCallback callback, Object userState) {
        // 整单退
        if (request.getSkuId() == -1) {
            ReApplyRefundAllRequest reApplyRefundAllRequest = new ReApplyRefundAllRequest();
            reApplyRefundAllRequest.setApplyNo(request.getApplyNo());
            reApplyRefundAllRequest.setIsNeedReturnGoods(request.isIsNeedReturnGoods());
            reApplyRefundAllRequest.setReason(request.getReason());
            reApplyRefundAllRequest.setExplain(request.getExplain());
            reApplyRefundAllRequest.setVoucherImageUrls(request.getVoucherImageUrls());
            reApplyRefundAllRequest.setOrderId(request.getOrderId());
            return apiPostRequest(Constant.SERVER_URL_NEW + Constant.REAPPLY_REFUND, reApplyRefundAllRequest, callback, userState);

        }
        // 单品退
        else {
            ReApplyRefundOneRequest reApplyRefundOneRequest = new ReApplyRefundOneRequest();
            reApplyRefundOneRequest.setApplyNo(request.getApplyNo());
            reApplyRefundOneRequest.setIsNeedReturnGoods(request.isIsNeedReturnGoods());
            reApplyRefundOneRequest.setReason(request.getReason());
            reApplyRefundOneRequest.setExplain(request.getExplain());
            reApplyRefundOneRequest.setVoucherImageUrls(request.getVoucherImageUrls());
            reApplyRefundOneRequest.setSkuId(request.getSkuId());
            reApplyRefundOneRequest.setOrderId(request.getOrderId());
            return apiPostRequest(Constant.SERVER_URL_NEW + Constant.REAPPLY_REFUND, reApplyRefundOneRequest, callback, userState);

        }
    }


    /**
     * 撤销退款申请
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState cancelApplyRefund(CancelApplyRefundRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(Constant.SERVER_URL_NEW + Constant.CANCEL_APPLY_REFUND, request, callback, userState);
    }

    /**
     * 获取物流公司列表
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getShippingCampanyList(IAsyncResultCallback<List<ShippingCompanyResponse>> callback, Object userState) {
        return apiPostRequest(new TypeToken<List<ShippingCompanyResponse>>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.SHIPPING_COMPANY_LIST, callback, userState);
    }

    /**
     * 买家寄货
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState sendGoods(BuyerSendGoodsRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(Constant.SERVER_URL_NEW + Constant.SEND_GOODS, request, callback, userState);
    }


    /**
     * 退款物流信息查询
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getRefundExpressInfo(RefundExpressInfoRequest request, IAsyncResultCallback<ExpressInfoResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<ExpressInfoResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.REFUND_EXPRESS_INFO, request, callback, userState);
    }
}
