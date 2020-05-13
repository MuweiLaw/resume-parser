/**
 * 修改历史：<br/>
 * =================================================================<br/>
 * 修改人 修改时间 修改原因/内容<br/>
 * =================================================================<br/>
 * sam 20100111 增加修改历史注释<br/>
 */

package com.dc.framework.lang;

import com.dc.framework.lang.collection.Lists;

import java.io.File;
import java.util.Collection;
import java.util.List;

/**
 * 类搜索器,根据指定的ClassFilter搜索类,搜索到的类如果没有装载则装载它
 * 
 */
public class ClassScaner {
    
    private static final String DOT_CLASS = ".class";
    
    private String classPath;
    private File[] searchPaths;
    private ClassLoader classLoader;
    
    private File root;
    private ClassFilter filter;
    private List<Class<?>> result;
    
    /**
     * 初始化类搜索器
     * 
     * @param classPath 类路径
     * @param classLoader 类装载器
     * @param rootPackages 指定要搜索的包,没有指定则搜索类路径下所有的包
     */
    public ClassScaner(String classPath, ClassLoader classLoader, String... rootPackages) {

        this.classPath = classPath;
        this.classLoader = classLoader;
        
        root = new File(classPath);
        if (!root.exists()) {
            throw new IllegalArgumentException(classPath + " doesn't exist");
        }
        
        if (!root.isDirectory()) {
            throw new IllegalArgumentException(classPath + "is not a directory");
        }
        
        if (Arrays.isNotEmpty(rootPackages)) {
            searchPaths = new File[rootPackages.length];
            int i = 0;
            for (String p : rootPackages) {
                String path = p.replace('.', File.separatorChar);
                searchPaths[i] = new File(root, path);
                if (!searchPaths[i].exists()) {
                    throw new IllegalArgumentException(rootPackages
                            + "package does't exist under classpath " + classPath);
                }
                i++;
            }
        }
        
    }
    
    public Collection<Class<?>> list(ClassFilter filter) throws ClassNotFoundException {

        this.filter = filter;
        result = Lists.newList();
        if (searchPaths == null) {
            traverse(root);
        } else {
            for (File path : searchPaths) {
                traverse(path);
            }
        }
        
        return result;
    }
    
    private void traverse(File dir) throws ClassNotFoundException {

        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                traverse(file);
                continue;
            }
            
            if (!file.getName().endsWith(DOT_CLASS)) {
                continue;
            }
            
            String name = toQualifiedClassName(file);
            if (!filter.nameMatches(name)) {
                continue;
            }
            
            Class<?> clazz = null;
            try {
                clazz = toClassDefinition(file);
            } catch (NoClassDefFoundError e) {
                continue;
            }
            
            if (filter.classMatches(clazz)) {
                result.add(clazz);
            }
        }
    }
    
    private Class<?> toClassDefinition(File file) throws ClassNotFoundException {

        String name = toQualifiedClassName(file);
        return classLoader.loadClass(name);
    }
    
    private String toQualifiedClassName(File file) {

        String name = file.getPath().substring(classPath.length() + 1);
        name = name.substring(0, name.length() - DOT_CLASS.length());
        return name.replace(File.separatorChar, '.');
    }
    
    public static void main(String[] a) {

    }
    
}
