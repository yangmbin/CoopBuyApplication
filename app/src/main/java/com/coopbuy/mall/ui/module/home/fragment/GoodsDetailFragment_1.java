package com.coopbuy.mall.ui.module.home.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.mainpage.imageloader.BannerImageLoader;
import com.coopbuy.mall.ui.module.home.activity.ShopDetailActivity;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ScreenUtils;
import com.coopbuy.mall.widget.dialog.GoodsAttrsDialog;
import com.coopbuy.mall.widget.dialog.GoodsParamsDialog;
import com.lzy.widget.VerticalSlide;
import com.lzy.widget.vertical.VerticalWebView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
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
                        .setLabelBgRadius(50)
                        .setPadding(ScreenUtils.dip2px(mContext, 5))
                        .setGravity(SpecialGravity.CENTER))
                .append("  " + "商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称");
        goodsName.setText(simplifySpanBuild.build());
    }

    /**
     * 上拉查看详情页监听，显示时再加载   注意：到时候需要设置显示一次即可
     */
    private void setShowNextPageListener() {
        verticalSlide.setOnShowNextPageListener(new VerticalSlide.OnShowNextPageListener() {
            @Override
            public void onShowNextPage() {
                Log.e("yangmbin", "showNextPage");

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

    @OnClick({R.id.btn_goods_params, R.id.btn_goods_attrs, R.id.btn_go_shop})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.btn_goods_params:
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 7; i++)
                    list.add("");
                GoodsParamsDialog goodsParamsDialog = new GoodsParamsDialog(mContext, list);
                goodsParamsDialog.showAtBottom();
                break;
            case R.id.btn_goods_attrs:
                list = new ArrayList<>();
                for (int i = 0; i < 2; i++)
                    list.add("");
                GoodsAttrsDialog goodsAttrsDialog = new GoodsAttrsDialog(mContext, list);
                goodsAttrsDialog.showAtBottom();
                break;
            // 进店逛逛
            case R.id.btn_go_shop:
                IntentUtils.gotoActivity(mContext, ShopDetailActivity.class);
                break;
        }
    }

}
