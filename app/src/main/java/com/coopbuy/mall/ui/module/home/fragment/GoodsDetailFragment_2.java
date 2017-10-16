package com.coopbuy.mall.ui.module.home.fragment;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.DescriptionResponse;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.module.home.activity.GoodsDetailActivity;
import com.coopbuy.mall.ui.module.home.model.GoodsDetailModel;
import com.coopbuy.mall.ui.module.home.presenter.GoodsDetailPresenter;
import com.coopbuy.mall.ui.module.home.view.GoodsDetail_IView;
import com.coopbuy.mall.widget.goodsdetail.ItemWebView;

import butterknife.Bind;

/**
 * 商品详情Fragment2
 *
 * @author ymb
 *         Create at 2017/7/25 10:23
 */
public class GoodsDetailFragment_2 extends ViewPagerBaseFragment<GoodsDetailPresenter, GoodsDetailModel> implements GoodsDetail_IView {
    @Bind(R.id.webView)
    ItemWebView webView;
    private WebSettings webSettings;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_goods_detail_2;
    }

    @Override
    public void initModel() {
        mModel = new GoodsDetailModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new GoodsDetailPresenter(mContext, mModel, this);
    }

    @Override
    protected void initView() {
        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setTextSize(WebSettings.TextSize.NORMAL);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSettings.setBlockNetworkImage(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setSupportZoom(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.setWebViewClient(new GoodsDetailWebViewClient());
    }

    @Override
    protected void onFragmentFirstVisible() {
        mPresenter.getDescriptionData(((GoodsDetailActivity) mContext).getProductId());
    }

    public void setDescriptionData(DescriptionResponse descriptionResponse) {
        //  加载、并显示HTML代码
        webView.loadDataWithBaseURL(null, descriptionResponse.getDescription(), "text/html", "charset=UTF-8", "");
    }

    private class GoodsDetailWebViewClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            webSettings.setBlockNetworkImage(false);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return true;
        }
    }
}
