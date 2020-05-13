package com.dc.resume.dao;

import com.dc.common.domain.UserIntention;
import com.dc.framework.dao.EntityDao;
import com.dc.framework.dao.MybatisDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @Description: 用户求职意向Dao
 * @ClassName: UserIntentionDao
 * @Version:  v1.0.0
 * @Author: Murray Law
 * @Date 2019/12/19 10:39
 */
@Repository("userIntentionDao")
public class UserIntentionDao extends MybatisDaoSupport<UserIntention, Integer> implements EntityDao<UserIntention, Integer> {

}
