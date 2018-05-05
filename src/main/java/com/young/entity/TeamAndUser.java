package com.young.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeamAndUser {
    private int tuId;
    private Integer uId;
    private Integer tId;

    @Id
    @Column(name = "tu_id", nullable = false)
    public int getTuId() {
        return tuId;
    }

    public void setTuId(int tuId) {
        this.tuId = tuId;
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
    @Column(name = "t_id", nullable = true)
    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamAndUser that = (TeamAndUser) o;

        if (tuId != that.tuId) return false;
        if (uId != null ? !uId.equals(that.uId) : that.uId != null) return false;
        return tId != null ? tId.equals(that.tId) : that.tId == null;
    }

    @Override
    public int hashCode() {
        int result = tuId;
        result = 31 * result + (uId != null ? uId.hashCode() : 0);
        result = 31 * result + (tId != null ? tId.hashCode() : 0);
        return result;
    }
}
