// -*- coding: utf-8 -*- 
/**
 * Project: chapter21
 * Creator: yanking
 * Create time: 2021-11-09 09:06
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.Homework.homework01.TCPM.zifuType;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPGeter {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("等待接收数据");
        Socket socket = serverSocket.accept();
//        byte[] bytes = new  byte[1024];
        InputStream inputStream = socket.getInputStream();
        BufferedReader bR = new BufferedReader(new InputStreamReader(inputStream));
        String s = bR.readLine();
        System.out.println(s);
        //根据收到的信息回复客户端
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bW = new BufferedWriter(new OutputStreamWriter(outputStream));
        String returnData = "";
        if (s.equals("name")){
            returnData = "nova";
        }else if (s.equals("hobby")){
            returnData = "编写java程序";
        }else {
            returnData = "你说啥呢";
        }
        bW.write(returnData);
        bW.flush();
        socket.shutdownOutput();
        System.out.println("完成回复！");
        //关闭相应的流文件
        bW.close();
        outputStream.close();
        inputStream.close();
        bR.close();
        socket.close();
        serverSocket.close();





    }
}
