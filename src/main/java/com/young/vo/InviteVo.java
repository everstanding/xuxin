package com.young.vo;

public class InviteVo {
    private int inviteId;
    private String uName;
    private String tName;
    private int status;

    public int getInviteId() {
        return inviteId;
    }

    public void setInviteId(int inviteId) {
        this.inviteId = inviteId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InviteVo{" +
                "uName='" + uName + '\'' +
                ", tName='" + tName + '\'' +
                ", status=" + status +
                '}';
    }
}
