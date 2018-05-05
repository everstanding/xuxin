package com.young.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    private int uId;
    private String uName;
    private String uHeaderUrl;
    private String uGender;
    private String uSchoolNum;
    private String uQq;
    private String uWx;
    private String uPhone;
    private Integer uTeamPower;
    private Integer uStudyPower;
    private String uPw;

    @Id
    @Column(name = "u_id", nullable = false)
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "u_name", nullable = true, length = 255)
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    @Basic
    @Column(name = "u_header_url", nullable = true, length = 255)
    public String getuHeaderUrl() {
        return uHeaderUrl;
    }

    public void setuHeaderUrl(String uHeaderUrl) {
        this.uHeaderUrl = uHeaderUrl;
    }

    @Basic
    @Column(name = "u_gender", nullable = true, length = 255)
    public String getuGender() {
        return uGender;
    }

    public void setuGender(String uGender) {
        this.uGender = uGender;
    }

    @Basic
    @Column(name = "u_school_num", nullable = true, length = 255)
    public String getuSchoolNum() {
        return uSchoolNum;
    }

    public void setuSchoolNum(String uSchoolNum) {
        this.uSchoolNum = uSchoolNum;
    }

    @Basic
    @Column(name = "u_qq", nullable = true, length = 255)
    public String getuQq() {
        return uQq;
    }

    public void setuQq(String uQq) {
        this.uQq = uQq;
    }

    @Basic
    @Column(name = "u_wx", nullable = true, length = 255)
    public String getuWx() {
        return uWx;
    }

    public void setuWx(String uWx) {
        this.uWx = uWx;
    }

    @Basic
    @Column(name = "u_phone", nullable = true, length = 255)
    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    @Basic
    @Column(name = "u_team_power", nullable = true)
    public Integer getuTeamPower() {
        return uTeamPower;
    }

    public void setuTeamPower(Integer uTeamPower) {
        this.uTeamPower = uTeamPower;
    }

    @Basic
    @Column(name = "u_study_power", nullable = true)
    public Integer getuStudyPower() {
        return uStudyPower;
    }

    public void setuStudyPower(Integer uStudyPower) {
        this.uStudyPower = uStudyPower;
    }

    @Basic
    @Column(name = "u_pw", nullable = true, length = 255)
    public String getuPw() {
        return uPw;
    }

    public void setuPw(String uPw) {
        this.uPw = uPw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (uId != user.uId) return false;
        if (uName != null ? !uName.equals(user.uName) : user.uName != null) return false;
        if (uHeaderUrl != null ? !uHeaderUrl.equals(user.uHeaderUrl) : user.uHeaderUrl != null) return false;
        if (uGender != null ? !uGender.equals(user.uGender) : user.uGender != null) return false;
        if (uSchoolNum != null ? !uSchoolNum.equals(user.uSchoolNum) : user.uSchoolNum != null) return false;
        if (uQq != null ? !uQq.equals(user.uQq) : user.uQq != null) return false;
        if (uWx != null ? !uWx.equals(user.uWx) : user.uWx != null) return false;
        if (uPhone != null ? !uPhone.equals(user.uPhone) : user.uPhone != null) return false;
        if (uTeamPower != null ? !uTeamPower.equals(user.uTeamPower) : user.uTeamPower != null) return false;
        if (uStudyPower != null ? !uStudyPower.equals(user.uStudyPower) : user.uStudyPower != null) return false;
        if (uPw != null ? !uPw.equals(user.uPw) : user.uPw != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uId;
        result = 31 * result + (uName != null ? uName.hashCode() : 0);
        result = 31 * result + (uHeaderUrl != null ? uHeaderUrl.hashCode() : 0);
        result = 31 * result + (uGender != null ? uGender.hashCode() : 0);
        result = 31 * result + (uSchoolNum != null ? uSchoolNum.hashCode() : 0);
        result = 31 * result + (uQq != null ? uQq.hashCode() : 0);
        result = 31 * result + (uWx != null ? uWx.hashCode() : 0);
        result = 31 * result + (uPhone != null ? uPhone.hashCode() : 0);
        result = 31 * result + (uTeamPower != null ? uTeamPower.hashCode() : 0);
        result = 31 * result + (uStudyPower != null ? uStudyPower.hashCode() : 0);
        result = 31 * result + (uPw != null ? uPw.hashCode() : 0);
        return result;
    }
}
