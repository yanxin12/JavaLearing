// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-01 00:39
 * IDE: IntelliJ IDEA
 * Introduction:
 * 栈的实现
 */
package com.DataStruct.Stack;

public class Stack {
    int top = -1;
    int[] data = null;

    public Stack() {
    }

    public Stack(int[] data) {
        this.data = data;
    }

    // 入栈操作
    public void push_back(int d) {
        ++top;
        if (top < data.length) {
            data[top] = d;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    // 出栈操作
    public int get_out() {
        if (top > -1) {
            --top;
            return data[top + 1];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    // 判断栈空
    public boolean isEmpty() {
        return top == -1;
    }


}
