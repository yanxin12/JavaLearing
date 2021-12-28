// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-25 20:51
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.calculate;

import java.util.Stack;

public class calculate_ {
    // 计算字符串表达式
    // 前缀、后缀表达式计算
    // Java可以时间将char类型的数字转化整形数字再进行计算
    // 使用后缀表达式方法进行计算，方法需要使用两个栈，一个为符号栈一个为数字栈
    // 依次遍历字符串的每一个字符，当遇到符号字符的时候将符号字符放入符号栈，当遇到数字字符的时候将数字字符放入数字栈
    // 每一个符号入栈的时候都应该判断前面栈内的符号，当当前入栈的符号为+或者-的时候，当栈内存在+或者-号的时候
    // 需要一次取出数字栈的两个数字并和符号栈的栈顶符号进行计算
    // 当入栈的符号为*或者/的时候则直接计算即可
    // 遍历的时候应该考虑多位数的情况
    // 单个数字也算一个表达式
    public int calculate(String s) {
        Stack<Character> sign = new Stack<>();
        Stack<Integer> cal_num = new Stack<>();
        int res = 0;
        int i = 0;
        s = s.trim();
        try {
            res = Integer.parseInt(s);
            return res;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        while (i < s.length()) {
            StringBuilder num = new StringBuilder();
            // 需要判断一下当前字符是否是多位数数字
            if (s.charAt(i) == ' ') ++i;
            while (i < s.length() && !isSign(s.charAt(i)) && s.charAt(i) != ' ') {
                num.append(s.charAt(i++));
            }
            cal_num.push(Integer.parseInt(num.toString()));

            if (i < s.length() && s.charAt(i) == ' ') ++i;
            if (i > s.length() - 1) break;
            // 每一个字符进栈的时候都应该判断一下栈顶字符

            while (!sign.isEmpty() && isCal(s.charAt(i), sign.peek())) {
                res = cal(sign.pop(), cal_num.pop(), cal_num.pop());
                cal_num.push(res);
            }
            sign.push(s.charAt(i++));
        }
        while (!sign.isEmpty()) {
            res = cal(sign.pop(), cal_num.pop(), cal_num.pop());
            cal_num.push(res);
        }
        return res;
    }

    // 判断当前字符是数字还是运算符
    public boolean isSign(char x) {
        return x == '*' || x == '/' || x == '+' || x == '-';
    }

    // 判断当前符号进栈的时候是否需要对符号栈的栈顶元素先进行运算
    public boolean isCal(char cur, char peek) {
        if (peek == '*' || peek == '/') {
            return true;
        } else return cur == '+' || cur == '-';
    }

    // 根据传入的字符实现运算
    public int cal(char sign, int b, int a) {
        if (sign == '+') {
            return a + b;
        } else if (sign == '-') {
            return a - b;
        } else if (sign == '*') {
            return a * b;
        } else return a / b;
    }
}
