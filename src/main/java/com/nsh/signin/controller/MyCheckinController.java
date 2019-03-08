package com.nsh.signin.controller;


import com.github.pagehelper.PageInfo;
import com.nsh.signin.entity.TeacherInfo;
import com.nsh.signin.service.TeacherCheckinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 教师端 我的考勤相关服务
 */
@Controller
@RequestMapping("/myCheckin")
public class MyCheckinController {

    @Autowired
    private TeacherCheckinService teacherCheckinService;

    /**
     * 页面跳转
     * @param request
     * @param curPage 当前页码
     * @param map
     * @return
     */
    @RequestMapping("/page")
    public String toMyCheckin(HttpServletRequest request,
                              @RequestParam(value = "curPage") Integer curPage,
                              Map<String,Object> map){

        TeacherInfo teacher = (TeacherInfo)request.getSession().getAttribute("teacher");

        //获取所有考勤记录，pageSize:10 每页十条记录
        PageInfo pageInfo = teacherCheckinService.getAllCheckin(teacher.getTeacherId(),curPage,10);

        map.put("checkinList",pageInfo.getList());

        map.put("curPage",curPage);
        map.put("firstPage",pageInfo.getFirstPage());
        map.put("lastPage",pageInfo.getLastPage());
        map.put("prePage",pageInfo.getPrePage());
        map.put("nextPage",pageInfo.getNextPage());

        request.getSession().setAttribute("activeTag","myCheckin");
        return "myCheckin";
    }

}
