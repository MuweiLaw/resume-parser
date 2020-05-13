package com.dc.resume.dao;

import com.dc.common.domain.UserIndustry;
import com.dc.framework.dao.EntityDao;
import com.dc.framework.dao.MybatisDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @Description: 用户行业的DAO
 * @ClassName: UserIndustryDao
 * @Version: v1.0.0
 * @Author: Murray Law
 * @Date 2020/1/9 16:36
 */
@Repository("UserIndustryDao")
public class UserIndustryDao extends MybatisDaoSupport<UserIndustry, Integer> implements EntityDao<UserIndustry, Integer> {

}
