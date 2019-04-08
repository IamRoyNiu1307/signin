package com.nsh.signin.service;

import com.nsh.signin.dao.StudentAccountMapper;
import com.nsh.signin.entity.StudentAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * StudentAccountService类
 */
@Service
public class StudentAccountService {
    @Autowired
    private StudentAccountMapper studentAccountMapper;

    /**
     * 验证账号
     * @param studentAccount
     * @return 1 验证通过
     *         2 账号密码错误
     *         3 账号已经被绑定
     */
    public int checkout(StudentAccount studentAccount){
        StudentAccount student = studentAccountMapper.getStudent(studentAccount);
        if(student!=null){
            if(student.getOpenid()!=null&&!"".equals(student.getOpenid())){
                return 3;
            }
            return 1;
        }

        return 2;
    }

    /**
     * 绑定校园网账号
     * @param studentAccount 校园网账号
     */
    public void bindAccount(StudentAccount studentAccount){
        studentAccountMapper.bindAccount(studentAccount);
    }

    /**
     * 根据openid获取绑定的校园网账号
     * @param openid 微信账号唯一标识
     * @return
     */
    public StudentAccount getStudentByOpenid(String openid){
        return studentAccountMapper.getStudentByOpenid(openid);
    }

    /**
     * 面部注册之后，将账号的has_registed设为1
     * @param studentid 学号
     */
    public void setRegisted(String studentid) {
        studentAccountMapper.setRegisted(studentid);
    }

    /**
     * 根据学号，查询校园网账号是否进行过面部注册
     * @param studentid 学号
     * @return
     */
    public boolean getRegisted(String studentid){
        Integer status = studentAccountMapper.getRegisted(studentid);
        return status == 0?false:true;
    }

    /**
     * 添加校园网账号
     * @param studentAccounts 校园网账号
     */
    public void addStudentAccount(List<StudentAccount> studentAccounts){
        for(StudentAccount each : studentAccounts){
            studentAccountMapper.addStudentAccount(each);
        }
    }
}
