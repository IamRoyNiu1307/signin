package com.nsh.signin.controller;

import com.nsh.signin.entity.ClassCourse;
import com.nsh.signin.entity.TeacherInfo;
import com.nsh.signin.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 教师端 课程相关服务
 */
@Controller
@RequestMapping("/myCourse")
public class CourseController {

    @Autowired
    private ScheduleService scheduleService;

    /**
     * 页面跳转
     * @param map
     * @return
     */
    @RequestMapping("/page")
    public String toCourse(HttpSession session, Map<String,Object> map){

        TeacherInfo teacher = (TeacherInfo)session.getAttribute("teacher");

        //根据教师id获取一周内所有的课程
        List<ClassCourse> classCourseList = scheduleService.getClassCourseList(teacher.getTeacherId());

        for (int i = 0; i < classCourseList.size(); i++) {
            ClassCourse current = classCourseList.get(i);
            //以当前工作日+课程序号(周*的第*节课)为键，课程信息为值
            map.put(current.getWorkday() + current.getNo(), current);
            //System.out.println("set map: " + current.getWorkday() + current.getNo() + " --> " + current.toString());

        }

        session.setAttribute("activeTag","myCourse");
        return "myCourse";
    }

}
