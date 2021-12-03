// -*- coding: utf-8 -*- 
/**
 * Project: QQserver
 * Creator: yanking
 * Create time: 2021-11-10 00:33
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.qqserver.service;

import com.qqcommon.Message;
import com.qqcommon.messageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Iterator;

public class ServerConetClientThread extends Thread {
    //实现和客户端进行连接，接收来自客户端的Message类的信息
    private Socket socket = null;
    private String Userid = "";
    private boolean loop = true;

    //使用构造器实现socket和Userid信息的初始化
    public ServerConetClientThread(Socket socket, String userid) {
        this.socket = socket;
        Userid = userid;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public Socket getSocket() {
        return socket;
    }

    //服务器只有一个接收信息的线程
    private void getMessage() {
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //接收来自客户端的Message信息
            Message message = (Message) ois.readObject();
            /**
             * 实现离线消息缓存：
             * 1.需要判断message的getter是否在线，
             *       需要在私聊和文件传送功能中进行判断
             *     如果在线则直接发送，否则将缓存的消息存入offlineUser集合中
             *  2. 确定什么时候发送缓存的数据
             *        当检测到getterid上线之后；每一次用户登陆的时候遍历offlineUser集合
             *                  需要创建一个方法
             *        如果存在User就直接调用Socket发送发送完成之后将User移除
             *
             */


            //接收来自客户端的信息，并且根据信息的种类做出相应的回复
            if (message.getMessageType().equals(messageType.MEASSAG_GET_ONLINE_FRIEND)) {
                //客户端希望返回在线好友列表
                System.out.println(message.getSender() + "希望返回在线好友列表");
                //1.获取在线好友列表（遍历HashMap<>）
                String onlineFriends = ManageServerConetClientThread.RETFriends();
                //2.使用Socket的流文件将信息类写出客户端
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                //3.创建相应的Message文件，并且将信息写入
                Message ms = new Message();
                ms.setContent(onlineFriends);
                ms.setGetter(message.getSender());
                ms.setMessageType(messageType.MEASSAG_RET_ONLINE_FRIEND);
                oos.writeObject(ms);

            } else if (message.getMessageType().equals(messageType.MEASSAG_CLIENT_EXIT)) {
                //接收到客户端退出的信号
                //服务器需要关闭线程，移除集合中的线程信息，关闭线程相关联的socket文件
                System.out.println("客户端" + message.getSender() + "已经退出！");
                //关闭线程只需要让线程停止无限循环
                //关闭Socket文件需要获取待关闭线程的Socket
                //移除集合中的线程需要调用输出线程的方法
                //1.关闭线程关联的Socket
                String sender = message.getSender();
                ManageServerConetClientThread.getByid(sender).getSocket().close();
                //2.从集合中删除线程
                ManageServerConetClientThread.removeThread(sender);
                //3.停止线程中的无限循环
                setLoop(false);

            } else if (message.getMessageType().equals(messageType.MEASSAG_COMM_MES)) {
                //接收的信息为私聊请求
                //创建接收者线程，并且通过Socket将数据传输过去
                //判断接收方是否离线
                if (!(ServerConetClient.ifLine(message))) {
                    //接收对象不在线，将message数据放入集合中
                    ServerConetClient.addOffLineUsers(message.getGetter(), message);
                } else {
                    // 接收对象在线
                    //1.获取message信息
                    String sender = message.getSender();
                    String getter = message.getGetter();
                    String content = message.getContent();
                    System.out.println("用户" + sender + "请求给用户" + getter + "发送信息！");
                    //2.通过getter的Socket传递数据类
                    ObjectOutputStream oos =
                            new ObjectOutputStream(ManageServerConetClientThread.getByid(getter).getSocket().getOutputStream());
                    oos.writeObject(message);
                }
            } else if (message.getMessageType().equals(messageType.MEASSAGE_TO_ALL)) {
                //接收到的消息请求为群发消息
                //遍历在线线程获取各个线程的Socket，通过Socket实现群发功能
                //1.获取message信息
                String sender = message.getSender();
                String content = message.getContent();
                System.out.println("用户" + sender + "请求给所有在线好友发送信息！");
                //2.获取Socket并且发送消息类
                Iterator<String> iterator = ManageServerConetClientThread.sccThread.keySet().iterator();
                while (iterator.hasNext()) {
                    String onlineFriends = iterator.next();
                    if (!(sender.equals(onlineFriends))) {
                        ObjectOutputStream oos =
                                new ObjectOutputStream(ManageServerConetClientThread.sccThread.get(onlineFriends).getSocket().getOutputStream());
                        oos.writeObject(message);
                    }
                }
            } else if (message.getMessageType().equals(messageType.FILE_TO_CLIENT)) {
                /**
                 * 接到的message类型为文件传输
                 * 服务器将接收的文件采用文件IO的方式传输给getter
                 */
                //判断文件接收方是否在线
                if (!(ServerConetClient.ifLine(message))) {
                    //接收对象不在线，将message数据放入集合中
                    ServerConetClient.addOffLineUsers(message.getGetter(), message);
                } else {
                    //1.获取message中的信息
                    //2.获取Socket并且发送数据
                    ObjectOutputStream oos =
                            new ObjectOutputStream(ManageServerConetClientThread.getByid(message.getGetter()).getSocket().getOutputStream());
                    oos.writeObject(message);
                }
            } else {
                //客户端其他请求，暂不不处理
                System.out.println("客户端其他请求，暂不不处理!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (loop) {
            getMessage();
        }
    }
}
