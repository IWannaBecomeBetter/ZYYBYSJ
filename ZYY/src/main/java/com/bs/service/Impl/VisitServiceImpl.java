package com.bs.service.Impl;

import com.bs.common.constants.SysParamDetailConstant;
import com.bs.common.entity.PageInfo;
import com.bs.common.util.DateUtil;
import com.bs.common.util.StringUtil;
import com.bs.dao.entity.VisitLog;
import com.bs.dao.entity.VisitLogExample;
import com.bs.dao.mapping.VisitLogMapper;
import com.bs.service.VisitService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
@Service
@Transactional
public class VisitServiceImpl implements VisitService {
    @Autowired
    private VisitLogMapper visitLogMapper;

    @Override
    public List<VisitLog> List(VisitLog visitLog,PageInfo pageInfo) {
        VisitLogExample visitLogExample = new VisitLogExample();
        if(StringUtil.isNotEmptyObject(visitLog.getVisitstate())){
            visitLogExample.createCriteria().andVisitstateEqualTo(visitLog.getVisitstate());
        }
        visitLogExample.setOrderByClause("in_date desc");
        visitLogExample.setLimitClauseStart(pageInfo.getPage());
        visitLogExample.setLimitClauseCount(pageInfo.getRows());
        List<VisitLog> visitLogs = visitLogMapper.selectByExample(visitLogExample);
        if(CollectionUtils.isNotEmpty(visitLogs)){
            return visitLogs;
        }else{
            return new ArrayList<VisitLog>();
        }
    }

    @Override
    public List<VisitLog> outList(PageInfo pageInfo) {
        VisitLogExample visitLogExample = new VisitLogExample();
        visitLogExample.createCriteria().andVisitstateEqualTo(SysParamDetailConstant.VISIT_IN);
        visitLogExample.setOrderByClause("out_date desc");
        visitLogExample.setLimitClauseStart(pageInfo.getPage());
        visitLogExample.setLimitClauseCount(pageInfo.getRows());
        List<VisitLog> visitLogs = visitLogMapper.selectByExample(visitLogExample);
        if(CollectionUtils.isNotEmpty(visitLogs)){
            return visitLogs;
        }else{
            return new ArrayList<VisitLog>();
        }
    }

    @Override
    public void addVisit(VisitLog visitLog) {
        visitLog.setInDate(DateUtil.getTimestamp());
        visitLog.setVisitstate(SysParamDetailConstant.VISIT_IN);
        visitLogMapper.insertSelective(visitLog);
    }

    @Override
    public void visitOut(VisitLog visitLog) {
        visitLog.setOutDate(DateUtil.getTimestamp());
        visitLog.setVisitstate(SysParamDetailConstant.VISIT_OUT);
        visitLogMapper.updateByPrimaryKeySelective(visitLog);
    }
}
