package com.nsh.signin.dao;

import com.nsh.signin.entity.StudentAccount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
@Mapper
public interface StudentAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentAccount record);

    int insertSelective(StudentAccount record);

    StudentAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentAccount record);

    int updateByPrimaryKey(StudentAccount record);

    @Select("select * from student_account where student_id = #{studentId} and student_password = #{studentPassword}")
    public StudentAccount getStudent(StudentAccount student);

    @Select("select * from student_account where student_id = #{studentid}")
    public StudentAccount getStudentById(String userid);

    @Select("select * from student_account where openid = #{openid}")
    public StudentAccount getStudentByOpenid(String openid);

    @Update("update student_account set openid = #{openid} where student_id = #{studentId} and student_password = #{studentPassword}")
    public void bindAccount(StudentAccount studentAccount);

    @Update("update student_account set has_registed = 1 where student_id = #{studentid}")
    public void setRegisted(String studentid);

    @Select("select has_registed from student_account where student_id = #{studentid}")
    public Integer getRegisted(String studentid);

    @Insert("insert into student_account values(Null,#{studentId},#{studentPassword},Null,0)")
    public void addStudentAccount(StudentAccount studentAccount);
}