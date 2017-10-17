package com.coopbuy.mall.ui.module.home.fragment;

import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.SkuDetailResponse;
import com.coopbuy.mall.api.reponse.SkuInfoResponse;
import com.coopbuy.mall.api.request.FindSkuInfoRequest;
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

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import cn.iwgang.simplifyspan.SimplifySpanBuild;
import cn.iwgang.simplifyspan.other.SpecialGravity;
import cn.iwgang.simplifyspan.unit.SpecialLabelUnit;

import static android.view.View.GONE;

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
    @Bind(R.id.salesVolume)
    TextView salesVolume;
    @Bind(R.id.propertyDesc)
    TextView propertyDesc;
    @Bind(R.id.btn_goods_attrs_layout)
    LinearLayout btnGoodsAttrsLayout;

    // 首次页面进入保存的返回信息
    private SkuDetailResponse mSkuDetailResponse;
    // 属性弹框
    private GoodsAttrsDialog goodsAttrsDialog = null;

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
//        mPresenter.getSkuDetailData(375);
        mPresenter.getSkuDetailData(6305);
    }

    @Override
    protected void onFragmentFirstVisible() {
//        mPresenter.getSkuDetailData(375);
        mPresenter.getSkuDetailData(6305);
    }

    @Override
    protected void initView() {
    }


    @OnClick({R.id.btn_goods_params, R.id.btn_goods_attrs, R.id.btn_go_shop})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.btn_goods_params:
                GoodsParamsDialog goodsParamsDialog = new GoodsParamsDialog(mContext, mSkuDetailResponse.getPropertie());
                goodsParamsDialog.showAtBottom();
                break;
            case R.id.btn_goods_attrs:
                mPresenter.getSkuInfoListData(mSkuDetailResponse.getProductId());
                break;
            // 进店逛逛
            case R.id.btn_go_shop:
                IntentUtils.gotoActivity(mContext, ShopDetailActivity.class);
                break;
        }
    }

    /**
     * 获取指定规格值或属性值的sku信息（属性弹框中选择）
     *
     * @param request
     */
    public void findSkuInfoData(FindSkuInfoRequest request) {
        mPresenter.findSkuInfoData(request);
    }

    /**
     * 设置指定的sku信息
     *
     * @param skuInfoBean
     */
    public void setFindSkuInfoData(SkuDetailResponse.SkuInfoBean skuInfoBean) {
        // 设置当前页面sku的信息
        setSkuInfoData(skuInfoBean);
        // 设置属性弹框sku的信息
        goodsAttrsDialog.setSkuInfoData(skuInfoBean);
    }


    /**
     * 首次进入返回数据显示
     *
     * @param skuDetailResponse
     */
    public void setSkuDetailData(SkuDetailResponse skuDetailResponse) {
        // 保存skuDetailResponse
        mSkuDetailResponse = skuDetailResponse;

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

        // sku相关信息
        setSkuInfoData(skuDetailResponse.getSkuInfo());

        // 销量
        salesVolume.setText("销量：" + skuDetailResponse.getSalesVolume());
        // 店铺logo
        shopLogo.setImageURI(Uri.parse(skuDetailResponse.getShopInfo().getImageUrl()));
        // 店铺名称
        shopName.setText(skuDetailResponse.getShopInfo().getShopName());
        // 店铺商品数
        goodsNum.setText("全部宝贝（" + skuDetailResponse.getShopInfo().getProductCount() + "）");
        // 店铺收藏数
        likeNum.setText(skuDetailResponse.getShopInfo().getNumberOfCollectors() + "人关注此店铺");
    }

    /**
     * 设置sku信息
     *
     * @param skuInfoBean
     */
    private void setSkuInfoData(SkuDetailResponse.SkuInfoBean skuInfoBean) {
        // 销售价
        sellingPrice.setText("¥" + StringUtils.keepTwoDecimalPoint(skuInfoBean.getSellingPrice()));
        // 成本价
        costPrice.setText("¥" + StringUtils.keepTwoDecimalPoint(skuInfoBean.getCostPrice()));
        // 库存
        stock.setText("库存：" + skuInfoBean.getStock());
        // 属性和规格
        propertyDesc.setText(skuInfoBean.getPricePropertyValue() + " " + skuInfoBean.getPriceSpecificationsValue());
        if (TextUtils.isEmpty(skuInfoBean.getPricePropertyValue()) && TextUtils.isEmpty(skuInfoBean.getPricePropertyValue()))
            btnGoodsAttrsLayout.setVisibility(GONE);
    }

    /**
     * 点击属性按钮返回数据，然后显示弹框
     *
     * @param skuInfoResponses
     */
    public void setSkuInfoListData(List<SkuInfoResponse> skuInfoResponses) {
        if (skuInfoResponses != null && skuInfoResponses.size() > 0) {
            goodsAttrsDialog = new GoodsAttrsDialog(mContext, this, skuInfoResponses, mSkuDetailResponse.getSkuInfo(), mSkuDetailResponse.getProductId());
            goodsAttrsDialog.showAtBottom();
        }
    }
}
