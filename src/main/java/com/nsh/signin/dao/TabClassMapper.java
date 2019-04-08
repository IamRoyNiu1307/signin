package com.nsh.signin.dao;

import com.nsh.signin.entity.TabClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TabClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TabClass record);

    int insertSelective(TabClass record);

    TabClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TabClass record);

    int updateByPrimaryKey(TabClass record);

    List<TabClass> selectClassListByTeacherId(String teacherId);
}