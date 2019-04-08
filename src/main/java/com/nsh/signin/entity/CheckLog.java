package com.nsh.signin.entity;

public class CheckLog {
    private Integer id;

    private String studentId;

    private Integer teacherCheckinId;

    private String status;

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
        this.status = status == null ? null : status.trim();
    }
}