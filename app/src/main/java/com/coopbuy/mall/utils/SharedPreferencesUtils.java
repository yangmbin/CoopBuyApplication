package com.coopbuy.mall.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.coopbuy.mall.api.Constant;
import com.coopbuy.mall.api.reponse.UserCenterInfoResponse;


/**
 * @author chenshuangniu
 * @time 2016/5/31 22:02
 * @内容 sharedPreference工具 可以不使用 但可以创建
 * @版本
 */
public class SharedPreferencesUtils {
    public static final String KEY = "coolbuy.spkey";
    private static SharedPreferencesUtils mInstance;
    private static Context mContext;
    private SharedPreferences mPerference;
    private SharedPreferences.Editor mEditor;

    private SharedPreferencesUtils(Context context) {
        this.mContext = context;
    }

    public static synchronized SharedPreferencesUtils getInstance(Context context) {//单例
        if (mInstance == null) {
            mInstance = new SharedPreferencesUtils(context);
        }
        return mInstance;
    }

    /**
     * 保存cookie 这里是由于
     *
     * @param cookie
     */
    public void saveCookier(String cookie) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putString(Constant.COOKIE, cookie);
    }

    /**
     * 获得cookier
     *
     * @return
     */
    public String getCookier() {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        return sp.getString(Constant.COOKIE, "");
    }

    /**
     * 是否登录过
     *
     * @return
     */
    public Boolean getLoginStatus() {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        return sp.getBoolean(FinalConstant.is_login, false);
    }

    /**
     * 清除用户登录数据  其他的以后再添加
     */
    public void clearUserData() {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(FinalConstant.is_login, false);
        editor.putBoolean(FinalConstant.user_status_type, false);
        editor.putString(FinalConstant.user_phone, "");
        editor.apply();

    }

    /**
     * 保存登录信息
     */
    public void saveLoginStatus() {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(FinalConstant.is_login, true);
        editor.apply();
    }

    /**
     * 保存是否打开过引导页
     */
    public void saveFristGuide() {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(FinalConstant.FRISTGUIDE, true);
        editor.apply();
    }

    public boolean getFristGuide() {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        return sp.getBoolean(FinalConstant.FRISTGUIDE, false);
    }

    /**
     *
     */
    public void saveUserData(UserCenterInfoResponse response) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(FinalConstant.photo, response.getUserInfo().getPhone());
        editor.putBoolean(FinalConstant.user_status, response.getUserInfo().isIsStationUser());
        editor.putString(FinalConstant.user_status_type, response.getUserInfo().getStationUserRoleName());
        editor.apply();
    }

    /**
     * 得到用户电话号码
     *
     * @return
     */
    public String getUserPhone() {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        return sp.getString(FinalConstant.photo, "");
    }

    /**
     * 得到用户身份状态 是否是站长
     *
     * @return
     */
    public Boolean getUserState() {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        return sp.getBoolean(FinalConstant.user_status, false);
    }
}
