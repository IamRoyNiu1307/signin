package com.nsh.signin.dao;

import com.nsh.signin.entity.TeacherCourse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeacherCourse record);

    int insertSelective(TeacherCourse record);

    TeacherCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeacherCourse record);

    int updateByPrimaryKey(TeacherCourse record);
}