package com.nsh.signin.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nsh.signin.dao.TabMsgMapper;
import com.nsh.signin.entity.MsgClass;
import com.nsh.signin.entity.TabClass;
import com.nsh.signin.entity.TabMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TabMsgService {

    @Autowired
    private TabMsgMapper tabMsgMapper;

    public TabMsg selectByPrimaryKey(int id){
        return tabMsgMapper.selectByPrimaryKey(id);
    }

    public int insertSelective(TabMsg record){
        return tabMsgMapper.insertSelective(record);
    }

    public PageInfo getMsgList(String teacherId, Integer pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<TabMsg> tabMsgList = tabMsgMapper.getMsgList(teacherId);
        PageInfo pageInfo = new PageInfo(tabMsgList);
        return pageInfo;
    }

    public void updateByPrimaryKeySelective(TabMsg tabMsg){
        tabMsgMapper.updateByPrimaryKeySelective(tabMsg);
    }
}
