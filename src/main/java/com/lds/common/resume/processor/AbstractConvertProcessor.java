package com.lds.common.resume.processor;

import org.apache.tika.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wx
 * @version 1.0.0
 * @description 简历解析抽象类
 * @date 2019/11/20 11:45
 **/
public abstract class AbstractConvertProcessor implements ConvertProcessor {

    protected static final Logger loger = LoggerFactory.getLogger(AbstractConvertProcessor.class);

    public AbstractConvertProcessor() {
    }

    public String convert(InputStream in,String chartset) throws Exception{
        try {
            String str = convertProcessor(in, chartset);
            if( null == str){
                str = read(in,chartset);
            }
            return str;
        }catch (Exception e){
            loger.error(e.getMessage(),e);
        }finally {
            IOUtils.closeQuietly(in);
        }
        return null;
    }

    protected String read(InputStream in,String chartset) throws IOException {
        byte[] bts = new byte[in.available()];
        in.read(bts);
        return new String(bts,chartset);
    }


    protected abstract String convertProcessor(InputStream in,String chartset) throws Exception;


}