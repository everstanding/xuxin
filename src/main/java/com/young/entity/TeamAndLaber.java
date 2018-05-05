package com.young.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeamAndLaber {
    private int talId;
    private Integer tId;
    private Integer lId;
    private Integer talType;

    @Id
    @Column(name = "tal_id", nullable = false)
    public int getTalId() {
        return talId;
    }

    public void setTalId(int talId) {
        this.talId = talId;
    }

    @Basic
    @Column(name = "t_id", nullable = true)
    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    @Basic
    @Column(name = "L_id", nullable = true)
    public Integer getlId() {
        return lId;
    }

    public void setlId(Integer lId) {
        this.lId = lId;
    }

    @Basic
    @Column(name = "tal_type", nullable = true)
    public Integer getTalType() {
        return talType;
    }

    public void setTalType(Integer talType) {
        this.talType = talType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamAndLaber that = (TeamAndLaber) o;

        if (talId != that.talId) return false;
        if (tId != null ? !tId.equals(that.tId) : that.tId != null) return false;
        if (lId != null ? !lId.equals(that.lId) : that.lId != null) return false;
        if (talType != null ? !talType.equals(that.talType) : that.talType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = talId;
        result = 31 * result + (tId != null ? tId.hashCode() : 0);
        result = 31 * result + (lId != null ? lId.hashCode() : 0);
        result = 31 * result + (talType != null ? talType.hashCode() : 0);
        return result;
    }
}
