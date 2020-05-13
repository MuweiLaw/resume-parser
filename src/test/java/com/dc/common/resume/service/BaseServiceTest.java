package com.dc.common.resume.service;

import com.dc.common.resume.BaseTest;
import com.dc.resume.ResumeApplicationBootstrap;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wx
 * @version v1.0.0
 * @className BaseServiceTest
 * @description TODO
 * @date 2019/12/25 17:03
 * @Copyright: 2020 www.decheng1024.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳得程信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = ResumeApplicationBootstrap.class)
public class BaseServiceTest extends BaseTest {
}
