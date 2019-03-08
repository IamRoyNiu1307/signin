package com.nsh.signin.util;

import java.util.Map;

/**
 * 调用API接口，请求返回结果
 */
public class RequestResult {
    /**
     *
     * @param url 接口地址
     * @param map 请求参数
     * @return json格式的数据
     * @throws Exception
     */
    public static String getResult(String url, Map map) throws Exception {
        //将map中的kv转成json
        String param = GsonUtils.toJson(map);

        // 获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
        String accessToken = AuthService.getAuth();

        String result = HttpUtil.post(url, accessToken, "application/json", param);

        return result;
    }
}
