package com.nsh.signin.controller;

import com.github.pagehelper.PageInfo;
import com.nsh.signin.entity.Record;
import com.nsh.signin.entity.TeacherInfo;
import com.nsh.signin.service.StudentClassService;
import com.nsh.signin.service.TeacherCheckinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 教师端 我的学生相关服务
 */
@Controller
@RequestMapping("/myStudent")
public class StudentController {

    @Autowired
    private StudentClassService studentClassService;
    @Autowired
    private TeacherCheckinService teacherCheckinService;
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

    @ResponseBody
    @RequestMapping("/getRecord")
    public Map getRecord(String studentId,HttpSession session){
        Map map = new HashMap<>();
        TeacherInfo teacher = (TeacherInfo) session.getAttribute("teacher");
        List<Record> records = teacherCheckinService.selectRecord(teacher.getTeacherId(), studentId);
        map.put("records",records);
        return map;
    }


}
