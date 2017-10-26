package com.coopbuy.mall.ui.module.center.port;

import com.coopbuy.mall.api.request.FindSkuInfoRequest;
import com.coopbuy.mall.api.request.GoodsUpdateRequest;

/**
 * @author csn
 * @date 2017/8/30 0030 16:38
 * @content 这个是购物车接口
 */
public interface ShopCartListener {
    /**
     * 购物车选中 进行界面刷新 同时计算费用
     *
     * @param isSelect
     */
    void selectFresh(boolean isSelect);

    /**
     * 撤回是否打开
     *
     * @param isSwip
     */
    void swipEdit(boolean isSwip);

    /**
     * 商品数量
     *
     * @param postion
     */
    void addSubGoods(int postion, int child, int type);

    /**
     * 商品删除
     *
     * @param postion
     * @param child
     */
    void delete(int postion, int child);

    /**
     * 商品详情
     *
     * @param parent
     * @param child
     */
    void openGoodsDetial(int parent, int child);

    /**
     * 商品选择skuidinfo
     *
     * @param prarent
     * @param child
     */
    void openSelectSkuinfo(int prarent, int child);

    /**
     * 打开店铺
     *
     * @param prarent
     */
    void openShop(int prarent);

    /**
     * 规格选择
     *
     * @param parant
     * @param child
     */
    void openVersionSelect(int parant, int child);

    void findSkuinfo(FindSkuInfoRequest request);

    /**
     * 得到新选择的skuinfo和数量
     */
    void getNewSkuinfo(GoodsUpdateRequest request);
}
