// -*- coding: utf-8 -*- 
/**
 * Project: QQclient
 * Creator: yanking
 * Create time: 2021-11-09 21:19
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.qqView;

import com.qqcommon.*;
import com.qqcommon.messageType;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.sql.SQLOutput;

public class ClientConnectSeverThread extends Thread {
    //需要占有socket
    private  Socket socket;

    //等待接收来自服务器的数据
    //定义构造器实现socket初始化
    public ClientConnectSeverThread(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    //根据socket输入流等待接收数据
    @Override
    public void run() {
        //线程不断接收来自服务器的信息
        while (true) {
            try {

                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                System.out.println("客户端等待来自服务器的信息！");
                Message ms = (Message) ois.readObject();
                //客户端根据接收到信息的类型进行相应的处理
                //1.判断信息类型
                if (ms.getMessageType().equals(messageType.MEASSAG_RET_ONLINE_FRIEND)) {
                    //2.实现展示在线好友列表的功能
                    String[] s = ms.getContent().split(" ");
                    System.out.println("=====当前在线用户列表=====");
                    for (int i = 0; i < s.length; i++) {
                        System.out.println(s[i]);
                    }
                } else if (ms.getMessageType().equals(messageType.MEASSAG_COMM_MES)) {
                    //3.实现私聊功能，接收私聊信息
                    System.out.println(ms.getSender() + ":" + ms.getContent());
                } else if (ms.getMessageType().equals(messageType.MEASSAGE_TO_ALL)) {
                    //4.实现消息群发功能
                    System.out.println(ms.getSender() + ":" + ms.getContent());
                } else if (ms.getMessageType().equals(messageType.FILE_TO_CLIENT)) {
                    //5.实现文件传输功能
                    System.out.println(ms.getSender() + "将数据发送给" + ms.getGetter() +
                            "并且将数据存储在" + ms.getDest() + "路径上。");
                    /**
                     * 创将文件流，将data数据直接写入指定路径
                     */
                    FileOutputStream fos = new FileOutputStream(ms.getDest());
                    fos.write(ms.getData());
                    fos.close();
                    System.out.println("文件保存成功！");
                } else if (ms.getMessageType().equals(messageType.NEWS)) {
                    //6.实现服务器向在线用户推送新闻
                    System.out.println(ms.getSender()+"对大家说："+ms.getContent());

                } else {
                    System.out.println("数据类型为其他类型，程序暂时不处理！");
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            //不关闭输入流
        }
    }
}
