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
import java.net.InetAddress;
import java.net.Socket;

public class Sender {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        OutputStream outputStream = socket.getOutputStream();
//        String data = "name";
//        String data = "hobby";
        String data = "bby";
        outputStream.write(data.getBytes());
        socket.shutdownOutput();
        System.out.println("数据传输完成！");
        //接收来自服务器的回复
        InputStream inputStream = socket.getInputStream();
        int rendlen = 0;
        byte[] buf = new byte[1024];
        while ((rendlen = inputStream.read(buf)) != -1) {
            String s = new String(buf, 0, rendlen);
            System.out.println(s);
        }
        //关闭相应的流文件
        inputStream.close();
        outputStream.close();
        socket.close();


    }
}
