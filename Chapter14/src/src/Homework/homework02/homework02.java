// -*- coding: utf-8 -*- 
/**
 * Project: Chapter14
 * Creator: yanking
 * Create time: 2021-10-27 00:37
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package src.Homework.homework02;

import java.util.ArrayList;

public class homework02 {
    public static void main(String[] args) {
        Car car = new Car("宝马", 400000);
        Car car1 = new Car("宾利", 5000000);
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(car);
        cars.add(car1);
//        cars.remove(1);
//        for (int i = cars.size()-1; i >=0 ; i--) {
//            System.out.println(cars.get(i));
//        }
        System.out.println(cars.contains(car));
        System.out.println(cars.contains(car1));
        System.out.println(cars.size());
//        cars.remove(car);
        System.out.println(cars.isEmpty());
        cars.addAll(cars);
//        for (int i = cars.size()-1; i >=0 ; i--) {
//            System.out.println(cars.get(i));
//        }
        cars.removeAll(cars);
        System.out.println(cars.isEmpty());
    }
}
