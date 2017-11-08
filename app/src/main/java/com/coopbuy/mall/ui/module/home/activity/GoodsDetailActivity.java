package com.coopbuy.mall.ui.module.home.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.GetCartQuantityResponse;
import com.coopbuy.mall.api.request.SkuIdRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.activity.ShopCartActivity;
import com.coopbuy.mall.ui.module.center.adapter.MyViewPagerAdapter;
import com.coopbuy.mall.ui.module.home.fragment.GoodsDetailFragment_1;
import com.coopbuy.mall.ui.module.home.fragment.GoodsDetailFragment_2;
import com.coopbuy.mall.ui.module.home.model.GoodsDetailModel;
import com.coopbuy.mall.ui.module.home.presenter.GoodsDetailPresenter;
import com.coopbuy.mall.ui.module.home.view.GoodsDetail_IView;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.widget.navigation.NavGoodsDetailBar;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 商品详情
 *
 * @author ymb
 *         Create at 2017/8/10 13:59
 */
public class GoodsDetailActivity extends BaseActivity<GoodsDetailPresenter, GoodsDetailModel> implements GoodsDetail_IView {

    @Bind(R.id.topBar)
    NavGoodsDetailBar topBar;
    @Bind(R.id.tab_content)
    ViewPager mViewPager;
    @Bind(R.id.cart_num)
    TextView cartNum;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private MyViewPagerAdapter mAdapter;
    private final String[] mTitles = {"商品", "详情"};
    // 保存商品id
    private int productId = -1;
    // 保存SkuId
    private int skuId = -1;
    // 保存shopId
    private int shopId = -1;

    // 添加和取消收藏监听器
    private NavGoodsDetailBar.FavoriteClickListener mFavoriteClickListener = new NavGoodsDetailBar.FavoriteClickListener() {
        @Override
        public void addFavorite() {
            SkuIdRequest request = new SkuIdRequest();
            request.setSkuId(skuId);
            mPresenter.addFavorite(request);
        }

        @Override
        public void removeFavorite() {
            SkuIdRequest request = new SkuIdRequest();
            request.setSkuId(skuId);
            mPresenter.removeFavorite(request);
        }
    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_goods_detail;
    }

    @Override
    public void initModel() {
        mModel = new GoodsDetailModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new GoodsDetailPresenter(mContext, mModel, this);
    }

    @Override
    public void initView() {
        initFragment();
        initAdapter();
        skuId = getIntent().getIntExtra(IntentUtils.PARAM1, -1);
        topBar.setOnFavoriteClickListener(mFavoriteClickListener);
    }

    private void initFragment() {
        mFragments.add(new GoodsDetailFragment_1());
        mFragments.add(new GoodsDetailFragment_2());
    }

    private void initAdapter() {
        mAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mAdapter);
        topBar.setViewPager(mViewPager, mTitles, this, mFragments);
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    @OnClick({R.id.buyRightNow, R.id.addToCart, R.id.bottom_shop_btn, R.id.bottom_cart_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            // 立即购买
            case R.id.buyRightNow:
                ((GoodsDetailFragment_1) mFragments.get(0)).beforeOpenAttrDialog();
                break;
            // 添加到购物车
            case R.id.addToCart:
                ((GoodsDetailFragment_1) mFragments.get(0)).beforeOpenAttrDialog();
                break;
            // 跳转店铺
            case R.id.bottom_shop_btn:
                if (shopId != -1)
                    IntentUtils.gotoActivity(mContext, ShopDetailActivity.class, shopId);
                break;
            // 跳转购物车
            case R.id.bottom_cart_btn:
                IntentUtils.gotoActivity(mContext, ShopCartActivity.class);
                break;
        }
    }

    /**
     * 设置收藏按钮的显示
     *
     * @param status -1:不显示 0：不选中 1：选中
     */
    public void setFavoriteBtnDisplay(int status) {
        topBar.setFavoriteBtnDisplay(status);
    }

    /**
     * 添加收藏成功回调
     */
    public void addFavoriteSuccess() {
        topBar.setFavoriteBtnDisplay(1);
    }

    /**
     * 取消收藏成功回调
     */
    public void removeFavoriteSuccess() {
        topBar.setFavoriteBtnDisplay(0);
    }

    /**
     * 获取购物车数量成功回调
     * @param getCartQuantityResponse
     */
    public void getCartQuantitySuccess(GetCartQuantityResponse getCartQuantityResponse) {
        int count = getCartQuantityResponse.getCartCount();
        if (count > 0) {
            cartNum.setVisibility(View.VISIBLE);
            cartNum.setText(count + "");
        } else {
            cartNum.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getCartQuantity();
    }
}
