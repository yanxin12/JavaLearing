// -*- coding: utf-8 -*- 
/**
 * Project: Java8InActionT
 * Creator: yanking
 * Create time: 2022-01-11 20:56
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.encloseRunableFunc;

public class encloseRunnableFuncT {
    // 可执行封闭类参数输出
    public final int value = 3;

    public void shout() {
        System.out.println(this.value);
    }

    public static class shout {
        private final int value = 4;

        public void shout() {
            System.out.println(this.value);
            System.out.println(value);
        }
    }
}
