package com.nsh.signin.entity;

public class StudentAccount {
    private Integer id;

    private String studentId;

    private String studentPassword;

    private String openid;

    private Integer hasRegisted;

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

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword == null ? null : studentPassword.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Integer getHasRegisted() {
        return hasRegisted;
    }

    public void setHasRegisted(Integer hasRegisted) {
        this.hasRegisted = hasRegisted;
    }
}