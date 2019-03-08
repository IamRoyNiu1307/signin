package com.nsh.signin.dao;

import com.nsh.signin.entity.TeacherInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TeacherInfoDao {

    @Select("select * from teacher_info where teacher_id = #{teacherId}")
    public TeacherInfo getTeacherInfo(String teacherId);
}
