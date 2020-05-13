package com.dc.common.resume.processor;

import com.dc.common.resume.BaseTest;
import com.dc.common.util.ResumeParseUtils;
import com.dc.common.util.Word2HtmlUtils;
import com.dc.common.util.resume.io.InputStreamCacher;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class HtmlConverterTest extends BaseTest {

    @Test
    public void oneGeneratorHtml() throws Exception {
        //D:\workspace\resume-parser\target\classes\resume\51job_全业萍(767697783).doc
        //D:\workspace\resume-parser\target\test-classes\resume\51job_全业萍(767697783).doc
        File f = new File(basePath + "C++服务器开发宋雄(J6598349).doc");
        converHtmlFile(f);
    }

    @Test
    public void oneGeneratorHtmlOnBoss() throws Exception {
        File f = new File(basePath + "boss陈勇4年.doc");
        converHtmlFile(f);
    }

    @Test
    public void oneGeneratorHtmlOnBoss1() throws Exception {
        File f = new File(basePath + "boss张旭4年.doc");
        converHtmlFile(f);
    }

    @Test
    public void oneGeneratorHtmlOnZhaopin() throws Exception {
        File f = new File(basePath + "智联招聘_朱春博_软件测试工程师_中文_20191024_1571901714449.doc");
        converHtmlFile(f);
    }

    @Test
    public void oneGeneratorHtmlOnZhuopin() throws Exception {
        File f = new File(basePath + "智联卓聘_中文_()_20191101 (4).doc");
        converHtmlFile(f);
    }

    @Test
    public void oneGeneratorHtmlOnRenCai() throws Exception {
        File f = new File(basePath + "高级.NET工程师余正伟(J4511083).doc");
        converHtmlFile(f);
    }

    @Test
    public void oneGeneratorHtmlOnRenCai1() throws Exception {
        File f = new File(basePath + "运营专员张雅花(J9972636).doc");
        converHtmlFile(f);
    }

    @Test
    public void oneGeneratorHtmlOnRenCai12() throws Exception {
        File f = new File(basePath + "智联招聘_殷崇贵_JAVA架构师_中文_20191221_1576892320569.doc");
        converHtmlFile(f);
    }
    @Test
    public void oneGeneratorHtmlByPDFOnBoss() throws Exception {
        File f = new File(basePath + "boss邓炜钧4年.pdf");
        converHtmlFile(f);
    }

    @Test
    public void batchTest() throws Exception {
        String str = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "resume/";
        File file = new File(str);
        File[] files = file.listFiles();
        for (File f : files) {
            if (!f.isDirectory()) {
                try {
                    converHtmlFile(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void converHtmlFile(File f) throws Exception {
        InputStream in = new FileInputStream(f);
        InputStreamCacher inputStreamCacher = new InputStreamCacher(in);
        String content = ResumeParseUtils.converResume(inputStreamCacher.getInputStream());

        String pathStr = f.getAbsolutePath().substring(0, f.getAbsolutePath().lastIndexOf(File.separator));
        pathStr = pathStr + File.separator + "html" + File.separator + f.getName().substring(0, f.getName().indexOf(".")) + ".html";


        //String chartset = EncodingDetectUtils.detect(inputStreamCacher.getInputStream());
        Word2HtmlUtils.writeFile(content, pathStr, null);
    }


}
