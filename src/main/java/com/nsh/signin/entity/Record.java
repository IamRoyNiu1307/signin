package com.nsh.signin.entity;

import java.sql.Timestamp;

public class Record {
    private String time;
    private String studentId;
    private String status;
    private String name;
    public String getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time.toString();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
