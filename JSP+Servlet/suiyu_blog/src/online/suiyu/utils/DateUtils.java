package online.suiyu.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    /**
     * 将字符串转换成util日期
     *
     * @param dateString
     * @return
     * @throws ParseException
     */
    public static Date getDate(String dateString) throws ParseException {
        SimpleDateFormat srcSdf = new SimpleDateFormat("yyyy-MM-dd");
        return srcSdf.parse(dateString);
    }

    /**
     * util的date转换成sql的date
     *
     * @param date
     * @return
     */
    public static java.sql.Date getDate(Date date) {
        return new java.sql.Date(date.getTime());
    }

    /**
     * sql的date转换成的util的date
     *
     * @param date
     * @return
     */
    public static Date getDate(java.sql.Date date) {
        return new Date(date.getTime());
    }

    /**
     * 获取当前时间为2000-9-9格式以备保存到数据库中
     *
     * @return
     */
    public static String getNowAsDate() {
        String format = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(new Date());
    }

    public static String getNowAsTime() {
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(new Date());
    }
}