package com.young.services.team.impl;

import com.young.entity.Task;
import com.young.entity.User;
import com.young.entity.UserAndTask;
import com.young.services.common.impl.CommServiceImpl;
import com.young.services.team.ITeamService;
import com.young.vo.TaskQueryVo;
import com.young.vo.TaskVo;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

@Service(value = "teamService")
public class TeamServiceImpl extends CommServiceImpl implements ITeamService{

    @Override
    public int add_task(String task_title,String task_detail,String date ,int team_id) {
        try {
            String []s = date.split("-");
            Task task = new Task();
            task.setTaskTitle(task_title);
            task.setTaskDetail(task_detail);
            task.setTaskDeadYear(Integer.parseInt(s[0]));
            task.setTaskDeadMonth(Integer.parseInt(s[1]));
            task.setTaskDeadDay(Integer.parseInt(s[2]));
            task.settId(team_id);
            task.setTaskCreatTime(new Timestamp(System.currentTimeMillis()));
            baseDAO.save(task);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public ArrayList<TaskVo> get_task(int t_id) {
        try {
           ArrayList<Task> tasks = (ArrayList<Task>) baseDAO.findByProperty("tId",t_id,Task.class);
           ArrayList<TaskVo> results = new ArrayList<>();
            for (Task task: tasks
                 ) {
                TaskVo tv = new TaskVo();
                tv.setTask_id(task.getTaskId());
                tv.setTask_name(task.getTaskTitle());
                String m_str = String.format("%02d", task.getTaskDeadMonth());
                String d_str = String.format("%02d", task.getTaskDeadDay());
                tv.setTask_date_String(task.getTaskDeadYear()+"-"+m_str+"-"+d_str);
                results.add(tv);
            }
            return results;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<TaskVo> get_task_for_member(int t_id, int u_id) {
        try {
            ArrayList<TaskVo> results = get_task(t_id);
            for (TaskVo tv:results
                 ) {
                int num = baseDAO.countBySQL("" +
                        "select * from UserAndTask where u_id = ? and task_id = ?",new Object[]{u_id, tv.getTask_id()});
                if (num<=0) tv.setState(-1);
                else tv.setState(1);
            }
            return results;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<UserAndTask> get_all_pics(int task_id, int u_id) {
        try {
            HashMap <String , Object> hp = new HashMap<String , Object>();
            hp.put("taskId",task_id);
            hp.put("uId",u_id);
            ArrayList<UserAndTask> results = (ArrayList<UserAndTask>)baseDAO.findByProperties(hp,UserAndTask.class);
            return results;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Task get_task_by_id(int task_id) {
        try {
            Task task = baseDAO.findById(task_id,Task.class);
            return task;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int save_task_query(int task_id, int u_id, String detail, String pic_url) {
        UserAndTask userAndTask = new UserAndTask();
        userAndTask.setTaskId(task_id);
        userAndTask.setuId(u_id);
        userAndTask.setUtCreatTime(new Timestamp(System.currentTimeMillis()));
        userAndTask.setUtDetail(detail);
        userAndTask.setUtPicUrl(pic_url);
        baseDAO.save(userAndTask);
        return 0;
    }

    @Override
    public ArrayList<TaskVo> get_task_plus(int t_id) {
        ArrayList<TaskVo> results = get_task(t_id);

        for (TaskVo tv: results
             ) {
            ArrayList<UserAndTask> querys = (ArrayList<UserAndTask>)baseDAO.findByProperty("taskId",tv.getTask_id(),UserAndTask.class);
            ArrayList<TaskQueryVo> taskQueryVos = new ArrayList<>();

            for (UserAndTask u :querys
                    ) {
                TaskQueryVo taskQueryVo = new TaskQueryVo();
                taskQueryVo.setUserAndTask(u);
                User user = baseDAO.findById(u.getuId(),User.class);
                taskQueryVo.setUser(user);
                taskQueryVos.add(taskQueryVo);
            }

            tv.setQuerys(taskQueryVos);
        }
        return results;
    }
}
