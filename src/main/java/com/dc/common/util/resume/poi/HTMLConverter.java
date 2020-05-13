package com.dc.common.util.resume.poi;

import org.apache.poi.xwpf.converter.core.IXWPFConverter;
import org.apache.poi.xwpf.converter.core.XWPFConverterException;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.xml.sax.ContentHandler;

import java.io.IOException;

/**
 * @author wx
 * @version 1.0.0
 * @className HTMLConverter
 * @description html转换器
 * @date 2019/12/7 22:42
 */
public class HTMLConverter extends XHTMLConverter {

    private static final IXWPFConverter<XHTMLOptions> INSTANCE = new HTMLConverter();

    public static IXWPFConverter<XHTMLOptions> getInstance() {
        return INSTANCE;
    }

    @Override
    public void convert(XWPFDocument document, ContentHandler contentHandler, XHTMLOptions options) throws XWPFConverterException, IOException {
        try {
            options = options != null ? options : XHTMLOptions.getDefault();
            HTMLMapper mapper = new HTMLMapper(document, contentHandler, options);
            mapper.start();
        } catch (Exception e) {
            throw new XWPFConverterException(e);
        }
    }
}
