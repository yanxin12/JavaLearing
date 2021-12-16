// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-16 00:56
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.maxConsecutiveAnswers;

public class maxConsecutiveAnswers_update {
    // 程序针对回溯时需要重新遍历已经遍历的子字符串，造成超时
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
                    // 回溯，需要避免重复遍历
                    // 通过对尾指针的移动和字符串首字符的判断避免重复遍历
                    maxXLen = Math.max(maxXLen, Xnum);
                    // 判断子字符串串首字符
                    // 子字符串的第一个字符为阻断字符,字符串串尾需要向后移动一格（当前为阻断字符）
                    // 子字符串的第一个字符为非阻断字符，则将字符串串首字符移动到阻断字符
                    // 相应的需要调整Xnum的大小
                    // 为什么需要前移字符串？
                    // 因为xk的大小无法支配i的前移，而造成xk减小的原因是因为遍历过程中遇到了
                    // 阻断字符，所以为了实现i的往前移动，直接将字符串头移动到阻断字符处即可
                    while (answerKey.charAt(i - Xnum) == x) {
                        // 这里通过Xnum的值的大小移动子字符串的首字符
                        Xnum--;
                    }
                }
            }
        }
        return maxXLen;
    }

}
