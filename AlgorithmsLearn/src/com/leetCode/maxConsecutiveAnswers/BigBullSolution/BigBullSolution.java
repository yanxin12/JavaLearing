// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-16 11:19
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.maxConsecutiveAnswers.BigBullSolution;

public class BigBullSolution {
//    左右指针确定一个窗口，计算该窗口内T和F的数量，当其中一个小于k的时候，我们可以将那个字母全部改为另一个，从而使窗口中的所有字母相同，因此此时的窗口大小即为一个备选答案，遍历整个字符串得到最大值，就是我们要找的答案。
// 1）右指针滑动，计算窗口内T和F的数量
// 2）如果T和F的数量均大于k，即无法通过修改其中一个字母来使窗口内所有字母相同，需要移动左指针
// 3）左指针移动完毕，此时窗口大小可以作为答案，和当前的最大值比较并更新

    class Solution {
        public int maxConsecutiveAnswers(String answerKey, int k) {
            int n = answerKey.length();
            char[] c = answerKey.toCharArray();
            int left = 0, right = 0;
            int numT = 0, numF = 0;
            int ans = 0;
            while(right < n){
                if(c[right] == 'T')
                    numT++;
                else
                    numF++;
                while(numT > k && numF > k){
                    if(c[left] == 'T')
                        numT--;
                    else
                        numF--;
                    left++;
                }
                ans = Math.max(ans, right - left + 1);
                right++;
            }
            return ans;
        }
    }
//    作者：magic_rubik
//    链接：https://leetcode-cn.com/problems/maximize-the-confusion-of-an-exam/solution/java-hua-dong-chuang-kou-by-magic_rubik-ezth/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
