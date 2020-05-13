package com.dc.resume.service;

import com.dc.common.domain.UserMajor;
import com.dc.common.util.base.Keygenerator;
import com.dc.common.util.base.LayUi;
import com.dc.common.util.base.PageUtils;
import com.dc.framework.dao.EntityDao;
import com.dc.framework.page.PageContext;
import com.dc.framework.service.EntityServiceBase;
import com.dc.resume.dao.UserMajorDao;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @Description: 用户专业service
 * @ClassName: UserMajorService
 * @Version:
 * @Author: Murray Law
 * @Date 2020/1/10 13:53
 */
@Service
public class UserMajorService extends EntityServiceBase<UserMajor, Integer> {

    @Autowired
    private UserMajorDao userMajorDao;

    @Override
    public EntityDao<UserMajor, Integer> getEntityDao() {
        return userMajorDao;
    }

    public void addMarjorMap(Map<String, String> marjorMap) {
        userMajorDao.findAll().forEach(userMajor -> {
            marjorMap.put(userMajor.getMajor(), userMajor.getMajorContain());
        });
    }

    public int insertUserMajor(UserMajor userMajor) {
        userMajor.setMajorId(Keygenerator.generateRequestNo());
        userMajor.setCreatedBy("admin");
        userMajor.setUpdatedBy("admin");
        return userMajorDao.insert(userMajor);
    }

    public int deleteUserMajor(UserMajor userMajor) {
        return userMajorDao.delete(userMajor);
    }

    public int updateUserMajor(UserMajor userMajor) {
        return userMajorDao.update(userMajor);
    }

    public List<UserMajor> findByUserMajor(UserMajor UserMajor) {
        return userMajorDao.findBy(UserMajor);
    }

    public List<UserMajor> findAllWithUserMajor() {
        return userMajorDao.findAll();
    }

    public LayUi findPageByLayUIWithUserMajor(@RequestParam Map<String, Object> params) {
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
        List<UserMajor> list = findPage(pageContext).getResult();
        int total = findAll().size();
        PageUtils pageUtil = new PageUtils(list, total, limit, page);
        return LayUi.data(pageUtil.getTotalCount(), pageUtil.getList());
    }

}
