package com.bs.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VisitLogExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table visitlog
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table visitlog
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table visitlog
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table visitlog
     *
     * @mbggenerated
     */
    protected int limitClauseStart = -1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table visitlog
     *
     * @mbggenerated
     */
    protected int limitClauseCount = -1;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table visitlog
     *
     * @mbggenerated
     */
    public VisitLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table visitlog
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table visitlog
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table visitlog
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table visitlog
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table visitlog
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table visitlog
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table visitlog
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
     * This method corresponds to the database table visitlog
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
     * This method corresponds to the database table visitlog
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table visitlog
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
     * This method corresponds to the database table visitlog
     *
     * @mbggenerated
     */
    public void setLimitClauseStart(int limitClauseStart) {
        this.limitClauseStart=limitClauseStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table visitlog
     *
     * @mbggenerated
     */
    public int getLimitClauseStart() {
        return limitClauseStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table visitlog
     *
     * @mbggenerated
     */
    public void setLimitClauseCount(int limitClauseCount) {
        this.limitClauseCount=limitClauseCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table visitlog
     *
     * @mbggenerated
     */
    public int getLimitClauseCount() {
        return limitClauseCount;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table visitlog
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

        public Criteria andVisitornameIsNull() {
            addCriterion("visitorname is null");
            return (Criteria) this;
        }

        public Criteria andVisitornameIsNotNull() {
            addCriterion("visitorname is not null");
            return (Criteria) this;
        }

        public Criteria andVisitornameEqualTo(String value) {
            addCriterion("visitorname =", value, "visitorname");
            return (Criteria) this;
        }

        public Criteria andVisitornameNotEqualTo(String value) {
            addCriterion("visitorname <>", value, "visitorname");
            return (Criteria) this;
        }

        public Criteria andVisitornameGreaterThan(String value) {
            addCriterion("visitorname >", value, "visitorname");
            return (Criteria) this;
        }

        public Criteria andVisitornameGreaterThanOrEqualTo(String value) {
            addCriterion("visitorname >=", value, "visitorname");
            return (Criteria) this;
        }

        public Criteria andVisitornameLessThan(String value) {
            addCriterion("visitorname <", value, "visitorname");
            return (Criteria) this;
        }

        public Criteria andVisitornameLessThanOrEqualTo(String value) {
            addCriterion("visitorname <=", value, "visitorname");
            return (Criteria) this;
        }

        public Criteria andVisitornameLike(String value) {
            addCriterion("visitorname like", value, "visitorname");
            return (Criteria) this;
        }

        public Criteria andVisitornameNotLike(String value) {
            addCriterion("visitorname not like", value, "visitorname");
            return (Criteria) this;
        }

        public Criteria andVisitornameIn(List<String> values) {
            addCriterion("visitorname in", values, "visitorname");
            return (Criteria) this;
        }

        public Criteria andVisitornameNotIn(List<String> values) {
            addCriterion("visitorname not in", values, "visitorname");
            return (Criteria) this;
        }

        public Criteria andVisitornameBetween(String value1, String value2) {
            addCriterion("visitorname between", value1, value2, "visitorname");
            return (Criteria) this;
        }

        public Criteria andVisitornameNotBetween(String value1, String value2) {
            addCriterion("visitorname not between", value1, value2, "visitorname");
            return (Criteria) this;
        }

        public Criteria andVisitortelephoneIsNull() {
            addCriterion("visitortelephone is null");
            return (Criteria) this;
        }

        public Criteria andVisitortelephoneIsNotNull() {
            addCriterion("visitortelephone is not null");
            return (Criteria) this;
        }

        public Criteria andVisitortelephoneEqualTo(String value) {
            addCriterion("visitortelephone =", value, "visitortelephone");
            return (Criteria) this;
        }

        public Criteria andVisitortelephoneNotEqualTo(String value) {
            addCriterion("visitortelephone <>", value, "visitortelephone");
            return (Criteria) this;
        }

        public Criteria andVisitortelephoneGreaterThan(String value) {
            addCriterion("visitortelephone >", value, "visitortelephone");
            return (Criteria) this;
        }

        public Criteria andVisitortelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("visitortelephone >=", value, "visitortelephone");
            return (Criteria) this;
        }

        public Criteria andVisitortelephoneLessThan(String value) {
            addCriterion("visitortelephone <", value, "visitortelephone");
            return (Criteria) this;
        }

        public Criteria andVisitortelephoneLessThanOrEqualTo(String value) {
            addCriterion("visitortelephone <=", value, "visitortelephone");
            return (Criteria) this;
        }

        public Criteria andVisitortelephoneLike(String value) {
            addCriterion("visitortelephone like", value, "visitortelephone");
            return (Criteria) this;
        }

        public Criteria andVisitortelephoneNotLike(String value) {
            addCriterion("visitortelephone not like", value, "visitortelephone");
            return (Criteria) this;
        }

        public Criteria andVisitortelephoneIn(List<String> values) {
            addCriterion("visitortelephone in", values, "visitortelephone");
            return (Criteria) this;
        }

        public Criteria andVisitortelephoneNotIn(List<String> values) {
            addCriterion("visitortelephone not in", values, "visitortelephone");
            return (Criteria) this;
        }

        public Criteria andVisitortelephoneBetween(String value1, String value2) {
            addCriterion("visitortelephone between", value1, value2, "visitortelephone");
            return (Criteria) this;
        }

        public Criteria andVisitortelephoneNotBetween(String value1, String value2) {
            addCriterion("visitortelephone not between", value1, value2, "visitortelephone");
            return (Criteria) this;
        }

        public Criteria andVisitobjectIsNull() {
            addCriterion("visitobject is null");
            return (Criteria) this;
        }

        public Criteria andVisitobjectIsNotNull() {
            addCriterion("visitobject is not null");
            return (Criteria) this;
        }

        public Criteria andVisitobjectEqualTo(String value) {
            addCriterion("visitobject =", value, "visitobject");
            return (Criteria) this;
        }

        public Criteria andVisitobjectNotEqualTo(String value) {
            addCriterion("visitobject <>", value, "visitobject");
            return (Criteria) this;
        }

        public Criteria andVisitobjectGreaterThan(String value) {
            addCriterion("visitobject >", value, "visitobject");
            return (Criteria) this;
        }

        public Criteria andVisitobjectGreaterThanOrEqualTo(String value) {
            addCriterion("visitobject >=", value, "visitobject");
            return (Criteria) this;
        }

        public Criteria andVisitobjectLessThan(String value) {
            addCriterion("visitobject <", value, "visitobject");
            return (Criteria) this;
        }

        public Criteria andVisitobjectLessThanOrEqualTo(String value) {
            addCriterion("visitobject <=", value, "visitobject");
            return (Criteria) this;
        }

        public Criteria andVisitobjectLike(String value) {
            addCriterion("visitobject like", value, "visitobject");
            return (Criteria) this;
        }

        public Criteria andVisitobjectNotLike(String value) {
            addCriterion("visitobject not like", value, "visitobject");
            return (Criteria) this;
        }

        public Criteria andVisitobjectIn(List<String> values) {
            addCriterion("visitobject in", values, "visitobject");
            return (Criteria) this;
        }

        public Criteria andVisitobjectNotIn(List<String> values) {
            addCriterion("visitobject not in", values, "visitobject");
            return (Criteria) this;
        }

        public Criteria andVisitobjectBetween(String value1, String value2) {
            addCriterion("visitobject between", value1, value2, "visitobject");
            return (Criteria) this;
        }

        public Criteria andVisitobjectNotBetween(String value1, String value2) {
            addCriterion("visitobject not between", value1, value2, "visitobject");
            return (Criteria) this;
        }

        public Criteria andInDateIsNull() {
            addCriterion("in_date is null");
            return (Criteria) this;
        }

        public Criteria andInDateIsNotNull() {
            addCriterion("in_date is not null");
            return (Criteria) this;
        }

        public Criteria andInDateEqualTo(Date value) {
            addCriterion("in_date =", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateNotEqualTo(Date value) {
            addCriterion("in_date <>", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateGreaterThan(Date value) {
            addCriterion("in_date >", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateGreaterThanOrEqualTo(Date value) {
            addCriterion("in_date >=", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateLessThan(Date value) {
            addCriterion("in_date <", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateLessThanOrEqualTo(Date value) {
            addCriterion("in_date <=", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateIn(List<Date> values) {
            addCriterion("in_date in", values, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateNotIn(List<Date> values) {
            addCriterion("in_date not in", values, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateBetween(Date value1, Date value2) {
            addCriterion("in_date between", value1, value2, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateNotBetween(Date value1, Date value2) {
            addCriterion("in_date not between", value1, value2, "inDate");
            return (Criteria) this;
        }

        public Criteria andOutDateIsNull() {
            addCriterion("out_date is null");
            return (Criteria) this;
        }

        public Criteria andOutDateIsNotNull() {
            addCriterion("out_date is not null");
            return (Criteria) this;
        }

        public Criteria andOutDateEqualTo(Date value) {
            addCriterion("out_date =", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateNotEqualTo(Date value) {
            addCriterion("out_date <>", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateGreaterThan(Date value) {
            addCriterion("out_date >", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateGreaterThanOrEqualTo(Date value) {
            addCriterion("out_date >=", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateLessThan(Date value) {
            addCriterion("out_date <", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateLessThanOrEqualTo(Date value) {
            addCriterion("out_date <=", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateIn(List<Date> values) {
            addCriterion("out_date in", values, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateNotIn(List<Date> values) {
            addCriterion("out_date not in", values, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateBetween(Date value1, Date value2) {
            addCriterion("out_date between", value1, value2, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateNotBetween(Date value1, Date value2) {
            addCriterion("out_date not between", value1, value2, "outDate");
            return (Criteria) this;
        }

        public Criteria andVisitstateIsNull() {
            addCriterion("visitstate is null");
            return (Criteria) this;
        }

        public Criteria andVisitstateIsNotNull() {
            addCriterion("visitstate is not null");
            return (Criteria) this;
        }

        public Criteria andVisitstateEqualTo(String value) {
            addCriterion("visitstate =", value, "visitstate");
            return (Criteria) this;
        }

        public Criteria andVisitstateNotEqualTo(String value) {
            addCriterion("visitstate <>", value, "visitstate");
            return (Criteria) this;
        }

        public Criteria andVisitstateGreaterThan(String value) {
            addCriterion("visitstate >", value, "visitstate");
            return (Criteria) this;
        }

        public Criteria andVisitstateGreaterThanOrEqualTo(String value) {
            addCriterion("visitstate >=", value, "visitstate");
            return (Criteria) this;
        }

        public Criteria andVisitstateLessThan(String value) {
            addCriterion("visitstate <", value, "visitstate");
            return (Criteria) this;
        }

        public Criteria andVisitstateLessThanOrEqualTo(String value) {
            addCriterion("visitstate <=", value, "visitstate");
            return (Criteria) this;
        }

        public Criteria andVisitstateLike(String value) {
            addCriterion("visitstate like", value, "visitstate");
            return (Criteria) this;
        }

        public Criteria andVisitstateNotLike(String value) {
            addCriterion("visitstate not like", value, "visitstate");
            return (Criteria) this;
        }

        public Criteria andVisitstateIn(List<String> values) {
            addCriterion("visitstate in", values, "visitstate");
            return (Criteria) this;
        }

        public Criteria andVisitstateNotIn(List<String> values) {
            addCriterion("visitstate not in", values, "visitstate");
            return (Criteria) this;
        }

        public Criteria andVisitstateBetween(String value1, String value2) {
            addCriterion("visitstate between", value1, value2, "visitstate");
            return (Criteria) this;
        }

        public Criteria andVisitstateNotBetween(String value1, String value2) {
            addCriterion("visitstate not between", value1, value2, "visitstate");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table visitlog
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
     * This class corresponds to the database table visitlog
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