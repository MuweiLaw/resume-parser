package com.dc.resume.service;

import com.dc.common.domain.UserWorkExperience;
import com.dc.framework.dao.EntityDao;
import com.dc.framework.service.EntityServiceBase;
import com.dc.resume.dao.UserWorkExperienceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户工作经验服务
 * @ClassName: UserWorkExperienceService
 * @Version: v1.0.0
 * @Author: Murray Law
 * @Date 2019/12/19 10:41
 */
@Service
public class UserWorkExperienceService extends EntityServiceBase<UserWorkExperience, Integer> {

    @Autowired
    private UserWorkExperienceDao userWorkExperienceDao;

    @Override
    public EntityDao<UserWorkExperience, Integer> getEntityDao() {
        return userWorkExperienceDao;
    }
}
