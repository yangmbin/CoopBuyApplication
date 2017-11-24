package com.coopbuy.mall.utils;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.telephony.TelephonyManager;
import android.text.Selection;
import android.text.Spannable;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RatingBar;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xiaoyu on 2016/3/9.
 * 工具类
 */
public class CommonUtils {
    public static List<View> loadmap = new ArrayList<>();
    // email匹配
    private static final String EMAIL_MATCH_REGX = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
    //11位手机号
    private static final String MOBILE_MATCH_REGX = "^((13[0-9])|(14[0-9])|(15([0-9]))|(17([0-9]))|(18[0-9]))\\d{8}";// "[1]"代表第1位为数字1，"\\d{10}"代表后面是可以是0～9的数字，有10位。
    //车牌号
    private static final String LICENSENUM_MATCH_REGX = "[\\u4e00-\\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}";
    //18位身份证
    private static final String IDENTITY_MATCH_REGX = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";

    /**
     * 判断是否是合法身份证
     **/
    public static boolean isID(String identity) {
        Pattern p = Pattern.compile(IDENTITY_MATCH_REGX);
        Matcher m = p.matcher(identity);
        return m.matches();
    }

    /***
     * 得到屏幕分辨率高
     */
    @SuppressWarnings("deprecation")
    public static int getDisplayHeight(Context context) {
        Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        return display.getHeight();

    }

    /***
     * 得到屏幕分辨率宽
     */
    @SuppressWarnings("deprecation")
    public static int getDisplayWidth(Context context) {
        Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        return display.getWidth();
    }

    /**
     * 判断是否是邮箱
     **/
    public static boolean isEmail(String email) {
        Pattern p = Pattern.compile(EMAIL_MATCH_REGX);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 判断上午(0)还是下午(1)
     *
     * @return
     */
    public static int checkAmorPm() {
        long time = System.currentTimeMillis();
        final Calendar mca = Calendar.getInstance();
        mca.setTimeInMillis(time);
        return mca.get(Calendar.AM_PM);
    }

    /**
     * 验证手机号码 1开头就行
     */
    public static boolean isMobileNO(String mobiles) {
        return mobiles.matches(MOBILE_MATCH_REGX);
    }

    /**
     * 判断String是否为空
     **/
    public static boolean isEmpty(String string) {
        return string == null || string.length() == 0 || string.equals("null");
    }

    /**
     * 获取设备唯一编码
     **/
    public static String getImieStatus(Context _context) {
        TelephonyManager tm = (TelephonyManager) _context.getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = tm.getDeviceId();
        LogUtils.error("commonUtils", "deviceId ->" + deviceId);
        return deviceId;
    }

    /**
     * 去掉.00
     **/
    public static String getFloatWithoutZero(float price) {
        String priceStr = String.valueOf(price);
        if (priceStr.endsWith(".0")) {
            priceStr = priceStr.substring(0, priceStr.length() - 2);
        }
        return priceStr;
    }

    /**
     * 防止Button快速连点
     **/

    private static long lastClickTime;

    public static boolean isFastClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }


