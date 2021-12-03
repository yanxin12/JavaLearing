// -*- coding: utf-8 -*- 
/**
 * Project: chapter21
 * Creator: yanking
 * Create time: 2021-11-07 09:47
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.InetAddress_;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class method_ {
    public static void main(String[] args) throws IOException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        System.out.println(InetAddress.getByName("DESKTOP-L20LMRD"));
        System.out.println(InetAddress.getByName("www.baidu.com"));
        System.out.println(InetAddress.getByName("www.baidu.com").getHostName());
        System.out.println(localHost.getHostName());
        System.out.println(localHost.getHostAddress());
        PrintStream out = System.out;
        out.write("hello!".getBytes());
        System.setOut(new PrintStream(""));
        out.close();
//        System.setIn();

    }
}
