package com.dc.common.resume;

import com.dc.common.util.ResumeParseUtils;
import com.dc.common.util.resume.domain.Resume;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author wx
 * @version 1.0.0
 * @className ResumeparseUtilsTest
 * @description TODO
 * @date 2019/12/6 16:49
 */
public class ResumeparseUtilsTest extends BaseTest {

    @Test
    public void oneParseOnBoss() throws Exception {
        File f = new File(basePath + "51job_柏玉玲(501936366).doc");
        Resume resume = ResumeParseUtils.parseResume(new FileInputStream(f));
        System.out.println("str = " + resume.toString());
    }

    @Test
    public void oneParseOnBoss1() throws Exception {
        File f = new File(basePath + "boss邓炜钧4年.pdf");
        Resume resume = ResumeParseUtils.parseResume(new FileInputStream(f));
        System.out.println("str = " + resume.toString());
    }

    @Test
    public void oneParseOnBoss2() throws Exception {
        File f = new File(basePath + "智联招聘_王女士_美工_中文_20191221_1576896778456.doc");
        Resume resume = ResumeParseUtils.parseResume(new FileInputStream(f));
        System.out.println("str = " + resume.toString());
    }

    @Test
    public void oneParseOn51Job() throws Exception {
        File f = new File(basePath + "51job_李战坤(联通信号不好)(855295820).doc");
        Resume resume = ResumeParseUtils.parseResume(new FileInputStream(f));
        System.out.println("str = " + resume.toString());
    }

    @Test
    public void oneParseOn51Job1() throws Exception {
        File f = new File(basePath + "51job_白航郡(740750138).doc");
        Resume resume = ResumeParseUtils.parseResume(new FileInputStream(f));
        System.out.println("str = " + resume.toString());
    }

    @Test
    public void oneParseOn51Job2() throws Exception {
        File f = new File(basePath + "51job_白浩志(766153872).doc");
        Resume resume = ResumeParseUtils.parseResume(new FileInputStream(f));
        System.out.println("str = " + resume.toString());
    }

    @Test
    public void oneParseOnZhaopin() throws Exception {
        File f = new File(basePath + "51job_陈龙(891206033).doc");
        Resume resume = ResumeParseUtils.parseResume(new FileInputStream(f));
        System.out.println("str = " + resume.toString());
    }

    @Test
    public void oneParseOnZhaopin1() throws Exception {
        File f = new File(basePath + "【软件测试工程师  深圳10-11K】易青 3年.docx");
        Resume resume = ResumeParseUtils.parseResume(new FileInputStream(f));
        System.out.println("str = " + resume.toString());
    }

    @Test
    public void oneParseOnZhaopin2() throws Exception {
        File f = new File(basePath + "智联招聘_殷崇贵_JAVA架构师_中文_20191221_1576892320569.doc");
        Resume resume = ResumeParseUtils.parseResume(new FileInputStream(f));
        System.out.println("str = " + resume.toString());
    }
    @Test
    public void oneParseOnRenCai() throws Exception {
        File f = new File(basePath + "Android客户端开发谭磊(J9219022).doc");
        Resume resume = ResumeParseUtils.parseResume(new FileInputStream(f));
        System.out.println("str = " + resume.toString());
    }@Test
    public void oneParseOnRenCai1() throws Exception {
        File f = new File(basePath + "高级软件工程师吴财圣(J9982025).doc");
        Resume resume = ResumeParseUtils.parseResume(new FileInputStream(f));
        System.out.println("str = " + resume.toString());
    }@Test
    public void oneParseOnRenCai2() throws Exception {
        File f = new File(basePath + "高级.NET工程师余正伟(J4511083).doc");
        Resume resume = ResumeParseUtils.parseResume(new FileInputStream(f));
        System.out.println("str = " + resume.toString());
    }
}
