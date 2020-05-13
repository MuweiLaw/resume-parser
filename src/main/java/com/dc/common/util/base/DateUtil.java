package com.dc.common.util.base;

import org.apache.commons.lang.StringUtils;
import org.quartz.CronExpression;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;


/**
 * 日期操作辅助类
 */
public final class DateUtil {
	
    private DateUtil() {
    	
    }
    
    /** 日期格式 **/
    public interface DATE_PATTERN {
        String HHMMSS = "HHmmss";
        String HH_MM_SS = "HH:mm:ss";
        String YYYYMMDD = "yyyyMMdd";
        String YYYY_MM_DD = "yyyy-MM-dd";
        String YYYY_MM_DD_X="yyyy年MM月dd日";
        String YYYY_MM = "yyyy-MM";
        String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
        String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
        String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
        String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
        String YYYYMD = "yyyy/MM/dd";
    }
    
    /** 
     * 使用预设格式将字符串转为Date 
     */  
    public static Date parse(String strDate, String pattern) {  
        try {
			return StringUtils.isBlank(strDate) ? null : new SimpleDateFormat(pattern).parse(strDate);
		} catch (ParseException e) {
			return null;
		}
    }  

    /**
     * 格式化日期
     *
     * @param date
     * @return
     */
    public static final String format(Object date) {
        return format(date, DATE_PATTERN.YYYY_MM_DD);
    }

    /**
     * 格式化日期
     *
     * @param date
     * @param pattern
     * @return
     */
    public static final String format(Object date, String pattern) {
        if (date == null) {
            return "";
        }
        if (pattern == null) {
            return format(date);
        }
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 获取日期
     *
     * @return
     */
    public static final String getDate() {
        return format(new Date());
    }

    /**
     * 获取日期时间
     *
     * @return
     */
    public static final String getDateTime() {
        return format(new Date(), DATE_PATTERN.YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 获取日期
     *
     * @param pattern
     * @return
     */
    public static final String getDateTime(String pattern) {
        return format(new Date(), pattern);
    }

    /**
     * 日期计算
     *
     * @param date
     * @param field
     * @param amount
     * @return
     */
    public static final Date addDate(Date date, int field, int amount) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, amount);
        return calendar.getTime();
    }

    /**
     * 字符串转换为日期:不支持yyM[M]d[d]格式
     *
     * @param date
     * @return
     */
    public static final Date stringToDate(String date) {
        if (date == null) {
            return null;
        }
        String separator = String.valueOf(date.charAt(4));
        String pattern = "yyyyMMdd";
        if (!separator.matches("\\d*")) {
            pattern = "yyyy" + separator + "MM" + separator + "dd";
            if (date.length() < 10) {
                pattern = "yyyy" + separator + "M" + separator + "d";
            }
            pattern += " HH:mm:ss.SSS";
        } else if (date.length() < 8) {
            pattern = "yyyyMd";
        } else {
            pattern += "HHmmss.SSS";
        }
        pattern = pattern.substring(0, Math.min(pattern.length(), date.length()));
        try {
            return new SimpleDateFormat(pattern).parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 间隔秒
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static final Integer getBetween(Date startDate, Date endDate) {
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);

        long n = end.getTimeInMillis() - start.getTimeInMillis();
        return (int)(n / 1000l);
    }


    /**
     * 间隔天数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static final Integer getDayBetween(Date startDate, Date endDate) {
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        end.set(Calendar.HOUR_OF_DAY, 0);
        end.set(Calendar.MINUTE, 0);
        end.set(Calendar.SECOND, 0);
        end.set(Calendar.MILLISECOND, 0);

        long n = end.getTimeInMillis() - start.getTimeInMillis();
        return (int) (n / (60 * 60 * 24 * 1000l));
    }

    /**
     * 间隔月
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static final Integer getMonthBetween(Date startDate, Date endDate) {
        if (startDate == null || endDate == null || !startDate.before(endDate)) {
            return null;
        }
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        int year1 = start.get(Calendar.YEAR);
        int year2 = end.get(Calendar.YEAR);
        int month1 = start.get(Calendar.MONTH);
        int month2 = end.get(Calendar.MONTH);
        int n = (year2 - year1) * 12;
        n = n + month2 - month1;
        return n;
    }

    /**
     * 间隔月，多一天就多算一个月
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static final Integer getMonthBetweenWithDay(Date startDate, Date endDate) {
        if (startDate == null || endDate == null || !startDate.before(endDate)) {
            return null;
        }
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        int year1 = start.get(Calendar.YEAR);
        int year2 = end.get(Calendar.YEAR);
        int month1 = start.get(Calendar.MONTH);
        int month2 = end.get(Calendar.MONTH);
        int n = (year2 - year1) * 12;
        n = n + month2 - month1;
        int day1 = start.get(Calendar.DAY_OF_MONTH);
        int day2 = end.get(Calendar.DAY_OF_MONTH);
        if (day1 <= day2) {
            n++;
        }
        return n;
    }
    
    /**
	 * 获取当前时间戳(yyyy-MM-dd HH:mm:ss.SSSSSSS)
	 * @return
	 */
	public static Timestamp getCurrentTimeStamp(){
		String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSSS").format(new Date());
		return Timestamp.valueOf(currentDate);
	}
	
	
	/**
	 * 获取下次触发时间
	 * @param min
	 * @return
	 */
	 public static final Date getNextFireTime(int min){
	    long currentTimeMillis = System.currentTimeMillis();
	    currentTimeMillis += 60*1000*min;
	    return new Date(currentTimeMillis);
	}
	 
	 /**
		 * 
		* @author 作者 : Tank
		* 方法说明 :根据cron表达式算出下一个时间
		 */
	public static Date getTimeAfter(Date time,String cron) throws Exception{
		CronExpression cronExpression = null;
		try {
			cronExpression = new CronExpression(cron);
		} catch (ParseException e) {
			throw new Exception("时间转换异常"+e);
		}
		return cronExpression.getTimeAfter(time);
	}
	
	/**
	 * 计算两个时间相差多少个年
	 * 
	 * @param start
	 * @param end
	 * @return
	 * @throws ParseException
	 */
	public static int getYearsBetween(Date start, Date end){
		Calendar startDate = Calendar.getInstance();
		startDate.setTime(start);
		Calendar endDate = Calendar.getInstance();
		endDate.setTime(end);
		return (endDate.get(Calendar.YEAR) - startDate.get(Calendar.YEAR));
	}
	
	/**
	 * 计算两个时间相差多少个年和月
	 */
	public static String getYearsMonthBetween(String date){
		if(org.springframework.util.StringUtils.isEmpty(date)){
			return "0年";
		}
		LocalDate now = LocalDate.now();
		LocalDate start = LocalDate.parse(date);
		Period period = Period.between(start, now);
		int years = period.getYears();
		int months = period.getMonths();
		if(years <= 0){
			return months > 0 ? months + "个月" : "0";
		}else{
			return months > 0 ? years + "年" + months + "个月" : years + "年";
		}
	}
	
	public static void main(String[] args) {
        System.out.print(getBetween(parse("2019-4-30 11:52:00", "yyyy-MM-dd HH:mm:ss"), new Date()));
	}
    
}
