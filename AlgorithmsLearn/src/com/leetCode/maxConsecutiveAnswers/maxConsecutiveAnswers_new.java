// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-16 00:19
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.maxConsecutiveAnswers;

public class maxConsecutiveAnswers_new {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxTLen = getMaxLen(answerKey, k, 'T');
        int maxFLen = getMaxLen(answerKey, k, 'F');
        return Math.max(maxFLen, maxTLen);
    }

    public int getMaxLen(String answerKey, int k, char x) {
        int Xnum = 0;
        int xk = k;
        int maxXLen = 0;
        for (int i = 0; i < answerKey.length(); i++) {
            if (answerKey.charAt(i) == x) {
                ++Xnum;
                if (i == answerKey.length() - 1) {
                    maxXLen = Math.max(maxXLen, Xnum);
                }
            } else {
                // 此时字符为另一个
                if (xk > 0) {
                    // 可以修改此时的字符，延长连续性
                    ++Xnum;
                    --xk;
                    if (i == answerKey.length() - 1) {
                        maxXLen = Math.max(maxXLen, Xnum);
                    }
                } else {
                    // 回溯
                    maxXLen = Math.max(maxXLen, Xnum);
                    i = i - Xnum;
                    Xnum = 0;
                    xk = k;
                }
            }
        }
        return maxXLen;
    }

}
