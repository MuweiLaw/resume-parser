package com.dc.configuration;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wx
 * @version v1.0.0
 * @className WebMvcConfigurer
 * @description TODO
 * @date 2019/12/14 20:51
 * @Copyright: 2020 www.decheng.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳得程信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Configuration
public class WebMvcConfigurer  implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 配置 FastJson
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.QuoteFieldNames, SerializerFeature.WriteEnumUsingToString,
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.DisableCircularReferenceDetect);

        // 添加 FastJsonHttpMessageConverter
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        fastJsonHttpMessageConverter.setFastJsonConfig(config);
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
        converters.add(fastJsonHttpMessageConverter);

        // 添加 StringHttpMessageConverter，解决中文乱码问题
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        converters.add(stringHttpMessageConverter);
    }


    /*资源处理器*/
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/"+"/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/"+"/js/");
        registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/"+"/img/");
        registry.addResourceHandler("/plugin/**").addResourceLocations("/WEB-INF/"+"/plugin/");
        registry.addResourceHandler("/bootstrap-3.3.7-dist/**").addResourceLocations("/WEB-INF/"+"/bootstrap-3.3.7-dist/");
        registry.addResourceHandler("/common/**").addResourceLocations("/WEB-INF/"+"/common/");
        registry.addResourceHandler("/statics/**").addResourceLocations("/WEB-INF/"+"/statics/");
    }
}
