package com.dc.resume.controller;

import com.dc.common.domain.UserMajor;
import com.dc.common.util.base.LayUi;
import com.dc.resume.service.UserMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author:MuweiLaw
 * @Date:2020/1/10 18:29
 */
@Controller
@RequestMapping("major")
public class MajorController {
    @Autowired
    UserMajorService userMajorService;


    /**
     * @return java.lang.String
     * @Description: 插入用户专业
     * @Param [userMajor]
     * @author Murray Law
     * @date 2020/1/11 14:01
     */
    @PostMapping("insertUserMajor")
    @ResponseBody
    public String insertUserMajor(@RequestBody UserMajor userMajor) {
        if (userMajorService.insertUserMajor(userMajor) > 0) {
            return "插入专业字典成功";
        } else {
            return "插入专业字典失败";
        }
    }

    @PostMapping("deleteUserMajor")
    @ResponseBody
    public String deleteUserMajor(@RequestBody UserMajor userMajor) {
        if (userMajorService.deleteUserMajor(userMajor) > 0) {
            return "删除专业字典成功";
        } else {
            return "删除专业字典失败";
        }
    }


    //更新专业
    @PostMapping("updateUserMajor")
    @ResponseBody
    public String updateUserMajor(@RequestBody UserMajor userMajor) {
        if (userMajorService.updateUserMajor(userMajor) > 0) {
            return "修改专业字典成功";
        } else {
            return "修改专业字典失败";
        }
    }


    //查询所有专业
    @GetMapping("findAllWithUserMajor")
    @ResponseBody
    public List<UserMajor> findAllWithUserMajor() {
        return userMajorService.findAllWithUserMajor();
    }


    //寻找专业
    @PostMapping("findByUserMajor")
    @ResponseBody
    public List<UserMajor> findByUserMajor(@RequestBody UserMajor userMajor) {
        return userMajorService.findByUserMajor(userMajor);
    }


    //分页查找专业
    @PostMapping("findPageByUserMajor")
    @ResponseBody
    public LayUi findPageByUserMajor(@RequestParam Map<String, Object> params) {

        return userMajorService.findPageByLayUIWithUserMajor(params);
    }


}
