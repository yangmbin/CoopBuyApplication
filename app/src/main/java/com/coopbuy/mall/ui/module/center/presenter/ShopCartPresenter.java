package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.GoodsUpdateResponse;
import com.coopbuy.mall.api.reponse.ShopCartResponse;
import com.coopbuy.mall.api.reponse.SkuDetailResponse;
import com.coopbuy.mall.api.reponse.SkuInfoResponse;
import com.coopbuy.mall.api.request.FindSkuInfoRequest;
import com.coopbuy.mall.api.request.GoodsDeleteRequest;
import com.coopbuy.mall.api.request.GoodsUpdateRequest;
import com.coopbuy.mall.api.request.ProductIdRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.ShopCartModel;
import com.coopbuy.mall.ui.module.center.view.ShopCart_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

import java.util.List;

/**
 * Created by niu on 2017/10/24.
 */

public class ShopCartPresenter extends BasePresenter<ShopCart_IView, ShopCartModel> {
    public ShopCartPresenter(Context mContext, ShopCartModel mModel, ShopCart_IView mView) {
        super(mContext, mModel, mView);
    }

    /**
     * 获得购物车数据
     *
     * @param type
     */
    public void getShopCartDate(String type) {
        if (type.equals("init")) {
            mView.showFillLoading();
        } else {
            mView.showTransLoading();
        }

        mView.appendNetCall(mModel.getShopCartData(new IAsyncResultCallback<ShopCartResponse>() {
            @Override
            public void onComplete(ShopCartResponse smsCodeReponse, Object userState) {
                if (!smsCodeReponse.getShops().isEmpty()) {
                    mView.getShopCartData(smsCodeReponse);
                    mView.stopAll();
                } else {
                    mView.showNoDataLayout();
                }
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                if (error != null) {
                    ToastUtils.toastShort(error.getMessage());
                    mView.stopAll();
                }
            }
        }, "shopcartdata"));
    }

    /**
     * 更新商品的数量
     */
    public void goodsUpdateCounts(GoodsUpdateRequest request, final int postion, final int child, final int type) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.updateAddOrSubSkuinfo(request, new IAsyncResultCallback<GoodsUpdateResponse>() {
            @Override
            public void onComplete(GoodsUpdateResponse smsCodeReponse, Object userState) {
                if (null != smsCodeReponse) {
                    mView.addSubSuccess(postion, child, type);
                }
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                if (error != null) {
                    ToastUtils.toastShort(error.getDetail());
                    mView.stopAll();
                }
            }
        }, "update"));
    }

    /**
     * 更新商品的skuinfo
     */
    public void goodsUpdateSkuinfo(GoodsUpdateRequest request) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.updateAddOrSubSkuinfo(request, new IAsyncResultCallback<GoodsUpdateResponse>() {
            @Override
            public void onComplete(GoodsUpdateResponse smsCodeReponse, Object userState) {
                if (null != smsCodeReponse) {
                    mView.updateGoodsSkuinfoSuccess();
                }
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                if (error != null) {
                    ToastUtils.toastShort(error.getDetail());
                    mView.stopAll();
                }
            }
        }, "update"));
    }

    /**
     * 删除单个商品
     */
    public void deleteGoods(GoodsDeleteRequest request, final int postion, final int child) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.deleteGoods(request, new IAsyncResultCallback<GoodsUpdateResponse>() {
            @Override
            public void onComplete(GoodsUpdateResponse smsCodeReponse, Object userState) {
                if (null != smsCodeReponse) {
                    mView.deleteItemSuccess(postion, child);
                }
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                if (error != null) {
                    ToastUtils.toastShort(error.getDetail());
                    mView.stopAll();
                }
            }
        }, "update"));
    }

    /**
     * 删除多个商品
     */
    public void deleteGoods(GoodsDeleteRequest request) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.deleteGoods(request, new IAsyncResultCallback<GoodsUpdateResponse>() {
            @Override
            public void onComplete(GoodsUpdateResponse smsCodeReponse, Object userState) {
                if (null != smsCodeReponse) {
                    mView.deleteMoreSuccess();
                }
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                if (error != null) {
                    ToastUtils.toastShort(error.getDetail());
                    mView.stopAll();
                }
            }
        }, "update"));
    }

    /**
     * 获取商品Sku信息列表
     *
     * @param productId
     */
    public void getSkuInfoListData(final int productId, final SkuDetailResponse.SkuInfoBean bean, final String type) {
        mView.showTransLoading();
        ProductIdRequest request = new ProductIdRequest();
        request.setProductId(productId);
        mView.appendNetCall(mModel.getSkuInfoListData(request, new IAsyncResultCallback<List<SkuInfoResponse>>() {
            @Override
            public void onComplete(List<SkuInfoResponse> skuInfoResponses, Object userState) {
                mView.setSkuInfoListData(skuInfoResponses, bean, productId,type);
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.stopAll();
                ToastUtils.toastShort(error.getMessage());
            }
        }, "商品Sku列表"));
    }

    /**
     * 获取指定规格值或属性值的sku信息
     *
     * @param request
     */
    public void findSkuInfoData(FindSkuInfoRequest request, final int productId, final String type) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.findSkuInfoData(request, new IAsyncResultCallback<SkuDetailResponse.SkuInfoBean>() {
            @Override
            public void onComplete(SkuDetailResponse.SkuInfoBean skuInfoBean, Object userState) {
                if (null != skuInfoBean) {
                    mView.getSkuInfoFindStock(skuInfoBean, productId,type);
                }else {
                    ToastUtils.toastShort("服务器数据异常，请稍后再试");
                }
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.stopAll();
                ToastUtils.toastShort(error.getMessage());
            }
        }, "获取指定规格值或属性值的sku信息"));
    }
}
