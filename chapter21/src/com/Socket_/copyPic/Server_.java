// -*- coding: utf-8 -*- 
/**
 * Project: chapter21
 * Creator: yanking
 * Create time: 2021-11-08 19:09
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.Socket_.copyPic;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_ {
    //实现在服务器接收来自客户端发送的字节数组形式的数据，并且存入指定位置
    public static void main(String[] args) throws Exception {
        //在ServerSocket里面设置端口号
        ServerSocket serverSocket = new ServerSocket(8888);
        //服务在此等待数据
        System.out.println("服务器已启动，正在等待接收数据！");
        Socket socket = serverSocket.accept();
        //定义服务器输入输出流实现读取数据以及保存数据
        //定义数据读取流(字节流)
        InputStream inputStream = socket.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        Thread.sleep(3000);
        //实现将从服务器中获取的数据存储在指定位置的文件
        String destFilePath = "src\\copyPic.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);
        socket.shutdownInput();

//        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));


        BufferedWriter writers = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writers.write("收到图片！");
        writers.flush();
        socket.shutdownOutput();


        //服务器处理完毕
        inputStream.close();
        bos.close();
        bis.close();
        socket.close();
        serverSocket.close();

        System.out.println("服务器服务完毕！");
    }
}
