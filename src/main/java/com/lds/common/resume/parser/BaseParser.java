package com.lds.common.resume.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public abstract class BaseParser {

    protected Element root;

    protected String content;

    public BaseParser(String content) {
        this.content = content;
        this.root = Jsoup.parse(content);
    }

    public String matchDegree(Element ele) {
        String degree = "...";
        if(ele.getElementsMatchingOwnText("研究生").size() > 0){
            return "研究生";
        }
        if(ele.getElementsMatchingOwnText("本科").size() > 0){
            return "本科";
        }
        if(ele.getElementsMatchingOwnText("大专").size() > 0){
            return "大专";
        }
        return degree;
    }

    public String matchDegree(String content) {
        if(content.contains("研究生")){
            return "研究生";
        }
        if(content.contains("本科")){
            return "本科";
        }
        if(content.contains("大专")){
            return "大专";
        }
        return "";
    }
}
