package com.dc.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author mybatis-generator
 * date:2019/12/15 03:09
 */
public class UserResumeDetailCriteria {
    /** 
     * 排序字段
    */
    protected String orderByClause;

    /** 
     * 过滤重复数据
    */
    protected boolean distinct;

    /** 
     * 查询条件
    */
    protected List<Criteria> oredCriteria;

    /** 
     * 构造查询条件
     */
    public UserResumeDetailCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /** 
     * 设置排序字段
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /** 
     * 获取排序字段
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /** 
     * 设置过滤重复数据
     * @param distinct 是否过滤重复数据
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /** 
     * 是否过滤重复数据
     */
    public boolean isDistinct() {
        return distinct;
    }

    /** 
     * 获取当前的查询条件实例
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /** 
     * 增加或者的查询条件,用于构建或者查询
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /** 
     * 创建一个新的或者查询条件
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /** 
     * 创建一个查询条件
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /** 
     * 内部构建查询条件对象
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /** 
     * 清除查询条件
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 用户简历详细信息表lds_user_resume_detail
     */
    protected abstract static class BaseCriteria {
        protected List<Criterion> criteria;

        protected BaseCriteria() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdKeyIsNull() {
            addCriterion("id_key is null");
            return (Criteria) this;
        }

        public Criteria andIdKeyIsNotNull() {
            addCriterion("id_key is not null");
            return (Criteria) this;
        }

        public Criteria andIdKeyEqualTo(Long value) {
            addCriterion("id_key =", value, "idKey");
            return (Criteria) this;
        }

        public Criteria andIdKeyNotEqualTo(Long value) {
            addCriterion("id_key <>", value, "idKey");
            return (Criteria) this;
        }

        public Criteria andIdKeyGreaterThan(Long value) {
            addCriterion("id_key >", value, "idKey");
            return (Criteria) this;
        }

        public Criteria andIdKeyGreaterThanOrEqualTo(Long value) {
            addCriterion("id_key >=", value, "idKey");
            return (Criteria) this;
        }

        public Criteria andIdKeyLessThan(Long value) {
            addCriterion("id_key <", value, "idKey");
            return (Criteria) this;
        }

        public Criteria andIdKeyLessThanOrEqualTo(Long value) {
            addCriterion("id_key <=", value, "idKey");
            return (Criteria) this;
        }

        public Criteria andIdKeyIn(List<Long> values) {
            addCriterion("id_key in", values, "idKey");
            return (Criteria) this;
        }

        public Criteria andIdKeyNotIn(List<Long> values) {
            addCriterion("id_key not in", values, "idKey");
            return (Criteria) this;
        }

        public Criteria andIdKeyBetween(Long value1, Long value2) {
            addCriterion("id_key between", value1, value2, "idKey");
            return (Criteria) this;
        }

        public Criteria andIdKeyNotBetween(Long value1, Long value2) {
            addCriterion("id_key not between", value1, value2, "idKey");
            return (Criteria) this;
        }

        public Criteria andAnnualIncomeIsNull() {
            addCriterion("annual_income is null");
            return (Criteria) this;
        }

