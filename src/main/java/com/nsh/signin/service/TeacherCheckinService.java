package com.nsh.signin.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nsh.signin.dao.TeacherCheckinMapper;
import com.nsh.signin.entity.Record;
import com.nsh.signin.entity.Statement;
import com.nsh.signin.entity.TeacherCheckin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherCheckinService {

    @Autowired
    private TeacherCheckinMapper teacherCheckinMapper;

    /**
     * 根据教师id获取该教师所有的考勤记录
     * @param teacherId 教师id
     * @param pageNumber 页码
     * @param pageSize 一页中的数据数
     * @return pageInfo
     */
    public PageInfo getAllCheckin(String teacherId,Integer pageNumber, Integer pageSize){
        PageHelper.startPage(pageNumber, pageSize);
        List<TeacherCheckin> teacherCheckinList = teacherCheckinMapper.getCheckinList(teacherId);
        for(TeacherCheckin each : teacherCheckinList){
            each.setAbsentRate(teacherCheckinMapper.getAbsentRate(each.getId())==null?0.00f: teacherCheckinMapper.getAbsentRate(each.getId()));
        }
        PageInfo pageInfo = new PageInfo(teacherCheckinList);
        return pageInfo;
    }

    public List<Statement> selectStatement(String teacherId){
        return teacherCheckinMapper.selectStatement(teacherId);
    }

    public float selectRate(String teacherId,String studentId){
        return teacherCheckinMapper.selectRate(teacherId,studentId);
    }

    public List<Record> selectRecord(String teacherId, String studentId){
        return teacherCheckinMapper.selectRecord(teacherId,studentId);
    }
}
