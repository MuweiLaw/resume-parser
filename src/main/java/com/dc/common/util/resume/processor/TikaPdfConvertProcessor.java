package com.dc.common.util.resume.processor;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.ExpandedTitleContentHandler;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author wx
 * @version v1.0.0
 * @className PdfConvertProcessor
 * @description TODO
 * @date 2019/12/23 15:25
 * @Copyright: 2020 www.decheng1024.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳得程信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class TikaPdfConvertProcessor extends AbstractConvertProcessor {

    private List pdfMediaType = Arrays.asList("application/pdf");

    @Override
    protected String convertProcessor(InputStream in, String chartset) throws Exception {
        AutoDetectParser tikaParser = new AutoDetectParser();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        TransformerHandler handler;
        try {
            handler = factory.newTransformerHandler();
        } catch (TransformerConfigurationException ex) {
            throw new IOException(ex);
        }
        handler.getTransformer().setOutputProperty(OutputKeys.METHOD, "html");
        handler.getTransformer().setOutputProperty(OutputKeys.INDENT, "yes");
        handler.getTransformer().setOutputProperty(OutputKeys.ENCODING, chartset);
        handler.setResult(new StreamResult(out));
        ExpandedTitleContentHandler handler1 = new ExpandedTitleContentHandler(handler);
        try {
            tikaParser.parse(in, handler1, new Metadata());
        } catch (TikaException ex) {
            throw new IOException(ex);
        }
        return new String(out.toByteArray(), chartset);
    }

    @Override
    public boolean isSupport(String mediaType) {
        return pdfMediaType.contains(mediaType);
    }
}
