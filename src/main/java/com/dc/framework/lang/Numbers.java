package com.dc.framework.lang;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.util.Assert;

/**
 * 数字工具类,提供数字格式化,类型转换,及数字之前的计算
 */
public abstract class Numbers extends NumberUtils {
    
    /**
     * 格式化一个数字
     * 
     * @param num 数字
     * @param fmt 格式
     * @return
     */
    public static String format(double num, String fmt) {

        DecimalFormat df = new DecimalFormat(fmt);
        return df.format(num);
    }
    
    /**
     * 格式化一个字符串数字
     * @param num
     * @param fmt
     * @return
     */
    public static String format(String num, String fmt) {
        return format(Double.valueOf(num), fmt);
    }
    
    /**
     * 先精度运算，再格式化数字
     * @param num 数字
     * @param fmt 格式
     * @param p   精度
     * @return
     */
    public static String format(double num,String fmt,int p) {
    	return format(round(num,p),fmt);
    }    
    
    /**
     * @see #format(double, String)
     */
    public static String format(String num,String fmt,int p) {
    	return format(round(toDouble(num),p),fmt);
    } 
    
    /**
     * 合计一组浮点数
     * @param values
     * @return
     */
    public static double total(double... values) {

        double d = 0;
        for (double v : values) {
            d += v;
        }
        return d;
    }
    
    /**
     * 求某个数的反数，如 -1 的反数是 1, 1 的反数为 -1，0不做处理
     * 
     * @param num
     * @return
     */
    public static String toNegative(String num, String fmt) {

        if (isNumber(num)) {
            fmt = Strings.defaultIfEmpty(fmt, "0.00");
            Double d = Double.valueOf(num);
            if (d != 0) {
                d = d / -1;
            }
            return format(d, fmt);
        }
        return num;
    }
    
    /**
     * 小数的精度运算(四舍五入)，如果要取的精度大于实际浮点数的精度则直接返回该数字
     * @param num 要进行精度运算的数字
     * @param precision 精度
     * @return
     */
    public static Double round(Double num,int precision) {
    	if (num == null)
    		return 0d;
    	BigDecimal dec = new BigDecimal(num).round(new MathContext(precision));
    	return dec.doubleValue();
    }
    
    /**
     * 合计一组浮点数并作格式化
     * @param fmt 格式
     * @param values
     * @return
     */
    public static String total(String fmt, double... values) {

        return format(total(values), fmt);
    }
    
    /**
     * 统计一个数据集
     * 
     * @param list 数据集
     * @param property VO属性
     * @return
     */
    @SuppressWarnings("unchecked")
    public static String totalByList(List list, String property) {

        Assert.notEmpty(list);
        double[] totalValues = new double[list.size()];
        int i = 0;
        for (Iterator it = list.iterator(); it.hasNext();) {
            String pValue = "";
            Object obj = it.next();
            try {
                pValue = com.dc.framework.lang.reflect.Beans.getProperty(it.next(), property);
            } catch (Exception e) {
                Lang.makeThrow("Not found property[%s] of Class[%s] ! ", property, obj.getClass()
                        .getName());
            }
            totalValues[i] = Double.valueOf(pValue);
            i++;
        }
        return total(totalValues) + "";
    }
    
    /**
     * 合计并格式化合计后的总数
     * 
     * @param fmt 格式
     * @param values 值列表
     * @return
     */
    public static String totalWithFormatted(String fmt, String... values) {

        return format(total(values), fmt);
    }
    
    /**
     * 合计多个值
     * 
     * @param values
     * @return
     */
    public static String total(String... values) {

        if (values != null && values.length > 0) {
            double[] douValues = new double[values.length];
            for (int i = 0; i < values.length; i++) {
                douValues[i] = Double.valueOf(values[i]);
            }
            return total(douValues) + "";
        }
        return "";
    }
    
