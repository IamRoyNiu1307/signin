package com.nsh.signin.entity;

import java.util.Objects;

public class TeacherInfo {
    private int id;
    private String teacherId;
    private String teacherName;

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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherInfo that = (TeacherInfo) o;
        return id == that.id &&
                Objects.equals(teacherId, that.teacherId) &&
                Objects.equals(teacherName, that.teacherName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teacherId, teacherName);
    }
}
