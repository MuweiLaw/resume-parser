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
    public void oneEducationParse() throws Exception {
        File f = new File(basePath + "智联招聘_蒋程_网页设计师_中文_20191031_1572509772676.doc");
        String html = converHtml(f);

        SkillsParser parser = new SkillsParser(html);
        parser.parse().forEach(skills -> {
                    System.out.println(skills.toString()    );
                }

                );
    }
}
