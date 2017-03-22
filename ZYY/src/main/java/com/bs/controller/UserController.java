package com.bs.controller;

import com.bs.common.annotation.Check;
import com.bs.common.entity.BaseController;
import com.bs.common.entity.ResultBean;
import com.bs.dao.entity.Dormitory;
import com.bs.dao.entity.User;
import com.bs.service.Impl.UserServerImpl;
import com.bs.service.UserServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/5.
 */
@Controller
@RequestMapping("")
public class UserController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserServer userServer;

    /**
     * 登陆页面
     * @return
     */
    @RequestMapping(value = {"", "/", "login"}, method = RequestMethod.GET)
    @Check(loginCheck = false)
    public String index() {
        return String.format(MAIN_VM_ROOT, "login");
    }


    /**
     * 用户登录
     * @param user
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    @Check(loginCheck = false)
    public ResultBean login(User user, HttpServletRequest request, HttpServletResponse response) {
        try{
            User myself = userServer.login(user);
            HttpSession session = request.getSession();
            session.setAttribute("myself",myself);
            ResultBean resultBean = new ResultBean(true);
            resultBean.setData(myself);
            return resultBean;
        }catch (Exception ex) {
            return ajaxException(ex);
        }
    }



    @RequestMapping(value = "changePassword", method = RequestMethod.GET)
    @Check(loginCheck = false)
    public String changePassword() {
        return String.format(MAIN_VM_ROOT, "user/changePassword");
    }


    /**
     * 修改密码
     * @param oldPassword
     * @param newPassword
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "changePassword", method = RequestMethod.POST)
    @ResponseBody
    @Check(loginCheck = false)
    public ResultBean changePassword(String oldPassword, String newPassword,HttpServletRequest request, HttpServletResponse response) {
        try{
            HttpSession session = request.getSession();
            User myself = (User) session.getAttribute("myself");
            userServer.changePassword(myself,oldPassword,newPassword);
            ResultBean resultBean = new ResultBean(true);
            return resultBean;
        }catch (Exception ex) {
            return ajaxException(ex);
        }
    }

}
