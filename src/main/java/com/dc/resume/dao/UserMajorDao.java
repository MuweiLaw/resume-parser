package com.dc.resume.dao;

import com.dc.common.domain.UserMajor;
import com.dc.framework.dao.EntityDao;
import com.dc.framework.dao.MybatisDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @Description: 专业的持久Dao层
 * @ClassName: UserMajorDao
 * @Version:  
 * @Author: Murray Law
 * @Date 2020/1/10 11:56
 */
@Repository("UserMajorDao")
public class UserMajorDao extends MybatisDaoSupport<UserMajor, Integer> implements EntityDao<UserMajor, Integer> {

}
