package com.bs.controller;

import com.bs.common.entity.BaseController;
import com.bs.common.entity.PageInfo;
import com.bs.common.entity.ResultBean;
import com.bs.dao.entity.Repair;
import com.bs.dao.entity.Trip;
import com.bs.dao.entity.User;
import com.bs.dao.entity.VisitLog;
import com.bs.service.VisitService;
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
import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
@Controller
@RequestMapping(value = "visit")
public class VisitController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(VisitController.class);
    @Autowired
    private VisitService visitService;

    /**
     * 管理员查看所有列表
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return String.format(MANAGER_VM_ROOT, "visitInList");
    }

    /**
     * 管理员查看未离去列表
     * @return
     */
    @RequestMapping(value = "outList", method = RequestMethod.GET)
    public String outList() {
        return String.format(MANAGER_VM_ROOT, "visitOutList");
    }

    /**
     * 管理员获取列表
     * @param visitLog
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public List<VisitLog> list(VisitLog visitLog, PageInfo pageInfo) {

        List<VisitLog> visitLogs = visitService.List(visitLog,pageInfo);
        return visitLogs;
    }


    /**
     * 管理员获取列表
     * @param visitLog
     * @return
     */
    @RequestMapping(value = "outList", method = RequestMethod.POST)
    @ResponseBody
    public List<VisitLog> outList(VisitLog visitLog, PageInfo pageInfo) {

        List<VisitLog> visitLogs = visitService.outList(pageInfo);
        return visitLogs;
    }


    /**
     * 添加申请维修记录
     * @param visitLog
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "addVisit", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean addVisit(VisitLog visitLog, HttpServletRequest request, HttpServletResponse response) {
        try{
            visitService.addVisit(visitLog);
            ResultBean resultBean = new ResultBean(true);
            return resultBean;
        }catch (Exception ex) {
            return ajaxException(ex);
        }
    }


    @RequestMapping(value = "visitOut",method = RequestMethod.POST)
    @ResponseBody
    public ResultBean visitOut(VisitLog visitLog){
        try{
            visitService.visitOut(visitLog);
            return new ResultBean(true);
        }catch (Exception ex){
            return ajaxException(ex);
        }
    }
}
