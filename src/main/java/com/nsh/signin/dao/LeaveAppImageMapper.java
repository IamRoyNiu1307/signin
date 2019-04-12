package com.nsh.signin.dao;

import com.nsh.signin.entity.LeaveAppImage;

import java.util.List;

public interface LeaveAppImageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LeaveAppImage record);

    int insertSelective(LeaveAppImage record);

    LeaveAppImage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LeaveAppImage record);

    int updateByPrimaryKey(LeaveAppImage record);

    List<LeaveAppImage> selectByLeaveAppId(int leaveAppId);
}