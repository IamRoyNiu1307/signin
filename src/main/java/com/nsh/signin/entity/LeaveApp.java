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

    private Integer status;

    private String teacherId;

    private TeacherInfo teacherInfo;

    private Course course;

    private List<LeaveAppImage> leaveAppImages;


    public LeaveApp() {}

    public LeaveApp(Integer id, String studentId, Integer courseId, Date date, String reason, String detail, Integer status, String teacherId) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.date = date;
        this.reason = reason;
        this.detail = detail;
        this.status = status;
        this.teacherId = teacherId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public List<LeaveAppImage> getLeaveAppImages() {
        return leaveAppImages;
    }

    public void setLeaveAppImages(List<LeaveAppImage> leaveAppImages) {
        this.leaveAppImages = leaveAppImages;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public TeacherInfo getTeacherInfo() {
        return teacherInfo;
    }

    public void setTeacherInfo(TeacherInfo teacherInfo) {
        this.teacherInfo = teacherInfo;
    }
}