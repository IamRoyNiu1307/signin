package com.nsh.signin.dao;

import com.nsh.signin.entity.TeacherCheckin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface TeacherCheckinMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeacherCheckin record);

    int insertSelective(TeacherCheckin record);

    TeacherCheckin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeacherCheckin record);

    int updateByPrimaryKey(TeacherCheckin record);

    @Select("select id, teacher_id, checkin_time, status from teacher_checkin where teacher_id = #{teacherId}")
    public List<TeacherCheckin> getCheckinList(String teacherId);

    @Select("select\n" +
            "(select total\n" +
            "from (select count(*) total,`status`,cl.teacher_checkin_id checkinId from check_log cl where cl.teacher_checkin_id = #{checkinId} group by `status`)temp\n" +
            "where temp.`status` = '已签到')/\n" +
            "(select total\n" +
            "from (select count(*) total,`status`,cl.teacher_checkin_id checkinId from check_log cl where cl.teacher_checkin_id = #{checkinId} group by `status`)temp\n" +
            "where temp.`status` = '未签到') absentRate")
    public Float getAbsentRate(int checkinId);
}