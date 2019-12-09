package com.lds.common.resume.parser;

import com.lds.common.resume.BaseTest;
import org.junit.Test;

import java.io.File;

/**
 * @author wx
 * @version 1.0.0
 * @className EducationParserTest
 * @description TODO
 * @date 2019/12/6 15:05
 */
public class SkillsParserTest extends BaseTest {

    @Test
    public void oneEducationParseZhiLian() throws Exception {
        File f = new File(basePath + "智联招聘_温超平_软件测试_中文_20191105_1572935670709.doc");
        String html = converHtml(f);

        SkillsParser parser = new SkillsParser(html);
        parser.parse().forEach(skills -> {
                    System.out.println(skills.toString());
                }
        );
    }
    @Test
    public void oneEducationParse51Job() throws Exception {
        File f = new File(basePath + "51job_凌梦之(23234904).doc");
        String html = converHtml(f);

        SkillsParser parser = new SkillsParser(html);
        parser.parse().forEach(skills -> {
                    System.out.println(skills.toString());
                }
        );
    }
}
