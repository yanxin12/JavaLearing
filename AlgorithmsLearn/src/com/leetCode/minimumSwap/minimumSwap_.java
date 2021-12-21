// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-21 20:06
 * IDE: IntelliJ IDEA
 * Introduction:
 * 有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。
 * <p>
 * 每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。
 * <p>
 * 交换只能发生在两个不同的字符串之间，绝对不能发生在同一个字符串内部。也就是说，我们可以交换 s1[i] 和 s2[j]，但不能交换 s1[i] 和 s1[j]。
 * <p>
 * 最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-swaps-to-make-strings-equal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package com.leetCode.minimumSwap;

import java.util.HashMap;

public class minimumSwap_ {
    public int minimumSwap(String s1, String s2) {
        // 交换两个字符串的字符，从而实现两个字符串相同
        // 要求使用的方法交换的次数最少
        if (s1.length() != s2.length()) {
            return -1;
        }
        // 需要同时记录多个不相同位置的信息，当出现不相同信息的时候，需要检查前面不相同的信息
        // 不同信息有不同的交换方式，使用两个相同字符进行交换只需要交换一次
        // 两个连续不同的字符进行交换需要交换两次，所以先对相同的字符进行交换，然后对剩下的字符进行交换
        // HashMap<Integer, Character> diff_s1 = new HashMap<Integer, Character>();
        //  HashMap<Integer, Character> diff_s2 = new HashMap<Integer, Character>();
        HashMap<Character, Integer> res = new HashMap<>();
        int count = 0;
        res.put('x', 0);
        res.put('y', 0);
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                res.compute(s1.charAt(i), (key, v) -> v + 1);
            }
        }
        int x_num = res.get('x');
        int y_num = res.get('y');
        count += x_num / 2;
        count += y_num / 2;
        if (x_num % 2 == 1 && y_num % 2 == 1) {
            count += 2;
        }
        if ((x_num % 2 != y_num % 2 && x_num != 0 && y_num != 0) ||
                (x_num + y_num == 1)) {
            return -1;
        }

        return count;
    }
}

