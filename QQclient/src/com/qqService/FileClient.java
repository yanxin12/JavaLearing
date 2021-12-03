// -*- coding: utf-8 -*- 
/**
 * Project: QQclient
 * Creator: yanking
 * Create time: 2021-11-10 23:58
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.qqService;

import com.qqcommon.Message;
import com.qqcommon.messageType;

import java.io.*;
import java.util.Date;

/**
 * 实现文件的传输
 * 将文件传输工程分为一对一传输和一对多传输
 */
public class FileClient {
    //实现对指定用户传输文件

    /**
     * @param src    源文件路径
     * @param dest   传输文件目标路径
     * @param sender 发送用户
     * @param getter 接收用户
     *               程序发送message给服务器端，经服务器端将文件传输给指定用户
     */
    public static void FileToOne(String src, String dest, String sender, String getter) throws IOException {
        //1.传输数据装箱
        Message message = new Message();
        message.setSendTime(new Date().toString());
        message.setMessageType(messageType.FILE_TO_CLIENT);
        message.setSrc(src);
        message.setDest(dest);
        message.setSender(sender);
        message.setGetter(getter);
//        FileReader fileReader = null;
        FileInputStream fileInputStream = null;
        byte[] data = new byte[(int)new File(src).length()];
        try {
            fileInputStream = new FileInputStream(src);
            fileInputStream.read(data);
            message.setData(data);//传输文件装箱
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //2.获取Socket并发送数据
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectSeverThread.getClientConnectSeverThread(sender).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
