package com.dc.common.resume.parser;

import com.dc.common.resume.BaseTest;
import com.dc.common.util.resume.parser.ProjectExperienceParser;
import org.junit.Test;

import java.io.File;

/**
 * @author wx
 * @version 1.0.0
 * @className EducationParserTest
 * @description
 * @date 2019/12/6 15:05
 */
public class ProjectExperienceParserTest extends BaseTest {

    @Test
    public void oneEducationParseZhiLian() throws Exception {
        File f = new File(basePath + "智联招聘_胡程_软件测试工程师_中文_20191031_1572509741654.doc");
        String html = converHtml(f);

        ProjectExperienceParser parser = new ProjectExperienceParser(html);
        parser.parse().forEach(projectExperience -> {
                    System.out.println(projectExperience.toString());
                }
        );
    }

    @Test
    public void oneEducationParseZhiLian0() throws Exception {
        File f = new File(basePath + "智联招聘_温琦生_项目运营总监_中文_20191105_1572919559195.doc");
        String html = converHtml(f);

        ProjectExperienceParser parser = new ProjectExperienceParser(html);
        parser.parse().forEach(projectExperience -> {
                    System.out.println(projectExperience.toString());
                }
        );
    }

    @Test
    public void oneEducationParse51Job() throws Exception {
        File f = new File(basePath + "51job_凌梦之(23234904).doc");
        String html = converHtml(f);

        ProjectExperienceParser parser = new ProjectExperienceParser(html);
        parser.parse().forEach(projectExperience -> {
                    System.out.println(projectExperience.toString());
                }
        );
    }

    @Test
    public void oneEducationParse51Job0() throws Exception {
        File f = new File(basePath + "51job_简兆坚(57768818).doc");
        String html = converHtml(f);

        ProjectExperienceParser parser = new ProjectExperienceParser(html);
        parser.parse().forEach(projectExperience -> {
                    System.out.println(projectExperience.toString());
                }
        );
    }

    @Test
    public void oneEducationParseZhuoPin() throws Exception {
        File f = new File(basePath + "智联卓聘_中文_()_20191127 (3).doc");
        String html = converHtml(f);

        ProjectExperienceParser parser = new ProjectExperienceParser(html);
        parser.parse().forEach(projectExperience -> {
                    System.out.println(projectExperience.toString());
                }
        );
    }

    @Test
    public void oneEducationParseZhuoPin1() throws Exception {
        File f = new File(basePath + "智联卓聘_中文_()_20191127 (4).doc");
        String html = converHtml(f);

        ProjectExperienceParser parser = new ProjectExperienceParser(html);
        parser.parse().forEach(projectExperience -> {
                    System.out.println(projectExperience.toString());
                }
        );
    }

    @Test
    public void oneEducationParseZhuoPin2() throws Exception {
        File f = new File(basePath + "智联卓聘_中文_()_20191127 (7).doc");
        String html = converHtml(f);

        ProjectExperienceParser parser = new ProjectExperienceParser(html);
        parser.parse().forEach(projectExperience -> {
                    System.out.println(projectExperience.toString());
                }
        );
    }

    @Test
    public void oneEducationParseZhuoPin3() throws Exception {
        File f = new File(basePath + "智联卓聘_中文_()_20191127 (9).doc");
        String html = converHtml(f);

        ProjectExperienceParser parser = new ProjectExperienceParser(html);
        parser.parse().forEach(projectExperience -> {
                    System.out.println(projectExperience.toString());
                }
        );
    }
    @Test
    public void oneEducationParseRenCai() throws Exception {
        File f = new File(basePath + "高级软件工程师吴财圣(J9982025).doc");
        String html = converHtml(f);

        ProjectExperienceParser parser = new ProjectExperienceParser(html);
        parser.parse().forEach(projectExperience -> {
                    System.out.println(projectExperience.toString());
                }
        );
    }@Test
    public void oneEducationParseRenCai1() throws Exception {
        File f = new File(basePath + "运营专员张雅花(J9972636).doc");
        String html = converHtml(f);

        ProjectExperienceParser parser = new ProjectExperienceParser(html);
        parser.parse().forEach(projectExperience -> {
                    System.out.println(projectExperience.toString());
                }
        );
    }@Test
    public void oneEducationParseRenCai2() throws Exception {
        File f = new File(basePath + "软件测试工程师安文卿(J9981160).doc");
        String html = converHtml(f);

        ProjectExperienceParser parser = new ProjectExperienceParser(html);
        parser.parse().forEach(projectExperience -> {
                    System.out.println(projectExperience.toString());
                }
        );
    }@Test
    public void oneEducationParseRenCai3() throws Exception {
        File f = new File(basePath + "高级.NET工程师余正伟(J4511083).doc");
        String html = converHtml(f);

        ProjectExperienceParser parser = new ProjectExperienceParser(html);
        parser.parse().forEach(projectExperience -> {
                    System.out.println(projectExperience.toString());
                }
        );
    }
}
