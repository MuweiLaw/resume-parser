package com.dc.resume.service;

import com.dc.common.domain.UserIndustry;
import com.dc.common.util.base.Keygenerator;
import com.dc.common.util.base.LayUi;
import com.dc.common.util.base.PageUtils;
import com.dc.framework.dao.EntityDao;
import com.dc.framework.page.PageContext;
import com.dc.framework.service.EntityServiceBase;
import com.dc.resume.dao.UserIndustryDao;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description: 用户行业的Service
 * @ClassName: UserIndustryService
 * @Version:
 * @Author: Murray Law
 * @Date 2020/1/10 16:56
 */
@Service
public class UserIndustryService extends EntityServiceBase<UserIndustry, Integer> {

    @Autowired
    private UserIndustryDao userIndustryDao;

    @Override
    public EntityDao<UserIndustry, Integer> getEntityDao() {
        return userIndustryDao;
    }

    void addIndustrys(List<String> industrys) {
        userIndustryDao.findAll().forEach(userIndustry -> {
            industrys.add(userIndustry.getIndustry());
        });
    }

    public int insertUserIndustry(UserIndustry userIndustry) {
        setParentIdByIndustry(userIndustry);
        userIndustry.setIndustryId(Keygenerator.generateRequestNo());
        userIndustry.setCreatedBy("admin");
        userIndustry.setUpdatedBy("admin");
        return userIndustryDao.insert(userIndustry);
    }

    public int deleteUserIndustry(UserIndustry userIndustry) {
        return userIndustryDao.delete(userIndustry);
    }

    public int updateUserIndustry(UserIndustry userIndustry) {
        setParentIdByIndustry(userIndustry);
        return userIndustryDao.update(userIndustry);
    }

    private void setParentIdByIndustry(UserIndustry userIndustry) {
        UserIndustry industry = new UserIndustry();
        industry.setIndustryParentId("");
        industry.setIndustry(userIndustry.getIndustryParentId());
        List<UserIndustry> list = userIndustryDao.findBy(industry);
        if (list.size() < 1) {
            userIndustry.setIndustryParentId(null);
        } else {
            userIndustry.setIndustryParentId(list.get(0).getIndustryId());
        }
    }

    public List<UserIndustry> findByUserIndustry(UserIndustry UserIndustry) {
        List<com.dc.common.domain.UserIndustry> list = userIndustryDao.findBy(UserIndustry);
        List<com.dc.common.domain.UserIndustry> reList = new ArrayList<>();
        List<com.dc.common.domain.UserIndustry> listAll = findAll();
        for (int i = 0; i < list.size(); i++) {
            com.dc.common.domain.UserIndustry industry = list.get(i);
            if (null == industry.getIndustryParentId()) {
                reList.add(industry);
            } else {
                listAll.forEach(industryByAll -> {
                    if (industry.getIndustryParentId().equals(industryByAll.getIndustryId())) {
                        industry.setIndustryParentId(industryByAll.getIndustry());
                        reList.add(industry);
                    }
                });
            }
        }
        return reList;
    }

    public List<UserIndustry> findAllWithUserIndustry() {
        return userIndustryDao.findAll();
    }

    public LayUi findPageByLayUIWithUserIndustry(Map<String, Object> params) {
        return getLayUIWithUserIndustry(params);
    }
    /**
     *@return com.dc.common.util.base.LayUi
     *@Description: 用户行业转换LayUI参数
     *@Param [params]
     *@author Murray Law
     *@date 2020/2/27 21:06
     */
    private LayUi getLayUIWithUserIndustry(Map<String, Object> params) {
        PageContext pageContext = new PageContext();
        List<UserIndustry> reList = new ArrayList<>();
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
        List<UserIndustry> list = findPage(pageContext).getResult();
        List<UserIndustry> listAll = findAll();
        for (int i = 0; i < list.size(); i++) {
            UserIndustry industry = list.get(i);
            if (null == industry.getIndustryParentId()) {
                reList.add(industry);
            } else {
                listAll.forEach(industryByAll -> {
                    if (industry.getIndustryParentId().equals(industryByAll.getIndustryId())) {
                        industry.setIndustryParentId(industryByAll.getIndustry());
                        reList.add(industry);
                    }
                });
            }
        }
        int total = listAll.size();
        PageUtils pageUtil = new PageUtils(reList, total, limit, page);
        return LayUi.data(pageUtil.getTotalCount(), pageUtil.getList());
    }

}
