// -*- coding: utf-8 -*- 
/**
 * Project: chapter21
 * Creator: yanking
 * Create time: 2021-11-09 08:48
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.Socket_.UDPSocket;

import java.io.IOException;
import java.net.*;

public class UDPSender {
    //实现通过UDP协议发送数据
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9998);
        byte[] buf = new byte[1024];

//        new DatagramPacket(buf,buf.length);
        byte[] data = "明天去吃火锅~".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length,
                InetAddress.getByName("10.201.14.17"),9999);
        //发动数据包
        socket.send(packet);
        System.out.println("数据发送完成！");
        //接收来自对方的信息
            //定义接收包
        DatagramPacket packet1 = new DatagramPacket(buf, buf.length);
        socket.receive(packet1);
        int length = packet1.getLength();
        byte[] data1 = packet1.getData();
        String s = new String(data1, 0, length);
        System.out.println(s);

        //关闭资源
        socket.close();




    }

}
