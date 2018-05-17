package com.young.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class invite {
    private Integer invite_id;
    private Integer u_id;
    private Integer t_id;
    private String invite_main;
    private Integer status;

    @Id
    @Column(name = "invite_id", nullable = false)
    public Integer getInvite_id() {
        return invite_id;
    }

    public void setInvite_id(Integer invite_id) {
        this.invite_id = invite_id;
    }

    @Basic
    @Column(name = "u_id", nullable = false)
    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    @Basic
    @Column(name = "t_id", nullable = false)
    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "invite_main", nullable = false)
    public String getInvite_main() {
        return invite_main;
    }

    public void setInvite_main(String invite_main) {
        this.invite_main = invite_main;
    }
}
