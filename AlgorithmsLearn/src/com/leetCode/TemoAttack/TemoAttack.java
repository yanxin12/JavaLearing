// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-06 20:55
 * IDE: IntelliJ IDEA
 * Introduction:
 * 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄。他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。
 * <p>
 * 当提莫攻击艾希，艾希的中毒状态正好持续 duration 秒。
 * <p>
 * 正式地讲，提莫在 t 发起发起攻击意味着艾希在时间区间 [t, t + duration - 1]（含 t 和 t + duration - 1）处于中毒状态。如果提莫在中毒影响结束 前 再次攻击，中毒状态计时器将会 重置 ，在新的攻击之后，中毒影响将会在 duration 秒后结束。
 * <p>
 * 给你一个 非递减 的整数数组 timeSeries ，其中 timeSeries[i] 表示提莫在 timeSeries[i] 秒时对艾希发起攻击，以及一个表示中毒持续时间的整数 duration 。
 * <p>
 * 返回艾希处于中毒状态的 总 秒数。
 */
package com.leetCode.TemoAttack;

public class TemoAttack {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        // [1,2,3,4,5,6,7,8,9]
        int res = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i] + duration > timeSeries[i + 1]) {
                // 相邻两次中毒不相交
                res += duration;
            } else {
                // 相邻两次中毒时间相互重叠，只需要添加间隔时间
                res += timeSeries[i + 1] - timeSeries[i];
            }
        }
        return res + duration;
    }
}
