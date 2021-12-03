// -*- coding: utf-8 -*- 
/**
 * Project: chapter21
 * Creator: yanking
 * Create time: 2021-11-08 19:10
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.Socket_.copyPic;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client_ {
    //实现从客户端传出数据
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //定数客户端文件输入流，获取本地文件
//        String sourceFilepath = "C:\\Users\\hp\\ Desktop\\PIC\\身份证.JPG";
        String sourceFilepath = "C:\\Users\\hp\\Desktop\\PIC\\身份证.JPG";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFilepath));
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //定数客户端输出流
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        //将读取的字符流文件上传至socket中
        bos.write(bytes);
        //文件输出完毕需要文件输出结束标记
        socket.shutdownOutput();
//        socket.shutdownInput();
        String s = StreamUtils.streamToString(socket.getInputStream());
        System.out.println(s);
        //文件处理完毕，关闭相关的流文件
        bos.close();
        bis.close();
        socket.close();

    }
}
