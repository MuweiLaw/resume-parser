package com.dc.common.resume.parser;

import com.dc.common.resume.BaseTest;
import com.dc.common.util.resume.domain.CareerObjective;
import com.dc.common.util.resume.parser.CareerObjectiveParser;
import org.junit.Test;

import java.io.File;

/**
 * @Description:求职意向的解析测试类
 * @author:MuweiLaw
 * @Date:2019/12/5 16:31
 */

public class CareerObjectiveParserTest extends BaseTest {
    @Test
    public void matchExpectingInsuatryBy51Job() throws Exception {
        File f = new File(basePath + "51job_王维爱(492726471).doc");
//        转换html
        String html = converHtml(f);
//        信息解析器
        CareerObjectiveParser careerObjectiveParser = new CareerObjectiveParser(html);
        CareerObjective parse = careerObjectiveParser.parse();

        System.out.println("parse = " + parse.toString());
    }

    @Test
    public void matchExpectingInsuatryByZhiLian() throws Exception {
        File f = new File(basePath + "智联招聘_奚钰格_运营专员_中文_20191108_1573202487643.doc");
//        转换html
        String html = converHtml(f);
//        信息解析器
        CareerObjectiveParser careerObjectiveParser = new CareerObjectiveParser(html);
        CareerObjective parse = careerObjectiveParser.parse();

        System.out.println("parse = " + parse.toString());
    }

    @Test
    public void matchExpectingInsuatryByZhiLian1() throws Exception {
        File f = new File(basePath + "智联招聘_郗文丽_数据分析BI方向_中文_20191108_1573193615159.doc");
//        转换html
        String html = converHtml(f);
//        信息解析器
        CareerObjectiveParser careerObjectiveParser = new CareerObjectiveParser(html);
        CareerObjective parse = careerObjectiveParser.parse();

        System.out.println("parse = " + parse.toString());
    }

    @Test
    public void matchExpectingInsuatryByZhiLian2() throws Exception {
        File f = new File(basePath + "智联招聘_温绍勇_Java研发工程师_中文_20191111_1573438920974.doc");
//        转换html
        String html = converHtml(f);
//        信息解析器
        CareerObjectiveParser careerObjectiveParser = new CareerObjectiveParser(html);
        CareerObjective parse = careerObjectiveParser.parse();

        System.out.println("parse = " + parse.toString());
    }

    @Test
    public void matchExpectingInsuatryByZhiLian3() throws Exception {
        File f = new File(basePath + "智联招聘_温琦生_项目运营总监_中文_20191105_1572919559195.doc");
//        转换html
        String html = converHtml(f);
//        信息解析器
        CareerObjectiveParser careerObjectiveParser = new CareerObjectiveParser(html);
        CareerObjective parse = careerObjectiveParser.parse();

        System.out.println("parse = " + parse.toString());
    }

    @Test
    public void matchExpectingInsuatryByZhiLian4() throws Exception {
        File f = new File(basePath + "智联招聘_席蒙_中级java开发工程师_中文_20191108_1573202626819.doc");
//        转换html
        String html = converHtml(f);
//        信息解析器
        CareerObjectiveParser careerObjectiveParser = new CareerObjectiveParser(html);
        CareerObjective parse = careerObjectiveParser.parse();

        System.out.println("parse = " + parse.toString());
    }

    @Test
    public void matchExpectingInsuatryByZhuoPin() throws Exception {
        File f = new File(basePath + "智联卓聘_中文_()_20191127 (4).doc");
//        转换html
        String html = converHtml(f);
//        信息解析器
        CareerObjectiveParser careerObjectiveParser = new CareerObjectiveParser(html);
        CareerObjective parse = careerObjectiveParser.parse();

        System.out.println("parse = " + parse.toString());
    }

    @Test
    public void matchExpectingInsuatryByZhuoPin1() throws Exception {
        File f = new File(basePath + "智联卓聘_中文_()_20191127 (3).doc");
//        转换html
        String html = converHtml(f);
//        信息解析器
        CareerObjectiveParser careerObjectiveParser = new CareerObjectiveParser(html);
        CareerObjective parse = careerObjectiveParser.parse();

        System.out.println("parse = " + parse.toString());
    }

    @Test
    public void matchExpectingInsuatryByZhuoPin2() throws Exception {
        File f = new File(basePath + "智联卓聘_中文_()_20191127 (7).doc");
//        转换html
        String html = converHtml(f);
//        信息解析器
        CareerObjectiveParser careerObjectiveParser = new CareerObjectiveParser(html);
        CareerObjective parse = careerObjectiveParser.parse();

        System.out.println("parse = " + parse.toString());
    }

    @Test
    public void matchExpectingInsuatryByZhuoPin3() throws Exception {
        File f = new File(basePath + "智联卓聘_中文_()_20191127 (9).doc");
//        转换html
        String html = converHtml(f);
//        信息解析器
        CareerObjectiveParser careerObjectiveParser = new CareerObjectiveParser(html);
        CareerObjective parse = careerObjectiveParser.parse();

        System.out.println("parse = " + parse.toString());
    }

    @Test
    public void matchExpectingInsuatryByZhuoPin4() throws Exception {
        File f = new File(basePath + "智联卓聘_中文__20191127 (4).doc");
//        转换html
        String html = converHtml(f);
//        信息解析器
        CareerObjectiveParser careerObjectiveParser = new CareerObjectiveParser(html);
        CareerObjective parse = careerObjectiveParser.parse();

        System.out.println("parse = " + parse.toString());
    }

    @Test
    public void matchExpectingInsuatryByZhuoPin5() throws Exception {
        File f = new File(basePath + "智联卓聘_中文_()_20191101 (16).doc");
//        转换html
        String html = converHtml(f);
//        信息解析器
        CareerObjectiveParser careerObjectiveParser = new CareerObjectiveParser(html);
        CareerObjective parse = careerObjectiveParser.parse();

        System.out.println("parse = " + parse.toString());
    }

    @Test
    public void matchExpectingInsuatryByZhuoPin6() throws Exception {
        File f = new File(basePath + "智联卓聘_中文20191101.doc");
        String html = converHtml(f);
        CareerObjectiveParser careerObjectiveParser = new CareerObjectiveParser(html);
        CareerObjective parse = careerObjectiveParser.parse();

        System.out.println("parse = " + parse.toString());
    }@Test
    public void matchExpectingInsuatryByRenCai() throws Exception {
        File f = new File(basePath + "高级.NET工程师余正伟(J4511083).doc");
        String html = converHtml(f);
        CareerObjectiveParser careerObjectiveParser = new CareerObjectiveParser(html);
        CareerObjective parse = careerObjectiveParser.parse();

        System.out.println("parse = " + parse.toString());
    }@Test
    public void matchExpectingInsuatryByRenCai1() throws Exception {
        File f = new File(basePath + "运营专员张雅花(J9972636).doc");
        String html = converHtml(f);
        CareerObjectiveParser careerObjectiveParser = new CareerObjectiveParser(html);
        CareerObjective parse = careerObjectiveParser.parse();

        System.out.println("parse = " + parse.toString());
    }@Test
    public void matchExpectingInsuatryByRenCai2() throws Exception {
        File f = new File(basePath + "高级软件工程师吴财圣(J9982025).doc");
        String html = converHtml(f);
        CareerObjectiveParser careerObjectiveParser = new CareerObjectiveParser(html);
        CareerObjective parse = careerObjectiveParser.parse();

        System.out.println("parse = " + parse.toString());
    }
}
