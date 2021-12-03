// -*- coding: utf-8 -*- 
/**
 * Project: chapter21
 * Creator: yanking
 * Create time: 2021-11-07 10:55
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.Socket_.Socket_S;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


//将客户端字节流传输数据的方法改为字符流
public class Socket01TCPClient {
    //实现通过Socket向指定端口的服务器端发送信息
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //获取数据输出流
        OutputStream outputStream = socket.getOutputStream();
        //通过OutputStream向服务器发送数据
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("Clinet: Hello,I am Client,I am sending a message to you!");
        bufferedWriter.newLine();
        bufferedWriter.flush();//数据传输完成之后需要进行手动刷新
        //数据发送完成，关闭输出流和Socket，结束程序
        System.out.println("The message has send!");
        //接收来自服务器传来的信息
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println(bufferedReader.readLine());
        System.out.println("The message from Server have been got!");

        //数据接收完毕,关闭各种借口和流文件
        bufferedReader.close();
        bufferedWriter.close();
        inputStream.close();
        outputStream.close();
        socket.close();

    }
}
