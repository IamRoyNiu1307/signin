package com.nsh.signin.entity;

import java.util.Objects;

public class TeacherAccount {
    private int id;
    private String teacherId;
    private String teacherPassword;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherAccount that = (TeacherAccount) o;
        return id == that.id &&
                Objects.equals(teacherId, that.teacherId) &&
                Objects.equals(teacherPassword, that.teacherPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teacherId, teacherPassword);
    }

    @Override
    public String toString() {
        return "TeacherAccount{" +
                "id=" + id +
                ", teacherId='" + teacherId + '\'' +
                ", teacherPassword='" + teacherPassword + '\'' +
                '}';
    }
}
