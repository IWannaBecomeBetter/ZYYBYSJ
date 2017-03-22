package com.bs.controller;

import com.bs.common.entity.BaseController;
import com.bs.common.entity.ResultBean;
import com.bs.dao.entity.Dormitory;
import com.bs.dao.entity.User;
import com.bs.service.DormitoryService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value={"","student"})
public class StudentController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private DormitoryService dormitoryService;
    @Autowired
    private UserServer userServer;

    /**
     * 学生后台管理首页
     *
     * @return
     */
    @RequestMapping(value = {"student_index", "/student_index/"}, method = RequestMethod.GET)
    public ModelAndView index(Model model,HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User myself = (User) session.getAttribute("myself");
        Dormitory dormitory = dormitoryService.getById(myself.getDormitoryid());
        model.addAttribute("dormitory",dormitory);
        return new ModelAndView(String.format(STUDENT_VM_ROOT, "student_index"));
    }


    @RequestMapping(value = "update",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView update(Model model,HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User myself = (User) session.getAttribute("myself");
        model.addAttribute("myself",myself);
        return new ModelAndView(String.format(STUDENT_VM_ROOT, "update"));
    }


    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public ResultBean update(User user){
        userServer.update(user);
        return new ResultBean(true);
    }


}
