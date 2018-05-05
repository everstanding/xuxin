package com.young.vo;

import java.math.BigInteger;

public class StudyVo
{
    private Integer sId;
    private String sTitle;
    private String sIntro;
    private String sUrl;
    private Integer uId;
    private Long sTime;
    private String sTimeString;
    private String uHeaderUrl;
    private String uName;
    private Integer sTumbNum;
    private Integer sMatchNum;

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsTimeString() {
        return sTimeString;
    }

    public void setsTimeString(String sTimeString) {
        this.sTimeString = sTimeString;
    }

    public String getuHeaderUrl() {
        return uHeaderUrl;
    }

    public void setuHeaderUrl(String uHeaderUrl) {
        this.uHeaderUrl = uHeaderUrl;
    }

    public Integer getsTumbNum() {
        return sTumbNum;
    }

    public void setsTumbNum(Integer sTumbNum) {
        this.sTumbNum = sTumbNum;
    }

    public Integer getsMatchNum() {
        return sMatchNum;
    }

    public void setsMatchNum(Integer sMatchNum) {
        this.sMatchNum = sMatchNum;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsTitle() {
        return sTitle;
    }

    public void setsTitle(String sTitle) {
        this.sTitle = sTitle;
    }

    public String getsIntro() {
        return sIntro;
    }

    public void setsIntro(String sIntro) {
        this.sIntro = sIntro;
    }

    public String getsUrl() {
        return sUrl;
    }

    public void setsUrl(String sUrl) {
        this.sUrl = sUrl;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Long getsTime() {

        return sTime;
    }

    public void setsTime(Long sTime) {
        this.sTime = sTime;
    }
}
