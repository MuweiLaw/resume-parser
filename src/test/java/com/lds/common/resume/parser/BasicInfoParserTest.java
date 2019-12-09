package com.lds.common.resume.parser;

import com.lds.common.resume.BaseTest;
import com.lds.common.resume.domain.BasicInfo;
import com.lds.common.resume.parser.BasicInfoParser;
import org.junit.Test;

import java.io.File;

public class BasicInfoParserTest extends BaseTest {


    @Test
    public void oneBaseInfoOn51job1() throws Exception {
        File f = new File(basePath + "51job_全业萍(767697783).doc");
        String html = converHtml(f);
        BasicInfoParser infoParser = new BasicInfoParser(html);
        BasicInfo parse = infoParser.parse();

        System.out.println("parse = " + parse);
    }

    @Test
    public void oneBaseInfoOn51job2() throws Exception {
        File f = new File(basePath + "51job_凌志伟(735658519).doc");
        String html = converHtml(f);
        BasicInfoParser infoParser = new BasicInfoParser(html);
        BasicInfo parse = infoParser.parse();

        System.out.println("parse = " + parse);
    }
    @Test
    public void oneBaseInfoOn51job3() throws Exception {
        File f = new File(basePath + "51job_王维爱(492726471).doc");
        String html = converHtml(f);
        BasicInfoParser infoParser = new BasicInfoParser(html);
        BasicInfo parse = infoParser.parse();

        System.out.println("parse = " + parse);
    }

    @Test
    public void oneBaseInfoOnBoss() throws Exception {
        File f = new File(basePath + "51job_全业萍(767697783).doc");
        String html = converHtml(f);
        BasicInfoParser infoParser = new BasicInfoParser(html);
        BasicInfo parse = infoParser.parse();

        System.out.println("parse = " + parse);
    }
}
