package com.nsh.signin.dao;

import com.nsh.signin.entity.TeacherAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface TeacherAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeacherAccount record);

    int insertSelective(TeacherAccount record);

    TeacherAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeacherAccount record);

    int updateByPrimaryKey(TeacherAccount record);

    @Select("select * from teacher_account where teacher_id = #{teacherId} and teacher_password = #{teacherPassword}")
    public TeacherAccount getTeacher(TeacherAccount teacherAccount);
}