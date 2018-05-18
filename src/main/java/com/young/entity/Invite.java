package com.young.entity;

import javax.persistence.*;

@Entity
public class Invite {
    private Integer invite_id;
    private Integer u_id;
    private Integer t_id;
    private Integer status;

    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
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

    @Override
    public String toString() {
        return "Invite{" +
                "invite_id=" + invite_id +
                ", u_id=" + u_id +
                ", t_id=" + t_id +
                ", status=" + status +
                '}';
    }
}
