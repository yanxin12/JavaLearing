// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-22 00:07
 * IDE: IntelliJ IDEA
 * Introduction:
 * 一个句子是由一些单词与它们之间的单个空格组成，且句子的开头和结尾没有多余空格。比方说，"Hello World" ，"HELLO" ，"hello world hello world" 都是句子。每个单词都 只 包含大写和小写英文字母。
 * <p>
 * 如果两个句子 sentence1 和 sentence2 ，可以通过往其中一个句子插入一个任意的句子（可以是空句子）而得到另一个句子，那么我们称这两个句子是 相似的 。比方说，sentence1 = "Hello my name is Jane" 且 sentence2 = "Hello Jane" ，我们可以往 sentence2 中 "Hello" 和 "Jane" 之间插入 "my name is" 得到 sentence1 。
 * <p>
 * 给你两个句子 sentence1 和 sentence2 ，如果 sentence1 和 sentence2 是相似的，请你返回 true ，否则返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sentence-similarity-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package com.leetCode.areSentencesSimilar;

public class areSentencesSimilar_ {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // 判断两个句子的相似性
        // 根据空格划分单词
        // 判断单词少的句子中的单词是否在句子长的边缘
        // 存在连续的单词，可能开头连续，也可能结尾连续
        // I am -- I am Henry
        // I beat -- I want beat
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        if (s1.length > s2.length) {
            return isMargin(s2, s1, 0, s2.length - 1, s1.length - 1);
        } else {
            return isMargin(s1, s2, 0, s1.length - 1, s2.length - 1);
        }
    }

    // 判断句子s1是否在s2的边缘
    public boolean isMargin(String[] s1, String[] s2, int head, int tail_s1, int tail_s2) {
        if (head > tail_s1) {
            return true;
        }
        if (s1[head].equals(s2[head])) {
            // 相同的头
            return isMargin(s1, s2, head + 1, tail_s1, tail_s2);
        } else if (s1[tail_s1].equals(s2[tail_s2])) {
            // 相同的尾
            return isMargin(s1, s2, head, tail_s1 - 1, tail_s2 - 1);
        } else {
            return false;
        }
    }
}
