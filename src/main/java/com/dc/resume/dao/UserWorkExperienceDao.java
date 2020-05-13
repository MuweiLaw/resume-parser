package com.dc.resume.dao;

import com.dc.common.domain.UserWorkExperience;
import com.dc.framework.dao.EntityDao;
import com.dc.framework.dao.MybatisDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @Description: 工作经验Dao
 * @ClassName: UserWorkExperienceDao
 * @Version: 1.0.0
 * @Author: Murray Law
 * @Date 2019/12/18 16:14
 */
@Repository("userWorkExperienceDao")
public class UserWorkExperienceDao extends MybatisDaoSupport<UserWorkExperience, Integer> implements EntityDao<UserWorkExperience, Integer> {

}
