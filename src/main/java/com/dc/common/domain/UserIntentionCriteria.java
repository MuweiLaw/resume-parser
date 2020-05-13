package com.dc.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author mybatis-generator
 * date:2019/12/15 03:09
 */
public class UserIntentionCriteria {
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
    public UserIntentionCriteria() {
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
     * 用户求职意向表lds_user_intention
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

        public Criteria andSalaryTypeIsNull() {
            addCriterion("salary_type is null");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeIsNotNull() {
            addCriterion("salary_type is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeEqualTo(String value) {
            addCriterion("salary_type =", value, "salaryType");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeNotEqualTo(String value) {
            addCriterion("salary_type <>", value, "salaryType");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeGreaterThan(String value) {
            addCriterion("salary_type >", value, "salaryType");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("salary_type >=", value, "salaryType");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeLessThan(String value) {
            addCriterion("salary_type <", value, "salaryType");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeLessThanOrEqualTo(String value) {
            addCriterion("salary_type <=", value, "salaryType");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeLike(String value) {
            addCriterion("salary_type like", value, "salaryType");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeNotLike(String value) {
            addCriterion("salary_type not like", value, "salaryType");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeIn(List<String> values) {
            addCriterion("salary_type in", values, "salaryType");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeNotIn(List<String> values) {
            addCriterion("salary_type not in", values, "salaryType");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeBetween(String value1, String value2) {
            addCriterion("salary_type between", value1, value2, "salaryType");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeNotBetween(String value1, String value2) {
            addCriterion("salary_type not between", value1, value2, "salaryType");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryIsNull() {
            addCriterion("expect_salary is null");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryIsNotNull() {
            addCriterion("expect_salary is not null");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryEqualTo(String value) {
            addCriterion("expect_salary =", value, "expectSalary");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryNotEqualTo(String value) {
            addCriterion("expect_salary <>", value, "expectSalary");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryGreaterThan(String value) {
            addCriterion("expect_salary >", value, "expectSalary");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryGreaterThanOrEqualTo(String value) {
            addCriterion("expect_salary >=", value, "expectSalary");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryLessThan(String value) {
            addCriterion("expect_salary <", value, "expectSalary");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryLessThanOrEqualTo(String value) {
            addCriterion("expect_salary <=", value, "expectSalary");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryLike(String value) {
            addCriterion("expect_salary like", value, "expectSalary");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryNotLike(String value) {
            addCriterion("expect_salary not like", value, "expectSalary");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryIn(List<String> values) {
            addCriterion("expect_salary in", values, "expectSalary");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryNotIn(List<String> values) {
            addCriterion("expect_salary not in", values, "expectSalary");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryBetween(String value1, String value2) {
            addCriterion("expect_salary between", value1, value2, "expectSalary");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryNotBetween(String value1, String value2) {
            addCriterion("expect_salary not between", value1, value2, "expectSalary");
            return (Criteria) this;
        }

        public Criteria andWorkAddressIsNull() {
            addCriterion("work_address is null");
            return (Criteria) this;
        }

        public Criteria andWorkAddressIsNotNull() {
            addCriterion("work_address is not null");
            return (Criteria) this;
        }

        public Criteria andWorkAddressEqualTo(String value) {
            addCriterion("work_address =", value, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressNotEqualTo(String value) {
            addCriterion("work_address <>", value, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressGreaterThan(String value) {
            addCriterion("work_address >", value, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressGreaterThanOrEqualTo(String value) {
            addCriterion("work_address >=", value, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressLessThan(String value) {
            addCriterion("work_address <", value, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressLessThanOrEqualTo(String value) {
            addCriterion("work_address <=", value, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressLike(String value) {
            addCriterion("work_address like", value, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressNotLike(String value) {
            addCriterion("work_address not like", value, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressIn(List<String> values) {
            addCriterion("work_address in", values, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressNotIn(List<String> values) {
            addCriterion("work_address not in", values, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressBetween(String value1, String value2) {
            addCriterion("work_address between", value1, value2, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressNotBetween(String value1, String value2) {
            addCriterion("work_address not between", value1, value2, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkPositionIsNull() {
            addCriterion("work_position is null");
            return (Criteria) this;
        }

        public Criteria andWorkPositionIsNotNull() {
            addCriterion("work_position is not null");
            return (Criteria) this;
        }

        public Criteria andWorkPositionEqualTo(String value) {
            addCriterion("work_position =", value, "workPosition");
            return (Criteria) this;
        }

        public Criteria andWorkPositionNotEqualTo(String value) {
            addCriterion("work_position <>", value, "workPosition");
            return (Criteria) this;
        }

        public Criteria andWorkPositionGreaterThan(String value) {
            addCriterion("work_position >", value, "workPosition");
            return (Criteria) this;
        }

        public Criteria andWorkPositionGreaterThanOrEqualTo(String value) {
            addCriterion("work_position >=", value, "workPosition");
            return (Criteria) this;
        }

        public Criteria andWorkPositionLessThan(String value) {
            addCriterion("work_position <", value, "workPosition");
            return (Criteria) this;
        }

        public Criteria andWorkPositionLessThanOrEqualTo(String value) {
            addCriterion("work_position <=", value, "workPosition");
            return (Criteria) this;
        }

        public Criteria andWorkPositionLike(String value) {
            addCriterion("work_position like", value, "workPosition");
            return (Criteria) this;
        }

        public Criteria andWorkPositionNotLike(String value) {
            addCriterion("work_position not like", value, "workPosition");
            return (Criteria) this;
        }

        public Criteria andWorkPositionIn(List<String> values) {
            addCriterion("work_position in", values, "workPosition");
            return (Criteria) this;
        }

        public Criteria andWorkPositionNotIn(List<String> values) {
            addCriterion("work_position not in", values, "workPosition");
            return (Criteria) this;
        }

        public Criteria andWorkPositionBetween(String value1, String value2) {
            addCriterion("work_position between", value1, value2, "workPosition");
            return (Criteria) this;
        }

        public Criteria andWorkPositionNotBetween(String value1, String value2) {
            addCriterion("work_position not between", value1, value2, "workPosition");
            return (Criteria) this;
        }

        public Criteria andWorkFunctionIsNull() {
            addCriterion("work_function is null");
            return (Criteria) this;
        }

        public Criteria andWorkFunctionIsNotNull() {
            addCriterion("work_function is not null");
            return (Criteria) this;
        }

        public Criteria andWorkFunctionEqualTo(String value) {
            addCriterion("work_function =", value, "workFunction");
            return (Criteria) this;
        }

        public Criteria andWorkFunctionNotEqualTo(String value) {
            addCriterion("work_function <>", value, "workFunction");
            return (Criteria) this;
        }

        public Criteria andWorkFunctionGreaterThan(String value) {
            addCriterion("work_function >", value, "workFunction");
            return (Criteria) this;
        }

        public Criteria andWorkFunctionGreaterThanOrEqualTo(String value) {
            addCriterion("work_function >=", value, "workFunction");
            return (Criteria) this;
        }

        public Criteria andWorkFunctionLessThan(String value) {
            addCriterion("work_function <", value, "workFunction");
            return (Criteria) this;
        }

        public Criteria andWorkFunctionLessThanOrEqualTo(String value) {
            addCriterion("work_function <=", value, "workFunction");
            return (Criteria) this;
        }

        public Criteria andWorkFunctionLike(String value) {
            addCriterion("work_function like", value, "workFunction");
            return (Criteria) this;
        }

        public Criteria andWorkFunctionNotLike(String value) {
            addCriterion("work_function not like", value, "workFunction");
            return (Criteria) this;
        }

        public Criteria andWorkFunctionIn(List<String> values) {
            addCriterion("work_function in", values, "workFunction");
            return (Criteria) this;
        }

        public Criteria andWorkFunctionNotIn(List<String> values) {
            addCriterion("work_function not in", values, "workFunction");
            return (Criteria) this;
        }

        public Criteria andWorkFunctionBetween(String value1, String value2) {
            addCriterion("work_function between", value1, value2, "workFunction");
            return (Criteria) this;
        }

        public Criteria andWorkFunctionNotBetween(String value1, String value2) {
            addCriterion("work_function not between", value1, value2, "workFunction");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNull() {
            addCriterion("industry is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNotNull() {
            addCriterion("industry is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryEqualTo(String value) {
            addCriterion("industry =", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotEqualTo(String value) {
            addCriterion("industry <>", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThan(String value) {
            addCriterion("industry >", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("industry >=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThan(String value) {
            addCriterion("industry <", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThanOrEqualTo(String value) {
            addCriterion("industry <=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLike(String value) {
            addCriterion("industry like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotLike(String value) {
            addCriterion("industry not like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryIn(List<String> values) {
            addCriterion("industry in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotIn(List<String> values) {
            addCriterion("industry not in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryBetween(String value1, String value2) {
            addCriterion("industry between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotBetween(String value1, String value2) {
            addCriterion("industry not between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andComeTimeIsNull() {
            addCriterion("come_time is null");
            return (Criteria) this;
        }

        public Criteria andComeTimeIsNotNull() {
            addCriterion("come_time is not null");
            return (Criteria) this;
        }

        public Criteria andComeTimeEqualTo(String value) {
            addCriterion("come_time =", value, "comeTime");
            return (Criteria) this;
        }

        public Criteria andComeTimeNotEqualTo(String value) {
            addCriterion("come_time <>", value, "comeTime");
            return (Criteria) this;
        }

        public Criteria andComeTimeGreaterThan(String value) {
            addCriterion("come_time >", value, "comeTime");
            return (Criteria) this;
        }

        public Criteria andComeTimeGreaterThanOrEqualTo(String value) {
            addCriterion("come_time >=", value, "comeTime");
            return (Criteria) this;
        }

        public Criteria andComeTimeLessThan(String value) {
            addCriterion("come_time <", value, "comeTime");
            return (Criteria) this;
        }

        public Criteria andComeTimeLessThanOrEqualTo(String value) {
            addCriterion("come_time <=", value, "comeTime");
            return (Criteria) this;
        }

        public Criteria andComeTimeLike(String value) {
            addCriterion("come_time like", value, "comeTime");
            return (Criteria) this;
        }

        public Criteria andComeTimeNotLike(String value) {
            addCriterion("come_time not like", value, "comeTime");
            return (Criteria) this;
        }

        public Criteria andComeTimeIn(List<String> values) {
            addCriterion("come_time in", values, "comeTime");
            return (Criteria) this;
        }

        public Criteria andComeTimeNotIn(List<String> values) {
            addCriterion("come_time not in", values, "comeTime");
            return (Criteria) this;
        }

        public Criteria andComeTimeBetween(String value1, String value2) {
            addCriterion("come_time between", value1, value2, "comeTime");
            return (Criteria) this;
        }

        public Criteria andComeTimeNotBetween(String value1, String value2) {
            addCriterion("come_time not between", value1, value2, "comeTime");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIsNull() {
            addCriterion("work_type is null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIsNotNull() {
            addCriterion("work_type is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeEqualTo(String value) {
            addCriterion("work_type =", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotEqualTo(String value) {
            addCriterion("work_type <>", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThan(String value) {
            addCriterion("work_type >", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThanOrEqualTo(String value) {
            addCriterion("work_type >=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThan(String value) {
            addCriterion("work_type <", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThanOrEqualTo(String value) {
            addCriterion("work_type <=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLike(String value) {
            addCriterion("work_type like", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotLike(String value) {
            addCriterion("work_type not like", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIn(List<String> values) {
            addCriterion("work_type in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotIn(List<String> values) {
            addCriterion("work_type not in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeBetween(String value1, String value2) {
            addCriterion("work_type between", value1, value2, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotBetween(String value1, String value2) {
            addCriterion("work_type not between", value1, value2, "workType");
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
    }

    /**
     * 用户求职意向表lds_user_intention的映射实体
     */
    public static class Criteria extends BaseCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 用户求职意向表lds_user_intention的动态SQL对象.
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