package com.nsh.signin.entity;

import java.util.Objects;

public class Schedule {
    private int id;
    private Integer classId;
    private Integer courseId;
    private String teacherId;
    private String workday;
    private Integer no;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
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

    public Schedule() {
    }

    public Schedule(int id, Integer classId, Integer courseId, String teacherId, String workday, Integer no) {
        this.id = id;
        this.classId = classId;
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.workday = workday;
        this.no = no;
    }
}
