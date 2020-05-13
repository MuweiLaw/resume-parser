package com.dc.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author mybatis-generator
 * date:2019/12/15 03:09
 */
public class UserResumeCriteria {
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
    public UserResumeCriteria() {
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
     * 用户简历表lds_user_resume
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

        public Criteria andSnapshotIdIsNull() {
            addCriterion("snapshot_id is null");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdIsNotNull() {
            addCriterion("snapshot_id is not null");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdEqualTo(String value) {
            addCriterion("snapshot_id =", value, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdNotEqualTo(String value) {
            addCriterion("snapshot_id <>", value, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdGreaterThan(String value) {
            addCriterion("snapshot_id >", value, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdGreaterThanOrEqualTo(String value) {
            addCriterion("snapshot_id >=", value, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdLessThan(String value) {
            addCriterion("snapshot_id <", value, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdLessThanOrEqualTo(String value) {
            addCriterion("snapshot_id <=", value, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdLike(String value) {
            addCriterion("snapshot_id like", value, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdNotLike(String value) {
            addCriterion("snapshot_id not like", value, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdIn(List<String> values) {
            addCriterion("snapshot_id in", values, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdNotIn(List<String> values) {
            addCriterion("snapshot_id not in", values, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdBetween(String value1, String value2) {
            addCriterion("snapshot_id between", value1, value2, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdNotBetween(String value1, String value2) {
            addCriterion("snapshot_id not between", value1, value2, "snapshotId");
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

        public Criteria andResumeNameIsNull() {
            addCriterion("resume_name is null");
            return (Criteria) this;
        }

        public Criteria andResumeNameIsNotNull() {
            addCriterion("resume_name is not null");
            return (Criteria) this;
        }

        public Criteria andResumeNameEqualTo(String value) {
            addCriterion("resume_name =", value, "resumeName");
            return (Criteria) this;
        }

        public Criteria andResumeNameNotEqualTo(String value) {
            addCriterion("resume_name <>", value, "resumeName");
            return (Criteria) this;
        }

        public Criteria andResumeNameGreaterThan(String value) {
            addCriterion("resume_name >", value, "resumeName");
            return (Criteria) this;
        }

        public Criteria andResumeNameGreaterThanOrEqualTo(String value) {
            addCriterion("resume_name >=", value, "resumeName");
            return (Criteria) this;
        }

        public Criteria andResumeNameLessThan(String value) {
            addCriterion("resume_name <", value, "resumeName");
            return (Criteria) this;
        }

        public Criteria andResumeNameLessThanOrEqualTo(String value) {
            addCriterion("resume_name <=", value, "resumeName");
            return (Criteria) this;
        }

        public Criteria andResumeNameLike(String value) {
            addCriterion("resume_name like", value, "resumeName");
            return (Criteria) this;
        }

        public Criteria andResumeNameNotLike(String value) {
            addCriterion("resume_name not like", value, "resumeName");
            return (Criteria) this;
        }

        public Criteria andResumeNameIn(List<String> values) {
            addCriterion("resume_name in", values, "resumeName");
            return (Criteria) this;
        }

        public Criteria andResumeNameNotIn(List<String> values) {
            addCriterion("resume_name not in", values, "resumeName");
            return (Criteria) this;
        }

        public Criteria andResumeNameBetween(String value1, String value2) {
            addCriterion("resume_name between", value1, value2, "resumeName");
            return (Criteria) this;
        }

        public Criteria andResumeNameNotBetween(String value1, String value2) {
            addCriterion("resume_name not between", value1, value2, "resumeName");
            return (Criteria) this;
        }

        public Criteria andResumeStatusIsNull() {
            addCriterion("resume_status is null");
            return (Criteria) this;
        }

        public Criteria andResumeStatusIsNotNull() {
            addCriterion("resume_status is not null");
            return (Criteria) this;
        }

        public Criteria andResumeStatusEqualTo(String value) {
            addCriterion("resume_status =", value, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusNotEqualTo(String value) {
            addCriterion("resume_status <>", value, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusGreaterThan(String value) {
            addCriterion("resume_status >", value, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("resume_status >=", value, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusLessThan(String value) {
            addCriterion("resume_status <", value, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusLessThanOrEqualTo(String value) {
            addCriterion("resume_status <=", value, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusLike(String value) {
            addCriterion("resume_status like", value, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusNotLike(String value) {
            addCriterion("resume_status not like", value, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusIn(List<String> values) {
            addCriterion("resume_status in", values, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusNotIn(List<String> values) {
            addCriterion("resume_status not in", values, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusBetween(String value1, String value2) {
            addCriterion("resume_status between", value1, value2, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusNotBetween(String value1, String value2) {
            addCriterion("resume_status not between", value1, value2, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeUpdateTimeIsNull() {
            addCriterion("resume_update_time is null");
            return (Criteria) this;
        }

        public Criteria andResumeUpdateTimeIsNotNull() {
            addCriterion("resume_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andResumeUpdateTimeEqualTo(Date value) {
            addCriterion("resume_update_time =", value, "resumeUpdateTime");
            return (Criteria) this;
        }

        public Criteria andResumeUpdateTimeNotEqualTo(Date value) {
            addCriterion("resume_update_time <>", value, "resumeUpdateTime");
            return (Criteria) this;
        }

        public Criteria andResumeUpdateTimeGreaterThan(Date value) {
            addCriterion("resume_update_time >", value, "resumeUpdateTime");
            return (Criteria) this;
        }

        public Criteria andResumeUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("resume_update_time >=", value, "resumeUpdateTime");
            return (Criteria) this;
        }

        public Criteria andResumeUpdateTimeLessThan(Date value) {
            addCriterion("resume_update_time <", value, "resumeUpdateTime");
            return (Criteria) this;
        }

        public Criteria andResumeUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("resume_update_time <=", value, "resumeUpdateTime");
            return (Criteria) this;
        }

        public Criteria andResumeUpdateTimeIn(List<Date> values) {
            addCriterion("resume_update_time in", values, "resumeUpdateTime");
            return (Criteria) this;
        }

        public Criteria andResumeUpdateTimeNotIn(List<Date> values) {
            addCriterion("resume_update_time not in", values, "resumeUpdateTime");
            return (Criteria) this;
        }

        public Criteria andResumeUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("resume_update_time between", value1, value2, "resumeUpdateTime");
            return (Criteria) this;
        }

        public Criteria andResumeUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("resume_update_time not between", value1, value2, "resumeUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPrivacyPolicyIsNull() {
            addCriterion("privacy_policy is null");
            return (Criteria) this;
        }

        public Criteria andPrivacyPolicyIsNotNull() {
            addCriterion("privacy_policy is not null");
            return (Criteria) this;
        }

        public Criteria andPrivacyPolicyEqualTo(String value) {
            addCriterion("privacy_policy =", value, "privacyPolicy");
            return (Criteria) this;
        }

        public Criteria andPrivacyPolicyNotEqualTo(String value) {
            addCriterion("privacy_policy <>", value, "privacyPolicy");
            return (Criteria) this;
        }

        public Criteria andPrivacyPolicyGreaterThan(String value) {
            addCriterion("privacy_policy >", value, "privacyPolicy");
            return (Criteria) this;
        }

        public Criteria andPrivacyPolicyGreaterThanOrEqualTo(String value) {
            addCriterion("privacy_policy >=", value, "privacyPolicy");
            return (Criteria) this;
        }

        public Criteria andPrivacyPolicyLessThan(String value) {
            addCriterion("privacy_policy <", value, "privacyPolicy");
            return (Criteria) this;
        }

        public Criteria andPrivacyPolicyLessThanOrEqualTo(String value) {
            addCriterion("privacy_policy <=", value, "privacyPolicy");
            return (Criteria) this;
        }

        public Criteria andPrivacyPolicyLike(String value) {
            addCriterion("privacy_policy like", value, "privacyPolicy");
            return (Criteria) this;
        }

        public Criteria andPrivacyPolicyNotLike(String value) {
            addCriterion("privacy_policy not like", value, "privacyPolicy");
            return (Criteria) this;
        }

        public Criteria andPrivacyPolicyIn(List<String> values) {
            addCriterion("privacy_policy in", values, "privacyPolicy");
            return (Criteria) this;
        }

        public Criteria andPrivacyPolicyNotIn(List<String> values) {
            addCriterion("privacy_policy not in", values, "privacyPolicy");
            return (Criteria) this;
        }

        public Criteria andPrivacyPolicyBetween(String value1, String value2) {
            addCriterion("privacy_policy between", value1, value2, "privacyPolicy");
            return (Criteria) this;
        }

        public Criteria andPrivacyPolicyNotBetween(String value1, String value2) {
            addCriterion("privacy_policy not between", value1, value2, "privacyPolicy");
            return (Criteria) this;
        }

        public Criteria andDeleteIsNull() {
            addCriterion("delete is null");
            return (Criteria) this;
        }

        public Criteria andDeleteIsNotNull() {
            addCriterion("delete is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteEqualTo(String value) {
            addCriterion("delete =", value, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteNotEqualTo(String value) {
            addCriterion("delete <>", value, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteGreaterThan(String value) {
            addCriterion("delete >", value, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteGreaterThanOrEqualTo(String value) {
            addCriterion("delete >=", value, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteLessThan(String value) {
            addCriterion("delete <", value, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteLessThanOrEqualTo(String value) {
            addCriterion("delete <=", value, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteLike(String value) {
            addCriterion("delete like", value, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteNotLike(String value) {
            addCriterion("delete not like", value, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteIn(List<String> values) {
            addCriterion("delete in", values, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteNotIn(List<String> values) {
            addCriterion("delete not in", values, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteBetween(String value1, String value2) {
            addCriterion("delete between", value1, value2, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteNotBetween(String value1, String value2) {
            addCriterion("delete not between", value1, value2, "delete");
            return (Criteria) this;
        }

        public Criteria andIsPublishedIsNull() {
            addCriterion("is_published is null");
            return (Criteria) this;
        }

        public Criteria andIsPublishedIsNotNull() {
            addCriterion("is_published is not null");
            return (Criteria) this;
        }

        public Criteria andIsPublishedEqualTo(String value) {
            addCriterion("is_published =", value, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedNotEqualTo(String value) {
            addCriterion("is_published <>", value, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedGreaterThan(String value) {
            addCriterion("is_published >", value, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedGreaterThanOrEqualTo(String value) {
            addCriterion("is_published >=", value, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedLessThan(String value) {
            addCriterion("is_published <", value, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedLessThanOrEqualTo(String value) {
            addCriterion("is_published <=", value, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedLike(String value) {
            addCriterion("is_published like", value, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedNotLike(String value) {
            addCriterion("is_published not like", value, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedIn(List<String> values) {
            addCriterion("is_published in", values, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedNotIn(List<String> values) {
            addCriterion("is_published not in", values, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedBetween(String value1, String value2) {
            addCriterion("is_published between", value1, value2, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsPublishedNotBetween(String value1, String value2) {
            addCriterion("is_published not between", value1, value2, "isPublished");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNull() {
            addCriterion("is_default is null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNotNull() {
            addCriterion("is_default is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultEqualTo(String value) {
            addCriterion("is_default =", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotEqualTo(String value) {
            addCriterion("is_default <>", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThan(String value) {
            addCriterion("is_default >", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThanOrEqualTo(String value) {
            addCriterion("is_default >=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThan(String value) {
            addCriterion("is_default <", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThanOrEqualTo(String value) {
            addCriterion("is_default <=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLike(String value) {
            addCriterion("is_default like", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotLike(String value) {
            addCriterion("is_default not like", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIn(List<String> values) {
            addCriterion("is_default in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotIn(List<String> values) {
            addCriterion("is_default not in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultBetween(String value1, String value2) {
            addCriterion("is_default between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotBetween(String value1, String value2) {
            addCriterion("is_default not between", value1, value2, "isDefault");
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
     * 用户简历表lds_user_resume的映射实体
     */
    public static class Criteria extends BaseCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 用户简历表lds_user_resume的动态SQL对象.
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