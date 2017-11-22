package com.coopbuy.mall.ui.module.center.activity;

import android.os.Bundle;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.tencent.smtt.sdk.WebView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MegHtmlActivity extends BaseActivity {


    @Bind(R.id.forum_context)
    WebView forumContext;

    @Override
    public int getLayoutId() {
        return R.layout.activity_meg_html;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        forumContext.loadUrl("https://x5.tencent.com/tbs/guide/sdkInit.html");
    }

}
