package com.young.services.team;

import com.young.entity.Task;
import com.young.entity.UserAndTask;
import com.young.vo.TaskVo;

import java.util.ArrayList;

public interface ITeamService {
    public int add_task(String task_title,String task_detail,String date  ,int team_id);
    public ArrayList<TaskVo> get_task(int t_id);
    public ArrayList<TaskVo> get_task_for_member(int t_id,int u_id);
    public ArrayList<UserAndTask> get_all_pics (int task_id,int u_id);
    public Task get_task_by_id(int task_id);

    public int save_task_query(int task_id,int u_id,String detail,String pic_url);

    public ArrayList<TaskVo> get_task_plus(int t_id);
    /*   @RequestParam("task_title") String lab_cate_id,
            @RequestParam("task_detail") String lab_name,
            @RequestParam("task_dead_year") int lab_phone,
            @RequestParam("task_dead_month") int lab_address*/
}
