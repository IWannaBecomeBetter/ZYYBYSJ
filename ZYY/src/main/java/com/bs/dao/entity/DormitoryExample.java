package com.bs.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class DormitoryExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    protected int limitClauseStart = -1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    protected int limitClauseCount = -1;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    public DormitoryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    public void setLimitClauseStart(int limitClauseStart) {
        this.limitClauseStart=limitClauseStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    public int getLimitClauseStart() {
        return limitClauseStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    public void setLimitClauseCount(int limitClauseCount) {
        this.limitClauseCount=limitClauseCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    public int getLimitClauseCount() {
        return limitClauseCount;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andHeathlevelIsNull() {
            addCriterion("heathlevel is null");
            return (Criteria) this;
        }

        public Criteria andHeathlevelIsNotNull() {
            addCriterion("heathlevel is not null");
            return (Criteria) this;
        }

        public Criteria andHeathlevelEqualTo(String value) {
            addCriterion("heathlevel =", value, "heathlevel");
            return (Criteria) this;
        }

        public Criteria andHeathlevelNotEqualTo(String value) {
            addCriterion("heathlevel <>", value, "heathlevel");
            return (Criteria) this;
        }

        public Criteria andHeathlevelGreaterThan(String value) {
            addCriterion("heathlevel >", value, "heathlevel");
            return (Criteria) this;
        }

        public Criteria andHeathlevelGreaterThanOrEqualTo(String value) {
            addCriterion("heathlevel >=", value, "heathlevel");
            return (Criteria) this;
        }

        public Criteria andHeathlevelLessThan(String value) {
            addCriterion("heathlevel <", value, "heathlevel");
            return (Criteria) this;
        }

        public Criteria andHeathlevelLessThanOrEqualTo(String value) {
            addCriterion("heathlevel <=", value, "heathlevel");
            return (Criteria) this;
        }

        public Criteria andHeathlevelLike(String value) {
            addCriterion("heathlevel like", value, "heathlevel");
            return (Criteria) this;
        }

        public Criteria andHeathlevelNotLike(String value) {
            addCriterion("heathlevel not like", value, "heathlevel");
            return (Criteria) this;
        }

        public Criteria andHeathlevelIn(List<String> values) {
            addCriterion("heathlevel in", values, "heathlevel");
            return (Criteria) this;
        }

        public Criteria andHeathlevelNotIn(List<String> values) {
            addCriterion("heathlevel not in", values, "heathlevel");
            return (Criteria) this;
        }

        public Criteria andHeathlevelBetween(String value1, String value2) {
            addCriterion("heathlevel between", value1, value2, "heathlevel");
            return (Criteria) this;
        }

        public Criteria andHeathlevelNotBetween(String value1, String value2) {
            addCriterion("heathlevel not between", value1, value2, "heathlevel");
            return (Criteria) this;
        }

        public Criteria andElectricityfeesIsNull() {
            addCriterion("electricityfees is null");
            return (Criteria) this;
        }

        public Criteria andElectricityfeesIsNotNull() {
            addCriterion("electricityfees is not null");
            return (Criteria) this;
        }

        public Criteria andElectricityfeesEqualTo(String value) {
            addCriterion("electricityfees =", value, "electricityfees");
            return (Criteria) this;
        }

        public Criteria andElectricityfeesNotEqualTo(String value) {
            addCriterion("electricityfees <>", value, "electricityfees");
            return (Criteria) this;
        }

        public Criteria andElectricityfeesGreaterThan(String value) {
            addCriterion("electricityfees >", value, "electricityfees");
            return (Criteria) this;
        }

        public Criteria andElectricityfeesGreaterThanOrEqualTo(String value) {
            addCriterion("electricityfees >=", value, "electricityfees");
            return (Criteria) this;
        }

        public Criteria andElectricityfeesLessThan(String value) {
            addCriterion("electricityfees <", value, "electricityfees");
            return (Criteria) this;
        }

        public Criteria andElectricityfeesLessThanOrEqualTo(String value) {
            addCriterion("electricityfees <=", value, "electricityfees");
            return (Criteria) this;
        }

        public Criteria andElectricityfeesLike(String value) {
            addCriterion("electricityfees like", value, "electricityfees");
            return (Criteria) this;
        }

        public Criteria andElectricityfeesNotLike(String value) {
            addCriterion("electricityfees not like", value, "electricityfees");
            return (Criteria) this;
        }

        public Criteria andElectricityfeesIn(List<String> values) {
            addCriterion("electricityfees in", values, "electricityfees");
            return (Criteria) this;
        }

        public Criteria andElectricityfeesNotIn(List<String> values) {
            addCriterion("electricityfees not in", values, "electricityfees");
            return (Criteria) this;
        }

        public Criteria andElectricityfeesBetween(String value1, String value2) {
            addCriterion("electricityfees between", value1, value2, "electricityfees");
            return (Criteria) this;
        }

        public Criteria andElectricityfeesNotBetween(String value1, String value2) {
            addCriterion("electricityfees not between", value1, value2, "electricityfees");
            return (Criteria) this;
        }

        public Criteria andWaterfeesIsNull() {
            addCriterion("waterfees is null");
            return (Criteria) this;
        }

        public Criteria andWaterfeesIsNotNull() {
            addCriterion("waterfees is not null");
            return (Criteria) this;
        }

        public Criteria andWaterfeesEqualTo(String value) {
            addCriterion("waterfees =", value, "waterfees");
            return (Criteria) this;
        }

        public Criteria andWaterfeesNotEqualTo(String value) {
            addCriterion("waterfees <>", value, "waterfees");
            return (Criteria) this;
        }

        public Criteria andWaterfeesGreaterThan(String value) {
            addCriterion("waterfees >", value, "waterfees");
            return (Criteria) this;
        }

        public Criteria andWaterfeesGreaterThanOrEqualTo(String value) {
            addCriterion("waterfees >=", value, "waterfees");
            return (Criteria) this;
        }

        public Criteria andWaterfeesLessThan(String value) {
            addCriterion("waterfees <", value, "waterfees");
            return (Criteria) this;
        }

        public Criteria andWaterfeesLessThanOrEqualTo(String value) {
            addCriterion("waterfees <=", value, "waterfees");
            return (Criteria) this;
        }

        public Criteria andWaterfeesLike(String value) {
            addCriterion("waterfees like", value, "waterfees");
            return (Criteria) this;
        }

        public Criteria andWaterfeesNotLike(String value) {
            addCriterion("waterfees not like", value, "waterfees");
            return (Criteria) this;
        }

        public Criteria andWaterfeesIn(List<String> values) {
            addCriterion("waterfees in", values, "waterfees");
            return (Criteria) this;
        }

        public Criteria andWaterfeesNotIn(List<String> values) {
            addCriterion("waterfees not in", values, "waterfees");
            return (Criteria) this;
        }

        public Criteria andWaterfeesBetween(String value1, String value2) {
            addCriterion("waterfees between", value1, value2, "waterfees");
            return (Criteria) this;
        }

        public Criteria andWaterfeesNotBetween(String value1, String value2) {
            addCriterion("waterfees not between", value1, value2, "waterfees");
            return (Criteria) this;
        }

        public Criteria andDoorplateIsNull() {
            addCriterion("doorplate is null");
            return (Criteria) this;
        }

        public Criteria andDoorplateIsNotNull() {
            addCriterion("doorplate is not null");
            return (Criteria) this;
        }

        public Criteria andDoorplateEqualTo(String value) {
            addCriterion("doorplate =", value, "doorplate");
            return (Criteria) this;
        }

        public Criteria andDoorplateNotEqualTo(String value) {
            addCriterion("doorplate <>", value, "doorplate");
            return (Criteria) this;
        }

        public Criteria andDoorplateGreaterThan(String value) {
            addCriterion("doorplate >", value, "doorplate");
            return (Criteria) this;
        }

        public Criteria andDoorplateGreaterThanOrEqualTo(String value) {
            addCriterion("doorplate >=", value, "doorplate");
            return (Criteria) this;
        }

        public Criteria andDoorplateLessThan(String value) {
            addCriterion("doorplate <", value, "doorplate");
            return (Criteria) this;
        }

        public Criteria andDoorplateLessThanOrEqualTo(String value) {
            addCriterion("doorplate <=", value, "doorplate");
            return (Criteria) this;
        }

        public Criteria andDoorplateLike(String value) {
            addCriterion("doorplate like", value, "doorplate");
            return (Criteria) this;
        }

        public Criteria andDoorplateNotLike(String value) {
            addCriterion("doorplate not like", value, "doorplate");
            return (Criteria) this;
        }

        public Criteria andDoorplateIn(List<String> values) {
            addCriterion("doorplate in", values, "doorplate");
            return (Criteria) this;
        }

        public Criteria andDoorplateNotIn(List<String> values) {
            addCriterion("doorplate not in", values, "doorplate");
            return (Criteria) this;
        }

        public Criteria andDoorplateBetween(String value1, String value2) {
            addCriterion("doorplate between", value1, value2, "doorplate");
            return (Criteria) this;
        }

        public Criteria andDoorplateNotBetween(String value1, String value2) {
            addCriterion("doorplate not between", value1, value2, "doorplate");
            return (Criteria) this;
        }

        public Criteria andLeadercodeIsNull() {
            addCriterion("leadercode is null");
            return (Criteria) this;
        }

        public Criteria andLeadercodeIsNotNull() {
            addCriterion("leadercode is not null");
            return (Criteria) this;
        }

        public Criteria andLeadercodeEqualTo(String value) {
            addCriterion("leadercode =", value, "leadercode");
            return (Criteria) this;
        }

        public Criteria andLeadercodeNotEqualTo(String value) {
            addCriterion("leadercode <>", value, "leadercode");
            return (Criteria) this;
        }

        public Criteria andLeadercodeGreaterThan(String value) {
            addCriterion("leadercode >", value, "leadercode");
            return (Criteria) this;
        }

        public Criteria andLeadercodeGreaterThanOrEqualTo(String value) {
            addCriterion("leadercode >=", value, "leadercode");
            return (Criteria) this;
        }

        public Criteria andLeadercodeLessThan(String value) {
            addCriterion("leadercode <", value, "leadercode");
            return (Criteria) this;
        }

        public Criteria andLeadercodeLessThanOrEqualTo(String value) {
            addCriterion("leadercode <=", value, "leadercode");
            return (Criteria) this;
        }

        public Criteria andLeadercodeLike(String value) {
            addCriterion("leadercode like", value, "leadercode");
            return (Criteria) this;
        }

        public Criteria andLeadercodeNotLike(String value) {
            addCriterion("leadercode not like", value, "leadercode");
            return (Criteria) this;
        }

        public Criteria andLeadercodeIn(List<String> values) {
            addCriterion("leadercode in", values, "leadercode");
            return (Criteria) this;
        }

        public Criteria andLeadercodeNotIn(List<String> values) {
            addCriterion("leadercode not in", values, "leadercode");
            return (Criteria) this;
        }

        public Criteria andLeadercodeBetween(String value1, String value2) {
            addCriterion("leadercode between", value1, value2, "leadercode");
            return (Criteria) this;
        }

        public Criteria andLeadercodeNotBetween(String value1, String value2) {
            addCriterion("leadercode not between", value1, value2, "leadercode");
            return (Criteria) this;
        }

        public Criteria andLeadernameIsNull() {
            addCriterion("leadername is null");
            return (Criteria) this;
        }

        public Criteria andLeadernameIsNotNull() {
            addCriterion("leadername is not null");
            return (Criteria) this;
        }

        public Criteria andLeadernameEqualTo(String value) {
            addCriterion("leadername =", value, "leadername");
            return (Criteria) this;
        }

        public Criteria andLeadernameNotEqualTo(String value) {
            addCriterion("leadername <>", value, "leadername");
            return (Criteria) this;
        }

        public Criteria andLeadernameGreaterThan(String value) {
            addCriterion("leadername >", value, "leadername");
            return (Criteria) this;
        }

        public Criteria andLeadernameGreaterThanOrEqualTo(String value) {
            addCriterion("leadername >=", value, "leadername");
            return (Criteria) this;
        }

        public Criteria andLeadernameLessThan(String value) {
            addCriterion("leadername <", value, "leadername");
            return (Criteria) this;
        }

        public Criteria andLeadernameLessThanOrEqualTo(String value) {
            addCriterion("leadername <=", value, "leadername");
            return (Criteria) this;
        }

        public Criteria andLeadernameLike(String value) {
            addCriterion("leadername like", value, "leadername");
            return (Criteria) this;
        }

        public Criteria andLeadernameNotLike(String value) {
            addCriterion("leadername not like", value, "leadername");
            return (Criteria) this;
        }

        public Criteria andLeadernameIn(List<String> values) {
            addCriterion("leadername in", values, "leadername");
            return (Criteria) this;
        }

        public Criteria andLeadernameNotIn(List<String> values) {
            addCriterion("leadername not in", values, "leadername");
            return (Criteria) this;
        }

        public Criteria andLeadernameBetween(String value1, String value2) {
            addCriterion("leadername between", value1, value2, "leadername");
            return (Criteria) this;
        }

        public Criteria andLeadernameNotBetween(String value1, String value2) {
            addCriterion("leadername not between", value1, value2, "leadername");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dormitory
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}