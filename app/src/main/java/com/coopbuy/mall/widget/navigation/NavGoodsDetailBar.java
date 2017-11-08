package com.coopbuy.mall.widget.navigation;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.coopbuy.mall.R;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

/**
 * 商品详情顶部
 * @author ymb
 * Create at 2017/7/21 15:53
 */
public class NavGoodsDetailBar extends RelativeLayout implements View.OnClickListener {

    private View mView;
    private Context mContext;
    private SlidingTabLayout slidingTabLayout;
    private FrameLayout fl_goback, fl_favorite;
    private ImageView iv_favorite;
    private int mFavoriteStatus = -1; // 当前的收藏状态
    private FavoriteClickListener mListener;

    public NavGoodsDetailBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mView = LayoutInflater.from(context).inflate(R.layout.nav_goods_detail_top, null);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mView.setLayoutParams(params);
        addView(mView);

        slidingTabLayout = mView.findViewById(R.id.tablayout);
        fl_goback = mView.findViewById(R.id.go_back);
        fl_favorite = mView.findViewById(R.id.fl_favorite);
        iv_favorite = mView.findViewById(R.id.iv_favorite);

        fl_goback.setOnClickListener(this);
        fl_favorite.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.go_back:
                ((Activity) mContext).finish();
                break;
            // 添加取消收藏
            case R.id.fl_favorite:
                if (mFavoriteStatus == 0)
                    mListener.addFavorite();
                else if (mFavoriteStatus == 1)
                    mListener.removeFavorite();
                break;
        }
    }

    public void setViewPager(ViewPager viewPager, String[] titles, FragmentActivity fragmentActivity, ArrayList<Fragment> fragments) {
        slidingTabLayout.setViewPager(viewPager, titles, fragmentActivity, fragments);
    }

    /**
     * 设置收藏按钮的显示
     * @param status -1:不显示 0：不选中 1：选中
     */
    public void setFavoriteBtnDisplay(int status) {
        mFavoriteStatus = status;
        if (status == -1) {
            fl_favorite.setVisibility(GONE);
        } else if (status == 0) {
            fl_favorite.setVisibility(VISIBLE);
            iv_favorite.setImageResource(R.mipmap.icon_recommend_unselect);
        } else {
            fl_favorite.setVisibility(VISIBLE);
            iv_favorite.setImageResource(R.mipmap.icon_recommend_select);
        }
    }

    /**
     * 设置收藏按钮监听
     * @param listener
     */
    public void setOnFavoriteClickListener(FavoriteClickListener listener) {
        mListener = listener;
    }

    /**
     * 收藏按钮监听
     */
    public interface FavoriteClickListener {
        void addFavorite();
        void removeFavorite();
    }
}
