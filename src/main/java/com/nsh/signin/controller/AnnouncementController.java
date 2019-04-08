package com.nsh.signin.controller;

import com.github.pagehelper.PageInfo;
import com.nsh.signin.entity.TabMsg;
import com.nsh.signin.entity.TeacherInfo;
import com.nsh.signin.myconst.MyConst;
import com.nsh.signin.service.MsgClassService;
import com.nsh.signin.service.TabMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 公告管理
 */
@Controller
@RequestMapping("/announcement")
public class AnnouncementController {
    @Autowired
    private TabMsgService tabMsgService;
    @Autowired
    private MsgClassService msgClassService;


    /**
     * 分页
     * @param curPage 当前页码
     * @param map
     * @return
     */
    @RequestMapping("/page")
    public String toMyStudent(HttpSession session,
                              @RequestParam(value = "curPage") Integer curPage,
                              Map<String,Object> map){

        TeacherInfo teacher = (TeacherInfo)session.getAttribute("teacher");

        //获取学生信息
        PageInfo pageInfo = tabMsgService.getMsgList(teacher.getTeacherId(),curPage,10);

        map.put("msgList",pageInfo.getList());

        map.put("curPage",curPage);
        map.put("firstPage",pageInfo.getFirstPage());
        map.put("lastPage",pageInfo.getLastPage());
        map.put("prePage",pageInfo.getPrePage());
        map.put("nextPage",pageInfo.getNextPage());

        session.setAttribute("activeTag","announcement");
        return "announcement";


    }

    /**
     * 公告发布、修改
     * @param session
     * @param file 公告图片
     * @param id 公告id
     * @param title 公告标题
     * @param content 公告内容
     * @param classes 推送班级id
     * @return
     */
    @Transactional
    @ResponseBody
    @RequestMapping("/push")
    public Map pushMsg(HttpSession session, @RequestParam(value = "file",required=false) MultipartFile file,
                       @RequestParam(value = "id",required=false) Integer id,
                       @RequestParam(value = "title",required=false) String title,
                       @RequestParam(value = "content",required=false) String content,
                       @RequestParam(value = "pushClass",required = false) int[] classes){
        //System.out.println(file);
        Map result = new HashMap();
        TeacherInfo teacher = (TeacherInfo)session.getAttribute("teacher");
        String path = "";
        String filaPath = "";
        if(!file.isEmpty()){
            //获取文件名
            String fileName = file.getOriginalFilename();
            //获取文件后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            //重新生成文件名
            fileName = UUID.randomUUID()+suffixName;
            filaPath = MyConst.IMAGE_PATH+fileName;
            //指定本地文件夹存储图片
            String filePath = MyConst.UPLOAD_FILEPATH;
            try {
                //将图片保存到static文件夹里
                path = filePath+fileName;
                file.transferTo(new File(path));
            } catch (Exception e) {
                e.printStackTrace();
                result.put("status",0);
                result.put("msg","图片上传失败！");
            }
        }
        //id不为空说明是修改操作
        if(id!=null){
            TabMsg tabMsg = tabMsgService.selectByPrimaryKey(id);
            tabMsg.setTitle(title);
            tabMsg.setContent(content);
            tabMsg.setImagePath(filaPath);
            tabMsgService.updateByPrimaryKeySelective(tabMsg);
        }else {
            TabMsg tabMsg = new TabMsg(title, content, new Date(), 1, teacher.getTeacherId(), filaPath);
            tabMsgService.insertSelective(tabMsg);
            System.out.println(tabMsg.getId());
            msgClassService.insertRecordBatch(tabMsg.getId(), classes);
        }
        result.put("status",1);
        return result;
    }

    /**
     * 公告删除
     * @param data
     * @return
     */
    @Transactional
    @ResponseBody
    @RequestMapping("/del")
    public Map del(@RequestBody Map<String,Integer> data){
        Map result = new HashMap();
        Integer id = data.get("id");
        TabMsg tabMsg = tabMsgService.selectByPrimaryKey(id);
        tabMsg.setStatus(0);
        tabMsgService.updateByPrimaryKeySelective(tabMsg);
        result.put("status",1);
        return result;
    }
}
