package com.coopbuy.mall.ui.module.home.activity;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.ShopDetailResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.activity.ShopCartActivity;
import com.coopbuy.mall.ui.module.center.adapter.MyViewPagerAdapter;
import com.coopbuy.mall.ui.module.home.fragment.ShopDetailFragment_2;
import com.coopbuy.mall.ui.module.home.model.ShopDetailModel;
import com.coopbuy.mall.ui.module.home.presenter.ShopDetailPresenter;
import com.coopbuy.mall.ui.module.home.view.ShopDetail_IView;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 店铺详情
 *
 * @author ymb
 *         Create at 2017/8/10 13:59
 */
public class ShopDetailActivity extends BaseActivity<ShopDetailPresenter, ShopDetailModel> implements ShopDetail_IView {

    @Bind(R.id.tab_content)
    ViewPager mViewPager;
    @Bind(R.id.tab_1_image)
    ImageView tab1Image;
    @Bind(R.id.tab_1_text)
    TextView tab1Text;
    @Bind(R.id.tab_2_num)
    TextView tab2Num;
    @Bind(R.id.tab_2_text)
    TextView tab2Text;
    @Bind(R.id.shop_logo)
    SimpleDraweeView shopLogo;
    @Bind(R.id.shop_name)
    TextView shopName;
    @Bind(R.id.introduction)
    TextView introduction;
    @Bind(R.id.like_icon)
    ImageView likeIcon;
    @Bind(R.id.like_text)
    TextView likeText;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private MyViewPagerAdapter mAdapter;
    private int mShopId; // 店铺id
    private boolean mIsFavorite = false; // 是否收藏了店铺

    @Override
    public int getLayoutId() {
        return R.layout.activity_shop_detail;
    }

    @Override
    public void initModel() {
        mModel = new ShopDetailModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new ShopDetailPresenter(mContext, mModel, this);
        mPresenter.getShopDetail(mShopId);
    }

    @Override
    protected void networkRetry() {
        mPresenter.getShopDetail(mShopId);
    }

    @Override
    public void initView() {
        mShopId = getIntent().getIntExtra(IntentUtils.PARAM1, 0);
        setTitle("");
        setRightImage(R.mipmap.icon_nav_home_top_cart);
        initFragment();
        initAdapter();
    }

    @Override
    public void clickTitleBarRight() {
        IntentUtils.gotoActivity(mContext, ShopCartActivity.class);
    }

    private void initFragment() {
//        mFragments.add(new ShopDetailFragment_1());
        mFragments.add(new ShopDetailFragment_2());
    }

    private void initAdapter() {
        mAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(0);
    }

    @OnClick({R.id.tab_1, R.id.tab_2, R.id.favorite_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tab_1:
                switchTab(0);
                break;
            case R.id.tab_2:
                switchTab(1);
                break;
            // 收藏/取消收藏
            case R.id.favorite_btn:
                if (mIsFavorite)
                    mPresenter.removeShopFavorite(mShopId);
                else
                    mPresenter.addShopFavorite(mShopId);
                break;
        }
    }

    /**
     * 标签切换
     *
     * @param tabIndex
     */
    private void switchTab(int tabIndex) {
        mViewPager.setCurrentItem(tabIndex);
        if (tabIndex == 0) {
            tab1Image.setImageResource(R.mipmap.icon_shop_detail_mainpage_light);
            tab1Text.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_title_orange));
            tab2Num.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_lab_black));
            tab2Text.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_lab_black));
        } else {
            tab1Image.setImageResource(R.mipmap.icon_shop_detail_mainpage_dark);
            tab1Text.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_lab_black));
            tab2Num.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_title_orange));
            tab2Text.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_title_orange));
        }
    }

    /**
     * 动态设置ViewPager高度
     *
     * @param height
     */
    public void setViewPagerHeight(int height) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) mViewPager.getLayoutParams();
        params.height = height;
        mViewPager.setLayoutParams(params);
    }

    /**
     * 设置网络返回数据
     *
     * @param shopDetailResponse
     */
    @Override
    public void setShopDetailData(ShopDetailResponse shopDetailResponse) {
        setTitle(shopDetailResponse.getShopName());
        shopLogo.setImageURI(Uri.parse(TextUtils.isEmpty(shopDetailResponse.getLogoUrl()) ? "" : shopDetailResponse.getLogoUrl()));
        shopName.setText(shopDetailResponse.getShopName());
        introduction.setText(shopDetailResponse.getSlogan());

        // 是否收藏店铺设置
        setFavoriteBtnDisplay(shopDetailResponse.isIsFavorite());
    }

    /**
     * 收藏店铺成功
     */
    @Override
    public void addShopFavoriteSuccess() {
        setFavoriteBtnDisplay(true);
        ToastUtils.toastShort("已收藏");
    }

    /**
     * 取消收藏店铺成功
     */
    @Override
    public void removeShopFavoriteSuccess() {
        setFavoriteBtnDisplay(false);
        ToastUtils.toastShort("已取消收藏");
    }

    /**
     * 获取商家id
     * @return
     */
    public int getShopId() {
        return mShopId;
    }

    private void setFavoriteBtnDisplay(boolean isFavorite) {
        if (isFavorite) {
            likeIcon.setVisibility(View.VISIBLE);
            likeText.setText("已收藏");
            mIsFavorite = true;
        } else {
            likeIcon.setVisibility(View.GONE);
            likeText.setText("收藏店铺");
            mIsFavorite = false;
        }
    }
}
