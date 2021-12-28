// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-25 20:24
 * IDE: IntelliJ IDEA
 * Introduction:
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package com.leetCode.isPowerOfTwo;

public class isPowerOfTwo_ {
    public boolean isPowerOfTwo(int n) {
        if (Math.pow(2, (double) (Math.log(n) / Math.log(2))) == n) {
            return true;
        }
        return false;
    }
}
