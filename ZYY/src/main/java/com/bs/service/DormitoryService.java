package com.bs.service;

import com.bs.common.entity.PageInfo;
import com.bs.dao.entity.Dormitory;
import com.bs.dao.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */
public interface DormitoryService {
    /**
     * 根据宿舍id查找宿舍信息
     * @param id
     * @return
     */
    Dormitory getById(int id);

    /**
     * 宿舍列表
     * @param dormitory
     * @param pageInfo
     * @return
     */
    List<Dormitory> dormitoryList(Dormitory dormitory,PageInfo pageInfo);

    /**
     * 新增宿舍
     * @param dormitory
     */
    void addDormitory(Dormitory dormitory);

    /**
     * 修改寝室信息
     * @param dormitory
     */
    void updateDormitory(Dormitory dormitory);

    /**
     * 退宿
     * @param user
     */
    void outDormitory(User user);

    /**
     * 入宿
     * @param user
     */
    void inDormitory(User user);

    /**
     * 设置寝室长
     * @param user
     */
    void leaderDormitory(User user);
}
