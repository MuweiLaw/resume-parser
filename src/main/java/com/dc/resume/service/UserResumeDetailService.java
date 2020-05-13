package com.dc.resume.service;

import com.dc.common.domain.UserResumeDetail;
import com.dc.common.domain.UserResumeDetailCriteria;
import com.dc.common.generator.mapper.UserResumeDetailIMapper;
import com.dc.framework.dao.EntityDao;
import com.dc.framework.service.EntityServiceBase;
import com.dc.resume.dao.UserResumeDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 用户简历服务类
 * @ClassName: UserResumeDetailService
 * @Version:  v1.0.0
 * @Author: Murray Law
 * @Date 2019/12/19 10:43
 */
@Service
public class UserResumeDetailService extends EntityServiceBase<UserResumeDetail, Integer> {

    @Autowired
    private UserResumeDetailDao userResumeDetailDao;

    @Autowired
    private UserResumeDetailIMapper userResumeDetailIMapper;

    @Override
    public EntityDao<UserResumeDetail, Integer> getEntityDao() {
        return userResumeDetailDao;
    }


    public List<UserResumeDetail> findListByPhoneNoAndName(String phone, String name){
        UserResumeDetailCriteria example = new UserResumeDetailCriteria();
        UserResumeDetailCriteria.Criteria criteria = example.createCriteria();
        criteria.andPhoneNoEqualTo(phone).andRealNameEqualTo(name);
        return userResumeDetailIMapper.selectByExample(example);
    }
}
