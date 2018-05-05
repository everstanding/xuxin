package com.young.entity;


import javax.persistence.Entity;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Post {
    private Integer pId;
    private String pTitle;
    private String pMain;
    private Integer pFloor;
    private Integer uId;


    @Id
    @GeneratedValue (strategy = GenerationType. IDENTITY)
    @Column(name = "p_id", nullable = false)
    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }



    @Basic
    @Column(name = "p_title", nullable = false)
    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    @Basic
    @Column(name = "p_main", nullable = false)
    public String getpMain() {
        return pMain;
    }

    public void setpMain(String pMain) {
        this.pMain = pMain;
    }

    @Basic
    @Column(name = "p_floor", nullable = false)
    public Integer getpFloor() {
        return pFloor;
    }

    public void setpFloor(Integer pFloor) {
        this.pFloor = pFloor;
    }

    @Basic
    @Column(name = "u_id", nullable = false)
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }
}
