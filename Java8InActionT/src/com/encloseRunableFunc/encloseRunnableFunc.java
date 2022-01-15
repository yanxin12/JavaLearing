// -*- coding: utf-8 -*- 
/**
 * Project: Java8InActionT
 * Creator: yanking
 * Create time: 2022-01-11 20:50
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.encloseRunableFunc;

public class encloseRunnableFunc {
    // Run方法对类中参数输出的影响
    public final int value = 3;

    public class shout implements Runnable {
        private final int value = 4;

        @Override
        public  void run() {
            int value = 5;
            System.out.println(this.value);
        }
    }

    public static class shoutT {
        static Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello!");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

    }

}
