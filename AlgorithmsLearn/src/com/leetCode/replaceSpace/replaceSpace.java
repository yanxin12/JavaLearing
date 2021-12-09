// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-07 18:40
 * IDE: IntelliJ IDEA
 * Introduction:
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
package com.leetCode.replaceSpace;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class replaceSpace {
    public String replaceSpace_(String s) {
        // 使用正则表达式匹配字符串中的空格字符
        // 并且通过replaceall方法实现替换操作
        String regstr = " ";
        Pattern pattern = Pattern.compile(regstr);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            s = matcher.replaceAll("%20");
        }
        return s;
    }
}
