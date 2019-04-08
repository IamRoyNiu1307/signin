package com.nsh.signin.service;

import com.nsh.signin.dao.ScheduleMapper;
import com.nsh.signin.entity.ClassCourse;
import com.nsh.signin.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;

    /**
     * 获取教师id对应的一周内所有的课程
     * @param teacherId 教师id
     * @return
     */
    public List<ClassCourse> getClassCourseList(String teacherId){
        //获取课程表
        List<ClassCourse> classCourseList = scheduleMapper.getClassCourseList(teacherId);
        return classCourseList;
    }



}
