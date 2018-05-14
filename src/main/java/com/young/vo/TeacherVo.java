package com.young.vo;

public class TeacherVo {
    private Integer tId;
    private String tName;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    @Override
    public String toString() {
        return "TeacherVo{" +
                "tId=" + tId +
                ", tName='" + tName + '\'' +
                '}';
    }
}
