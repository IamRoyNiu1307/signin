package com.nsh.signin.entity;

import java.util.Objects;

public class StudentAccount {
    private int id;
    private String studentId;
    private String studentPassword;
    private String openid;
    private Integer hasRegisted;

    public StudentAccount() {
    }

    public StudentAccount(String studentId, String studentPassword, String openid, Integer hasRegisted) {
        this.studentId = studentId;
        this.studentPassword = studentPassword;
        this.openid = openid;
        this.hasRegisted = hasRegisted;
    }

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

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getHasRegisted() {
        return hasRegisted;
    }

    public void setHasRegisted(Integer hasRegisted) {
        this.hasRegisted = hasRegisted;
    }

    @Override
    public String toString() {
        return "StudentAccount{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", studentPassword='" + studentPassword + '\'' +
                ", openid='" + openid + '\'' +
                ", hasRegisted='" + hasRegisted + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentAccount that = (StudentAccount) o;
        return id == that.id &&
                Objects.equals(studentId, that.studentId) &&
                Objects.equals(studentPassword, that.studentPassword) &&
                Objects.equals(openid, that.openid) &&
                Objects.equals(hasRegisted, that.hasRegisted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentId, studentPassword, openid, hasRegisted);
    }
}
