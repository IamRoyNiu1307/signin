package com.nsh.signin.service;

import com.nsh.signin.dao.TeacherAccountMapper;
import com.nsh.signin.entity.TeacherAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherAccountService {

    @Autowired
    private TeacherAccountMapper teacherAccountMapper;

    /**
     * 教师登录验证账号密码
     * @param teacherAccount 教师账号
     * @return
     */
    public boolean checkout(TeacherAccount teacherAccount){
        TeacherAccount teacher = teacherAccountMapper.getTeacher(teacherAccount);
        return teacher==null?false:true;
    }
}
