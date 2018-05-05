package com.young.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Team {
    private int tId;
    private Integer tGrade;
    private Integer tScale;
    private Integer uId;
    private Long tTime;
    private String tTitle;
    private Integer tTumbNum;
    private Integer tWatchNum;
    private String tIntro;
    private Integer tType;
    private Integer tState;

    @Id
    @Column(name = "t_id", nullable = false)
    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    @Basic
    @Column(name = "t_grade", nullable = true)
    public Integer gettGrade() {
        return tGrade;
    }

    public void settGrade(Integer tGrade) {
        this.tGrade = tGrade;
    }

    @Basic
    @Column(name = "t_scale", nullable = true)
    public Integer gettScale() {
        return tScale;
    }

    public void settScale(Integer tScale) {
        this.tScale = tScale;
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
    @Column(name = "t_time", nullable = true)
    public Long gettTime() {
        return tTime;
    }

    public void settTime(Long tTime) {
        this.tTime = tTime;
    }

    @Basic
    @Column(name = "t_title", nullable = true, length = 255)
    public String gettTitle() {
        return tTitle;
    }

    public void settTitle(String tTitle) {
        this.tTitle = tTitle;
    }

    @Basic
    @Column(name = "t_tumb_num", nullable = true)
    public Integer gettTumbNum() {
        return tTumbNum;
    }

    public void settTumbNum(Integer tTumbNum) {
        this.tTumbNum = tTumbNum;
    }

    @Basic
    @Column(name = "t_watch_num", nullable = true)
    public Integer gettWatchNum() {
        return tWatchNum;
    }

    public void settWatchNum(Integer tWatchNum) {
        this.tWatchNum = tWatchNum;
    }

    @Basic
    @Column(name = "t_intro", nullable = true, length = -1)
    public String gettIntro() {
        return tIntro;
    }

    public void settIntro(String tIntro) {
        this.tIntro = tIntro;
    }

    @Basic
    @Column(name = "t_type", nullable = true)
    public Integer gettType() {
        return tType;
    }

    public void settType(Integer tType) {
        this.tType = tType;
    }

    @Basic
    @Column(name = "t_state", nullable = true)
    public Integer gettState() {
        return tState;
    }

    public void settState(Integer tState) {
        this.tState = tState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (tId != team.tId) return false;
        if (tGrade != null ? !tGrade.equals(team.tGrade) : team.tGrade != null) return false;
        if (tScale != null ? !tScale.equals(team.tScale) : team.tScale != null) return false;
        if (uId != null ? !uId.equals(team.uId) : team.uId != null) return false;
        if (tTime != null ? !tTime.equals(team.tTime) : team.tTime != null) return false;
        if (tTitle != null ? !tTitle.equals(team.tTitle) : team.tTitle != null) return false;
        if (tTumbNum != null ? !tTumbNum.equals(team.tTumbNum) : team.tTumbNum != null) return false;
        if (tWatchNum != null ? !tWatchNum.equals(team.tWatchNum) : team.tWatchNum != null) return false;
        if (tIntro != null ? !tIntro.equals(team.tIntro) : team.tIntro != null) return false;
        if (tType != null ? !tType.equals(team.tType) : team.tType != null) return false;
        if (tState != null ? !tState.equals(team.tState) : team.tState != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tId;
        result = 31 * result + (tGrade != null ? tGrade.hashCode() : 0);
        result = 31 * result + (tScale != null ? tScale.hashCode() : 0);
        result = 31 * result + (uId != null ? uId.hashCode() : 0);
        result = 31 * result + (tTime != null ? tTime.hashCode() : 0);
        result = 31 * result + (tTitle != null ? tTitle.hashCode() : 0);
        result = 31 * result + (tTumbNum != null ? tTumbNum.hashCode() : 0);
        result = 31 * result + (tWatchNum != null ? tWatchNum.hashCode() : 0);
        result = 31 * result + (tIntro != null ? tIntro.hashCode() : 0);
        result = 31 * result + (tType != null ? tType.hashCode() : 0);
        result = 31 * result + (tState != null ? tState.hashCode() : 0);
        return result;
    }
}
