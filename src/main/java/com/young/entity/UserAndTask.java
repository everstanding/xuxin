package com.young.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class UserAndTask {
    private int utId;
    private Integer uId;
    private Integer taskId;
    private String utPicUrl;
    private String utDetail;
    private Timestamp utCreatTime;

    @Id
    @Column(name = "ut_id", nullable = false)
    public int getUtId() {
        return utId;
    }

    public void setUtId(int utId) {
        this.utId = utId;
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
    @Column(name = "task_id", nullable = true)
    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    @Basic
    @Column(name = "ut_pic_url", nullable = true, length = 255)
    public String getUtPicUrl() {
        return utPicUrl;
    }

    public void setUtPicUrl(String utPicUrl) {
        this.utPicUrl = utPicUrl;
    }

    @Basic
    @Column(name = "ut_detail", nullable = true, length = 255)
    public String getUtDetail() {
        return utDetail;
    }

    public void setUtDetail(String utDetail) {
        this.utDetail = utDetail;
    }

    @Basic
    @Column(name = "ut_creat_time", nullable = true)
    public Timestamp getUtCreatTime() {
        return utCreatTime;
    }

    public void setUtCreatTime(Timestamp utCreatTime) {
        this.utCreatTime = utCreatTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAndTask that = (UserAndTask) o;

        if (utId != that.utId) return false;
        if (uId != null ? !uId.equals(that.uId) : that.uId != null) return false;
        if (taskId != null ? !taskId.equals(that.taskId) : that.taskId != null) return false;
        if (utPicUrl != null ? !utPicUrl.equals(that.utPicUrl) : that.utPicUrl != null) return false;
        if (utDetail != null ? !utDetail.equals(that.utDetail) : that.utDetail != null) return false;
        if (utCreatTime != null ? !utCreatTime.equals(that.utCreatTime) : that.utCreatTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = utId;
        result = 31 * result + (uId != null ? uId.hashCode() : 0);
        result = 31 * result + (taskId != null ? taskId.hashCode() : 0);
        result = 31 * result + (utPicUrl != null ? utPicUrl.hashCode() : 0);
        result = 31 * result + (utDetail != null ? utDetail.hashCode() : 0);
        result = 31 * result + (utCreatTime != null ? utCreatTime.hashCode() : 0);
        return result;
    }
}
