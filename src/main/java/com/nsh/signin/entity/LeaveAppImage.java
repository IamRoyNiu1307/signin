package com.nsh.signin.entity;

public class LeaveAppImage {
    private Integer id;

    private Integer leaveAppId;

    private String imagePath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLeaveAppId() {
        return leaveAppId;
    }

    public void setLeaveAppId(Integer leaveAppId) {
        this.leaveAppId = leaveAppId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

    public LeaveAppImage() {
    }

    public LeaveAppImage(Integer leaveAppId, String imagePath) {
        this.leaveAppId = leaveAppId;
        this.imagePath = imagePath;
    }
}