package com.young.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Laber {
    private Integer lId;
    private String lName;
    private Integer lType;

    @Id
    @Column(name = "L_id", nullable = false)
    public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
    }

    @Basic
    @Column(name = "L_name", nullable = true, length = 255)
    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Basic
    @Column(name = "L_type", nullable = true)
    public Integer getlType() {
        return lType;
    }

    public void setlType(Integer lType) {
        this.lType = lType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Laber laber = (Laber) o;

        if (lId != laber.lId) return false;
        if (lName != null ? !lName.equals(laber.lName) : laber.lName != null) return false;
        if (lType != null ? !lType.equals(laber.lType) : laber.lType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lId;
        result = 31 * result + (lName != null ? lName.hashCode() : 0);
        result = 31 * result + (lType != null ? lType.hashCode() : 0);
        return result;
    }
}
