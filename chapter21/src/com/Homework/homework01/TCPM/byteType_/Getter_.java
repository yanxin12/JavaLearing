// -*- coding: utf-8 -*- 
/**
 * Project: chapter21
 * Creator: yanking
 * Create time: 2021-11-09 11:52
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.Homework.homework01.TCPM.byteType_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Getter_ {
    public static void main(String[] args) throws IOException {
        String s = "";
        String returnData = "";
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("等待接收数据！");
        Socket socket = serverSocket.accept();
        byte[] buf = new byte[1024];
        InputStream inputStream = socket.getInputStream();
        int readlen = 0;
        while((readlen = inputStream.read(buf))!=-1){
            s = new String(buf, 0, readlen);
            System.out.println(s);
        }
        if (s.equals("name")){
            returnData = "nova";
        }else if (s.equals("hobby")){
            returnData = "编写java程序";
        }else {
            returnData = "你说啥呢";
        }
        //回复信息
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(returnData.getBytes());
        socket.shutdownOutput();
        System.out.println("数据回复完成！");

        //关闭相应的流文件
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
