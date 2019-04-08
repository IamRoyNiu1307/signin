package com.nsh.signin.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nsh.signin.api.FaceRegister;
import com.nsh.signin.api.FaceSearch;
import com.nsh.signin.myconst.MyConst;
import com.nsh.signin.service.StudentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 面部注册Controller
 */
@Controller
@RequestMapping("/wx")
public class FaceRegisterController {

    @Autowired
    private StudentAccountService studentAccountService;
    private JsonParser jp = new JsonParser();

    @ResponseBody
    @RequestMapping("/registerFace")
    public String registerFace(@RequestParam(value = "file", required = false) MultipartFile file,
                               @RequestParam(value = "studentid", required = false) String studentid) throws IOException {
        System.out.println("执行 人脸注册...");
        //将图像转成byte数组，返回查询结果
        String searchResult = FaceSearch.search(file.getBytes());
        //将查询结果解析成json
        JsonObject json = jp.parse(searchResult).getAsJsonObject();
        //如果面部可以在库中比对成功，则说明该面部已经注册过
        if(json.get("error_msg").getAsString().equals("SUCCESS")){
            System.out.println("面部已注册");
            return "{\"error_msg\":\"面部已注册\"}";
        }
        //否则 将面部添加到人脸库中
        String result = FaceRegister.add(file.getBytes(), MyConst.GROUPID,studentid);
        //将结果解析成json
        JsonObject resultJson = jp.parse(result).getAsJsonObject();
        //如果结果中的error_msg=SUCCESS则说明注册成功，将has_registed设为1
        if(resultJson.get("error_msg").getAsString().equals("SUCCESS")){
            studentAccountService.setRegisted(studentid);
        }

        return result;
//        request.setCharacterEncoding("UTF-8");
//        logger.info("执行图片上传");
//        String user = request.getParameter("user");
//        logger.info("user:"+user);
//        if(!file.isEmpty()) {
//            logger.info("成功获取照片");
//            String fileName = file.getOriginalFilename();
//            String path = null;
//            String type = null;
//            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
//            logger.info("图片初始名称为：" + fileName + " 类型为：" + type);
//            if (type != null) {
//                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
//                    // 项目在容器中实际发布运行的根路径'
//                    String realPath = request.getSession().getServletContext().getRealPath("/");
//                    // 自定义的文件名称
//                    String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
//                    // 设置存放图片文件的路径
//                    path = realPath + "/uploads/" + trueFileName;
//                    logger.info("存放图片文件的路径:" + path);
//                    file.transferTo(new File(path));
//                    logger.info("文件成功上传到指定目录下");
//                }else {
//                    logger.info("不是我们想要的文件类型,请按要求重新上传");
//                    return "error";
//                }
//            }else {
//                logger.info("文件类型为空");
//                return "error";
//            }
//        }else {
//            logger.info("没有找到相对应的文件");
//            return "error";
//        }
//        return "success";

    }
}
