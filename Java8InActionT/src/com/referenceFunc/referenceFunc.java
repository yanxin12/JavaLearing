// -*- coding: utf-8 -*- 
/**
 * Project: Java8InActionT
 * Creator: yanking
 * Create time: 2022-01-11 10:45
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.referenceFunc;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class referenceFunc {
    public static void main(String[] args) {
        List<Integer> weights = Arrays.asList(2, 3, 4, 5, 6, 7, 8);
        List<Apple> res = Apple.map(weights, Apple::new);
        for (Apple apple : res) {
            System.out.println(apple);
        }





/*        Apple apple1 = new Apple("紅蘋果", "Red", 15);
        Apple apple2 = new Apple("绿蘋果", "Green", 10);
        Apple apple3 = new Apple("蓝蘋果", "Blue", 8);
        Apple apple4 = new Apple("黄蘋果", "Yellow", 9);
        List<Apple> inventory = Arrays.asList(apple1, apple2, apple3, apple4);*/
        // List<Apple> res = Apple.filterApple(inventory, Apple::isBigApple);
        // List<Apple> res = Apple.filterApple(inventory, Apple::isBigAndGreen);
        // List<Apple> res = Apple.filterApple(inventory, Apple::isBigAndGreen);
        // 需要大苹果和绿苹果，使用Predicate接口中的and方法实现
        //List<Apple> res = Apple.filterAppleT(inventory, Apple::isBigApple, Apple::isGreenApple);
        //List<Apple> res = Apple.filterApple(inventory, (Apple a) -> "Green".equals(a.getColor()));
        //List<Apple> res = inventory.stream().filter(Apple::isGreenApple).collect(toList());
        // List<Apple> res = inventory.parallelStream().filter(Apple::isGreenApple).collect(toList());

//        for (Apple apple : res) {
//            System.out.println(apple);
//        }
    /*    Apple.printPrettyApple(res, new Apple.appleFormatter() {
            @Override
            public String accept(Apple a) {
                return "The Apple is" + a.getWeight() + "g.";
            }
        });*/

       /* Apple.printPrettyAppleT(res, new Consumer<Apple>() {
            @Override
            public void accept(Apple apple) {
                System.out.println("Apple is " + apple.getColor());
            }
        });*/

    }
}
