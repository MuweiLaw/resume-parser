package com.lds.common.resume.parser;

import com.lds.common.resume.BaseTest;
import com.lds.common.resume.parser.EducationParser;
import org.junit.Test;

import java.io.File;

/**
 * @author wx
 * @version 1.0.0
 * @className EducationParserTest
 * @description TODO
 * @date 2019/12/6 15:05
 */
public class EducationParserTest extends BaseTest {

    @Test
    public void oneEducationParse() throws Exception {
        File f = new File(basePath + "51job_全业萍(767697783).doc");
        String html = converHtml(f);

        EducationParser parser = new EducationParser(html);
        parser.parse();
    }
}
