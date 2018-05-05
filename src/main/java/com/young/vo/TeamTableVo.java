package com.young.vo;

public class TeamTableVo {
    private Integer tId;
    private Integer tuId ;
    private Integer uId;
    private Integer uId_mate;
    private String tTitle;
    private Integer tuState;
    private String  tuStateString;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Integer getuId_mate() {
        return uId_mate;
    }

    public void setuId_mate(Integer uId_mate) {
        this.uId_mate = uId_mate;
    }

    public Integer getTuId() {
        return tuId;
    }

    public void setTuId(Integer tuId) {
        this.tuId = tuId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String gettTitle() {
        return tTitle;
    }

    public void settTitle(String tTitle) {
        this.tTitle = tTitle;
    }

    public Integer getTuState() {
        return tuState;
    }

    public void setTuState(Integer tuState) {
        this.tuState = tuState;
    }

    public String getTuStateString() {
        return tuStateString;
    }

    public void setTuStateString(String tuStateString) {
        this.tuStateString = tuStateString;
    }
}
