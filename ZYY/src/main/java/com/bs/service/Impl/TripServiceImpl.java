package com.bs.service.Impl;

import com.bs.common.constants.SysParamDetailConstant;
import com.bs.common.entity.PageInfo;
import com.bs.common.util.DateUtil;
import com.bs.common.util.StringUtil;
import com.bs.dao.entity.Trip;
import com.bs.dao.entity.TripExample;
import com.bs.dao.entity.User;
import com.bs.dao.mapping.TripMapper;
import com.bs.service.TripService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */
@Service
@Transactional
public class TripServiceImpl implements TripService{
    @Autowired
    private TripMapper tripMapper;

    @Override
    public List<Trip> tripList(Trip trip, PageInfo pageInfo) {
        TripExample tripExample = new TripExample();
        TripExample.Criteria criteria = tripExample.createCriteria();
        if(StringUtil.isNotEmptyObject(trip.getTripstate())){//离返校状态
            criteria.andTripstateEqualTo(trip.getTripstate());
        }
        if(StringUtil.isNotEmptyObject(trip.getOutDate())){//离校时间
            criteria.andOutDateGreaterThanOrEqualTo(trip.getOutDate());
        }
        if(StringUtil.isNotEmptyObject(trip.getInDate())){//返校时间
            criteria.andInDateLessThanOrEqualTo(trip.getInDate());
        }
        tripExample.setLimitClauseStart(pageInfo.getPage());
        tripExample.setLimitClauseCount(pageInfo.getRows());
        tripExample.setOrderByClause("out_date desc");
        List<Trip> trips = tripMapper.selectByExample(tripExample);
        if(CollectionUtils.isNotEmpty(trips)){
            return trips;
        }else{
            return new ArrayList<Trip>();
        }
    }

    @Override
    public List<Trip> tripListByCode(String userCode, PageInfo pageInfo) {
        TripExample tripExample = new TripExample();
        tripExample.createCriteria().andUsercodeEqualTo(userCode);
        tripExample.setLimitClauseStart(pageInfo.getPage());
        tripExample.setLimitClauseCount(pageInfo.getRows());
        tripExample.setOrderByClause("out_date desc");
        List<Trip> trips = tripMapper.selectByExample(tripExample);
        if(CollectionUtils.isNotEmpty(trips)){
            return trips;
        }else{
            return null;
        }
    }

    @Override
    public List<Trip> outListByCode(String userCode,PageInfo pageInfo) {
        TripExample tripExample = new TripExample();
        tripExample.createCriteria().andUsercodeEqualTo(userCode).andTripstateEqualTo(SysParamDetailConstant.TRIP_NO);
        tripExample.setLimitClauseStart(pageInfo.getPage());
        tripExample.setLimitClauseCount(pageInfo.getRows());
        tripExample.setOrderByClause("out_date desc");
        List<Trip> trips = tripMapper.selectByExample(tripExample);
        if(CollectionUtils.isNotEmpty(trips)){
            return trips;
        }else{
            return null;
        }
    }

    @Override
    public void addTrip(Trip trip, User user) {
        trip.setTelephone(user.getTelephone());
        trip.setTripstate(SysParamDetailConstant.TRIP_NO);
        trip.setUsercode(user.getUsercode());
        trip.setUsername(user.getUsername());
        tripMapper.insertSelective(trip);
    }

    @Override
    public void addBack(int id) {
        Trip trip = new Trip();
        trip.setId(id);
        trip.setInDate(DateUtil.getTimestamp());
        trip.setTripstate(SysParamDetailConstant.TRIP_YES);
        tripMapper.updateByPrimaryKeySelective(trip);
    }
}
