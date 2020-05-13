package com.dc.common.resume;

import com.dc.common.util.ResumeParseUtils;
import com.dc.common.util.resume.io.InputStreamCacher;
import org.junit.Before;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class BaseTest {


    protected String basePath;

    @Before
    public void before() {
        basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + File.separator + "resume" + File.separator;
    }

    public String converHtml(File f) throws Exception{
        InputStream in = new FileInputStream(f);
        InputStreamCacher inputStreamCacher = new InputStreamCacher(in);
        String html = ResumeParseUtils.converResume(inputStreamCacher.getInputStream());
        return html;
    }
}
