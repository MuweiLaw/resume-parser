package com.dc.common.util.resume.processor;

import com.dc.common.util.Base64Utils;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wx
 * @version 1.0.0
 * @description 处理MIME邮件格式
 * @date 2019/11/20 14:00
 **/
public class EmlConvertProcessor extends AbstractConvertProcessor {

    private String rfc822MediaType = "message/rfc822";
    private String MESSAGE_RFC822_FLAG = "Content-Type:multipart/related;boundary=";
    private String MESSAGE_RFC822_TRANSFER_ENCODING = "Content-Transfer-Encoding:base64";

    public EmlConvertProcessor() {
    }

    @Override
    public boolean isSupport(String mediaType) {
        return rfc822MediaType.equals(mediaType);
    }

    @Override
    protected String convertProcessor(InputStream in,String charset) throws IOException {
        String text = super.read(in,charset);
        if(!Objects.isNull(text) && text.indexOf(MESSAGE_RFC822_FLAG) > -1){

            String  content = text.substring(text.indexOf(MESSAGE_RFC822_FLAG) + MESSAGE_RFC822_FLAG.length());
            String boundary = "";
            Matcher matcher = Pattern.compile("\"--boundary(.*?)\"").matcher(content);
            if( !matcher.find()){
                return "";
            }
            boundary = matcher.group().replaceAll("\"","");
            System.out.println("boundary = " + boundary);
            if(text.indexOf("--" + boundary) != -1){
                boundary = "--" + boundary;
            }
            String paragraph = content.split(boundary)[1];
            if( paragraph.indexOf(MESSAGE_RFC822_TRANSFER_ENCODING) != -1 ){
                String html = paragraph.substring(paragraph.indexOf(MESSAGE_RFC822_TRANSFER_ENCODING) + MESSAGE_RFC822_TRANSFER_ENCODING.length());
                return Jsoup.parse(Base64Utils.decode(html,charset)).html();
            }
        }
        return Jsoup.parse(text).body().html();
    }
}