// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-15 20:03
 * IDE: IntelliJ IDEA
 * Introduction:
 * 一位老师正在出一场由 n 道判断题构成的考试，每道题的答案为 true （用 'T' 表示）或者 false （用 'F' 表示）。老师想增加学生对自己做出答案的不确定性，方法是 最大化 有 连续相同 结果的题数。（也就是连续出现 true 或者连续出现 false）。
 * <p>
 * 给你一个字符串 answerKey ，其中 answerKey[i] 是第 i 个问题的正确结果。除此以外，还给你一个整数 k ，表示你能进行以下操作的最多次数：
 * <p>
 * 每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i] 改为 'T' 或者 'F' ）。
 * <p>
 * 请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。
 */
package com.leetCode.maxConsecutiveAnswers;

public class maxConsecutiveAnswers_ {
    /**
     * 1 分别求出在可以改变K个值的情况下，最大的连续相同字符T和F
     * 最大的即为结果
     * 2  在1的基础上简化代码，将两次遍历化为1次
     */
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxFLen = getMaxLen(answerKey, k, 'F');
        int maxTLen = getMaxLen(answerKey, k, 'T');
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
                    // 遍历完字符串，需要检验是否还有修改次数
                    if (xk > 0) {
                        Xnum = getRetroSpect(answerKey, Xnum, xk, x);
                    }
                    maxXLen = Math.max(maxXLen, Xnum);
                }
            } else {
                // 此时字符为另一个
                if (xk > 0) {
                    // 可以修改此时的字符，延长连续性
                    ++Xnum;
                    --xk;
                    if (i == answerKey.length() - 1) {
                        // 此时到达字符串的最后一个字符，需要判断Tk对maxXLen的影响
                        if (xk > 0) {
                            Xnum = getRetroSpect(answerKey, Xnum, xk, x);
                        }
                        maxXLen = Math.max(maxXLen, Xnum);
                    }
                } else {
                    // 此时xk=0时，子字符串串首往前移动
                    // 当移动的时候需要判断子字符串的第一个字符是否为阻断字符
                    // 如果子字符串的第一个字符为阻断字符，此时进行前移是xk+1,Xnum-1
                    // 但是如果子字符串的第一个字符为非阻断字符，此时xk不变，Xnum-1
                    // 子字符串的串尾不移动
                    if (answerKey.charAt(i - Xnum + 1) != x) {
                        // 判断子字符串串首字符
                        // 子字符串的第一个字符为非阻断字符
                        xk += 1;
                    }
                    Xnum--;
                    // 因为是通过i和Xnum实现子字符串串首元素的判断
                    // 所以子字符串串首向前移动一格而串尾不变的时候，Xnum肯定需要-1
                    // 为了保持子字符串串尾不变
                    --i;
                }
            }
        }
        return maxXLen;
    }

    // 重置数据是查看当前数据点前面连续字符个数方法
    public int getPreLen(String answerKey, int i, char x) {
        int res = 0;
        while (i > 0) {
            --i;
            if (answerKey.charAt(i) == x) {
                ++res;
            } else {
                break;
            }
        }
        return res;
    }

    // 子字符串前移时候，子字符串首个字符为非阻断字符时，尾巴前移方法
    public int RetroSpect(String answerKey, int i, char x) {
        // 往前走
        while (answerKey.charAt(i) != x) {
            --i;
        }
        return i;
    }


    // 当数组遍历完之后发现xk的值仍然大于0，此时需要往回修改字符
    public int getRetroSpect(String answerKey, int Xnum, int xk, char x) {
        // 往前走
        int i = answerKey.length() - Xnum - 1;
        while (i > 0 && xk >= 0) {
            if (answerKey.charAt(i--) != x) {
                // 当前字符为阻断字符，但是此时修改次数不足则直接退出循环
                if (--xk < 0) {
                    break;
                }
            }
            ++Xnum;
        }
        return Xnum;
    }

}
