package com.nsh.signin.dao;

import com.nsh.signin.entity.StudentClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentClassMapper {

    @Select("SELECT DISTINCT si.student_id ,si.student_name as studentName,tab_class.class_name as className\n" +
            "FROM `schedule` s,tab_class,student_info si\n" +
            "WHERE s.class_id = tab_class.id and tab_class.id = si.class_id and teacher_id = #{teacherId}")
    public List<StudentClass> getStudentClassList(String teacherId);

    @Select("SELECT DISTINCT si.student_id ,si.student_name as studentName,tab_class.class_name as className\n" +
            "FROM `schedule` s,tab_class,student_info si\n" +
            "WHERE s.class_id = tab_class.id and tab_class.id = si.class_id and teacher_id = #{teacherId} and tab_class.class_name = #{className}")
    public List<StudentClass> getAllByClassName(@Param("teacherId") String teacherId,@Param("className") String className);

}
