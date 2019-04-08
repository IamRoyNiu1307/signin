package com.nsh.signin.entity;

public class StudentInfo {
    private Integer id;

    private String studentId;

    private String studentName;

    private Integer classId;

    public StudentInfo() {
    }

    public StudentInfo(Integer id, String studentId, String studentName, Integer classId) {
        this.id = id;
        this.studentId = studentId;
        this.studentName = studentName;
        this.classId = classId;
    }

    public StudentInfo(String studentId, String studentName, Integer classId) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.classId = classId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}