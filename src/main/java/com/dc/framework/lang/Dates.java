/**
 * 修改历史：<br/>
 * =================================================================<br/>
 * 修改人 修改时间 修改原因/内容<br/>
 * =================================================================<br/>
 * sam 20100111 增加修改历史注释<br/>
 */

package com.dc.framework.lang;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;

/**
 * 日期工具类,提供日期字符串转换,分割,格式化，计算等功能
 * 
 */
public abstract class Dates extends DateUtils {
    
    /**
     * 取得某季度的开始或者结束月份
     * 
     * @param quarter 季度
     * @param startOrEnd true-开始月份 false-结束月份
     * @return
     */
    public static int getMonthOfQuarter(int quarter, boolean startOrEnd) {

        if (quarter < 1 || quarter > 4)
            return -1;
        switch (quarter) {
            case 1:
                return startOrEnd ? 1 : 3;
            case 2:
                return startOrEnd ? 4 : 6;
            case 3:
                return startOrEnd ? 7 : 9;
            case 4:
                return startOrEnd ? 10 : 12;
            default:
                return -1;
        }
    }
    
    /**
     * 取某季度的开始月份
     * 
     * @param quarter 季度
     * @return
     */
    public static int getStartMonthOfQuarter(int quarter) {

        return getMonthOfQuarter(quarter, true);
    }
    
    /**
     * 取得某季度的结束月份
     * 
     * @param quarter 季度
     * @return
     */
    public static int getEndMonthOfQuarter(int quarter) {

        return getMonthOfQuarter(quarter, false);
    }
    
