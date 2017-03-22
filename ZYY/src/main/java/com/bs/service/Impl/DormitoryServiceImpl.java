package com.bs.service.Impl;

import com.bs.common.constants.SysParamDetailConstant;
import com.bs.common.entity.PageInfo;
import com.bs.common.exception.ApplicationException;
import com.bs.common.util.StringUtil;
import com.bs.dao.entity.Dormitory;
import com.bs.dao.entity.DormitoryExample;
import com.bs.dao.entity.User;
import com.bs.dao.entity.UserExample;
import com.bs.dao.mapping.DormitoryMapper;
import com.bs.dao.mapping.UserMapper;
import com.bs.service.DormitoryService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */
@Service
@Transactional
public class DormitoryServiceImpl implements DormitoryService {
    @Autowired
    private DormitoryMapper dormitoryMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Dormitory getById(int id) {
        Dormitory dormitory = dormitoryMapper.selectByPrimaryKey(id);
        if(StringUtil.isNotEmptyObject(dormitory)){
            return dormitory;
        }else{
            return new Dormitory();
        }
    }

    @Override
    public List<Dormitory> dormitoryList(Dormitory dormitory,PageInfo pageInfo) {
        DormitoryExample dormitoryExample = new DormitoryExample();

        dormitoryExample.setLimitClauseStart(pageInfo.getPage());
        dormitoryExample.setLimitClauseCount(pageInfo.getRows());
        dormitoryExample.setOrderByClause("doorplate asc");
        List<Dormitory> dormitories = dormitoryMapper.selectByExample(dormitoryExample);
        if(CollectionUtils.isNotEmpty(dormitories)){
            return dormitories;
        }else{
            return new ArrayList<Dormitory>();
        }
    }

    @Override
    public void addDormitory(Dormitory dormitory) {
        DormitoryExample dormitoryExample = new DormitoryExample();
        dormitoryExample.createCriteria().andDoorplateEqualTo(dormitory.getDoorplate());
        List<Dormitory> dormitories = dormitoryMapper.selectByExample(dormitoryExample);
        if(CollectionUtils.isNotEmpty(dormitories)){
            throw new ApplicationException("该寝室已存在");
        }
        dormitoryMapper.insertSelective(dormitory);
    }


    @Override
    public void updateDormitory(Dormitory dormitory) {
        dormitoryMapper.updateByPrimaryKeySelective(dormitory);
    }

    @Override
    public void outDormitory(User user) {
        DormitoryExample dormitoryExample = new DormitoryExample();
        dormitoryExample.createCriteria().andIdEqualTo(user.getDormitoryid());
        List<Dormitory> dormitories = dormitoryMapper.selectByExample(dormitoryExample);
        Dormitory dormitory = dormitories.get(0);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(user.getId());
        List<User> users = userMapper.selectByExample(userExample);
        User user1 = users.get(0);
        if(StringUtil.isNotEmptyObject(dormitory.getLeadercode())){
            if(dormitory.getLeadercode().equals(user1.getUsercode())){//清空寝室长信息
                dormitory.setLeadername("");
                dormitory.setLeadercode("");
                dormitoryMapper.updateByPrimaryKeySelective(dormitory);
            }
        }
        user.setDormitoryid(SysParamDetailConstant.DORMITORY_OUT);//退宿单独标志为0
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void inDormitory(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andDormitoryidEqualTo(user.getDormitoryid())
                .andBedEqualTo(user.getBed());
        List<User> users = userMapper.selectByExample(userExample);
        if(CollectionUtils.isNotEmpty(users)){
            throw new ApplicationException("该床位有人了！");
        }else{
            userMapper.updateByPrimaryKeySelective(user);
        }
    }

    @Override
    public void leaderDormitory(User user) {
        DormitoryExample dormitoryExample = new DormitoryExample();
        dormitoryExample.createCriteria().andIdEqualTo(user.getDormitoryid());
        List<Dormitory> dormitories = dormitoryMapper.selectByExample(dormitoryExample);
        Dormitory dormitory = dormitories.get(0);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(user.getId());
        List<User> users = userMapper.selectByExample(userExample);
        User user1 = users.get(0);
        dormitory.setLeadercode(user1.getUsercode());
        dormitory.setLeadername(user1.getUsername());
        dormitoryMapper.updateByPrimaryKeySelective(dormitory);
    }
}
