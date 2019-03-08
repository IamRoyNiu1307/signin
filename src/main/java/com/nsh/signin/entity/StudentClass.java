package com.nsh.signin.entity;

public class StudentClass {
    private String studentId;
    private String studentName;
    private String className;

    public StudentClass() {
    }

    public StudentClass(String studentId, String studentName, String className) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.className = className;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "StudentClass{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
