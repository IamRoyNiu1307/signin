package com.nsh.signin.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TabMsg {
    private Integer id;

    private String title;

    private String content;

    private Date pushDate;

    private Integer status;

    private String teacherAccount;

    private String imagePath;

    private List<MsgClass> msgClassList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getPushDate() {

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");

        return pushDate==null?null:sdf.format(pushDate);
    }

    public void setPushDate(Date pushDate) {
        this.pushDate = pushDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTeacherAccount() {
        return teacherAccount;
    }

    public void setTeacherAccount(String teacherAccount) {
        this.teacherAccount = teacherAccount == null ? null : teacherAccount.trim();
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

    public List<MsgClass> getMsgClassList() {
        return msgClassList;
    }

    public void setMsgClassList(List<MsgClass> msgClassList) {
        this.msgClassList = msgClassList;
    }

    public TabMsg() {
    }

    public TabMsg(String title, String content, Date pushDate, Integer status, String teacherAccount, String imagePath) {
        this.title = title;
        this.content = content;
        this.pushDate = pushDate;
        this.status = status;
        this.teacherAccount = teacherAccount;
        this.imagePath = imagePath;
    }
}