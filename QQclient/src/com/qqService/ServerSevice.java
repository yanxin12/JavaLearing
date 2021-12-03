// -*- coding: utf-8 -*- 
/**
 * Project: QQclient
 * Creator: yanking
 * Create time: 2021-11-09 20:54
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.qqService;

import com.qqView.ClientConnectSeverThread;
import com.qqcommon.Message;
import com.qqcommon.User;
import com.qqcommon.messageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

public class ServerSevice {
    //实现判断输入的账号和密码是否正确的方法
    //private Socket socket;
    //内置User类，方便多次使用User类属性
    //设置为静态类，通过动态绑定机制可以实现线程之间的User是独立的
    private static User u = new User();

    //定义无异常退出方法
    public static void logOut() {
        //1.定义Message类
        Message message = new Message();
        message.setSender(u.getId());
        message.setMessageType(messageType.MEASSAG_CLIENT_EXIT);
        //2.获取Socket，通过静态内部类User从集合中获取
        ClientConnectSeverThread clientConnectSeverThread =
                ManageClientConnectSeverThread.getClientConnectSeverThread(u.getId());
        //3.获取线程的socket并传输数据
        Socket socket = clientConnectSeverThread.getSocket();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //4.移除集合中的线程
        ManageClientConnectSeverThread.removeThread(u.getId());
    }
    //私聊方法的实现
    /**
     * @param content  传输的数据内容
     * @param senderid 数据发送者
     * @param getterid 数据接收者
     */
    public static void talkToOne(String content, String senderid, String getterid) {
        //1.传输信息初始化
        Message message = new Message();
        message.setSender(senderid);
        message.setGetter(getterid);
        message.setContent(content);
        message.setSendTime(new Date().toString());
        //将数据类型定义为普通信息传输
        message.setMessageType(messageType.MEASSAG_COMM_MES);
        //2.获取Socket进行数据传输
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectSeverThread.getClientConnectSeverThread(senderid).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean checkUser(String Uid, String pwd) {
        u.setId(Uid);
        u.setPwd(pwd);
        boolean b = false;
        //连接到服务器，发送u对象
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
            //定义输出流
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);
            oos.flush();
            //接收来自服务器的信息对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            System.out.println("客户端线程准备，等待从服务器端读取信息！ ");
            Message ms = (Message) ois.readObject();
            if (ms.getMessageType().equals(messageType.MEASSAG_LOGIN_SUCESSFUL)) {
                //连接成功
                b = true;
                //创建线程占有Socket,客户端每个登陆用户占有一个独立线程
                ClientConnectSeverThread clientConnectSeverThread = new ClientConnectSeverThread(socket);
                clientConnectSeverThread.start();
                //创建线程管理类，方便操作
                ManageClientConnectSeverThread.addClientConnectSeverThread(Uid,
                        clientConnectSeverThread);
            } else {//连接不成功
                socket.close();//关闭socket
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return b;
    }
    //向服务器请求在线用户列表的方法
    public void onlineFriendList() {
        //获取当前user运行的线程，通过该线程向服务器发送相应类别的信息
        //1. 从线程管理器获得相应线程
        ClientConnectSeverThread clientConnectSeverThread =
                ManageClientConnectSeverThread.getClientConnectSeverThread(u.getId());
        //2.获取线程的socket
        Socket socket = clientConnectSeverThread.getSocket();
        //3.使用对应socket创建文件输出流，将数据类传输到服务器
        try {
            //创建传输文件类，并且将文件设置相应文件类型
            Message message = new Message();
            message.setMessageType(messageType.MEASSAG_GET_ONLINE_FRIEND);
            message.setSender(u.getId());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 实现群发功能
     * @param content 群发内容
     * @param senderid 消息发送者
     */
    public static void talkToAll(String content, String senderid) {
        //1.传输信息初始化
        Message message = new Message();
        message.setSender(senderid);
        message.setContent(content);
        message.setSendTime(new Date().toString());
        message.setMessageType(messageType.MEASSAGE_TO_ALL);
        //2.获取Socket进行数据传输
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectSeverThread.getClientConnectSeverThread(senderid).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
