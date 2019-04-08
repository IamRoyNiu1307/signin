package com.nsh.signin.entity;

import java.sql.Timestamp;
import java.util.Date;

public class TeacherCheckin {
    private Integer id;

    private String teacherId;

    private Timestamp checkinTime;

    private Integer status;

    private Float absentRate;

    public TeacherCheckin(String teacherId, Timestamp checkinTime) {
        this.teacherId=teacherId;
        this.checkinTime=checkinTime;
    }

    public TeacherCheckin(Integer id, String teacherId, Timestamp checkinTime, Integer status) {
        this.id = id;
        this.teacherId = teacherId;
        this.checkinTime = checkinTime;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public Date getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(Timestamp checkinTime) {
        this.checkinTime = checkinTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Float getAbsentRate() {
        return absentRate;
    }

    public void setAbsentRate(Float absentRate) {
        this.absentRate = absentRate;
    }
}