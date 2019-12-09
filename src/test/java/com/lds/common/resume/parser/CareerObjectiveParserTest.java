package com.lds.common.resume.parser;

import com.lds.common.resume.BaseTest;
import com.lds.common.resume.domain.CareerObjective;
import com.lds.common.resume.parser.CareerObjectiveParser;
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
        File f = new File(basePath + "智联招聘_温超平_软件测试_中文_20191105_1572935670709.doc");
//        转换html
        String html = converHtml(f);
//        信息解析器
        CareerObjectiveParser careerObjectiveParser = new CareerObjectiveParser(html);
        CareerObjective parse = careerObjectiveParser.parse();

        System.out.println("parse = " + parse.toString());
    }
}
