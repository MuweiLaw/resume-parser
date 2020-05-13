package com.dc.resume.controller;

import com.dc.common.domain.UserLocation;
import com.dc.common.util.base.LayUi;
import com.dc.resume.service.UserLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author:MuweiLaw
 * @Date:2020/2/25 23:12
 */
@Controller
@RequestMapping("location")
public class LocationController {

    @Autowired
    UserLocationService userLocationService;

    /**
     * @return java.lang.String
     * @Description: 插入位置字典
     * @Param [userLocation]
     * @author Murray Law
     * @date 2020/1/11 14:00
     */
    @PostMapping("insertUserLocation")
    @ResponseBody
    public String insertUserLocation(@RequestBody UserLocation userLocation) {
        if (userLocationService.insertUserLocation(userLocation) > 0) {
            return "插入位置字典成功";
        } else {
            return "插入位置字典失败";
        }

    }

    @PostMapping("deleteUserLocation")
    @ResponseBody
    public String deleteUserLocation(@RequestBody UserLocation userLocation) {
        if (userLocationService.deleteUserLocation(userLocation) > 0) {
            return "删除地址字典成功";
        } else {
            return "删除地址字典失败";
        }
    }    //更新位置

    @PostMapping("updateUserLocation")
    @ResponseBody
    public String updateUserLocation(@RequestBody UserLocation userLocation) {
        if (userLocationService.updateUserLocation(userLocation) > 0) {
            return "修改地址字典成功";
        } else {
            return "修改地址字典失败";
        }
    }//查询所有位置

    @GetMapping("findAllWithUserLocation")
    @ResponseBody
    public List<UserLocation> findAllWithUserLocation() {
        return userLocationService.findAllWithUserLocation();
    }

    //寻找位置
    @PostMapping("findByUserLocation")
    @ResponseBody
    public List<UserLocation> findByUserLocation(@RequestBody UserLocation userLocation) {
        return userLocationService.findByUserLocation(userLocation);
    }
    //分页查找位置
    @PostMapping("findPageByUserLocation")
    @ResponseBody
    public LayUi findPageByUserLocation(@RequestParam Map<String, Object> params) {
        return userLocationService.findPageByLayUIWithUserLocation(params);
    }

}
