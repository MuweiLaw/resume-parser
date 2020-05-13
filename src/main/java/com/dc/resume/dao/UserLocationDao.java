package com.dc.resume.dao;

import com.dc.common.domain.UserLocation;
import com.dc.framework.dao.EntityDao;
import com.dc.framework.dao.MybatisDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @Description: 用户地址的DAO
 * @ClassName: UserLocationDao
 * @Version: v1.0.0
 * @Author: Murray Law
 * @Date 2020/1/9 16:36
 */
@Repository("UserLocationDao")
public class UserLocationDao extends MybatisDaoSupport<UserLocation, Integer> implements EntityDao<UserLocation, Integer> {
}
