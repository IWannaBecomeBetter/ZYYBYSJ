package com.bs.controller;

import com.bs.common.annotation.Check;
import com.bs.common.constants.SysParamDetailConstant;
import com.bs.common.entity.BaseController;
import com.bs.common.entity.PageInfo;
import com.bs.common.entity.ResultBean;
import com.bs.common.util.StringUtil;
import com.bs.dao.entity.Repair;
import com.bs.dao.entity.User;
import com.bs.service.MaintenanceService;
import org.apache.commons.collections.CollectionUtils;
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
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */
@Controller
@RequestMapping(value = "maintenance")
public class MaintenanceController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);

    @Autowired
    private MaintenanceService maintenanceService;

    /**
     * 申报列表
     * @return
     */
    @RequestMapping(value = {"maintenance","","/"}, method = RequestMethod.GET)
    public String maintenance(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("myself");
        if(user.getUsertype().equals(SysParamDetailConstant.USER_STUDENT)){
            return String.format(STUDENT_VM_ROOT, "maintenance");
        }else {
            return String.format(MANAGER_VM_ROOT, "maintenance");
        }
    }

    /**
     * 根据用户是否有寝室号查询维修列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "list", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<Repair> list(Repair repair,PageInfo pageInfo,HttpServletRequest request, HttpServletResponse response) {

            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("myself");
            List<Repair> repairs = new ArrayList<Repair>();
            if(StringUtil.isNotEmptyObject(user.getDormitoryid())){//学生有寝室号
                repairs = maintenanceService.repairListByDormitorId(user.getDormitoryid(),pageInfo);
            }else{//管理员没有寝室号
                repairs = maintenanceService.repairList(repair,pageInfo);
            }
            if(CollectionUtils.isNotEmpty(repairs)){
                return repairs;
            }else{
                return new ArrayList<Repair>();
            }
    }

    /**
     * 添加申请维修记录
     * @param repairs
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "addRepair", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean addRepair(Repair repairs,HttpServletRequest request, HttpServletResponse response) {
        try{
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("myself");
            maintenanceService.addRepair(repairs,user);
            ResultBean resultBean = new ResultBean(true);
            resultBean.setData(repairs);
            return resultBean;
        }catch (Exception ex) {
            return ajaxException(ex);
        }
    }


    @RequestMapping(value = "finishRepair",method = RequestMethod.POST)
    @ResponseBody
    public ResultBean finishRepair(Repair repairs){
        try{
            maintenanceService.finishRepair(repairs);
            return new ResultBean(true);
        }catch (Exception ex){
            return ajaxException(ex);
        }
    }
}
