package com.young.vo;

public class TeacherDetailVo {
    private String tName;
    private String tPhone;
    private String tArea;
    private String tCredit;


    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }


    public String gettPhone() {
        return tPhone;
    }

    public void settPhone(String tPhone) {
        this.tPhone = tPhone;
    }

    public String gettArea() {
        return tArea;
    }

    public void settArea(String tArea) {
        this.tArea = tArea;
    }

    public String gettCredit() {
        return tCredit;
    }

    public void settCredit(String tCredit) {
        this.tCredit = tCredit;
    }

    @Override
    public String toString() {
        return "TeacherDetailVo{" +
                "tName='" + tName + '\'' +
                ", tPhone='" + tPhone + '\'' +
                ", tArea='" + tArea + '\'' +
                ", tCredit='" + tCredit + '\'' +
                '}';
    }
}
