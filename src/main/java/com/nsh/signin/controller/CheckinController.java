package com.nsh.signin.controller;

import com.nsh.signin.entity.CurrentCourse;
import com.nsh.signin.entity.StudentClass;
import com.nsh.signin.entity.TeacherInfo;
import com.nsh.signin.service.CheckLogService;
import com.nsh.signin.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 教师端 考勤相关服务
 */
@Controller
@RequestMapping("/checkin")
public class CheckinController {

    @Autowired
    private CheckLogService checkLogService;
    @Autowired
    private StudentClassService studentClassService;


    /**
     * 页面跳转
     * @param request
     * @param map
     * @return 视图
     */
    @RequestMapping("/page")
    public String toCheckin(HttpServletRequest request, Map<String,Object> map){
        TeacherInfo teacher = (TeacherInfo)request.getSession().getAttribute("teacher");
        //获取当前正在进行的课程
        CurrentCourse currentCourse = checkLogService.getCurrentCourse(teacher.getTeacherId());
        //如果当前有正在进行的课程，则放入map中
        if(currentCourse!=null){
            map.put("currentCourse",currentCourse);
        }

        request.getSession().setAttribute("activeTag","checkin");
        return "checkin";
    }

    /**
     * 开始考勤
     * @param data
     * @param request
     * @return map
     */
    @ResponseBody
    @RequestMapping("/startCheckin")
    public Map startCheckin(@RequestBody Map<String,Object> data,HttpServletRequest request){
        Map<String,Object> map =new HashMap<>();
        System.out.println(data.get("classId")+" "+data.get("className")+" start to checkin...");

        TeacherInfo teacherInfo = (TeacherInfo) request.getSession().getAttribute("teacher");
        //获取当前课程中所有的学生
        List<StudentClass> studentClassList = studentClassService.getAllByClassName(teacherInfo.getTeacherId(),(String)data.get("className"));
        //生成考勤记录，同时将这些学生加入到考勤列表下，初始状态：未签到
        int teacherCheckinId = checkLogService.startCheckin(teacherInfo.getTeacherId(), (String) data.get("className"), studentClassList);

        map.put("msg","success");
        map.put("checkinId",teacherCheckinId);
        return map;
    }

    /**
     * 关闭签到通道
     * @param data 包含了当前签到通道的id
     * @return
     */
    @ResponseBody
    @RequestMapping("/closeCheckin")
    public Map closeCheckin(@RequestBody Map<String,Object> data){
        Map<String,Object> map =new HashMap<>();
        //System.out.println(data.get("checkinId") + " closing checkin...");
        checkLogService.closeCheckin(Integer.parseInt(data.get("checkinId").toString()));
        map.put("msg","success");
        return map;
    }

    /**
     * 获取缺勤表
     * @param data
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAbsentList")
    public Map getAbsentList(@RequestBody Map<String,Object> data){
        Map<String,Object> map =new HashMap<>();
        //System.out.println(data.get("checkinId") + " get absent list...");

        List<Map> absentList = checkLogService.getAbsentList(Integer.parseInt(data.get("checkinId").toString()));

        map.put("msg","success");
        map.put("absentList",absentList);
        return map;
    }

}
