package com.coopbuy.mall.ui.module.home.fragment;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.SkuDetailResponse;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.mainpage.imageloader.BannerImageLoader;
import com.coopbuy.mall.ui.module.home.activity.GoodsDetailActivity;
import com.coopbuy.mall.ui.module.home.activity.ShopDetailActivity;
import com.coopbuy.mall.ui.module.home.model.GoodsDetailModel;
import com.coopbuy.mall.ui.module.home.presenter.GoodsDetailPresenter;
import com.coopbuy.mall.ui.module.home.view.GoodsDetail_IView;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ScreenUtils;
import com.coopbuy.mall.utils.StringUtils;
import com.coopbuy.mall.widget.DeleteLineTextView;
import com.coopbuy.mall.widget.dialog.GoodsAttrsDialog;
import com.coopbuy.mall.widget.dialog.GoodsParamsDialog;
import com.coopbuy.mall.widget.goodsdetail.SlideDetailsLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.iwgang.simplifyspan.SimplifySpanBuild;
import cn.iwgang.simplifyspan.other.SpecialGravity;
import cn.iwgang.simplifyspan.unit.SpecialLabelUnit;

/**
 * 商品详情Fragment1
 *
 * @author ymb
 *         Create at 2017/7/25 10:23
 */
public class GoodsDetailFragment_1 extends ViewPagerBaseFragment<GoodsDetailPresenter, GoodsDetailModel> implements GoodsDetail_IView {
    @Bind(R.id.verticalSlide)
    SlideDetailsLayout verticalSlide;
    @Bind(R.id.banner)
    Banner banner;
    @Bind(R.id.goods_name)
    TextView goodsName;
    @Bind(R.id.sellingPrice)
    TextView sellingPrice;
    @Bind(R.id.costPrice)
    DeleteLineTextView costPrice;
    @Bind(R.id.stock)
    TextView stock;
    @Bind(R.id.shop_logo)
    SimpleDraweeView shopLogo;
    @Bind(R.id.shop_name)
    TextView shopName;
    @Bind(R.id.goods_num)
    TextView goodsNum;
    @Bind(R.id.like_num)
    TextView likeNum;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_goods_detail_1;
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
    protected void networkRetry() {
        mPresenter.getSkuDetailData(376);
    }

    @Override
    protected void onFragmentFirstVisible() {
        mPresenter.getSkuDetailData(376);
    }

    @Override
    protected void initView() {
    }


    @OnClick({R.id.btn_goods_params, R.id.btn_goods_attrs, R.id.btn_go_shop})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.btn_goods_params:
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 7; i++)
                    list.add("");
                GoodsParamsDialog goodsParamsDialog = new GoodsParamsDialog(mContext, list);
                goodsParamsDialog.showAtBottom();
                break;
            case R.id.btn_goods_attrs:
                list = new ArrayList<>();
                for (int i = 0; i < 2; i++)
                    list.add("");
                GoodsAttrsDialog goodsAttrsDialog = new GoodsAttrsDialog(mContext, list);
                goodsAttrsDialog.showAtBottom();
                break;
            // 进店逛逛
            case R.id.btn_go_shop:
                IntentUtils.gotoActivity(mContext, ShopDetailActivity.class);
                break;
        }
    }

    /**
     * 返回数据显示
     *
     * @param skuDetailResponse
     */
    public void setSkuDetailData(SkuDetailResponse skuDetailResponse) {
        // 保存productId
        ((GoodsDetailActivity) mContext).setProductId(skuDetailResponse.getProductId());
        getChildFragmentManager().beginTransaction().add(R.id.webViewContainer, new GoodsDetailFragment_2()).commit();

        // banner图
        if (skuDetailResponse.getImages() != null && skuDetailResponse.getImages().size() > 0)
            banner.setImages(skuDetailResponse.getImages()).setImageLoader(new BannerImageLoader()).start();
        // 商品名
        SimplifySpanBuild simplifySpanBuild = new SimplifySpanBuild();
        if (skuDetailResponse.isIsSelfSupport()) {
            simplifySpanBuild.append(new SpecialLabelUnit("自营", Color.WHITE, ScreenUtils.dip2px(mContext, 10), 0xFF51A400)
                    .setLabelBgRadius(50)
                    .setPadding(ScreenUtils.dip2px(mContext, 5))
                    .setGravity(SpecialGravity.CENTER))
                    .append("  " + skuDetailResponse.getTitle());
        } else {
            simplifySpanBuild.append(skuDetailResponse.getTitle());
        }
        goodsName.setText(simplifySpanBuild.build());
        // 销售价
        sellingPrice.setText("¥" + StringUtils.keepTwoDecimalPoint(skuDetailResponse.getSkuInfo().getSellingPrice()));
        // 成本价
        costPrice.setText("¥" + StringUtils.keepTwoDecimalPoint(skuDetailResponse.getSkuInfo().getCostPrice()));
        // 库存
        stock.setText("库存：" + skuDetailResponse.getSkuInfo().getStock());
        // 店铺logo
        shopLogo.setImageURI(Uri.parse(skuDetailResponse.getShopInfo().getImageUrl()));
        // 店铺名称
        shopName.setText(skuDetailResponse.getShopInfo().getShopName());
        // 店铺商品数
        goodsNum.setText("全部宝贝（" + skuDetailResponse.getShopInfo().getProductCount() + "）");
        // 店铺收藏数
        likeNum.setText(skuDetailResponse.getShopInfo().getNumberOfCollectors() + "人关注此店铺");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
