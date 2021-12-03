// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-01 00:51
 * IDE: IntelliJ IDEA
 * Introduction:
 * 队列对象的实现
 * 先进先出
 */
package com.DataStruct.Queue;

public class Queue {
    int p = 1;
    int r = 0;
    int[] queue = null;

    // 队满：p=r
    // 队空: p+1 = r
    public Queue() {

    }

    public Queue(int[] queue) {
        this.queue = queue;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    // 进队
    public void input_queue(int data) {
        if ((p) % queue.length != r) {
            queue[(p++) % queue.length] = data;
        } else {
            System.out.println("队满！");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    // 出队
    public int out_queue() {
        if (!isEmpty()) {
            return queue[++r];
        } else {
            System.out.println("队空！");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    // 查看队的大小
    public int sizeQueue() {
        return queue.length;
    }

    public int lengthQueue() {
        return p - r - 1;
    }

    // 判断是否队空
    public boolean isEmpty() {
        return (p - r) == 1;
    }

}
