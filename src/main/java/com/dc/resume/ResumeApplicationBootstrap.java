package com.dc.resume;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.servlet.MultipartConfigElement;

/**
 * @author wx
 * @version v1.0.0
 * @className ResumeApplicationBootstarp
 * @description bootstarp
 * @date 2019/12/14 19:11
 * @Copyright: 2020 www.decheng1024.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳得程信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@SpringBootApplication(scanBasePackages = "com.dc")
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan("com.dc")
public class ResumeApplicationBootstrap {
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //允许上传的文件最大值
        factory.setMaxFileSize("5MB");
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("5MB");
        return factory.createMultipartConfig();
    }

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(ResumeApplicationBootstrap.class);
        builder.build().run(args);

    }
}
