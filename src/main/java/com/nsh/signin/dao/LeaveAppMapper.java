package com.nsh.signin.dao;

import com.nsh.signin.entity.LeaveApp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface LeaveAppMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LeaveApp record);

    int insertSelective(LeaveApp record);

    LeaveApp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LeaveApp record);

    int updateByPrimaryKey(LeaveApp record);

    List<LeaveApp> selectByStudentId(@Param("studentId") String studentId,@Param("status") Integer status);

    List<LeaveApp> selectByTeacherId(String teacherId);
}