    /**
     * 得到渠道名
     **/
    public static String getUmengChannelName(Context context) {
        String key = "UMENG_CHANNEL";
        String channelName = "";
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
//注意此处为ApplicationInfo 而不是 ActivityInfo,因为友盟设置的meta-data是在application标签中，而不是某activity标签中，所以用ApplicationInfo
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
                if (applicationInfo != null) {
                    if (applicationInfo.metaData != null) {
//                        <span style = "white-space:pre" ></span >//key换成说需要的key
                        channelName = applicationInfo.metaData.getString(key);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        LogUtils.error("CommonUtils", channelName + "");
        return channelName;
    }

    public static String md5(String string) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }

    public static String getTime() {
        SimpleDateFormat sf;
        long time = System.currentTimeMillis();
        Date data = new Date(time);
        sf = new SimpleDateFormat("yyyy-MM-dd");
        return sf.format(data);
    }

    /**
     * 将光标移动到字符串末尾
     */
    public static void moveToLast(EditText editText) {
        CharSequence charSequence = editText.getText();
        if (charSequence instanceof Spannable) {
            Spannable spanText = (Spannable) charSequence;
            Selection.setSelection(spanText, charSequence.length());
        }
    }

    /**
     * 动态设置Ratingbar高度，解决图片在不同分辨率手机拉伸问题
     *
     * @param context
     * @param ratingBar
     * @param resourceId 本地图片资源Id
     */
    public static void setRatingBarHeight(Context context, RatingBar ratingBar, int resourceId) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId);
        int height = bitmap.getHeight();
        ViewGroup.LayoutParams params = ratingBar.getLayoutParams();
        params.height = height;
        ratingBar.setLayoutParams(params);
    }

    /*public static FrameLayout.LayoutParams getHW60(LoadingLayout layout) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) layout.getLayoutParams();
        layoutParams.width = CoolBuyApplication.context.getResources().getDimensionPixelOffset(R.dimen.divider_px80);
        layoutParams.height = CoolBuyApplication.context.getResources().getDimensionPixelOffset(R.dimen.divider_px80);
        layout.setDefineBackgroundColor(R.color.hint_color);
        return layoutParams;
    }

    public static void addLoadClick(String tag, View loadclick) {
        if (loadclick != null)
            loadmap.add(loadclick);
    }

    */

    /**
     * 设置可以点击
     *//*
    public static void setLoadCliced(Boolean cliced) {
        boolean isClick = SharedPreferencesUtils.getInstance(CoolBuyApplication.context).getErrorOnClick();
        for (int i = 0; i < loadmap.size(); i++) {
            if (isClick) {
                loadmap.get(i).setClickable(false);
            } else {
                loadmap.get(i).setClickable(cliced);
            }
        }
    }

    public static FrameLayout.LayoutParams getHWM(LoadingLayout layout) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) layout.getLayoutParams();
        layoutParams.width = FrameLayout.LayoutParams.MATCH_PARENT;
        layoutParams.height = FrameLayout.LayoutParams.MATCH_PARENT;
        layout.setDefineBackgroundColor(R.color.white);
        return layoutParams;
    }*/
    public static String getSystemTiem() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日- HH:mm:ss:SSS");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);
        return str;
    }

    /**
     * 判断微信是否可用
     *
     * @param context
     * @return
     */
    public static boolean isWeixinAvilible(Context context) {
        final PackageManager packageManager = context.getPackageManager();// 获取packagemanager
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals("com.tencent.mm")) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 判断qq是否可用
     *
     * @param context
     * @return
     */
    public static boolean isQQClientAvailable(Context context) {
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals("com.tencent.mobileqq")) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断微博是否可用
     *
     * @param context
     * @return
     */
    public static boolean isWeiboAvailable(@NonNull Context context) {
        PackageManager pm;
        if ((pm = context.getApplicationContext().getPackageManager()) == null) {
            return false;
        }
        List<PackageInfo> packages = pm.getInstalledPackages(0);
        for (PackageInfo info : packages) {
            String name = info.packageName.toLowerCase(Locale.ENGLISH);
            if ("com.sina.weibo".equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static String getImageNetSize(int size) {
        size = size * 2;//这里需要x2 才清晰
        if (size <= 200) {
            return "?x-oss-process=style/1x1_200";
        }
        if (200 < size && size < 400) {
            return "?x-oss-process=style/1x1_300";
        }
        if (400 <= size && size < 600) {
            return "?x-oss-process=style/1x1_500";
        }
        if (600 <= size && size < 800) {
            return "?x-oss-process=style/1x1_800";
        }
        if (800 <= size) {
            return "?x-oss-process=style/1x1_1080";
        }
        return "";
    }

    /**
     * 复制到剪贴板
     *
     * @param text
     */
    public static void copyToClipboard(Context context, String text) {
        ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        cm.setText(text);
        ToastUtils.toastShort("已复制到剪贴板");
    }

    /**
     * 获取状态栏高度
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}
