package com.nsh.signin.dao;

import com.nsh.signin.entity.StudentInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Auther: iamRoyNiu
 * @Date: 2019/1/2 22:31
 */
@Mapper
public interface StudentInfoDao {

    @Select("select * from student_info where student_id = #{studentId}")
    public StudentInfo getStudentInfo(String studentId);

    @Select("select student_name from student_info where student_id = #{studentId}")
    public String getStudentName(String studentId);

    @Insert("insert into student_info values(Null,#{studentId},#{studentName},#{classId})")
    public void addStudentInfo(StudentInfo studentInfo);

}