        public Criteria andAnnualIncomeIsNotNull() {
            addCriterion("annual_income is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualIncomeEqualTo(Double value) {
            addCriterion("annual_income =", value, "annualIncome");
            return (Criteria) this;
        }

        public Criteria andAnnualIncomeNotEqualTo(Double value) {
            addCriterion("annual_income <>", value, "annualIncome");
            return (Criteria) this;
        }

        public Criteria andAnnualIncomeGreaterThan(Double value) {
            addCriterion("annual_income >", value, "annualIncome");
            return (Criteria) this;
        }

        public Criteria andAnnualIncomeGreaterThanOrEqualTo(Double value) {
            addCriterion("annual_income >=", value, "annualIncome");
            return (Criteria) this;
        }

        public Criteria andAnnualIncomeLessThan(Double value) {
            addCriterion("annual_income <", value, "annualIncome");
            return (Criteria) this;
        }

        public Criteria andAnnualIncomeLessThanOrEqualTo(Double value) {
            addCriterion("annual_income <=", value, "annualIncome");
            return (Criteria) this;
        }

        public Criteria andAnnualIncomeIn(List<Double> values) {
            addCriterion("annual_income in", values, "annualIncome");
            return (Criteria) this;
        }

        public Criteria andAnnualIncomeNotIn(List<Double> values) {
            addCriterion("annual_income not in", values, "annualIncome");
            return (Criteria) this;
        }

        public Criteria andAnnualIncomeBetween(Double value1, Double value2) {
            addCriterion("annual_income between", value1, value2, "annualIncome");
            return (Criteria) this;
        }

        public Criteria andAnnualIncomeNotBetween(Double value1, Double value2) {
            addCriterion("annual_income not between", value1, value2, "annualIncome");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("real_name in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andPhoneNoIsNull() {
            addCriterion("phone_no is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNoIsNotNull() {
            addCriterion("phone_no is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNoEqualTo(String value) {
            addCriterion("phone_no =", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoNotEqualTo(String value) {
            addCriterion("phone_no <>", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoGreaterThan(String value) {
            addCriterion("phone_no >", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoGreaterThanOrEqualTo(String value) {
            addCriterion("phone_no >=", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoLessThan(String value) {
            addCriterion("phone_no <", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoLessThanOrEqualTo(String value) {
            addCriterion("phone_no <=", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoLike(String value) {
            addCriterion("phone_no like", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoNotLike(String value) {
            addCriterion("phone_no not like", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoIn(List<String> values) {
            addCriterion("phone_no in", values, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoNotIn(List<String> values) {
            addCriterion("phone_no not in", values, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoBetween(String value1, String value2) {
            addCriterion("phone_no between", value1, value2, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoNotBetween(String value1, String value2) {
            addCriterion("phone_no not between", value1, value2, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBeginWorkDateIsNull() {
            addCriterion("begin_work_date is null");
            return (Criteria) this;
        }

        public Criteria andBeginWorkDateIsNotNull() {
            addCriterion("begin_work_date is not null");
            return (Criteria) this;
        }

        public Criteria andBeginWorkDateEqualTo(Date value) {
            addCriterionForJDBCDate("begin_work_date =", value, "beginWorkDate");
            return (Criteria) this;
        }

        public Criteria andBeginWorkDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("begin_work_date <>", value, "beginWorkDate");
            return (Criteria) this;
        }

        public Criteria andBeginWorkDateGreaterThan(Date value) {
            addCriterionForJDBCDate("begin_work_date >", value, "beginWorkDate");
            return (Criteria) this;
        }

        public Criteria andBeginWorkDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("begin_work_date >=", value, "beginWorkDate");
            return (Criteria) this;
        }

        public Criteria andBeginWorkDateLessThan(Date value) {
            addCriterionForJDBCDate("begin_work_date <", value, "beginWorkDate");
            return (Criteria) this;
        }

        public Criteria andBeginWorkDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("begin_work_date <=", value, "beginWorkDate");
            return (Criteria) this;
        }

        public Criteria andBeginWorkDateIn(List<Date> values) {
            addCriterionForJDBCDate("begin_work_date in", values, "beginWorkDate");
            return (Criteria) this;
        }

        public Criteria andBeginWorkDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("begin_work_date not in", values, "beginWorkDate");
            return (Criteria) this;
        }

        public Criteria andBeginWorkDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("begin_work_date between", value1, value2, "beginWorkDate");
            return (Criteria) this;
        }

        public Criteria andBeginWorkDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("begin_work_date not between", value1, value2, "beginWorkDate");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionIsNull() {
            addCriterion("current_position is null");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionIsNotNull() {
            addCriterion("current_position is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionEqualTo(String value) {
            addCriterion("current_position =", value, "currentPosition");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionNotEqualTo(String value) {
            addCriterion("current_position <>", value, "currentPosition");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionGreaterThan(String value) {
            addCriterion("current_position >", value, "currentPosition");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionGreaterThanOrEqualTo(String value) {
            addCriterion("current_position >=", value, "currentPosition");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionLessThan(String value) {
            addCriterion("current_position <", value, "currentPosition");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionLessThanOrEqualTo(String value) {
            addCriterion("current_position <=", value, "currentPosition");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionLike(String value) {
            addCriterion("current_position like", value, "currentPosition");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionNotLike(String value) {
            addCriterion("current_position not like", value, "currentPosition");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionIn(List<String> values) {
            addCriterion("current_position in", values, "currentPosition");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionNotIn(List<String> values) {
            addCriterion("current_position not in", values, "currentPosition");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionBetween(String value1, String value2) {
            addCriterion("current_position between", value1, value2, "currentPosition");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionNotBetween(String value1, String value2) {
            addCriterion("current_position not between", value1, value2, "currentPosition");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsIsNull() {
            addCriterion("working_years is null");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsIsNotNull() {
            addCriterion("working_years is not null");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsEqualTo(Byte value) {
            addCriterion("working_years =", value, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsNotEqualTo(Byte value) {
            addCriterion("working_years <>", value, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsGreaterThan(Byte value) {
            addCriterion("working_years >", value, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsGreaterThanOrEqualTo(Byte value) {
            addCriterion("working_years >=", value, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsLessThan(Byte value) {
            addCriterion("working_years <", value, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsLessThanOrEqualTo(Byte value) {
            addCriterion("working_years <=", value, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsIn(List<Byte> values) {
            addCriterion("working_years in", values, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsNotIn(List<Byte> values) {
            addCriterion("working_years not in", values, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsBetween(Byte value1, Byte value2) {
            addCriterion("working_years between", value1, value2, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsNotBetween(Byte value1, Byte value2) {
            addCriterion("working_years not between", value1, value2, "workingYears");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyIsNull() {
            addCriterion("current_company is null");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyIsNotNull() {
            addCriterion("current_company is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyEqualTo(String value) {
            addCriterion("current_company =", value, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyNotEqualTo(String value) {
            addCriterion("current_company <>", value, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyGreaterThan(String value) {
            addCriterion("current_company >", value, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("current_company >=", value, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyLessThan(String value) {
            addCriterion("current_company <", value, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyLessThanOrEqualTo(String value) {
            addCriterion("current_company <=", value, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyLike(String value) {
            addCriterion("current_company like", value, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyNotLike(String value) {
            addCriterion("current_company not like", value, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyIn(List<String> values) {
            addCriterion("current_company in", values, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyNotIn(List<String> values) {
            addCriterion("current_company not in", values, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyBetween(String value1, String value2) {
            addCriterion("current_company between", value1, value2, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyNotBetween(String value1, String value2) {
            addCriterion("current_company not between", value1, value2, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andJobStatusIsNull() {
            addCriterion("job_status is null");
            return (Criteria) this;
        }

        public Criteria andJobStatusIsNotNull() {
            addCriterion("job_status is not null");
            return (Criteria) this;
        }

        public Criteria andJobStatusEqualTo(String value) {
            addCriterion("job_status =", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusNotEqualTo(String value) {
            addCriterion("job_status <>", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusGreaterThan(String value) {
            addCriterion("job_status >", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusGreaterThanOrEqualTo(String value) {
            addCriterion("job_status >=", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusLessThan(String value) {
            addCriterion("job_status <", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusLessThanOrEqualTo(String value) {
            addCriterion("job_status <=", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusLike(String value) {
            addCriterion("job_status like", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusNotLike(String value) {
            addCriterion("job_status not like", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusIn(List<String> values) {
            addCriterion("job_status in", values, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusNotIn(List<String> values) {
            addCriterion("job_status not in", values, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusBetween(String value1, String value2) {
            addCriterion("job_status between", value1, value2, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusNotBetween(String value1, String value2) {
            addCriterion("job_status not between", value1, value2, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andHomeAddressIsNull() {
            addCriterion("home_address is null");
            return (Criteria) this;
        }

        public Criteria andHomeAddressIsNotNull() {
            addCriterion("home_address is not null");
            return (Criteria) this;
        }

        public Criteria andHomeAddressEqualTo(String value) {
            addCriterion("home_address =", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotEqualTo(String value) {
            addCriterion("home_address <>", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressGreaterThan(String value) {
            addCriterion("home_address >", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressGreaterThanOrEqualTo(String value) {
            addCriterion("home_address >=", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressLessThan(String value) {
            addCriterion("home_address <", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressLessThanOrEqualTo(String value) {
            addCriterion("home_address <=", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressLike(String value) {
            addCriterion("home_address like", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotLike(String value) {
            addCriterion("home_address not like", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressIn(List<String> values) {
            addCriterion("home_address in", values, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotIn(List<String> values) {
            addCriterion("home_address not in", values, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressBetween(String value1, String value2) {
            addCriterion("home_address between", value1, value2, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotBetween(String value1, String value2) {
            addCriterion("home_address not between", value1, value2, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andResidentialAddressIsNull() {
            addCriterion("residential_address is null");
            return (Criteria) this;
        }

        public Criteria andResidentialAddressIsNotNull() {
            addCriterion("residential_address is not null");
            return (Criteria) this;
        }

        public Criteria andResidentialAddressEqualTo(String value) {
            addCriterion("residential_address =", value, "residentialAddress");
            return (Criteria) this;
        }

        public Criteria andResidentialAddressNotEqualTo(String value) {
            addCriterion("residential_address <>", value, "residentialAddress");
            return (Criteria) this;
        }

        public Criteria andResidentialAddressGreaterThan(String value) {
            addCriterion("residential_address >", value, "residentialAddress");
            return (Criteria) this;
        }

        public Criteria andResidentialAddressGreaterThanOrEqualTo(String value) {
            addCriterion("residential_address >=", value, "residentialAddress");
            return (Criteria) this;
        }

        public Criteria andResidentialAddressLessThan(String value) {
            addCriterion("residential_address <", value, "residentialAddress");
            return (Criteria) this;
        }

        public Criteria andResidentialAddressLessThanOrEqualTo(String value) {
            addCriterion("residential_address <=", value, "residentialAddress");
            return (Criteria) this;
        }

        public Criteria andResidentialAddressLike(String value) {
            addCriterion("residential_address like", value, "residentialAddress");
            return (Criteria) this;
        }

        public Criteria andResidentialAddressNotLike(String value) {
            addCriterion("residential_address not like", value, "residentialAddress");
            return (Criteria) this;
        }

        public Criteria andResidentialAddressIn(List<String> values) {
            addCriterion("residential_address in", values, "residentialAddress");
            return (Criteria) this;
        }

        public Criteria andResidentialAddressNotIn(List<String> values) {
            addCriterion("residential_address not in", values, "residentialAddress");
            return (Criteria) this;
        }

        public Criteria andResidentialAddressBetween(String value1, String value2) {
            addCriterion("residential_address between", value1, value2, "residentialAddress");
            return (Criteria) this;
        }

        public Criteria andResidentialAddressNotBetween(String value1, String value2) {
            addCriterion("residential_address not between", value1, value2, "residentialAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredIsNull() {
            addCriterion("registered is null");
            return (Criteria) this;
        }

        public Criteria andRegisteredIsNotNull() {
            addCriterion("registered is not null");
            return (Criteria) this;
        }

        public Criteria andRegisteredEqualTo(String value) {
            addCriterion("registered =", value, "registered");
            return (Criteria) this;
        }

        public Criteria andRegisteredNotEqualTo(String value) {
            addCriterion("registered <>", value, "registered");
            return (Criteria) this;
        }

        public Criteria andRegisteredGreaterThan(String value) {
            addCriterion("registered >", value, "registered");
            return (Criteria) this;
        }

        public Criteria andRegisteredGreaterThanOrEqualTo(String value) {
            addCriterion("registered >=", value, "registered");
            return (Criteria) this;
        }

        public Criteria andRegisteredLessThan(String value) {
            addCriterion("registered <", value, "registered");
            return (Criteria) this;
        }

        public Criteria andRegisteredLessThanOrEqualTo(String value) {
            addCriterion("registered <=", value, "registered");
            return (Criteria) this;
        }

        public Criteria andRegisteredLike(String value) {
            addCriterion("registered like", value, "registered");
            return (Criteria) this;
        }

        public Criteria andRegisteredNotLike(String value) {
            addCriterion("registered not like", value, "registered");
            return (Criteria) this;
        }

        public Criteria andRegisteredIn(List<String> values) {
            addCriterion("registered in", values, "registered");
            return (Criteria) this;
        }

        public Criteria andRegisteredNotIn(List<String> values) {
            addCriterion("registered not in", values, "registered");
            return (Criteria) this;
        }

        public Criteria andRegisteredBetween(String value1, String value2) {
            addCriterion("registered between", value1, value2, "registered");
            return (Criteria) this;
        }

        public Criteria andRegisteredNotBetween(String value1, String value2) {
            addCriterion("registered not between", value1, value2, "registered");
            return (Criteria) this;
        }

        public Criteria andZipcodeIsNull() {
            addCriterion("zipcode is null");
            return (Criteria) this;
        }

        public Criteria andZipcodeIsNotNull() {
            addCriterion("zipcode is not null");
            return (Criteria) this;
        }

        public Criteria andZipcodeEqualTo(String value) {
            addCriterion("zipcode =", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotEqualTo(String value) {
            addCriterion("zipcode <>", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeGreaterThan(String value) {
            addCriterion("zipcode >", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeGreaterThanOrEqualTo(String value) {
            addCriterion("zipcode >=", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeLessThan(String value) {
            addCriterion("zipcode <", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeLessThanOrEqualTo(String value) {
            addCriterion("zipcode <=", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeLike(String value) {
            addCriterion("zipcode like", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotLike(String value) {
            addCriterion("zipcode not like", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeIn(List<String> values) {
            addCriterion("zipcode in", values, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotIn(List<String> values) {
            addCriterion("zipcode not in", values, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeBetween(String value1, String value2) {
            addCriterion("zipcode between", value1, value2, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotBetween(String value1, String value2) {
            addCriterion("zipcode not between", value1, value2, "zipcode");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIsNull() {
            addCriterion("marital_status is null");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIsNotNull() {
            addCriterion("marital_status is not null");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusEqualTo(String value) {
            addCriterion("marital_status =", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotEqualTo(String value) {
            addCriterion("marital_status <>", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusGreaterThan(String value) {
            addCriterion("marital_status >", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("marital_status >=", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLessThan(String value) {
            addCriterion("marital_status <", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLessThanOrEqualTo(String value) {
            addCriterion("marital_status <=", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLike(String value) {
            addCriterion("marital_status like", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotLike(String value) {
            addCriterion("marital_status not like", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIn(List<String> values) {
            addCriterion("marital_status in", values, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotIn(List<String> values) {
            addCriterion("marital_status not in", values, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusBetween(String value1, String value2) {
            addCriterion("marital_status between", value1, value2, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotBetween(String value1, String value2) {
            addCriterion("marital_status not between", value1, value2, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andIdTypeIsNull() {
            addCriterion("id_type is null");
            return (Criteria) this;
        }

        public Criteria andIdTypeIsNotNull() {
            addCriterion("id_type is not null");
            return (Criteria) this;
        }

        public Criteria andIdTypeEqualTo(String value) {
            addCriterion("id_type =", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotEqualTo(String value) {
            addCriterion("id_type <>", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeGreaterThan(String value) {
            addCriterion("id_type >", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeGreaterThanOrEqualTo(String value) {
            addCriterion("id_type >=", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeLessThan(String value) {
            addCriterion("id_type <", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeLessThanOrEqualTo(String value) {
            addCriterion("id_type <=", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeLike(String value) {
            addCriterion("id_type like", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotLike(String value) {
            addCriterion("id_type not like", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeIn(List<String> values) {
            addCriterion("id_type in", values, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotIn(List<String> values) {
            addCriterion("id_type not in", values, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeBetween(String value1, String value2) {
            addCriterion("id_type between", value1, value2, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotBetween(String value1, String value2) {
            addCriterion("id_type not between", value1, value2, "idType");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNull() {
            addCriterion("id_number is null");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNotNull() {
            addCriterion("id_number is not null");
            return (Criteria) this;
        }

        public Criteria andIdNumberEqualTo(String value) {
            addCriterion("id_number =", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotEqualTo(String value) {
            addCriterion("id_number <>", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThan(String value) {
            addCriterion("id_number >", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThanOrEqualTo(String value) {
            addCriterion("id_number >=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThan(String value) {
            addCriterion("id_number <", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThanOrEqualTo(String value) {
            addCriterion("id_number <=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLike(String value) {
            addCriterion("id_number like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotLike(String value) {
            addCriterion("id_number not like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberIn(List<String> values) {
            addCriterion("id_number in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotIn(List<String> values) {
            addCriterion("id_number not in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberBetween(String value1, String value2) {
            addCriterion("id_number between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotBetween(String value1, String value2) {
            addCriterion("id_number not between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusIsNull() {
            addCriterion("political_status is null");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusIsNotNull() {
            addCriterion("political_status is not null");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusEqualTo(String value) {
            addCriterion("political_status =", value, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusNotEqualTo(String value) {
            addCriterion("political_status <>", value, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusGreaterThan(String value) {
            addCriterion("political_status >", value, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("political_status >=", value, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusLessThan(String value) {
            addCriterion("political_status <", value, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusLessThanOrEqualTo(String value) {
            addCriterion("political_status <=", value, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusLike(String value) {
            addCriterion("political_status like", value, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusNotLike(String value) {
            addCriterion("political_status not like", value, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusIn(List<String> values) {
            addCriterion("political_status in", values, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusNotIn(List<String> values) {
            addCriterion("political_status not in", values, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusBetween(String value1, String value2) {
            addCriterion("political_status between", value1, value2, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusNotBetween(String value1, String value2) {
            addCriterion("political_status not between", value1, value2, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andOtherContactTypeIsNull() {
            addCriterion("other_contact_type is null");
            return (Criteria) this;
        }

        public Criteria andOtherContactTypeIsNotNull() {
            addCriterion("other_contact_type is not null");
            return (Criteria) this;
        }

        public Criteria andOtherContactTypeEqualTo(String value) {
            addCriterion("other_contact_type =", value, "otherContactType");
            return (Criteria) this;
        }

        public Criteria andOtherContactTypeNotEqualTo(String value) {
            addCriterion("other_contact_type <>", value, "otherContactType");
            return (Criteria) this;
        }

        public Criteria andOtherContactTypeGreaterThan(String value) {
            addCriterion("other_contact_type >", value, "otherContactType");
            return (Criteria) this;
        }

        public Criteria andOtherContactTypeGreaterThanOrEqualTo(String value) {
            addCriterion("other_contact_type >=", value, "otherContactType");
            return (Criteria) this;
        }

        public Criteria andOtherContactTypeLessThan(String value) {
            addCriterion("other_contact_type <", value, "otherContactType");
            return (Criteria) this;
        }

        public Criteria andOtherContactTypeLessThanOrEqualTo(String value) {
            addCriterion("other_contact_type <=", value, "otherContactType");
            return (Criteria) this;
        }

        public Criteria andOtherContactTypeLike(String value) {
            addCriterion("other_contact_type like", value, "otherContactType");
            return (Criteria) this;
        }

        public Criteria andOtherContactTypeNotLike(String value) {
            addCriterion("other_contact_type not like", value, "otherContactType");
            return (Criteria) this;
        }

        public Criteria andOtherContactTypeIn(List<String> values) {
            addCriterion("other_contact_type in", values, "otherContactType");
            return (Criteria) this;
        }

        public Criteria andOtherContactTypeNotIn(List<String> values) {
            addCriterion("other_contact_type not in", values, "otherContactType");
            return (Criteria) this;
        }

        public Criteria andOtherContactTypeBetween(String value1, String value2) {
            addCriterion("other_contact_type between", value1, value2, "otherContactType");
            return (Criteria) this;
        }

        public Criteria andOtherContactTypeNotBetween(String value1, String value2) {
            addCriterion("other_contact_type not between", value1, value2, "otherContactType");
            return (Criteria) this;
        }

        public Criteria andOtherNumberIsNull() {
            addCriterion("other_number is null");
            return (Criteria) this;
        }

        public Criteria andOtherNumberIsNotNull() {
            addCriterion("other_number is not null");
            return (Criteria) this;
        }

        public Criteria andOtherNumberEqualTo(String value) {
            addCriterion("other_number =", value, "otherNumber");
            return (Criteria) this;
        }

        public Criteria andOtherNumberNotEqualTo(String value) {
            addCriterion("other_number <>", value, "otherNumber");
            return (Criteria) this;
        }

        public Criteria andOtherNumberGreaterThan(String value) {
            addCriterion("other_number >", value, "otherNumber");
            return (Criteria) this;
        }

        public Criteria andOtherNumberGreaterThanOrEqualTo(String value) {
            addCriterion("other_number >=", value, "otherNumber");
            return (Criteria) this;
        }

        public Criteria andOtherNumberLessThan(String value) {
            addCriterion("other_number <", value, "otherNumber");
            return (Criteria) this;
        }

        public Criteria andOtherNumberLessThanOrEqualTo(String value) {
            addCriterion("other_number <=", value, "otherNumber");
            return (Criteria) this;
        }

        public Criteria andOtherNumberLike(String value) {
            addCriterion("other_number like", value, "otherNumber");
            return (Criteria) this;
        }

        public Criteria andOtherNumberNotLike(String value) {
            addCriterion("other_number not like", value, "otherNumber");
            return (Criteria) this;
        }

        public Criteria andOtherNumberIn(List<String> values) {
            addCriterion("other_number in", values, "otherNumber");
            return (Criteria) this;
        }

        public Criteria andOtherNumberNotIn(List<String> values) {
            addCriterion("other_number not in", values, "otherNumber");
            return (Criteria) this;
        }

        public Criteria andOtherNumberBetween(String value1, String value2) {
            addCriterion("other_number between", value1, value2, "otherNumber");
            return (Criteria) this;
        }

        public Criteria andOtherNumberNotBetween(String value1, String value2) {
            addCriterion("other_number not between", value1, value2, "otherNumber");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(Integer value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(Integer value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(Integer value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(Integer value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(Integer value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<Integer> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<Integer> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(Integer value1, Integer value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(Integer value1, Integer value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageIsNull() {
            addCriterion("personal_homepage is null");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageIsNotNull() {
            addCriterion("personal_homepage is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageEqualTo(String value) {
            addCriterion("personal_homepage =", value, "personalHomepage");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageNotEqualTo(String value) {
            addCriterion("personal_homepage <>", value, "personalHomepage");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageGreaterThan(String value) {
            addCriterion("personal_homepage >", value, "personalHomepage");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageGreaterThanOrEqualTo(String value) {
            addCriterion("personal_homepage >=", value, "personalHomepage");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageLessThan(String value) {
            addCriterion("personal_homepage <", value, "personalHomepage");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageLessThanOrEqualTo(String value) {
            addCriterion("personal_homepage <=", value, "personalHomepage");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageLike(String value) {
            addCriterion("personal_homepage like", value, "personalHomepage");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageNotLike(String value) {
            addCriterion("personal_homepage not like", value, "personalHomepage");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageIn(List<String> values) {
            addCriterion("personal_homepage in", values, "personalHomepage");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageNotIn(List<String> values) {
            addCriterion("personal_homepage not in", values, "personalHomepage");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageBetween(String value1, String value2) {
            addCriterion("personal_homepage between", value1, value2, "personalHomepage");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageNotBetween(String value1, String value2) {
            addCriterion("personal_homepage not between", value1, value2, "personalHomepage");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitUrlIsNull() {
            addCriterion("head_portrait_url is null");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitUrlIsNotNull() {
            addCriterion("head_portrait_url is not null");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitUrlEqualTo(String value) {
            addCriterion("head_portrait_url =", value, "headPortraitUrl");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitUrlNotEqualTo(String value) {
            addCriterion("head_portrait_url <>", value, "headPortraitUrl");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitUrlGreaterThan(String value) {
            addCriterion("head_portrait_url >", value, "headPortraitUrl");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitUrlGreaterThanOrEqualTo(String value) {
            addCriterion("head_portrait_url >=", value, "headPortraitUrl");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitUrlLessThan(String value) {
            addCriterion("head_portrait_url <", value, "headPortraitUrl");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitUrlLessThanOrEqualTo(String value) {
            addCriterion("head_portrait_url <=", value, "headPortraitUrl");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitUrlLike(String value) {
            addCriterion("head_portrait_url like", value, "headPortraitUrl");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitUrlNotLike(String value) {
            addCriterion("head_portrait_url not like", value, "headPortraitUrl");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitUrlIn(List<String> values) {
            addCriterion("head_portrait_url in", values, "headPortraitUrl");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitUrlNotIn(List<String> values) {
            addCriterion("head_portrait_url not in", values, "headPortraitUrl");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitUrlBetween(String value1, String value2) {
            addCriterion("head_portrait_url between", value1, value2, "headPortraitUrl");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitUrlNotBetween(String value1, String value2) {
            addCriterion("head_portrait_url not between", value1, value2, "headPortraitUrl");
            return (Criteria) this;
        }

        public Criteria andBasePayIsNull() {
            addCriterion("base_pay is null");
            return (Criteria) this;
        }

        public Criteria andBasePayIsNotNull() {
            addCriterion("base_pay is not null");
            return (Criteria) this;
        }

        public Criteria andBasePayEqualTo(Double value) {
            addCriterion("base_pay =", value, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayNotEqualTo(Double value) {
            addCriterion("base_pay <>", value, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayGreaterThan(Double value) {
            addCriterion("base_pay >", value, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayGreaterThanOrEqualTo(Double value) {
            addCriterion("base_pay >=", value, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayLessThan(Double value) {
            addCriterion("base_pay <", value, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayLessThanOrEqualTo(Double value) {
            addCriterion("base_pay <=", value, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayIn(List<Double> values) {
            addCriterion("base_pay in", values, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayNotIn(List<Double> values) {
            addCriterion("base_pay not in", values, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayBetween(Double value1, Double value2) {
            addCriterion("base_pay between", value1, value2, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayNotBetween(Double value1, Double value2) {
            addCriterion("base_pay not between", value1, value2, "basePay");
            return (Criteria) this;
        }

        public Criteria andAllowanceIsNull() {
            addCriterion("allowance is null");
            return (Criteria) this;
        }

        public Criteria andAllowanceIsNotNull() {
            addCriterion("allowance is not null");
            return (Criteria) this;
        }

        public Criteria andAllowanceEqualTo(Double value) {
            addCriterion("allowance =", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceNotEqualTo(Double value) {
            addCriterion("allowance <>", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceGreaterThan(Double value) {
            addCriterion("allowance >", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceGreaterThanOrEqualTo(Double value) {
            addCriterion("allowance >=", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceLessThan(Double value) {
            addCriterion("allowance <", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceLessThanOrEqualTo(Double value) {
            addCriterion("allowance <=", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceIn(List<Double> values) {
            addCriterion("allowance in", values, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceNotIn(List<Double> values) {
            addCriterion("allowance not in", values, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceBetween(Double value1, Double value2) {
            addCriterion("allowance between", value1, value2, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceNotBetween(Double value1, Double value2) {
            addCriterion("allowance not between", value1, value2, "allowance");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNull() {
            addCriterion("commission is null");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNotNull() {
            addCriterion("commission is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionEqualTo(Double value) {
            addCriterion("commission =", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotEqualTo(Double value) {
            addCriterion("commission <>", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThan(Double value) {
            addCriterion("commission >", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThanOrEqualTo(Double value) {
            addCriterion("commission >=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThan(Double value) {
            addCriterion("commission <", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThanOrEqualTo(Double value) {
            addCriterion("commission <=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionIn(List<Double> values) {
            addCriterion("commission in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotIn(List<Double> values) {
            addCriterion("commission not in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionBetween(Double value1, Double value2) {
            addCriterion("commission between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotBetween(Double value1, Double value2) {
            addCriterion("commission not between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andEquityIncomeIsNull() {
            addCriterion("equity_income is null");
            return (Criteria) this;
        }

        public Criteria andEquityIncomeIsNotNull() {
            addCriterion("equity_income is not null");
            return (Criteria) this;
        }

        public Criteria andEquityIncomeEqualTo(Double value) {
            addCriterion("equity_income =", value, "equityIncome");
            return (Criteria) this;
        }

        public Criteria andEquityIncomeNotEqualTo(Double value) {
            addCriterion("equity_income <>", value, "equityIncome");
            return (Criteria) this;
        }

        public Criteria andEquityIncomeGreaterThan(Double value) {
            addCriterion("equity_income >", value, "equityIncome");
            return (Criteria) this;
        }

        public Criteria andEquityIncomeGreaterThanOrEqualTo(Double value) {
            addCriterion("equity_income >=", value, "equityIncome");
            return (Criteria) this;
        }

        public Criteria andEquityIncomeLessThan(Double value) {
            addCriterion("equity_income <", value, "equityIncome");
            return (Criteria) this;
        }

        public Criteria andEquityIncomeLessThanOrEqualTo(Double value) {
            addCriterion("equity_income <=", value, "equityIncome");
            return (Criteria) this;
        }

        public Criteria andEquityIncomeIn(List<Double> values) {
            addCriterion("equity_income in", values, "equityIncome");
            return (Criteria) this;
        }

        public Criteria andEquityIncomeNotIn(List<Double> values) {
            addCriterion("equity_income not in", values, "equityIncome");
            return (Criteria) this;
        }

        public Criteria andEquityIncomeBetween(Double value1, Double value2) {
            addCriterion("equity_income between", value1, value2, "equityIncome");
            return (Criteria) this;
        }

        public Criteria andEquityIncomeNotBetween(Double value1, Double value2) {
            addCriterion("equity_income not between", value1, value2, "equityIncome");
            return (Criteria) this;
        }

        public Criteria andResumeIdIsNull() {
            addCriterion("resume_id is null");
            return (Criteria) this;
        }

        public Criteria andResumeIdIsNotNull() {
            addCriterion("resume_id is not null");
            return (Criteria) this;
        }

        public Criteria andResumeIdEqualTo(String value) {
            addCriterion("resume_id =", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdNotEqualTo(String value) {
            addCriterion("resume_id <>", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdGreaterThan(String value) {
            addCriterion("resume_id >", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdGreaterThanOrEqualTo(String value) {
            addCriterion("resume_id >=", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdLessThan(String value) {
            addCriterion("resume_id <", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdLessThanOrEqualTo(String value) {
            addCriterion("resume_id <=", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdLike(String value) {
            addCriterion("resume_id like", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdNotLike(String value) {
            addCriterion("resume_id not like", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdIn(List<String> values) {
            addCriterion("resume_id in", values, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdNotIn(List<String> values) {
            addCriterion("resume_id not in", values, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdBetween(String value1, String value2) {
            addCriterion("resume_id between", value1, value2, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdNotBetween(String value1, String value2) {
            addCriterion("resume_id not between", value1, value2, "resumeId");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNull() {
            addCriterion("created_by is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("created_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(String value) {
            addCriterion("created_by =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(String value) {
            addCriterion("created_by <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(String value) {
            addCriterion("created_by >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(String value) {
            addCriterion("created_by >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(String value) {
            addCriterion("created_by <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(String value) {
            addCriterion("created_by <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLike(String value) {
            addCriterion("created_by like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotLike(String value) {
            addCriterion("created_by not like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<String> values) {
            addCriterion("created_by in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<String> values) {
            addCriterion("created_by not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(String value1, String value2) {
            addCriterion("created_by between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(String value1, String value2) {
            addCriterion("created_by not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNull() {
            addCriterion("updated_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNotNull() {
            addCriterion("updated_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByEqualTo(String value) {
            addCriterion("updated_by =", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotEqualTo(String value) {
            addCriterion("updated_by <>", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThan(String value) {
            addCriterion("updated_by >", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThanOrEqualTo(String value) {
            addCriterion("updated_by >=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThan(String value) {
            addCriterion("updated_by <", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThanOrEqualTo(String value) {
            addCriterion("updated_by <=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLike(String value) {
            addCriterion("updated_by like", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotLike(String value) {
            addCriterion("updated_by not like", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIn(List<String> values) {
            addCriterion("updated_by in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotIn(List<String> values) {
            addCriterion("updated_by not in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByBetween(String value1, String value2) {
            addCriterion("updated_by between", value1, value2, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotBetween(String value1, String value2) {
            addCriterion("updated_by not between", value1, value2, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIsNull() {
            addCriterion("created_date is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIsNotNull() {
            addCriterion("created_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateEqualTo(Date value) {
            addCriterion("created_date =", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotEqualTo(Date value) {
            addCriterion("created_date <>", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateGreaterThan(Date value) {
            addCriterion("created_date >", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("created_date >=", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateLessThan(Date value) {
            addCriterion("created_date <", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateLessThanOrEqualTo(Date value) {
            addCriterion("created_date <=", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIn(List<Date> values) {
            addCriterion("created_date in", values, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotIn(List<Date> values) {
            addCriterion("created_date not in", values, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateBetween(Date value1, Date value2) {
            addCriterion("created_date between", value1, value2, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotBetween(Date value1, Date value2) {
            addCriterion("created_date not between", value1, value2, "createdDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateIsNull() {
            addCriterion("updated_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateIsNotNull() {
            addCriterion("updated_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateEqualTo(Date value) {
            addCriterion("updated_date =", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateNotEqualTo(Date value) {
            addCriterion("updated_date <>", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateGreaterThan(Date value) {
            addCriterion("updated_date >", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_date >=", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateLessThan(Date value) {
            addCriterion("updated_date <", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateLessThanOrEqualTo(Date value) {
            addCriterion("updated_date <=", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateIn(List<Date> values) {
            addCriterion("updated_date in", values, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateNotIn(List<Date> values) {
            addCriterion("updated_date not in", values, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateBetween(Date value1, Date value2) {
            addCriterion("updated_date between", value1, value2, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateNotBetween(Date value1, Date value2) {
            addCriterion("updated_date not between", value1, value2, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Integer> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Integer> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }
    }

    /**
     * 用户简历详细信息表lds_user_resume_detail的映射实体
     */
    public static class Criteria extends BaseCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 用户简历详细信息表lds_user_resume_detail的动态SQL对象.
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