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
    public void matchExpectingInsuatry() throws Exception {
        File f = new File(basePath + "51job_庞幸珍(763358430).doc");
//        转换html
        String html = converHtml(f);
//        信息解析器
        CareerObjectiveParser careerObjectiveParser = new CareerObjectiveParser(html);
        CareerObjective parse = careerObjectiveParser.parse();

        System.out.println("parse = " + parse.toString());
    }
}
