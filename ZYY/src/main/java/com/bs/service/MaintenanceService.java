package com.bs.service;

import com.bs.common.entity.PageInfo;
import com.bs.dao.entity.Repair;
import com.bs.dao.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */
public interface MaintenanceService {

    /**
     * 根据寝室号查询申报列表
     * @param dormitorId
     * @return
     */
    List<Repair> repairListByDormitorId(int dormitorId, PageInfo pageInfo);

    /**
     * 获取所有信息
     * @return
     */
    List<Repair> repairList(Repair repair,PageInfo pageInfo);

    /**
     * 新增维修
     * @param repair
     */
    void addRepair(Repair repair,User user);

    /**
     * 维修完成
     * @param repair
     */
    void finishRepair(Repair repair);

    /**
     * 删除维修信息
     * @param repair
     */
    void deleteRepair(Repair repair);

}
