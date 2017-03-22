package com.bs.service;

import com.bs.common.entity.PageInfo;
import com.bs.dao.entity.Trip;
import com.bs.dao.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */
public interface TripService {

    /**
     * 管理员获取所有离返校列表(可以通过trip的类别查询)
     * @param trip
     * @param pageInfo
     * @return
     */
    List<Trip> tripList(Trip trip, PageInfo pageInfo);
    /**
     * 根据用户code获取离校列表
     * @param userCode
     * @return
     */
    List<Trip> tripListByCode(String userCode, PageInfo pageInfo);

    /**
     * 根据用户code获取未返校的离校列表
     * @param userCode
     * @return
     */
    List<Trip> outListByCode(String userCode,PageInfo pageInfo);


    /**
     * 学生新增离校申请
     * @param trip
     * @param user
     */
    void addTrip(Trip trip,User user);

    /**
     * 学生回校
     * @param id
     */
    void addBack(int id);

}
