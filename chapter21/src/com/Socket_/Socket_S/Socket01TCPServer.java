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
import java.net.ServerSocket;
import java.net.Socket;


//通过转换流将字节流数据转换为字符溜数据传输
public class Socket01TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器正在等待接收信息!");
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        //通过转换流实现字符流方法的调用
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();//使用newline作为字符流输出结束标记的时候需要在对面使用readline方法
        System.out.println(s);
        //实现通过Socket向客户端发送信息
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("Server:Hello Client,I have recept the message that you send!");
        bufferedWriter.newLine();//数据传输完毕之后以newline方法作为传输结束标记
        bufferedWriter.flush();


        //所有操作完毕之后需要关闭各种接口和流文件
        socket.close();
        serverSocket.close();
        bufferedWriter.close();
        bufferedReader.close();
        inputStream.close();
        outputStream.close();


    }
}
