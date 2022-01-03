// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2022-01-02 13:51
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.sortSentence_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class sortSentence_ {
    // 对字符串里面的单词按照序号进行排序
    // 排序完之后删除序号和空格
    public String sortSentence(String s) {
        s = "  ".concat(s);
        String[] sortString = new String[9];
        String res = "";
        int q = s.length() - 1;
//        System.out.println("start!");
//        System.out.println(s.charAt(q));
//        System.out.println("end!");
        while (q > 0) {
            int p = q - 1;
            while (p > 0 && !Character.isDigit(s.charAt(p))) {
                p--;
            }
            int idx = Integer.parseInt(s.substring(q, q + 1));
            sortString[idx - 1] = s.substring(p + 1, q + 1);
//            int idx = s.charAt(p) - '0';

            q = p;
        }
        for (int i = 0; i < sortString.length; i++) {
            if (sortString[i] != null) {
                res = res.concat(sortString[i]);
            }
        }
        String regstr = "\\d";
        Pattern pattern = Pattern.compile(regstr);
        Matcher matcher = pattern.matcher(res);
        res = matcher.replaceAll("");
        res.trim();

        return res;
//        StringBuilder ans = new StringBuilder();
//        for (int i = 0; i < res.length(); i++) {
//            if (!Character.isDigit(res.charAt(i))) {
//                ans.append(res.charAt(i));
//            }
//        }
//        return ans.toString();
    }
}
