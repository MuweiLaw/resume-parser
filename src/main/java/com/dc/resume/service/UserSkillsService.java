package com.dc.resume.service;

import com.dc.common.domain.UserResumeDetail;
import com.dc.common.domain.UserResumeDetailCriteria;
import com.dc.common.domain.UserSkills;
import com.dc.common.generator.mapper.UserResumeDetailIMapper;
import com.dc.framework.dao.EntityDao;
import com.dc.framework.service.EntityServiceBase;
import com.dc.resume.dao.UserSkillsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 用户技能服务
 * @ClassName: UserIntentionService
 * @Version: v1.0.0
 * @Author: Murray Law
 * @Date 2019/12/19 10:45
 */
@Service
public class UserSkillsService extends EntityServiceBase<UserSkills, Integer> {

    @Autowired
    private UserSkillsDao userSkillsDao;


    @Override
    public EntityDao<UserSkills, Integer> getEntityDao() {
        return userSkillsDao;
    }


}
