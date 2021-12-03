// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-01 01:29
 * IDE: IntelliJ IDEA
 * Introduction:
 * 共享栈的实现
 */
package com.DataStruct.Stack;

public class commomStack {
    protected int top_head = -1;
    protected int[] data = null;
    protected int top_tail;

    public commomStack() {
    }

    public commomStack(int[] data, int top_tail) {
        this.data = data;
        this.top_tail = top_tail;
    }

    // 入栈操作
    public void push_back_head(int d) {
        ++top_head;
        if (top_head < top_tail) {
            data[top_head] = d;
        } else {
            System.out.println("栈满");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void push_back_tail(int d) {
        --top_tail;
        if (top_head < top_tail) {
            data[top_tail] = d;
        } else {
            System.out.println("栈满");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    // 出栈操作
    public int get_out_head() {
        if (top_head > -1) {
            --top_head;
            return data[top_head + 1];
        } else {
            System.out.println("栈空");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int get_out_tail() {
        if (top_tail < data.length) {
            ++top_tail;
            return data[top_tail - 1];
        } else {
            System.out.println("栈空");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    // 判断栈空
    public boolean isHeadStackEmpty() {
        return top_head == -1;
    }

    public boolean isTailStackEmpty() {
        return top_tail == data.length;
    }

}
