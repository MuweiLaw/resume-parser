package com.dc.resume.dao;

import com.dc.common.domain.UserCertificates;
import com.dc.framework.dao.EntityDao;
import com.dc.framework.dao.MybatisDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @Description: 用户证书Dao
 * @ClassName: UserEducationExperienceDao
 * @Version: v1.0.0
 * @Author: Murray Law
 * @Date 2019/12/18 18:02
 */
@Repository("userCertificatesDao")
public class UserCertificatesDao extends MybatisDaoSupport<UserCertificates, Integer> implements EntityDao<UserCertificates, Integer> {

}
