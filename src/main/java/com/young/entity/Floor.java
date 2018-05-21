package com.young.entity;



import javax.persistence.*;


@Entity
public class Floor {

    private Integer fId;
    private Integer pId;
    private String fMain;
    private Integer uId;


    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
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
