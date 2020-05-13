package com.dc.resume.controller;

import com.dc.common.domain.UserIndustry;
import com.dc.common.util.base.LayUi;
import com.dc.resume.service.UserIndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author:MuweiLaw
 * @Date:2020/2/27 17:29
 */
@Controller
@RequestMapping("industry")
public class IndustryController {
    @Autowired
    UserIndustryService userIndustryService;

    /**
     * @return java.lang.String
     * @Description: 插入行业字典
     * @Param [userIndustry]
     * @author Murray Law
     * @date 2020/1/11 14:01
     */
    @PostMapping("insertUserIndustry")
    @ResponseBody
    public String insertUserIndustry(@RequestBody UserIndustry userIndustry) {
        if (userIndustryService.insertUserIndustry(userIndustry) > 0) {
            return "插入行业字典成功";
        } else {
            return "插入行业字典失败";
        }

    }

    @PostMapping("deleteUserIndustry")
    @ResponseBody
    public String deleteUserIndustry(@RequestBody UserIndustry userIndustry) {
        if (userIndustryService.deleteUserIndustry(userIndustry) > 0) {
            return "删除行业字典成功";
        } else {
            return "删除行业字典失败";
        }
    }

    /**
     * @return java.lang.String
     * @Description: 修改行业字典
     * @Param [userIndustry]
     * @author Murray Law
     * @date 2020/1/11 16:52
     */
    @PostMapping("updateUserIndustry")
    @ResponseBody
    public String updateUserIndustry(@RequestBody UserIndustry userIndustry) {
        if (userIndustryService.updateUserIndustry(userIndustry) > 0) {
            return "修改行业字典成功";
        } else {
            return "修改行业字典失败";
        }
    }

    //查询所有行业
    @GetMapping("findAllWithUserIndustry")
    @ResponseBody
    public List<UserIndustry> findAllWithUserIndustry() {
        return userIndustryService.findAllWithUserIndustry();
    }

    //寻找行业
    @PostMapping("findByUserIndustry")
    @ResponseBody
    public List<UserIndustry> findByUserIndustry(@RequestBody UserIndustry userIndustry) {
        return userIndustryService.findByUserIndustry(userIndustry);
    } //分页查找行业
    @PostMapping("findPageByUserIndustry")
    @ResponseBody
    public LayUi findPageByUserIndustry(@RequestParam Map<String, Object> params) {
        return userIndustryService.findPageByLayUIWithUserIndustry(params);
    }
}
