package com.bs.service;

import com.bs.dao.entity.Dormitory;
import com.bs.dao.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/3/10.
 */
public interface UserServer {
    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 修改密码
     * @param user
     * @param oldPassword
     * @param newPassword
     */
    void changePassword(User user,String oldPassword,String newPassword);

    /**
     * 更新个人信息
     * @param user
     */
    void update(User user);


    /**
     * 根据寝室号获取人员列表
     * @param dormitory
     * @return
     */
    List<User> getListByDormitpryId(Dormitory dormitory);

    /**
     * 获取还未分配寝室的学生列表
     * @return
     */
    List<User> getWithOutDormitory();
}
