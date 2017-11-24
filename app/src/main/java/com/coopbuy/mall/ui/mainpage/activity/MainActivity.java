package com.coopbuy.mall.ui.mainpage.activity;

import android.content.Intent;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.CheckUpdateResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.mainpage.model.MainModel;
import com.coopbuy.mall.ui.mainpage.presenter.MainPresenter;
import com.coopbuy.mall.ui.mainpage.view.Main_IView;
import com.coopbuy.mall.utils.APPUpdateUtils;
import com.coopbuy.mall.utils.DeviceUtils;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.widget.APPUpdateDialog;
import com.coopbuy.mall.widget.navigation.BottomBar;

import butterknife.Bind;

public class MainActivity extends BaseActivity<MainPresenter, MainModel> implements Main_IView {
    public static final int MSG_INDEX = 0;
    public static final String FRAGMENT_INDEX = "fragment_index";
    public static final int HOME_FRAGMENT_INDEX = 0;
    public static final int MARKET_FRAGMENT_INDEX = 1;
    public static final int CENTER_FRAGMENT_INDEX = 2;

    @Bind(R.id.bottom_bar)
    BottomBar bottomBar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initModel() {
        mModel = new MainModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new MainPresenter(mContext, mModel, this);
      //  mPresenter.checkUpdate(DeviceUtils.getVersionName());
    }

    @Override
    public void initView() {

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        bottomBar.setCurrentView(intent.getIntExtra(FRAGMENT_INDEX, intent.getIntExtra(IntentUtils.TAB_INDEX,0)));
    }

    private void showUpdateDialog(String url, String title, String content) {
        final APPUpdateUtils appUpdateUtils = new APPUpdateUtils(mContext, url);
        final APPUpdateDialog dialog = new APPUpdateDialog(mContext, title, content);
        APPUpdateDialog.ClickCallBack clickCallBack = new APPUpdateDialog.ClickCallBack() {
            @Override
            public void onUpdate() {
                appUpdateUtils.downloadAPK(dialog);
            }

            @Override
            public void onClose() {
                appUpdateUtils.cancel();
            }
        };
        dialog.setCallBack(clickCallBack);
        dialog.show();
    }

    @Override
    public void setCheckUpdateData(CheckUpdateResponse checkUpdateResponse) {
        if (checkUpdateResponse.isHasNewVersion()) {
            showUpdateDialog(checkUpdateResponse.getDownLoadUrl(), checkUpdateResponse.getVersion(), checkUpdateResponse.getDescription());
        }
    }
}
