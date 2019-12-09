package com.lds.common.resume.processor;

import org.jsoup.Jsoup;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author wx
 * @version 1.0.0
 * @description html,plain格式处理
 * @date 2019/11/20 15:45
 **/
public class StandardConvertProcessor extends AbstractConvertProcessor {

    private List textMediaList = Arrays.asList("text/html","text/plain","application/xhtml+xml");

    public StandardConvertProcessor() {
    }

    @Override
    protected String convertProcessor(InputStream in,String charset) throws Exception {
        return Jsoup.parse(super.read(in,charset)).body().html();
    }

    @Override
    public boolean isSupport(String mediaType) {
        return textMediaList.contains(mediaType);
    }
}