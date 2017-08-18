package com.coopbuy.mall.ui.mainpage.fragment;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.FixLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.ScrollFixLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.login.HomePageDataResponse;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_1;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_2;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_3;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_4;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_5;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_6;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_7;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_8;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_9;
import com.coopbuy.mall.ui.mainpage.model.HomeModel;
import com.coopbuy.mall.ui.mainpage.presenter.HomePresenter;
import com.coopbuy.mall.ui.mainpage.view.Home_IView;
import com.coopbuy.mall.ui.module.home.activity.ScanQrCodeActivity;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ScreenUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

/**
 * 主页Fragment
 *
 * @author ymb
 *         Create at 2017/7/25 10:23
 */
@RuntimePermissions
public class OneFragment extends ViewPagerBaseFragment<HomePresenter, HomeModel> implements Home_IView, OnRefreshListener {

    @Bind(R.id.rv_home)
    RecyclerView mRvHome;
    @Bind(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;
    private DelegateAdapter mDelegateAdapter;
    private List<DelegateAdapter.Adapter> mAdapters = new LinkedList<>();
    private int mScrollY = 0;
    private HomeLayoutAdapter_9 mTopTitleBarAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_one;
    }

    @Override
    public void initModel() {
        mModel = new HomeModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new HomePresenter(mContext, mModel, this);
    }

    @Override
    protected void initView() {
        VirtualLayoutManager manager = new VirtualLayoutManager(mContext);
        mRvHome.setLayoutManager(manager);
        mDelegateAdapter = new DelegateAdapter(manager, false);
        mRvHome.setAdapter(mDelegateAdapter);

        // 刷新监听
        mRefreshLayout.setOnRefreshListener(this);

        // RecyclerView滑动监听设置颜色渐变
        mRvHome.addOnScrollListener(mTitleBarColorListener);
    }

    @Override
    protected void onFragmentVisible(boolean isVisible) {
        super.onFragmentVisible(isVisible);
        if (isVisible) {
        } else {
        }
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
        mPresenter.getHomeData(false);
    }

    @Override
    protected void networkRetry() {
        super.networkRetry();
        mPresenter.getHomeData(false);
    }

    @Override
    public void setHomeData(HomePageDataResponse homePageDataResponse) {
        if (homePageDataResponse == null)
            return;
        mAdapters.clear();
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRvHome.setRecycledViewPool(viewPool);
        List<HomePageDataResponse.FloorsBean> floors = homePageDataResponse.getFloors();
        for (int i = 0; i < floors.size(); i++) {
            viewPool.setMaxRecycledViews(i, 10);
            String templateKey = floors.get(i).getTemplateKey();
            List<HomePageDataResponse.FloorsBean> decoration;
            switch (templateKey) {
                case "banner-slider-2":
                    decoration = new ArrayList<>();
                    decoration.add(floors.get(i));
                    mAdapters.add(new HomeLayoutAdapter_1(mContext, decoration, new SingleLayoutHelper()));
                    break;
                case "icons-image-1":
                    GridLayoutHelper gridIconHelper = new GridLayoutHelper(4);
                    gridIconHelper.setAutoExpand(false);
                    mAdapters.add(new HomeLayoutAdapter_2(mContext, floors.get(i).getFloorItems(), gridIconHelper));
                    break;
                case "banner-image-1":
                    decoration = new ArrayList<>();
                    decoration.add(floors.get(i));
                    SingleLayoutHelper bannerImage1Helper = new SingleLayoutHelper();
                    bannerImage1Helper.setMarginTop(ScreenUtils.dp2px(mContext, 5));
                    mAdapters.add(new HomeLayoutAdapter_3(mContext, decoration, bannerImage1Helper));
                    break;
                case "banner-slider-1":
                    decoration = new ArrayList<>();
                    decoration.add(floors.get(i));
                    SingleLayoutHelper bannerSlider1Helper = new SingleLayoutHelper();
                    bannerSlider1Helper.setMarginTop(ScreenUtils.dp2px(mContext, 5));
                    mAdapters.add(new HomeLayoutAdapter_4(mContext, decoration, bannerSlider1Helper));
                    break;
                case "goods-list-1":
                    GridLayoutHelper gridListTwoHelper = new GridLayoutHelper(2);
                    gridListTwoHelper.setAutoExpand(false);
                    int gridListTwoMargin = ScreenUtils.dp2px(mContext, 5);
                    gridListTwoHelper.setMargin(gridListTwoMargin, gridListTwoMargin, gridListTwoMargin, 0);
                    gridListTwoHelper.setGap(gridListTwoMargin);
                    gridListTwoHelper.setHGap(gridListTwoMargin);
                    mAdapters.add(new HomeLayoutAdapter_5(mContext, floors.get(i).getFloorItems(), gridListTwoHelper));
                    break;
                case "goods-list-2":
                    LinearLayoutHelper linearListHelper = new LinearLayoutHelper();
                    linearListHelper.setDividerHeight(ScreenUtils.dp2px(mContext, 1));
                    mAdapters.add(new HomeLayoutAdapter_6(mContext, floors.get(i).getFloorItems(), linearListHelper));
                    break;
                case "icons-image-2":
                    GridLayoutHelper gridListThreeHelper = new GridLayoutHelper(3);
                    gridListThreeHelper.setAutoExpand(false);
                    gridListThreeHelper.setMarginTop(ScreenUtils.dp2px(mContext, 5));
                    mAdapters.add(new HomeLayoutAdapter_7(mContext, floors.get(i).getFloorItems(), gridListThreeHelper));
                    break;
                default:
                    break;
            }
            // 返回顶部按钮
            goBackTopPosition();
        }

        // 顶部标题栏
        showTopTitleBar();

        mDelegateAdapter.setAdapters(mAdapters);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPresenter.getHomeData(true);
    }

