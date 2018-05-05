package com.young.services.young.impl;

import com.framework.util.DateUtil;
import com.young.entity.*;
import com.young.services.common.impl.CommServiceImpl;
import com.young.services.young.IYoungService;
import com.young.vo.*;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by young on 2017/9/7.
 */
@Service(value = "youngService")
public class YoungServiceImpl extends CommServiceImpl implements IYoungService {
    private Random random = new Random();

    @Override
    public UserVo login(String school_num, String pw) {
        try {
            ArrayList<UserVo>reList = ( ArrayList<UserVo>) baseDAO.findBySQLForVO("" +
                    "select u_id as uId ,u_name as uName , u_header_url as uHeaderUrl from User where u_school_num = ? and u_pw = ? ", UserVo.class , new Object[]{school_num,pw});
            if (reList==null||reList.size()<=0){
                return null;
            }
            else {
                return reList.get(0);
            }
        } catch (Exception e) {
            return null;
        }
    }

    public TeacherVo login2 (String school_num , String pw){
        try {
            ArrayList<TeacherVo>reList = ( ArrayList<TeacherVo>) baseDAO.findBySQLForVO("" +
                    "select t_id as tId ,t_name as tName from Teacher where t_school_num = ? and t_pw = ? ", TeacherVo.class , new Object[]{school_num,pw});
            if (reList==null||reList.size()<=0){
                return null;
            }
            else {
                return reList.get(0);
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UserDetailVo getUserInfoByUserId(int user_id) {
        try {
            User user = baseDAO.findById(user_id,User.class);
            if (user==null)return null;
            else{
                UserDetailVo udv = new UserDetailVo();
                udv.setuGender(user.getuGender());
                udv.setuHeaderUrl(user.getuHeaderUrl());
                udv.setuName(user.getuName());
                udv.setuPhone(user.getuPhone());
                udv.setuQq(user.getuQq());
                udv.setuWx(user.getuWx());
                udv.setuSchoolNum(user.getuSchoolNum());
                return udv;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int change_info(int user_id, String uName, String uGender, String uSchoolNum, String uQq, String uWx, String uPhone) {
        try {
            User user = baseDAO.findById(user_id,User.class);
            user.setuName(uName);
            user.setuGender(uGender);
            user.setuPhone(uPhone);
            user.setuQq(uQq);
            user.setuWx(uWx);
            user.setuSchoolNum(uSchoolNum);
            baseDAO.update(user);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public ArrayList<TeamTableVo> get_team_join(int user_id) {
        try {
            String sql="select Team.t_id as tId , TeamAndUser.tu_id as tuId , Team.t_state as tuState , TeamAndUser.u_id as uId ,Team.t_title as " +
                    "tTitle , Team.u_id as uId_mate  from TeamAndUser  LEFT JOIN Team  on TeamAndUser.t_id = Team.t_id where  TeamAndUser.u_id = ? ORDER BY Team.t_time DESC";
            ArrayList<TeamTableVo>reList = (ArrayList<TeamTableVo>)baseDAO.findBySQLForVO(sql,TeamTableVo.class,new Object[]{user_id});
            for (TeamTableVo ttv:reList
                 ) {
                if(ttv.getTuState()==1){
                    ttv.setTuStateString("寻找队友中");
                }else if(ttv.getTuState()==2){
                    ttv.setTuStateString("队伍已满");
                }
            }
            return reList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<TeamTableVo> get_team_create(int user_id) {
        try {
            String sql="SELECT " +
                    " Team.t_id AS tId, " +
                    " Team.t_state AS tuState, " +
                    " Team.u_id AS uId, " +
                    " Team.t_title AS tTitle " +
                    " FROM " +
                    " Team " +
                    " WHERE " +
                    " Team.u_id = ? " +
                    " ORDER BY " +
                    " Team.t_time DESC ";
            ArrayList<TeamTableVo>reList = (ArrayList<TeamTableVo>)baseDAO.findBySQLForVO(sql,TeamTableVo.class,new Object[]{user_id});
            for (TeamTableVo ttv:reList
                    ) {
                if(ttv.getTuState()==1){
                    ttv.setTuStateString("寻找队友中");
                }else if(ttv.getTuState()==2){
                    ttv.setTuStateString("队伍已满");
                }
            }
            return reList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<StudyVo> get_study_by_uid(int uid) {
        try {
            String sql = "";
            ArrayList<Study>reList = (ArrayList<Study>)baseDAO.findByProperty("uId",uid,Study.class);
            ArrayList<StudyVo> returnList= new ArrayList();
            for (Study s:reList
                 ) {
                StudyVo sv = new StudyVo();
                sv.setsId(s.getsId());
                sv.setsIntro(s.getsIntro());
                sv.setsTime(s.getsTime());
                sv.setsTitle(s.getsTitle());
                sv.setsUrl(s.getsUrl());
                sv.setuId(s.getuId());
                returnList.add(sv);
            }
            return returnList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PowerVo get_power_by_uid(int uid) {
        try {
            String sql ="select User.u_team_power as uTeamPower,User.u_study_power as uStudyPower from User where User.u_id = ?";
            ArrayList<PowerVo>relist= (ArrayList<PowerVo>)baseDAO.findBySQLForVO(sql , PowerVo.class,new Object[]{uid});
            if (relist==null||relist.size()==0){
                PowerVo pv = new PowerVo();
                pv.setuStudyPower(2);
                pv.setuTeamPower(2);
                return pv;
            }else{
                return relist.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            PowerVo pv = new PowerVo();
            pv.setuStudyPower(2);
            pv.setuTeamPower(2);
            return pv;
        }
    }

    @Override
    public ArrayList<LaberVo> get_team_laber() {
        ArrayList<Laber> labers = (ArrayList<Laber>) baseDAO.findByProperty("lType",1,Laber.class);
        ArrayList<LaberVo> reList = new ArrayList<>();
        for (Laber l:labers
             ) {
            LaberVo lv = new LaberVo();
            lv.setlId(l.getlId());
            lv.setlName(l.getlName());
            reList.add(lv);
        }
        return reList;
    }

    @Override
    public ArrayList<LaberVo> get_project_laber() {
        ArrayList<Laber> labers = (ArrayList<Laber>) baseDAO.findByProperty("lType",2,Laber.class);
        ArrayList<LaberVo> reList = new ArrayList<>();
        for (Laber l:labers
                ) {
            LaberVo lv = new LaberVo();
            lv.setlId(l.getlId());
            lv.setlName(l.getlName());
            reList.add(lv);
        }
        return reList;
    }

    @Override
    public ArrayList<TeamListVo> get_teams_by_p(int grade, int scale, String need, String support,int type) {
        ArrayList<TeamListVo>reList = new ArrayList<>();
        String sql = "select T.t_id as tId , Team.t_grade as tGrade , Team.t_scale as tScale " +
                ", Team.u_id as uId,Team.t_time as tTime , Team.t_title as tTitle " +
                ", Team.t_tumb_num as tTumbNum , Team.t_watch_num as tWatchNum ," +
                " Team.t_intro as tIntro " +
                " from " +
                " (select TeamAndLaber.t_id as t_id ,count(TeamAndLaber.t_id) as count from TeamAndLaber where ";
        int first = 1;
        String[] needs = need.split("_");
        for (String s:needs
             ) {
            if (!s.equals("0")){
                if (first!=1){
                    sql+=" or ";
                }else{
                    first=0;
                }
                sql+="(TeamAndLaber.L_id = "+s+" and TeamAndLaber.tal_type = 1)";
            }
        }

        String[] supports = support.split("_");
        for (String s:supports
                ) {
            if (!s.equals("0")){
                if (first!=1){
                    sql+=" or ";
                }else{
                    first=0;
                }
                sql+="(TeamAndLaber.L_id = "+s+" and TeamAndLaber.tal_type = 2)";
            }
        }
        if(sql.endsWith("where ")){
            sql = "select T.t_id as tId , Team.t_grade as tGrade , Team.t_scale as tScale " +
                    ", Team.u_id as uId,Team.t_time as tTime , Team.t_title as tTitle " +
                    ", Team.t_tumb_num as tTumbNum , Team.t_watch_num as tWatchNum ," +
                    " Team.t_intro as tIntro " +
                    "from " +
                    "(select TeamAndLaber.t_id as t_id ,count(TeamAndLaber.t_id) as count from TeamAndLaber ";
        }
       /* sql+="GROUP BY t_id)T " +
                "LEFT JOIN Team on T.t_id = Team.t_id WHERE " +
                "Team.t_grade = ? " +
                "AND Team.t_scale = ? " ;*/
        sql+="GROUP BY t_id)T " +
                "LEFT JOIN Team on T.t_id = Team.t_id WHERE " ;
        int p = 0;
        if(grade!=0){
            sql+=" Team.t_grade = ? ";
            p++;
        }
        if (scale!=0){
            if(p==0)sql+=" Team.t_scale = ? ";
            else sql+=" AND Team.t_scale = ? ";
            p++;
        }
        if(p==0)sql+=" Team.t_type = ?  ";
        else sql+=" AND Team.t_type = ? ";

        sql+="order by count desc ";
        System.out.println(sql);
        if (grade==0&&scale==0){
            reList = (ArrayList<TeamListVo>)baseDAO.findBySQLForVO(sql,TeamListVo.class , new Object[]{type});
        }else if(grade==0){
            reList = (ArrayList<TeamListVo>)baseDAO.findBySQLForVO(sql,TeamListVo.class , new Object[]{scale,type});
        }
        else if(scale==0){
            reList = (ArrayList<TeamListVo>)baseDAO.findBySQLForVO(sql,TeamListVo.class , new Object[]{grade,type});
        }
        else {
            reList = (ArrayList<TeamListVo>)baseDAO.findBySQLForVO(sql,TeamListVo.class , new Object[]{grade,scale,type});
        }

        for (TeamListVo tlv : reList
             ) {
            //date
            tlv.settTimeString(DateUtil.getDateString(new Date(tlv.gettTime().longValue()),DateUtil.dashFormat));
            //user
            User user  = baseDAO.findById(tlv.getuId(),User.class);
            tlv.setuName(user.getuName());
            tlv.setuHeaderUrl(user.getuHeaderUrl());
            //labers
            String sql2 = "SELECT DISTINCT TeamAndLaber.L_id as lId , Laber.L_name as lName , Laber.L_type as lType " +
                    " from TeamAndLaber LEFT JOIN Laber on TeamAndLaber.L_id = Laber.L_id where " +
                    " TeamAndLaber.t_id = ? ";
            ArrayList<Laber>labers = (ArrayList<Laber>)baseDAO.findBySQLForVO(sql2,Laber.class , new Object[]{tlv.gettId()});
            tlv.setLabers(labers);
        }
        return reList;
    }

    @Override
    public ArrayList<StudyVo> get_study_all() {
        String sql = " SELECT s.s_id as sId , s.s_intro as sIntro , s.s_title as sTitle , s.s_url as sUrl , s.s_time as sTime , s.s_tumb_num as sTumbNum , s.s_match_num as sMatchNum, " +
                " u.u_id as uId , u.u_name as uName , u.u_header_url as uHeaderUrl " +
                "  from Study s left JOIN `User` u on s.u_id = u.u_id  ORDER BY s.s_time desc ";
        ArrayList<StudyVo>studies = ( ArrayList<StudyVo>)baseDAO.findBySQLForVO(sql,StudyVo.class,new Object[]{});
        return studies;
    }

    @Override
    public ArrayList<TeamListVo> get_teams_all() {
        String sql = "SELECT " +
                " Team.t_id AS tId, " +
                " Team.t_grade AS tGrade, " +
                " Team.t_scale AS tScale, " +
                " Team.u_id AS uId, " +
                " Team.t_time AS tTime, " +
                " Team.t_title AS tTitle, " +
                " Team.t_tumb_num AS tTumbNum, " +
                " Team.t_watch_num AS tWatchNum, " +
                " Team.t_intro AS tIntro " +
                " FROM " +
                " Team  " +
                " ORDER BY " +
                " Team.t_time DESC ";
        ArrayList<TeamListVo>reList = (ArrayList<TeamListVo>)baseDAO.findBySQLForVO(sql,TeamListVo.class,new Object[]{},0,10);
        for (TeamListVo tlv : reList
                ) {
            //date
            tlv.settTimeString(DateUtil.getDateString(new Date(tlv.gettTime().longValue()),DateUtil.dashFormat));
            //user
            User user  = baseDAO.findById(tlv.getuId(),User.class);
            tlv.setuName(user.getuName());
            tlv.setuHeaderUrl(user.getuHeaderUrl());
            //labers
            String sql2 = "SELECT DISTINCT TeamAndLaber.L_id as lId , Laber.L_name as lName , Laber.L_type as lType " +
                    " from TeamAndLaber LEFT JOIN Laber on TeamAndLaber.L_id = Laber.L_id where " +
                    " TeamAndLaber.t_id = ? ";
            ArrayList<Laber>labers = (ArrayList<Laber>)baseDAO.findBySQLForVO(sql2,Laber.class , new Object[]{tlv.gettId()});
            tlv.setLabers(labers);
        }
        return reList;
    }

    @Override
    public ArrayList<UserVo> get_hot_user() {
        String sql = " select TeamAndUser.u_id as uId,`User`.u_name as uName,`User`.u_header_url as uHeaderUrl, count(TeamAndUser.tu_id) as count " +
                " from TeamAndUser LEFT JOIN `User` on TeamAndUser.u_id = `User`.u_id GROUP BY TeamAndUser.u_id ORDER BY count desc ";
        ArrayList<UserVo> reList = (ArrayList<UserVo>)baseDAO.findBySQLForVO(sql,UserVo.class,new Object[]{},0,10);
        return reList;
    }

    @Override
    public int register( String uName, String uGender, String uSchoolNum, String uQq, String uWx, String uPhone, String pw) {
        try {
            int count = baseDAO.countBySQL("select * from `User` where `User`.u_school_num = ? ",new Object[]{uSchoolNum});
            if (count >= 1 )return -1;

            User user = new User();
            user.setuSchoolNum(uSchoolNum);
            user.setuWx(uWx);
            user.setuQq(uQq);
            user.setuPhone(uPhone);
            user.setuGender(uGender);
            user.setuName(uName);
            user.setuPw(pw);
            //user.setuHeaderUrl();
            int num = random.nextInt(9)+1;
            String header_url = "/web/pic/head/"+num+".jpg";
            user.setuHeaderUrl(header_url);
            user.setuStudyPower(1);
            user.setuTeamPower(1);
            baseDAO.save(user);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int up_study(String sTitle, String sIntro, String sUrl,int u_id) {
        if (!(sUrl.startsWith("http://")||sUrl.startsWith("https://"))){
            sUrl="http://"+sUrl;
        }
        try {
            Study study = new Study();
            study.setsIntro(sIntro);
            study.setsMatchNum(0);
            study.setsTime(System.currentTimeMillis());
            study.setsTitle(sTitle);
            study.setsTumbNum(random.nextInt(50)+1);
            study.setsUrl(sUrl);
            study.setuId(u_id);
            baseDAO.save(study);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int new_team(String title, int grade, int scale, String need, String support, String intro,int type,int u_id) {
        try {
            int t_id = get_team_num()+1;
            Team team = new Team();
            team.settId(t_id);
            team.settGrade(grade);
            team.settIntro(intro);
            team.settScale(scale);
            team.settState(1);
            team.settTime(System.currentTimeMillis());
            team.settTitle(title);
            team.settTumbNum(random.nextInt(50)+1);
            team.settWatchNum(0);
            team.settType(type);
            team.setuId(u_id);
            try {
                baseDAO.save(team);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(team.gettId());

            for (int i = 0; i<scale;i++){
                TeamAndUser teamAndUser = new TeamAndUser();
                teamAndUser.settId(t_id);
                teamAndUser.setuId(-1);
                try {
                    baseDAO.save(teamAndUser);
                    baseDAO.clear();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            String[] needs = need.split("_");
            for (String s:needs
                    ) {
                try {
                    TeamAndLaber teamAndLaber = new TeamAndLaber();
                    teamAndLaber.setlId(Integer.parseInt(s));
                    teamAndLaber.setTalType(1);
                    teamAndLaber.settId(t_id);
                    baseDAO.save(teamAndLaber);
                    baseDAO.clear();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            String[] supports = support.split("_");
            for (String s:supports
                    ) {
                try {
                    TeamAndLaber teamAndLaber2 = new TeamAndLaber();
                    teamAndLaber2.setlId(Integer.parseInt(s));
                    teamAndLaber2.setTalType(2);
                    teamAndLaber2.settId(t_id);
                    baseDAO.save(teamAndLaber2);
                    baseDAO.clear();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    int get_team_num(){
        int num = baseDAO.countBySQL("select * from Team",new Object[]{});
        return num;
    }

    @Override
    public TeamListVo get_team_info_by_id(int t_id) {
        Team team = baseDAO.findById(t_id,Team.class);
        TeamListVo teamListVo = new TeamListVo();
        teamListVo.settTimeString(DateUtil.getDateString(new Date(team.gettTime()),DateUtil.dashFormat));
        if (team.gettGrade()==1){
            teamListVo.settGradeString("大一");
        }else if (team.gettGrade()==2){
            teamListVo.settGradeString("大二");
        }else if (team.gettGrade()==3){
            teamListVo.settGradeString("大三");
        }else if (team.gettGrade()==4){
            teamListVo.settGradeString("大四");
        }
        teamListVo.settIntro(team.gettIntro());
        teamListVo.settScale(team.gettScale());
        teamListVo.settTitle(team.gettTitle());
        if(team.gettState()==1){
            teamListVo.setState("寻找队友中");
        }else  if(team.gettState()==2){
            teamListVo.setState("队伍已满");
        }
        UserDetailVo user = getUserInfoByUserId(team.getuId());
        teamListVo.setuName(user.getuName());
        String sql = "SELECT  TeamAndLaber.L_id as lId , Laber.L_name as lName , Laber.L_type as lType  " +
                "                from TeamAndLaber LEFT JOIN Laber on TeamAndLaber.L_id = Laber.L_id where  " +
                "                TeamAndLaber.t_id = ? and TeamAndLaber.tal_type = 1 ";
        ArrayList<Laber>labers_need = (ArrayList<Laber>)baseDAO.findBySQLForVO(sql,Laber.class , new Object[]{t_id});
        teamListVo.setLabers_need(labers_need);

        String sql2 = "SELECT  TeamAndLaber.L_id as lId , Laber.L_name as lName , Laber.L_type as lType  " +
                "                from TeamAndLaber LEFT JOIN Laber on TeamAndLaber.L_id = Laber.L_id where  " +
                "                TeamAndLaber.t_id = ? and TeamAndLaber.tal_type = 2 ";
        ArrayList<Laber>labers_support = (ArrayList<Laber>)baseDAO.findBySQLForVO(sql2,Laber.class , new Object[]{t_id});
        teamListVo.setLabers_support(labers_support);
        return teamListVo;
    }

    @Override
    public int add_team(int t_id, int u_id) {
        Team team = baseDAO.findById(t_id,Team.class);
        if (team.getuId()==u_id) return -3;// 不能加入自己创建的队伍
        int count = baseDAO.countBySQL("select * from TeamAndUser where TeamAndUser.t_id = ? and TeamAndUser.u_id = ? ",new Object[]{t_id,u_id});
        if (count!=0)return -1;//已经参加过这个队伍
        Map p_map = new HashMap();
        p_map.put("tId",t_id);
        p_map.put("uId",-1);
        ArrayList<TeamAndUser> teamAndUsers = (ArrayList<TeamAndUser>)baseDAO.findByProperties(p_map,TeamAndUser.class);
        System.out.println(teamAndUsers.size());
        if (teamAndUsers==null||teamAndUsers.size()<=0){
            return -2;// 这个队伍满员了
        }else{
            team.settState(2);
            baseDAO.update(team);
            TeamAndUser teamAndUser = teamAndUsers.get(0);
            teamAndUser.setuId(u_id);
            baseDAO.update(teamAndUser);
            baseDAO.clear();
            return 1;
        }
    }

    @Override
    public ArrayList<UserVo> get_mates_by_t_id(int t_id) {
        String sql = " select `User`.u_id as uId , `User`.u_name as uName from " +
                " TeamAndUser LEFT JOIN `User` on TeamAndUser.u_id = `User`.u_id where TeamAndUser.u_id != -1 and TeamAndUser.t_id = ?";
        ArrayList<UserVo> userVos =(ArrayList<UserVo>)baseDAO.findBySQLForVO(sql,UserVo.class,new Object[]{t_id});
        return userVos;
    }

    @Override
    public void study_num_update(int type, int s_id) {
        Study study = baseDAO.findById(s_id,Study.class);
        if (type==1){
            study.setsMatchNum(study.getsMatchNum()+1);
            baseDAO.update(study);
        }else if(type==2){
            study.setsTumbNum(study.getsTumbNum()+1);
            baseDAO.update(study);
        }
    }

    @Override
    public void team_num_update(int type, int t_id) {
        Team team =baseDAO.findById(t_id,Team.class);
        if (type==1){
            team.settWatchNum(team.gettWatchNum()+1);
            baseDAO.update(team);
        }else if(type==2){
            team.settTumbNum(team.gettTumbNum()+1);
            baseDAO.update(team);
        }
    }

    @Override
    public int del_study(int u_id, int s_id) {
        Study study = baseDAO.findById(s_id,Study.class);
        if (study==null ||study.getuId()!=u_id)return  -1;
        else baseDAO.delete(study);
        return 1;
    }

    @Override
    public int upfile(int t_id,String f_name,String f_url){
        try {
            studyfile file =new studyfile();
            file.settId(t_id);
            file.setfName(f_name);
            file.setfUrl(f_url);
            baseDAO.save(file);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<studyfile> getfile(int t_id) {
        List<studyfile> files = baseDAO.findByProperty("tId",t_id,studyfile.class);
        return files;
    }

    @Override
    public ArrayList<PostVo> get_post_by_page(int page) {
        //10 posts per page
        ArrayList<PostVo> posts = (ArrayList<PostVo>) baseDAO.findBySQLForVO("" +
                "select p.p_id as pId , p.p_floor as pFloor , p.p_main as pMain , p.p_title as pTitle" +
                " , u.u_name as uName from Post as p join  user as u on p.u_id = u.u_id "
                ,PostVo.class,null,10*(page-1),10);
        return posts;
    }


    @Override
    public int add_post(int u_id, String title, String main) {
        Post  post = new Post();
        post.setpMain(main);
        post.setpFloor(0);
        post.setpTitle(title);
        post.setuId(u_id);
        baseDAO.save(post);
        return 1;
    }

    @Override
    public Post get_post_by_id(int id) {
        Post post = baseDAO.findById(id,Post.class);
        //同时要拿出所有的评论  select还要join用户表
        return post;
    }

    @Override
    public ArrayList<FloorVo> get_floors_by_page(int p_id) {
        ArrayList<FloorVo> posts = (ArrayList<FloorVo>) baseDAO.findBySQL("" +
                        "select p.p_id as pId , p.p_floor as pFloor , p.p_main as pMain , p.p_title as pTitle" +
                        " , u.u_name as uName from Post as p join  user as u on p.u_id = u.u_id "
                ,new Object[]{});
        return null;
    }
}
