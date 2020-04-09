package com.dt.utils.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtils
 * @Date 2019/6/17 11:10
 * @Version 1.0
 **/
public class DateUtils {

    /**
     * @description 将Date格式的日期按照 format格式进行转换
     * @param date
     * @param format
     * @return
     */
    public static String date2String(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static String getYyyyMmDdHhMmSs(Date date) {
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date);
    }

    /**
     *
     * @param date 时间
     * @param ms 超时时间 毫秒
     * @return
     */
    public static Boolean checkOvertime(Date date,Long ms){
        Long nowTimeStamp = System.currentTimeMillis();
        Long chenkTimeStamp = date.getTime();
        if (nowTimeStamp-chenkTimeStamp > ms){
            //超时
            return Boolean.FALSE;
        }
        else {
            //未超时
            return Boolean.TRUE;
        }
    }
}
