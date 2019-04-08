package com.nsh.signin.controller;

import com.github.pagehelper.PageInfo;
import com.nsh.signin.entity.ClassCourse;
import com.nsh.signin.entity.StudentClass;
import com.nsh.signin.entity.TeacherInfo;
import com.nsh.signin.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 教师端 我的学生相关服务
 */
@Controller
@RequestMapping("/myStudent")
public class StudentController {

    @Autowired
    private StudentClassService studentClassService;

    /**
     * 页面跳转
     * @param curPage
     * @param map
     * @return
     */
    @RequestMapping("/page")
    public String toMyStudent(HttpSession session,
                              @RequestParam(value = "curPage") Integer curPage,
                              Map<String,Object> map){

        TeacherInfo teacher = (TeacherInfo)session.getAttribute("teacher");

        //获取学生信息
        PageInfo pageInfo = studentClassService.getStudentClassList(teacher.getTeacherId(),curPage,10);

        map.put("studentList",pageInfo.getList());

        map.put("curPage",curPage);
        map.put("firstPage",pageInfo.getFirstPage());
        map.put("lastPage",pageInfo.getLastPage());
        map.put("prePage",pageInfo.getPrePage());
        map.put("nextPage",pageInfo.getNextPage());

        session.setAttribute("activeTag","myStudent");
        return "myStudent";


    }

}
