package com.lds.common.resume.processor;

import java.io.InputStream;

/**
 * @author wx
 * @version 1.0.0
 * @description 简历转换处理接口
 * @date 2019/11/20 11:38
 **/
public interface ConvertProcessor {

    /**
     * 是否支持该media类型的解析
     * @param mediaType
     * @return
     */
    boolean isSupport(String mediaType);

    /**
     * 生成String
     * @return
     */
    String convert(InputStream in, String chartset) throws Exception;

}