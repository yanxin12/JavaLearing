// -*- coding: utf-8 -*- 
/**
 * Project: InnerClass
 * Creator: yanking
 * Create time: 2021-08-07 19:24
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package chapter10Homework.Homework05;

public class Boat implements Vehicles{
    String name = "小船";
    @Override
    public String work() {
       return name;
    }
}
