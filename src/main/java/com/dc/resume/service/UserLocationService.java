package com.dc.resume.service;

import com.dc.common.domain.UserLocation;
import com.dc.common.util.base.Keygenerator;
import com.dc.common.util.base.LayUi;
import com.dc.common.util.base.PageUtils;
import com.dc.framework.dao.EntityDao;
import com.dc.framework.page.PageContext;
import com.dc.framework.service.EntityServiceBase;
import com.dc.resume.dao.UserLocationDao;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description: 用户地址的Service
 * @ClassName: UserLocationService
 * @Version:
 * @Author: Murray Law
 * @Date 2020/1/10 16:57
 */
@Service
public class UserLocationService extends EntityServiceBase<UserLocation, Integer> {

    @Autowired
    private UserLocationDao userLocationDao;

    @Override
    public EntityDao<UserLocation, Integer> getEntityDao() {
        return userLocationDao;
    }

    public void addLocations(List<String> locations) {
        userLocationDao.findAll().forEach(userLocation -> {
            locations.add(userLocation.getLocation());
        });
    }

    public int insertUserLocation(UserLocation userLocation) {
        setParentIdByLocation(userLocation);
        userLocation.setLocationId(Keygenerator.generateRequestNo());
        userLocation.setCreatedBy("admin");
        userLocation.setUpdatedBy("admin");
        return userLocationDao.insert(userLocation);
    }

    public int deleteUserLocation(UserLocation userLocation) {
        return userLocationDao.delete(userLocation);
    }

    public int updateUserLocation(UserLocation userLocation) {
        setParentIdByLocation(userLocation);
        return userLocationDao.update(userLocation);
    }

    public List<UserLocation> findByUserLocation(UserLocation UserLocation) {
        List<com.dc.common.domain.UserLocation> reList = new ArrayList<>();
        List<com.dc.common.domain.UserLocation> locations = userLocationDao.findBy(UserLocation);
        List<com.dc.common.domain.UserLocation> listAll = findAll();
        ChangeParentIdToParentName(reList, locations,listAll);
        return reList;
    }


    public List<UserLocation> findAllWithUserLocation() {
        return userLocationDao.findAll();
    }

    public LayUi findPageByLayUIWithUserLocation(@RequestParam Map<String, Object> params) {
        return getLayUIWithUserLocation(params);
    }

    private void setParentIdByLocation(UserLocation userLocation) {
        UserLocation location = new UserLocation();
        location.setLocationParentId("");
        location.setLocation(userLocation.getLocationParentId());
        List<UserLocation> list = userLocationDao.findBy(location);
        if (list.size() < 1) {
            userLocation.setLocationParentId(null);
        } else {
            userLocation.setLocationParentId(list.get(0).getLocationId());
        }
    }

    private LayUi getLayUIWithUserLocation(Map<String, Object> params) {
        PageContext pageContext = new PageContext();
        List<UserLocation> reList = new ArrayList<>();
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
        List<UserLocation> list = findPage(pageContext).getResult();
        List<UserLocation> listAll = findAll();
        ChangeParentIdToParentName(reList, list,listAll);
        int total = listAll.size();
        PageUtils pageUtil = new PageUtils(reList, total, limit, page);
        return LayUi.data(pageUtil.getTotalCount(), pageUtil.getList());
    }
    private void ChangeParentIdToParentName(List<UserLocation> reList, List<UserLocation> locations, List<UserLocation> listAll ) {
        for (int i = 0; i < locations.size(); i++) {
            UserLocation location = locations.get(i);
            if (null == location.getLocationParentId()) {
                reList.add(location);
            } else {
                listAll.forEach(locationByAll -> {
                    if (location.getLocationParentId().equals(locationByAll.getLocationId())) {
                        location.setLocationParentId(locationByAll.getLocation());
                        reList.add(location);
                    }
                });
            }
        }
    }

}
