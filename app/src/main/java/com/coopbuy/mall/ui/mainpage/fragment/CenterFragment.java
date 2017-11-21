package com.coopbuy.mall.ui.mainpage.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.UserCenterInfoResponse;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.bean.CenterData;
import com.coopbuy.mall.eventbus.EventBusInstance;
import com.coopbuy.mall.eventbus.MainEvent;
import com.coopbuy.mall.ui.module.center.activity.AddressManageActivity;
import com.coopbuy.mall.ui.module.center.activity.CreatQRActivity;
import com.coopbuy.mall.ui.module.center.activity.FootMarkActivity;
import com.coopbuy.mall.ui.module.center.activity.HeplCenterActivity;
import com.coopbuy.mall.ui.module.center.activity.LoginActivity;
import com.coopbuy.mall.ui.module.center.activity.MessageCenterActivity;
import com.coopbuy.mall.ui.module.center.activity.PersonalActivity;
import com.coopbuy.mall.ui.module.center.activity.PhoneRechargeActivity;
import com.coopbuy.mall.ui.module.center.activity.ScanQRActivity;
import com.coopbuy.mall.ui.module.center.activity.SettingActivity;
import com.coopbuy.mall.ui.module.center.activity.ShopCartActivity;
import com.coopbuy.mall.ui.module.center.activity.ShopStoreActivity;
import com.coopbuy.mall.ui.module.center.activity.StationRecommendActivity;
import com.coopbuy.mall.ui.module.center.activity.StationReleasesActivity;
import com.coopbuy.mall.ui.module.center.adapter.CenterAdapter;
import com.coopbuy.mall.ui.module.center.model.CenterModel;
import com.coopbuy.mall.ui.module.center.presenter.CenterPresenter;
import com.coopbuy.mall.ui.module.center.view.Center_IView;
import com.coopbuy.mall.utils.Constants;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.widget.OrderBarView;
import com.coopbuy.mall.widget.popwindow.CustomPopWindow;
import com.facebook.drawee.view.SimpleDraweeView;
import com.gyf.barlibrary.ImmersionBar;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 个人中心Fragment
 *
 * @author ymb
 *         Create at 2017/7/25 10:23
 */
