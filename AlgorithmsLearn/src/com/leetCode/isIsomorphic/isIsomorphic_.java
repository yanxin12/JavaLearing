// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-27 23:47
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.isIsomorphic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class isIsomorphic_ {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // 判断字符串是否是同构的
        // 使用另外集合存储已经映射的字符，防止映射之后出现多对一映射的情况
        Map<Character, Character> data = new HashMap<>();
        HashSet<Character> reflect = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char cur_s = s.charAt(i);
            char cur_t = t.charAt(i);

            if (!data.containsKey(cur_s)) {
                // 当前的s->t的映射已经存在，在两个字符串不是异构的
                if (reflect.contains(cur_t)) {
                    return false;
                }

                data.put(cur_s, cur_t);
                // 将当前映射存入集合，防止重复映射
                reflect.add(cur_t);
            } else {
                // 当前字符映射和之前字符映射之间不相等
                if (data.get(cur_s) != cur_t) {
                    return false;
                }
            }
        }
        return true;
    }
}
