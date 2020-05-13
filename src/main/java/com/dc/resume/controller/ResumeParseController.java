package com.dc.resume.controller;

import com.dc.common.domain.UserSkills;
import com.dc.framework.page.Page;
import com.dc.framework.page.PageContext;
import com.dc.resume.service.ResumeParseService;
import com.dc.resume.service.UserSkillsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wx
 * @version v1.0.0
 * @className ResumeParseController
 * @description 简历解析控制器
 * @date 2019/12/14 17:09
 * @Copyright: 2020 www.decheng.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳龙得水信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Slf4j
@RestController
public class ResumeParseController {

    @Autowired
    private ResumeParseService resumeParseService;

    @Autowired
    UserSkillsService userSkillsService;

    @PostMapping("/parseResume")
    public Map<String, String> parseResume(MultipartFile file) throws IOException {
        Map<String, String> map = new HashMap<>();
        try {
            InputStream inputStream = file.getInputStream();
            String resumeId = resumeParseService.parseResume(inputStream);
            map.put("code", "success");
            map.put("resumeId", resumeId);
            return map;
        } catch (Exception e) {
            map.put("msg", e.getMessage());
        }
        map.put("code", "failed");
        return map;
    }


    @PostMapping("/list")
    @ResponseBody
    public Page parseResume(int page, int limit) throws IOException {
        PageContext pageContext = new PageContext();
        RowBounds rowBounds = new RowBounds((page-1)*limit,limit);
        pageContext.setRowBounds(rowBounds);
        Page<UserSkills> p = userSkillsService.findPage(pageContext);
        return p;
    }

}
