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
import java.net.ServerSocket;
import java.net.Socket;

public class Socket01TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器正在等待接收信息!");
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readlen = 0;
        while ((readlen = inputStream.read(buf)) != -1) {
//            System.out.println(inputStream.read(buf,0,readlen));
            System.out.println(new String(buf, 0, readlen));
        }
//        System.out.println("数据读取完毕，关闭Socket以及ServerSocket以及输入流");
        //实现通过Socket向客户端发送信息
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Server:Hello Client,I have recept the message that you send!".getBytes());
        //通过使用shutdownOutput指令明确发送信息完毕
        socket.shutdownOutput();


        //所有操作完毕之后需要关闭各种接口和流文件
        socket.close();
        serverSocket.close();
        inputStream.close();
        outputStream.close();


    }
}
