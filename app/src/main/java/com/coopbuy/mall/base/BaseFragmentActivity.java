package com.coopbuy.mall.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;

import com.coopbuy.mall.R;
import com.coopbuy.mall.widget.LoadingBox;
import com.coopbuy.mall.widget.navigation.TitleBar;
import com.guinong.net.NetworkException;
import com.guinong.net.request.IAsyncRequestState;
import com.guinong.net.utils.LogUtil;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * @author wangyu
 * @time 2017/8/4 0004 on 下午 14:09
 * @desc
 */
public abstract class BaseFragmentActivity<P extends BasePresenter, M extends BaseModel> extends FragmentActivity implements View.OnClickListener , TitleBar.TitleBarClickListener {
    private TitleBar mTitleBar;
    public P mPresenter;
    public M mModel;
    protected Context mContext;
    private LoadingBox box;
    protected String thisActivityName = "BaseActivity";
    public List<IAsyncRequestState> mNetCalls = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doBeforeSetContentView();
        setThisActivityName();
        setContentView(getLayoutId());
        mContext = this;
        if (mPresenter != null) {
            mPresenter.mContext = this;
        }
        if (findViewById(R.id.box) != null) {
            box = new LoadingBox(this, findViewById(R.id.box));
            box.setClickListener(this);
        }
        if (findViewById(R.id.title_bar) != null) {
            mTitleBar = (TitleBar) findViewById(R.id.title_bar);
            mTitleBar.setTitleBarClickListener(this);
        }
      //  GnwAppManager.getInstance(mContext).addActivity(this);
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
     * 用于统计页面组件
     */
    protected abstract void setThisActivityName();

    /**
     * 全覆盖加载框
     */
    public void showFillLoading() {
        box.showLoadingLayout();
    }

    /**
     * 显示透明加载框
     */
    public void showTransLoading() {
        box.showTransLoadingLayout();
    }

    /**
     * 显示无数据页面
     */
    public void showNoDataLayout() {
        box.showNoDataLayout();
    }

    /**
     * 显示无网络页面
     */
    public void showNetOffLayout() {
        box.showInternetOffLayout();
    }

    /**
     * 显示网络错误页面
     */
    public void showNetErrorLayout() {
        box.showExceptionLayout();
    }

    /**
     * 停止加载框
     */
    public void stopAll() {
        box.hideAll();
    }

    /**
     * 网络重载按钮监听
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        networkRetry();
    }

    /**
     * 网络重载按钮
     */
    protected void networkRetry() {
    }


    /**
     * 设置无网络信息
     * @param message
     */
    public void setNetOffMessage(String message) {
        box.setInternetOffMessage(message);
    }
    /**
     * TitleBar返回按钮
     */
    @Override
    public void clickTitleBarBack() {
        onBackPressed();
    }

    /**
     * TitleBar右边文字或按钮
     */
    @Override
    public void clickTitleBarRight() {

    }   @Override
    public void clickTitleBarRight(View v) {

    }

    /**
     * TitleBar返回按钮和手机back键执行动作一致
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    /**
     * 设置TitleBar标题
     *
     * @param title
     */
    public void setTitle(String title) {
        mTitleBar.setTitleText(title);
    }

    /**
     * 设置TitleBar标题
     *
     * @param titleResId
     */
    public void setTitle(int titleResId) {
        mTitleBar.setTitleText(titleResId);
    }

    /**
     * 设置TitleBar右边文字
     *
     * @param text
     */
    public void setRightText(String text) {
        mTitleBar.setRightText(text);
    }

    /**
     * 设置TitleBar右边文字
     *
     * @param textResId
     */
    public void setRightText(int textResId) {
        mTitleBar.setRightText(textResId);
    }

    /**
     * 设置TitleBar右边图片
     *
     * @param imageResId
     */
    public void setRightImage(int imageResId) {
        mTitleBar.setRightImage(imageResId);
    }


    public void onResume() {
        super.onResume();
       /* MobclickAgent.onPageStart(thisActivityName); //统计页面(仅有Activity的应用中SDK自动调用，不需要单独写。"SplashScreen"为页面名称，可自定义)
        MobclickAgent.onResume(this);          //统计时长
        //netWorkReceiver();
        LogUtil.error("加载", "onResume");*/
    }

    public void onPause() {
       // LogUtil.error("加载", "onPause");
        super.onPause();
/*        MobclickAgent.onPageEnd(thisActivityName); // （仅有Activity的应用中SDK自动调用，不需要单独写）保证 onPageEnd 在onPause 之前调用,因为 onPause 中会保存信息。"SplashScreen"为页面名称，可自定义
        MobclickAgent.onPause(this);*/
        //unregisterReceiver(mNetWorkReceiver);
    }

    /**
     * 添加网络请求到请求列表
     *
     * @param state
     */
    public void appendNetCall(IAsyncRequestState state) {
        mNetCalls.add(state);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDestroy();
        ButterKnife.unbind(this);
        if (!mNetCalls.isEmpty()) {
            for (IAsyncRequestState state : mNetCalls) {
                if (state != null)
                    state.cancel();

            }
            LogUtil.error("test", "network canceled");
        }
    }

    public void onError(NetworkException error) {

    }

}
