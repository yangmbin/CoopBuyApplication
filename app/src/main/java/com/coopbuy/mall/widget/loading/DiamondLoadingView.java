package com.coopbuy.mall.widget.loading;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;


/**
 * 菱形加载图
 *
 * @author ymb
 *         Create at 2017/5/26 19:02
 */
public class DiamondLoadingView extends FrameAnimView {

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public DiamondLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
