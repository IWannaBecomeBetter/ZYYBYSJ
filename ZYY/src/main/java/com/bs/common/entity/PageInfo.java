package com.bs.common.entity;

/**
 * Created by Administrator on 2017/3/15.
 */
public class PageInfo {
    /**
     * 当前页数
     */
    private Integer page;
    /**
     * 一页行数
     */
    private Integer rows;


    public Integer getPage() {
        return this.page != null && this.page.intValue() > 1?Integer.valueOf((this.page.intValue() - 1) * this.rows.intValue()):Integer.valueOf(0);
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
