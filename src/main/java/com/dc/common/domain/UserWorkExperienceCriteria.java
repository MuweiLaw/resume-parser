package com.dc.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author mybatis-generator
 * date:2019/12/15 03:09
 */
public class UserWorkExperienceCriteria {
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
    public UserWorkExperienceCriteria() {
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
     * 用户工作经历表lds_user_work_experience
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

        public Criteria andWorkExpIdIsNull() {
            addCriterion("work_exp_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkExpIdIsNotNull() {
            addCriterion("work_exp_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkExpIdEqualTo(String value) {
            addCriterion("work_exp_id =", value, "workExpId");
            return (Criteria) this;
        }

        public Criteria andWorkExpIdNotEqualTo(String value) {
            addCriterion("work_exp_id <>", value, "workExpId");
            return (Criteria) this;
        }

        public Criteria andWorkExpIdGreaterThan(String value) {
            addCriterion("work_exp_id >", value, "workExpId");
            return (Criteria) this;
        }

        public Criteria andWorkExpIdGreaterThanOrEqualTo(String value) {
            addCriterion("work_exp_id >=", value, "workExpId");
            return (Criteria) this;
        }

        public Criteria andWorkExpIdLessThan(String value) {
            addCriterion("work_exp_id <", value, "workExpId");
            return (Criteria) this;
        }

        public Criteria andWorkExpIdLessThanOrEqualTo(String value) {
            addCriterion("work_exp_id <=", value, "workExpId");
            return (Criteria) this;
        }

        public Criteria andWorkExpIdLike(String value) {
            addCriterion("work_exp_id like", value, "workExpId");
            return (Criteria) this;
        }

        public Criteria andWorkExpIdNotLike(String value) {
            addCriterion("work_exp_id not like", value, "workExpId");
            return (Criteria) this;
        }

        public Criteria andWorkExpIdIn(List<String> values) {
            addCriterion("work_exp_id in", values, "workExpId");
            return (Criteria) this;
        }

        public Criteria andWorkExpIdNotIn(List<String> values) {
            addCriterion("work_exp_id not in", values, "workExpId");
            return (Criteria) this;
        }

        public Criteria andWorkExpIdBetween(String value1, String value2) {
            addCriterion("work_exp_id between", value1, value2, "workExpId");
            return (Criteria) this;
        }

        public Criteria andWorkExpIdNotBetween(String value1, String value2) {
            addCriterion("work_exp_id not between", value1, value2, "workExpId");
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

        public Criteria andBeginDateIsNull() {
            addCriterion("begin_date is null");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNotNull() {
            addCriterion("begin_date is not null");
            return (Criteria) this;
        }

        public Criteria andBeginDateEqualTo(Date value) {
            addCriterionForJDBCDate("begin_date =", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("begin_date <>", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThan(Date value) {
            addCriterionForJDBCDate("begin_date >", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("begin_date >=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThan(Date value) {
            addCriterionForJDBCDate("begin_date <", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("begin_date <=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateIn(List<Date> values) {
            addCriterionForJDBCDate("begin_date in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("begin_date not in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("begin_date between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("begin_date not between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanySizeIsNull() {
            addCriterion("company_size is null");
            return (Criteria) this;
        }

        public Criteria andCompanySizeIsNotNull() {
            addCriterion("company_size is not null");
            return (Criteria) this;
        }

        public Criteria andCompanySizeEqualTo(String value) {
            addCriterion("company_size =", value, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeNotEqualTo(String value) {
            addCriterion("company_size <>", value, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeGreaterThan(String value) {
            addCriterion("company_size >", value, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeGreaterThanOrEqualTo(String value) {
            addCriterion("company_size >=", value, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeLessThan(String value) {
            addCriterion("company_size <", value, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeLessThanOrEqualTo(String value) {
            addCriterion("company_size <=", value, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeLike(String value) {
            addCriterion("company_size like", value, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeNotLike(String value) {
            addCriterion("company_size not like", value, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeIn(List<String> values) {
            addCriterion("company_size in", values, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeNotIn(List<String> values) {
            addCriterion("company_size not in", values, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeBetween(String value1, String value2) {
            addCriterion("company_size between", value1, value2, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeNotBetween(String value1, String value2) {
            addCriterion("company_size not between", value1, value2, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureIsNull() {
            addCriterion("company_nature is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureIsNotNull() {
            addCriterion("company_nature is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureEqualTo(String value) {
            addCriterion("company_nature =", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureNotEqualTo(String value) {
            addCriterion("company_nature <>", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureGreaterThan(String value) {
            addCriterion("company_nature >", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureGreaterThanOrEqualTo(String value) {
            addCriterion("company_nature >=", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureLessThan(String value) {
            addCriterion("company_nature <", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureLessThanOrEqualTo(String value) {
            addCriterion("company_nature <=", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureLike(String value) {
            addCriterion("company_nature like", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureNotLike(String value) {
            addCriterion("company_nature not like", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureIn(List<String> values) {
            addCriterion("company_nature in", values, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureNotIn(List<String> values) {
            addCriterion("company_nature not in", values, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureBetween(String value1, String value2) {
            addCriterion("company_nature between", value1, value2, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureNotBetween(String value1, String value2) {
            addCriterion("company_nature not between", value1, value2, "companyNature");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andFunctionIsNull() {
            addCriterion("function is null");
            return (Criteria) this;
        }

        public Criteria andFunctionIsNotNull() {
            addCriterion("function is not null");
            return (Criteria) this;
        }

        public Criteria andFunctionEqualTo(String value) {
            addCriterion("function =", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionNotEqualTo(String value) {
            addCriterion("function <>", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionGreaterThan(String value) {
            addCriterion("function >", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionGreaterThanOrEqualTo(String value) {
            addCriterion("function >=", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionLessThan(String value) {
            addCriterion("function <", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionLessThanOrEqualTo(String value) {
            addCriterion("function <=", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionLike(String value) {
            addCriterion("function like", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionNotLike(String value) {
            addCriterion("function not like", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionIn(List<String> values) {
            addCriterion("function in", values, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionNotIn(List<String> values) {
            addCriterion("function not in", values, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionBetween(String value1, String value2) {
            addCriterion("function between", value1, value2, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionNotBetween(String value1, String value2) {
            addCriterion("function not between", value1, value2, "function");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("position is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("position is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("position =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("position <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("position >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("position >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("position <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("position <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("position like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("position not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("position in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("position not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("position between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("position not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andMonthlySalaryIsNull() {
            addCriterion("monthly_salary is null");
            return (Criteria) this;
        }

        public Criteria andMonthlySalaryIsNotNull() {
            addCriterion("monthly_salary is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlySalaryEqualTo(String value) {
            addCriterion("monthly_salary =", value, "monthlySalary");
            return (Criteria) this;
        }

        public Criteria andMonthlySalaryNotEqualTo(String value) {
            addCriterion("monthly_salary <>", value, "monthlySalary");
            return (Criteria) this;
        }

        public Criteria andMonthlySalaryGreaterThan(String value) {
            addCriterion("monthly_salary >", value, "monthlySalary");
            return (Criteria) this;
        }

        public Criteria andMonthlySalaryGreaterThanOrEqualTo(String value) {
            addCriterion("monthly_salary >=", value, "monthlySalary");
            return (Criteria) this;
        }

        public Criteria andMonthlySalaryLessThan(String value) {
            addCriterion("monthly_salary <", value, "monthlySalary");
            return (Criteria) this;
        }

        public Criteria andMonthlySalaryLessThanOrEqualTo(String value) {
            addCriterion("monthly_salary <=", value, "monthlySalary");
            return (Criteria) this;
        }

        public Criteria andMonthlySalaryLike(String value) {
            addCriterion("monthly_salary like", value, "monthlySalary");
            return (Criteria) this;
        }

        public Criteria andMonthlySalaryNotLike(String value) {
            addCriterion("monthly_salary not like", value, "monthlySalary");
            return (Criteria) this;
        }

        public Criteria andMonthlySalaryIn(List<String> values) {
            addCriterion("monthly_salary in", values, "monthlySalary");
            return (Criteria) this;
        }

        public Criteria andMonthlySalaryNotIn(List<String> values) {
            addCriterion("monthly_salary not in", values, "monthlySalary");
            return (Criteria) this;
        }

        public Criteria andMonthlySalaryBetween(String value1, String value2) {
            addCriterion("monthly_salary between", value1, value2, "monthlySalary");
            return (Criteria) this;
        }

        public Criteria andMonthlySalaryNotBetween(String value1, String value2) {
            addCriterion("monthly_salary not between", value1, value2, "monthlySalary");
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

        public Criteria andJobTypeIsNull() {
            addCriterion("job_type is null");
            return (Criteria) this;
        }

        public Criteria andJobTypeIsNotNull() {
            addCriterion("job_type is not null");
            return (Criteria) this;
        }

        public Criteria andJobTypeEqualTo(String value) {
            addCriterion("job_type =", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotEqualTo(String value) {
            addCriterion("job_type <>", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeGreaterThan(String value) {
            addCriterion("job_type >", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeGreaterThanOrEqualTo(String value) {
            addCriterion("job_type >=", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeLessThan(String value) {
            addCriterion("job_type <", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeLessThanOrEqualTo(String value) {
            addCriterion("job_type <=", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeLike(String value) {
            addCriterion("job_type like", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotLike(String value) {
            addCriterion("job_type not like", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeIn(List<String> values) {
            addCriterion("job_type in", values, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotIn(List<String> values) {
            addCriterion("job_type not in", values, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeBetween(String value1, String value2) {
            addCriterion("job_type between", value1, value2, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotBetween(String value1, String value2) {
            addCriterion("job_type not between", value1, value2, "jobType");
            return (Criteria) this;
        }

        public Criteria andSubordinatesIsNull() {
            addCriterion("subordinates is null");
            return (Criteria) this;
        }

        public Criteria andSubordinatesIsNotNull() {
            addCriterion("subordinates is not null");
            return (Criteria) this;
        }

        public Criteria andSubordinatesEqualTo(Integer value) {
            addCriterion("subordinates =", value, "subordinates");
            return (Criteria) this;
        }

        public Criteria andSubordinatesNotEqualTo(Integer value) {
            addCriterion("subordinates <>", value, "subordinates");
            return (Criteria) this;
        }

        public Criteria andSubordinatesGreaterThan(Integer value) {
            addCriterion("subordinates >", value, "subordinates");
            return (Criteria) this;
        }

        public Criteria andSubordinatesGreaterThanOrEqualTo(Integer value) {
            addCriterion("subordinates >=", value, "subordinates");
            return (Criteria) this;
        }

        public Criteria andSubordinatesLessThan(Integer value) {
            addCriterion("subordinates <", value, "subordinates");
            return (Criteria) this;
        }

        public Criteria andSubordinatesLessThanOrEqualTo(Integer value) {
            addCriterion("subordinates <=", value, "subordinates");
            return (Criteria) this;
        }

        public Criteria andSubordinatesIn(List<Integer> values) {
            addCriterion("subordinates in", values, "subordinates");
            return (Criteria) this;
        }

        public Criteria andSubordinatesNotIn(List<Integer> values) {
            addCriterion("subordinates not in", values, "subordinates");
            return (Criteria) this;
        }

        public Criteria andSubordinatesBetween(Integer value1, Integer value2) {
            addCriterion("subordinates between", value1, value2, "subordinates");
            return (Criteria) this;
        }

        public Criteria andSubordinatesNotBetween(Integer value1, Integer value2) {
            addCriterion("subordinates not between", value1, value2, "subordinates");
            return (Criteria) this;
        }

        public Criteria andReportingObjectIsNull() {
            addCriterion("reporting_object is null");
            return (Criteria) this;
        }

        public Criteria andReportingObjectIsNotNull() {
            addCriterion("reporting_object is not null");
            return (Criteria) this;
        }

        public Criteria andReportingObjectEqualTo(String value) {
            addCriterion("reporting_object =", value, "reportingObject");
            return (Criteria) this;
        }

        public Criteria andReportingObjectNotEqualTo(String value) {
            addCriterion("reporting_object <>", value, "reportingObject");
            return (Criteria) this;
        }

        public Criteria andReportingObjectGreaterThan(String value) {
            addCriterion("reporting_object >", value, "reportingObject");
            return (Criteria) this;
        }

        public Criteria andReportingObjectGreaterThanOrEqualTo(String value) {
            addCriterion("reporting_object >=", value, "reportingObject");
            return (Criteria) this;
        }

        public Criteria andReportingObjectLessThan(String value) {
            addCriterion("reporting_object <", value, "reportingObject");
            return (Criteria) this;
        }

        public Criteria andReportingObjectLessThanOrEqualTo(String value) {
            addCriterion("reporting_object <=", value, "reportingObject");
            return (Criteria) this;
        }

        public Criteria andReportingObjectLike(String value) {
            addCriterion("reporting_object like", value, "reportingObject");
            return (Criteria) this;
        }

        public Criteria andReportingObjectNotLike(String value) {
            addCriterion("reporting_object not like", value, "reportingObject");
            return (Criteria) this;
        }

        public Criteria andReportingObjectIn(List<String> values) {
            addCriterion("reporting_object in", values, "reportingObject");
            return (Criteria) this;
        }

        public Criteria andReportingObjectNotIn(List<String> values) {
            addCriterion("reporting_object not in", values, "reportingObject");
            return (Criteria) this;
        }

        public Criteria andReportingObjectBetween(String value1, String value2) {
            addCriterion("reporting_object between", value1, value2, "reportingObject");
            return (Criteria) this;
        }

        public Criteria andReportingObjectNotBetween(String value1, String value2) {
            addCriterion("reporting_object not between", value1, value2, "reportingObject");
            return (Criteria) this;
        }

        public Criteria andLeavingReasonsIsNull() {
            addCriterion("leaving_reasons is null");
            return (Criteria) this;
        }

        public Criteria andLeavingReasonsIsNotNull() {
            addCriterion("leaving_reasons is not null");
            return (Criteria) this;
        }

        public Criteria andLeavingReasonsEqualTo(String value) {
            addCriterion("leaving_reasons =", value, "leavingReasons");
            return (Criteria) this;
        }

        public Criteria andLeavingReasonsNotEqualTo(String value) {
            addCriterion("leaving_reasons <>", value, "leavingReasons");
            return (Criteria) this;
        }

        public Criteria andLeavingReasonsGreaterThan(String value) {
            addCriterion("leaving_reasons >", value, "leavingReasons");
            return (Criteria) this;
        }

        public Criteria andLeavingReasonsGreaterThanOrEqualTo(String value) {
            addCriterion("leaving_reasons >=", value, "leavingReasons");
            return (Criteria) this;
        }

        public Criteria andLeavingReasonsLessThan(String value) {
            addCriterion("leaving_reasons <", value, "leavingReasons");
            return (Criteria) this;
        }

        public Criteria andLeavingReasonsLessThanOrEqualTo(String value) {
            addCriterion("leaving_reasons <=", value, "leavingReasons");
            return (Criteria) this;
        }

        public Criteria andLeavingReasonsLike(String value) {
            addCriterion("leaving_reasons like", value, "leavingReasons");
            return (Criteria) this;
        }

        public Criteria andLeavingReasonsNotLike(String value) {
            addCriterion("leaving_reasons not like", value, "leavingReasons");
            return (Criteria) this;
        }

        public Criteria andLeavingReasonsIn(List<String> values) {
            addCriterion("leaving_reasons in", values, "leavingReasons");
            return (Criteria) this;
        }

        public Criteria andLeavingReasonsNotIn(List<String> values) {
            addCriterion("leaving_reasons not in", values, "leavingReasons");
            return (Criteria) this;
        }

        public Criteria andLeavingReasonsBetween(String value1, String value2) {
            addCriterion("leaving_reasons between", value1, value2, "leavingReasons");
            return (Criteria) this;
        }

        public Criteria andLeavingReasonsNotBetween(String value1, String value2) {
            addCriterion("leaving_reasons not between", value1, value2, "leavingReasons");
            return (Criteria) this;
        }

        public Criteria andHasOverseasIsNull() {
            addCriterion("has_overseas is null");
            return (Criteria) this;
        }

        public Criteria andHasOverseasIsNotNull() {
            addCriterion("has_overseas is not null");
            return (Criteria) this;
        }

        public Criteria andHasOverseasEqualTo(String value) {
            addCriterion("has_overseas =", value, "hasOverseas");
            return (Criteria) this;
        }

        public Criteria andHasOverseasNotEqualTo(String value) {
            addCriterion("has_overseas <>", value, "hasOverseas");
            return (Criteria) this;
        }

        public Criteria andHasOverseasGreaterThan(String value) {
            addCriterion("has_overseas >", value, "hasOverseas");
            return (Criteria) this;
        }

        public Criteria andHasOverseasGreaterThanOrEqualTo(String value) {
            addCriterion("has_overseas >=", value, "hasOverseas");
            return (Criteria) this;
        }

        public Criteria andHasOverseasLessThan(String value) {
            addCriterion("has_overseas <", value, "hasOverseas");
            return (Criteria) this;
        }

        public Criteria andHasOverseasLessThanOrEqualTo(String value) {
            addCriterion("has_overseas <=", value, "hasOverseas");
            return (Criteria) this;
        }

        public Criteria andHasOverseasLike(String value) {
            addCriterion("has_overseas like", value, "hasOverseas");
            return (Criteria) this;
        }

        public Criteria andHasOverseasNotLike(String value) {
            addCriterion("has_overseas not like", value, "hasOverseas");
            return (Criteria) this;
        }

        public Criteria andHasOverseasIn(List<String> values) {
            addCriterion("has_overseas in", values, "hasOverseas");
            return (Criteria) this;
        }

        public Criteria andHasOverseasNotIn(List<String> values) {
            addCriterion("has_overseas not in", values, "hasOverseas");
            return (Criteria) this;
        }

        public Criteria andHasOverseasBetween(String value1, String value2) {
            addCriterion("has_overseas between", value1, value2, "hasOverseas");
            return (Criteria) this;
        }

        public Criteria andHasOverseasNotBetween(String value1, String value2) {
            addCriterion("has_overseas not between", value1, value2, "hasOverseas");
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
     * 用户工作经历表lds_user_work_experience的映射实体
     */
    public static class Criteria extends BaseCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 用户工作经历表lds_user_work_experience的动态SQL对象.
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