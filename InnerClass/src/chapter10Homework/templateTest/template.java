// -*- coding: utf-8 -*- 
/**
 * Project: InnerClass
 * Creator: yanking
 * Create time: 2021-08-11 14:42
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package chapter10Homework.templateTest;

public class template {

    public void m(Job obj){
        long start = System.currentTimeMillis();
        System.out.println("The beginning time is  " + start );
        obj.job();
        long end = System.currentTimeMillis();
        System.out.println("The endding time is " + end);
        System.out.println("The job totally spend " + (end - start));
    }








}
