package com.dc.resume.service;

import com.dc.common.domain.UserCertificates;
import com.dc.framework.dao.EntityDao;
import com.dc.framework.service.EntityServiceBase;
import com.dc.resume.dao.UserCertificatesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户技能服务
 * @ClassName: UserIntentionService
 * @Version: v1.0.0
 * @Author: Murray Law
 * @Date 2019/12/19 10:45
 */
@Service
public class UserCertificatesService extends EntityServiceBase<UserCertificates, Integer> {

    @Autowired
    private UserCertificatesDao userCertificatesDao;

    @Override
    public EntityDao<UserCertificates, Integer> getEntityDao() {
        return userCertificatesDao;
    }
}
