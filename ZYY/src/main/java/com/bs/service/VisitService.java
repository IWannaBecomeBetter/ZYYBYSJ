package com.bs.service;

import com.bs.common.entity.PageInfo;
import com.bs.dao.entity.VisitLog;

import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
public interface VisitService {

    /**
     * 所有访客来访记录
     * @return
     */
    List<VisitLog> List(VisitLog visitLog,PageInfo pageInfo);

    /**
     * 访客离开记录
     * @return
     */
    List<VisitLog> outList(PageInfo pageInfo);

    /**
     * 添加来访记录
     * @param visitLog
     */
    void addVisit(VisitLog visitLog);

    /**
     * 访客离去
     * @param visitLog
     */
    void visitOut(VisitLog visitLog);
}
