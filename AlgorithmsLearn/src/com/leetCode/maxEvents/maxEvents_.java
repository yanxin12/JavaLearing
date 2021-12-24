// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-23 01:50
 * IDE: IntelliJ IDEA
 * Introduction:
 * 给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。
 * <p>
 * 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。注意，一天只能参加一个会议。
 * <p>
 * 请你返回你可以参加的 最大 会议数目。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-events-that-can-be-attended
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package com.leetCode.maxEvents;

import java.util.Arrays;
import java.util.HashMap;

public class maxEvents_ {
    // 给出时间段，判断能参加的最多会议
    // {1,2}、{2,3}有两个会议，在1-2天举行第一个会议，在2-3天举行第二个会议
    // 1 会议数可以确定，如何安排参加会议的时间？
    // 2 使用Map，考虑到Map的Key是unique的，对应一天只能参加一个会议
    // 3 传入的会议记录都是一个长度为2的数组，数据索引为0和1
    // 4 会议记录都是开始天数在0结束天数在1，所以可以通过一一搜索的方式匹配到之间没有参加会议的日子
    // 5 如果最优天数匹配到大于结束日期仍然没有能够参加会议的日子，说明该会议没时间去参加
    // 6 考虑会议日期排序杂乱的情况下，安排可能无法达到最佳效果
    //              {1,2} {2,99} {2,2} -> 只能分配到两次会议，没有利用到第二个会议用时久的优点
    //              对数据进行排序 {1,2} {2,2} {2,99}-> 可以参加三次会议
    public int maxEvents(int[][] events) {
        HashMap<Integer, int[]> meeting = new HashMap<>();
        Arrays.sort(events, ((o1, o2) -> {
            return o1[1] - o2[1];
        }));
        int lastMeetingDay = 0;
        for (int i = 0; i < events.length; i++) {
            if (!meeting.containsKey(events[i][0])) {
                // 当天没有会议,可以参加这个会议
                meeting.put(events[i][0], events[i]);
                lastMeetingDay = events[i][0];
            } else {
                // 当天有会议，通过+1搜索会议举行范围内可以参加会议的日子
                int assignDay = Math.max(events[i][0] + 1, lastMeetingDay);
                while (true) {
                    if (assignDay <= events[i][1]) {
                        // 仍然在时间范围内
                        if (!meeting.containsKey(assignDay)) {
                            meeting.put(assignDay, events[i]);
                            lastMeetingDay = assignDay;
                            break;
                        }
                        ++assignDay;
                    } else {
                        // 会议举行时间间隔内，没有能够参加会议的日期
                        break;
                    }
                }
            }
        }
        return meeting.size();
    }
}


