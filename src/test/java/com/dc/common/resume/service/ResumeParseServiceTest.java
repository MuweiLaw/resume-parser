package com.dc.common.resume.service;

import com.dc.resume.service.ResumeParseService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author wx
 * @version v1.0.0
 * @className ResumeParseServiceTest
 * @description 简历解析测试
 * @date 2019/12/25 17:02
 * @Copyright: 2020 www.decheng1024.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳得程信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class ResumeParseServiceTest extends BaseServiceTest {

    @Autowired
    private ResumeParseService resumeParseService;

    @Test
    public void parser() throws FileNotFoundException {
        File f = new File(basePath + "51job_李战坤(联通信号不好)(855295820).doc");

        try {
            resumeParseService.parseResume(new FileInputStream(f));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
