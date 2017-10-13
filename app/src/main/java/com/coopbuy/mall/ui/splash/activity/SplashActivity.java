package com.coopbuy.mall.ui.splash.activity;

import android.os.Handler;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.SharedPreferencesUtils;

/**
 * @author csn
 * @time 2017/10/12 0012 10:25
 * @content 闪屏页  就是logo页  欢迎页
 */
public class SplashActivity extends BaseActivity {
    private long endTime;
    private long FINAL_TIME = 1500;
    private long startTime;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        startTime = System.currentTimeMillis();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!SharedPreferencesUtils.getInstance(this).getFristGuide()) {//打开引导页
            IntentUtils.gotoActivity(this, GuideActivity.class);
            SharedPreferencesUtils.getInstance(this).saveFristGuide();
            this.finish();
        } else {//进入广告页  这里需要判断网络的状态 如果不好 直接进入主界面
            endTime = System.currentTimeMillis();
            long finalTime = endTime - startTime;
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    IntentUtils.gotoActivity(SplashActivity.this, AdActivity.class);
                    finish();
                }
            }, FINAL_TIME - finalTime); //延迟2秒跳转
        }
    }
}
