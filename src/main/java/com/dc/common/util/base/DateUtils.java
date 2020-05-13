package com.dc.common.util.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 计算周的时候是根据 周一为每周的第一天 ，  每年的第一周最少有几天   odps函数  weekofyear  4天以上 包含4天
 * Description (日期工具类)
 * author: gaoxueyong
 * Create at: 2017/11/23 9:46
 */
public class DateUtils {

    public static void main(String[] args) throws ParseException {


        String yyyy_MM_dd = "2018-01-25 ";
        String[] daAry = "6:40-7:15".split("-");
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date dateStart =sdf.parse(yyyy_MM_dd+daAry[0]);
        Date dateEnd =sdf.parse(yyyy_MM_dd+daAry[1]);
        System.out.println(dateStart.getTime());
        System.out.println(dateEnd.getTime());
        System.out.println(getDatePoor(dateStart,dateEnd));;


    }

    /**
     * 根据日期字符串判断当月第几周
     * @param date_str 格式 yyyy-MM-dd
     * @return
     */
    public static Integer getWeekOfMonth(String date_str){
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date =sdf.parse(date_str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            //第几周
            int week = calendar.get(Calendar.WEEK_OF_MONTH);
            //第几天，从周日开始
            int day = calendar.get(Calendar.DAY_OF_WEEK);
            return week;
        }catch (Exception e){
            return null;
        }
    }

    /**
     *  根据日期字符串获取是当年的第几周
     * @param date_str  格式 yyyy-MM-dd
     * @return
     */
    public static Integer getWeekOfYear(String date_str) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(date_str);
            Calendar calendar = Calendar.getInstance();
    //        设置周一是一周的开始
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
    //        每年的第一周最少有几天   odps函数  weekofyear  4天以上
            calendar.setMinimalDaysInFirstWeek(4);
            calendar.setTime(date);
            return calendar.get(Calendar.WEEK_OF_YEAR);
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * 获取日期所在周的周一  日期为null  则显示 当前日期的周一
     * @param date_str
     * @return
     */
    public static String getWeekMonday(String date_str){
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
            if(date_str!=null && !"".equals(date_str)){
                calendar.setTime(sdf.parse(date_str));
            }

            int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);

            if(day_of_week==1){
                //周日
                calendar.add(Calendar.DATE,-6);
            }else{
//                day_of_week ==2  周一
                calendar.add(Calendar.DATE,-(day_of_week-2));
            }
            return sdf.format(calendar.getTime());
        }catch (Exception e){
            return null;
        }
    }




    /**
     * 获取上一周的周一
     * @return  如 2017-11-06
     */
    public static String getLastWeekMonday(){
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);

            if(day_of_week==1){
                //周日
                calendar.add(Calendar.DATE,-13);
            }else{
//                day_of_week ==2  周一
                calendar.add(Calendar.DATE,-(day_of_week+5));
            }
            return sdf.format(calendar.getTime());
        }catch (Exception e){
            return null;
        }
    }

    /**
     *  获取上一周的周日
     * @return
     */
    public static String getLastWeekSunday(){
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(getLastWeekMonday()));
            calendar.add(Calendar.DATE,+6);
            return sdf.format(calendar.getTime());
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 获取上上一周的周一
     * @return  如 2017-11-06
     */
    public static String getLastLastWeekMonday(){
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);
            if(day_of_week==1){
                //周日
                calendar.add(Calendar.DATE,-20);
            }else{
                calendar.add(Calendar.DATE,-(day_of_week+12));
            }
            return sdf.format(calendar.getTime());
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 获取当前日期的字符串 如  20171116
     * @return
     */
    public static String getCurrentTime_yyyyMMdd(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(new Date());
    }

    /**
     * 获取当前日期的字符串 如  2017-11-16
     * @return
     */
    public static String getCurrentTime_yyyy_MM_dd(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

    /**
     * 获取当前日期的字符串 如  20171116
     * @return
     */
    public static String getCurrentTime_yyyyMMddHHmmss(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }


    /**
     * 获取当前日期的字符串(毫秒) 如
     * @return
     */
    public static String getCurrentTime_yyyyMMddHHmmssSSS(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date());
    }


    /**
     * 获取当前日期的字符串 如  2017-11-22 15:12:33
     * @return
     */
    public static String getCurrentTime_yyyy_MM_dd_HH_mm_ss(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }


    /**
     *  根据年、周数获取该周的具体日期
     * @param year  year可以为null
     * @param week_no
     * @return
     */
    public static List<String> getListWeekDaysByWeekNo(Integer year, Integer week_no){
        if(week_no==null){return null;}
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        if(year!=null){
            calendar.set(Calendar.YEAR,year);
        }
        calendar.set(Calendar.WEEK_OF_YEAR,week_no);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
//        每年的第一周最少有几天   odps函数  weekofyear  4天以上
        calendar.setMinimalDaysInFirstWeek(4);
        List result = new ArrayList();
        calendar.set(Calendar.DAY_OF_WEEK,2);// 1表示周日，2表示周一，7表示周六
        result.add(sf.format(calendar.getTime()));//周一
        calendar.set(Calendar.DAY_OF_WEEK,3);
        result.add(sf.format(calendar.getTime()));//周二
        calendar.set(Calendar.DAY_OF_WEEK,4);
        result.add(sf.format(calendar.getTime()));//周三
        calendar.set(Calendar.DAY_OF_WEEK,5);
        result.add(sf.format(calendar.getTime()));//周四
        calendar.set(Calendar.DAY_OF_WEEK,6);
        result.add(sf.format(calendar.getTime()));//周五
        calendar.set(Calendar.DAY_OF_WEEK,7);
        result.add(sf.format(calendar.getTime()));//周六
        calendar.set(Calendar.DAY_OF_WEEK,1);
        result.add(sf.format(calendar.getTime()));//周日

        return result;
    }

    /**
     * 两个时间段相差分钟数据
     * @param startDate
     * @param endDate
     * @return   day + "_" + hour + "_" + min
     */
    public static long getDatePoor(Date startDate, Date endDate) {


        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - startDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day * 24 * 60  + hour * 60  + min;
    }

}