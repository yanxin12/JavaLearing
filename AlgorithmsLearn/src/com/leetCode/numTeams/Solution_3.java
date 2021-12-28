// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-25 19:48
 * IDE: IntelliJ IDEA
 * Introduction:
 * 遍历中间的士兵，统计 左边/右边 比他 小/大 的士兵人数。
 * <p>
 * 每名士兵在中间的情况下可以组队的数量为：
 * 左边比他小的人数 × 右边比他大的人数 + 左边比他大的人数 × 右边比他小的人数
 * <p>
 * 公式为：∑(left[0]∗right[1]+left[1]∗right[0])\sum_{}(left[0] * right[1] + left[1] * right[0])∑​(left[0]∗right[1]+left[1]∗right[0])
 * <p>
 * 时间复杂度：一个for循环为O(n)O(n)O(n)，两次count函数O(n)O(n)O(n)，故总的时间复杂度为O(n2)O(n^2)O(n2)。
 * 空间复杂度：O(1)O(1)O(1)。
 * <p>
 * 作者：wowph
 * 链接：https://leetcode-cn.com/problems/count-number-of-teams/solution/tong-ji-liang-ce-de-shi-bing-on2java-by-wowph/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
package com.leetCode.numTeams;

public class Solution_3 {
    public int numTeams(int[] rating) {
        int res = 0;
        int leftNums = 0;
        int leftNumb = 0;
        int rightNums = 0;
        int rightNumb = 0;
        // 遍历中间的士兵
        for (int i = 1; i < rating.length - 1; i++) {
            // 1 左小右大
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    ++leftNums;
                } else {
                    ++leftNumb;
                }
            }
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] > rating[i]) {
                    ++rightNumb;
                } else {
                    ++rightNums;
                }
            }
            res += leftNums * rightNumb + leftNumb * rightNums;
            leftNums = 0;
            leftNumb = 0;
            rightNums = 0;
            rightNumb = 0;
        }
        return res;

    }
}
