// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-01 01:01
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.DataStruct.Queue;

public class main_ {
    public static void main(String[] args) {
        int[] que = new int[40];
        // 留一个空间判断队满、对空，时间存储空间为que.length-1
        Queue queue = new Queue(que);
        for (int i = 0; i < 30; i++) {
            queue.input_queue(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.out_queue());
        }
        for (int i = 30; i < 50; i++) {
            queue.input_queue(i);
        }
        System.out.println("");
    }
}
