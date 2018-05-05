package com.young.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Study {
    private int sId;
    private String sTitle;
    private String sIntro;
    private String sUrl;
    private Integer uId;
    private Long sTime;
    private Integer sTumbNum;
    private Integer sMatchNum;

    @Id
    @Column(name = "s_id", nullable = false)
    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    @Basic
    @Column(name = "s_title", nullable = true, length = 255)
    public String getsTitle() {
        return sTitle;
    }

    public void setsTitle(String sTitle) {
        this.sTitle = sTitle;
    }

    @Basic
    @Column(name = "s_intro", nullable = true, length = 255)
    public String getsIntro() {
        return sIntro;
    }

    public void setsIntro(String sIntro) {
        this.sIntro = sIntro;
    }

    @Basic
    @Column(name = "s_url", nullable = true, length = 255)
    public String getsUrl() {
        return sUrl;
    }

    public void setsUrl(String sUrl) {
        this.sUrl = sUrl;
    }

    @Basic
    @Column(name = "u_id", nullable = true)
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "s_time", nullable = true)
    public Long getsTime() {
        return sTime;
    }

    public void setsTime(Long sTime) {
        this.sTime = sTime;
    }

    @Basic
    @Column(name = "s_tumb_num", nullable = true)
    public Integer getsTumbNum() {
        return sTumbNum;
    }

    public void setsTumbNum(Integer sTumbNum) {
        this.sTumbNum = sTumbNum;
    }

    @Basic
    @Column(name = "s_match_num", nullable = true)
    public Integer getsMatchNum() {
        return sMatchNum;
    }

    public void setsMatchNum(Integer sMatchNum) {
        this.sMatchNum = sMatchNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Study study = (Study) o;

        if (sId != study.sId) return false;
        if (sTitle != null ? !sTitle.equals(study.sTitle) : study.sTitle != null) return false;
        if (sIntro != null ? !sIntro.equals(study.sIntro) : study.sIntro != null) return false;
        if (sUrl != null ? !sUrl.equals(study.sUrl) : study.sUrl != null) return false;
        if (uId != null ? !uId.equals(study.uId) : study.uId != null) return false;
        if (sTime != null ? !sTime.equals(study.sTime) : study.sTime != null) return false;
        if (sTumbNum != null ? !sTumbNum.equals(study.sTumbNum) : study.sTumbNum != null) return false;
        if (sMatchNum != null ? !sMatchNum.equals(study.sMatchNum) : study.sMatchNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sId;
        result = 31 * result + (sTitle != null ? sTitle.hashCode() : 0);
        result = 31 * result + (sIntro != null ? sIntro.hashCode() : 0);
        result = 31 * result + (sUrl != null ? sUrl.hashCode() : 0);
        result = 31 * result + (uId != null ? uId.hashCode() : 0);
        result = 31 * result + (sTime != null ? sTime.hashCode() : 0);
        result = 31 * result + (sTumbNum != null ? sTumbNum.hashCode() : 0);
        result = 31 * result + (sMatchNum != null ? sMatchNum.hashCode() : 0);
        return result;
    }
}
