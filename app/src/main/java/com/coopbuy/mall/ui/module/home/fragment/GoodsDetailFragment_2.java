package com.coopbuy.mall.ui.module.home.fragment;

import android.webkit.WebView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.module.home.model.GoodsDetailModel;
import com.coopbuy.mall.ui.module.home.presenter.GoodsDetailPresenter;
import com.coopbuy.mall.ui.module.home.view.GoodsDetail_IView;

import butterknife.Bind;

/**
 * 商品详情Fragment2
 *
 * @author ymb
 *         Create at 2017/7/25 10:23
 */
public class GoodsDetailFragment_2 extends ViewPagerBaseFragment<GoodsDetailPresenter, GoodsDetailModel> implements GoodsDetail_IView {
    @Bind(R.id.webView)
    WebView webView;

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

    }

    @Override
    protected void onFragmentFirstVisible() {
        StringBuilder sb = new StringBuilder();
        // 拼接一段HTML代码
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> 欢迎您 </title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<h2> 欢迎您访问<a href=\"http://www.cctv.com\">"
                + "Java联盟</a></h2>");
        sb.append("</body>");
        sb.append("</html>");

        //  加载、并显示HTML代码
        webView.loadDataWithBaseURL(null, sb.toString(), "text/html" , "utf-8", null);
    }
}
