package com.nsh.signin.dao;

import com.nsh.signin.entity.StudentInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface StudentInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    StudentInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentInfo record);

    int updateByPrimaryKey(StudentInfo record);

    @Select("select * from student_info where student_id = #{studentId}")
    public StudentInfo getStudentInfo(String studentId);

    @Select("select student_name from student_info where student_id = #{studentId}")
    public String getStudentName(String studentId);

    @Insert("insert into student_info values(Null,#{studentId},#{studentName},#{classId})")
    public void addStudentInfo(StudentInfo studentInfo);
}