    /**
     * 获取某个季度的开始或者结束月份，并根据条件进行格式化
     * @param quarter 季节
     * @param isFormatted 是否格式化
     * @param startOrEnd true为开始月份,false为结束月份
     * @return 以字符串返回取得月份
     */
    public static String getMonthOfQuarter(String quarter, boolean isFormatted, boolean startOrEnd) {

        int _quarter = 0;
        DecimalFormat df = new DecimalFormat("00");
        if (quarter.length() == 2) {
            try {
                _quarter = df.parse(quarter).intValue();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else {
            _quarter = Integer.valueOf(quarter);
        }
        int month = startOrEnd ? getStartMonthOfQuarter(_quarter) : getEndMonthOfQuarter(_quarter);
        
        return isFormatted ? df.format(month) : month + "";
    }
    
    /**
     * 获取某个季节的起始月份
     * @param quarter 季节
     * @return
     */
    public static String getStartMonthOfQuarter(String quarter) {

        return getMonthOfQuarter(quarter, true, true);
    }
    
    /**
     * 获取某个季节的结束月份
     * @param quarter
     * @return
     */
    public static String getEndMonthOfQuarter(String quarter) {

        return getMonthOfQuarter(quarter, true, false);
    }
    
    /**
     * 取得某个月的最后一天,只取天数
     * 
     * @param year 年
     * @param month 月(不能输入大于12或小于1)
     * @return
     */
    public static int getLastDayOfMonth(int year, int month) {

        if (month > 12 && month < 1)
            throw Lang.makeThrow("输入的月份[%s]无效!", month + "");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        return getLasDayOfMonth(c);
    }
    
    /**
     * 根据一个Date类型日期，计算该日期所在月份的最后一天，如1月份最后一天应该是31。
     * @param date 日期对象
     * @return 以字符串类型返回该日期
     */
    public static String getLastDayOfMonth(Date date) {

        Calendar c = calendar(date);
        return getLasDayOfMonth(c) + "";
    }
    
    /**
     * 根据一个Calendar日历对象，计算该日期所在月份的最后一天，如1月份最后一天应该是31。
     * @param c 日历对象
     * @return 以整型返回该日期
     */
    public static int getLasDayOfMonth(Calendar c) {

        Assert.notNull(c, "Calendar can not be null!");
        return c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    
    /**
     * 返回某一个月分的最后一天
     * @param year 年
     * @param month 月
     * @return 以字符串返回该日期
     */
    public static String getLastDayOfMonth(String year, String month) {

        if (!Numbers.isNumber(year) || !Numbers.isNumber(month))
            throw Lang.makeThrow("输入年[%s]或月[%s]非整数！", year, month);
        return (getLastDayOfMonth(Integer.valueOf(year), Integer.valueOf(month)) + "");
    }
    
    /**
     * 获取某一个季节的最后一天
     * @param year 年
     * @param quarter 季节
     * @return
     */
    public static String getLastDayOfQuarter(String year, String quarter) {

        return getLastDayOfMonth(year, getEndMonthOfQuarter(quarter));
    }
    
    /**
     * 取得某个月最后一天的日期
     * 
     * @param year 年
     * @param month 月
     * @param fmt 格式
     * @return
     */
    public static String getLastDateOfMonth(String year, String month, String fmt) {

        String day = getLastDayOfMonth(year, month);
        return changeFormat(year + Numbers.format(month, "00") + Numbers.format(day, "00"),
                "yyyyMMdd", fmt);
    }
    
    public static String getLastDateOfMonth(String year, String month) {

        return getLastDateOfMonth(year, month, DEFAULT_DATE_FORMAT);
    }
    
    /**
     * 根据传进来的某个日期计算出这个日期所在的月份的最后一天的日期
     * 
     * @param date 日期
     * @param fmt 格式
     * @return
     */
    public static String getLastDateByDate(String date, String fmt) {

        return getLastDateOfMonth(getYear(date), getMonth(date), fmt);
    }
    
    public static String getLastDateByDate(String date) {

        return getLastDateOfMonth(getYear(date), getMonth(date), DEFAULT_DATE_FORMAT);
    }
    
    /**
     * 取得当前月最后一天的日期
     * 
     * @return
     */
    public static String getLastDateOfCurrentMonth() {

        return getLastDateOfMonth(currentYear(), currentMonth());
    }
    
    /**
     * 取得当前月的第一天的日期
     * 
     * @return
     */
    public static String getFirstDateOfCurrentMonth() {

        return format(currentYear(), currentMonth(), "1", DEFAULT_DATE_FORMAT);
    }
    
    /**
     * 取得某个季度最后一天的日期
     * 
     * @param year 年
     * @param quarter 季
     * @param fmt 格式化
     * @return
     */
    public static String getLastDateOfQuarter(String year, String quarter, String fmt) {

        String month = getEndMonthOfQuarter(quarter);
        return getLastDateOfMonth(year, month, fmt);
    }
    
    /**
     * 取得某个季度最后一天的日期,并默认格化式为"yyyy-MM-dd"
     * 
     * @param year 年
     * @param quarter 季节
     * @return
     */
    public static String getLastDateOfQuarter(String year, String quarter) {

        return getLastDateOfQuarter(year, quarter, DEFAULT_DATE_FORMAT);
    }
    
    /**
     * 返回指定格式的当前日期
     * 
     * @param fmt 格式
     * @return
     */
    public static String currentDate(String fmt) {

        Date d = new Date();
        return format(d, fmt);
    }
    
    public static String currentDate() {

        return currentDate(DEFAULT_DATE_FORMAT);
    }
    
    public static String currentYear() {

        return currentDate(F_YYYY);
    }
    
    public static String currentMonth() {

        Calendar c = Calendar.getInstance();
        return getMonth(c) + "";
    }
    
    public static String currentDay() {

        Calendar c = Calendar.getInstance();
        return getDay(c) + "";
    }
    
    public static String currentDateTime() {

        return currentDate(DEFAULT_DATE_TIME_FORMAT);
    }
    
    public static String format(Calendar c, String fmt) {

        return format(c.getTime(), fmt);
    }
    
    /**
     * 格式化指定的日期
     * 
     * @param d 日期
     * @param fmt 格式
     * @return
     */
    public static String format(Date d, String fmt) {

        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        return sdf.format(d);
    }
    
    public static String format(String year, String month, String day, String fmt) {

        return changeFormat(year + Numbers.format(month, "00") + Numbers.format(day, "00"),
                F_YYYYMMDD, fmt);
    }
    
    /**
     * 为指定的日期转换格式,如'yyyy-MM-dd'转为'yyyyMMDD'
     * 
     * @param date 日期字符串
     * @param sourceFmt 源格式
     * @param targetFmt 目标格式
     * @return
     */
    public static String changeFormat(String date, String sourceFmt, String targetFmt) {

        // 源格式和目标格式一致则不需要作转换
        if (sourceFmt.equals(targetFmt))
            return date;
        Date d = parse(date, sourceFmt);
        return format(d, targetFmt);
    }
    
    /**
     * 转换日期格式,只要指定目标格式即可
     * 
     * @param date 日期
     * @param targetFmt 日期格式
     * @return
     */
    public static String changeFormat(String date, String targetFmt) {

        String srcFmt = guessFormat(date);
        return changeFormat(date, srcFmt, targetFmt);
    }
    
    /**
     * 将日期转为中国式日期,如: 将 "1992-02-03"转为"1992年2月3日", "199202"转为"1992年2月"
     * 
     * @param date 日期
     * @return
     */
    public static String chineseFormat(String date) {

        String srcFormat = guessFormat(date);
        String targetFormat = null;
        if (Strings.containsAny(srcFormat, "年", "月", "日"))
            return date;
        if (Strings.containsAny(srcFormat, F_YYYYMMDD, F_YYYY_MM_DD, F_YYYY_M_D))
            targetFormat = F_YYYY年M月D日;
        else if (Strings.containsAny(srcFormat, F_YYYYMM, F_YYYY_MM))
            targetFormat = F_YYYY年M月;
        else
            targetFormat = F_YYYY年;
        return changeFormat(date, srcFormat, targetFormat);
    }
    
    /**
     * 推测某个日期的格式
     * 
     * @param date
     * @return
     */
    public static String guessFormat(String date) {

        if (Strings.isEmpty(date))
            return null;
        boolean unHasSepChar = Strings.containsNone(date, "-");
        boolean hasSepChar = Strings.contains(date, "-");
        if (Strings.containsAny(date, "年", "月", "日")) {
            if (F_YYYY年MM月DD日.length() == date.length())
                return F_YYYY年MM月DD日;
            else if (F_YYYY年MM月.length() == date.length())
                return F_YYYY年MM月;
            else if (F_YYYY年M月D日.length() == date.length())
                return F_YYYY年M月D日;
            else
                return F_YYYY年;
        } else if (F_YYYYMMDD.length() == date.length() && unHasSepChar) {
            return F_YYYYMMDD;
        } else if (F_YYYY_MM_DD.length() == date.length() && hasSepChar) {
            return F_YYYY_MM_DD;
        } else if (F_YYYYMM.length() == date.length() && unHasSepChar) {
            return F_YYYYMM;
        } else if (F_YYYY.length() == date.length() && unHasSepChar) {
            return F_YYYY;
        } else if (F_YYYY_MM.length() == date.length() && hasSepChar) {
            return F_YYYY_MM;
        } else if (F_YYYY_MM_DD_HH_MM_SS.length() == date.length() && hasSepChar) {
            return F_YYYY_MM_DD_HH_MM_SS;
            // 有可能是如:1982-12-1 ,1982-1-1 , 1982-1-12,如果是1982-12-12则yyyy-MM-dd为准
        } else if ((F_YYYY_M_D.length() == date.length() || (F_YYYY_M_D.length() + 1) == date
                .length())
                && hasSepChar) {
            return F_YYYY_M_D;
        }
        return null;
        
    }
    
    /**
     * 计算两个日期(格式必须是yyyymm或者yyyy-mm)的时间差，并将时间差的每一个年月日期以集合形式返回
     * 
     * @param startYM 开始年月
     * @param endYM 结束年月
     * @param withSE true为在返回集中加上开始和结束的时间，false则不
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List betweenYM2List(String startYM, String endYM, Boolean... withSE) {

        if (Strings.isEmpty(startYM) || Strings.isEmpty(endYM))
            return null;
        
        int startYear = Integer.valueOf(changeFormat(startYM, "yyyy"));
        int startMonth = Integer.valueOf(changeFormat(startYM, "MM"));
        int endYear = Integer.valueOf(changeFormat(endYM, "yyyy"));
        int endMonth = Integer.valueOf(changeFormat(endYM, "MM"));
        
        List diffList = new ArrayList();
        
        if (startYear > endYear)
            return null;
        if ((startYear == endYear) && (startMonth > endMonth))
            return null;
        if ((startYear == endYear) && (startMonth == endMonth)) {
            diffList.add(startYM);
            return diffList;
        }
        boolean isWithSE = (withSE != null && withSE.length > 0) ? withSE[0] : true;
        
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, startYear);
        c.set(Calendar.MONTH, startMonth - 1);
        String iterYM = startYM;
        do {
            int y = c.get(Calendar.YEAR);
            int m = c.get(Calendar.MONTH) + 1;
            iterYM = y + Numbers.format(m, "00");
            boolean isSE = Strings.equals(iterYM, startYM) || Strings.equals(iterYM, endYM);
            if (isSE && !isWithSE) {
                c.add(Calendar.MONTH, 1);
                continue;
            }
            diffList.add(iterYM);
            c.add(Calendar.MONTH, 1);
        } while (!Strings.equals(iterYM, endYM));
        return diffList;
    }
    
    /**
     * 计算两个日期(格式必须是yyyymmdd或者yyyy-mm-dd)的时间差，并将时间差的每一个年月日期以集合形式返回
     * 
     * @param startYMD 开始日期
     * @param endYMD 结束日期
     * @param withSE true为在返回集中加上开始和结束的时间，false则不
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List betweenYMD2List(String startYMD, String endYMD, Boolean... withSE) {

        if (Strings.isEmpty(startYMD) || Strings.isEmpty(endYMD))
            return null;
        
        int startYear = Integer.valueOf(changeFormat(startYMD, "yyyy"));
        int startMonth = Integer.valueOf(changeFormat(startYMD, "MM"));
        int startDate = Integer.valueOf(changeFormat(startYMD, "dd"));
        int endYear = Integer.valueOf(changeFormat(endYMD, "yyyy"));
        int endMonth = Integer.valueOf(changeFormat(endYMD, "MM"));
        int endDate = Integer.valueOf(changeFormat(endYMD, "dd"));
        
        List diffList = new ArrayList();
        
        if (startYear > endYear)
            return null;
        if ((startYear == endYear) && (startMonth > endMonth))
            return null;
        if ((startYear == endYear) && (startMonth == endMonth) && (startDate > endDate))
            return null;
        if ((startYear == endYear) && (startMonth == endMonth) && (startDate == endDate)) {
            diffList.add(startYMD);
            return diffList;
        }
        boolean isWithSE = (withSE != null && withSE.length > 0) ? withSE[0] : true;
        
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, startYear);
        c.set(Calendar.MONTH, startMonth - 1);
        c.set(Calendar.DAY_OF_MONTH, startDate);
        String iterYM = startYMD;
        do {
            int y = c.get(Calendar.YEAR);
            int m = c.get(Calendar.MONTH) + 1;
            int d = c.get(Calendar.DAY_OF_MONTH);
            iterYM = y + Numbers.format(m, "00") + Numbers.format(d, "00");
            boolean isStartOrEnd = Strings.equals(iterYM, startYMD)
                    || Strings.equals(iterYM, endYMD);
            if (isStartOrEnd && !isWithSE) {
                c.add(Calendar.DAY_OF_MONTH, 1);
                continue;
            }
            diffList.add(iterYM);
            c.add(Calendar.DAY_OF_MONTH, 1);
        } while (!Strings.equals(iterYM, endYMD));
        return diffList;
    }
    
    /**
     * 将日期字符串转换为日期数据类型
     * 
     * @param date 日期字符串
     * @param sourceFmt 格式
     * @return
     */
    public static Date parse(String date, String sourceFmt) {

        SimpleDateFormat sdf = new SimpleDateFormat(sourceFmt);
        Date d = null;
        try {
            d = sdf.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException("日期源格式输入有误!", e);
        }
        return d;
    }
    
    /**
     * 根据支持的格式将日期字符串转换为日期数据类型
     * 
     * @see guessFormat(String date);
     * @param date 日期格式串
     * @return
     */
    public static Date parse(String date) {

        return parse(date, guessFormat(date));
    }
    
    /**
     * 创建一个日历对象
     * 
     * @param date
     * @return
     */
    public static Calendar calendar(String date) {

        return calendar(parse(date));
    }
    
    /**
     * 十二个月的格式化数字列表
     * 
     * @param isFormatted true为格式化
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List allMonths(boolean isFormatted) {

        List<String> monthList = new ArrayList<String>();
        for (int i = 1; i < 13; i++) {
            monthList.add(isFormatted ? Numbers.format(i, "00") : i + "");
        }
        return monthList;
    }
    
    /**
     * 四个季度的格式化数字列表
     * 
     * @param isFormatted true为格式化
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List allQuarters(boolean isFormatted) {

        List<String> quarterList = new ArrayList<String>();
        for (int i = 1; i < 5; i++) {
            quarterList.add(isFormatted ? Numbers.format(i, "00") : i + "");
        }
        return quarterList;
    }
    
    public static String[] splitDateForStrings(String date, String sep) {

        if (Strings.isNotBlank(date))
            return date.split(sep);
        return null;
    }
    
    public static int[] splitDateForInts(String date, String sep) {

        String[] items = splitDateForStrings(date, sep);
        if (items != null) {
            int[] intItems = new int[items.length];
            for (int i = 0; i < items.length; i++) {
                intItems[i] = Integer.valueOf(items[i]);
            }
            return intItems;
        }
        return null;
    }
    
    /**
     * 判断两个日期是否相同
     * 
     * @param d1
     * @param d2
     * @return
     */
    public static boolean isSameDate(Date d1, Date d2) {

        if (d1 == null || d2 == null)
            return false;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        return (getYear(c1) == getYear(c2) && getMonth(c1) == getMonth(c2) && getDay(c1) == getDay(c2));
    }
    
    public static boolean isSameDate(String date1, String formatOfDate1, String date2,
        String formatOfDate2) {

        Date d1 = parse(date1, formatOfDate1);
        Date d2 = parse(date2, formatOfDate2);
        return isSameDate(d1, d2);
    }
    
    /**
     * 判断两个任何格式的日期是否相同
     * 
     * @param date1 日期1
     * @param date2 日期2
     * @return 如果两个日期的格式不同则返回false,如果格式相同对应各字段(年|月|日)也相同返回true,否则false
     */
    public static boolean isSameDate(String date1, String date2) {

        if (Strings.isEmpty(date1) || Strings.isEmpty(date2)) {
            return false;
        }
        String srcFmt1 = guessFormat(date1);
        String srcFmt2 = guessFormat(date2);
        if (srcFmt1.length() != srcFmt2.length())
            return false;
        return isSameDate(date1, srcFmt1, date2, srcFmt2);
    }
    
    public static int get(int field) {

        Calendar c = Calendar.getInstance();
        int reallyValue = 0;
        if (Calendar.MONTH == field)
            reallyValue = 1;
        return c.get(field) + reallyValue;
    }
    
    public static String getYear(String date) {

        return changeFormat(date, F_YYYY);
    }
    
    public static String getMonth(String date) {

        return changeFormat(date, "MM");
    }
    
    public static String getDay(String date) {

        return changeFormat(date, "dd");
    }
    
    /**
     * 将秒转成分钟数
     * 
     * @param seconds
     * @return
     */
    public static String second2Minute(String seconds) {

        String minutue = seconds;
        try {
            DecimalFormat df = new DecimalFormat();
            df.applyPattern("####################0.00");
            double n1 = Numbers.toDouble(seconds) / 60;
            n1 = Math.round(n1 * 100);
            minutue = df.format(n1 / 100);
        } catch (Exception e) {
            
        }
        return minutue;
    }
    
    /**
     * 获取当前时间戳
     * 
     * @param date
     * @param format
     * @return
     */
    public static Timestamp currentTimestamp() {

        return new Timestamp(System.currentTimeMillis());
    }
    
    /**
     * 时间1-时间2的毫秒
     * 
     * @param t1
     * @param t2
     * @return
     */
    public static long between(Timestamp t1, Timestamp t2) {

        if ((t1 != null) && (t2 != null)) {
            return t1.getTime() - t2.getTime();
        }
        
        return 0;
    }
    
    /**
     * 两个日期date1-date2相减，相差的天数
     * 
     * @param date1 日期
     * @param date2 日期
     * @return 返回相减后的日期
     */
    public static int betweenTwoDates(Date date1, Date date2) {

        return (int) ((getMillis(date1) - getMillis(date2)) / (24 * 3600 * 1000));
    }
    
    /**
     * 返回日期中的年份
     * 
     * @param date 日期
     * @return 返回年份
     */
    public static int getYear(Date date) {

        return calendar(date).get(Calendar.YEAR);
    }
    
    public static int getYear(Calendar c) {

        return c.get(Calendar.YEAR);
    }
    
    /**
     * 返回日期中的月份
     * 
     * @param date 日期
     * @return 返回月份
     */
    public static int getMonth(Date date) {

        return calendar(date).get(Calendar.MONTH) + 1;
    }
    
    public static int getMonth(Calendar c) {

        return c.get(Calendar.MONTH) + 1;
    }
    
    /**
     * 返回日期中的日
     * 
     * @param date 日期
     * @return 返回日
     */
    public static int getDay(Date date) {

        return calendar(date).get(Calendar.DAY_OF_MONTH);
    }
    
    public static int getDay(Calendar c) {

        return c.get(Calendar.DAY_OF_MONTH);
    }
    
    /**
     * 返回日期中的小时
     * 
     * @param date 日期
     * @return 返回小时
     */
    public static int getHour(Date date) {

        return calendar(date).get(Calendar.HOUR_OF_DAY);
    }
    
    /**
     * 返回日期中的分钟
     * 
     * @param date 日期
     * @return 返回分钟
     */
    public static int getMinute(Date date) {

        return calendar(date).get(Calendar.MINUTE);
    }
    
    /**
     * 返回日期中的秒钟
     * 
     * @param date 日期
     * @return 返回秒钟
     */
    public static int getSecond(Date date) {

        return calendar(date).get(Calendar.SECOND);
    }
    
    /**
     * 返回日期代表的毫秒
     * 
     * @param date 日期
     * @return 返回毫秒
     */
    public static long getMillis(Date date) {

        return calendar(date).getTimeInMillis();
    }
    
    /**
     * 根据一个Date创建一个Calendar
     * 
     * @param date
     * @return
     */
    public static Calendar calendar(Date date) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;
    }
    
    public static Calendar calendar() {

        return Calendar.getInstance();
    }
    
    /**
     * 转化时间：将java.util.Date转化为java.sql.Date
     * 
     * @param date
     * @return
     */
    public static java.sql.Date toSqlDate(Date date) {

        Assert.notNull(date, "the date can not be null!");
        return new java.sql.Date(date.getTime());
    }
    
    /**
     * 取当前日期的上一个月的日期
     * 
     * @param fmt 格式化
     * @return
     */
    public static String getLastMonth(String fmt) {

        return addMonth(currentDate(), -1, fmt);
    }
    
    /**
     *  取当前日期的上一个月的日期，并使用格式:YYYYMM
     * @return
     */
    public static String getLastMonth() {

        return getLastMonth(F_YYYYMM);
    }
    
    /**
     * 根据i和指定的日期计算月份并提供格式化，具体如下：
     * <pre>
     * Dates.addMonth(20080101,1);//将返回 200802
     * Dates.addMonth(20081201,1);//将返回200901
     * </pre>
     * 
     * @param date 日期
     * @param i 要增加多少个月
     * @param fmt 格式
     * @return
     */
    public static String addMonth(String date, int i, String fmt) {

        Date d = parse(date);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.MONTH, i);
        return format(c, fmt);
    }
    
    /**
     * 根据i和指定的日期计算月份
     * @param date 日期
     * @param i 要增加多少个月
     * @return
     * @see #addMonth(String, int, String)
     */
    public static String addMonth(String date, int i) {

        String fmt = guessFormat(date);
        return addMonth(date, i, fmt);
    }
    
    public static final String F_YYYYMMDD = "yyyyMMdd";
    public static final String F_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String F_YYYY_M_D = "yyyy-M-d";
    public static final String F_YYYYMM = "yyyyMM";
    public static final String F_YYYY = "yyyy";
    public static final String F_YYYY_MM = "yyyy-MM";
    public static final String F_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd hh:mm:ss";
    public static final String F_YYYYMMDD_HH_MM_SS = "yyyyMMdd hh:mm:ss";
    public static final String F_YYYY年MM月DD日 = "yyyy年MM月dd日";
    public static final String F_YYYY年M月D日 = "yyyy年M月d日";
    public static final String F_YYYY年MM月 = "yyyy年MM月";
    public static final String F_YYYY年M月 = "yyyy年M月";
    public static final String F_YYYY年 = "yyyy年";
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd hh:mm:dd";
    
    public static void main(String[] args) {

        // unit test
        System.out.println(currentDate());
        System.out.println(currentDate("yyyy-MM-dd"));
        System.out.println(currentDate("yyyy-MM-dd hh:mm:ss"));
        System.out.println(currentYear());
        System.out.println(currentMonth());
        System.out.println(currentDay());
        System.out.println(changeFormat("200908", "yyyyMM", "yyyy-MM-dd"));
        System.out.println(changeFormat("2009", "yyyy", "yyyy-MM-dd"));
        System.out.println(getLastDayOfMonth("2009", "5"));
        System.out.println(getLastDayOfMonth("2009", "6"));
        System.out.println(getLastDateOfMonth("2009", "6"));
        System.out.println(getLastDateOfMonth("2009", "6", "yyyy=MM=dd"));
        System.out.println(format("2009", "06", "01", "yyyy-MM-dd"));
        System.out.println("currentLastDate:" + getLastDateOfCurrentMonth());
        System.out.println(currentDate("yyyy年M月d日"));
        System.out.println(chineseFormat("20091123"));
        System.out.println(guessFormat("20091123"));
        System.out.println(guessFormat("2009-11-23"));
        System.out.println(guessFormat("2009-11"));
        System.out.println(guessFormat("2009"));
        System.out.println(guessFormat("2009年1月20日"));
        System.out.println(isSameDate("2009-01-03", "2009-11-03"));
        System.out.println(isSameDate("2009-11-03", "2009-11-03"));
        System.out.println(isSameDate("200911", "200911"));
        System.out.println(isSameDate("20091102", "20091101"));
        //	 
        // System.out.println(changeFormat("2009-1-1","yyyy-MM-dd"));
        System.out.println(betweenYM2List("200901", "201001"));
        System.out.println(betweenYM2List("200901", "201001", true));
        System.out.println(betweenYM2List("201001", "201001"));
        System.out.println(betweenYM2List("200901", "201001", false));
        System.out.println(betweenYMD2List("20100101", "20100103"));
        System.out.println(betweenYMD2List("20100101", "20100104", false));
        
        Lang.println(getLastMonth());
        Lang.println(addMonth(currentDate(F_YYYYMM), 0));
    }
    
}
