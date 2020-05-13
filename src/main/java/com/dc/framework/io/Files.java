/**
 * 修改历史：<br/>
 * =================================================================<br/>
 * 修改人 修改时间 修改原因/内容<br/>
 * =================================================================<br/>
 * sam 20100111 增加修改历史注释<br/>
 */

package com.dc.framework.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import com.dc.framework.lang.Lang;
import com.dc.framework.lang.Strings;
import com.dc.framework.lang.collection.Collections;
import com.dc.framework.lang.collection.Lists;
import org.apache.commons.io.FileUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;


/**
 * 文件处理工具类,扩展自apache commons
 * 
 * @author Sam
 * 
 */
public class Files extends FileUtils {
    
	/**
	 * 创建一个txt文件
	 * @param dir 文件目录
	 * @param name 文件名称
	 * @param content 文件内容
	 * @return
	 */
	public static File createTxtFile(String dir,String name,String content) {
		File f = new File(dir,name);
		return createTxtFile(f,content);
	}
	
	/**
	 * 创建一个txt文件
	 * @param path 文件的全路径
	 * @param content 文件的内容
	 * @return
	 */
	public static File createTxtFile(File path,String content) {
		if (path == null)
			throw Lang.makeThrow("Can not create a txt file,becaue the path is Null!");
		FileWriter fileWriter = null;
		try {
			fileWriter = IO.fileWriter(path);
			fileWriter.write(content);
			fileWriter.flush();
		} catch (IOException e) {
			throw Lang.wrapThrow(e,"Create txt file[%s] is error!",path.getAbsolutePath());
		} finally {
			IO.close(fileWriter);
		}
		return path;
	
	}
	
	
    /**
     * 转换文件编码
     * 
     * @param file 指定的文本文件
     * @param srcEncode 源存储编码
     * @param targetEncode 目标存储编码
     * @throws IOException
     */
    public static void changeEncoding(File file, String srcEncode, String targetEncode)
        throws IOException {

        String fileStr = loadTxtFile(file, srcEncode);
        File tempFile = new File(file.getParent(), "temp_____" + file.getName());
        FileOutputStream fileOut = IO.fileOut(tempFile);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOut, targetEncode));
        try {
            writer.write(fileStr);
            writer.flush();
        } finally {
            IO.close(writer);
        }
        copyFile(tempFile, file);
        tempFile.delete();
    }
    
    /**
     * 装载一个文本文件
     * 
     * @param file 指定要装载的文件
     * @param fileEncode 指定的文件编码,如果是以GBK进行存储的话，读取也要以GBK进行读取，否则会乱码
     * @return "" 表示指定的路径不存在或者不是一个文件
     * @throws IOException
     */
    public static String loadTxtFile(File file, String fileEncode) throws IOException {

        if (Strings.isEmpty(fileEncode))
            fileEncode = Strings.ENCODING_UTF_8;
        if (!file.exists() || file.isDirectory())
            return Strings.EMPTY;
        BufferedReader bReader = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), fileEncode));
        StringBuilder sb = new StringBuilder();
        try {
            String line = Strings.EMPTY;
            while ((line = bReader.readLine()) != null) {
                sb.append(line).append(Strings.NEW_LINE);
            }
            return sb.toString();
        } finally {
            IO.close(bReader);
        }
        
    }
    
    public static String loadTxtFile(File file) throws IOException {

        return loadTxtFile(file, null);
    }
    
    /**
     * 根据指定的路径装载一个Properties文件
     * 
     * @param loadPath
     * @return
     */
    public static Properties loadPropertiesFile(String loadPath) {

        Properties prop = new Properties();
        try {
            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(loadPath));
        } catch (IOException e) {
            Lang.wrapThrow(e, "load properties file['%s'] is error,cause is:'%s'", loadPath, e
                    .getMessage());
        }
        return prop;
    }
    
    /**
     * 装载一个文件到内存中
     * 
     * @param file
     * @return
     * @throws IOException
     */
    public static byte[] toBytes(File file) throws IOException {

        FileInputStream fin = IO.fileIn(file);
        return IO.toBytes(fin);
    }
    
    public static String toString(File f) {

        if (f == null)
            return "";
        return String.format("[Path:%s,Name:%s,FileOrDiectory:%s]", f.getAbsolutePath(), f
                .getName(), f.isDirectory() ? "Directory" : "File");
    }
    
    /**
     * 根据一个路径创建一个File对象
     * 
     * @param path
     * @return
     */
    public static File of(String path) {
        return new File(path);
    }
    
    /**
     * 根据一个路径创建一个File对象
     * 
     * @param dir
	 * @param  fileName
     * @return
     */
    public static File of(String dir, String fileName) {

        return new File(dir, fileName);
    }
    
    /**
     * 根据一组路径创建一个File 列表
     * 
     * @param paths
     * @return
     */
    public static List<File> valuesOf(String... paths) {

        return valuesOf(Lists.of(paths));
    }
    
    /**
     * 根据一组路径List创建一个File列表
     * 
     * @param paths
     * @return
     */
    public static List<File> valuesOf(List<String> paths) {

        return Lists.valuesTo(paths, File.class);
    }
    
    
    /**
     * 压缩一个文件或者目录
     * @param src 要被压缩的源文件或者目录
     */
    public static void zips(File src) {
    	if (!src.exists()) {
    		throw Lang.makeThrow("srouce file or directory is not exists!");    		
    	}
    	File target = new File(src.getParentFile(),src.getName()+".zip");
    	zips(src,target);
    }
    
    public static void zips(String path){
    	zips(new File(path));
    }
    
    /**
     * 压缩一个文件或者目录
     * @param src 要被压缩的源文件或者目录
     * @param target 压缩文件的路径
     */
    public static void zips(File src,File target) {
    	if (!src.exists()) {
    		throw Lang.makeThrow("srouce file or directory is not exists!");    		
    	}
    	ZipOutputStream targetZip = null;
    	try {
    		if (src.isFile()) {
    			zip(target,src);
    			return;
    		}
    		targetZip = new ZipOutputStream(IO.fileOut(target));
    		targetZip.setEncoding(Strings.ENCODING_GBK);
    		zips(src.getParentFile(),src,targetZip);
    		targetZip.flush();
		} catch (IOException e) {
			Lang.wrapThrow(e,"file[%s] zip to file[%s] is error!",src.getAbsolutePath(),target.getAbsolutePath());
		} finally {
			IO.close(targetZip);
		}
    }
    
    private static void zips(File base,File currentZipFile,ZipOutputStream zipOut) throws IOException {
    	URI uri = base.toURI().relativize(currentZipFile.toURI());
    	ZipEntry entry = new ZipEntry(uri.getPath());
    	if (currentZipFile.isDirectory()) {
    		entry.setUnixMode(755);
    		try {
    			zipOut.putNextEntry(entry);
    		} finally {
    			closeEntry(zipOut);
    		}    		
    		File[] files = currentZipFile.listFiles();
    		for (File f : files) {
    			zips(base,f,zipOut);
    		}
    	} else {
    		entry.setUnixMode(644);    		
    		BufferedInputStream bufferIn = null;
    		try {
	    		zipOut.putNextEntry(entry);
	    		bufferIn = IO.fileBufferIn(currentZipFile);
	    		IO.copy(bufferIn, zipOut);
    		} finally {
	    		IO.close(bufferIn);
	    		closeEntry(zipOut);
    		}
    	}
    }
    
    private static void closeEntry(ZipOutputStream zipOut) {
    	try {zipOut.closeEntry();} catch (IOException e) {}
    }
    
    /**
     * zip多个文件
     * 
     * @param zipFilePath zip目标文件
     * @param files 被zip的文件列表
     */
    public static void zip(File zipFilePath, File... files) {

        List<File> fileList = Collections.list(files);
        zip(zipFilePath, fileList);
    }
    
    public static void zip(String zipPath,File...files){
    	zip(new File(zipPath),files);
    }
    
    /**
     * zip 多个文件
     * 
     * @param zipFilePath zip目标文件
     * @param files 被zip文件列表
     */
    public static void zip(File zipFilePath, List<File> files) {
    	if (Collections.isNotEmpty(files)) {
    		ZipOutputStream zipOut = null;
    		try {
				zipOut = new ZipOutputStream(IO.fileOut(zipFilePath));
				zipOut.setEncoding(Strings.ENCODING_GBK);
				for (File f : files) {
					BufferedInputStream bufferIn = null;
					try {
						bufferIn = IO.fileBufferIn(f);
						ZipEntry zipEntry = new ZipEntry(f.getName());
						zipOut.putNextEntry(zipEntry);
						IO.copy(bufferIn, zipOut);
					} finally {
						IO.close(bufferIn);
						zipOut.closeEntry();
					}
				}
				zipOut.flush();
			} catch (IOException e) {
				throw Lang.wrapThrow(e,"zip files is error!");
			} finally {
				IO.close(zipOut);
			}
    	}
    }

    /**
     * 解压缩一个文件
     * 
     * @param srcZipFile
     * @param targetPath
     */
    @SuppressWarnings("unchecked")
	public static void unzip(File srcZipFile, File targetPath) {
    	if (!srcZipFile.exists())
    		throw Lang.makeThrow("srouce zip file is not exists!");
    	if (targetPath.isFile()) 
    		throw Lang.makeThrow("target unzip path can not be a file,must be a directory!");
    	if (!targetPath.exists())
    		targetPath.mkdir();
    	try {
			ZipFile zipFile = new ZipFile(srcZipFile,Strings.ENCODING_GBK);
			Enumeration<ZipEntry> enumer = zipFile.getEntries();
			while(enumer.hasMoreElements()) {
				ZipEntry entry = enumer.nextElement();
				if (entry.isDirectory()) {
					new File(targetPath,entry.getName()).mkdir();
					continue;
				}
				BufferedInputStream bufferIn = null;
				BufferedOutputStream bufferOut = null;
				try {
				bufferIn = IO.buffer(zipFile.getInputStream(entry));
				File file = new File(targetPath,entry.getName());
				bufferOut = IO.fileBufferOut(file);
				IO.copy(bufferIn, bufferOut);
				} finally {
					IO.close(bufferIn,bufferOut);
				}
				
			}
		} catch (IOException e) {
			throw Lang.wrapThrow(e,"unzip file[%s] to file[%s] is error!",
								 srcZipFile.getAbsolutePath(),
								 targetPath.getAbsolutePath());
		}
    	
    }
    
    public static void unzip(String srcZipFilePath) {
    	unzip(new File(srcZipFilePath));
    }
    
    public static void unzip(String srcZipFilePath,String targetPath) {
    	unzip(new File(srcZipFilePath),new File(targetPath));
    }
    
    public static void unzip(File srcZipFile) {
    	unzip(srcZipFile,srcZipFile.getParentFile());
    }
    
    public static void main(String[] a) throws IOException {

        // 转换文件编码
//        FileFilter ff = new FileFilter() {
//            
//            public boolean accept(File f) {
//
//                return (!f.getName().matches(".*[db|gif|xls]")
//
//                );
//            }
//            
//        };
//        String dir = "E:/dev/project/IBMS_PROJECT/projects/ibms/webapp/jsp/common";
//        String ecdir = "encoding//webapp/jsp";
//        List<File> files = Disks.search(dir, ff, true);
//        StringBuilder sb = new StringBuilder();
//        StringBuilder sb2 = new StringBuilder();
//        for (File f : files) {
//            try {
//                Lang.printlnf("开始处理文件:%s,路径：%s", f.getName(), f.getParent());
//                Files.changeEncoding(f, Strings.ENCODING_GBK, Strings.ENCODING_UTF_8);
//                String strEc = f.getAbsolutePath().replace("\\", "/");
//                strEc = strEc.replaceAll("E:/dev/project/IBMS_PROJECT/projects/ibms/webapp/jsp",
//                        ecdir);
//                strEc += "=UTF-8";
//                sb2.append(strEc).append(Strings.NEW_LINE);
//                strEc = "";
//            } catch (Exception e) {
//                sb.append(String.format("处理失败！文件：%s,路径:%s", f.getName(), f.getParent())).append(
//                        Strings.NEW_LINE);
//            }
//        }
//        Lang.println(sb);
//        Lang.println(sb2);
        // String f = "E:/dev/project/IBMS_PROJECT/projects/ibms/webapp/js/forecast_common.js";
        // Files.changeEncoding(new File(f),Strings.ENCODING_GBK, Strings.ENCODING_UTF_8);
    	
    	//压缩文件测试
//    	File f = createTxtFile("c:\\tempdir","文件1.txt","JustAText");
//    	File f1 = createTxtFile("c:\\tempdir","文件2.txt","JustAText");
//    	Files.zip("c:\\tempdir\\测试压缩文件.zip", f,f1);
    	
    	//压缩文件或者目录
    	Files.zips(new File("c:\\tempdir\\这不是一个神话"));
    	
    	//解压缩文件
//    	File f = new File("c:\\tempdir\\这不是一个神话.zip");
//    	File f2 = new File("c:\\tempdir");
//    	Files.unzip(f, f2);
    	
        
    }
}
