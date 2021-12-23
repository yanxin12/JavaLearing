// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-22 10:45
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.shoppingOffers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RePeatBigBullResolution {
    // 为了减少时间复杂度，将已经计算完成的最优购买需求存储在_cache中
    // 同一个需求会在代码中出现两次？
    Map<List<Integer>, Integer> _cache = new HashMap<>();

    // 抄写大佬代码
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs);
    }

    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (_cache.containsKey(needs)) {
            return _cache.get(needs);
        }
        int ans = 0;
        // 朴素购买
        for (int i = 0; i < price.size(); i++) {
            // 一个一个的买，不购买大礼包
            ans += needs.get(i) * price.get(i);
        }
        // 检验当地大礼包是否符合购买要求
        for (int i = 0; i < special.size(); i++) {
            boolean flag = true;
            ArrayList<Integer> next = new ArrayList<>(needs);
            for (int item = 0; item < price.size(); item++) {
                if (special.get(i).get(item) > needs.get(item)) {
                    // 当前大礼包某个项目购买数量超出了需求
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                continue;
            }
            for (int item = 0; item < price.size(); item++) {
                next.set(item, next.get(item) - special.get(i).get(item));
            }
            ans = Math.min(ans, dfs(price, special, next) + special.get(i).get(price.size()));
        }
        _cache.put(needs, ans);
        return ans;
    }
}

