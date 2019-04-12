package com.nsh.signin.service;

import com.nsh.signin.dao.CourseMapper;
import com.nsh.signin.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    public int deleteByPrimaryKey(Integer id){
        return courseMapper.deleteByPrimaryKey(id);
    }

    public int insert(Course record){
        return courseMapper.insert(record);
    }

    public int insertSelective(Course record){
        return courseMapper.insertSelective(record);
    }

    public Course selectByPrimaryKey(Integer id){
        return courseMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Course record){
        return courseMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Course record){
        return courseMapper.updateByPrimaryKey(record);
    }

    public List<Course> selectCourseByClassId(int classId){
        return courseMapper.selectCourseByClassId(classId);
    }
}
