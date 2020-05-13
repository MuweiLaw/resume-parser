package com.dc.resume.service;

import com.dc.common.domain.UserEducationExperience;
import com.dc.framework.dao.EntityDao;
import com.dc.framework.service.EntityServiceBase;
import com.dc.resume.dao.UserEducationExperienceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户教育经历类
 * @ClassName: UserEducationExperienceService
 * @Version: v1.0.0
 * @Author: Murray Law
 * @Date 2019/12/19 10:43
 */
@Service
public class UserEducationExperienceService extends EntityServiceBase<UserEducationExperience, Integer> {

    @Autowired
    private UserEducationExperienceDao userEducationExperienceDao;

    @Override
    public EntityDao<UserEducationExperience, Integer> getEntityDao() {
        return userEducationExperienceDao;
    }
}
