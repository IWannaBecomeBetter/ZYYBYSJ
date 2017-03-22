package com.bs.common.constants;

/**
 *
 * 原则上常量应该是一些不可变对象 但是例如各种状态信息 不应该在字典数据和常量中维护两份
 * 正常的做法是只在数据字典中维护，通过键值对的方式存在，中间通过公共方法，后台只通过 key 访问
 *
 */
public class SysParamDetailConstant {

    /**
     * 用户类型
     */
    public static final String USER_STUDENT = "0"; // 学生

    public static final String USER_MANAGER = "1"; // 管理员

    /**
     * 维修状态
     */
    public static final String REPAIR_NO = "0"; // 维修状态未完成

    public static final String REPAIR_YES = "1"; // 维修状态已完成

    /**
     * 离校状态
     */
    public static final String TRIP_NO = "0"; // 离校中

    public static final String TRIP_YES = "1"; // 已返校

    /**
     * 物品出入库状态
     */
    public static final String RES_IN = "1"; // 入库

    public static final String RES_OUT = "0"; // 出库

    /**
     * 物品出入库状态
     */
    public static final String VISIT_IN = "1"; // 来访

    public static final String VISIT_OUT = "0"; // 离开

    /**
     *
     */
    public static final Integer DORMITORY_OUT = 0; // 退宿或者没有寝室
}
