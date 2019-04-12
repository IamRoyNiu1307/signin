package com.nsh.signin.dao;

import com.nsh.signin.entity.TabMsg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TabMsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TabMsg record);

    int insertSelective(TabMsg record);

    TabMsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TabMsg record);

    int updateByPrimaryKey(TabMsg record);

    List<TabMsg> getMsgList(String teacherId);

    List<TabMsg> selectByClassId(int classId);
}