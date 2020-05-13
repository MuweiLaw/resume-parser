package com.dc.common.resume.parser;

import com.dc.common.resume.BaseTest;
import com.dc.common.util.resume.domain.Education;
import com.dc.common.util.resume.parser.EducationParser;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * @author wx
 * @version 1.0.0
 * @className EducationParserTest
 * @description TODO
 * @date 2019/12/6 15:05
 */
public class EducationParserTest extends BaseTest {

    @Test
    public void oneEducationParseBy51Job() throws Exception {
        File f = new File(basePath + "51job_黄志崇(439114242).doc");
        String html = converHtml(f);
        EducationParser parser = new EducationParser(html);
        System.out.println(parser.parse().toString());
    }

    @Test
    public void oneEducationParseBy51Job1() throws Exception {
        File f = new File(basePath + "51job_简兆坚(57768818).doc");
        String html = converHtml(f);

        EducationParser parser = new EducationParser(html);
        System.out.println(parser.parse().toString());

    }

    @Test
    public void oneEducationParseBy51Job2() throws Exception {
        File f = new File(basePath + "51job_黄子欣(492361147).doc");
        String html = converHtml(f);

        EducationParser parser = new EducationParser(html);
        System.out.println(parser.parse().toString());
    }

    @Test
    public void oneEducationZhiLian() throws Exception {
        File f = new File(basePath + "智联招聘_胡程_软件测试工程师_中文_20191031_1572509741654.doc");
        String html = converHtml(f);

        EducationParser parser = new EducationParser(html);
        System.out.println(parser.parse().toString());
    }

    @Test
    public void oneEducationZhiLian0() throws Exception {
        File f = new File(basePath + "智联招聘_温琦生_项目运营总监_中文_20191105_1572919559195.doc");
        String html = converHtml(f);

        EducationParser parser = new EducationParser(html);
        System.out.println(parser.parse().toString());
    }
    @Test
    public void matchExpectingInsuatryByZhuoPin() throws Exception {
        File f = new File(basePath + "智联卓聘_中文_()_20191127 (4).doc");
//        转换html
        String html = converHtml(f);
//        信息解析器
        EducationParser parser = new EducationParser(html);

        System.out.println("parse = " + parser.parse().toString());
    }

    @Test
    public void matchExpectingInsuatryByZhuoPin1() throws Exception {
        File f = new File(basePath + "智联卓聘_中文_()_20191127 (3).doc");
//        转换html
        String html = converHtml(f);
//        信息解析器
        EducationParser parser = new EducationParser(html);

        System.out.println("parse = " + parser.parse().toString());
    }

    @Test
    public void matchExpectingInsuatryByZhuoPin2() throws Exception {
        File f = new File(basePath + "智联卓聘_中文_()_20191127 (7).doc");
//        转换html
        String html = converHtml(f);
//        信息解析器
        EducationParser parser = new EducationParser(html);

        System.out.println("parse = " + parser.parse().toString());
    }

    @Test
    public void matchExpectingInsuatryByZhuoPin3() throws Exception {
        File f = new File(basePath + "智联卓聘_中文_()_20191127 (9).doc");
//        转换html
        String html = converHtml(f);
//        信息解析器
        EducationParser parser = new EducationParser(html);

        System.out.println("parse = " + parser.parse().toString());
    }

    @Test
    public void matchExpectingInsuatryByZhuoPin4() throws Exception {
        File f = new File(basePath + "智联卓聘_中文__20191127 (4).doc");
//        转换html
        String html = converHtml(f);
//        信息解析器
        EducationParser parser = new EducationParser(html);

        System.out.println("parse = " + parser.parse().toString());
    }

    @Test
    public void matchExpectingInsuatryByZhuoPin5() throws Exception {
        File f = new File(basePath + "智联卓聘_中文_()_20191101 (16).doc");
//        转换html
        String html = converHtml(f);
//        信息解析器
        EducationParser parser = new EducationParser(html);

        System.out.println("parse = " + parser.parse().toString());
    }

    @Test
    public void matchExpectingInsuatryByZhuoPin6() throws Exception {
        File f = new File(basePath + "智联卓聘_中文20191101.doc");
//        转换html
        String html = converHtml(f);
//        信息解析器
        EducationParser parser = new EducationParser(html);

        System.out.println("parse = " + parser.parse().toString());
    }
    @Test
    public void oneBaseInfoOnRenCai() throws Exception {
        File f = new File(basePath + "高级.NET工程师余正伟(J4511083).doc");
        String html = converHtml(f);
        EducationParser parser = new EducationParser(html);
        List<Education> educaton = parser.parse();

        System.out.println("educaton = " + educaton);
    } @Test
    public void oneBaseInfoOnRenCai1() throws Exception {
        File f = new File(basePath + "运营专员张雅花(J9972636).doc");
        String html = converHtml(f);
        EducationParser parser = new EducationParser(html);
        List<Education> educaton = parser.parse();

        System.out.println("educaton = " + educaton);
    } @Test
    public void oneBaseInfoOnRenCai2() throws Exception {
        File f = new File(basePath + "软件测试工程师安文卿(J9981160).doc");
        String html = converHtml(f);
        EducationParser parser = new EducationParser(html);
        List<Education> educaton = parser.parse();

        System.out.println("educaton = " + educaton);
    } @Test
    public void oneBaseInfoOnRenCai3() throws Exception {
        File f = new File(basePath + "运维工程师杜旭升(J3547848).doc");
        String html = converHtml(f);
        EducationParser parser = new EducationParser(html);
        List<Education> educaton = parser.parse();

        System.out.println("educaton = " + educaton);
    }
    @Test
    public void oneBaseInfoOnBoss() throws Exception {
        File f = new File(basePath + "boss直聘何正宇3年.docx");
        String html = converHtml(f);
        EducationParser parser = new EducationParser(html);
        List<Education> educaton = parser.parse();

        System.out.println("educaton = " + educaton);
    }
}
