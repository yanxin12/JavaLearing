// -*- coding: utf-8 -*- 
/**
 * Project: Chapter17
 * Creator: yanking
 * Create time: 2021-10-29 10:50
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.core_num;

public class core_num {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int core_num = runtime.availableProcessors();
        System.out.println(core_num);
    }
}
