package com.happyghost.utils;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;
import org.apache.commons.lang3.time.DateUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class CommonDateUtils  {

    @Test
    public void subDate() {
        int halfTime = Integer.parseInt(CommonDateUtils.formatDate(CommonDateUtils.longToDate(new Date().getTime()), "mm"));
        System.out.println(halfTime);

    }

    @Test
    public void subDat1() {
        LocalDate date = LocalDate.of(2019, 06, 20);
        LocalDateTime dateTime = LocalDateTime.of(2019, 06, 14, 16, 30, 11);

        Date dateObj = new Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(dateObj.toInstant(), ZoneId.systemDefault());
        System.out.println(localDateTime);
        java.time.Duration duration = java.time.Duration.between(dateTime,  LocalDateTime.now() );
        System.out.println(duration.toMinutes());
        System.out.println(duration.toHours());
        System.out.println(date);
    }


    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * @param lo 毫秒数
     * @return String yyyy-MM-dd HH:mm:ss
     * @Description: long类型转换成日期
     */
    public static Date longToDate(long lo) {
        return new Date(lo);
    }
}
