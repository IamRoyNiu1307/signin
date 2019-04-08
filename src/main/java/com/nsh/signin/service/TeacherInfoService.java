package com.nsh.signin.service;

import com.nsh.signin.dao.TeacherInfoMapper;
import com.nsh.signin.entity.TeacherInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherInfoService {

    @Autowired
    private TeacherInfoMapper teacherInfoMapper;

    /**
     * 根据教师id获取教师信息
     * @param teacherId 教师id
     * @return
     */
    public TeacherInfo getTeacherInfo(String teacherId){
        return teacherInfoMapper.getTeacherInfo(teacherId);
    }
}
