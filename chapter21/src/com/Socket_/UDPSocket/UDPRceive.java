// -*- coding: utf-8 -*- 
/**
 * Project: chapter21
 * Creator: yanking
 * Create time: 2021-11-09 08:36
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.Socket_.UDPSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPRceive {
    //实现使用UDP协议进行数据传输
    public static void main(String[] args) throws IOException {
        byte[] buf = new byte[1024];
        //创建UDPSocket并且定义接口
        DatagramSocket socket = new DatagramSocket(9999);
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        //UDPSocket在此等待数据传入
        System.out.println("等待数据传入...");
        socket.receive(packet);
        //将获取的数据进行解包
        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data,0, length);
        System.out.println(s);

        System.out.println("数据接收完成！");
        //发送数据给对面
        byte[] data01 = "好的，明天见！".getBytes();
        DatagramPacket packet1 = new DatagramPacket(data01, data01.length, InetAddress.getLocalHost(), 9998);
        socket.send(packet1);
        //数据发送完毕
        System.out.println("数据发送完毕！");


        //关闭资源
        socket.close();


    }
}
