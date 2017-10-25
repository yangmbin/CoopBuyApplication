package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.api.reponse.ShopCartResponse;
import com.coopbuy.mall.api.reponse.SkuInfoResponse;
import com.coopbuy.mall.base.BaseView;

import java.util.List;

/**
 * @author niu
 * @time 2017/10/24 10:29
 * @content
 */
public interface ShopCart_IView extends BaseView {
    void getShopCartData(ShopCartResponse data);


    /**
     * 操作数量成功 postion 用于不更新界面
     */
    void addSubSuccess(int postion, int child, int type);

    /**
     * 更新商品的skuinfo成功
     */
    void updateGoodsSkuinfoSuccess();

    /**
     * 删除多个商品
     */
    void deleteMoreSuccess();

    /**
     * 删除单个商品
     *
     * @param parent
     * @param child
     */
    void deleteItemSuccess(int parent, int child);

    /**
     * 规格选择
     * @param skuInfoResponses
     * @param prant
     * @param child
     */
    void setSkuInfoListData(List<SkuInfoResponse> skuInfoResponses,int prant,int child);
}
