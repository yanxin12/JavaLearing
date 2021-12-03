// -*- coding: utf-8 -*- 
/**
 * Project: QQclient
 * Creator: yanking
 * Create time: 2021-11-09 16:37
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.qqView;


import com.qqService.FileClient;
import com.qqService.ServerSevice;
import com.qqcommon.Utility;

import java.io.IOException;

public class mainView {
    static boolean loop = true;
    static String key = "";
    static String userid = "";
    static String pwd = "";


    //这个类实现项目中界面实现
    //一级列表界面
    static void Prensent() {
        while (loop) {
            System.out.println("==========欢迎登陆网络通信系统==========");
            System.out.println("\t\t 1 登陆系统");
            System.out.println("\t\t 2 退出系统");
            System.out.println("请输入你的选择！");
            key = Utility.readString(1);
            switch (key) {
                case "1":
                    System.out.println("请输入用户ID:");
                    userid = Utility.readString(50);
                    System.out.println("请输入密    码:");
                    pwd = Utility.readString(50);
                    //实现登陆账号是否成功登陆
                    if (new ServerSevice().checkUser(userid, pwd)) {
                        twoR();
                    } else {
                        System.out.println("你输入的账号或者密码有误，请重新输入！");
                    }
                    break;
                case "2":
                    loop = false;
                    break;
            }
        }
    }

    //二级列表界面
    static void twoR() {
        while (loop) {
            System.out.println("========欢迎（用户" + userid + "）========");
            System.out.println("\n");
            System.out.println("=======网络通信系统二级菜单（用户" + userid + "）=======");
            System.out.println("\t\t1.显示在线用户列表");
            System.out.println("\t\t2.群发消息");
            System.out.println("\t\t3.私聊消息");
            System.out.println("\t\t4.发送文件");
            System.out.println("\t\t9.退出系统");
            System.out.println("请输入你的选择:");
            key = Utility.readString(1);
            switch (key) {
                case "1":
                    System.out.println("显示在线用户列表");
                    //调用ServerService的方法
                    ServerSevice sevice = new ServerSevice();
                    sevice.onlineFriendList();
                    break;
                case "2":
                    System.out.println("群发消息");
                    System.out.println("发送内容：");
                    String toAllContent = Utility.readString(100);
                    ServerSevice.talkToAll(toAllContent, userid);
                    break;
                case "3":
//                    System.out.println("私聊消息");
                    System.out.print("私聊对象：");
                    String getter = Utility.readString(50);
                    System.out.println("\n私聊信息：");
                    String content = Utility.readString(100);
                    ServerSevice.talkToOne(content, userid, getter);
                    break;
                case "4":
                    System.out.println("发送文件");
                    System.out.println("请输入以下信息");
                    System.out.println("源文件地址：");
                    String src = Utility.readString(200);
                    System.out.println("目标路径地址：");
                    String dest = Utility.readString(200);
                    System.out.println("传输对象：");
                    String getterid = Utility.readString(100);
                    try {
                        FileClient.FileToOne(src,dest,userid,getterid);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "9":
                    System.out.println("退出系统");
                    //实现无异常退出，客户端直接退出，服务器端需要接受来自客户端的退出信号
                    ServerSevice.logOut();
                    System.exit(0);
                    loop = false;
                    break;
            }
        }
    }
}
