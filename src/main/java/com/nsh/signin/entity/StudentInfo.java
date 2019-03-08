package com.nsh.signin.entity;

import java.util.Objects;

public class StudentInfo {
    private int id;
    private String studentId;
    private String studentName;
    private Integer classId;

    public StudentInfo() {
    }

    public StudentInfo(String studentId, String studentName, Integer classId) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.classId = classId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentInfo that = (StudentInfo) o;
        return id == that.id &&
                Objects.equals(studentId, that.studentId) &&
                Objects.equals(studentName, that.studentName) &&
                Objects.equals(classId, that.classId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentId, studentName, classId);
    }
}
