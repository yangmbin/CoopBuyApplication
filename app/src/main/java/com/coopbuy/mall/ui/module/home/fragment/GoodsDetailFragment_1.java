package com.coopbuy.mall.ui.module.home.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.mainpage.imageloader.BannerImageLoader;
import com.coopbuy.mall.utils.ScreenUtils;
import com.lzy.widget.VerticalSlide;
import com.lzy.widget.vertical.VerticalWebView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.iwgang.simplifyspan.SimplifySpanBuild;
import cn.iwgang.simplifyspan.other.SpecialGravity;
import cn.iwgang.simplifyspan.unit.SpecialLabelUnit;

/**
 * 商品详情Fragment1
 *
 * @author ymb
 *         Create at 2017/7/25 10:23
 */
public class GoodsDetailFragment_1 extends ViewPagerBaseFragment {
    @Bind(R.id.webView)
    VerticalWebView webView;
    @Bind(R.id.verticalSlide)
    VerticalSlide verticalSlide;
    @Bind(R.id.banner)
    Banner banner;
    @Bind(R.id.goods_name)
    TextView goodsName;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_goods_detail_1;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        setShowNextPageListener();
        initBanner();

        // 设置商品名
        SimplifySpanBuild simplifySpanBuild = new SimplifySpanBuild();
        simplifySpanBuild
                .append(new SpecialLabelUnit("自营", Color.WHITE, ScreenUtils.dip2px(mContext, 10), 0xFF51A400)
                        .setLabelBgRadius(10)
                        .setPadding(ScreenUtils.dip2px(mContext, 5))
                        .setGravity(SpecialGravity.CENTER))
                .append("  " + "商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称");
        goodsName.setText(simplifySpanBuild.build());
    }

    // 上拉查看详情页监听，显示时再加载
    private void setShowNextPageListener() {
        verticalSlide.setOnShowNextPageListener(new VerticalSlide.OnShowNextPageListener() {
            @Override
            public void onShowNextPage() {
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
                webView.loadDataWithBaseURL(null, sb.toString(), "text/html", "utf-8", null);
            }
        });
    }

    private void initBanner() {
        List list = new ArrayList();
        list.add("https://cd5n.pixabay.com/photo/2017/09/16/16/09/sea-2755908__340.jpg");
        list.add("https://cd5n.pixabay.com/photo/2017/09/09/21/55/noodles-2733636__340.jpg");
        banner.setImages(list).setImageLoader(new BannerImageLoader()).start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
