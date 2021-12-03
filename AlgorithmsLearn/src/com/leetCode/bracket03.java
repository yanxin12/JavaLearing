// -*- coding: utf-8 -*- 
/**
 * Project: SortTrain
 * Creator: yanking
 * Create time: 2021-11-25 10:47
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode;

import java.util.Stack;

public class bracket03 {
    public static void main(String[] args) {
//        String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
        String s = "(*))";
        if (solution(s)) {
            System.out.println("配对成功！");
        } else {
            System.out.println("配对失败！");
        }
    }

    public static boolean solution(String s) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        //使用两个栈保存（和*
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            //入栈操作
            if (c == '(') stack1.push(i);
            else if (c == '*') stack2.push(i);
                // 出栈：优先出stack1
            else {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                } else if (!stack2.isEmpty()) {
                    stack2.pop();
                } else {
                    return false;
                }
            }
        }

        // 当右括号栈存在元素时，对左括号栈逐一出栈，
        // 然后去看此时星号栈的栈顶，如果栈顶元素的位置大于左括号栈顶元素的位置，
        // 说明星号在括号的右侧，可以匹配。否则不可。
        while (!stack1.isEmpty()) {
            if (stack2.isEmpty()) return false;
            int posStack1 = stack1.pop();
            int posStack2 = stack2.pop();
            if (posStack1 > posStack2) {
                System.out.println("here");
                return false;
            }
        }

        return true;


    }
}

