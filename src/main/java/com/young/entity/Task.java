package com.young.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Task {
    private int taskId;
    private String taskTitle;
    private String taskDetail;
    private Timestamp taskCreatTime;
    private Integer taskDeadYear;
    private Integer taskDeadMonth;
    private Integer tId;
    private Integer taskDeadDay;

    @Id
    @Column(name = "task_id", nullable = false)
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Basic
    @Column(name = "task_title", nullable = true, length = 255)
    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    @Basic
    @Column(name = "task_detail", nullable = true, length = -1)
    public String getTaskDetail() {
        return taskDetail;
    }

    public void setTaskDetail(String taskDetail) {
        this.taskDetail = taskDetail;
    }

    @Basic
    @Column(name = "task_creat_time", nullable = true)
    public Timestamp getTaskCreatTime() {
        return taskCreatTime;
    }

    public void setTaskCreatTime(Timestamp taskCreatTime) {
        this.taskCreatTime = taskCreatTime;
    }

    @Basic
    @Column(name = "task_dead_year", nullable = true)
    public Integer getTaskDeadYear() {
        return taskDeadYear;
    }

    public void setTaskDeadYear(Integer taskDeadYear) {
        this.taskDeadYear = taskDeadYear;
    }

    @Basic
    @Column(name = "task_dead_month", nullable = true)
    public Integer getTaskDeadMonth() {
        return taskDeadMonth;
    }

    public void setTaskDeadMonth(Integer taskDeadMonth) {
        this.taskDeadMonth = taskDeadMonth;
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

        Task task = (Task) o;

        if (taskId != task.taskId) return false;
        if (taskTitle != null ? !taskTitle.equals(task.taskTitle) : task.taskTitle != null) return false;
        if (taskDetail != null ? !taskDetail.equals(task.taskDetail) : task.taskDetail != null) return false;
        if (taskCreatTime != null ? !taskCreatTime.equals(task.taskCreatTime) : task.taskCreatTime != null)
            return false;
        if (taskDeadYear != null ? !taskDeadYear.equals(task.taskDeadYear) : task.taskDeadYear != null) return false;
        if (taskDeadMonth != null ? !taskDeadMonth.equals(task.taskDeadMonth) : task.taskDeadMonth != null)
            return false;
        if (tId != null ? !tId.equals(task.tId) : task.tId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taskId;
        result = 31 * result + (taskTitle != null ? taskTitle.hashCode() : 0);
        result = 31 * result + (taskDetail != null ? taskDetail.hashCode() : 0);
        result = 31 * result + (taskCreatTime != null ? taskCreatTime.hashCode() : 0);
        result = 31 * result + (taskDeadYear != null ? taskDeadYear.hashCode() : 0);
        result = 31 * result + (taskDeadMonth != null ? taskDeadMonth.hashCode() : 0);
        result = 31 * result + (tId != null ? tId.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "task_dead_day", nullable = true)
    public Integer getTaskDeadDay() {
        return taskDeadDay;
    }

    public void setTaskDeadDay(Integer taskDeadDay) {
        this.taskDeadDay = taskDeadDay;
    }
}
