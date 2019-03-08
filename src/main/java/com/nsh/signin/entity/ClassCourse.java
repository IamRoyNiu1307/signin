package com.nsh.signin.entity;

public class ClassCourse {
    private String className;
    private String courseName;
    private String teacherName;
    private String workday;
    private Integer no;
    private String classroom;

    public ClassCourse() {
    }

    public ClassCourse(String className, String courseName, String teacherName, String workday, Integer no,String classroom) {
        this.className = className;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.workday = workday;
        this.no = no;
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getWorkday() {
        return workday;
    }

    public void setWorkday(String workday) {
        this.workday = workday;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "ClassCourse{" +
                "className='" + className + '\'' +
                ", courseName='" + courseName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", workday='" + workday + '\'' +
                ", no=" + no +
                ", classroom='" + classroom + '\'' +
                '}';
    }
}
