package com.dc.common.resume.parser;

import com.dc.common.resume.BaseTest;
import com.dc.common.util.resume.parser.SkillsParser;
import org.junit.Test;

import java.io.File;

/**
 * @author wx
 * @version 1.0.0
 * @className SkillsParserTest
 * @description TODO
 * @date 2019/12/6 15:05
 */
public class SkillsParserTest extends BaseTest {

    @Test
    public void oneSkillsParseZhiLian() throws Exception {
        File f = new File(basePath + "智联招聘_侯钟民_美工_中文_20191221_1576918237510.doc");
        String html = converHtml(f);

        SkillsParser parser = new SkillsParser(html);
        parser.parse().forEach(skills -> {
                    System.out.println(skills.toString());
                }
        );
    }

    @Test
    public void oneSkillsParseZhiLian0() throws Exception {
        File f = new File(basePath + "智联招聘_刘延雄_测试工程师_中文_20191221_1576912122329.doc");
        String html = converHtml(f);

        SkillsParser parser = new SkillsParser(html);
        parser.parse().forEach(skills -> {
                    System.out.println(skills.toString());
                }
        );
    }

    @Test
    public void oneSkillsParse51Job() throws Exception {
        File f = new File(basePath + "51job_雷雨(769346361).doc");
        String html = converHtml(f);

        SkillsParser parser = new SkillsParser(html);
        parser.parse().forEach(skills -> {
                    System.out.println(skills.toString());
                }
        );
    }

    @Test
    public void oneSkillsParseZhuoPin() throws Exception {
        File f = new File(basePath + "智联卓聘_中文_()_20191127 (4).doc");
        String html = converHtml(f);

        SkillsParser parser = new SkillsParser(html);
        parser.parse().forEach(skills -> {
                    System.out.println(skills.toString());
                }
        );
    }

    @Test
    public void oneSkillsParseZhuoPin1() throws Exception {
        File f = new File(basePath + "51job_庞幸珍(763358430).doc");
        String html = converHtml(f);

        SkillsParser parser = new SkillsParser(html);
        parser.parse().forEach(skills -> {
                    System.out.println(skills.toString());
                }
        );
    }

    @Test
    public void oneSkillsParseZhuoPin2() throws Exception {
        File f = new File(basePath + "智联招聘_殷崇贵_JAVA架构师_中文_20191221_1576892320569.doc");
        String html = converHtml(f);

        SkillsParser parser = new SkillsParser(html);
        parser.parse().forEach(skills -> {
                    System.out.println(skills.toString());
                }
        );
    }

    @Test
    public void oneSkillsParseZhuoPin3() throws Exception {
        File f = new File(basePath + "智联卓聘_中文_()_20191127 (3).doc");
        String html = converHtml(f);

        SkillsParser parser = new SkillsParser(html);
        parser.parse().forEach(skills -> {
                    System.out.println(skills.toString());
                }
        );
    }

    @Test
    public void oneSkillsParseRenCai() throws Exception {
        File f = new File(basePath + "JAVA中级李圣隆(J9969434).doc");
        String html = converHtml(f);
        SkillsParser parser = new SkillsParser(html);
        parser.parse().forEach(skills -> {
                    System.out.println(skills.toString());
                }
        );
    }@Test
    public void oneSkillsParseRenCai1() throws Exception {
        File f = new File(basePath + "JAVA中级彭拓(J9478717).doc");
        String html = converHtml(f);
        SkillsParser parser = new SkillsParser(html);
        parser.parse().forEach(skills -> {
                    System.out.println(skills.toString());
                }
        );
    }@Test
    public void oneSkillsParseRenCai2() throws Exception {
        File f = new File(basePath + "NET高级开发工程师曾钊(J5649176).doc");
        String html = converHtml(f);
        SkillsParser parser = new SkillsParser(html);
        parser.parse().forEach(skills -> {
                    System.out.println(skills.toString());
                }
        );
    }@Test
    public void oneSkillsParseRenCai3() throws Exception {
        File f = new File(basePath + "SQA软件测试工程师熊成材(J9666632).doc");
        String html = converHtml(f);
        SkillsParser parser = new SkillsParser(html);
        parser.parse().forEach(skills -> {
                    System.out.println(skills.toString());
                }
        );
    }@Test
    public void oneSkillsParseRenCai4() throws Exception {
        File f = new File(basePath + "web前端开发工程师廖日华(J9979495).doc");
        String html = converHtml(f);
        SkillsParser parser = new SkillsParser(html);
        parser.parse().forEach(skills -> {
                    System.out.println(skills.toString());
                }
        );
    }@Test
    public void oneSkillsParseRenCai5() throws Exception {
        File f = new File(basePath + "全盘会计陈丽丽(J9800899).doc");
        String html = converHtml(f);
        SkillsParser parser = new SkillsParser(html);
        parser.parse().forEach(skills -> {
                    System.out.println(skills.toString());
                }
        );
    }

}
