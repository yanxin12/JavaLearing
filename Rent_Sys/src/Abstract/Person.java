// -*- coding: utf-8 -*- 
/**
 * Project: Rent_Sys
 * Creator: yanking
 * Create time: 2021-08-05 10:16
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Abstract;

public abstract class Person {
    public String name;
    public int age;
    public  String job;
    static {
        System.out.println("Hello this is the abstract class A!");
    }
    public abstract void interest();
    public void smile(){
        
    }
}
