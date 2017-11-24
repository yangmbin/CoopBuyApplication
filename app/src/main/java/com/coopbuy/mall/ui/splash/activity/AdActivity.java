package com.coopbuy.mall.ui.splash.activity;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.mainpage.activity.MainActivity;
import com.coopbuy.mall.utils.Constants;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.SharedPreferencesUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.OnClick;

public class AdActivity extends BaseActivity {

    @Bind(R.id.tv_countdown)
    TextView tvCountdown;
    private int recLen = 3;
    @Bind(R.id.adFaceImage)
    SimpleDraweeView adFaceImage;
    Timer timer = new Timer();

    private Boolean isEnter = false;

    @Override
    public int getLayoutId() {
        return R.layout.activity_ad;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (!isEnter) {
                        recLen--;
                        if (null != tvCountdown) {
                            tvCountdown.setText("" + recLen);
                            if (recLen < 1) {
                                timer.cancel();
                                enterMain();
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            });
        }
    };

    @Override
    public void initView() {
        if (!SharedPreferencesUtils.getInstance(this).getFristGuide()) {//打开引导页
            IntentUtils.gotoActivity(this, GuideActivity.class);
            SharedPreferencesUtils.getInstance(this).saveFristGuide();
            this.finish();
            if (task != null)
                task.cancel();
        } else {//进入广告页  这里需要判断网络的状态 如果不好 直接进入主界面
            adFaceImage.setImageURI(Constants.images[(new Random().nextInt(12) + 1)]);
            timer.schedule(task, 1000, 1000);
        }
    }

    @OnClick({R.id.adFaceImage, R.id.ll_enter})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.adFaceImage:
                ToastUtils.toastShort("跳转广告页。。。");
                break;
            case R.id.ll_enter:
                enterMain();
                isEnter = true;
                break;
        }
    }

    private void enterMain() {
        if (!isEnter) {
            IntentUtils.gotoActivity(this, MainActivity.class);
            finish();
        } else {
            finish();
            return;
        }
    }

    @Override
    protected void initStatusBar() {
    }
}
