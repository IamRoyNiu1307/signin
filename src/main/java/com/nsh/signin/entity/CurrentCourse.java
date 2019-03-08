package com.nsh.signin.entity;

public class CurrentCourse {
    private String workday;
    private Integer no;
    private int courseId;
    private String courseName;
    private int classId;
    private String className;
    private String classroom;

    public CurrentCourse() {
    }

    public CurrentCourse(String workday, Integer no, int courseId, String courseName, int classId, String className, String classroom) {
        this.workday = workday;
        this.no = no;
        this.courseId = courseId;
        this.courseName = courseName;
        this.classId = classId;
        this.className = className;
        this.classroom = classroom;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
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

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