public class CenterFragment extends ViewPagerBaseFragment<CenterPresenter, CenterModel> implements Center_IView, View.OnClickListener {
    @Bind(R.id.swipe_target)
    RecyclerView mRvTest;
    @Bind(R.id.circleImageView)
    SimpleDraweeView head;
    @Bind(R.id.backImage)
    SimpleDraweeView backImage;
    @Bind(R.id.orderBarView)
    OrderBarView orderBarView;
    @Bind(R.id.iv_lab)
    ImageView ivLab;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_shopcart_number)
    TextView tvShopcartNumber;
    @Bind(R.id.tv_collect_number)
    TextView tvCollectNumber;
    @Bind(R.id.tv_footmark_number)
    TextView tvFootmarkNumber;
    @Bind(R.id.ll_location)
    LinearLayout llLocation;
    @Bind(R.id.ll_search)
    LinearLayout llSearch;
    /**
     * 普通用户可以展示  站长不展示
     */
    @Bind(R.id.ll_station)
    LinearLayout llStation;
    //站长类型
    @Bind(R.id.ll_station_status)
    LinearLayout llStationStatus;
    @Bind(R.id.ll_title_bar)
    LinearLayout llTitleBar;
    @Bind(R.id.iv_setting)
    ImageView ivSetting;
    @Bind(R.id.iv_msg)
    ImageView ivMsg;
    @Bind(R.id.ll_line)
    LinearLayout llLine;
    private UserCenterInfoResponse.UserInfoBean userInfo;
    private CenterAdapter adapter;
    private List<CenterData> mData;
    private CustomPopWindow popWindow;
    // 个人中心Fragment状态栏是蓝色的，做特殊处理
    private ImmersionBar mImmersionBar = null;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_three;
    }

    @Override
    public void initModel() {
        mModel = new CenterModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new CenterPresenter(getActivity(), mModel, this);
    }

    @Override
    protected void initView() {
        EventBusInstance.getInstance().registerEvent(this);
        setInitTitle();
        setData();
        adapter = new CenterAdapter(getActivity(), mData);
        mRvTest.setLayoutManager(new GridLayoutManager(mContext, 4) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mRvTest.setAdapter(adapter);
    }

    private void setInitTitle() {
        llLocation.setVisibility(View.INVISIBLE);
        llSearch.setVisibility(View.INVISIBLE);
        llLine.setVisibility(View.GONE);
        ivMsg.setImageResource(R.mipmap.icon_center_msg);
        ivSetting.setImageResource(R.mipmap.icon_center_setting);
        llTitleBar.setBackgroundResource(R.color.center_back);
    }

    private void setData() {
        mData = new ArrayList<>();
        mData.add(new CenterData(getActivity().getResources().getString(R.string.lab_center_data), R.mipmap.icon_center_data));
        mData.add(new CenterData(getActivity().getResources().getString(R.string.lab_center_client), R.mipmap.icon_center_client));
        mData.add(new CenterData(getActivity().getResources().getString(R.string.lab_center_order), R.mipmap.icon_center_order));
        //   mData.add(new CenterData(getActivity().getResources().getString(R.string.lab_center_work), R.mipmap.icon_cneter_work));
        mData.add(new CenterData(getActivity().getResources().getString(R.string.lab_center_recommend), R.mipmap.icon_center_recommend));
    }

    @Override
    protected void onFragmentVisible(boolean isVisible) {
        super.onFragmentVisible(isVisible);
        if (isVisible) {
            initStatusBar();
        } else {
            destroyStatusBar();
        }
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
    }

    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.iv_setting, R.id.iv_msg, R.id.circleImageView, R.id.ll_shopcart, R.id.ll_collect, R.id.ll_footmark, R.id.ll_phone_fare, R.id.ll_broadband, R.id.ll_station, R.id.ll_help, R.id.ll_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.circleImageView:
                if (null != userInfo)
                    enter(PersonalActivity.class, userInfo);
                break;
            case R.id.ll_shopcart:
                enter(ShopCartActivity.class, null);
                break;
            case R.id.ll_collect:
                enter(ShopStoreActivity.class, null);
                break;
            case R.id.ll_footmark:
                enter(FootMarkActivity.class, null);
                break;
            case R.id.ll_phone_fare:
                enter(PhoneRechargeActivity.class, null);
                break;
            case R.id.ll_broadband:

                break;
            case R.id.ll_station:
                enter(StationRecommendActivity.class, null);
                break;
            case R.id.ll_help:
                IntentUtils.gotoActivity(getActivity(), HeplCenterActivity.class);
                break;
            case R.id.ll_address:
                enter(AddressManageActivity.class, "center");
                break;
            case R.id.iv_setting:
                IntentUtils.gotoActivity(getActivity(), SettingActivity.class);
                break;
            case R.id.iv_msg:
                showPopBottom(view);
                break;
        }
    }

    private void showPopBottom(View v) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.popuwindow_dialog_top, null);
        view.findViewById(R.id.ll_message).setOnClickListener(this);
        view.findViewById(R.id.ll_scan).setOnClickListener(this);
        view.findViewById(R.id.ll_code).setOnClickListener(this);
        popWindow = new CustomPopWindow.PopupWindowBuilder(getContext())
                .setView(view)
                .setFocusable(true)
                .setOutsideTouchable(true)
                .create();
        popWindow.showAsDropDown(v, 0, -2);
    }


    private void enter(Class activity, Serializable data) {
        if (sharedPreferencesUtils.getLoginStatus()) {
            IntentUtils.gotoActivity(getActivity(), activity, data);
        } else {
            IntentUtils.gotoActivity(getActivity(), LoginActivity.class);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (sharedPreferencesUtils.getLoginStatus()) {
            mPresenter.getUserInfoData();
        }
    }

    @Override
    public void getUserData(UserCenterInfoResponse data) {
        sharedPreferencesUtils.saveUserData(data);
        userInfo = data.getUserInfo();
        setUserInfo();
        tvShopcartNumber.setText(data.getCartProductCount() + "");
        tvCollectNumber.setText(data.getFavoriteShopCount() + "");
        tvFootmarkNumber.setText(data.getBrowseProductCount() + "");
        if (null == data.getFestivalImageUrl()) {
            backImage.setImageURI(Constants.images[(new Random().nextInt(12) + 1)]);
        } else {
            backImage.setImageURI(data.getFestivalImageUrl());
        }
        if (TextUtils.isEmpty(data.getUserInfo().getHeadPortraitPath())) {
            head.setImageURI(Constants.images[(new Random().nextInt(12) + 1)]);
        } else {
            head.setImageURI(data.getUserInfo().getHeadPortraitPath());
        }
        orderBarView.setAftersalesDox((int) data.getAfterSalesCount());//售后
        orderBarView.setWaitchargeDox((int) data.getWaitReceiptOrderCount());//待收货
        orderBarView.setWaitpayDox((int) data.getWaitPayOrderCount());//代付款
        orderBarView.setWaitsendDox((int) data.getWaitShipmentOrderCount());//待发货
    }

    private void setUserInfo() {
        if (userInfo.isIsStationUser()) {
            llStationStatus.setVisibility(View.VISIBLE);
            llStation.setVisibility(View.GONE);
            if (userInfo.getStationUserRoleName().equals("站长")) {
                ivLab.setImageResource(R.mipmap.icon_station);
            } else {
                ivLab.setImageResource(R.mipmap.icon_common);
            }
        } else {
            ivLab.setImageResource(R.mipmap.icon_vip);
            llStationStatus.setVisibility(View.GONE);
            llStation.setVisibility(View.VISIBLE);
        }
        tvName.setText(userInfo.getUserName());
    }

    //需要更新中心 需要使用event来通知
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThreadrep(MainEvent event) {
        if (event != null) {
            if (sharedPreferencesUtils.getLoginStatus()) {
                mPresenter.getUserInfoData();
            } else {
                IntentUtils.gotoActivity(getActivity(), LoginActivity.class);
            }
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBusInstance.getInstance().unRegisterEvent(this);
    }

    /**
     * 初始化沉浸式状态栏
     */
    protected void initStatusBar() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.fitsSystemWindows(true).statusBarColor(R.color.center_back).init();
    }

    /**
     * 销毁沉浸式状态栏
     */
    private void destroyStatusBar() {
        if (mImmersionBar != null) {
            mImmersionBar.destroy();
            mImmersionBar = null;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_message:
                enter(MessageCenterActivity.class, null);
                break;
            case R.id.ll_scan:
                enter(ScanQRActivity.class, "bindStation");
                break;
            case R.id.ll_code:
                enter(CreatQRActivity.class, null);
                break;
        }
        if (popWindow != null)
            popWindow.dissmiss();
    }
}