// -*- coding: utf-8 -*- 
/**
 * Project: Chapter_13
 * Creator: yanking
 * Create time: 2021-08-12 11:10
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.Uclass;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Date_ {


    public static void main(String[] args) {
//        Date d1 = new Date();
//        System.out.println(d1);
//        System.out.println(d1.getHours());
//        Date d2 = new Date(0);
//        System.out.println(d2);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
////        System.out.println(sdf.format(d1));
////        System.out.println(sdf.format(d2));
//        Calendar calendar = Calendar.getInstance();
////        System.out.println(calendar);
////        BigInteger bigInteger = new BigInteger("1628738851374");
//        System.out.println(calendar.getWeekYear());
//        System.out.println(+calendar.getWeeksInWeekYear());
//        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
//        System.out.println(calendar.get(Calendar.MONTH)+1);

        Instant now = Instant.now();
        System.out.println(now);

    }
}
