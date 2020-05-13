package com.dc.framework.lang.text;

import java.util.Locale;
import java.util.Map;

import com.dc.framework.lang.collection.Collections;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author wx
 * @version v1.0.0
 * @className Springs
 * @description 以静态变量保存Spring ApplicationContext, 可在任何代码任何地方任何时候中取出ApplicaitonContext
 * @date 2019/12/25 17:11
 * @Copyright: 2020 www.decheng1024.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳得程信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Component
public class Springs  implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    /**
     * 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.
     */
    public void setApplicationContext(ApplicationContext applicationContext) {

        Springs.applicationContext = applicationContext;
    }

    /**
     * 取得存储在静态变量中的ApplicationContext.
     */
    public static ApplicationContext getApplicationContext() {

        checkApplicationContext();
        return applicationContext;
    }

    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {

        checkApplicationContext();
        return (T) applicationContext.getBean(name);
    }

    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型. 如果同Class类型配置了多个Bean，只返回第一个
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> clazz) {

        checkApplicationContext();
        Map beans = applicationContext.getBeansOfType(clazz);
        return (T) Collections.first(beans.values());
    }

    /**
     * 获取一个在SpringContext定义的消息资源的某个消息
     *
     * @return
     */
    public static String getMessage(String code, String defaultMessage, Locale locale,
                                    Object... args) {

        return getApplicationContext().getMessage(code, args, defaultMessage, locale);
    }

    /**
     * 获取一个在SpringContext定义的消息资源的某个消息
     *
     * @return
     */
    public static String getMessage(String code, Locale locale, Object... args) {

        return getApplicationContext().getMessage(code, args, locale);
    }

    public static String getMessage(String code, Object... args) {

        return getMessage(code, Locale.CHINA, args);
    }


    private static void checkApplicationContext() {

        if (applicationContext == null) {
            throw new IllegalStateException(
                    "applicaitonContext未注入,请定义Springs");
        }
    }
}
