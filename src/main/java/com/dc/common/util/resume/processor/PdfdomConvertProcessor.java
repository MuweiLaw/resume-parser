package com.dc.common.util.resume.processor;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.fit.pdfdom.PDFDomTree;

import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

/**
 * @author wx
 * @version v1.0.0
 * @className PdfdomConvertProcessor
 * @description 使用pdfdom将pdf格式文件转换为html
 * @date 2019/12/23 15:45
 * @Copyright: 2020 www.decheng.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳得程信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class PdfdomConvertProcessor extends AbstractConvertProcessor  {

    private List pdfMediaType = Arrays.asList("application/pdf");

    @Override
    protected String convertProcessor(InputStream in, String chartset) throws Exception {
        PDDocument pdf = PDDocument.load(in);
        Writer output = new StringWriter();
        new PDFDomTree().writeText(pdf,output);
        return output.toString();
    }

    @Override
    public boolean isSupport(String mediaType) {
        return pdfMediaType.contains(mediaType);
    }
}