    @Override
    public void stopPullToRefreshLoading() {
        mRefreshLayout.finishRefresh();
    }

    /**
     * 悬浮按钮点击返回顶部按钮和监听
     */
    private void goBackTopPosition() {
        if (mAdapters.size() == 4) {
            ScrollFixLayoutHelper scrollFixLayoutHelper = new ScrollFixLayoutHelper(FixLayoutHelper.BOTTOM_RIGHT, ScreenUtils.dip2px(mContext, 15), ScreenUtils.dip2px(mContext, 15));
            scrollFixLayoutHelper.setShowType(ScrollFixLayoutHelper.SHOW_ON_LEAVE);
            List<Object> tmp = new ArrayList<>();
            tmp.add(new Object());
            mAdapters.add(new HomeLayoutAdapter_8(mContext, tmp, scrollFixLayoutHelper, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int itemCount = 0;
                    for (int i = 0; i < mAdapters.size(); i++) {
                        if (i == 5)
                            break;
                        itemCount += mAdapters.get(i).getItemCount();
                    }
                    mRvHome.scrollToPosition(itemCount);
                    mRvHome.smoothScrollToPosition(0);
                }
            }));
        }
    }

    /**
     * RecyclerView滑动监听改变标题栏颜色
     */
    private RecyclerView.OnScrollListener mTitleBarColorListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            mScrollY += dy;
            if (!recyclerView.canScrollVertically(-1))
                mScrollY = 0;
            if (mTopTitleBarAdapter != null && mTopTitleBarAdapter.getTitleBarLayout() != null) {
                int bounds = mTopTitleBarAdapter.getTitleBarLayout().getHeight() * 3;
                if (mScrollY <= bounds) {
                    float scale = (float) mScrollY / bounds;
                    float alpha = scale * 255;
                    mTopTitleBarAdapter.getTitleBarLayout().setBackgroundColor(Color.argb((int) alpha, 111, 203, 21));
                } else {
                    mTopTitleBarAdapter.getTitleBarLayout().setBackgroundColor(Color.rgb(111, 203, 21));
                }
            }
        }
    };

    /**
     * 显示顶部标题栏
     */
    private void showTopTitleBar() {
        FixLayoutHelper fixLayoutHelper = new FixLayoutHelper(FixLayoutHelper.TOP_LEFT, 0, 0);
        fixLayoutHelper.setSketchMeasure(true);
        List<Object> tmp = new ArrayList<>();
        tmp.add(new Object());
        mTopTitleBarAdapter = new HomeLayoutAdapter_9(mContext, tmp, fixLayoutHelper, this);
        mAdapters.add(mTopTitleBarAdapter);
    }


    /**
     * 二维码扫描相关动态权限处理
     */
    @OnShowRationale({android.Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    public void showRationaleForPermission(final PermissionRequest request) {
        new AlertDialog.Builder(mContext)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        request.proceed();
                    }
                })
                .setNegativeButton("拒绝", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        request.cancel();
                    }
                })
                .setCancelable(false)
                .setMessage("扫描二维码需要相机和SD卡权限")
                .show();
    }

    @NeedsPermission({android.Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    public void gotoScanQRCodeActivity() {
        IntentUtils.gotoActivity(mContext, ScanQrCodeActivity.class);
    }

    @OnPermissionDenied({android.Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    public void showPermissionDenied() {
        ToastUtils.toastShort("您已拒绝打开权限");
    }

    @OnNeverAskAgain({android.Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    public void onRecordNeverAskAgain() {
        new AlertDialog.Builder(mContext)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        if(Build.VERSION.SDK_INT >= 9){
                            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                            intent.setData(Uri.fromParts("package", mContext.getPackageName(), null));
                        } else if(Build.VERSION.SDK_INT <= 8){
                            intent.setAction(Intent.ACTION_VIEW);
                            intent.setClassName("com.android.settings","com.android.settings.InstalledAppDetails");
                            intent.putExtra("com.android.settings.ApplicationPkgName", mContext.getPackageName());
                        }
                        startActivity(intent);
                        dialog.cancel();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setCancelable(false)
                .setMessage("您已经禁止了相关权限，是否现在去开启")
                .show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        OneFragmentPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    public void requestPermission() {
        OneFragmentPermissionsDispatcher.gotoScanQRCodeActivityWithCheck(this);
    }
}
