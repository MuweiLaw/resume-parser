package com.dc.resume.dao;

import com.dc.common.domain.UserResumeDetail;
import com.dc.framework.dao.EntityDao;
import com.dc.framework.dao.MybatisDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @Description: 用户信息Dao
 * @ClassName: UserResumeDetailDao
 * @Version: v1.0.0
 * @Author: Murray Law
 * @Date 2019/12/19 10:39
 */
@Repository("userResumeDetailDao")
public class UserResumeDetailDao extends MybatisDaoSupport<UserResumeDetail, Integer> implements EntityDao<UserResumeDetail, Integer> {

}
