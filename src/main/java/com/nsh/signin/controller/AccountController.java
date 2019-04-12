package com.nsh.signin.controller;

import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import com.nsh.signin.entity.Course;
import com.nsh.signin.entity.StudentAccount;
import com.nsh.signin.entity.StudentInfo;
import com.nsh.signin.myconst.MyConst;
import com.nsh.signin.service.CheckLogService;
import com.nsh.signin.service.CourseService;
import com.nsh.signin.service.StudentAccountService;
import com.nsh.signin.service.StudentInfoService;
import com.nsh.signin.util.HttpRequestUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 账号Controller---微信端
 */
@RestController
@RequestMapping("/wx")
public class AccountController {

    @Autowired
    private StudentAccountService studentAccountService;
    @Autowired
    private StudentInfoService studentInfoService;
    @Autowired
    private CheckLogService checkLogService;
    @Autowired
    private CourseService courseService;

    private JsonParser jp=new JsonParser();


    /**
     * 用于微信号和校园网账号的绑定
     * @param studentAccount 微信端传来的校园网账号密码
     * @return Map
     */
    @RequestMapping(value = "/bind",method = RequestMethod.POST)
    public Map toLogin(@RequestBody StudentAccount studentAccount){
        Map map = new HashMap();
        System.out.println("toBind..");
        System.out.println(studentAccount.toString());
        //验证校园网账号密码
        int result = studentAccountService.checkout(studentAccount);
        if(result==1){
            //微信 绑定 校园网账号
            studentAccountService.bindAccount(studentAccount);
            //根据校园网账号获取学生信息
            StudentInfo studentInfo = studentInfoService.getStudentInfo(studentAccount.getStudentId());
            map.put("status",1);
            map.put("msg","绑定成功!");
            map.put("studentInfo",studentInfo);
            return map;
        }
        //账号密码错误
        else if(result==2){
            System.out.println("bind failed! account or password is wrong!");
            map.put("status",0);
            map.put("msg","绑定失败，账号或密码错误!");
            return map;
        }
        //账号已经被绑定
        else {
            System.out.println("bind failed! account has been binded!");
            map.put("status",0);
            map.put("msg","绑定失败，该账号已经被绑定!");
            return map;
        }
    }

    /**
     * 根据wxLogin返回的code换取openid
     * @param code 微信登录后得到的code
     * @return Map
     */
    @RequestMapping(value = "/getopenid",method = RequestMethod.GET)
    public Map getOpenid(String code){
        Map map = new HashMap();
        //login code不能为空
        if(code==null||code.length()==0){
            map.put("status",0);
            map.put("msg","code 不能为空");
            return map;
        }
        //通过login code去换取openId
        String param = "appid=" + MyConst.APPID + "&secret=" + MyConst.APPSECRET + "&js_code=" + code + "&grant_type=authorization_code";
        String data = HttpRequestUtil.sendGet(MyConst.WxGetOpenIdUrl, param);
        //解析成json格式
        JsonObject json = jp.parse(data).getAsJsonObject();

        //获取sessionKey和openid
        String sessionKey = json.get("session_key").getAsString();
        String openId = json.get("openid").getAsString();

        map.put("sessionKey",sessionKey);
        map.put("openId",openId);
        map.put("status",1);
        map.put("msg","成功");

        return map;
    }

    /**
     * 根据openid获取绑定的校园网账号的学生信息
     * @param openid 微信号的唯一标识
     * @return Map
     */
    @RequestMapping(value = "/getStudentInfo",method = RequestMethod.POST)
    public Map getStudentInfo(@RequestBody String openid){
        Map map = new HashMap();
        //openid不能为空
        if(openid==null){
            map.put("status",0);
            map.put("msg","openid 不能为空");
            return map;
        }
        //获取该微信号绑定的校园网账号
        StudentAccount student = studentAccountService.getStudentByOpenid(openid);
        StudentInfo studentInfo = null;
        //如果绑定过校园网账号，则根据学号获取学生信息
        if(student!=null) {
            studentInfo = studentInfoService.getStudentInfo(student.getStudentId());
            List<Course> courseList = courseService.selectCourseByClassId(studentInfo.getClassId());
            map.put("studentInfo",studentInfo);
            map.put("courseList",courseList);
        }

        map.put("status",1);
        map.put("msg","读取完成");
        map.put("has_registed",student==null?0:student.getHasRegisted());

        return map;

    }

    /**
     * 获取当前开始考勤的状态
     * @param studentId
     * @return Map
     */
    @RequestMapping(value = "/getCurrentCheckin",method = RequestMethod.POST)
    public Map getCheckStatus(@RequestBody String studentId){
        Map<String,Object> map = new HashMap<>();
        //根据学号查询当前的考勤的状态
        Map checkStatus = checkLogService.getCheckStatus(studentId);

        //如果当前有考勤
        if(checkStatus!=null){
            map.put("msg","success");
            //checkStatus 中的签到状态为'已签到'或'未签到' ， 能否签到在微信端判断
            map.put("map",checkStatus);
        }else{
            map.put("msg","null");
        }
        return map;
    }
}
