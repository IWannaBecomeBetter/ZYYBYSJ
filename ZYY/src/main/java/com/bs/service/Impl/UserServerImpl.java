package com.bs.service.Impl;

import com.bs.common.constants.SysParamDetailConstant;
import com.bs.common.exception.ApplicationException;
import com.bs.common.util.StringUtil;
import com.bs.dao.entity.Dormitory;
import com.bs.dao.entity.User;
import com.bs.dao.entity.UserExample;
import com.bs.dao.mapping.UserMapper;
import com.bs.service.UserServer;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/10.
 */
@Service
@Transactional
public class UserServerImpl implements UserServer {
    @Autowired
    public UserMapper userMapper;


    @Override
    public User login(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsertypeEqualTo(user.getUsertype())
                .andUsercodeEqualTo(user.getUsercode())
                .andPasswordEqualTo(user.getPassword());
        List<User> users = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(users)) {
            throw new ApplicationException("用户名或密码错误请核对后重试");
        }
        user = users.get(0);
        return user;
    }


    @Override
    public void changePassword(User user,String oldPassword, String newPassword) {
        if(!user.getPassword().equals(oldPassword)){
            throw new ApplicationException("原密码不正确请重试");
        }else{
            user.setPassword(newPassword);
            userMapper.updateByPrimaryKeySelective(user);
        }
    }


    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }


    @Override
    public List<User> getListByDormitpryId(Dormitory dormitory) {
        UserExample userExample = new UserExample();
        if(StringUtil.isNotEmptyObject(dormitory.getId())){
            userExample.createCriteria().andDormitoryidEqualTo(dormitory.getId()).andUsertypeEqualTo(SysParamDetailConstant.USER_STUDENT);
        }
        List<User> users = userMapper.selectByExample(userExample);
        if(CollectionUtils.isNotEmpty(users)){
            return users;
        }else{
            return new ArrayList<User>();
        }
    }

    @Override
    public List<User> getWithOutDormitory() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsertypeEqualTo(SysParamDetailConstant.USER_STUDENT).andDormitoryidEqualTo(SysParamDetailConstant.DORMITORY_OUT);
        List<User> users = userMapper.selectByExample(userExample);
        if(CollectionUtils.isNotEmpty(users)){
            return users;
        }else{
            return new ArrayList<User>();
        }
    }
}
