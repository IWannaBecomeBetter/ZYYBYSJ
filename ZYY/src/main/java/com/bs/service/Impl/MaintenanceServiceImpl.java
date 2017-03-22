package com.bs.service.Impl;

import antlr.StringUtils;
import com.bs.common.constants.SysParamDetailConstant;
import com.bs.common.entity.PageInfo;
import com.bs.common.exception.ApplicationException;
import com.bs.common.util.DateUtil;
import com.bs.common.util.StringUtil;
import com.bs.dao.entity.*;
import com.bs.dao.mapping.DormitoryMapper;
import com.bs.dao.mapping.RepairMapper;
import com.bs.service.MaintenanceService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */
@Service
@Transactional
public class MaintenanceServiceImpl implements MaintenanceService{

    @Autowired
    private RepairMapper repairMapper;
    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Override
    public List<Repair> repairListByDormitorId(int dormitorid, PageInfo pageInfo) {
        RepairExample repairExample = new RepairExample();
        if(StringUtil.isNotEmptyObject(dormitorid)){
            repairExample.createCriteria().andDormitoridEqualTo(dormitorid);
        }
        repairExample.setOrderByClause("startdate desc");
        repairExample.setLimitClauseStart(pageInfo.getPage());
        repairExample.setLimitClauseCount(pageInfo.getRows());
        List<Repair> repairs = repairMapper.selectByExample(repairExample);
        if(CollectionUtils.isEmpty(repairs)){
            throw new ApplicationException("暂无记录");
        }
        else{
            return repairs;
        }
    }

    @Override
    public List<Repair> repairList(Repair repair,PageInfo pageInfo) {
        RepairExample repairExample = new RepairExample();
        if(StringUtil.isNotEmptyObject(repair.getRepairstate())){
            repairExample.createCriteria().andRepairstateEqualTo(repair.getRepairstate());
        }
        repairExample.setOrderByClause("startdate desc");
        repairExample.setLimitClauseStart(pageInfo.getPage());
        repairExample.setLimitClauseCount(pageInfo.getRows());
        List<Repair> repairs = repairMapper.selectByExample(repairExample);
        return repairs;
    }

    @Override
    public void addRepair(Repair repair, User user) {
        DormitoryExample dormitoryExample = new DormitoryExample();
        dormitoryExample.createCriteria().andIdEqualTo(user.getDormitoryid());
        List<Dormitory> dormitories = dormitoryMapper.selectByExample(dormitoryExample);
        repair.setUsername(user.getUsername());
        repair.setTelephone(user.getTelephone());
        repair.setDoorplate(dormitories.get(0).getDoorplate());
        repair.setDormitorid(user.getDormitoryid());
        repair.setStartdate(DateUtil.getTimestamp());
        repair.setRepairstate(SysParamDetailConstant.REPAIR_NO);
        repairMapper.insertSelective(repair);
    }

    @Override
    public void finishRepair(Repair repair) {
        repair.setEnddate(DateUtil.getTimestamp());
        repair.setRepairstate(SysParamDetailConstant.REPAIR_YES);
        repairMapper.updateByPrimaryKeySelective(repair);
    }


    @Override
    public void deleteRepair(Repair repair) {
        repairMapper.deleteByPrimaryKey(repair.getId());
    }
}
