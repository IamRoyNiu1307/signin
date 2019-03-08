package com.nsh.signin.entity;

import java.util.Objects;

public class CheckLog {
    private int id;
    private String studentId;
    private Integer teacherCheckinId;
    private String status;

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

    public Integer getTeacherCheckinId() {
        return teacherCheckinId;
    }

    public void setTeacherCheckinId(Integer teacherCheckinId) {
        this.teacherCheckinId = teacherCheckinId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckLog checkLog = (CheckLog) o;
        return id == checkLog.id &&
                Objects.equals(studentId, checkLog.studentId) &&
                Objects.equals(teacherCheckinId, checkLog.teacherCheckinId) &&
                Objects.equals(status, checkLog.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentId, teacherCheckinId, status);
    }
}
