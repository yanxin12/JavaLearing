// -*- coding: utf-8 -*- 
/**
 * Project: QQserver
 * Creator: yanking
 * Create time: 2021-11-10 00:21
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.qqserver.service;

import com.qqcommon.Message;
import com.qqcommon.User;
import com.qqcommon.messageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ServerConetClient {
    public static ConcurrentHashMap<String, ArrayList<Message>> offLineUsers = new ConcurrentHashMap<>();
    //创建可登陆用户的集合
    private static ConcurrentHashMap<String, User> validUsers = new ConcurrentHashMap<>();

    //使用静态代码块对可登录用户集合进行初始化
    static {
        validUsers.put("100", new User("100", "123456"));
        validUsers.put("200", new User("100", "123456"));
        validUsers.put("300", new User("100", "123456"));
        validUsers.put("至尊宝", new User("至尊宝", "123456"));
        validUsers.put("紫霞仙子", new User("紫霞仙子", "123456"));
        validUsers.put("菩提老祖", new User("菩提老祖", "123456"));
    }

    //实现接收来自客户端的信息，并且判断用户名和密码是否登陆错误
    private ServerSocket ss;

    public ServerConetClient() {
        try {
            ss = new ServerSocket(8888);//服务器端口号为8888
            //定义socket，程序再次等待客户端的登陆信息
            //需要一直对端口进行监听

            while (true) {
                System.out.println("服务器端在8888端口监听！");
                Socket socket = ss.accept();
                //创建并且运行新闻推送线程
                new Thread(new NewsToAllThread()).start();
                //接收来自客户端的登陆信息，并且判断是否符合登陆条件
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                Message message = new Message();
                User u = (User) ois.readObject();//使用向下类型转化获取到从客户端传输过来的登陆信息
                //为了实现多用户登陆，在这里定义一个用户集合，并且提供验证方法
                if (checkUser(u.getId(), u.getPwd())) {
                    //符合登陆条件
                    //需要给客户端传回登陆成功的信号
                    //需要创建一个不断连接客户端的线程，通过不停的调用线程实现和客户端的通讯
                    //同时需要在此基础上创建一个线程集合，用于管理不同用户的线程
                    //新用户上线，需要在这里查看是否有离线信息未接收
                    message.setMessageType(messageType.MEASSAG_LOGIN_SUCESSFUL);
                    oos.writeObject(message);
                    //启动服务器监听线程
                    ServerConetClientThread serverConetClientThread =
                            new ServerConetClientThread(socket, u.getId());
                    serverConetClientThread.start();
                    try {
                        ManageServerConetClientThread.addConetThread(u.getId(), serverConetClientThread);
                        ArrayList<Message> ungetMessage = offLineUsers.get(u.getId());
                        if (ungetMessage != null) {
                            /**
                             * 存在离线消息没有发送
                             * 遍历离线号集合的ArrayList并且发送消息
                             * 发送完消息之后需要移除离线消息
                             */
                            /**
                             * 这里需要获取userid对应线程绑定的socket这里的oos是服务器的socket
                             */
                            ObjectOutputStream oos02 =
                                    new ObjectOutputStream(ManageServerConetClientThread.sccThread.get(u.getId()).getSocket().getOutputStream());
                            Iterator<Message> iterator = ungetMessage.iterator();
                            while (iterator.hasNext()) {
                                Message next = iterator.next();
//                            System.out.println(next.getSender()+"正在给"+next.getGetter()+"发送信息:"+next.getContent());
                                oos02.writeObject(next);
                                oos02.flush();
                            }
//                            oos.writeObject(iterator.next());
                            //移除离线消息
                            offLineUsers.remove(u.getId());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    //不符合登陆条件
                    System.out.println("用户id = " + u.getId() + "pwd = " + u.getPwd() + "验证失败！");
                    message.setMessageType(messageType.MEASSAG_LOGIN_FAIL);
                    oos.writeObject(message);
                    //关闭相关流文件
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //无限循环结束，关闭流文件
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void addOffLineUsers(String getterid, Message message) {
        //首先需要判断集合中是否getterid是否已经存在
        ArrayList<Message> offlineFriend = offLineUsers.get(getterid);
        if (offlineFriend != null) {
            offlineFriend.add(message);
            ServerConetClient.offLineUsers.put(getterid, offlineFriend);
        } else {
            ArrayList<Message> messages = new ArrayList<>();
            messages.add(message);
            ServerConetClient.offLineUsers.put(getterid, messages);
        }

    }

    /**
     * 创建一个方法判断接收的message中的发送对象是否在线
     * 如果不在线则放入结合offlineUser中
     */
    public static Boolean ifLine(Message message) {
        ServerConetClientThread user = ManageServerConetClientThread.sccThread.get(message.getGetter());
        return user != null;
        //在线为true，不在线为false
    }

    //创建判断登陆用户是否符合登陆条件的方法
    private boolean checkUser(String id, String pwd) {
        //通过传入的用户的id和密码进行查找，分别返回值
        User user = validUsers.get(id);
        if (user == null) {
            //集合之中找不到用户，登陆失败
            return false;
        }
        //集合中存在该用户，判断该用户密码是否正确
        if (!(user.getPwd().equals(pwd))) {
            return false;
        }
        //集合中存在该用户而且密码正确，允许登陆
        return true;
    }

}



