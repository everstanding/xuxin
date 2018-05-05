package com.young.vo;

import com.young.entity.Laber;

import java.math.BigInteger;
import java.util.ArrayList;

public class TeamListVo {
    private Integer tId;
    private Integer tGrade;
    private String tGradeString;
    private Integer tScale;
    private Integer uId;
    private BigInteger tTime;
    private String tTitle;
    private String tTimeString;
    private String uName;
    private String uHeaderUrl;
    private ArrayList<Laber> labers;
    private ArrayList<Laber> labers_need;
    private ArrayList<Laber> labers_support;
    private Integer tTumbNum;
    private Integer tWatchNum;
    private String tIntro;
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String gettGradeString() {
        return tGradeString;
    }

    public void settGradeString(String tGradeString) {
        this.tGradeString = tGradeString;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettIntro() {
        return tIntro;
    }

    public void settIntro(String tIntro) {
        this.tIntro = tIntro;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public Integer gettGrade() {
        return tGrade;
    }

    public void settGrade(Integer tGrade) {
        this.tGrade = tGrade;
    }

    public Integer gettScale() {
        return tScale;
    }

    public void settScale(Integer tScale) {
        this.tScale = tScale;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public BigInteger gettTime() {
        return tTime;
    }

    public void settTime(BigInteger tTime) {
        this.tTime = tTime;
    }

    public String gettTitle() {
        return tTitle;
    }

    public void settTitle(String tTitle) {
        this.tTitle = tTitle;
    }

    public String gettTimeString() {
        return tTimeString;
    }

    public void settTimeString(String tTimeString) {
        this.tTimeString = tTimeString;
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

    public ArrayList<Laber> getLabers() {
        return labers;
    }

    public void setLabers(ArrayList<Laber> labers) {
        this.labers = labers;
    }

    public Integer gettTumbNum() {
        return tTumbNum;
    }

    public void settTumbNum(Integer tTumbNum) {
        this.tTumbNum = tTumbNum;
    }

    public Integer gettWatchNum() {
        return tWatchNum;
    }

    public void settWatchNum(Integer tWatchNum) {
        this.tWatchNum = tWatchNum;
    }

    public ArrayList<Laber> getLabers_need() {
        return labers_need;
    }

    public void setLabers_need(ArrayList<Laber> labers_need) {
        this.labers_need = labers_need;
    }

    public ArrayList<Laber> getLabers_support() {
        return labers_support;
    }

    public void setLabers_support(ArrayList<Laber> labers_support) {
        this.labers_support = labers_support;
    }
}
