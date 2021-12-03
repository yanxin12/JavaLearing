// -*- coding: utf-8 -*- 
/**
 * Project: chapter21
 * Creator: yanking
 * Create time: 2021-11-07 10:55
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.Socket_.Socket_C;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Socket01TCPClient {
    //实现通过Socket向指定端口的服务器端发送信息
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //获取数据输出流
        OutputStream outputStream = socket.getOutputStream();
        //通过OutputStream相服务器发送数据
        outputStream.write("Clinet: Hello,I am Client,I am sending a message to you!".getBytes());
        //在Socket发送完信息之后需要明确信息已经发送完毕,使用socket.shutdown指令
        socket.shutdownOutput();
        //数据发送完成，关闭输出流和Socket，结束程序
        System.out.println("The message has send!");

        //接收来自服务器传来的信息
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readlen = 0;
        while ((readlen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readlen));
        }
        socket.shutdownInput();



        //数据接收完毕,关闭各种借口和流文件
        outputStream.close();
        socket.close();
        inputStream.close();

    }
}
