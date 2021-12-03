// -*- coding: utf-8 -*- 
/**
 * Project: QQclient
 * Creator: yanking
 * Create time: 2021-11-09 22:13
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.qqService;

import com.qqView.ClientConnectSeverThread;

import java.util.HashMap;

public class ManageClientConnectSeverThread {
    //通过集合将所有客户端的线程进行集中管理
   static HashMap<String, ClientConnectSeverThread> map = new HashMap<>();

   //将每个客户端对应的线程加入
   static void addClientConnectSeverThread(String Userid, ClientConnectSeverThread thread){
       map.put(Userid, thread);
   }

    static ClientConnectSeverThread getClientConnectSeverThread(String Userid){
       return map.get(Userid);
    }

    //当客户端线程退出时候，删除相应线程
    static void removeThread(String Userid){
       map.remove(Userid);
    }

}
