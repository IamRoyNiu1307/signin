package com.nsh.signin.service;

import com.nsh.signin.dao.StudentInfoDao;
import com.nsh.signin.entity.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentInfoService {

    @Autowired
    private StudentInfoDao studentInfoDao;

    /**
     * 根据学号获取学生信息
     * @param studentId 学号
     * @return StudentInfo
     */
    public StudentInfo getStudentInfo(String studentId){
        return studentInfoDao.getStudentInfo(studentId);

    }

    /**
     * 根据学号获取学生姓名
     * @param studentId 学号
     * @return 学生姓名
     */
    public String getStudentName(String studentId){
        return studentInfoDao.getStudentName(studentId);
    }

    /**
     * 添加学生信息 测试用
     * @param studentInfos 学生信息列表
     */
    public void addStudentInfo(List<StudentInfo> studentInfos){
        for(StudentInfo each : studentInfos){
            studentInfoDao.addStudentInfo(each);
        }
    }

}
