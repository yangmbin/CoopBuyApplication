package com.coopbuy.mall.ui.mainpage.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.bean.CenterData;
import com.coopbuy.mall.ui.module.center.activity.AddressManageActivity;
import com.coopbuy.mall.ui.module.center.activity.HeplCenterActivity;
import com.coopbuy.mall.ui.module.center.activity.LoginActivity;
import com.coopbuy.mall.ui.module.center.activity.PersonalActivity;
import com.coopbuy.mall.ui.module.center.activity.PhoneChargeActivity;
import com.coopbuy.mall.ui.module.center.activity.SettingActivity;
import com.coopbuy.mall.ui.module.center.activity.StationRecommendActivity;
import com.coopbuy.mall.ui.module.center.adapter.CenterAdapter;
import com.coopbuy.mall.ui.module.test.activity.NiuTestActivity;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.widget.OrderBarView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 个人中心Fragment
 *
 * @author ymb
 *         Create at 2017/7/25 10:23
 */
public class ThreeFragment extends ViewPagerBaseFragment {
    @Bind(R.id.swipe_target)
    RecyclerView mRvTest;
    @Bind(R.id.circleImageView)
    SimpleDraweeView head;
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
    @Bind(R.id.ll_loaction)
    LinearLayout llLoaction;
    @Bind(R.id.ll_search)
    LinearLayout llSearch;
    @Bind(R.id.ll_title_bar)
    LinearLayout llTitleBar;
    @Bind(R.id.iv_setting)
    ImageView ivSetting;
    @Bind(R.id.iv_msg)
    ImageView ivMsg;
    @Bind(R.id.ll_line)
    LinearLayout llLine;

    private CenterAdapter adapter;
    private List<CenterData> mData;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_three;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
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
        head.setImageURI("http://upload.cankaoxiaoxi.com/2017/0601/1496319083789.jpg");
        orderBarView.setAftersalesDox((int) 1);//售后
        orderBarView.setWaitchargeDox((int) 2);//待收货
        orderBarView.setWaitpayDox((int) 3);//代付款
        orderBarView.setWaitsendDox((int) 5);//待发货
    }

    private void setInitTitle() {
        llLoaction.setVisibility(View.INVISIBLE);
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
        mData.add(new CenterData(getActivity().getResources().getString(R.string.lab_center_work), R.mipmap.icon_cneter_work));
        mData.add(new CenterData(getActivity().getResources().getString(R.string.lab_center_recommend), R.mipmap.icon_center_recommend));
    }

    @Override
    protected void onFragmentVisible(boolean isVisible) {
        super.onFragmentVisible(isVisible);
        if (isVisible) {
        } else {
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
                if (sharedPreferencesUtils.getLoginStatus()) {
                    IntentUtils.gotoActivity(getActivity(), PersonalActivity.class);
                } else {
                    IntentUtils.gotoActivity(getActivity(), LoginActivity.class);
                }

                break;
            case R.id.ll_shopcart:
                IntentUtils.gotoActivity(getActivity(), NiuTestActivity.class);
                break;
            case R.id.ll_collect:

                break;
            case R.id.ll_footmark:

                break;
            case R.id.ll_phone_fare:
                IntentUtils.gotoActivity(getActivity(), PhoneChargeActivity.class);
                break;
            case R.id.ll_broadband:

                break;
            case R.id.ll_station:
                IntentUtils.gotoActivity(getActivity(), StationRecommendActivity.class);
                break;
            case R.id.ll_help:
                IntentUtils.gotoActivity(getActivity(), HeplCenterActivity.class);
                break;
            case R.id.ll_address:
                IntentUtils.gotoActivity(getActivity(), AddressManageActivity.class);
                break;
            case R.id.iv_setting:
                IntentUtils.gotoActivity(getActivity(), SettingActivity.class);
                break;
            case R.id.iv_msg:
                break;
        }
    }


}
