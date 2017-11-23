package com.coopbuy.mall.ui.mainpage.fragment;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.FixLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.ScrollFixLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.HomeFloorResponse;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_0;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_1;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_10;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_2;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_3_1;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_3_2;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_4;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_5;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_6;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_7_1;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_7_2;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_8;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_9;
import com.coopbuy.mall.ui.mainpage.model.HomeModel;
import com.coopbuy.mall.ui.mainpage.presenter.HomePresenter;
import com.coopbuy.mall.ui.mainpage.view.Home_IView;
import com.coopbuy.mall.utils.ScreenUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

/**
 * 主页Fragment
 *
 * @author ymb
 *         Create at 2017/7/25 10:23
 */
//@RuntimePermissions
public class HomeFragment extends ViewPagerBaseFragment<HomePresenter, HomeModel> implements Home_IView, OnRefreshListener {

    public static final String LAYOUT_TYPE_1 = "template-banner-1";
    public static final String LAYOUT_TYPE_2 = "template-icon-1";
    public static final String LAYOUT_TYPE_3 = "template-banner-2";
    public static final String LAYOUT_TYPE_4 = "template-remember-1";
    public static final String LAYOUT_TYPE_5 = "template-product-list-1";
    public static final String LAYOUT_TYPE_6 = "template-product-list-2";
    public static final String LAYOUT_TYPE_7 = "template-product-list-3";
    public static final String LAYOUT_TYPE_8 = "template-product-list-4";
    public static final String LAYOUT_TYPE_9 = "template-product-list-5";

