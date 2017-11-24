package com.coopbuy.mall.widget.navigation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.activity.CreatQRActivity;
import com.coopbuy.mall.ui.module.center.activity.LoginActivity;
import com.coopbuy.mall.ui.module.center.activity.MessageCenterActivity;
import com.coopbuy.mall.ui.module.center.activity.ScanQRActivity;
import com.coopbuy.mall.ui.module.center.activity.ShopCartActivity;
import com.coopbuy.mall.ui.module.home.activity.LocationActivity;
import com.coopbuy.mall.ui.module.home.activity.SearchActivity;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.SharedPreferencesUtils;
import com.coopbuy.mall.widget.popwindow.CustomPopWindow;

import java.io.Serializable;

/**
 * 主页顶部bar
 *
 * @author ymb
 *         Create at 2017/7/21 15:53
 */
public class NavHomeBar extends RelativeLayout implements View.OnClickListener {

    private View mView;
    private LinearLayout ll_location, ll_search;
    private ImageView mCartBtn;
    private FrameLayout mMoreBtn;
    private Context mContext;
    private CustomPopWindow popWindow;

    public NavHomeBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mView = LayoutInflater.from(context).inflate(R.layout.nav_home_top, null);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mView.setLayoutParams(params);
        addView(mView);

        ll_location = mView.findViewById(R.id.ll_location);
        ll_search = mView.findViewById(R.id.ll_search);
        mCartBtn = mView.findViewById(R.id.iv_setting);
        mMoreBtn = mView.findViewById(R.id.more_btn);
        ll_location.setOnClickListener(this);
        ll_search.setOnClickListener(this);
        mCartBtn.setOnClickListener(this);
        mMoreBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_location:
                IntentUtils.gotoActivity(mContext, LocationActivity.class);
                break;
            case R.id.ll_search:
                IntentUtils.gotoActivity(mContext, SearchActivity.class);
                break;
            case R.id.iv_setting:
                if (SharedPreferencesUtils.getInstance(mContext).getLoginStatus()) {
                    IntentUtils.gotoActivity(mContext, ShopCartActivity.class);
                } else {
                    IntentUtils.gotoActivity(mContext, LoginActivity.class);
                }
                break;
            case R.id.more_btn:
                showPopBottom(view);
                break;
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
    }

    /**
     * 弹出popwindow（二维码、扫描等）
     *
     * @param v
     */
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
        if (((BaseActivity) mContext).sharedPreferencesUtils.getLoginStatus()) {
            IntentUtils.gotoActivity(mContext, activity, data);
        } else {
            IntentUtils.gotoActivity(mContext, LoginActivity.class);
        }
        if (popWindow != null)
            popWindow.dissmiss();
    }
}
