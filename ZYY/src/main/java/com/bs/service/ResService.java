package com.bs.service;

import com.bs.common.entity.PageInfo;
import com.bs.dao.entity.Res;

import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
public interface ResService {
    /**
     * 管理员获取物品列表
     * @param res
     * @param pageInfo
     * @return
     */
    List<Res> resList(Res res,PageInfo pageInfo);

    /**
     * 管理员获取物品列表
     * @param res
     * @param pageInfo
     * @return
     */
    List<Res> outList(Res res,PageInfo pageInfo);

    /**
     * 管理员新增物品
     * @param res
     */
    void addRes(Res res);

    /**
     * 物品出库
     * @param res
     * @param outnum
     */
    void outRes(Res res,int outnum);
}
