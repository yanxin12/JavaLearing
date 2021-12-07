// -*- coding: utf-8 -*- 
/**
 * Project: SortTrain
 * Creator: yanking
 * Create time: 2021-11-25 11:03
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.brackets;

import java.util.Stack;

// 记录每一个符号的位置
public class bracket04 {
    public static void main(String[] args) {
//        String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
        String s = "(*))";
        if (matchBracket(s)) {
            System.out.println("配对成功！");
        } else {
            System.out.println("配对失败！");
        }
    }

    public static boolean matchBracket(String s) {
        Stack<Integer> leftBracket = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftBracket.push(i);
            } else if (s.charAt(i) == '*') {
                star.push(i);
            } else if (s.charAt(i) == ')') {
                if (!leftBracket.isEmpty()) {
                    leftBracket.pop();
                }
                if (!star.isEmpty()) {
                    star.pop();
                }else {
                    return false;
                }
            }
        }
        while (!leftBracket.isEmpty()) {
            if (star.isEmpty()) {
                return false;
            }
            int leftsite = leftBracket.pop();
            int starsite = star.pop();
            if (leftsite > starsite) {
                return false;
            }
        }

        return true;
    }
}
