package com.coopbuy.mall.ui.module.home.adapter;


import android.content.Context;
import android.net.Uri;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.Constant;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.ui.mainpage.imageloader.BannerImageLoader;
import com.coopbuy.mall.ui.module.home.activity.BannerDetailActivity;
import com.coopbuy.mall.utils.IntentUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.List;

public class BannerDetailLayoutAdapter_1 extends BaseDelegateAdapter<String> {

    public BannerDetailLayoutAdapter_1(Context ctx, List<String> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_1_banner_detail;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final String item) {
        ((SimpleDraweeView) holder.getView(R.id.sdv_image)).setImageURI(Uri.parse(Constant.IMAGE_SERVER_URL + item));
    }
}
