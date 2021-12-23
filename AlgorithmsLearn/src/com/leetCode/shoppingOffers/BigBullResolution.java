// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-22 01:48
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.shoppingOffers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BigBullResolution {
    Map<List<Integer>, Integer> cache = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(needs, price, special);
    }

    public int dfs(List<Integer> needs, List<Integer> price, List<List<Integer>> special) {
        // 子问题存在则直接返回，存储的是已经计算之后的needs最优购买方法
        if (cache.containsKey(needs))
            return cache.get(needs);
        int ans = 0;
        // 不购买大礼包
        for (int i = 0; i < needs.size(); i++) {
            ans += needs.get(i) * price.get(i);
        }
        // 选择大礼包，即不超过购买数量
        for (int i = 0; i < special.size(); i++) {
            List<Integer> next = new ArrayList<>(needs);
            boolean flag = true;
            for (int item = 0; item < price.size(); item++) {
                if (special.get(i).get(item) > needs.get(item)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) continue;
            for (int item = 0; item < price.size(); item++) {
                // 每次只买一个大礼包
                next.set(item, next.get(item) - special.get(i).get(item));
            }
            ans = Math.min(ans, dfs(next, price, special) + special.get(i).get(price.size()));
        }
        cache.put(needs, ans);
        return ans;
    }
}
