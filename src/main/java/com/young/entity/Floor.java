package com.young.entity;



import javax.persistence.Entity;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;



@Entity
public class Floor {

    private Integer fId;
    private Integer pId;
    private Integer uId;
    private String fMain;


    @Id
    @Column(name = "f_id", nullable = false)
    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }


    @Basic
    @Column(name = "p_id", nullable = false)
    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }


    @Basic
    @Column(name = "u_id", nullable = false)
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }


    @Basic
    @Column(name = "f_main", nullable = false)
    public String getfMain() {
        return fMain;
    }

    public void setfMain(String fMain) {
        this.fMain = fMain;
    }
}
