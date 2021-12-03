// -*- coding: utf-8 -*- 
/**
 * Project: chapter21
 * Creator: yanking
 * Create time: 2021-11-09 12:08
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.Homework.homework01.UDPM;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Getter {
    //程序使用UPD传输协议实现信息的交流
    public static void main(String[] args) throws IOException {
        String returnData = "";
        //定义端口号为8888的socket
        DatagramSocket socket = new DatagramSocket(8888);
        //初始化接收数据的包
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        //接收数据文件
        System.out.println("等待接收数据");
        socket.receive(packet);
        //将接收的包数据实现解包操作
        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);
        //数据接收完毕
        //根据接收的数据进行回复
        if (s.equals("name")){
            returnData = "nova";
        }else if (s.equals("hobby")){
            returnData = "编写java程序";
        }else {
            returnData = "你说啥呢";
        }
        DatagramPacket packet1 = new DatagramPacket(returnData.getBytes(),
                returnData.getBytes().length, InetAddress.getLocalHost(), 6666);
        socket.send(packet1);
        System.out.println("数据回复完毕！");


        //关闭相应的流文件
        socket.close();


    }
}
