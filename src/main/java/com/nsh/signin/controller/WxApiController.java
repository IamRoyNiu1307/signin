package com.nsh.signin.controller;

import cn.hutool.core.date.DateUtil;
import com.nsh.signin.dao.MsgClassMapper;
import com.nsh.signin.entity.LeaveApp;
import com.nsh.signin.entity.LeaveAppImage;
import com.nsh.signin.entity.MsgClass;
import com.nsh.signin.entity.TabMsg;
import com.nsh.signin.myconst.MyConst;
import com.nsh.signin.service.LeaveAppImageService;
import com.nsh.signin.service.LeaveAppService;
import com.nsh.signin.service.ScheduleService;
import com.nsh.signin.service.TabMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

@RestController
@RequestMapping("/wx")
public class WxApiController {

    @Autowired
    private TabMsgService tabMsgService;
    @Autowired
    private MsgClassMapper msgClassMapper;
    @Autowired
    private LeaveAppService leaveAppService;
    @Autowired
    private LeaveAppImageService leaveAppImageService;
    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping("/getMsgList/{classId}")
    public Map getMsgList(@PathVariable("classId")int classId){
        Map result = new HashMap();
        List<TabMsg> msgList = tabMsgService.getMsgListByClassId(classId);
        if(msgList.size()>0) {
            result.put("status", 1);
            result.put("msgList", msgList);
        }else{
            result.put("status",0);
        }
        return result;
    }

    @RequestMapping("/submitLeaveApplication")
    public Map submitLeaveApplication(@RequestParam(value = "file", required = false) MultipartFile file,
                                      @RequestParam(value = "id", required = false) Integer id,
                                      @RequestParam(value = "course", required = false)Integer courseId,
                                      @RequestParam(value = "date", required = false)String date,
                                      @RequestParam(value = "reason", required = false)String reason,
                                      @RequestParam(value = "detail", required = false)String detail,
                                      @RequestParam(value = "studentId", required = false)String studentId,
                                      @RequestParam(value = "classId", required = false)Integer classId){

        Map result = new HashMap();
        //file为空时，说明是先插入数据
        if(file==null){
            String teacherId = scheduleService.selectTeacherIdByCourseId(classId,courseId);
            LeaveApp leaveApp = new LeaveApp(id, studentId, courseId, DateUtil.parse(date).toSqlDate(), reason, detail,0,teacherId);
            leaveAppService.insert(leaveApp);
            result.put("status",1);
        }else {
            LeaveApp leaveApp = leaveAppService.selectByPrimaryKey(id);
            String path = "";
            String dbFilePath = "";
            if(!file.isEmpty()){
                //获取文件名
                String fileName = file.getOriginalFilename();
                //获取文件后缀名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                //重新生成文件名
                fileName = UUID.randomUUID()+suffixName;
                //保存在数据库中的图片路径
                dbFilePath = MyConst.LEAVEAPP_IMAGE_PATH+fileName;
                //指定本地文件夹存储图片
                String filePath = MyConst.LEAVEAPP_UPLOAD_FILEPATH;
                try {
                    //将图片保存到static文件夹里
                    path = filePath+fileName;
                    file.transferTo(new File(path));
                    LeaveAppImage leaveAppImage = new LeaveAppImage(leaveApp.getId(), dbFilePath);
                    leaveAppImageService.insertSelective(leaveAppImage);
                    result.put("status",1);
                } catch (Exception e) {
                    result.put("status",0);
                    result.put("msg","图片上传失败!");
                    e.printStackTrace();
                }
            }

        }



        return result;
    }

    @RequestMapping("/getAppList")
    public Map getMyApp(@RequestParam(value = "studentId", required = false)String studentId,
                        @RequestParam(value = "status", required = false)Integer status){
        Map result = new HashMap();
        List<LeaveApp> leaveApps = leaveAppService.selectByStudentId(studentId,status);
        result.put("appList",leaveApps);
        return result;
    }

}
