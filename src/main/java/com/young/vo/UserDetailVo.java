package com.young.vo;

public class UserDetailVo {
    //private Integer uId;
    private String uName;
    private String uHeaderUrl;
    private String uGender;
    private String uSchoolNum;
    private String uQq;
    private String uWx;
    private String uPhone;
    //private Integer uTeamPower;
    //private Integer uStudyPower;
    //private String uPw;

    public String getuSchoolNum() {
        return uSchoolNum;
    }

    public void setuSchoolNum(String uSchoolNum) {
        this.uSchoolNum = uSchoolNum;
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

    public String getuGender() {
        return uGender;
    }

    public void setuGender(String uGender) {
        this.uGender = uGender;
    }

    public String getuQq() {
        return uQq;
    }

    public void setuQq(String uQq) {
        this.uQq = uQq;
    }

    public String getuWx() {
        return uWx;
    }

    public void setuWx(String uWx) {
        this.uWx = uWx;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }
}
