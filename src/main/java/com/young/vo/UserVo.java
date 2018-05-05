package com.young.vo;

public class UserVo {
    private Integer uId;
    private String uName;
    private String uHeaderUrl;

    public int getuId() {

        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuHeaderUrl() {
        return uHeaderUrl;
    }

    public void setuHeaderUrl(String uHeaderUrl) {
        this.uHeaderUrl = uHeaderUrl;
    }
}
