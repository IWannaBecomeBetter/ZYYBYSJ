package com.bs.controller;

import com.bs.common.entity.BaseController;
import com.bs.common.entity.PageInfo;
import com.bs.common.entity.ResultBean;
import com.bs.dao.entity.Dormitory;
import com.bs.dao.entity.User;
import com.bs.service.DormitoryService;
import com.bs.service.UserServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/17.
 */
@Controller
@RequestMapping(value = "dormitory")
public class DormitoryController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);

    @Autowired
    private DormitoryService dormitoryService;
    @Autowired
    private UserServer userServer;

    /**
     * 管理员查看列表
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return String.format(MANAGER_VM_ROOT, "dormitory");
    }

    /**
     * 管理员获取列表
     * @param dormitory
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public List<Dormitory> list(Dormitory dormitory,PageInfo pageInfo){
        List<Dormitory> dormitories = dormitoryService.dormitoryList(dormitory, pageInfo);
        return dormitories;
    }

    /**
     * 新增宿舍
     * @param dormitory
     * @return
     */
    @RequestMapping(value = "addDormitory",method = RequestMethod.POST)
    @ResponseBody
    public ResultBean addDormitory(Dormitory dormitory){
        try{
            dormitoryService.addDormitory(dormitory);
            return new ResultBean(true);
        }catch (Exception ex){
            return ajaxException(ex);
        }
    }



    /**
     * 修改宿舍
     * @param dormitory
     * @return
     */
    @RequestMapping(value = "updateDormitory",method = RequestMethod.POST)
    @ResponseBody
    public ResultBean updateDormitory(Dormitory dormitory){
        dormitoryService.updateDormitory(dormitory);
        return new ResultBean(true);
    }


    @RequestMapping(value = "getListByDormitoryId",method = RequestMethod.POST)
    @ResponseBody
    public List<User> getListByDormitpryId(Dormitory dormitory){
        List<User> users = userServer.getListByDormitpryId(dormitory);
        return users;
    }


    @RequestMapping(value = "inDormitory",method = RequestMethod.POST)
    @ResponseBody
    public ResultBean inDormitory(User user){
        try{
            dormitoryService.inDormitory(user);
            return new ResultBean(true);
        }catch (Exception ex){
            return ajaxException(ex);
        }

    }


    @RequestMapping(value = "outDormitory",method = RequestMethod.POST)
    @ResponseBody
    public ResultBean outDormitory(User user){
        dormitoryService.outDormitory(user);
        return new ResultBean(true);
    }


    @RequestMapping(value = "leaderDormitory",method = RequestMethod.POST)
    @ResponseBody
    public ResultBean leaderDormitory(User user){
        dormitoryService.leaderDormitory(user);
        return new ResultBean(true);
    }



    @RequestMapping(value = "getWithOutDormitory",method = RequestMethod.POST)
    @ResponseBody
    public List<User> getWithOutDormitory(){
        List<User> users = userServer.getWithOutDormitory();
        return users;
    }
}
