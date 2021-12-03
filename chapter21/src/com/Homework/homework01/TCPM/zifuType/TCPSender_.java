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
import java.net.InetAddress;
import java.net.Socket;

public class TCPSender_ {
    //实现数据传送
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream oS = socket.getOutputStream();
//        oS.write("name".getBytes());
        BufferedWriter bW = new BufferedWriter(new OutputStreamWriter(oS));
//        bW.write("name");
//        bW.write("n");
        bW.write("hobby");

        bW.flush();
        System.out.println("数据传送完毕！");
        socket.shutdownOutput();
        //接收来自服务器的回复信息
        InputStream inputStream = socket.getInputStream();
        BufferedReader bR = new BufferedReader(new InputStreamReader(inputStream));
        String s = bR.readLine();
        System.out.println(s);
        //关闭流文件
        inputStream.close();
        bR.close();
        socket.close();


    }
}
