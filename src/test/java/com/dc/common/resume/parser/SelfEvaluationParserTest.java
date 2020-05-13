package com.dc.common.resume.parser;

import com.dc.common.resume.BaseTest;
import com.dc.common.util.resume.domain.SelfEvaluation;
import com.dc.common.util.resume.parser.SelfEvaluationParser;
import org.junit.Test;

import java.io.File;

public class SelfEvaluationParserTest extends BaseTest {


    @Test
    public void oneBaseInfoOn51job1() throws Exception {
        File f = new File(basePath + "51job_简兆坚(57768818).doc");
        String html = converHtml(f);
        SelfEvaluationParser infoParser = new SelfEvaluationParser(html);
        SelfEvaluation parse = infoParser.parse();

        System.out.println("parse = " + parse);
    }

    @Test
    public void oneBaseInfoOn51job2() throws Exception {
        File f = new File(basePath + "51job_黄伟康(496699083).doc");
        String html = converHtml(f);
        SelfEvaluationParser infoParser = new SelfEvaluationParser(html);
        SelfEvaluation parse = infoParser.parse();

        System.out.println("parse = " + parse);
    }

    @Test
    public void oneBaseInfoOn51job3() throws Exception {
        File f = new File(basePath + "51job_王维爱(492726471).doc");
        String html = converHtml(f);
        SelfEvaluationParser infoParser = new SelfEvaluationParser(html);
        SelfEvaluation parse = infoParser.parse();

        System.out.println("parse = " + parse);
    }

    @Test
    public void oneBaseInfoOnBoss() throws Exception {
        File f = new File(basePath + "boss直聘何正宇3年.docx");
        String html = converHtml(f);
        SelfEvaluationParser infoParser = new SelfEvaluationParser(html);
        SelfEvaluation parse = infoParser.parse();

        System.out.println("parse = " + parse);
    }

    @Test
    public void oneBaseInfoOnZhiLian() throws Exception {
        File f = new File(basePath + "智联招聘_胡程_软件测试工程师_中文_20191031_1572509741654.doc");
        String html = converHtml(f);
        SelfEvaluationParser infoParser = new SelfEvaluationParser(html);
        SelfEvaluation parse = infoParser.parse();

        System.out.println("parse = " + parse);
    }

    @Test
    public void oneBaseInfoOnZhiLian1() throws Exception {
        File f = new File(basePath + "智联招聘_伍泉_高级Android开发工程师_中文_20191104_1572832055378.doc");
        String html = converHtml(f);
        SelfEvaluationParser infoParser = new SelfEvaluationParser(html);
        SelfEvaluation parse = infoParser.parse();

        System.out.println("parse = " + parse);
    }

    @Test
    public void oneBaseInfoOnZhiLian2() throws Exception {
        File f = new File(basePath + "智联招聘_伍祖辉_中级前端工程师_中文_20191105_1572919075535.doc");
        String html = converHtml(f);
        SelfEvaluationParser infoParser = new SelfEvaluationParser(html);
        SelfEvaluation parse = infoParser.parse();

        System.out.println("parse = " + parse);
    }

    @Test
    public void oneBaseInfoOnZhuoPin() throws Exception {
        File f = new File(basePath + "智联卓聘_中文_()_20191127 (3).doc");
        String html = converHtml(f);
        SelfEvaluationParser infoParser = new SelfEvaluationParser(html);
        SelfEvaluation parse = infoParser.parse();

        System.out.println("parse = " + parse);
    }

    @Test
    public void oneBaseInfoOnZhuoPin1() throws Exception {
        File f = new File(basePath + "智联卓聘_中文_()_20191127 (4).doc");
        String html = converHtml(f);
        SelfEvaluationParser infoParser = new SelfEvaluationParser(html);
        SelfEvaluation parse = infoParser.parse();

        System.out.println("parse = " + parse);
    }

    @Test
    public void oneBaseInfoOnZhuoPin2() throws Exception {
        File f = new File(basePath + "智联卓聘_中文_()_20191127 (9).doc");
        String html = converHtml(f);
        SelfEvaluationParser infoParser = new SelfEvaluationParser(html);
        SelfEvaluation parse = infoParser.parse();

        System.out.println("parse = " + parse);
    }

    @Test
    public void oneBaseInfoOnZhuoPin3() throws Exception {
        File f = new File(basePath + "智联卓聘_中文20191101.doc");
        String html = converHtml(f);
        SelfEvaluationParser infoParser = new SelfEvaluationParser(html);
        SelfEvaluation parse = infoParser.parse();

        System.out.println("parse = " + parse);
    }

    @Test
    public void oneBaseInfoOnRenCai() throws Exception {
        File f = new File(basePath + "软件测试工程师安文卿(J9981160).doc");
        String html = converHtml(f);
        SelfEvaluationParser infoParser = new SelfEvaluationParser(html);
        SelfEvaluation parse = infoParser.parse();

        System.out.println("parse = " + parse);
    }
}
