package com.nsh.signin.service;

import com.nsh.signin.dao.LeaveAppMapper;
import com.nsh.signin.entity.LeaveApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveAppService {

    @Autowired
    private LeaveAppMapper leaveAppMapper;

    public int deleteByPrimaryKey(Integer id){
        return leaveAppMapper.deleteByPrimaryKey(id);
    }

    public int insert(LeaveApp record){
        return leaveAppMapper.insert(record);
    }

    public int insertSelective(LeaveApp record){
        return leaveAppMapper.insertSelective(record);
    }

    public LeaveApp selectByPrimaryKey(Integer id){
        return leaveAppMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(LeaveApp record){
        return leaveAppMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(LeaveApp record){
        return leaveAppMapper.updateByPrimaryKey(record);
    }

    public LeaveApp selectByStudentId(String studentId) {
        return leaveAppMapper.selectByStudentId(studentId);
    }
}
