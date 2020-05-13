package com.dc.common.util.base;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 常见的辅助类
 */
public final class DataUtil {
	
    private DataUtil() {
    	
    }

    /**
     * 十进制字节数组转十六进制字符串
     * @param b
     * @return
     */
    public static final String byte2hex(byte[] b) { // 一个字节数，转成16进制字符串
        StringBuilder hs = new StringBuilder(b.length * 2);
        String stmp = "";
        for (byte element : b) {
            // 整数转成十六进制表示
            stmp = Integer.toHexString(element & 0XFF);
            if (stmp.length() == 1) {
                hs.append("0").append(stmp);
            } else {
                hs.append(stmp);
            }
        }
        return hs.toString(); // 转成大写
    }

    /**
     * 十六进制字符串转十进制字节数组
     * @param hs
     * @return
     */
    public static final byte[] hex2byte(String hs) {
        byte[] b = hs.getBytes();
        if (b.length % 2 != 0) {
            throw new IllegalArgumentException("长度不是偶数");
        }
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            // 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个十进制字节
            b2[n / 2] = (byte)Integer.parseInt(item, 16);
        }
        return b2;
    }

    /**
     * 这个方法可以通过与某个类的class文件的相对路径来获取文件或目录的绝对路径。 通常在程序中很难定位某个相对路径，特别是在B/S应用中。
     * 通过这个方法，我们可以根据我们程序自身的类文件的位置来定位某个相对路径。
     * 比如：某个txt文件相对于程序的Test类文件的路径是../../resource/test.txt，
     * 那么使用本方法Path.getFullPathRelateClass("../../resource/test.txt",Test.class)
     * 得到的结果是txt文件的在系统中的绝对路径。
     *
     * @param relatedPath
     *            相对路径
     * @param cls
     *            用来定位的类
     * @return 相对路径所对应的绝对路径
     */
    public static final String getFullPathRelateClass(String relatedPath, Class<?> cls) {
        String path = null;
        if (relatedPath == null) {
            throw new NullPointerException();
        }
        String clsPath = getPathFromClass(cls);
        File clsFile = new File(clsPath);
        String tempPath = clsFile.getParent() + File.separator + relatedPath;
        File file = new File(tempPath);
        try {
            path = file.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    /**
     * 获取class文件所在绝对路径
     *
     * @param cls
     * @return
     */
    public static final String getPathFromClass(Class<?> cls) {
        String path = null;
        if (cls == null) {
            throw new NullPointerException();
        }
        URL url = getClassLocationURL(cls);
        if (url != null) {
            path = url.getPath();
            if ("jar".equalsIgnoreCase(url.getProtocol())) {
                try {
                    path = new URL(path).getPath();
                } catch (MalformedURLException e) {
                }
                int location = path.indexOf("!/");
                if (location != -1) {
                    path = path.substring(0, location);
                }
            }
            File file = new File(path);
            try {
                path = file.getCanonicalPath();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return path;
    }

    /**
     * 判断对象是否Empty(null或元素为0)<br>
     * 实用于对如下对象做判断:String Collection及其子类 Map及其子类
     *
     * @param pObj
     *            待检查对象
     * @return boolean 返回的布尔值
     */
    public static final boolean isEmpty(Object pObj) {
        if (pObj == null || "".equals(pObj)) {
            return true;
        }
        if (pObj instanceof String) {
            if (((String)pObj).trim().length() == 0) {
                return true;
            }
        } else if (pObj instanceof Collection<?>) {
            if (((Collection<?>)pObj).size() == 0) {
                return true;
            }
        } else if (pObj instanceof Map<?, ?>) {
            if (((Map<?, ?>)pObj).size() == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断对象是否为NotEmpty(!null或有元素)<br>
     * 实用于对如下对象做判断:String Collection及其子类 Map及其子类
     *
     * @param pObj
     *            待检查对象
     * @return boolean 返回的布尔值
     */
    public static final boolean isNotEmpty(Object pObj) {
        if (pObj == null || "".equals(pObj)) {
            return false;
        }
        if (pObj instanceof String) {
            if (((String)pObj).trim().length() == 0) {
                return false;
            }
        } else if (pObj instanceof Collection<?>) {
            if (((Collection<?>)pObj).size() == 0) {
                return false;
            }
        } else if (pObj instanceof Map<?, ?>) {
            if (((Map<?, ?>)pObj).size() == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 分别去空格
     *
     * @param paramArray
     * @return
     */
    public static final String[] trim(String[] paramArray) {
        if (ArrayUtils.isEmpty(paramArray)) {
            return paramArray;
        }
        String[] resultArray = new String[paramArray.length];
        for (int i = 0; i < paramArray.length; i++) {
            String param = paramArray[i];
            resultArray[i] = StringUtils.trim(param);
        }
        return resultArray;
    }

    /**
     * 获取类的class文件位置的URL
     *
     * @param cls
     * @return
     */
    private static URL getClassLocationURL(final Class<?> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("null input: cls");
        }
        URL result = null;
        final String clsAsResource = cls.getName().replace('.', '/').concat(".class");
        final ProtectionDomain pd = cls.getProtectionDomain();
        if (pd != null) {
            final CodeSource cs = pd.getCodeSource();
            if (cs != null) {
                result = cs.getLocation();
            }
            if (result != null) {
                if ("file".equals(result.getProtocol())) {
                    try {
                        if (result.toExternalForm().endsWith(".jar") || result.toExternalForm().endsWith(".zip")) {
                            result = new URL("jar:".concat(result.toExternalForm()).concat("!/").concat(clsAsResource));
                        } else if (new File(result.getFile()).isDirectory()) {
                            result = new URL(result, clsAsResource);
                        }
                    } catch (MalformedURLException ignore) {
                    }
                }
            }
        }
        if (result == null) {
            final ClassLoader clsLoader = cls.getClassLoader();
            result = clsLoader != null ? clsLoader.getResource(clsAsResource)
                : ClassLoader.getSystemResource(clsAsResource);
        }
        return result;
    }

    /** 初始化设置默认值 */
    public static final <K> K ifNull(K k, K defaultValue) {
        if (k == null) {
            return defaultValue;
        }
        return k;
    }

    /**
     * 判断是否是正确的IP地址
     * @param ip
     * @return boolean true,通过，false，没通过
     */
    public static boolean isIp(String ip) {
        if (isEmpty(ip)) {
            return false;
        }
        return ip.matches(RegexType.IP.value());
    }

    /**
     * 判断是否是正确的邮箱地址
     * @param email
     * @return boolean true,通过，false，没通过
     */
    public static boolean isEmail(String email) {
        if (isEmpty(email)) {
            return false;
        }
        return email.matches(RegexType.EMAIL.value());
    }

    /**
     * 判断是否正整数
     * @param number 数字
     * @return boolean true,通过，false，没通过
     */
    public static boolean isNumber(String number) {
        if (isEmpty(number)) {
            return false;
        }
        return number.matches(RegexType.NUMBER.value());
    }

    /**
     * 判断几位小数
     * @param decimal 数字
     * @param count 小数位数
     * @return boolean true,通过，false，没通过
     */
    public static boolean isDecimal(String decimal, int count) {
        if (isEmpty(decimal)) {
            return false;
        }
        String regex = "^(-)?(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){" + count + "})?$";
        return decimal.matches(regex);
    }

    /**
     * 判断是否是手机号码
     * @param phoneNumber 手机号码
     * @return boolean true,通过，false，没通过
     */
    public static boolean isPhone(String phoneNumber) {
        if (isEmpty(phoneNumber)) {
            return false;
        }
        return phoneNumber.matches(RegexType.PHONE.value());
    }

    /**
     * 验证固话号码
     *
     * @param telephone
     * @return
     */
    public static boolean isTelephone(String telephone) {
        if (isEmpty(telephone)) {
            return false;
        }
        return telephone.matches(RegexType.TELEPHONE.value());
    }

    /**
     * 判断是否含有特殊字符
     * @param text
     * @return boolean true,通过，false，没通过
     */
    public static boolean hasSpecialChar(String text) {
        if (isEmpty(text)) {
            return false;
        }
        if (text.replaceAll("[a-z]*[A-Z]*\\d*-*_*\\s*", "").length() == 0) {
            // 如果不包含特殊字符
            return true;
        }
        return false;
    }

    /**
     * 强密码验证
     * @param value
     * @return
     */
    public static boolean isPassword(String value) {
        if (isEmpty(value)) {
            return false;
        }
        return value.matches(RegexType.PASSWORD.value());
    }

    /**
     * 判断是否含有中文，仅适合中国汉字，不包括标点
     * @param text
     * @return boolean true,通过，false，没通过
     */
    public static boolean isChinese(String text) {
        if (isEmpty(text)) {
            return false;
        }
        Pattern p = Pattern.compile(RegexType.CHINESE.value());
        Matcher m = p.matcher(text);
        return m.find();
    }

    /**
     * 适应CJK（中日韩）字符集，部分中日韩的字是一样的
     */
    public static boolean isChinese2(String strName) {
        char[] ch = strName.toCharArray();
        for (char c : ch) {
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }
    
	// 获得图片的base64码
	public static String getImageBase(String src) {
		HttpURLConnection conn = null;
		URL url;
		try {
			url = new URL(src);
			conn = (HttpURLConnection) url.openConnection();
			// 设置请求方式为"GET"
			conn.setRequestMethod("GET");
			// 超时响应时间为5秒
			conn.setConnectTimeout(5 * 1000);
			// 通过输入流获取图片数据
			InputStream inStream = conn.getInputStream();
			// 得到图片的二进制数据，以二进制封装得到数据，具有通用性
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			// 创建一个Buffer字符串
			byte[] buffer = new byte[1024];
			// 每次读取的字符串长度，如果为-1，代表全部读取完毕
			int len = 0;
			// 使用一个输入流从buffer里把数据读取出来
			while ((len = inStream.read(buffer)) != -1) {
				// 用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
				outStream.write(buffer, 0, len);
			}
			// 关闭输入流
			inStream.close();
			byte[] data = outStream.toByteArray();
			// 对字节数组Base64编码
			BASE64Encoder encoder = new BASE64Encoder();
			String base64 = encoder.encode(data);
			return base64;// 返回Base64编码过的字节数组字符串
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static String getWorkingYears(Integer monthNum){
		String workyears = "";
		if(monthNum != null && monthNum > 0) {
			if((monthNum / 12) > 0) {
				workyears = (monthNum / 12) + "年";
			}
			if(monthNum % 12 != 0) {
				workyears = workyears + monthNum % 12 + "个月";
			}
		}else{
			workyears = "0";
		}
		return workyears;
	}
    
}
