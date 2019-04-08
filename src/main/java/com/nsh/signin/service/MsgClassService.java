package com.nsh.signin.service;

import com.nsh.signin.dao.MsgClassMapper;
import com.nsh.signin.entity.MsgClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MsgClassService {
    @Autowired
    private MsgClassMapper msgClassMapper;

    public int insertSelective(MsgClass record){
        return msgClassMapper.insertSelective(record);
    }

    /**
     * 批量插入
     * @param msgId 公告id
     * @param classes 班级id数组
     */
    public void insertRecordBatch(int msgId,int[] classes){

        msgClassMapper.insertRecordBatch(msgId,classes);
    }
}
