package com.nsh.signin.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nsh.signin.dao.TeacherCheckinDao;
import com.nsh.signin.entity.TeacherCheckin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherCheckinService {

    @Autowired
    private TeacherCheckinDao teacherCheckinDao;

    /**
     * 根据教师id获取该教师所有的考勤记录
     * @param teacherId 教师id
     * @param pageNumber 页码
     * @param pageSize 一页中的数据数
     * @return pageInfo
     */
    public PageInfo getAllCheckin(String teacherId,Integer pageNumber, Integer pageSize){
        PageHelper.startPage(pageNumber, pageSize);
        List<TeacherCheckin> teacherCheckinList = teacherCheckinDao.getCheckinList(teacherId);
        for(TeacherCheckin each : teacherCheckinList){
            each.setAbsentRate(teacherCheckinDao.getAbsentRate(each.getId())==null?0.00f:teacherCheckinDao.getAbsentRate(each.getId()));
        }
        PageInfo pageInfo = new PageInfo(teacherCheckinList);
        return pageInfo;
    }
}
