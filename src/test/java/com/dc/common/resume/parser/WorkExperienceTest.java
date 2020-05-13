package com.dc.common.resume.parser;

import com.dc.common.resume.BaseTest;
import com.dc.common.util.resume.domain.WorkExperience;
import com.dc.common.util.resume.parser.WorkExperienceParser;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class WorkExperienceTest extends BaseTest {

    @Test
    public void oneWorkExperienceOn51job() throws Exception {
        File f = new File(basePath + "智联招聘_侯钟民_美工_中文_20191221_1576918237510.doc");
        String html = converHtml(f);
        WorkExperienceParser parser = new WorkExperienceParser(html);
        List<WorkExperience> wps = parser.parse();
        for (WorkExperience wep : wps) {
            System.out.println("wep = " + wep);
        }
    }

    @Test
    public void oneWorkExperienceOn51job1() throws Exception {
        File f = new File(basePath + "51job_曹鹏(49804639).doc");
        String html = converHtml(f);
        WorkExperienceParser parser = new WorkExperienceParser(html);
        List<WorkExperience> wps = parser.parse();
        for (WorkExperience wep : wps) {
            System.out.println("wep = " + wep);
        }
    }

    @Test
    public void oneWorkExperienceOnBoss() throws Exception {
        File f = new File(basePath + "boss直聘何正宇3年.docx");
        String html = converHtml(f);
        WorkExperienceParser parser = new WorkExperienceParser(html);
        List<WorkExperience> wps = parser.parse();
        for (WorkExperience wep : wps) {
            System.out.println("wep = " + wep);
        }
    }

    @Test
    public void oneWorkExperienceOnZhilianzhaopin() throws Exception {
        File f = new File(basePath + "智联招聘_景子霖_测试工程师_中文_20191221_1576893309397.doc");
        String html = converHtml(f);
        WorkExperienceParser parser = new WorkExperienceParser(html);
        List<WorkExperience> wps = parser.parse();
        for (WorkExperience wep : wps) {
            System.out.println("wep = " + wep);
        }
    }

    @Test
    public void oneWorkExperienceOnZhilianzhaopin1() throws Exception {
        File f = new File(basePath + "智联招聘_刘延雄_测试工程师_中文_20191221_1576912122329.doc");
        String html = converHtml(f);
        WorkExperienceParser parser = new WorkExperienceParser(html);
        List<WorkExperience> wps = parser.parse();
        for (WorkExperience wep : wps) {
            System.out.println("wep = " + wep);
        }
    }

    @Test
    public void oneWorkExperienceOnZhilianzhaopin2() throws Exception {
        File f = new File(basePath + "智联招聘_王女士_美工_中文_20191221_1576896778456.doc");
        String html = converHtml(f);
        WorkExperienceParser parser = new WorkExperienceParser(html);
        List<WorkExperience> wps = parser.parse();
        for (WorkExperience wep : wps) {
            System.out.println("wep = " + wep);
        }
    }

    /**
     * @Description: 该解析的简历需要\r\n换行
     * @author Murray Law
     * @date 2019/12/11 13:44
     */
    @Test
    public void oneWorkExperienceOnZhilianzhaopin3() throws Exception {
        File f = new File(basePath + "智联招聘_胡程_软件测试工程师_中文_20191031_1572509741654.doc");
        String html = converHtml(f);
        WorkExperienceParser parser = new WorkExperienceParser(html);
        List<WorkExperience> wps = parser.parse();
        for (WorkExperience wep : wps) {
            System.out.println("wep = " + wep);
        }
    }

    @Test
    public void oneWorkExperienceOnZhilianzhaopin4() throws Exception {
        File f = new File(basePath + "智联招聘_伍锡伟_中级java开发工程师_中文_20191106_1573022627922.doc");
        String html = converHtml(f);
        WorkExperienceParser parser = new WorkExperienceParser(html);
        List<WorkExperience> wps = parser.parse();
        for (WorkExperience wep : wps) {
            System.out.println("wep = " + wep);
        }
    }

    @Test
    public void oneWorkExperienceOnZhilianzhaopin5() throws Exception {
        File f = new File(basePath + "智联招聘_温琦生_项目运营总监_中文_20191105_1572919559195.doc");
        String html = converHtml(f);
        WorkExperienceParser parser = new WorkExperienceParser(html);
        List<WorkExperience> wps = parser.parse();
        for (WorkExperience wep : wps) {
            System.out.println("wep = " + wep);
        }
    }

    @Test
    public void workExperienceOnRenCai() throws Exception {
        File f = new File(basePath + "运营专员张雅花(J9972636).doc");
        String html = converHtml(f);
        WorkExperienceParser parser = new WorkExperienceParser(html);
        List<WorkExperience> wps = parser.parse();
        for (WorkExperience wep : wps) {
            System.out.println("wep = " + wep);
        }
    }

    @Test
    public void workExperienceOnRenCai1() throws Exception {
        File f = new File(basePath + "高级软件工程师吴财圣(J9982025).doc");
        String html = converHtml(f);
        WorkExperienceParser parser = new WorkExperienceParser(html);
        List<WorkExperience> wps = parser.parse();
        for (WorkExperience wep : wps) {
            System.out.println("wep = " + wep);
        }
    }

    @Test
    public void workExperienceOnRenCai2() throws Exception {
        File f = new File(basePath + "高级.NET工程师余正伟(J4511083).doc");
        String html = converHtml(f);
        WorkExperienceParser parser = new WorkExperienceParser(html);
        List<WorkExperience> wps = parser.parse();
        for (WorkExperience wep : wps) {
            System.out.println("wep = " + wep);
        }
    }

    @Test
    public void workExperienceOnRenCai3() throws Exception {
        File f = new File(basePath + "软件测试工程师安文卿(J9981160).doc");
        String html = converHtml(f);
        WorkExperienceParser parser = new WorkExperienceParser(html);
        List<WorkExperience> wps = parser.parse();
        for (WorkExperience wep : wps) {
            System.out.println("wep = " + wep);
        }
    }

    @Test
    public void workExperienceOnZhuoPin() throws Exception {
        File f = new File(basePath + "智联卓聘_中文_()_20191127 (3).doc");
        String html = converHtml(f);
        WorkExperienceParser parser = new WorkExperienceParser(html);
        List<WorkExperience> wps = parser.parse();
        for (WorkExperience wep : wps) {
            System.out.println("wep = " + wep);
        }
    }

    @Test
    public void workExperienceOnZhuoPin1() throws Exception {
        File f = new File(basePath + "智联卓聘_中文_()_20191127 (4).doc");
        String html = converHtml(f);
        WorkExperienceParser parser = new WorkExperienceParser(html);
        List<WorkExperience> wps = parser.parse();
        for (WorkExperience wep : wps) {
            System.out.println("wep = " + wep);
        }
    }

    @Test
    public void workExperienceOnZhuoPin2() throws Exception {
        File f = new File(basePath + "智联卓聘_中文_()_20191127 (7).doc");
        String html = converHtml(f);
        WorkExperienceParser parser = new WorkExperienceParser(html);
        List<WorkExperience> wps = parser.parse();
        for (WorkExperience wep : wps) {
            System.out.println("wep = " + wep);
        }
    }

    @Test
    public void workExperienceOnZhuoPin3() throws Exception {
        File f = new File(basePath + "智联卓聘_中文_()_20191127 (9).doc");
        String html = converHtml(f);
        WorkExperienceParser parser = new WorkExperienceParser(html);
        List<WorkExperience> wps = parser.parse();
        for (WorkExperience wep : wps) {
            System.out.println("wep = " + wep);
        }
    }
}
