package com.nsh.signin.dao;

import com.nsh.signin.entity.TeacherInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface TeacherInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeacherInfo record);

    int insertSelective(TeacherInfo record);

    TeacherInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeacherInfo record);

    int updateByPrimaryKey(TeacherInfo record);

    @Select("select id,teacher_id,teacher_name from teacher_info where teacher_id = #{teacherId}")
    public TeacherInfo getTeacherInfo(String teacherId);
}