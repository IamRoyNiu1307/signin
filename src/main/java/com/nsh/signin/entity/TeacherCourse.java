package com.nsh.signin.entity;


import java.util.Objects;


public class TeacherCourse {
    private int id;
    private String teacherId;
    private Integer courseId;

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

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherCourse that = (TeacherCourse) o;
        return id == that.id &&
                Objects.equals(teacherId, that.teacherId) &&
                Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teacherId, courseId);
    }
}
