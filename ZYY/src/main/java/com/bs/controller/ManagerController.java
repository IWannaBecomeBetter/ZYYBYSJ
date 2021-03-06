package com.bs.controller;

import com.bs.common.entity.BaseController;
import com.bs.common.entity.ResultBean;
import com.bs.dao.entity.User;
import com.bs.service.UserServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value={"","manager"})
public class ManagerController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);

    @Autowired
    private UserServer userServer;
    /**
     * 后台管理首页
     *
     * @return
     */
    @RequestMapping(value = {"/manager_index", "/manager_index/"}, method = RequestMethod.GET)
    public ModelAndView index(Model model,HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User myself = (User) session.getAttribute("myself");
        model.addAttribute("myself",myself);
        return new ModelAndView(String.format(MANAGER_VM_ROOT, "manager_index"));
    }

    @RequestMapping(value = "manager_update",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView managerUpdate(Model model,HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User myself = (User) session.getAttribute("myself");
        model.addAttribute("myself",myself);
        return new ModelAndView(String.format(MANAGER_VM_ROOT, "update"));
    }


    @RequestMapping(value = "manager_update",method = RequestMethod.POST)
    @ResponseBody
    public ResultBean update(User user){
        userServer.update(user);
        return new ResultBean(true);
    }

}
