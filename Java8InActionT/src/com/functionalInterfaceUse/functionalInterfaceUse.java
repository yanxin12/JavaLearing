// -*- coding: utf-8 -*- 
/**
 * Project: Java8InActionT
 * Creator: yanking
 * Create time: 2022-01-12 22:57
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.functionalInterfaceUse;

@FunctionalInterface
public interface functionalInterfaceUse {
    // 使用函数式接口实现Lambda表达式参数化行为
    public void shout();

    default void smile() {
        System.out.println("I am smile!");
    }

}
