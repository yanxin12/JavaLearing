// -*- coding: utf-8 -*- 
/**
 * Project: QQserver
 * Creator: yanking
 * Create time: 2021-11-10 00:51
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.qqserver.service;

import java.util.HashMap;

public class ManageServerConetClientThread {
    //创建HashMap实现对服务器线程的管理
    static HashMap<String, ServerConetClientThread> sccThread = new HashMap<>();

    //提供添加方法以及提取方法
    static public void addConetThread(String Userid, ServerConetClientThread serverConetClientThread) {
        sccThread.put(Userid, serverConetClientThread);
    }

    static public ServerConetClientThread getByid(String Userid) {
        return sccThread.get(Userid);
    }
    //实现返回在线好友列表功能
    //对Hashmap进行遍历或得在线好友列表
    //返回在线好友列表的字符串
    //1.创建字符串（不采用静态字符串）
    public static String RETFriends() {
        String onlineFriends = "";
        //2. 获取集合中key的迭代器
        for (String s : sccThread.keySet()) {
            //3.通过迭代器获取map集合中的userid(key值),并且将每个id都用空格分隔开来
            onlineFriends += s.toString() + " ";
        }
        return onlineFriends;
    }

    /**
     * 创建在线程退出时候删除集合中对应线程的方法
     */
    public static void removeThread(String Userid){
         sccThread.remove(Userid);
    }


}
