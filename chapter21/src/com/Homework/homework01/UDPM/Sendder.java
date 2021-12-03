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
import java.net.SocketException;

public class Sendder {
    //实现采用UDP协议进行数据之间的信息交互
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(6666);
        //实现UPD传递信息
        byte[] buf = new byte[1024];
//        String data = "name";
//        String data = "hobby";
        String data = "bby";
        DatagramPacket packet = new DatagramPacket(data.getBytes(),
                data.getBytes().length, InetAddress.getLocalHost(),8888);
        socket.send(packet);
        //接收回复信息
        DatagramPacket packet1 = new DatagramPacket(buf, buf.length);
        socket.receive(packet1);
        String s = new String(packet1.getData(),0, packet1.getLength());
        System.out.println(s);


        //关闭相应的流文件
        socket.close();


    }
}
