package com.young.controller.base;

import com.framework.constant.Constant;
import com.framework.exceptions.NotLoginException;
import com.young.entity.Teacher;
import com.young.json.BaseJson;
import com.framework.exceptions.InvaildParamentException;
import com.young.vo.TeacherVo;
import com.young.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by deru on 2017/2/3.
 */
public class BaseController {

    protected Logger log = LoggerFactory.getLogger(getClass());

    /**
     * ThreadLocal确保高并发下每个请求的request，response都是独立的
     */
    private static ThreadLocal<ServletRequest> currentRequest = new ThreadLocal<ServletRequest>();
    private static ThreadLocal<ServletResponse> currentResponse = new ThreadLocal<ServletResponse>();
    /**
     * 线程安全初始化reque，respose对象
     *
     * @param request
     * @param response
     */
    @ModelAttribute
    protected void initReqAndRep(HttpServletRequest request, HttpServletResponse response) {
        currentRequest.set(request);
        currentResponse.set(response);
    }

    /**
     * 线程安全
     *
     * @return
     */
    protected HttpServletRequest getHttpRequest() {
        return (HttpServletRequest) currentRequest.get();
    }

    /**
     * 线程安全
     *
     * @return
     */
    protected HttpServletResponse getHttpResponse() {
        return (HttpServletResponse) currentResponse.get();
    }

    protected void setUserSession(UserVo value) {
        getHttpRequest().getSession().setAttribute(Constant.USER, value);
    }

    protected UserVo getUserSession() {
        HttpSession session = getHttpRequest().getSession();
        if (session.getAttribute(Constant.USER) == null)
            throw new NotLoginException();
        return (UserVo)session.getAttribute(Constant.USER);
    }

    protected void setTeacherSession(TeacherVo value) {
        getHttpRequest().getSession().setAttribute(Constant.USER, value);
    }

    protected TeacherVo getTeacherSession() {
        HttpSession session = getHttpRequest().getSession();
        if (session.getAttribute(Constant.USER) == null)
            throw new NotLoginException();
        return (TeacherVo)session.getAttribute(Constant.USER);
    }


    protected ModelAndView getModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModel().put(Constant.USER,getUserSession());
        return modelAndView;
    }
    protected ModelAndView getModelAndView1(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModel().put(Constant.USER,getTeacherSession());
        return modelAndView;
    }

    /**
     * 保存session数据
     *
     * @param key
     * @param value
     */
    protected void setSessionAttribute(String key, Object value) {
        getHttpRequest().getSession().setAttribute(key, value);
    }

    /**
     * 获取session数据
     *
     * @param key
     */
    protected Object getSessionAttribute(String key) {
        return getHttpRequest().getSession().getAttribute(key);
    }


    /**
     * 异常处理，转换异常代码并写入json对象
     *
     * @param e      异常
     * @param target 绑定的json对象
     */
    protected void processException(Throwable e, BaseJson target) {

    }


    protected int parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new InvaildParamentException();
        }
    }

    protected long parseLong(String s) {
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException e) {
            throw new InvaildParamentException();
        }
    }
}
