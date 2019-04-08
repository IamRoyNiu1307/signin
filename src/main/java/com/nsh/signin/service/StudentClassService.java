package com.nsh.signin.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nsh.signin.dao.StudentClassMapper;
import com.nsh.signin.entity.StudentClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentClassService {
    @Autowired
    private StudentClassMapper studentClassMapper;

    /**
     * 根据教师id获取所教所有学生的信息及所在班级的列表
     * @param teacherId 教师id
     * @param pageNumber 页码
     * @param pageSize 一页中的数据数
     * @return pageInfo
     */
    public PageInfo getStudentClassList(String teacherId,Integer pageNumber, Integer pageSize){
        PageHelper.startPage(pageNumber, pageSize);
        List<StudentClass> studentClassList = studentClassMapper.getStudentClassList(teacherId);
        PageInfo pageInfo = new PageInfo(studentClassList);
        return pageInfo;
    }

    /**
     * 根据班级名称获取班级下所有的学生
     * @param teacherId 教师id
     * @param className 班级名称
     * @return 学生列表
     */
    public List<StudentClass> getAllByClassName(String teacherId,String className){
        List<StudentClass> studentClassList = studentClassMapper.getAllByClassName(teacherId,className);
        return studentClassList;
    }

}
