package com.coopbuy.mall.ui.module.center.activity;

import android.text.TextUtils;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.utils.IntentUtils;
import com.tencent.smtt.sdk.WebView;

import butterknife.Bind;

public class MegHtmlActivity extends BaseActivity {

    private String url = "http://bbs.mb.qq.com/forum-112-1.html";
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
        String url = getIntent().getStringExtra(IntentUtils.PARAM1);
        if (!TextUtils.isEmpty(url)) {
            this.url = url;
        }
        forumContext.loadUrl(this.url);
        setHtmlLogo(true);
    }

}
