package com.dc.resume.service;

import com.dc.common.domain.UserJob;
import com.dc.common.util.base.Keygenerator;
import com.dc.common.util.base.LayUi;
import com.dc.common.util.base.PageUtils;
import com.dc.framework.dao.EntityDao;
import com.dc.framework.page.PageContext;
import com.dc.framework.service.EntityServiceBase;
import com.dc.resume.dao.UserJobDao;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @Description: 用户的职位服务
 * @ClassName: UserJobService
 * @Version:
 * @Author: Murray Law
 * @Date 2020/1/9 16:44
 */
@Service
public class UserJobService extends EntityServiceBase<UserJob, Integer> {

    @Autowired
    private UserJobDao userJobDao;

    @Override
    public EntityDao<UserJob, Integer> getEntityDao() {
        return userJobDao;
    }

    public void addJobTitles(Map<String, String> jobTitles) {
        userJobDao.findAll().forEach(userJob -> {
            jobTitles.put(userJob.getJob(), userJob.getJobContain());
        });
    }

    public int insertJobDao(UserJob userJob) {
        userJob.setJobId(Keygenerator.generateRequestNo());
        userJob.setCreatedBy("admin");
        userJob.setUpdatedBy("admin");
        return userJobDao.insert(userJob);
    }

    public int deleteUserJob(UserJob userJob) {
        return userJobDao.delete(userJob);
    }

    public int updateUserJob(UserJob userJob) {
        userJob.setUpdatedBy("admin");
        return userJobDao.update(userJob);
    }

    public List<UserJob> findByUserJob(UserJob userJob) {
        return userJobDao.findBy(userJob);
    }

    public List<UserJob> findAllWithUserJob() {
        return userJobDao.findAll();
    }

    public List<UserJob> findPageWithUserJob(PageContext parameter) {
        return userJobDao.findPage(parameter).getResult();
    }

    public LayUi findPageByLayUIWithUserJob(@RequestParam Map<String, Object> params) {
        return getLayUI(params);
    }
    private LayUi getLayUI(Map<String, Object> params) {
        PageContext pageContext = new PageContext();
        int page = 0;
        int limit = 0;
        try {
            page = Integer.parseInt((String) params.get("page"));
            limit = Integer.parseInt((String) params.get("limit"));

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        RowBounds rowBounds = new RowBounds((page - 1) * limit, limit);
        pageContext.setRowBounds(rowBounds);
        pageContext.addParams(params);
        List<UserJob> list = findPage(pageContext).getResult();
        int total = findAll().size();
        PageUtils pageUtil = new PageUtils(list, total, limit, page);
        return LayUi.data(pageUtil.getTotalCount(), pageUtil.getList());
    }

}
