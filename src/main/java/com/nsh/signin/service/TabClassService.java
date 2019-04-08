package com.nsh.signin.service;

import com.nsh.signin.dao.TabClassMapper;
import com.nsh.signin.entity.TabClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TabClassService {
    @Autowired
    private TabClassMapper tabClassMapper;

    /**
     * 根据教师id 查询教师所带的班级
     * @param teacherId
     * @return
     */
    public List<TabClass> getTabClassListByTeacherId(String teacherId){
        return tabClassMapper.selectClassListByTeacherId(teacherId);
    }

}
