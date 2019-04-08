package com.nsh.signin.dao;

import com.nsh.signin.entity.MsgClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MsgClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MsgClass record);

    int insertSelective(MsgClass record);

    MsgClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MsgClass record);

    int updateByPrimaryKey(MsgClass record);

    List selectByMsgId(int id);

    void insertRecordBatch(@Param("msgId") int msgId, @Param("classes") int[] classes);
}