package com.young.entity;

import javax.persistence.*;


@Table(name = "teacher")
@Entity
public class Teacher {
    private int tId;
    private String tName;
    private String tPw;
    private String tPhone;
    private String tArea;
    private String tCredit;
    private String tSchoolNum;

    @Id
    @Column(name = "t_id", nullable = false)
    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    @Basic
    @Column(name = "t_name", nullable = true, length = 255)
    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    @Basic
    @Column(name = "t_phone", nullable = true, length = 255)
    public String gettPhone() {
        return tPhone;
    }

    public void settPhone(String tPhone) {
        this.tPhone = tPhone;
    }

    @Basic
    @Column(name = "t_school_num", nullable = true, length = 255)
    public String gettSchoolNum() {
        return tSchoolNum;
    }

    public void settSchoolNum(String tSchoolNum) {
        this.tSchoolNum = tSchoolNum;
    }

    @Basic
    @Column(name = "t_pw", nullable = true, length = 255)
    public String gettPw() {
        return tPw;
    }

    public void settPw(String tPw) {
        this.tPw = tPw;
    }

    @Basic
    @Column(name = "t_area", nullable = true, length = 255)
    public String gettArea() {
        return tArea;
    }

    public void settArea(String tArea) {
        this.tArea = tArea;
    }

    @Basic
    @Column(name = "t_credit", nullable = true, length = 255)
    public String gettCredit() {
        return tCredit;
    }

    public void settCredit(String tCredit) {
        this.tCredit = tCredit;
    }
}
