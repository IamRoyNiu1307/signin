package com.nsh.signin.entity;

import java.sql.Timestamp;

public class Statement {
    private Timestamp checkinTime;
    private int num;

    public String getCheckinTime() {
        String[] s = checkinTime.toString().split(" ")[0].split("-");
        return s[1]+"-"+s[2];
    }

    public void setCheckinTime(Timestamp checkinTime) {
        this.checkinTime = checkinTime;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "checkinTime=" + checkinTime +
                ", num=" + num +
                '}';
    }
}
