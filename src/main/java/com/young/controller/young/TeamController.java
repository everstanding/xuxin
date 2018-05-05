package com.young.controller.young;


import com.framework.util.FileUtil;
import com.young.controller.base.BaseController;
import com.young.entity.Task;
import com.young.entity.UserAndTask;
import com.young.json.BaseJson;
import com.young.services.team.ITeamService;
import com.young.vo.TaskVo;
import com.young.vo.TeamListVo;
import com.young.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


@Controller
@RequestMapping(value = "/team")
public class TeamController extends BaseController {

    @Resource
    private ITeamService teamService;



    @RequestMapping(value = "/{tid}/teamTaskLeader", method = RequestMethod.GET)
    public ModelAndView teamTaskLeader(
            @PathVariable("tid") int tid
    ) throws Exception {
        ModelAndView modelAndView = getModelAndView();
        ArrayList<TaskVo> tasks= teamService.get_task(tid);
        modelAndView.getModel().put("tid", tid);
        modelAndView.getModel().put("tasks", tasks);
        modelAndView.setViewName("teamTaskLeader");
        return modelAndView;
    }

    @RequestMapping(value = "/{tid}/teamTaskMember", method = RequestMethod.GET)
    public ModelAndView teamTaskMember(
            @PathVariable("tid") int tid
    ) throws Exception {
        ModelAndView modelAndView = getModelAndView();
        UserVo userVo = getUserSession();
        ArrayList<TaskVo> tasks= teamService.get_task_for_member(tid,userVo.getuId());
        modelAndView.getModel().put("tid", tid);
        modelAndView.getModel().put("tasks", tasks);
        modelAndView.setViewName("teamTaskMember");
        return modelAndView;
    }


    @RequestMapping(value = "/{team_id}/{type}/album", method = RequestMethod.GET)
    public ModelAndView album(
            @PathVariable("team_id") int team_id,
            @PathVariable("type") int type
    ) throws Exception {
        ModelAndView modelAndView = getModelAndView();
        UserVo userVo = getUserSession();
        ArrayList<TaskVo> tasks = teamService.get_task_plus(team_id);
        modelAndView.getModel().put("tasks" , tasks);
        modelAndView.getModel().put("tid", team_id);
        if (type==1){
            modelAndView.getModel().put("href", "/team/"+team_id+"/teamTaskLeader");
        }else{
            modelAndView.getModel().put("href", "/team/"+team_id+"/teamTaskMember");
        }
        modelAndView.setViewName("teamView");
        return modelAndView;
    }


    @RequestMapping(value = "/add_task", method = RequestMethod.POST)
    public ModelAndView add_task(
            @RequestParam("task_title") String task_title,
            @RequestParam("task_detail") String task_detail,
            @RequestParam("date") String date,
            @RequestParam("team_id") int team_id
    ) throws Exception {
        task_title = new String(task_title.getBytes("iso8859-1"), "utf-8");
        task_detail = new String(task_detail.getBytes("iso8859-1"), "utf-8");
        ModelAndView modelAndView = new ModelAndView();
        int reCode = teamService.add_task(task_title,task_detail,date,team_id);
        modelAndView.getModel().put("msg", "添加任务成功");
        modelAndView.getModel().put("url", "/team/"+team_id+"/teamTaskLeader");
        modelAndView.setViewName("result");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/get_task", method = RequestMethod.POST)
    public BaseJson get_task(
            @RequestParam("t_id") int t_id
    ) throws Exception {
        BaseJson queryJson = new BaseJson();
        ArrayList<TaskVo> tasks= teamService.get_task(t_id);
        queryJson.setObj(tasks);
        return queryJson;
    }

    @ResponseBody
    @RequestMapping(value = "/user_get_task", method = RequestMethod.POST)
    public BaseJson user_get_task(
            @RequestParam("task_id") int task_id
    ) throws Exception {
        BaseJson queryJson = new BaseJson();
        UserVo userVo = getUserSession();
        ArrayList<UserAndTask> results = teamService.get_all_pics(task_id,userVo.getuId());
        Task task = teamService.get_task_by_id(task_id);
        HashMap hp = new HashMap();
        hp.put("task",task);
        hp.put("querys",results);
        queryJson.setObj(hp);
        return queryJson;
    }


    @ResponseBody
    @RequestMapping(value = "/add_task_query", method = RequestMethod.POST)
    public ModelAndView add_course(
            @RequestParam("pic1") MultipartFile file,
            @RequestParam("ut_detail") String ut_detail,
            @RequestParam("team_id") int team_id,
            @RequestParam("task_id") int task_id
    ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        UserVo userVo = getUserSession();


        String picPath="";
        picPath= FileUtil.up_file(getHttpRequest(),file,"/web/images/pics");
        System.out.println(picPath);
        teamService.save_task_query(task_id,userVo.getuId(),ut_detail,picPath);
        modelAndView.getModel().put("msg", "添加进度成功");
        modelAndView.getModel().put("url", "/team/"+team_id+"/teamTaskMember");
        modelAndView.setViewName("result");
        return modelAndView;
    }



}
