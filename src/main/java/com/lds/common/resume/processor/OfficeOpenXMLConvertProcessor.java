package com.lds.common.resume.processor;

import com.lds.common.resume.util.Word2HtmlUtils;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;

import java.io.InputStream;
import java.io.PushbackInputStream;

/**
 * @author wx
 * @version 1.0.0
 * @description .docx格式的文件处理
 * @date 2019/11/20 15:24
 **/
public class OfficeOpenXMLConvertProcessor extends AbstractConvertProcessor {

    private String officeOpenXMLMediaType = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";

    public OfficeOpenXMLConvertProcessor() {
    }

    @Override
    public boolean isSupport(String mediaType) {
        return officeOpenXMLMediaType.equals(mediaType);
    }

    @Override
    protected String convertProcessor(InputStream in,String charset) throws Exception {
        if (!in.markSupported()) {
            in = new PushbackInputStream(in, 8);
        }
        if (NPOIFSFileSystem.hasPOIFSHeader(in)) {
            System.out.println("doc格式.....");
            return Word2HtmlUtils.doc2Html(in);
        }
        if (POIXMLDocument.hasOOXMLHeader(in)) {
            System.out.println("docx格式.....");
            return Word2HtmlUtils.docx2Html(in);
        }
        throw new IllegalArgumentException("Your InputStream was neither an OLE2 stream, nor an OOXML stream");
    }

}