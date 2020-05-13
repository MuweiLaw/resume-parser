package com.dc.resume.dao;

import com.dc.common.domain.UserEducationExperience;
import com.dc.framework.dao.EntityDao;
import com.dc.framework.dao.MybatisDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @Description: 用户教育经历Dao
 * @ClassName: UserEducationExperienceDao
 * @Version: v1.0.0
 * @Author: Murray Law
 * @Date 2019/12/18 18:02
 */
@Repository("userEducationExperienceDao")
public class UserEducationExperienceDao extends MybatisDaoSupport<UserEducationExperience, Integer> implements EntityDao<UserEducationExperience, Integer> {

}
