package com.nsh.signin.service;

import com.nsh.signin.dao.LeaveAppImageMapper;
import com.nsh.signin.entity.LeaveAppImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveAppImageService  {

    @Autowired
    private LeaveAppImageMapper leaveAppImageMapper;

    public int deleteByPrimaryKey(Integer id) {
        return leaveAppImageMapper.deleteByPrimaryKey(id);
    }


    public int insert(LeaveAppImage record) {
        return leaveAppImageMapper.insert(record);
    }


    public int insertSelective(LeaveAppImage record) {
        return leaveAppImageMapper.insertSelective(record);
    }


    public LeaveAppImage selectByPrimaryKey(Integer id) {
        return leaveAppImageMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(LeaveAppImage record) {
        return leaveAppImageMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(LeaveAppImage record) {
        return leaveAppImageMapper.updateByPrimaryKey(record);
    }


    public List<LeaveAppImage> selectByLeaveAppId(int leaveAppId) {
        return leaveAppImageMapper.selectByLeaveAppId(leaveAppId);
    }
}
