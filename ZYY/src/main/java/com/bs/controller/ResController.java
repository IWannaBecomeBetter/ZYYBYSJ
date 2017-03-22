package com.bs.controller;

import com.bs.common.entity.BaseController;
import com.bs.common.entity.PageInfo;
import com.bs.common.entity.ResultBean;
import com.bs.common.util.StringUtil;
import com.bs.dao.entity.Res;
import com.bs.dao.entity.Trip;
import com.bs.dao.entity.User;
import com.bs.service.ResService;
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
@RequestMapping(value = "res")
public class ResController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(ResController.class);
    @Autowired
    private ResService resService;

    /**
     * 管理员查看物品列表
     * @return
     */
    @RequestMapping(value = "inList", method = RequestMethod.GET)
    public String inList() {
        return String.format(MANAGER_VM_ROOT, "resInList");
    }


    /**
     * 管理员查看物品列表
     * @return
     */
    @RequestMapping(value = "outList", method = RequestMethod.GET)
    public String outList() {
        return String.format(MANAGER_VM_ROOT, "resOutList");
    }


    /**
     * 管理员获取物品页面
     * @param res
     * @return
     */
    @RequestMapping(value = "inList", method = RequestMethod.POST)
    @ResponseBody
    public List<Res> inList(Res res, PageInfo pageInfo) {
        List<Res> resList = resService.resList(res,pageInfo);
        return resList;
    }


    /**
     * 管理员获取物品列表
     * @param res
     * @return
     */
    @RequestMapping(value = "outList", method = RequestMethod.POST)
    @ResponseBody
    public List<Res> outlist(Res res, PageInfo pageInfo) {
        List<Res> resList = resService.resList(res,pageInfo);
        return resList;
    }



    @RequestMapping(value = "addRes", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean add(Res res) {
        try{
            if(StringUtil.isNotEmptyObject(res)){
                resService.addRes(res);
            }
            ResultBean resultBean = new ResultBean(true);
            return resultBean;
        }catch (Exception ex) {
            return ajaxException(ex);
        }
    }


    @RequestMapping(value = "outRes", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean out(Res res,int outnum) {
        try{
            resService.outRes(res,outnum);
            ResultBean resultBean = new ResultBean(true);
            return resultBean;
        }catch (Exception ex) {
            return ajaxException(ex);
        }
    }
}
