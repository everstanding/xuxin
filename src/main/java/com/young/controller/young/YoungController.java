package com.young.controller.young;

import com.framework.util.FileUtil;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.young.controller.base.BaseController;
import com.young.entity.Invite;
import com.young.entity.Post;
import com.young.entity.studyfile;
import com.young.json.BaseJson;
import com.young.services.young.IYoungService;
import com.young.vo.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by young on 2017/9/7.
 */
@Controller
@RequestMapping(value = "/young")
public class YoungController extends BaseController {
    @Resource
    private IYoungService youngService;

    private BaseJson queryJson = new BaseJson();

    private LinkedList<UserVo> users = new LinkedList();


    @RequestMapping(value = "/formlogin", method = RequestMethod.GET)
    public ModelAndView formlogin() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("formlogin");
        return modelAndView;
    }

    @RequestMapping(value = "/formRegister", method = RequestMethod.GET)
    public ModelAndView formRegister() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("formRegister");
        return modelAndView;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView modelAndView = getModelAndView();
        ArrayList<TeamListVo> teams = youngService.get_teams_all();
        ArrayList<UserVo> usersP = youngService.get_hot_user();
        modelAndView.getModel().put("users", usersP);
        modelAndView.getModel().put("usersRec", this.users);
        modelAndView.getModel().put("teams", teams);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/index1", method = RequestMethod.GET)
    public ModelAndView index1() throws Exception {
        ModelAndView modelAndView = getModelAndView1();
        ArrayList<TeamListVo> teams = youngService.get_teams_all();
        modelAndView.getModel().put("teams", teams);
        modelAndView.setViewName("index1");
        return modelAndView;
    }


    @RequestMapping(value = "/learningTeam", method = RequestMethod.GET)
    public ModelAndView learningTeam() throws Exception {
        ModelAndView modelAndView = getModelAndView();
        ArrayList<LaberVo> labers = youngService.get_team_laber();
        modelAndView.getModel().put("labers", labers);
        modelAndView.setViewName("learningTeam");
        return modelAndView;
    }

    @RequestMapping(value = "/projectTeam", method = RequestMethod.GET)
    public ModelAndView projectTeam() throws Exception {
        ModelAndView modelAndView = getModelAndView();
        ArrayList<LaberVo> labers = youngService.get_project_laber();
        modelAndView.getModel().put("labers", labers);
        modelAndView.setViewName("projectTeam");
        return modelAndView;
    }

    @RequestMapping(value = "/articalShare", method = RequestMethod.GET)
    public ModelAndView articalShare() throws Exception {
        ModelAndView modelAndView = getModelAndView();
        ArrayList<StudyVo> studies = youngService.get_study_all();
        modelAndView.getModel().put("studies", studies);
        modelAndView.setViewName("articalShare");
        return modelAndView;
    }

    @RequestMapping(value = "/share2", method = RequestMethod.GET)
    public ModelAndView share2() throws Exception {
        ModelAndView modelAndView = getModelAndView1();
        ArrayList<StudyVo> studies = youngService.get_study_all();
        modelAndView.getModel().put("studies", studies);
        modelAndView.setViewName("share2");
        return modelAndView;
    }


    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public ModelAndView question() throws Exception {
        ModelAndView modelAndView = getModelAndView();
        modelAndView.setViewName("question");
        return modelAndView;
    }


    @RequestMapping(value = "/{uid}/userDetail", method = RequestMethod.GET)
    public ModelAndView userDetail(
            @PathVariable("uid") int uid
    ) throws Exception {
        ModelAndView modelAndView = getModelAndView();
        UserDetailVo udv = youngService.getUserInfoByUserId(uid);


        PowerVo pv = youngService.get_power_by_uid(uid);
        if (pv.getuStudyPower() == 1) {
            ArrayList<StudyVo> studys = youngService.get_study_by_uid(uid);

            modelAndView.getModel().put("studys", studys);
        }
        if (pv.getuTeamPower() == 1) {
            ArrayList<TeamTableVo> team_create_list = youngService.get_team_create(uid);
            ArrayList<TeamTableVo> team_join_list = youngService.get_team_join(uid);

            modelAndView.getModel().put("team_create_list", team_create_list);
            modelAndView.getModel().put("team_join_list", team_join_list);
        }
        modelAndView.getModel().put("user", udv);
        modelAndView.getModel().put("power", pv);
        modelAndView.setViewName("userDetail");
        return modelAndView;
    }

    @RequestMapping(value = "/{tid}/teamDetail", method = RequestMethod.GET)
    public ModelAndView teamDetail(
            @PathVariable("tid") int tid
    ) throws Exception {
        ModelAndView modelAndView = getModelAndView();
        TeamListVo teamListVo = youngService.get_team_info_by_id(tid);
        modelAndView.getModel().put("team", teamListVo);
        modelAndView.setViewName("teamDetail");
        youngService.team_num_update(1, tid);
        return modelAndView;
    }


    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public ModelAndView userInfo() throws Exception {
        ModelAndView modelAndView = getModelAndView();
        UserVo userVo = getUserSession();
        UserDetailVo udv = youngService.getUserInfoByUserId(userVo.getuId());
        modelAndView.getModel().put("user", udv);
        modelAndView.setViewName("userInfo");
        return modelAndView;
    }

    @RequestMapping(value = "/teacherInfo", method = RequestMethod.GET)
    public ModelAndView teacherInfo() throws Exception {
        ModelAndView modelAndView = getModelAndView();
        TeacherVo teacherVo = getTeacherSession();
     //   UserDetailVo udv = youngService.getUserInfoByUserId(teacherVo.gettId());
       // modelAndView.getModel().put("teacher", udv);
        modelAndView.setViewName("teacherInfo");
        return modelAndView;
    }

    @RequestMapping(value = "/userMyArt", method = RequestMethod.GET)
    public ModelAndView userMyArt() throws Exception {
        ModelAndView modelAndView = getModelAndView();
        UserVo userVo = getUserSession();
        ArrayList<StudyVo> studys = youngService.get_study_by_uid(userVo.getuId());
        modelAndView.getModel().put("studys", studys);
        modelAndView.setViewName("userMyArt");
        return modelAndView;
    }

    @RequestMapping(value = "/userMyTeam", method = RequestMethod.GET)
    public ModelAndView userMyTeam() throws Exception {
        ModelAndView modelAndView = getModelAndView();
        UserVo userVo = getUserSession();
        ArrayList<TeamTableVo> reList = youngService.get_team_join(userVo.getuId());
        modelAndView.getModel().put("table", reList);
        modelAndView.setViewName("userMyTeam");
        return modelAndView;
    }

    @RequestMapping(value = "/userMyTeamCreate", method = RequestMethod.GET)
    public ModelAndView userMyTeamCreate() throws Exception {
        ModelAndView modelAndView = getModelAndView();
        UserVo userVo = getUserSession();
        ArrayList<TeamTableVo> reList = youngService.get_team_create(userVo.getuId());
        modelAndView.getModel().put("table", reList);
        modelAndView.setViewName("userCreateTeam");
        return modelAndView;
    }

    @RequestMapping(value = "/userNewArt", method = RequestMethod.GET)
    public ModelAndView userNewArt() throws Exception {
        ModelAndView modelAndView = getModelAndView();

        modelAndView.setViewName("userNewArt");
        return modelAndView;
    }


    @RequestMapping(value = "/userNewTeam/project", method = RequestMethod.GET)
    public ModelAndView userNewTeam_project() throws Exception {
        ModelAndView modelAndView = getModelAndView();
        ArrayList<LaberVo> labers = youngService.get_project_laber();
        modelAndView.getModel().put("labers", labers);
        modelAndView.getModel().put("type", 2);
        modelAndView.getModel().put("page", "new-team-project");
        modelAndView.setViewName("userNewTeam");
        return modelAndView;
    }

    @RequestMapping(value = "/userNewTeam/study", method = RequestMethod.GET)
    public ModelAndView userNewTeam_study() throws Exception {
        ModelAndView modelAndView = getModelAndView();
        ArrayList<LaberVo> labers = youngService.get_team_laber();
        modelAndView.getModel().put("labers", labers);
        modelAndView.getModel().put("type", 1);
        modelAndView.getModel().put("page", "new-team-learning");
        modelAndView.setViewName("userNewTeam");
        return modelAndView;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(
            @RequestParam(value = "school_num", defaultValue = "123") String school_num,
            @RequestParam(value = "pw", defaultValue = "!!!") String pw,
            @RequestParam(value = "user", defaultValue = "!!!") String user
    ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
            if(user.equals("student")) {
                UserVo uv = youngService.login(school_num, pw);
                if (uv == null) {
                    modelAndView.getModel().put("msg", "账号或者密码不正确");
                    modelAndView.getModel().put("url", "/young/formlogin");
                    System.out.println(2);
                    modelAndView.setViewName("result");
                } else {
                    setUserSession(uv);
                    if (users.size() < 5) {
                        for (UserVo u : users
                                ) {
                            if (u.getuId() == uv.getuId()) {
                                users.remove(u);
                                break;
                            }
                        }
                        users.addFirst(uv);
                    } else {
                        for (UserVo u : users
                                ) {
                            if (u.getuId() == uv.getuId()) {
                                users.remove(u);
                                break;
                            } else {
                                users.removeLast();
                            }
                        }
                        users.addFirst(uv);
                    }
                    System.out.println(1);
                    modelAndView.setViewName("redirect:/young/index");
                }
            }
            else if(user.equals("teacher")){
                TeacherVo tv = youngService.login2(school_num, pw);
                if (tv == null) {
                    modelAndView.getModel().put("msg", "账号或者密码不正确");
                    modelAndView.getModel().put("url", "/young/formlogin");
                    System.out.println(2);
                    modelAndView.setViewName("result");
                } else {
                    setTeacherSession(tv);
                    modelAndView.setViewName("redirect:/young/index1" );
                }

            }
            else if(user.equals("administration")){
                ArrayList<UserVo> users = youngService.get_allstudent();
                modelAndView.getModel().put("users", users);
                ArrayList<TeacherVo> teachers = youngService.get_allteacher();
                modelAndView.getModel().put("teachers", teachers);
                modelAndView.setViewName("index2");
            }
            else{
                modelAndView.getModel().put("msg", "请选择登录用户类型");
                modelAndView.getModel().put("url", "/young/formlogin");
                System.out.println(2);
                modelAndView.setViewName("result");
            }
        return modelAndView;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        setUserSession(null);
        modelAndView.setViewName("redirect:/young/formlogin");
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(
            @RequestParam(value = "uName", defaultValue = "空") String uName,
            @RequestParam(value = "uGender", defaultValue = "男") String uGender,
            @RequestParam(value = "uSchoolNum", defaultValue = "0") String uSchoolNum,
            @RequestParam(value = "uQq", defaultValue = "0") String uQq,
            @RequestParam(value = "uWx", defaultValue = "无") String uWx,
            @RequestParam(value = "uPhone", defaultValue = "10086") String uPhone,
            @RequestParam(value = "Pw", defaultValue = "123456") String Pw
    ) throws Exception {
        uName = new String(uName.getBytes("iso8859-1"), "utf-8");
        uGender = new String(uGender.getBytes("iso8859-1"), "utf-8");
        uSchoolNum = new String(uSchoolNum.getBytes("iso8859-1"), "utf-8");
        uQq = new String(uQq.getBytes("iso8859-1"), "utf-8");
        uWx = new String(uWx.getBytes("iso8859-1"), "utf-8");
        uPhone = new String(uPhone.getBytes("iso8859-1"), "utf-8");
        Pw = new String(Pw.getBytes("iso8859-1"), "utf-8");
        ModelAndView modelAndView = new ModelAndView();
        int recode = youngService.register(uName, uGender, uSchoolNum, uQq, uWx, uPhone, Pw);
        System.out.println(recode);
        if (recode == -1) {
            modelAndView.getModel().put("msg", "此学号已被注册");
            modelAndView.getModel().put("url", "/young/formRegister");
            modelAndView.setViewName("result");
        } else {
            modelAndView.getModel().put("msg", "注册成功");
            modelAndView.getModel().put("url", "/young/formlogin");
            modelAndView.setViewName("result");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/change_user_info", method = RequestMethod.POST)
    public ModelAndView change_user_info(
            @RequestParam(value = "uName", defaultValue = "空") String uName,
            @RequestParam(value = "uGender", defaultValue = "男") String uGender,
            @RequestParam(value = "uSchoolNum", defaultValue = "0") String uSchoolNum,
            @RequestParam(value = "uQq", defaultValue = "0") String uQq,
            @RequestParam(value = "uWx", defaultValue = "无") String uWx,
            @RequestParam(value = "uPhone", defaultValue = "10086") String uPhone

    ) throws Exception {
        uName = new String(uName.getBytes("iso8859-1"), "utf-8");
        uGender = new String(uGender.getBytes("iso8859-1"), "utf-8");
        uSchoolNum = new String(uSchoolNum.getBytes("iso8859-1"), "utf-8");
        uQq = new String(uQq.getBytes("iso8859-1"), "utf-8");
        uWx = new String(uWx.getBytes("iso8859-1"), "utf-8");
        uPhone = new String(uPhone.getBytes("iso8859-1"), "utf-8");
        ModelAndView modelAndView = new ModelAndView();
        UserVo userVo = getUserSession();
        int recode = youngService.change_info(userVo.getuId(), uName, uGender, uSchoolNum, uQq, uWx, uPhone);
        System.out.println(recode);
        if (recode == 1) {
            modelAndView.getModel().put("msg", "修改个人信息成功");
            modelAndView.getModel().put("url", "/young/logout");
            modelAndView.setViewName("result");
        } else {
            modelAndView.getModel().put("msg", "修改个人信息失败");
            modelAndView.getModel().put("url", "/young/userInfo");
            modelAndView.setViewName("result");
        }
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping(value = "/get_team_list", method = RequestMethod.POST)
    public BaseJson get_team_list(
            @RequestParam(value = "grade", defaultValue = "0") int grade,
            @RequestParam(value = "scale", defaultValue = "0") int scale,
            @RequestParam(value = "need", defaultValue = "0") String need,
            @RequestParam(value = "support", defaultValue = "0") String support,
            @RequestParam(value = "type", defaultValue = "1") int type
    ) throws Exception {
        queryJson = new BaseJson();
        ArrayList<TeamListVo> tlvs = youngService.get_teams_by_p(grade, scale, need, support, type);
        queryJson.setObj(tlvs);
        return queryJson;
    }

    @RequestMapping(value = "/up_study", method = RequestMethod.POST)
    public ModelAndView up_study(
            @RequestParam(value = "sTitle", defaultValue = "无") String sTitle,
            @RequestParam(value = "sIntro", defaultValue = "无") String sIntro,
            @RequestParam(value = "sUrl", defaultValue = "http://www.baidu.com") String sUrl
    ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        sTitle = new String(sTitle.getBytes("iso8859-1"), "utf-8");
        sIntro = new String(sIntro.getBytes("iso8859-1"), "utf-8");
        sUrl = new String(sUrl.getBytes("iso8859-1"), "utf-8");
        UserVo userVo = getUserSession();
        int recode = youngService.up_study(sTitle, sIntro, sUrl, userVo.getuId());
        System.out.println(recode);
        if (recode == -1) {
            modelAndView.getModel().put("msg", "添加文章失败");
            modelAndView.getModel().put("url", "/young/userNewArt");
            modelAndView.setViewName("result");
        } else {
            modelAndView.getModel().put("msg", "添加文章成功");
            modelAndView.getModel().put("url", "/young/userNewArt");
            modelAndView.setViewName("result");
        }
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/new_team", method = RequestMethod.POST)
    public BaseJson new_team(
            @RequestParam(value = "tTile", defaultValue = "无标题") String tTile,
            @RequestParam(value = "grade", defaultValue = "1") int grade,
            @RequestParam(value = "scale", defaultValue = "1") int scale,
            @RequestParam(value = "need", defaultValue = "1") String need,
            @RequestParam(value = "support", defaultValue = "1") String support,
            @RequestParam(value = "tIntro", defaultValue = "0") String tIntro,
            @RequestParam(value = "type", defaultValue = "1") int type
    ) throws Exception {
        queryJson = new BaseJson();
        UserVo userVo = getUserSession();
        int recode = youngService.new_team(tTile, grade, scale, need, support, tIntro, type, userVo.getuId());
        if (recode == 1) {
            queryJson.setErrmsg("添加组队成功");
        } else {
            queryJson.setErrmsg("添加组队失败");
        }
        return queryJson;
    }


    @RequestMapping(value = "/add_team", method = RequestMethod.POST)
    public ModelAndView add_team(
            @RequestParam(value = "t_id") int t_id,
            @RequestParam(value = "location") String location
    ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("result");
        UserVo userVo = getUserSession();
        int reCode = youngService.add_team(t_id, userVo.getuId());
        System.out.println(reCode);
        if (reCode == -1) {
            modelAndView.getModel().put("msg", "已经参加过这个队伍");
        } else if (reCode == -2) {
            modelAndView.getModel().put("msg", "这个队伍满员了");
        } else if (reCode == 1) {
            modelAndView.getModel().put("msg", "成功参加");

        } else if (reCode == -3) {
            modelAndView.getModel().put("msg", "不能参加自己创建的小队");
        } else {
            modelAndView.getModel().put("msg", "成功失败");
        }
        modelAndView.getModel().put("url", location);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/get_mates", method = RequestMethod.POST)
    public BaseJson get_mates(
            @RequestParam(value = "t_id") int t_id
    ) throws Exception {
        queryJson = new BaseJson();
        ArrayList<UserVo> tlvs = youngService.get_mates_by_t_id(t_id);
        queryJson.setObj(tlvs);
        return queryJson;
    }

    @ResponseBody
    @RequestMapping(value = "/study_watch_update", method = RequestMethod.POST)
    public BaseJson study_watch_update(
            @RequestParam(value = "s_id") int s_id
    ) throws Exception {
        queryJson = new BaseJson();
        youngService.study_num_update(1, s_id);
        return queryJson;
    }


    @RequestMapping(value = "/del_art/{s_id}", method = RequestMethod.GET)
    public ModelAndView del_art(
            @PathVariable("s_id") int s_id
    ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        UserVo userVo = getUserSession();
        int recode = youngService.del_study(userVo.getuId(), s_id);
        if (recode == -1) {
            modelAndView.getModel().put("msg", "删除经验分享失败");
            modelAndView.getModel().put("url", "/young/userMyArt");
            modelAndView.setViewName("result");
        } else {
            modelAndView.getModel().put("msg", "删除经验分享成功");
            modelAndView.getModel().put("url", "/young/userMyArt");
            modelAndView.setViewName("result");
        }
        return modelAndView;
    }





    @RequestMapping(value = "/files", method = RequestMethod.GET)
    public ModelAndView files(
    ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        TeacherVo teacherVo = getTeacherSession();
        List<studyfile> studyfiles = youngService.getfile(teacherVo.gettId());
        modelAndView.getModel().put("studyfiles",studyfiles);
        modelAndView.setViewName("study");
        System.out.println("11111");
        return modelAndView;
    }


    @RequestMapping(value = "/p/{page}/post", method = RequestMethod.GET)
    public ModelAndView posts_by_page(
            @PathVariable("page") int page
    ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        UserVo userVo = getUserSession();
        ArrayList<PostVo> posts = youngService.get_post_by_page(page);
        for (PostVo pv:posts
             ) {
            System.out.println(pv.getpTitle());
        }
        modelAndView.getModel().put("post",posts);
        modelAndView.setViewName("chat");
        return modelAndView;
    }

    @RequestMapping(value = "/add_post", method = RequestMethod.POST)
    public ModelAndView add_post(
            @RequestParam("title") String title,
            @RequestParam("main") String main
    ) throws Exception {
        ModelAndView modelAndView = getModelAndView();
        title=new String(title.getBytes("iso8859-1"),"utf-8");
        main=new String(main.getBytes("iso8859-1"),"utf-8");
        UserVo userVo = getUserSession();
        youngService.add_post(userVo.getuId(),title,main);
        modelAndView.getModel().put("msg", "发帖成功");
        modelAndView.getModel().put("url", "/young/p/1/post");
        modelAndView.setViewName("result");
        return modelAndView;
    }


    @RequestMapping(value = "/{p_id}/post", method = RequestMethod.GET)
    public ModelAndView post_by_id(
            @PathVariable("p_id") int p_id
    ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        UserVo userVo = getUserSession();
        Post post = youngService.get_post_by_id(p_id);
        modelAndView.getModel().put("post",post);
        modelAndView.setViewName("question");
        return modelAndView;
    }





    @RequestMapping(value = "/{p_id}/add_floor", method = RequestMethod.GET)
    public ModelAndView add_floor(
            @PathVariable("p_id") int p_id
    ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        UserVo userVo = getUserSession();

        return modelAndView;
    }

    @RequestMapping(value = "/inviteTeacher", method = RequestMethod.GET)
    public ModelAndView inviteTeacher() throws Exception {
        ModelAndView modelAndView = getModelAndView();
        ArrayList<TeacherVo> teacherVos = youngService.get_allteacher();
        modelAndView.getModel().put("teacherVos",teacherVos);
        UserVo userVo = getUserSession();
        ArrayList<InviteVo> invites = youngService.get_invite_of_student(userVo.getuId());
        modelAndView.getModel().put("invites",invites);
        modelAndView.setViewName("inviteTeacher");
        return modelAndView;
    }

    @RequestMapping(value = "/{tId}/teacher", method = RequestMethod.GET)
    public ModelAndView teacher(
            @PathVariable("tId")    int tId
    ) throws Exception {
        ModelAndView modelAndView = getModelAndView();
        TeacherDetailVo teacherDetailVo = youngService.get_teacher(tId);
        System.out.println(teacherDetailVo.toString());
        modelAndView.getModel().put("teacherDetailVo", teacherDetailVo);
        List<studyfile> studyfiles = youngService.get_file_of_teacher(tId);
        modelAndView.getModel().put("studyfiles",studyfiles);
        modelAndView.setViewName("teacher");
        return modelAndView;
    }


    @RequestMapping(value = "/teacher/invite/{tId}", method = RequestMethod.GET)
    public ModelAndView invite(
            @PathVariable("tId")int tId
    ) throws Exception {
        ModelAndView modelAndView = getModelAndView();
        UserVo userVo = getUserSession();
        System.out.println(userVo.toString());
        youngService.add_invite(tId,userVo.getuId());
        modelAndView.getModel().put("msg", "邀请成功");
        modelAndView.getModel().put("url", "/young/inviteTeacher");
        modelAndView.setViewName("result");
        return modelAndView;
    }

}