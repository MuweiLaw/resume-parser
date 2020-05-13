package com.dc.resume.dao;

import com.dc.common.domain.UserSkills;
import com.dc.framework.dao.EntityDao;
import com.dc.framework.dao.MybatisDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @Description: 用户技能Dao
 * @ClassName: UserEducationExperienceDao
 * @Version: v1.0.0
 * @Author: Murray Law
 * @Date 2019/12/18 18:02
 */
@Repository("userSkillsDao")
public class UserSkillsDao extends MybatisDaoSupport<UserSkills, Integer> implements EntityDao<UserSkills, Integer> {

}
