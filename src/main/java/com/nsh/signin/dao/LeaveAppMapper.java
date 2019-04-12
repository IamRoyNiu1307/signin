package com.nsh.signin.dao;

import com.nsh.signin.entity.LeaveApp;
import org.apache.ibatis.annotations.Mapper;


public interface LeaveAppMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LeaveApp record);

    int insertSelective(LeaveApp record);

    LeaveApp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LeaveApp record);

    int updateByPrimaryKey(LeaveApp record);

    LeaveApp selectByStudentId(String studentId);
}