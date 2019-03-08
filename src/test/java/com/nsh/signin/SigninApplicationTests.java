package com.nsh.signin;

import com.nsh.signin.api.FaceRegister;
import com.nsh.signin.api.FaceSearch;
import com.nsh.signin.dao.StudentAccountDao;
import com.nsh.signin.entity.StudentAccount;
import com.nsh.signin.entity.StudentClass;
import com.nsh.signin.entity.StudentInfo;
import com.nsh.signin.service.CheckLogService;
import com.nsh.signin.service.StudentAccountService;
import com.nsh.signin.service.StudentInfoService;
import com.nsh.signin.util.FileUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SigninApplicationTests {

    @Autowired
    private StudentAccountService studentAccountService;
    @Autowired
    private StudentInfoService studentInfoService;
    @Autowired
    CheckLogService checkLogService;

    @Test
    public void contextLoads() {
        String path = "/users/roy/desktop/face.jpg";
        FaceRegister.addWithPath(path,"group_stu","201577F0502");
    }

//    @Test
//    public void testFaceSearch(){
//        String path = "/users/roy/desktop/group/tmp.png";
//        System.out.println(FaceSearch.search(path));
//    }

    @Test
    public void addStudent(){
        List studentAccountList = new ArrayList();
        List studentInfoList = new ArrayList();
        for(int i = 100;i<200;i++){
            StudentInfo studentInfo = new StudentInfo("201577f0"+i,"学生"+i,i%4+1);
            StudentAccount studentAccount = new StudentAccount("201577f0"+i,"201577f0"+i,null,0);
            studentInfoList.add(studentInfo);
            studentAccountList.add(studentAccount);
        }
        studentAccountService.addStudentAccount(studentAccountList);
        studentInfoService.addStudentInfo(studentInfoList);
    }

    @Test
    public void testHour() throws ParseException {
        SimpleDateFormat hourSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat dateSdf = new SimpleDateFormat("yyyy-MM-dd");
        String now = dateSdf.format(new Date());
        System.out.println(now);
        Date date1 = hourSdf.parse(now + " 9:50");
        System.out.println(date1.compareTo(new Date()));
    }


    @Test
    public void startCheckin(){
        List<StudentClass> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            StudentClass studentClass = new StudentClass();
            studentClass.setClassName("软测五班");
            studentClass.setStudentId("0000"+i);
            list.add(studentClass);
        }

        checkLogService.startCheckin("liuminghao","软测五班",list);
    }

    /**
     * 测试api能力
     * @throws IOException
     */
    @Test
    public void testApi() throws IOException {
        //将图片转成byte数组
        byte[] bytes = FileUtil.readFileByBytes("/Users/roy/Desktop/jjl.jpg");
        String result = FaceSearch.searchFace(bytes);
        System.out.println(result);
    }

    
    public void testBranch(){
        System.out.println(1);
    }

}

