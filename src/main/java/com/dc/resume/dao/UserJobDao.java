package com.dc.resume.dao;

import com.dc.common.domain.UserJob;
import com.dc.framework.dao.EntityDao;
import com.dc.framework.dao.MybatisDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @Description: 用户职位的DAO
 * @ClassName: UserJobDao
 * @Version: v1.0.0
 * @Author: Murray Law
 * @Date 2020/1/9 16:36
 */
@Repository("userJobDao")
public class UserJobDao extends MybatisDaoSupport<UserJob, Integer> implements EntityDao<UserJob, Integer> {

}
