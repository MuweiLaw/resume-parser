package com.dc.common.util.base;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
	 private static  String docText = "word/document.xml";//要替换的document.xml的位置

	    private static  String imgName = "word/_rels/document.xml.rels"; //要替换的document.xml.rels的位置

	    private static  String mediaName = "word/media/";//图片meida的位置

	    /**
	     *
	     * @param zipInputStream zip文件的zip输入流
	     * @param zipOutputStream 输出的zip输出流
	     * @param docTextInputStream 替换后的document.xml文本
	     * @param imgInputStream 替换后的document.xml.rels文本
	     * @param fileList 需要压入meida的图片
	     */
	    public static void replaceItem(ZipInputStream zipInputStream,
	                                   ZipOutputStream zipOutputStream,
	                                   InputStream docTextInputStream,
	                                   InputStream imgInputStream, List<File> fileList){
	        //
	        if(null == zipInputStream){return;}
	        if(null == zipOutputStream){return;}
	        if(null == docTextInputStream){return;}
	        boolean replaceMedia = false;
	        //
	        ZipEntry entryIn;
	        try {
	            while((entryIn = zipInputStream.getNextEntry())!=null)
	            {
	                String entryName =  entryIn.getName();
	                ZipEntry entryOut = new ZipEntry(entryName);
	                // 只使用 name
	                zipOutputStream.putNextEntry(entryOut);
	                // 缓冲区
	                byte [] buf = new byte[8*1024];
	                int len;
	                if(entryName.equals(docText)){
	                    // 使用替换流（替换文字内容）
	                    while((len = (docTextInputStream.read(buf))) > 0) {
	                        zipOutputStream.write(buf, 0, len);
	                    }
	                }else if(entryName.equals( imgName)){
	                    // 使用替换流（替换图片）
	                    while((len = (imgInputStream.read(buf))) > 0) {
	                        zipOutputStream.write(buf, 0, len);
	                    }
	                }else if(entryName.contains(mediaName)&&replaceMedia){
	                }else if(entryName.contains(mediaName)&&!entryName.equals(mediaName)&&!replaceMedia){//将图片压缩到media目录中
	                    replaceMedia = true;
	                    if(entryName.contains("image1.png")){
	                        // 输出普通Zip流
	                        while((len = (zipInputStream.read(buf))) > 0) {
	                            zipOutputStream.write(buf, 0, len);
	                        }
	                        // 关闭此 entry
	                        zipOutputStream.closeEntry();
	                    }
	                    for(int i=0;i<fileList.size();i++){
	                        entryIn = new ZipEntry(mediaName+fileList.get(i).getName());
	                        zipOutputStream.putNextEntry(entryIn);
	                        FileInputStream in = null;
	                        try {
	                            in = new FileInputStream(fileList.get(i));
	                            while ((len = in.read(buf)) != -1){
	                                zipOutputStream.write(buf, 0, len);
	                            }
	                            // 关闭此 entry
	                            zipOutputStream.closeEntry();
	                        } catch (IOException e) {
	                        }finally {
	                            close(in);
	                        }
	                    }
	                }else {
	                    // 输出普通Zip流
	                    while((len = (zipInputStream.read(buf))) > 0) {
	                        zipOutputStream.write(buf, 0, len);
	                    }
	                }


	                // 关闭此 entry
	                zipOutputStream.closeEntry();

	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally {
	            //e.printStackTrace();
	            close(docTextInputStream);
	            close(zipInputStream);
	            close(zipOutputStream);
	            close(imgInputStream);
	        }
	    }

	    /**
	     * 包装输入流
	     */
	    public static ZipInputStream wrapZipInputStream(InputStream inputStream){
	        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
	        return zipInputStream;
	    }

	    /**
	     * 包装输出流
	     */
	    public static ZipOutputStream wrapZipOutputStream(OutputStream outputStream){
	        ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
	        return zipOutputStream;
	    }
	    private static void close(InputStream inputStream){
	        if (null != inputStream){
	            try {
	                inputStream.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    private static void close(OutputStream outputStream){
	        if (null != outputStream){
	            try {
	                outputStream.flush();
	                outputStream.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
