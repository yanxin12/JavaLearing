// -*- coding: utf-8 -*- 
/**
 * Project: InnerClass
 * Creator: yanking
 * Create time: 2021-08-07 19:26
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package chapter10Homework.Homework05;

import java.util.Scanner;

public class Person {
    public String name;
    public Vehicles vehicles;

    public Person(String name) {
        this.name = name;
    }
    public void selectVehicles(){
        System.out.println("现在是什么情况？ 1. 一般情况  2. 遇到大河");
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        if (c == 1){
            this.vehicles = new transportCompany().getHorse();
        }else if(c == 2){
            this.vehicles = new transportCompany().getBoat();
        }else{
            System.out.println("输入错误！");
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", vehicles=" + vehicles.work() +
                '}';
    }
}
