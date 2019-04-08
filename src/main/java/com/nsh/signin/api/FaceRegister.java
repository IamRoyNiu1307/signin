package com.nsh.signin.api;
import com.nsh.signin.myconst.MyConst;
import com.nsh.signin.util.*;

import java.util.*;

/**
 * 人脸注册
 */
public class FaceRegister {

    public static String add(byte[] file,String groupid,String userid) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
        try {
//            byte[] bytes = FileUtil.readFileByBytes(filePath);
            String image = Base64Util.encode(file);
            Map<String, Object> map = new HashMap<>();
            map.put("image", image);
            map.put("group_id", groupid);
            map.put("user_id", userid);
            map.put("user_info", String.valueOf(System.currentTimeMillis()));
            map.put("liveness_control", "NONE");
            map.put("image_type", "BASE64");
            map.put("quality_control", "LOW");

            String result = RequestResult.getResult(url, map);

            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String addWithPath(String filePath,String groupid,String userid) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
        try {
            byte[] bytes = FileUtil.readFileByBytes(filePath);
            String image = Base64Util.encode(bytes);
            Map<String, Object> map = new HashMap<>();
            map.put("image", image);
            map.put("group_id", MyConst.GROUPID);
            map.put("user_id", userid);
            map.put("user_info", String.valueOf(System.currentTimeMillis()));
            map.put("liveness_control", "NONE");
            map.put("image_type", "BASE64");
            map.put("quality_control", "LOW");

            String result = RequestResult.getResult(url, map);

            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
