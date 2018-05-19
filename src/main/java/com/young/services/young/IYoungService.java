package com.young.services.young;

import com.young.entity.*;
import com.young.vo.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by young on 2017/9/7.
 */
public interface IYoungService {
    public UserVo login (String school_num , String pw);
    public TeacherVo login2 (String school_num , String pw);
    public UserDetailVo getUserInfoByUserId(int user_id);
    public int change_info(int user_id,String uName,String uGender,String uSchoolNum, String uQq,String uWx,String uPhone);
    public ArrayList<TeamTableVo>get_team_join(int user_id);
    public ArrayList<TeamTableVo>get_team_create(int user_id);
    public ArrayList<StudyVo>get_study_by_uid(int uid);
    public PowerVo get_power_by_uid(int uid);
    public ArrayList<LaberVo> get_team_laber();
    public ArrayList<LaberVo> get_project_laber();
    public ArrayList<TeamListVo>get_teams_by_p(int grade,int scale,String need,String support,int type);
    public ArrayList<StudyVo>get_study_all();
    public ArrayList<TeamListVo>get_teams_all();
    public ArrayList<UserVo>get_hot_user();
    public int register(String uName,String uGender,String uSchoolNum, String uQq,String uWx,String uPhone,String pw);
    public int up_study(String sTitle,String sIntro,String sUrl,int u_id);
    public int new_team(String title,int grade,int scale,String need,String support,String intro,int type,int u_id);
    public TeamListVo get_team_info_by_id(int t_id);
    public int add_team(int t_id, int u_id);
    public ArrayList<UserVo>get_mates_by_t_id(int t_id);
    public void team_num_update(int type,int t_id);
    public void study_num_update(int type,int s_id);
    public int del_study(int u_id,int s_id);
    public int upfile(int t_id,String f_name,String f_url);

    public List<studyfile> getfile(int t_id);

    public ArrayList<PostVo> get_post_by_page(int page);
    public Post get_post_by_id(int id);
    public ArrayList<FloorVo> get_floors_by_page(int p_id);
    public ArrayList<TeacherVo> get_allteacher();
    public ArrayList<UserVo> get_allstudent();
    public int add_post(int u_id , String title , String main);

    public TeacherDetailVo get_teacher(int t_id);
    public List<studyfile> get_file_of_teacher(int t_id);
    public int add_invite(int t_id,int u_id);
    public ArrayList<InviteVo> get_invite_of_student(int u_id);
    public ArrayList<InviteVo> get_invite_of_teacher(int t_id);
    public int change_status(int invite_id);
}
