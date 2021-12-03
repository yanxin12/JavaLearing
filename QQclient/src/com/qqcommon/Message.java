// -*- coding: utf-8 -*- 
/**
 * Project: QQserver
 * Creator: yanking
 * Create time: 2021-11-09 15:58
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.qqcommon;

import java.io.Serializable;

public class Message  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String getter;//发送者
    private  String sender;//接收者
    private String content;//信息内容
    private String messageType;//信息类别
    private String sendTime;//信息发送时间

    //与文件传输相关的变量
    private byte[] data;//存放数据的字符串数组
    private String src;//源文件路径
    private String dest;//目标文件路径
    private int fileLen = 0;//文件读取长度

    public Message() {
    }

    public Message(String getter, String sender, String content, String messageType, String sendTime) {
        this.getter = getter;
        this.sender = sender;
        this.content = content;
        this.messageType = messageType;
        this.sendTime = sendTime;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public int getFileLen() {
        return fileLen;
    }

    public void setFileLen(int fileLen) {
        this.fileLen = fileLen;
    }
}
