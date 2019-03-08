package com.nsh.signin.dao;

import com.nsh.signin.entity.ClassCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ScheduleDao {

    @Select("select tab_class.class_name as className,course.course_name as courseName,teacher_info.teacher_name as teacherName , s.workday as workday,s.`no` as no,s.classroom\n" +
            "from `schedule` s,course,tab_class,teacher_info\n" +
            "where s.course_id = course.id and s.class_id = tab_class.id and s.teacher_id = teacher_info.teacher_id and s.teacher_id = #{teacherId}")
    public List<ClassCourse> getClassCourseList(String teacherId);
}
