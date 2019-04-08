package com.nsh.signin.controller;

import com.nsh.signin.entity.TabClass;
import com.nsh.signin.entity.TeacherAccount;
import com.nsh.signin.entity.TeacherInfo;
import com.nsh.signin.service.TabClassService;
import com.nsh.signin.service.TeacherAccountService;
import com.nsh.signin.service.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 教师端 教师账号相关服务
 */
@Controller
@RequestMapping("/teacher")
public class TeacherAccountController {

    @Autowired
    private TeacherAccountService teacherAccountService;
    @Autowired
    private TeacherInfoService teacherInfoService;
    @Autowired
    private TabClassService tabClassService;

    /**
     * 页面跳转，重定向到后台首页
     * @param request
     * @return
     */
    @RequestMapping("/main")
    public String toHomePage(HttpServletRequest request){
        request.getSession().setAttribute("activeTag","home");
        return "redirect:/main";
    }

    /**
     * 教师登录
     * @param teacherAccount 教师账号
     * @param pageParams
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String teacherLogin(TeacherAccount teacherAccount, Map<String,String> pageParams,
                               HttpSession session){
        //验证账号密码正确性
        boolean result = teacherAccountService.checkout(teacherAccount);
        if(result){
            TeacherInfo teacherInfo = teacherInfoService.getTeacherInfo(teacherAccount.getTeacherId());
            List<TabClass> classList = tabClassService.getTabClassListByTeacherId(teacherAccount.getTeacherId());
            session.setAttribute("teacher",teacherInfo);
            session.setAttribute("classList",classList);
            session.setAttribute("activeTag","home");
            //request.setAttribute("activeTag","home");
            return "redirect:/main";
        }else{
            pageParams.put("login_error","账号密码错误！");
            return "index";
        }
    }
}
