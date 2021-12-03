// -*- coding: utf-8 -*- 
/**
 * Project: QQserver
 * Creator: yanking
 * Create time: 2021-11-11 10:10
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.qqserver.service;

import com.Utils.Utility;
import com.qqcommon.Message;
import com.qqcommon.messageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Iterator;

/**
 * 线程实现服务器的新闻推送
 * 需要遍历所有在线列表，通过Socket直接传输信息
 */
public class NewsToAllThread implements Runnable {
    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop) {
            //1.信息封装
            Message message = new Message();
            System.out.println("正在通过服务器给在线用户推送新闻，请输入以下内容！");
            System.out.println("(如果需要结束线程请输入exit)");
            System.out.println("新闻内容：");
            String news = Utility.readString(100);
            //3.结束线程
            if (news.equals("exit")) {
                break;
            }
            message.setSendTime(new Date().toString());
            message.setSender("服务器");
            message.setGetter("所有在线用户");
            message.setMessageType(messageType.NEWS);
            message.setContent(news);
            //2.遍历集合,取出Socket，发送文件
            Iterator<String> iterator = ManageServerConetClientThread.sccThread.keySet().iterator();
            while (iterator.hasNext()) {
                String onlineFriends = iterator.next();
                try {
                    ObjectOutputStream oos =
                            new ObjectOutputStream(ManageServerConetClientThread.sccThread.get(onlineFriends).getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //3.结束线程
//            if (news.equals("exit")){
//                setLoop(false);
//            }
        }
    }
}
