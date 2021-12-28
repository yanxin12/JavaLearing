// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-27 20:06
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.AuthenticationManager;

import java.util.HashMap;

public class AuthenticationManager {
    private int timeToLive = 0;
    private HashMap<String, Integer> tokenMap = new HashMap<>();


    public AuthenticationManager(int timeToLive) {
        // 构造器，用于初始化验证码存活时间
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        // 在当前时间生成一个验证码，如果当前时间存在相同的验证码则进行覆盖
        tokenMap.put(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        // 实现更新验证码操作，如果当前时间验证码已经过期则忽视此操作
        if (tokenMap.containsKey(tokenId) && currentTime < tokenMap.get(tokenId) + timeToLive) {
            tokenMap.put(tokenId, currentTime);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        // 返回当前时候未过期的验证码个数
        int unExpiredTokensNums = 0;
        for (String s : tokenMap.keySet()) {
            if (tokenMap.get(s) + timeToLive > currentTime) {
                ++unExpiredTokensNums;
            }
        }
        return unExpiredTokensNums;
    }

}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */