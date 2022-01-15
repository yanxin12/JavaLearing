// -*- coding: utf-8 -*- 
/**
 * Project: Java8InActionT
 * Creator: yanking
 * Create time: 2022-01-12 23:35
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.FunctionInterfaceTrain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class runFuncInterface {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "orange", "grape");
        fruits.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s.length());
            }
        });
//        List<Integer> res = FunctionInterfaceTrain.map(fruits, String::length);
//        for (int i : res) {
//            System.out.println(i);
//        }
    }
}
