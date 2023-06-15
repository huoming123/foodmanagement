package com.design.foodmanagement.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
    /**
     * 根据格式转换毫秒数
     * @param format
     * @param date
     * @return
     * @throws ParseException
     */
    public static long getMillisecond(String format,String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);//24小时制
        return simpleDateFormat.parse(date).getTime();
    }

    /**
     * 根据时间格式转Timestamp
     * @param format
     * @param date
     * @return
     * @throws ParseException
     */
    public static Timestamp getTimestamp(String format,String date) throws ParseException {
        return new Timestamp(getMillisecond(format,date));
    }

    /**
     * 获取当前时间的timestamp
     * @return
     */
    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(new Date().getTime());
    }

    /**
     * 获取指定时间戳 与 指定时间戳多少分钟后的相差数
     * @return
     */
    public static long getDefineTimestamp(Timestamp time, int afterMinute) {
        // 获取到当前时间
        long currentTime = new Date().getTime();

        // 起始时间
//        long startTime = new Date(time.getTime()).getTime();

        // 过期的时间
        Date d1 = new Date(time.getTime());
        Calendar cal = Calendar.getInstance();
        cal.setTime(d1);
        cal.add(Calendar.MINUTE, afterMinute);
        long expeirdTime = cal.getTime().getTime();

        // 过期时间与现在时间之差
        long interval = expeirdTime - currentTime;
        long i = interval / 1000;
        //对 i 做个判断 i<0 则不进行倒计时
        if(i<0){
            return 0;
        }else{
            return i;
        }
    }




    /**
     * 获取多少分钟后的时间点
     * @param expireNumber 多少分钟
     * @return
     */
    public static String getDateTime(Integer expireNumber) {
        Integer defalut = 30; // 默认30分钟
        if(expireNumber != null) {
            defalut = expireNumber;
        }
        // 创建SimpleDateFormat类型对象、 "yyyy-MM-dd HH:mm:ss"是正则式，分别表示年月日时分秒
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

        // 将两个String类型的时间转换为Date类型，从而计算差值、parse()方法的作用是将String类型的时间解析为Date类型
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, defalut);

        Date afterDate = cal.getTime();
        return df.format(afterDate);
    }



}
