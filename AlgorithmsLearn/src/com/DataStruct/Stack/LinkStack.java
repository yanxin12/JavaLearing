// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-01 20:52
 * IDE: IntelliJ IDEA
 * Introduction:
 * 实现链栈操作
 */
package com.DataStruct.Stack;

import com.DataStruct.LinkList.LinkList;

public class LinkStack extends LinkList {
    // 为了实现使用链表完成栈的先进后出的状态1，插入元素的时候使用尾插法插入
    // 删除元素的链表的尾节点前移一位即可
    // 此时尾节点相当于栈的栈顶指针
    public boolean push_back(int d) {
        Entry tmp = new Entry(d);
        if (head.next == null) {
            // 先完成链表头结点和尾节点的初始化
            // 将头结点和尾节点指向相同位置
            head = tail;
            // 插入节点的时候共同享有同一个next
            head.next = tmp;
            tmp.pre = head;
            // 插入元素之后，尾节点需要前移
            tail = tmp;
        } else {
            // 当链表中存在元素的时候，直接在尾结点后面添加节点
            tail.next = tmp;
            tmp.pre = tail;
            // tmp.next = head;// 循环链表
            // head.pre = tmp;
            // 插入元素之后，尾节点需要前移
            tail = tmp;
            // 为了构建循环链表，这里将尾节点和头节点连接起来
            tail.next = head;
            head.pre = tail;
        }
        ++LinkLength;
        return true;
    }

    // 删除操作
    public Entry push_out(int d) {
        Entry tmp = tail;
        tail = tail.pre;
        // 节点删除之后需要重新对链表进行连接
        tail.next = head;
        head.pre = tail;
        return tmp;
    }

    // 遍历链栈
    public void searchLinkStack() {


    }
}
