package com.nsh.test;

import com.nsh.signin.api.FaceSearch;
import com.nsh.signin.util.FileUtil;

import java.io.IOException;

public class TestApi {
    public static void main(String[] args) throws IOException {
        //将图片转成byte数组
        byte[] bytes = FileUtil.readFileByBytes("/Users/roy/Desktop/linjunjie.jpeg");
        String result = FaceSearch.searchFace(bytes);
        System.out.println(result);
    }
}
