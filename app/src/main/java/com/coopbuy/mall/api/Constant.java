package com.coopbuy.mall.api;

/**
 * @author csn
 * @date 2017/8/1 0001 14:04
 * @content
 */
public class Constant {
   /* public static final String HOST = "http://dev.guinong.com:8810/";
    public static final String login = "api/Login/GetUser";
    public static final String cart = "api/Cart/GetCartList";*/


    /**
     * 主机地址
     */
    public static final String SERVER_URL = "http://dev.guinong.com:8858/";
    /**
     * 图片地址
     */
    public static final String IMAGE_SERVER_URL = "http://oss.coopbuy.com";
    /**
     * 登录
     */
    public static final String LOGIN = "Home/AppLogin";
    /**
     * 图形验证码
     */
    public static final String LOGIN_IMAGECODE = "api/services/app/member/GetCheckCode";
    /**
     * 获取短信验证码
     */
    public static final String LOGIN_SEDN_SMS_CODE = "api/services/app/member/SendSmsActivationCode";
    /**
     * 注册用户
     */
    public static final String LOGIN_REGISTER = "api/services/app/member/RegistMember";
    /**
     * 忘记密码   获取短信验证码
     */
    public static final String LOGIN_SME_RESTPASSWORD_GET_CODE = "api/services/app/member/SmsResetPassword";
    /**
     * 忘记密码   获取短信验证码后 请求修改
     */
    public static final String LOGIN_SME_RESTPASSWORD = "api/services/app/member/SmsResetUpdatePassword";
    /**
     * 退出登录  单独地址
     */
    public static final String LOGIN_QUIT = "https://shop.coopbuy.com/Home/AppLogOff";
    /**
     * 商品分类
     */
    public static final String COTEGORYS = "api/services/app/goodsCategoryCustomer/GetAllCategorys";


}
