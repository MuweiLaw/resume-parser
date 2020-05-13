package com.dc.resume.service;

import com.dc.common.domain.UserIntention;
import com.dc.framework.dao.EntityDao;
import com.dc.framework.service.EntityServiceBase;
import com.dc.resume.dao.UserIntentionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户求职意向类
 * @ClassName: UserIntentionService
 * @Version: v1.0.0
 * @Author: Murray Law
 * @Date 2019/12/19 10:45
 */
@Service
public class UserIntentionService extends EntityServiceBase<UserIntention, Integer> {

    @Autowired
    private UserIntentionDao userIntentionDao;

    @Override
    public EntityDao<UserIntention, Integer> getEntityDao() {
        return userIntentionDao;
    }
}
