// -*- coding: utf-8 -*- 
/**
 * Project: Chapter14
 * Creator: yanking
 * Create time: 2021-10-27 00:13
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package src.Homework.homework01;
@SuppressWarnings({"all"})
public class String_train {
    public static void main(String[] args) {
        String title = "新冠确诊病例超千万，数百万印度教信徒赴恒河\"圣浴\"引民众担忧";
//        System.out.println(title.length());
//        String t_point  = "...";
//        System.out.println(t_point.length());
        String title02 = title.substring(0,15)+"...";
        System.out.println(title02);
    }
}
