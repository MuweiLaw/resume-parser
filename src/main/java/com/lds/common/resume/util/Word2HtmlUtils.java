package com.lds.common.resume.util;

import com.lds.common.resume.poi.HTMLConverter;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.core.FileURIResolver;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.List;
import java.util.Objects;

public class Word2HtmlUtils {

        private final static String  tempPath = System.getProperty("java.io.tmpdir");

        /**
         * doc转换为html
         *
         * @param fileName
         * @param outPutFile
         * @throws TransformerException
         * @throws IOException
         * @throws ParserConfigurationException
         */
        public static void doc2Html(String fileName, String outPutFile) throws TransformerException, IOException, ParserConfigurationException {
            HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(fileName));
            WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
            wordToHtmlConverter.setPicturesManager(new PicturesManager() {
                public String savePicture(byte[] content, PictureType pictureType, String suggestedName, float widthInches, float heightInches) {
                    return tempPath + suggestedName;
                }
            });
            wordToHtmlConverter.processDocument(wordDocument);
            // 保存图片
            List<Picture> pics = wordDocument.getPicturesTable().getAllPictures();
            if (pics != null) {
                for (int i = 0; i < pics.size(); i++) {
                    Picture pic = (Picture) pics.get(i);
                    System.out.println();
                    try {
                        pic.writeImageContent(new FileOutputStream(tempPath + pic.suggestFullFileName()));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
            Document htmlDocument = wordToHtmlConverter.getDocument();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            DOMSource domSource = new DOMSource(htmlDocument);
            StreamResult streamResult = new StreamResult(out);

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer serializer = tf.newTransformer();
            serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            serializer.setOutputProperty(OutputKeys.INDENT, "yes");
            serializer.setOutputProperty(OutputKeys.METHOD, "html");
            serializer.transform(domSource, streamResult);
            out.close();
        }

        /**
         * 写文件
         *
         * @param content
         * @param path
         */
        public static void writeFile(String content, String path,String charset) {
            if(Objects.isNull(charset)){
                charset = "utf-8";
            }
            FileOutputStream fos = null;
            BufferedWriter bw = null;
            try {
                File file = new File(path);
                if( !file.exists()){
                    file.createNewFile();
                }
                fos = new FileOutputStream(file);
                bw = new BufferedWriter(new OutputStreamWriter(fos, charset));
                bw.write(content);
            } catch (FileNotFoundException fnfe) {
                fnfe.printStackTrace();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } finally {
                try {
                    if (bw != null)
                        bw.close();
                    if (fos != null)
                        fos.close();
                } catch (IOException ie) {
                }
            }
        }


    /**
     * doc转换为html
     *
     * @param in
     * @throws TransformerException
     * @throws IOException
     * @throws ParserConfigurationException
     */
    public static String doc2Html(InputStream in) throws TransformerException, IOException, ParserConfigurationException {
        long startTime = System.currentTimeMillis();
        HWPFDocument wordDocument = new HWPFDocument(in);
        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
        wordToHtmlConverter.processDocument(wordDocument);
        Document htmlDocument = wordToHtmlConverter.getDocument();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(out);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer serializer = tf.newTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty(OutputKeys.METHOD, "html");
        serializer.transform(domSource, streamResult);
        out.close();
        String html = new String(out.toByteArray());
        System.out.println("cost times " + (System.currentTimeMillis() - startTime) + " ms.");
        return html;
    }

    /**
     * docx格式word转换为html
     * @param in
     * @throws TransformerException
     * @throws IOException
     * @throws ParserConfigurationException
     */
    public static String docx2Html(InputStream in) throws TransformerException, IOException, ParserConfigurationException {
        long startTime = System.currentTimeMillis();
        XWPFDocument document = new XWPFDocument(in);
        File imageFolderFile = new File(tempPath);
        XHTMLOptions options = XHTMLOptions.create().URIResolver(new FileURIResolver(imageFolderFile));
        options.setExtractor(new FileImageExtractor(imageFolderFile));
        options.setIgnoreStylesIfUnused(false);
        options.setFragment(true);
        // URI resolver
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        HTMLConverter.getInstance().convert(document, out, options);

        System.out.println("cost times  " + (System.currentTimeMillis() - startTime) + " ms.");
        return (new String(out.toByteArray()));

    }

}