    @Bind(R.id.rv_home)
    RecyclerView mRvHome;
    @Bind(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;
    private DelegateAdapter mDelegateAdapter;
    private List<DelegateAdapter.Adapter> mAdapters = new LinkedList<>();
    // 首页Fragment状态栏是白色的，做特殊处理
    private ImmersionBar mImmersionBar = null;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
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
        mRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    protected void onFragmentFirstVisible() {
        mPresenter.getHomeData(false);
    }

    @Override
    protected void networkRetry() {
        mPresenter.getHomeData(false);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPresenter.getHomeData(true);
    }

    @Override
    public void stopPullToRefreshLoading() {
        if (mRefreshLayout != null)
            mRefreshLayout.finishRefresh();
    }

    /**
     * 悬浮按钮点击返回顶部按钮和监听
     */
    private void goBackTopPosition() {
        ScrollFixLayoutHelper scrollFixLayoutHelper = new ScrollFixLayoutHelper(FixLayoutHelper.BOTTOM_RIGHT, ScreenUtils.dip2px(mContext, 15), ScreenUtils.dip2px(mContext, 232));
//        scrollFixLayoutHelper.setShowType(ScrollFixLayoutHelper.SHOW_ON_LEAVE);
        scrollFixLayoutHelper.setShowType(ScrollFixLayoutHelper.SHOW_ON_ENTER);
        List<Object> tmp = new ArrayList<>();
        tmp.add(new Object());
        mAdapters.add(new HomeLayoutAdapter_10(mContext, tmp, scrollFixLayoutHelper, new View.OnClickListener() {
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

    @Override
    protected void onFragmentVisible(boolean isVisible) {
        if (isVisible) {
            initStatusBar();
        } else {
            destroyStatusBar();
        }
    }

    /**
     * 初始化沉浸式状态栏
     */
    protected void initStatusBar() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.fitsSystemWindows(true).statusBarColor(R.color.white).statusBarDarkFont(true, 0.2f).init();
    }

    /**
     * 销毁沉浸式状态栏
     */
    private void destroyStatusBar() {
        if (mImmersionBar != null) {
            mImmersionBar.destroy();
            mImmersionBar = null;
        }
    }


    /**
     * 设置网络返回数据
     * @param homeFloorResponseList
     */
    @Override
    public void setHomeData(List<HomeFloorResponse> homeFloorResponseList) {
        mAdapters.clear();
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRvHome.setRecycledViewPool(viewPool);

        for (int i = 0; i < homeFloorResponseList.size(); i++) {
            HomeFloorResponse item = homeFloorResponseList.get(i);
            // 头部标题（判断一下，如果布局是空的，下拉刷新失效）
            List list_0 = new ArrayList();
            list_0.add(item);
            if (item.isIsShowTitle() || !TextUtils.isEmpty(item.getTitleImage()))
                mAdapters.add(new HomeLayoutAdapter_0(mContext, list_0, new SingleLayoutHelper()));

            switch (item.getTemplateKey()) {
                case LAYOUT_TYPE_1:
                    List list_1 = new ArrayList<>();
                    list_1.add(item);
                    mAdapters.add(new HomeLayoutAdapter_1(mContext, list_1, new SingleLayoutHelper()));
                    break;
                case LAYOUT_TYPE_2:
                    GridLayoutHelper helper_2 = new GridLayoutHelper(5);
                    helper_2.setPaddingTop(ScreenUtils.dip2px(mContext, 20));
                    helper_2.setPaddingBottom(ScreenUtils.dip2px(mContext, 22));
                    helper_2.setVGap(ScreenUtils.dip2px(mContext, 20));
                    helper_2.setBgColor(ContextCompat.getColor(mContext, R.color.white));
                    helper_2.setAutoExpand(false);
                    mAdapters.add(new HomeLayoutAdapter_2(mContext, item.getFloorItems(), helper_2));
                    break;
                case LAYOUT_TYPE_3:
                    List list_3_1 = new ArrayList<>();
                    list_3_1.add(item);
                    mAdapters.add(new HomeLayoutAdapter_3_1(mContext, list_3_1, new SingleLayoutHelper()));
                    break;
                case LAYOUT_TYPE_4:
                    List list_3_2 = new ArrayList<>();
                    list_3_2.add(item);
                    mAdapters.add(new HomeLayoutAdapter_3_2(mContext, list_3_2, new SingleLayoutHelper()));
                    break;
                case LAYOUT_TYPE_5:
                    LinearLayoutHelper helper_4 = new LinearLayoutHelper();
                    helper_4.setDividerHeight(ScreenUtils.dip2px(mContext, 2));
                    mAdapters.add(new HomeLayoutAdapter_4(mContext, item.getFloorItems(), helper_4));
                    break;
                case LAYOUT_TYPE_6:
                    SingleLayoutHelper helper_5 = new SingleLayoutHelper();
                    mAdapters.add(new HomeLayoutAdapter_5(mContext, item.getFloorItems(), helper_5));
                    break;
                case LAYOUT_TYPE_7:
                    SingleLayoutHelper helper_6 = new SingleLayoutHelper();
                    List list_6 = new ArrayList<>();
                    list_6.add(item);
                    mAdapters.add(new HomeLayoutAdapter_6(mContext, list_6, helper_6));
                    break;
                case LAYOUT_TYPE_8:
                    SingleLayoutHelper helper_7_1 = new SingleLayoutHelper();
                    List list_7_1 = new ArrayList<>();
                    list_7_1.add(item);
                    mAdapters.add(new HomeLayoutAdapter_7_1(mContext, list_7_1, helper_7_1));

                    LinearLayoutHelper helper_7_2 = new LinearLayoutHelper();
                    helper_7_2.setPaddingBottom(ScreenUtils.dip2px(mContext, 10));
                    helper_7_2.setBgColor(ContextCompat.getColor(mContext, R.color.white));
                    List list_7_2 = new ArrayList();
                    list_7_2.addAll(item.getFloorItems().subList(1, item.getFloorItems().size()));
                    mAdapters.add(new HomeLayoutAdapter_7_2(mContext, list_7_2, helper_7_2));
                    break;
                case LAYOUT_TYPE_9:
                    GridLayoutHelper helper_8 = new GridLayoutHelper(2);
                    helper_8.setAutoExpand(false);
                    helper_8.setGap(ScreenUtils.dip2px(mContext, 15));
                    helper_8.setPadding(ScreenUtils.dip2px(mContext, 15), ScreenUtils.dip2px(mContext, 15), ScreenUtils.dip2px(mContext, 15), ScreenUtils.dip2px(mContext, 15));
                    helper_8.setBgColor(ContextCompat.getColor(mContext, R.color.white));
                    mAdapters.add(new HomeLayoutAdapter_8(mContext, item.getFloorItems(), helper_8));
                    break;
            }
        }
        // 尾部
        List list_9 = new ArrayList();
        list_9.add(new Object());
        mAdapters.add(new HomeLayoutAdapter_9(mContext, list_9, new SingleLayoutHelper()));

        for (int i = 0; i < mAdapters.size(); i++)
            viewPool.setMaxRecycledViews(i, 10);
        mDelegateAdapter.setAdapters(mAdapters);
        mDelegateAdapter.notifyDataSetChanged();
    }

    //    /**
//     * 二维码扫描相关动态权限处理
//     */
//    @OnShowRationale({android.Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE})
//    public void showRationaleForPermission(final PermissionRequest request) {
//        new AlertDialog.Builder(mContext)
//                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        request.proceed();
//                    }
//                })
//                .setNegativeButton("拒绝", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        request.cancel();
//                    }
//                })
//                .setCancelable(false)
//                .setMessage("扫描二维码需要相机和SD卡权限")
//                .show();
//    }
//
//    @NeedsPermission({android.Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE})
//    public void gotoScanQRCodeActivity() {
//        IntentUtils.gotoActivity(mContext, ScanQrCodeActivity.class);
//    }
//
//    @OnPermissionDenied({android.Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE})
//    public void showPermissionDenied() {
//        ToastUtils.toastShort("您已拒绝打开权限");
//    }
//
//    @OnNeverAskAgain({android.Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE})
//    public void onRecordNeverAskAgain() {
//        new AlertDialog.Builder(mContext)
//                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Intent intent = new Intent();
//                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        if(Build.VERSION.SDK_INT >= 9){
//                            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
//                            intent.setData(Uri.fromParts("package", mContext.getPackageName(), null));
//                        } else if(Build.VERSION.SDK_INT <= 8){
//                            intent.setAction(Intent.ACTION_VIEW);
//                            intent.setClassName("com.android.settings","com.android.settings.InstalledAppDetails");
//                            intent.putExtra("com.android.settings.ApplicationPkgName", mContext.getPackageName());
//                        }
//                        startActivity(intent);
//                        dialog.cancel();
//                    }
//                })
//                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                    }
//                })
//                .setCancelable(false)
//                .setMessage("您已经禁止了相关权限，是否现在去开启")
//                .show();
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        HomeFragmentPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
//    }
//
//    public void requestPermission() {
//        HomeFragmentPermissionsDispatcher.gotoScanQRCodeActivityWithCheck(this);
//    }
}
