package com.nsh.signin.dao;

import com.nsh.signin.entity.CheckLog;
import com.nsh.signin.entity.CurrentCourse;
import com.nsh.signin.entity.TeacherCheckin;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;
@Mapper
public interface CheckLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckLog record);

    int insertSelective(CheckLog record);

    CheckLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CheckLog record);

    int updateByPrimaryKey(CheckLog record);

    @Select("select s.workday,s.no,s.course_id,course.course_name,s.class_id,tab_class.class_name,s.classroom classroom\n" +
            "from `schedule` s,tab_class,course,(SELECT case DATE_FORMAT(NOW(), '%w') when 1 then 'monday' when 2 then 'tuesday' when 3 then 'wednesday' when 4 then 'thursday' when 5 then 'friday' end as workday) t1\n" +
            "where s.workday = t1.workday and s.course_id=course.id and s.class_id = tab_class.id and s.`no`= #{no} and s.teacher_id = #{teacherId}")
    public CurrentCourse getCurrentCourse(@Param("teacherId") String teacherId, @Param("no") int no);


    @Insert("insert into teacher_checkin values(Null,#{teacherId},#{checkinTime},1)")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public void addTeacherCheckin(TeacherCheckin teacherCheckin);

    @Update("update teacher_checkin set status = 0 where id = #{teacherCheckinId}")
    public void closeCheckin(int teacherCheckinId);

    @Insert("insert into check_log values(Null,#{studentId},#{teacherCkeckinId},'未签到')")
    public void addStudentsToCheckinList(@Param("studentId") String studentId, @Param("teacherCkeckinId")int teacherCheckinId);

    @Select("select tc.id,cl.`status`\n" +
            "from teacher_checkin tc,check_log cl\n" +
            "where cl.teacher_checkin_id = tc.id and tc.`status`=1 and cl.student_id = #{studentId}")
    public Map getCheckStatus(String studentId);

    @Update("update check_log set status = '已签到' where student_id = #{studentId} and teacher_checkin_id = #{teacherCheckinId}")
    public void setStatus(@Param("studentId") String studentId,@Param("teacherCheckinId") int teacherCheckinId);

    @Select("select si.student_id,si.student_name\n" +
            "from check_log cl , student_info si\n" +
            "where cl.student_id = si.student_id and cl.`status` = '未签到' and cl.teacher_checkin_id = #{checkinId}")
    public List<Map> getAbsentList(int checkinId);
}