// -*- coding: utf-8 -*- 
/**
 * Project: InnerClass
 * Creator: yanking
 * Create time: 2021-08-07 18:38
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package chapter10Homework.Homework01;

public class Frock {
    private static int currentNum = 100000;
    private static int serialNumber;

    public static int getNextNum(){
        serialNumber = currentNum+= 100;
        return serialNumber;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

}
