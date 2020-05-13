package com.dc.resume.controller;

import com.dc.common.domain.UserJob;
import com.dc.common.util.base.LayUi;
import com.dc.resume.service.UserJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author:MuweiLaw
 * @Date:2020/2/27 18:17
 */
@Controller
@RequestMapping("job")
public class JobController {
    @Autowired
    UserJobService userJobService;
    /**
     * @return java.lang.String
     * @Description: 插入职业/职能字典
     * @Param [userJob]
     * @author Murray Law
     * @date 2020/1/11 14:03
     */
    @PostMapping("insertUserJob")
    @ResponseBody
    public String insertUserJob(@RequestBody UserJob userJob) {
        if (userJobService.insertJobDao(userJob) > 0) {
            return "插入职业字典成功";
        } else {
            return "插入职业字典失败";
        }

    }  @PostMapping("deleteUserJob")
    @ResponseBody
    public String deleteUserJob(@RequestBody UserJob userJob) {
        if (userJobService.deleteUserJob(userJob) > 0) {
            return "删除职位字典成功";
        } else {
            return "删除职位字典失败";
        }
    }

    //更新职位
    @PostMapping("updateUserJob")
    @ResponseBody
    public String updateUserJob(@RequestBody UserJob userJob) {
        if (userJobService.updateUserJob(userJob) > 0) {
            return "修改职位字典成功";
        } else {
            return "修改职位字典失败";
        }
    }
    //查询所有职位
    @GetMapping("findAllWithUserJob")
    @ResponseBody
    public List<UserJob> findAllWithUserJob() {
        return userJobService.findAllWithUserJob();
    }

    //寻找职位
    @PostMapping("findByUserJob")
    @ResponseBody
    public List<UserJob> findByUserJob(@RequestBody UserJob userJob) {
        return userJobService.findByUserJob(userJob);
    }//分页查找职位
    @PostMapping("findPageByUserJob")
    @ResponseBody
    public LayUi findPageByUserJob(@RequestParam Map<String, Object> params) {
        return userJobService.findPageByLayUIWithUserJob(params);
    }
}
