package com.coopbuy.mall.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.coopbuy.mall.api.reponse.HomeFloorResponse;
import com.coopbuy.mall.bean.HomeExtendData;
import com.coopbuy.mall.ui.mainpage.activity.HomeDetailActivity;
import com.coopbuy.mall.ui.mainpage.activity.MainActivity;
import com.coopbuy.mall.ui.module.center.activity.AfterSalesActivity;
import com.coopbuy.mall.ui.module.center.activity.OrderActivity;
import com.coopbuy.mall.ui.module.home.activity.CategoryActivity;
import com.coopbuy.mall.ui.module.home.activity.GoodsDetailActivity;
import com.coopbuy.mall.ui.module.home.activity.QrqWbActivity;
import com.coopbuy.mall.ui.module.home.activity.SearchResultActivity;
import com.coopbuy.mall.ui.module.home.activity.ShopDetailActivity;
import com.google.gson.Gson;

import java.io.Serializable;

/**
 * 页面跳转
 *
 * @author ymb
 *         Create at 2017/7/18 17:25
 */
public class IntentUtils {

    public static final String PARAM1 = "param1";
    public static final String PARAM2 = "param2";
    public static String TAB_INDEX = "index";
    public static String DATA = "data";
    public static String ORDER_TYPE = "order_type";
    public static String EVENT = "event";
    public static String INFO = "info";
    public static String BOO = "boo";
    public static final int REQUEST_SEARCH = 1;
    public static String TYPE = "type";//区别进入某个界面的类型

    /**
     * 无参无需返回结果
     *
     * @param context
     * @param activity
     */
    public static void gotoActivity(Context context, Class<?> activity) {
        context.startActivity((new Intent(context, activity)));
    }

    /**
     * 带一个参数无返回结果
     *
     * @param context
     * @param activity
     * @param param1
     */
    public static void gotoActivity(Context context, Class<?> activity, String param1) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(PARAM1, param1);
        context.startActivity(intent);
    }

    public static void gotoActivity(Context context, Class<?> activity, Serializable data) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(DATA, data);
        context.startActivity(intent);
    }

    public static void gotoActivity(Context context, Class<?> activity, int param1) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(PARAM1, param1);
        context.startActivity(intent);
    }

    public static void gotoActivity(Context context, Class<?> activity, double param1) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(PARAM1, param1);
        context.startActivity(intent);
    }

    /**
     * 我的订单
     *
     * @param context
     * @param type
     */
    public static void gotoOrderActivity(Context context, int type) {
        if (type == Constants.ORDER_TYPE_AFTERSALES)
            context.startActivity(new Intent(context, AfterSalesActivity.class));
        else
            context.startActivity((new Intent(context, OrderActivity.class).putExtra(ORDER_TYPE, type)));
    }

    /**
     * 我的订单，带ClearTop启动模式
     *
     * @param context
     * @param type
     */
    public static void gotoOrderActivityWithClearTop(Context context, int type) {
        if (type == Constants.ORDER_TYPE_AFTERSALES) {
            Intent intent = new Intent(context, AfterSalesActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
        } else {
            Intent intent = new Intent(context, OrderActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra(ORDER_TYPE, type);
            context.startActivity(intent);
        }
    }

    /**
     * 带参无需返回结果
     *
     * @param context
     * @param activity
     * @param data
     */
    public static void gotoActivity(Context context, Class<?> activity, Serializable data, String type) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data).putExtra(PARAM1, type)));
    }

    public static void gotoActivity(Context context, Class<?> activity, int type, int param2) {
        context.startActivity((new Intent(context, activity).putExtra(PARAM1, type).putExtra(PARAM2, param2)));
    }

    public static void gotoActivity(Context context, Class<?> activity, String param1, String param2) {
        context.startActivity((new Intent(context, activity).putExtra(PARAM1, param1).putExtra(PARAM2, param2)));
    }

    /**
     * 跳转至主页
     *
     * @param context
     * @param activity
     * @param fragmentIndex
     */
    public static void gotoMainActivity(Context context, Class<?> activity, int fragmentIndex) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(MainActivity.FRAGMENT_INDEX, fragmentIndex);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }

    /**
     * 返回该Activity 指定Fragment视图
     * 该Activity一般为SingleTask  模式
     *
     * @param context
     * @param index
     */
    public static void gotoMainActivity(Context context, int index) {
        context.startActivity((new Intent(context, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP).putExtra(TAB_INDEX, index)));
    }

    /**
     * 跳转到我的订单，带启动模式
     *
     * @param context
     * @param type
     */
    public static void gotoMeOrderActivityWithClearTop(Context context, int type) {
        Intent intent = new Intent(context, OrderActivity.class).putExtra(ORDER_TYPE, type);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    /**
     * 带启动模式跳转
     * @param context
     * @param activity
     */
    public static void gotoActivityWithClearTop(Context context, Class<?> activity) {
        Intent intent = new Intent(context, activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    /**
     * 从首页打开不同类型页面
     * @param context
     * @param type 0=商品页，1=搜索页，2=分类页，3=店铺页，4=链接，5=活动页
     * @param floorItemsBean
     */
    public static void gotoActivityFromHome(Context context, int type, HomeFloorResponse.FloorItemsBean floorItemsBean) {
        Gson gson = new Gson();
        HomeExtendData homeExtendData = new HomeExtendData();
        if (!TextUtils.isEmpty(floorItemsBean.getExtendData())) {
            try {
                homeExtendData = gson.fromJson(floorItemsBean.getExtendData(), HomeExtendData.class);
            } catch (Exception e) {}
        }
        switch (type) {
            case 0:
                gotoActivity(context, GoodsDetailActivity.class, floorItemsBean.getObjectId());
                break;
            case 1:
                gotoActivity(context, SearchResultActivity.class, homeExtendData.getKeyword(), homeExtendData.getCategoryId());
                break;
            case 2:
                gotoActivity(context, CategoryActivity.class);
                break;
            case 3:
                gotoActivity(context, ShopDetailActivity.class, floorItemsBean.getObjectId());
                break;
            case 4:
                if (!TextUtils.isEmpty(homeExtendData.getLink()))
                    gotoActivity(context, QrqWbActivity.class, homeExtendData.getLink());
                break;
            case 5:
                gotoActivity(context, HomeDetailActivity.class, floorItemsBean.getObjectId());
                break;
        }
    }
}
