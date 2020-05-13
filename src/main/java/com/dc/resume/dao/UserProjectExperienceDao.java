package com.dc.resume.dao;

import com.dc.common.domain.UserProjectExperience;
import com.dc.framework.dao.EntityDao;
import com.dc.framework.dao.MybatisDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @author wx
 * @version 1.0.0
 * @className ProjectExperienceDao
 * @description 项目经验Dao
 * @date 2019/12/13 21:00
 */
@Repository("userProjectExperienceDao")
public class UserProjectExperienceDao extends MybatisDaoSupport<UserProjectExperience, Integer> implements EntityDao<UserProjectExperience, Integer> {

}
