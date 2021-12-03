// -*- coding: utf-8 -*- 
/**
 * Project: InnerClass
 * Creator: yanking
 * Create time: 2021-08-07 19:25
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package chapter10Homework.Homework05;

public class transportCompany {
    public Vehicles getHorse(){
        return new Horse();
    }
    public Vehicles getBoat(){
        return new Boat();
    }
}
