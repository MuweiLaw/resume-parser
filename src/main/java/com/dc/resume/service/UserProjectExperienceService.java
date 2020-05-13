package com.dc.resume.service;

import com.dc.common.domain.UserProjectExperience;
import com.dc.resume.dao.UserProjectExperienceDao;
import com.dc.framework.dao.EntityDao;
import com.dc.framework.service.EntityServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wx
 * @version 1.0.0
 * @className ProjectExperienceService
 * @description 工作经验service
 * @date 2019/12/13 21:09
 */
@Service
public class UserProjectExperienceService extends EntityServiceBase<UserProjectExperience, Integer> {

    @Autowired
    private UserProjectExperienceDao userProjectExperienceDao;

    @Override
    public EntityDao<UserProjectExperience, Integer> getEntityDao() {
        System.out.println();
        return userProjectExperienceDao;
    }
}
