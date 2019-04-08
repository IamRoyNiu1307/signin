package com.nsh.signin.entity;

public class MsgClass {
    private Integer id;

    private Integer msgId;

    private Integer classId;

    private TabClass tabClass;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public TabClass getTabClass() {
        return tabClass;
    }

    public void setTabClass(TabClass tabClass) {
        this.tabClass = tabClass;
    }

    public MsgClass() {
    }

    public MsgClass(Integer id, Integer msgId, Integer classId) {
        this.id = id;
        this.msgId = msgId;
        this.classId = classId;
    }

    public MsgClass(Integer msgId, Integer classId) {
        this.msgId = msgId;
        this.classId = classId;
    }
}