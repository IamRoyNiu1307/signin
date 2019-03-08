package com.nsh.signin.dao;

import com.nsh.signin.entity.ClassCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TeacherCourseDao {

    @Select("select ")
    public ClassCourse getClassCourse();

}
