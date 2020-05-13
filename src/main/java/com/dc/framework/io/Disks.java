package com.dc.framework.io;

import com.dc.framework.lang.Strings;
import com.dc.framework.lang.collection.Lists;

import java.io.File;
import java.io.FileFilter;
import java.util.List;

/**
 * 磁盘目录工具类
 * 
 */
public abstract class Disks {
    
    public static String absolutePath(String path) {

        File file = Files.of(path);
        return file.getAbsolutePath();
    }
    
    /**
     * 根据一个连接一个目录名和文件名，目录名
     * 
     * @param directory
     * @param fileName
     * @return
     */
    public static String getUnixPath(String directory, String fileName) {

        return addSeparator(directory) + fileName;
    }
    
    /**
     * 添加一个目录分隔符到指定的路径中，如果指定的路径最后一个字符已经是目录隔符则不作处理
     * 
     * @param path
     * @return
     */
    public static String addSeparator(String path) {

        if (!Strings.isEmpty(path)) {
            char sep = path.charAt(path.length() - 1), tempCh;
            if (!(sep == '/' || sep == '\\')) {
                if (Strings.contains(path, '/'))
                    tempCh = '/';
                else
                    tempCh = '\\';
                return path + tempCh;
            }
        }
        return path;
    }
    
    /**
     * 指定一个搜索器，搜索某个目录的文件集
     * 
     * @param dir 文件目录
     * @param filter 搜索器
     * @param chainable 是否深层查找
     * @return
     */
    public static List<File> search(String dir, FileFilter filter, boolean chainable) {

        List<File> fileList = Lists.newList();
        File searchDir = new File(dir);
        if (searchDir.isFile()) {
            fileList.add(searchDir);
            return fileList;
        }
        if (!chainable)
            return Lists.of(searchDir.listFiles(filter));
        search(searchDir, filter, fileList);
        return fileList;
        
    }
    
    protected static void search(File dir, FileFilter filter, List<File> fileList) {

        if (!dir.exists())
            return;
        if (dir.isFile()) {
            fileList.add(dir);
            return;
        }
        File[] files = dir.listFiles(filter);
        for (File f : files) {
            if (f.isDirectory()) {
                search(f, filter, fileList);
            }
            if (f.isFile()) {
                fileList.add(f);
            }
        }
    }
}
