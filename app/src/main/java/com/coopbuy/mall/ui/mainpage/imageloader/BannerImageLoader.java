package com.coopbuy.mall.ui.mainpage.imageloader;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.coopbuy.mall.api.Constant;
import com.coopbuy.mall.api.login.HomePageDataResponse;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.loader.ImageLoader;

/**
 * Banner图片加载器
 *
 * @author ymb
 *         Create at 2017/8/8 9:48
 */
public class BannerImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        HomePageDataResponse.FloorsBean.FloorItemsBean bean = (HomePageDataResponse.FloorsBean.FloorItemsBean) path;
        Uri uri = Uri.parse(Constant.IMAGE_SERVER_URL + bean.getImageUrl());
        imageView.setImageURI(uri);
    }

    @Override
    public ImageView createImageView(Context context) {
        SimpleDraweeView sdv = new SimpleDraweeView(context);
        return sdv;
    }
}