    /**
     * 两个数相除,如果除数为0,不返回无穷大,而是转为1进行相除
     * 
     * @param dividend 被除数
     * @param divisor 除数
     * @return
     */
    public static double divide(double dividend, double divisor) {

        if (divisor == 0) {
            return dividend;
        }
        BigDecimal dividendDecimal = new BigDecimal(Double.toString(dividend));
        BigDecimal divisorDecimal = new BigDecimal(Double.toString(divisor));
        return dividendDecimal.divide(divisorDecimal).doubleValue();
        
    }
    
    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入。 注：不处理除数为零的情况
     * 
     * @param divisor 被除数
     * @param dividend 除数
     * @param scale 表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static float divide(float dividend, float divisor, int scale) {

        return divide(dividend, divisor, scale, false);
    }
    
    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入。 注：不处理除数为零的情况
     * 
     * @param divisor 被除数
     * @param dividend
     * @param scale
     * @return
     */
    public static float divide(long dividend, long divisor, int scale) {

        return divide(dividend, divisor, scale, false);
    }
    
    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入。
     * 
     * @param divisor 被除数
     * @param divisor 除数
     * @param scale 表示需要精确到小数点以后几位。
     * @param dividendIsZero 为true时并且除数为0返回被除数
     * @return 两个参数的商，如果除数为0，返回被除数
     */
    public static float divide(float dividend, float divisor, int scale, boolean dividendIsZero) {

        BigDecimal dividendDecimal = new BigDecimal(Double.toString(dividend));
        BigDecimal divisorDecimal = new BigDecimal(Double.toString(divisor));
        if (dividendIsZero && divisor == 0)
            return dividend;
        return dividendDecimal.divide(divisorDecimal, scale, BigDecimal.ROUND_HALF_UP).floatValue();
    }
    
    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入。
     * 
     * @param dividend 被除数
     * @param dividend 除数
     * @param scale 表示需要精确到小数点以后几位。
     * @param dividendIsZero 为true时并且除数为0返回被除数
     * @return 两个参数的商，如果除数为0，返回被除数
     */
    public static float divide(long dividend, long divisor, int scale, boolean dividendIsZero) {

        BigDecimal dividendDecimal = new BigDecimal(Double.toString(dividend));
        BigDecimal divisorDecimal = new BigDecimal(Double.toString(divisor));
        if (dividendIsZero && divisor == 0)
            return dividend;
        return dividendDecimal.divide(divisorDecimal, scale, BigDecimal.ROUND_HALF_UP).floatValue();
    }
    
    /**
     * 解析一个格式化数字
     * 
     * @param num
     * @param fmt
     * @return
     */
    public static Number parse(String num, String fmt) {
        DecimalFormat df = new DecimalFormat(fmt);
        try {
            return df.parse(num);
        } catch (ParseException e) {
            throw new RuntimeException("输入的字符串非数字或者指定格式有误!", e);
        }
    }
    
    /**
     * 判断一个字符串是否为数字
     * 
     * @param num
     * @return
     */
    public static boolean isNumber(String num) {

        if (Strings.isNotEmpty(num)) {
            return NumberUtils.isNumber(num.trim());
        }
        
        return false;
    }
    
    /**
     * 求一个数字的绝对值
     * 
     * @param num
     * @return
     */
    public static String abs(String num) {

        if (isNumber(num)) {
            return Math.abs(Double.valueOf(num)) + "";
        }
        return num;
    }
    
    /**
     * 求一个字符串数字的绝对值
     * @param num
     * @param fmt
     * @return
     */
    public static String abs(String num, String fmt) {

        return format(abs(num), fmt);
    }

    
    public static String chineseNumber(long number) {

        long t = 0;
        String zero = "零";
        if (number == 0) {
            return "零";
        } else if (number == 1) {
            return "一";
        } else if (number == 2) {
            return "二";
        } else if (number == 3) {
            return "三";
        } else if (number == 4) {
            return "四";
        } else if (number == 5) {
            return "五";
        } else if (number == 6) {
            return "六";
        } else if (number == 7) {
            return "七";
        } else if (number == 8) {
            return "八";
        } else if (number == 9) {
            return "九";
        } else if (number == 10) {
            return "十";
        } else if (number > 99999999) {
            t = number / 100000000;
            return chineseNumber(t)
                    + "亿"
                    + (number % 100000000 == 0 ? ""
                            : (((number % 100000000) < 10000000 ? zero : "") + chineseNumber(number % 100000000)));
        } else if (number > 9999 && number < 100000000) {
            t = number / 10000;
            return chineseNumber(t)
                    + "万"
                    + (number % 10000 == 0 ? ""
                            : (((number % 10000) < 1000 ? zero : "") + chineseNumber(number % 10000)));
        } else if (number > 999 && number < 10000) {
            t = number / 1000;
            return chineseNumber(t)
                    + "千"
                    + (number % 1000 == 0 ? ""
                            : (((number % 1000) < 100 ? zero : "") + chineseNumber(number % 1000)));
        } else if (number > 99 && number < 1000) {
            t = number / 100;
            return chineseNumber(t)
                    + "百"
                    + (number % 100 == 0 ? ""
                            : (((number % 100) < 10 ? zero : "") + chineseNumber(number % 100)));
        } else if (number > 9 && number < 100) {
            t = number / 10;
            return chineseNumber(t) + "十" + (number % 10 == 0 ? "" : chineseNumber(number % 10));
        } else
            return "";
        
    }
    
    
    public static void main(String[] strs) {
    	Lang.println(round(0.124,4));
    }
    
}
