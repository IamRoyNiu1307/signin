package com.nsh.signin.controller;


import com.nsh.signin.entity.LeaveApp;
import com.nsh.signin.entity.TeacherInfo;
import com.nsh.signin.service.LeaveAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LeaveAPPController {

    @Autowired
    LeaveAppService leaveAppService;

    @RequestMapping("/checkApp")
    public String checkApp(HttpSession session,Map map){
        TeacherInfo teacher = (TeacherInfo)session.getAttribute("teacher");
        session.setAttribute("activeTag","checkApp");
        List<LeaveApp> leaveAppList = leaveAppService.selectByTeacherId(teacher.getTeacherId());
        map.put("leaveAppList",leaveAppList);
        return "checkApp";
    }

    @ResponseBody
    @RequestMapping("/checkApp/check")
    public Map check(@RequestParam(name = "id")int id,@RequestParam(name = "todo")String todo){
        Map map = new HashMap();


        LeaveApp leaveApp = leaveAppService.selectByPrimaryKey(id);
        int status = 0;
        if("pass".equals(todo)){
            status=1;
        }
        if("unpass".equals(todo)){
            status=2;
        }
        leaveApp.setStatus(status);
        leaveAppService.updateByPrimaryKeySelective(leaveApp);

        map.put("status",1);
        return map;
    }
}
