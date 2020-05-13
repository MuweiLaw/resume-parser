package com.dc.resume.dao;

import com.dc.common.domain.UserResume;
import com.dc.framework.dao.EntityDao;
import com.dc.framework.dao.MybatisDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @author wx
 * @version 1.0.0
 * @className UserResumeDao
 * @description 用户简历Dao
 * @date 2019/12/14 16:15
 */
@Repository("userResumeDao")
public class UserResumeDao extends MybatisDaoSupport<UserResume, Long> implements EntityDao<UserResume, Long> {
}
