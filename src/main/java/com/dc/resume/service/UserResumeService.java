package com.dc.resume.service;

import com.dc.common.domain.UserResume;
import com.dc.framework.dao.EntityDao;
import com.dc.framework.service.EntityServiceBase;
import com.dc.resume.dao.UserResumeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户简历服务类
 * @ClassName: UserResumeService
 * @Version:  v1.0.0
 * @Author: Murray Law
 * @Date 2019/12/19 10:42
 */
@Service
public class UserResumeService extends EntityServiceBase<UserResume, Long> {

    @Autowired
    private UserResumeDao userResumeDao;

    @Override
    public EntityDao<UserResume, Long> getEntityDao() {
        return userResumeDao;
    }
}
