package com.dc.framework.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

import com.dc.framework.lang.Lang;
import com.dc.framework.lang.reflect.ClassWrapper;
import org.apache.commons.io.IOUtils;


/**
 * IO流操作工具类
 *
 */
public abstract class IO extends IOUtils {
    
    /**
     * 封装任意一个输出流对象
     * 
     * @param <T>
     * @param outClass
     * @param args
     * @return
     */
    public static <T extends OutputStream> T out(Class<T> outClass, Object... args) {

        return ClassWrapper.wrap(outClass).newOne(args);
    }
    
    /**
     * 将任意一个输出流包装成Buffer输出流对象
     * 
     * @param out
     * @return
     */
    public static BufferedOutputStream buffer(OutputStream out) {

        return new BufferedOutputStream(out);
    }
    
    /**
     * 将任意一个输入流包装成Buffer输入流对象
     * 
     * @param in
     * @return
     */
    public static BufferedInputStream buffer(InputStream in) {

        return new BufferedInputStream(in);
    }
    
    /**
     * 以Buffer的方式将某个输入流copy至某个输出流中
     * 
     * @param input
     * @param output
     * @return
     * @throws IOException
     */
    public static int bufferedCopy(InputStream input, OutputStream output) throws IOException {

        BufferedOutputStream out = buffer(output);
        BufferedInputStream in = buffer(input);
        int count = IO.copy(in, out);
        out.flush();
        return count;
    }
    
    /**
     * 将某个输入流装载至内存中
     * 
     * @param in
     * @param closeable 如果为'true'，装载至内存后关闭该输入流，否则不
     * @return
     * @throws IOException
     */
    public static byte[] toBytes(InputStream in, boolean closeable) throws IOException {

        try {
            return IO.toByteArray(in);
        } finally {
            if (closeable)
                close(in);
        }
    }
    
    /**
     * 将任意一个输入流包装成一个Reader
     * 
     * @param <T>
     * @param rClass
     * @param in
     * @return
     * @throws IOException
     */
    public static <T extends Reader> T reader(Class<T> rClass, InputStream in) throws IOException {

        return ClassWrapper.wrap(rClass).newOne(in);
    }
    
    /**
     * 将任意一个输出流包装成一个Writer
     * 
     * @param <T>
     * @param wClass
     * @param out
     * @return
     * @throws IOException
     */
    public static <T extends Writer> T writer(Class<T> wClass, OutputStream out) throws IOException {

        return ClassWrapper.wrap(wClass).newOne(out);
    }
    
    /**
     * 将任意一个输出流包装成PrintWriter
     * 
     * @param out
     * @return
     * @throws IOException
     */
    public static PrintWriter printWriter(OutputStream out) throws IOException {

        return new PrintWriter(out);
    }
    
    /**
     * 将某个输入流装载至内存中
     * 
     * @param in
     * @return
     * @throws IOException
     */
    public static byte[] toBytes(InputStream in) throws IOException {

        return toBytes(in, false);
    }
    
    /**
     * 创建一个文件输出流
     * 
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    public static FileOutputStream fileOut(File file) throws FileNotFoundException {

        checkIsFile(file, "Can't not create fileoutputstream of directory! ");
        return new FileOutputStream(file);
    }
    
    public static FileOutputStream fileOut(File directory, String fileName)
        throws FileNotFoundException {

        return fileOut(new File(directory, fileName));
    }
    
    public static FileOutputStream fileOut(String directory, String fileName)
        throws FileNotFoundException {

        return fileOut(new File(new File(directory), fileName));
    }
    
    public static FileWriter fileWriter(File file) throws IOException {

        return new FileWriter(file);
    }
    
    public static FileWriter fileWriter(String directory, String fileName) throws IOException {

        return fileWriter(new File(directory, fileName));
    }
    
    public static FileInputStream fileIn(File file) throws FileNotFoundException {

        checkExists(file);
        checkIsFile(file, "Can't not read file,becuse the file object is a directory!");
        return new FileInputStream(file);
    }
    
    public static BufferedInputStream fileBufferIn(File file) throws FileNotFoundException {

        return IO.buffer(fileIn(file));
    }
    
    
    public static BufferedOutputStream fileBufferOut(File file) throws FileNotFoundException {
    	return IO.buffer(fileOut(file));
    }
    
    /**
     * 关闭一个或者多个流对象
     * 
     * @param cc
     */
    public static void close(Closeable... cc) {

        try {
            for (Closeable c : cc) {
                if (c != null)
                    c.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void checkIsFile(File file, String msg) {

        if (file.isDirectory())
            throw Lang.makeThrow(msg);
    }
    
    private static void checkExists(File file) {

        if (!file.exists())
            throw Lang.makeThrow("the file[%s] is not exists!", file.getName());
    }
    
}
