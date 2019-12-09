package com.lds.common.resume.parser;

import com.lds.common.resume.BaseTest;
import com.lds.common.resume.parser.WorkExperienceParser;
import org.junit.Test;

import java.io.File;

public class WorkExperienceTest extends BaseTest {

    @Test
    public void oneWorkExperience() throws Exception {
        File f = new File(basePath + "51job_全业萍(767697783).doc");
        String html = converHtml(f);
        WorkExperienceParser parser = new WorkExperienceParser(html);

        parser.parse();
    }
}
