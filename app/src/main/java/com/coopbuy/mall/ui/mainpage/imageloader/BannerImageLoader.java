package com.coopbuy.mall.ui.mainpage.imageloader;

import android.content.Context;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import com.coopbuy.mall.R;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
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
        Uri uri = Uri.parse(path.toString());
        imageView.setImageURI(uri);
    }

    @Override
    public ImageView createImageView(Context context) {
        SimpleDraweeView sdv = new SimpleDraweeView(context);
        GenericDraweeHierarchy hierarchy = new GenericDraweeHierarchyBuilder(context.getResources())
                .setPlaceholderImage(R.mipmap.default_img)
                .build();
        sdv.setHierarchy(hierarchy);
        sdv.setBackgroundColor(ContextCompat.getColor(context, R.color.bitmap_base_color));
        return sdv;
    }
}
