package com.nsh.signin.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nsh.signin.api.FaceSearch;
import com.nsh.signin.service.CheckLogService;
import com.nsh.signin.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 面部识别Controller
 */
@Controller
@RequestMapping("/wx")
public class FaceSearchController {
    @Autowired
    private StudentInfoService studentInfoService;
    @Autowired
    private CheckLogService checkLogService;

    JsonParser jp = new JsonParser();

    @ResponseBody
    @RequestMapping("/searchFace/baiduAPI")
    public Map searchFaceByBaidu(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file,
                            @RequestParam(value = "studentid", required = false) String studentid,
                            @RequestParam(value = "checkinId", required = false) Integer checkinId) throws IOException {
        System.out.println("执行 人脸识别...");

        Map map = new HashMap();

        String result = FaceSearch.search(file.getBytes());

        JsonObject json = jp.parse(result).getAsJsonObject();

        if(json.get("error_msg").getAsString().equals("SUCCESS")){

            //result:{"error_code":0,"error_msg":"SUCCESS","log_id":304592865027042551,"timestamp":1546502704,"cached":0,
            // "result":{
            // "face_token":"53224e0de171ae6c852b43f58f310ee0","user_list":[{"group_id":"group_stu","user_id":"201577F0501","user_info":"1546496624033","score":97.585189819336
            // }]}}
            JsonObject userResult = json.get("result").getAsJsonObject();
            JsonArray user_list = userResult.get("user_list").getAsJsonArray();
            JsonObject userJson = user_list.get(0).getAsJsonObject();
            //相似度达到90以上
            if(userJson.get("score").getAsFloat()>90.0f){
                String studentId = userJson.get("user_id").getAsString();

                //比对人脸对应的学号和客户端传来的学号是否相同，确保是本人
                if(studentId.equals(studentid)) {
                    String studentName = studentInfoService.getStudentName(studentId);

                    //说明不是测试模式 ，实际刷脸签到模式
                    if(checkinId!=null){
                        checkLogService.setStatus(studentid,checkinId);
                    }

                    map.put("status",1);
                    map.put("msg","识别成功！");
                    map.put("student_name",studentName);
                }
            }else{
                map.put("status",0);
                map.put("msg","不是本人！");
            }



        }else{
            map.put("status",0);
            map.put("msg","未能识别！");

        }

        return map;
    }



    @ResponseBody
    @RequestMapping("/searchFace")
    public Map searchFaceCustom(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file,
                          @RequestParam(value = "studentid", required = false) String studentid,
                          @RequestParam(value = "checkinId", required = false) Integer checkinId) throws IOException {

        Map map = new HashMap();

        String result = FaceSearch.searchFace(file.getBytes());

        JsonObject json = jp.parse(result).getAsJsonObject();

        if(json.get("error_msg").getAsString().equals("SUCCESS")) {

            String faceID = json.get("faceID").getAsString();

            //比对人脸对应的学号和客户端传来的学号是否相同，确保是本人
            if (faceID.equals(studentid)) {

                String studentName = studentInfoService.getStudentName(faceID);

                //说明不是测试模式 ，实际刷脸签到模式
                if (checkinId != null) {
                    checkLogService.setStatus(studentid, checkinId);
                }

                map.put("status", 1);
                map.put("msg", "识别成功！");
                map.put("student_name", studentName);
            }else{
                map.put("status", 0);
                map.put("msg", "不是本人！");
            }
        }else{
            map.put("status", 0);
            map.put("msg", "未能识别！");
        }


        System.out.println(map);


        return map;
    }
}
