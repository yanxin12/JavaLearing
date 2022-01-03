// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2022-01-03 14:19
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.sortSentence_;

public class sortSentenceUpdate {
    // 根据给定字符串规律实现对单词位置判断
    public String sortSentence(String s) {
        StringBuilder res = new StringBuilder(); // 使用StringBuilder连解重新排序的字符串
        String[] reSortString = new String[9];
        int p = 0, q = 1;
        // 使用双指针实现对给定字符串中单词的截取
        // 由给定的字符串可以得知，两个单词之间必定相隔着一个空格
        // 由给定的字符串可知，空格前面一定存在一个记录上一个单词位置的数字
        // 但是最后一个单词后面没有空格，第一个单词前面没有空格
        s = s + " ";
        while (q < s.length()) {
            if (s.charAt(q) == ' ') {
                int idx = Integer.parseInt(s.substring(q - 1, q));
                // 指定单词落座之后将单词后面的数字去掉
                reSortString[idx - 1] = s.substring(p, q - 1) + " ";
                p = q + 1;
            }
            ++q;
        }
        for (int i = 0; i < reSortString.length; i++) {
            res.append(reSortString[i]);
        }
        String ans = res.toString().trim();
        return ans;
    }
}
