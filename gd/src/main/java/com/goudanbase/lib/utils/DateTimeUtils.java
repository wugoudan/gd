package com.goudanbase.lib.utils;

import android.os.StrictMode;
import android.util.Log;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;


public final class DateTimeUtils {

    /**
     * 获取现在时间
     *
     * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
     */
    public static Date getNowDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(0);
        Date currentTime_2 = formatter.parse(dateString, pos);
        return currentTime_2;
    }

    public static String getNowDateString() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(currentTime);
    }

    public static String getNowDateHMS() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(currentTime);
    }

    public static String getNowDateStringMMDD() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");
        return formatter.format(currentTime);
    }

    /**
     * 获取现在时间
     *
     * @return返回短时间格式 yyyy-MM-dd
     */
    public static Date getNowDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(0);
        Date currentTime_2 = formatter.parse(dateString, pos);
        return currentTime_2;
    }

    /**
     * 获取现在时间
     *
     * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 获取现在时间
     *
     * @return 返回短时间字符串格式yyyy-MM-dd
     */
    public static String getStringDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 获取现在年月1号
     *
     * @return 返回短时间字符串格式yyyy-MM-01
     */
    public static String getStringDateYM1() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-01");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 获取时间 小时:分;秒 HH:mm:ss
     *
     * @return
     */
    public static String getTimeShort() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date currentTime = new Date();
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss * * @param dateDate * @return
     */
    public static String dateToStrLong(Long dateDate) {
        String time = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(dateDate * 1000);
        return date;
    }

    /**
     * 将短时间格式时间转换为字符串 yyyy-MM-dd
     *
     * @param dateDate
     * @return
     */
    public static String dateToStr(Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(dateDate);
        return dateString;
    }

    public static String dateToStr1(Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月");
        String dateString = formatter.format(dateDate);
        return dateString;
    }

    public static String dateToStr2(Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
        String dateString = formatter.format(dateDate);
        return dateString;
    }

    public static String dateToStr3(String s) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(s, pos);
        String dateString = formatter.format(strtodate);
        return dateString;
    }

    public static String dateToStr4(String s) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(s, pos);
        String dateString = formatter.format(strtodate);
        return dateString;
    }

    public static String dateToStr5(String s) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(s, pos);
        String dateString = formatter.format(strtodate);
        return dateString;
    }

    /**
     * 将短时间格式字符串转换为时间 yyyy-MM-dd
     *
     * @param strDate
     * @return
     */
    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }


    /**
     * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
     *
     * @param strDate
     * @return
     */
    public static Date strToDateLong(String strDate) {
        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
     *
     * @param strDate
     * @return
     */
    public static Date strToDateLong1(String strDate) {
        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     * 时间戳转换成日期格式字符串
     *
     * @param seconds 精确到秒的字符串
     * @return
     */
    public static String timeStamp2Date(String seconds) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(Long.valueOf(seconds + "000")));
    }

    public static String timeStamp3Date(String seconds) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
        return sdf.format(new Date(Long.valueOf(seconds + "000")));
    }

    /**
     * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm
     *
     * @param strDate
     * @return
     */
    public static Date strToDateLongNs(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }


    /**
     * 得到现在时间
     *
     * @return
     */
    public static Date getNow() {
        Date currentTime = new Date();
        return currentTime;
    }

    /**
     * 提取一个月中的最后一天
     *
     * @param day
     * @return
     */
    public static Date getLastDate(long day) {
        Date date = new Date();
        long date_3_hm = date.getTime() - 3600000 * 34 * day;
        Date date_3_hm_date = new Date(date_3_hm);
        return date_3_hm_date;
    }

    /**
     * 日期格式字符串转换成时间戳
     *
     * @param
     * @return
     */
    public static String date2TimeStamp(String date_str) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return String.valueOf(sdf.parse(date_str).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 得到现在时间
     *
     * @return 字符串 yyyyMMdd HHmmss
     */
    public static String getStringToday() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 得到现在小时
     */
    public static String getHour() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        String hour;
        hour = dateString.substring(11, 13);
        return hour;
    }

    /**
     * 得到现在分钟
     *
     * @return
     */
    public static String getTime() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        String min;
        min = dateString.substring(14, 16);
        return min;
    }

    /**
     * 根据用户传入的时间表示格式，返回当前时间的格式 如果是yyyyMMdd，注意字母y不能大写。
     *
     * @param sformat yyyyMMddhhmmss
     * @return
     */
    public static String getUserDate(String sformat) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月");
        String dataStr = formatter.format(sformat);
        return dataStr;
    }


    /**
     * 根据用户传入的时间表示格式，返回当前时间的格式 如果是yyyyMMdd，注意字母y不能大写。
     *
     * @param sformat yyyyMMddhhmmss
     * @return
     */
    public static String getDate(String sformat) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }


    /**
     * 二个小时时间间的差值,必须保证二个时间都是"HH:MM"的格式，返回字符型的分钟
     */
    public static String getTwoHour(String st1, String st2) {
        String[] kk = null;
        String[] jj = null;
        kk = st1.split(":");
        jj = st2.split(":");
        if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0]))
            return "0";
        else {
            double y = Double.parseDouble(kk[0]) + Double.parseDouble(kk[1])
                    / 60;
            double u = Double.parseDouble(jj[0]) + Double.parseDouble(jj[1])
                    / 60;
            if ((y - u) > 0)
                return y - u + "";
            else
                return "0";
        }
    }

    /**
     * 得到二个日期间的间隔天数
     */
    public static String getTwoDay(String sj1, String sj2) {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        long day = 0;
        try {

            Date date = myFormatter.parse(sj1);
            Date mydate = myFormatter.parse(sj2);
            day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
        } catch (Exception e) {
            return "";
        }
        return day + "";
    }

    public static long timeDiffByMinute(String date1, String date2) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d1 = formatter.parse(date1);
            Date d2 = formatter.parse(date2);
            return (d1.getTime() - d2.getTime()) / (60 * 1000);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * 比较两个日期的大小
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int compareDate(String date1, String date2) {
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        try {
            Date d1 = formatter.parse(date1);
            Date d2 = formatter.parse(date2);
            Log.d("compareDate", "compareDate: " + d1.getTime());
            Log.d("compareDate", "compareDate: " + d2.getTime());
            if (d1.getTime() > d2.getTime()) {
                return 1;
            } else if (d1.getTime() < d2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * 得到二个日期间的间隔天数，小时，分钟 yyyy-MM-dd HH:mm
     */
    public static String getTwoDayNs(String sj1, String sj2) {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        long day = 0;
        try {
            Date date = myFormatter.parse(sj1);
            Date mydate = myFormatter.parse(sj2);
            day = (date.getTime() - mydate.getTime() / (24 * 60 * 60 * 1000));

        } catch (Exception e) {
            return "";
        }
        return day + "";
    }

    /**
     * 时间前推或后推分钟,其中JJ表示分钟.
     */
    public static String getPreTime(String sj1, String jj) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String mydate1 = "";
        try {
            Date date1 = format.parse(sj1);
            long Time = (date1.getTime() / 1000) + Integer.parseInt(jj) * 60;
            date1.setTime(Time * 1000);
            mydate1 = format.format(date1);
        } catch (Exception e) {
        }
        return mydate1;
    }

    /**
     * 获取一个时间的后一天的时间
     *
     * @param nowdate
     * @return
     */
    public static long getLongNextDay(long nowdate, long serviceTime) {
        long time = nowdate + 24 * 60 * 60 - serviceTime;
        return time * 1000;
    }

    /**
     * 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数
     */
    public static String getNextDay(String nowdate, String delay) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String mdate = "";
            Date d = strToDateLongNs(nowdate);
            long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24 * 60 * 60;
            d.setTime(myTime * 1000);
            mdate = format.format(d);
            System.out.println("sssssssssssssssss" + mdate);
            return mdate;
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 根据用户传入的日期得到  日期中的号数
     *
     * @param date
     * @return
     */
    public static String getUserDay(String date) {
        String day = null;
        int mday = 0;
        Calendar days = new GregorianCalendar();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date mDate = df.parse(date);
            days.setTime(mDate);
            mday = days.get(Calendar.DAY_OF_MONTH);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (mday < 10) {
            day = "0" + mday;
        } else {
            day = mday + "";
        }
        return day;
    }

    /**
     * 根据用户传入的日期得到YYYY-MM
     *
     * @param date
     * @return
     */
    public static String getUserYm(String date) {
        String mdate = null;
        int dY = 0;
        int dM = 0;
        Calendar days = new GregorianCalendar();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date mDate = df.parse(date);
            days.setTime(mDate);
            dY = days.get(Calendar.YEAR);
            dM = days.get(Calendar.MONTH) + 1;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        mdate = dY + "年" + dM + "月";
        return mdate;
    }

    /**
     * 根据用户传入的日期得到MM-DD
     *
     * @param date
     * @return
     */
    public static String getUserMd(String date) {
        String mdate = null;
        int dM = 0;
        int dd = 0;
        Calendar days = new GregorianCalendar();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date mDate = df.parse(date);
            days.setTime(mDate);
            dM = days.get(Calendar.MONTH) + 1;
            dd = days.get(Calendar.DAY_OF_MONTH);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (dM < 10 && dd < 10) {
            mdate = "0" + dM + "-" + "0" + dd;
        } else if (dM < 10) {
            mdate = "0" + dM + "-" + dd;
        } else if (dd < 10) {
            mdate = dM + "-" + "0" + dd;
        }

        return mdate;
    }

    /**
     * 获取时分秒
     *
     * @return
     */
    public static String getHMS(String dateStr) {

        Calendar days = new GregorianCalendar();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date mDate;
        try {
            mDate = formatter.parse(dateStr);
            days.setTime(mDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int hour = days.get(Calendar.HOUR);
        int minute = days.get(Calendar.MINUTE);
        int miao = days.get(Calendar.SECOND);
        return hour + "时" + minute + "分" + miao + "秒";

    }

    /**
     * 得到某个时间和现在时间相差年，月，日
     *
     * @param date 短时间只字符串
     * @return
     */
    public static String getYearMonthDay(String date) {
        String age = null;
        Calendar days = new GregorianCalendar();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date daystart = df.parse(date);
            days.setTime(daystart);

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Calendar mCalendar = Calendar.getInstance();
        int day = mCalendar.get(Calendar.DAY_OF_MONTH) - days.get(Calendar.DAY_OF_MONTH);
        int month = mCalendar.get(Calendar.MONTH) - days.get(Calendar.MONTH);
        int year = mCalendar.get(Calendar.YEAR) - days.get(Calendar.YEAR);
        // 按照减法原理，先day相减，不够向month借；然后month相减，不够向year借；最后year相减。
        if (day < 0) {
            month -= 1;
            mCalendar.add(Calendar.MONTH, -1);// 得到上一个月，用来得到上个月的天数。
            day = day + mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        }
        if (month < 0) {
            month = (month + 12) % 12;
            year--;
        }
        // 三种可能性， 分别 几岁几个月几天，几个月几天，几天
        if (year == 0 && month == 0) {
            age = day + "天";
        } else if (year == 0 && month != 0) {
            age = month + "个月" + day + "天";
        } else if (year != 0 && month != 0) {
            age = year + "岁" + month + "个月" + day + "天";
        }
        return age;
    }

    /**
     * 判断是否润年
     *
     * @param ddate
     * @return
     */
    public static boolean isLeapYear(String ddate) {

        /**
         * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
         * 3.能被4整除同时能被100整除则不是闰年
         */
        Date d = strToDate(ddate);
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(d);
        int year = gc.get(Calendar.YEAR);
        if ((year % 400) == 0)
            return true;
        else if ((year % 4) == 0) {
            if ((year % 100) == 0)
                return false;
            else
                return true;
        } else
            return false;
    }

    /**
     * 返回美国时间格式 26 Apr 2006
     *
     * @param str
     * @return
     */
    public static String getEDate(String str) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(str, pos);
        String j = strtodate.toString();
        String[] k = j.split(" ");
        return k[2] + k[1].toUpperCase() + k[5].substring(2, 4);
    }

    /**
     * 获取一个月的最后一天
     *
     * @param dat
     * @return
     */
    public static String getEndDateOfMonth(String dat) {// yyyy-MM-dd
        String str = dat.substring(0, 8);
        String month = dat.substring(5, 7);
        int mon = Integer.parseInt(month);
        if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8
                || mon == 10 || mon == 12) {
            str += "31";
        } else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
            str += "30";
        } else {
            if (isLeapYear(dat)) {
                str += "29";
            } else {
                str += "28";
            }
        }
        return str;
    }

    /**
     * 判断二个时间是否在同一个周
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameWeekDates(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
        if (0 == subYear) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
                    .get(Calendar.WEEK_OF_YEAR))
                return true;
        } else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {
            // 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
                    .get(Calendar.WEEK_OF_YEAR))
                return true;
        } else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
                    .get(Calendar.WEEK_OF_YEAR))
                return true;
        }
        return false;
    }

    /**
     * 产生周序列,即得到当前时间所在的年度是第几周
     *
     * @return
     */
    public static String getSeqWeek() {
        Calendar c = Calendar.getInstance(Locale.CHINA);
        String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
        if (week.length() == 1)
            week = "0" + week;
        String year = Integer.toString(c.get(Calendar.YEAR));
        return year + week;
    }

    /**
     * 获得一个日期所在的周的星期几的日期，如要找出2002年2月3日所在周的星期一是几号
     *
     * @param sdate
     * @param num
     * @return
     */
    public static String getWeek(String sdate, String num) {
        // 再转换为时间
        Date dd = DateTimeUtils.strToDate(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(dd);
        if (num.equals("1")) // 返回星期一所在的日期
            c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        else if (num.equals("2")) // 返回星期二所在的日期
            c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        else if (num.equals("3")) // 返回星期三所在的日期
            c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        else if (num.equals("4")) // 返回星期四所在的日期
            c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
        else if (num.equals("5")) // 返回星期五所在的日期
            c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        else if (num.equals("6")) // 返回星期六所在的日期
            c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        else if (num.equals("0")) // 返回星期日所在的日期
            c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
    }

    /**
     * 根据一个日期，返回是星期几的字符串
     *
     * @param sdate
     * @return
     */
    public static String getWeek(String sdate) {
        // 再转换为时间
        Date date = DateTimeUtils.strToDate(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        // int hour=c.get(Calendar.DAY_OF_WEEK);
        // hour中存的就是星期几了，其范围 1~7
        // 1=星期日 7=星期六，其他类推
        return new SimpleDateFormat("EEEE").format(c.getTime());
    }

    public static String getWeekStr(String sdate) {
        String str = "";
        str = DateTimeUtils.getWeek(sdate);
        if ("1".equals(str)) {
            str = "Sunday";
        } else if ("2".equals(str)) {
            str = "Monday";
        } else if ("3".equals(str)) {
            str = "Tuesday";
        } else if ("4".equals(str)) {
            str = "Wednesday";
        } else if ("5".equals(str)) {
            str = "Thursday";
        } else if ("6".equals(str)) {
            str = "Friday";
        } else if ("7".equals(str)) {
            str = "Saturday";
        }
        return str;
    }

    /**
     * 两个时间之间的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long getDays(String date1, String date2) {
        if (date1 == null || date1.equals(""))
            return 0;
        if (date2 == null || date2.equals(""))
            return 0;
        // 转换为标准时间
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Date mydate = null;
        try {
            date = myFormatter.parse(date1);
            mydate = myFormatter.parse(date2);
        } catch (Exception e) {
        }
        long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
        return day;
    }

    /**
     * 形成如下的日历 ， 根据传入的一个时间返回一个结构 星期日 星期一 星期二 星期三 星期四 星期五 星期六 下面是当月的各个时间
     * 此函数返回该日历第一行星期日所在的日期
     *
     * @param sdate
     * @return
     */
    public static String getNowMonth(String sdate) {
        // 取该时间所在月的一号
        sdate = sdate.substring(0, 8) + "01";

        // 得到这个月的1号是星期几
        Date date = DateTimeUtils.strToDate(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int u = c.get(Calendar.DAY_OF_WEEK);
        String newday = DateTimeUtils.getNextDay(sdate, (1 - u) + "");
        return newday;
    }

    /**
     * 取得数据库主键 生成格式为yyyymmddhhmmss+k位随机数
     *
     * @param k 表示是取几位随机数，可以自己定
     */

    public static String getNo(int k) {

        return getUserDate("yyyyMMddhhmmss") + getRandom(k);
    }

    /**
     * 返回一个随机数
     *
     * @param i
     * @return
     */
    public static String getRandom(int i) {
        Random jjj = new Random();
        // int suiJiShu = jjj.nextInt(9);
        if (i == 0)
            return "";
        String jj = "";
        for (int k = 0; k < i; k++) {
            jj = jj + jjj.nextInt(9);
        }
        return jj;
    }

    /***************************************************************************
     * //nd=1表示返回的值中包含年度 //yf=1表示返回的值中包含月份 //rq=1表示返回的值中包含日期 //format表示返回的格式 1
     * 以年月日中文返回 2 以横线-返回 // 3 以斜线/返回 4 以缩写不带其它符号形式返回 // 5 以点号.返回
     **************************************************************************/

	/*
     * public static String getStringDateMonth(String sdate, String nd, String
	 * yf, String rq, String format) { Date currentTime = new Date();
	 * SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); String
	 * dateString = formatter.format(currentTime); String s_nd =
	 * dateString.substring(0, 4); // 年份 String s_yf = dateString.substring(5,
	 * 7); // 月份 String s_rq = dateString.substring(8, 10); // 日期 String sreturn
	 * = ""; roc.util.MyChar mc = new roc.util.MyChar(); if (sdate == null ||
	 * sdate.equals("") || !mc.Isdate(sdate)) { // 处理空值情况 if (nd.equals("1")) {
	 * sreturn = s_nd; // 处理间隔符 if (format.equals("1")) sreturn = sreturn + "年";
	 * else if (format.equals("2")) sreturn = sreturn + "-"; else if
	 * (format.equals("3")) sreturn = sreturn + "/"; else if
	 * (format.equals("5")) sreturn = sreturn + "."; } // 处理月份 if
	 * (yf.equals("1")) { sreturn = sreturn + s_yf; if (format.equals("1"))
	 * sreturn = sreturn + "月"; else if (format.equals("2")) sreturn = sreturn +
	 * "-"; else if (format.equals("3")) sreturn = sreturn + "/"; else if
	 * (format.equals("5")) sreturn = sreturn + "."; } // 处理日期 if
	 * (rq.equals("1")) { sreturn = sreturn + s_rq; if (format.equals("1"))
	 * sreturn = sreturn + "日"; } } else { // 不是空值，也是一个合法的日期值，则先将其转换为标准的时间格式
	 * sdate = roc.util.RocDate.getOKDate(sdate); s_nd = sdate.substring(0, 4);
	 * // 年份 s_yf = sdate.substring(5, 7); // 月份 s_rq = sdate.substring(8, 10);
	 * // 日期 if (nd.equals("1")) { sreturn = s_nd; // 处理间隔符 if
	 * (format.equals("1")) sreturn = sreturn + "年"; else if
	 * (format.equals("2")) sreturn = sreturn + "-"; else if
	 * (format.equals("3")) sreturn = sreturn + "/"; else if
	 * (format.equals("5")) sreturn = sreturn + "."; } // 处理月份 if
	 * (yf.equals("1")) { sreturn = sreturn + s_yf; if (format.equals("1"))
	 * sreturn = sreturn + "月"; else if (format.equals("2")) sreturn = sreturn +
	 * "-"; else if (format.equals("3")) sreturn = sreturn + "/"; else if
	 * (format.equals("5")) sreturn = sreturn + "."; } // 处理日期 if
	 * (rq.equals("1")) { sreturn = sreturn + s_rq; if (format.equals("1"))
	 * sreturn = sreturn + "日"; } } return sreturn; }
	 */

    /**
     * @return 该毫秒数转换为 * days * hours * minutes * seconds 后的格式
     * @author fy.zhang
     */
    public static String formatDuring(long mss) {
        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;
        return days + " 天 " + hours + " 小时 " + minutes + " 分钟 " + seconds
                + " 秒 ";
    }


    /**
     * 毫秒转化为秒
     *
     * @param mss
     * @return
     */
    public static String formatMillisecondsToSeconds(long mss) {
        Date date = new Date(mss);
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        String seconds = sdf.format(date);
        return seconds;
    }

    /**
     * @param begin 时间段的开始
     * @param end   时间段的结束
     * @return 输入的两个Date类型数据之间的时间间格用* days * hours * minutes * seconds的格式展示
     * @author fy.zhang
     */
    public static String formatDuring(Date begin, Date end) {
        return formatDuring(end.getTime() - begin.getTime());
    }

    /**
     * 得到2个日期之间的年份月份和天数
     * <p>
     * 短时间只字符串
     *
     * @return
     */
    public static Double getMonthDay(String date1, String date2) {
        Double age = null;
        Calendar days = new GregorianCalendar();
        Calendar days1 = new GregorianCalendar();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date day1 = df.parse(date1);
            Date day2 = df.parse(date2);
            days.setTime(day1);
            days1.setTime(day2);

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int day = days.get(Calendar.DAY_OF_MONTH) - days1.get(Calendar.DAY_OF_MONTH);

        int month = days.get(Calendar.MONTH) - days1.get(Calendar.MONTH);
        int year = days.get(Calendar.YEAR) - days1.get(Calendar.YEAR);
        // 按照减法原理，先day相减，不够向month借；然后month相减，不够向year借；最后year相减。
        if (day < 0) {
            month -= 1;
            days1.add(Calendar.MONTH, -1);// 得到上一个月，用来得到上个月的天数。
            day = day + days1.getActualMaximum(Calendar.DAY_OF_MONTH);
        }
        if (month < 0) {
            month = (month + 12) % 12;
            year--;
        }
        // 三种可能性， 分别 几岁几个月几天，几个月几天，几天
        if (year == 0 && month == 0) {
            age = Double.valueOf(day);
        } else if (year == 0 && month != 0) {
            age = Double.valueOf(month + "." + day);
        }
        return age;
    }

    /**
     * 计算2个时间之间多少个月几天
     *
     * @param startDateStr
     * @param endDateStr
     * @return
     */

    public static String remainDateToString(String startDateStr, String endDateStr) {
        Calendar calS = Calendar.getInstance();
        Pattern p = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");//定义整则表达式
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateStr);
            endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateStr);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        calS.setTime(startDate);
        int startY = calS.get(Calendar.YEAR);
        int startM = calS.get(Calendar.MONTH);
        int startD = calS.get(Calendar.DATE);
        int startDayOfMonth = calS.getActualMaximum(Calendar.DAY_OF_MONTH);

        calS.setTime(endDate);
        int endY = calS.get(Calendar.YEAR);
        int endM = calS.get(Calendar.MONTH);
        int endD = calS.get(Calendar.DATE) + 1;
        int endDayOfMonth = calS.getActualMaximum(Calendar.DAY_OF_MONTH);

        StringBuilder sBuilder = new StringBuilder();
        if (endDate.compareTo(startDate) < 0) {
            return sBuilder.append("过期").toString();
        }
        int lday = endD - startD;
        if (lday < 0) {
            endM = endM - 1;
            lday = startDayOfMonth + lday;
        }

        if (lday == endDayOfMonth) {
            endM = endM + 1;
            lday = 0;
        }
        int mos = (endY - startY) * 12 + (endM - startM);
        int lyear = mos / 12;
        int lmonth = mos % 12;
        if (lyear > 0) {
            //sBuilder.append(lyear+".");
            lyear = lyear * 12;

        }
        if (lmonth > 0) {
            // sBuilder.append(lmonth+".");
            lyear = lyear + lmonth;

        }

        if (lyear == 0) {
            if (lday > 0) {
                sBuilder.append(lday - 1 + ".");
            }
        } else {
            if (lday > 0) {
                sBuilder.append(lday + "");
            }
        }
        return String.valueOf(lyear);

    }

    private static Calendar calS = Calendar.getInstance();
    private static Pattern p = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");//定义整则表达式

    /**
     * 计算剩余时间
     *
     * @param startDateStr
     * @param endDateStr
     * @return
     */
    public static String remainDateToString1(String startDateStr, String endDateStr) {
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateStr);
            endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateStr);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        calS.setTime(startDate);
        int startY = calS.get(Calendar.YEAR);
        int startM = calS.get(Calendar.MONTH);
        int startD = calS.get(Calendar.DATE);
        int startDayOfMonth = calS.getActualMaximum(Calendar.DAY_OF_MONTH);

        calS.setTime(endDate);
        int endY = calS.get(Calendar.YEAR);
        int endM = calS.get(Calendar.MONTH);
        //处理2011-01-10到2011-01-10，认为服务为一天
        int endD = calS.get(Calendar.DATE) + 1;
        int endDayOfMonth = calS.getActualMaximum(Calendar.DAY_OF_MONTH);

        StringBuilder sBuilder = new StringBuilder();
        if (endDate.compareTo(startDate) < 0) {
            return sBuilder.append("过期").toString();
        }
        int lday = endD - startD;
        if (lday < 0) {
            endM = endM - 1;
            lday = startDayOfMonth + lday;
        }
        //处理天数问题，如：2011-01-01 到 2013-12-31  2年11个月31天     实际上就是3年
        if (lday == endDayOfMonth) {
            endM = endM + 1;
            lday = 0;
        }
        int mos = (endY - startY) * 12 + (endM - startM);
        int lyear = mos / 12;
        int lmonth = mos % 12;
        if (lyear > 0) {
            sBuilder.append(lyear + "岁");
        }
        if (lmonth > 0) {
            sBuilder.append(lmonth + "个月");
        }

        //假如是小于一岁的时候，
        if (lyear == 0) {
            //sBuilder.append(lday+"天");
            if (lday > 0) {
                sBuilder.append(lday - 1 + "天");
            }
        } else {
            if (lday > 0) {
                sBuilder.append(lday + "天");
            }
        }
        return sBuilder.toString();
    }

    /**
     * 将长时间格式时间转换为字符串 yyyy-MM-dd * * @param dateDate * @return
     */
    public static String dateToStrLong_short(Long dateDate) {
        String time = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dateDate * 1000);
        return date;
    }

    // 字符串类型日期转化成date类型
    public static Date strToDate(String style, String date) {
        SimpleDateFormat formatter = new SimpleDateFormat(style);
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    public static String dateToStr(String style, Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(style);
        return formatter.format(date);
    }

    public static String clanderTodatetime(Calendar calendar, String style) {
        SimpleDateFormat formatter = new SimpleDateFormat(style);
        return formatter.format(calendar.getTime());
    }

    public static String getMyBirthday(int year, int month, int day) {
        String str = null;
        if (month < 10 && day < 10) {
            str = year + "-" + "0" + month + "-" + "0" + day;
        } else if (month < 10) {
            str = year + "-" + "0" + month + "-" + "" + day;
        } else if (day < 10) {
            str = year + "-" + "" + month + "-" + "0" + day;
        } else if (month >= 10 && day >= 10) {
            str = year + "-" + "" + month + "-" + "" + day;
        }
        return str;
    }


    /**
     * 根据身日 计算出年龄
     * 当前时间根据网络时间
     *
     * @param birthday
     * @return
     */
    public static int getAgeByBirth(String birthday) {
        int age = 0;
        try {
            Calendar now = Calendar.getInstance();
//            now.setTime(getNetworkTime());// 当前时间
            now.setTime(getNowDate());

            Calendar birth = Calendar.getInstance();
            birth.setTime(strToDate(birthday));

            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                /*if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }*/
            }
            return age;
        } catch (Exception e) {//兼容性更强,异常后返回数据
            return 0;
        }
    }

    /**
     * 获取网络时间
     *
     * @return
     */
    public static Date getNetworkTime() {
        try {
            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            URL url = new URL("http://www.ntsc.ac.cn");// 中国科学院国家授时中心
            URLConnection conn = url.openConnection();
            conn.connect();
            long dateL = conn.getDate();
            Date date = new Date(dateL);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            String dateString = dateFormat.format(date);
            ParsePosition pos = new ParsePosition(0);
            Date currentTime_2 = dateFormat.parse(dateString, pos);

            return currentTime_2;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}
