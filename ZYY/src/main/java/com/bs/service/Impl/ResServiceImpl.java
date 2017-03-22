package com.bs.service.Impl;

import com.bs.common.constants.SysParamDetailConstant;
import com.bs.common.entity.PageInfo;
import com.bs.common.util.DateUtil;
import com.bs.dao.entity.Res;
import com.bs.dao.entity.ResExample;
import com.bs.dao.mapping.ResMapper;
import com.bs.service.ResService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
@Service
@Transactional
public class ResServiceImpl implements ResService {
    @Autowired
    private ResMapper resMapper;

    @Override
    public List<Res> resList(Res res, PageInfo pageInfo) {
        ResExample resExample = new ResExample();
        resExample.createCriteria().andResnumNotEqualTo("0");
        resExample.setLimitClauseStart(pageInfo.getPage());
        resExample.setLimitClauseCount(pageInfo.getRows());
        resExample.setOrderByClause("updatedate desc");
        List<Res> resList = resMapper.selectByExample(resExample);
        if(CollectionUtils.isNotEmpty(resList)){
            return resList;
        }else{
            return new ArrayList<Res>();
        }
    }

    @Override
    public List<Res> outList(Res res, PageInfo pageInfo) {
        ResExample resExample = new ResExample();
        resExample.createCriteria().andResnameGreaterThan("0").andResstateEqualTo(SysParamDetailConstant.RES_IN);
        resExample.setLimitClauseStart(pageInfo.getPage());
        resExample.setLimitClauseCount(pageInfo.getRows());
        resExample.setOrderByClause("updatedate desc");
        List<Res> resList = resMapper.selectByExample(resExample);
        if(CollectionUtils.isNotEmpty(resList)){
            return resList;
        }else{
            return new ArrayList<Res>();
        }
    }

    @Override
    public void addRes(Res res) {
        res.setResstate(SysParamDetailConstant.RES_IN);
        res.setUpdatedate(DateUtil.getTimestamp());
        resMapper.insertSelective(res);
    }

    @Override
    public void outRes(Res res, int outnum) {
        res = resMapper.selectByPrimaryKey(res.getId());
        int lost = Integer.parseInt(res.getResnum())-outnum;
        res.setResnum(String.valueOf(lost));
        resMapper.updateByPrimaryKeySelective(res);
    }
}
