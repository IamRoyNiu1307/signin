package com.nsh.signin.entity;

import java.util.Objects;

public class TabClass {
    private int id;
    private String className;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TabClass tabClass = (TabClass) o;
        return id == tabClass.id &&
                Objects.equals(className, tabClass.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, className);
    }
}
