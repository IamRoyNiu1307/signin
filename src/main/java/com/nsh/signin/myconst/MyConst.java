package com.nsh.signin.myconst;

/**
 * @Auther: iamRoyNiu
 * @Date: 2019/1/2 19:14
 * @Description: 常数类
 */
public class MyConst {
    //服务器地址
    public static final String HOST = "http://localhost:8080";

    //微信小程序appid
    public static final String APPID = "wxde6415f50b2d05c3";
    //微信小程序appsecret
    public static final String APPSECRET = "300bda0ea35e7f536f4d8125dac6783a";
    //获取微信Openid的请求地址
    public static String WxGetOpenIdUrl = "https://api.weixin.qq.com/sns/jscode2session";
    //面部 用户组
    public static final String GROUPID = "group_stu";
    //公告图片所在的请求路径
    public static final String ANNO_IMAGE_PATH = HOST+"/static/fileUpload/anno/";
    //假条图片所在的请求路径
    public static final String LEAVEAPP_IMAGE_PATH = HOST+"/static/fileUpload/leaveapp/";
    //公告图片保存路径
    public static final String ANNO_UPLOAD_FILEPATH = "/Users/roy/project/signin/src/main/resources/static/fileUpload/anno/";
    //假条图片保存路径
    public static final String LEAVEAPP_UPLOAD_FILEPATH = "/Users/roy/project/signin/src/main/resources/static/fileUpload/leaveapp/";

    //第一节课上课时间
    public static final String FIRST_CLASS_START_TIME = "8:00";
    //第一节课下课时间
    public static final String FIRST_CLASS_END_TIME = "9:50";
    //第二节课上课时间
    public static final String SECOND_CLASS_START_TIME = "10:10";
    //第二节课下课时间
    public static final String SECOND_CLASS_END_TIME = "11:50";
    //第三节课上课时间
    public static final String THIRD_CLASS_START_TIME = "14:00";
    //第三节课下课时间
    public static final String THIRD_CLASS_END_TIME = "15:50";
    //第四节课上课时间
    public static final String FORTH_CLASS_START_TIME = "16:10";
    //第四节课下课时间
    public static final String FORTH_CLASS_END_TIME = "17:50";
}
