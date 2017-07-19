package com.coopbuy.mall.base;


import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.coopbuy.mall.R;
import com.coopbuy.mall.widget.LoadingBox;

import butterknife.ButterKnife;

/**
 * Activity抽象类
 * @author ymb
 * Create at 2017/7/13 11:19
 */
public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity {
    public P mPresenter;
    public M mModel;
    public Context mContext;
    public LoadingBox box;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doBeforeSetContentView();
        setContentView(getLayoutId());
        mContext = this;
        if (mPresenter != null) {
            mPresenter.mContext = this;
        }
        box = new LoadingBox(this, findViewById(R.id.box));
        ButterKnife.bind(this);
        this.initModel();
        this.initView();
        this.initPresenter();
    }

    /**
     * 设置layout前配置（设置无标题、竖屏或着色状态栏等）
     */
    private void doBeforeSetContentView() {
        // 无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    /**
     * 获取布局文件
     */
    public abstract int getLayoutId();

    /**
     * 初始化Model
     */
    public abstract void initModel();

    /**
     * 初始化Presenter
     */
    public abstract void initPresenter();

    /**
     * 初始化View
     */
    public abstract void initView();

    /**
     * 全覆盖加载框
     */
    public void showFillLoading() {
        box.showLoadingLayout();
    }

    /**
     * 停止加载框
     */
    public void stopLoading() {
        box.hideAll();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDestroy();
        ButterKnife.unbind(this);
    }

}
