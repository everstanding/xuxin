package com.young.vo;

import com.young.entity.UserAndTask;

import java.util.ArrayList;

public class TaskVo {
    private int task_id;
    private String task_name;
    private String task_date_String;
    private int state;
    private ArrayList<TaskQueryVo> querys = new ArrayList<>();
    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_date_String() {
        return task_date_String;
    }

    public void setTask_date_String(String task_date_String) {
        this.task_date_String = task_date_String;
    }

    public int getState() {

        return state;
    }

    public ArrayList<TaskQueryVo> getQuerys() {
        return querys;
    }

    public void setQuerys(ArrayList<TaskQueryVo> querys) {
        this.querys = querys;
    }

    public void setState(int state) {
        this.state = state;
    }
}
