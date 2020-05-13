package com.dc.common.util.resume.parser;

import com.dc.common.util.resume.domain.SelfEvaluation;
import org.jsoup.select.Elements;

/**
 * @Description:
 * @author:MuweiLaw
 * @Date:2019/12/12 10:06
 */

public class SelfEvaluationParser extends BaseParser {
    public SelfEvaluationParser(String content) {
        super(content);
    }

    public SelfEvaluation parse() {
        SelfEvaluation selfEvaluation = new SelfEvaluation();
        selfEvaluation.setSelfEvaluation(matchSelfEvaluation());
        return selfEvaluation;
    }

    private String matchSelfEvaluation() {
        //智联
        Elements selfEvaluation = root.getElementsMatchingOwnText("^自我评价$");
        String sytle = "font-size:15.0pt;font-family:宋体;mso-ascii-font-family:\n" +
                "Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:\n" +
                "minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin;\n" +
                "background:#D9D9D9;mso-shading:white;mso-pattern:gray-15 auto";
        //智联
        if (selfEvaluation.size() > 0 && (selfEvaluation.first().getElementsByAttributeValue("style", sytle)).size() > 0) {
            return selfEvaluation.first().parent().parent().nextElementSibling().text();
        }
        //智联1
        if (selfEvaluation.size() > 0 && (selfEvaluation.first().getElementsByAttributeValue("face", "宋体")).size() > 0) {
            return selfEvaluation.first().parent().parent().parent().nextElementSibling().text();
        }
        //卓聘
        if (selfEvaluation.size() > 0 && (selfEvaluation.first().getElementsByAttributeValue("style", "font-size: 14px;")).size() > 0) {
            return selfEvaluation.first().parent().parent().parent().parent().parent().nextElementSibling().text();
        }
        //人才热线
        if (selfEvaluation.size() > 0 && (selfEvaluation.first().getElementsByAttributeValue("style", "font:12px/20px Arial; color:#ffffff; padding:0 25px; height:20px;")).size() > 0) {
            return selfEvaluation.first().parent().nextElementSibling().text();
        }
        //51Job
        selfEvaluation = root.getElementsMatchingOwnText("^自我评价：$");
        if (selfEvaluation.size() > 0) {
            if (selfEvaluation.first().getElementsByAttributeValue("class", "keys").size() > 0) {
                return selfEvaluation.next().text();
            }
        }
        return "";
    }
}
