package com.nsh.signin.api;

import com.nsh.signin.myconst.MyConst;
import com.nsh.signin.util.*;

import java.util.*;

/**
 * 人脸搜索
 */
public class FaceSearch {

    /**
     * 调用百度api，完成人脸搜索
     * @param file 图片的byte数组
     * @return 识别结果
     */
    public static String search(byte[] file) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
        try {

            //将图片转成byte数组
            //byte[] bytes = FileUtil.readFileByBytes(filePath);
            //获取图片的base64值
            String image = Base64Util.encode(file);

            //封装请求参数
            Map<String, Object> map = new HashMap<>();
            map.put("image", image);
            map.put("liveness_control", "LOW");
            map.put("group_id_list", MyConst.GROUPID);
            map.put("image_type", "BASE64");
            map.put("quality_control", "HIGH");

            String result = RequestResult.getResult(url, map);

            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 调用python识别接口
     * @param file 图片的byte数组
     * @return 识别结果
     */
    public static String searchFace(byte[] file){
        String url = "http://localhost:5000/face/api/v1.0/recognition";
        String image = Base64Util.encode(file);
        try{
            Map<String, Object> map = new HashMap<>();
            map.put("image",image);
            String result = RequestResult.getResult(url,map);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
