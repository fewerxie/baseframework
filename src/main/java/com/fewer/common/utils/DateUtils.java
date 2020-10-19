package com.fewer.common.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * @Description: 日期工具类
 * @Author: xiezy
 * @Date: 2020/10/16 11:17
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime() {
        return formatDate(new Date(), "HH:mm:ss");
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
        return formatDate(new Date(), pattern);
    }

    /**
     * 得到任意日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (date != null) {
            if (pattern != null && pattern.length > 0) {
                formatDate = DateFormatUtils.format(date, pattern[0].toString());
            } else {
                formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
            }
        }
        return formatDate;
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }

    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getMonth() {
        return formatDate(new Date(), "MM");
    }

    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay() {
        return formatDate(new Date(), "dd");
    }

    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek() {
        return formatDate(new Date(), "E");
    }

    /**
     * 日期型字符串转化为日期 格式
     * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
     * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
     * "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取过去的天数
     *
     * @param date
     * @return
     */
    public static long pastDays(Date date) {
        long t = System.currentTimeMillis() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }

    /**
     * 获取过去的小时
     *
     * @param date
     * @return
     */
    public static long pastHour(Date date) {
        long t = System.currentTimeMillis() - date.getTime();
        return t / (60 * 60 * 1000);
    }

    /**
     * 获取过去的分钟
     *
     * @param date
     * @return
     */
    public static long pastMinutes(Date date) {
        long t = System.currentTimeMillis() - date.getTime();
        return t / (60 * 1000);
    }

    /**
     * 某天的开始时间
     *
     * @date 2017/6/2
     */
    public static Date getDayBegin(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 某天的最后时间
     *
     * @date 2017/6/2
     */
    public static Date getDayEnd(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    /**
     * 某月的开始时间
     *
     * @date 2017/6/2
     */
    public static Date getMonthBegin(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 1, 0, 0, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();

    }

    /**
     * 某月的最后时间
     *
     * @date 2017/6/2
     */
    public static Date getMonthEnd(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 1);
        c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 1, 23, 59, 59);
        c.set(Calendar.MILLISECOND, 999);
        c.add(Calendar.DATE, -1);
        return c.getTime();
    }

    /**
     * 判断是否是同一天
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean isSameDay(Date startDate, Date endDate) {
        return !(startDate == null || endDate == null) && Objects.equals(getDayBegin(startDate), getDayBegin(endDate));
    }

    /**
     * 转换为时间（天,时:分:秒.毫秒）
     *
     * @param timeMillis
     * @return
     */
    public static String formatDateTime(long timeMillis) {
        long day = timeMillis / (24 * 60 * 60 * 1000);
        long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
        long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
        return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
    }

    /**
     * 获取两个日期之间的天数
     *
     * @param before
     * @param after
     * @return
     */
    public static double getDistanceOfTwoDate(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
    }

    /**
     * 获取两个日期之间的分钟数 --如果小于1分钟则按1分钟对待
     *
     * @param before
     * @param after
     * @return
     */
    public static long getDistanceMinOfTwoDate(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        long result = (afterTime - beforeTime) / (1000 * 60);
        return result < 1 ? 1 : result;
    }

    /**
     * 获得指定日期的前或后几天
     *
     * @param specifiedDay
     * @return
     * @throws ParseException
     * @throws Exception
     */
    public static Date getSpecifiedDayBefore(Date specifiedDay, int dayNum) {
        Calendar date = Calendar.getInstance();
        date.setTime(specifiedDay);
        date.set(Calendar.DATE, date.get(Calendar.DATE) + dayNum);
        return date.getTime();
    }

    /**
     * 获取某日期的之后几个小时的时间
     *
     * @date 2020/6/14
     */
    public static Date getSpecifiedHourBefore(Date specifiedDay, int hourNum) {
        Calendar date = Calendar.getInstance();
        date.setTime(specifiedDay);
        date.set(Calendar.HOUR, date.get(Calendar.HOUR) + hourNum);
        return date.getTime();
    }

    /**
     * 返回当前时间所在半个自然年内的开始时间的零点
     * 例如：传入4月1日则返回1月1日00:00:00:000，传入8月1日则返回7月1日00:00:00:000
     *
     * @Date: 10:30 2017/7/27
     */
    public static Date getHalfYearDayStart(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH) + 1;
        //如果1~6月
        if (month >= 1 && month <= 6) {
            c.set(c.get(Calendar.YEAR), 0, 1, 0, 0, 0);
            c.set(Calendar.MILLISECOND, 0);
        }
        //如果7~12月
        else if (month > 6 && month <= 12) {
            c.set(c.get(Calendar.YEAR), 6, 1, 0, 0, 0);
            c.set(Calendar.MILLISECOND, 0);
        }
        return c.getTime();
    }

    /**
     * 返回当前时间所在半个自然年内的结束时间的23:59:59:999
     * 例如：传入4月1日则返回6月30日23:59:59:999，传入8月1日则返回12月31日23:59:59:999
     *
     * @Date: 13:43 2017/7/27
     */
    public static Date getHalfYearDayEnd(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH) + 1;
        //如果1~6月
        if (month >= 1 && month <= 6) {
            c.set(c.get(Calendar.YEAR), 5, 30, 23, 59, 59);
            c.set(Calendar.MILLISECOND, 999);
        }
        //如果7~12月
        else if (month > 6 && month <= 12) {
            c.set(c.get(Calendar.YEAR), 11, 31, 23, 59, 59);
            c.set(Calendar.MILLISECOND, 999);
        }
        return c.getTime();
    }

}
