package com.nsh.signin.entity;

import java.sql.Date;
import java.util.List;

public class LeaveApp {
    private Integer id;

    private String studentId;

    private Integer courseId;

    private Date date;

    private String reason;

    private String detail;

    private List<LeaveAppImage> leaveAppImages;

    public LeaveApp() {}

    public LeaveApp(Integer id, String studentId, Integer courseId, Date date, String reason, String detail) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.date = date;
        this.reason = reason;
        this.detail = detail;
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

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}