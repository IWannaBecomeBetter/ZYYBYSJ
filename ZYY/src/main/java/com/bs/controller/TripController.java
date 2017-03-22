package com.bs.controller;

import com.bs.common.entity.BaseController;
import com.bs.common.entity.PageInfo;
import com.bs.common.entity.ResultBean;
import com.bs.common.util.StringUtil;
import com.bs.dao.entity.Trip;
import com.bs.dao.entity.User;
import com.bs.service.TripService;
import org.apache.commons.collections.CollectionUtils;
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */
@Controller
@RequestMapping(value = "trip")
public class TripController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(TripController.class);
    @Autowired
    private TripService tripService;

    /**
     * 管理员查看列表
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return String.format(MANAGER_VM_ROOT, "trip");
    }

    /**
     * 学生查看离校列表
     * @return
     */
    @RequestMapping(value = {"out","","/"}, method = RequestMethod.GET)
    public String trip() {
        return String.format(STUDENT_VM_ROOT, "out");
    }


    /**
     * 学生查看未返校列表
     * @return
     */
    @RequestMapping(value = "back", method = RequestMethod.GET)
    public String back() {
        return String.format(STUDENT_VM_ROOT, "back");
    }


    /**
     * 管理员获取列表
     * @param trip
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public List<Trip> list(Trip trip, PageInfo pageInfo) {

        List<Trip> trips = tripService.tripList(trip,pageInfo);
        return trips;
    }



    /**
     * 学生根据自己的code获取自己的离校记录
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "myList", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<Trip> myList(PageInfo pageInfo, HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("myself");
        List<Trip> trips = tripService.tripListByCode(user.getUsercode(),pageInfo);
        return trips;
    }

    /**
     * 学生新增离校记录
     * @param trip
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "addTrip", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean add(Trip trip, HttpServletRequest request, HttpServletResponse response) {
        try{
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("myself");
            tripService.addTrip(trip,user);
            ResultBean resultBean = new ResultBean(true);
            return resultBean;
        }catch (Exception ex) {
            return ajaxException(ex);
        }
    }


    /**
     * 学生获取还未确认的离校记录
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "outList", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<Trip> outList(PageInfo pageInfo,HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("myself");
        List<Trip> trips = tripService.outListByCode(user.getUsercode(),pageInfo);
        if(CollectionUtils.isNotEmpty(trips)){
            return trips;
        }else{
            return new ArrayList<Trip>();
        }

    }


    @RequestMapping(value = "addBack", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean addBack(int id, HttpServletRequest request, HttpServletResponse response) {
        try{
            tripService.addBack(id);
            ResultBean resultBean = new ResultBean(true);
            return resultBean;
        }catch (Exception ex) {
            return ajaxException(ex);
        }
    }
}
