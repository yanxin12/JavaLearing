// -*- coding: utf-8 -*- 
/**
 * Project: Java8InActionT
 * Creator: yanking
 * Create time: 2022-01-12 13:57
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.genThread;

import java.util.concurrent.Callable;

public class ThreadUtils implements Callable<String>, Runnable {
    // 1 使用Callable接口创建线程
    @Override
    public String call() throws Exception {
        return "I am Callable Thread!";
    }

    @Override
    public void run() {
        System.out.println("I am Runnable Thread!");
    }

    public static class innerClass extends Thread {
        @Override
        public void run() {
            System.out.println("I am Thread Class ！");
        }
    }

}
