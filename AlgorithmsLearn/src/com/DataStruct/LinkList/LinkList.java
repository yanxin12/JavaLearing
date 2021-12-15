// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-01 20:53
 * IDE: IntelliJ IDEA
 * Introduction:
 * 实现链表对象
 */
package com.DataStruct.LinkList;

import java.util.Objects;

public class LinkList {
    public int LinkLength = 0;
    protected LinkList next = null;
    protected LinkList pre = null;
    protected Entry head = new Entry();
    protected Entry tail = head;

    public LinkList() {
    }

    public int getLinkLength() {
        return LinkLength;
    }

    public void setLinkLength(int linkLength) {
        LinkLength = linkLength;
    }

    public void setHead(Entry head) {
        this.head = head;
    }

    public void setTail(Entry tail) {
        this.tail = tail;
    }

    // 插入操作,头插法，头插法不用使用尾指针
    public boolean insertDataHead(int d) {
        Entry tmp = new Entry(d);
        if (head.next != null) {
            head.next.pre = tmp;
        }
        tmp.next = head.next;
        head.next = tmp;
        tmp.pre = head;
//        tail = tmp;
        ++LinkLength;
        return true;
    }

    // 尾插法，需要使用尾指针,同时需要头指针
    public boolean insertDataTail(int d) {
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

    // 指定删除
    // 从头部删除一个
    public Entry deleteHeadNode() {
        Entry tmp = head.next;
        head.next = head.next.next;
        LinkLength--;
        return tmp;
    }

    // 从尾部删除
    public Entry deleteTailNode() {
        Entry tmp = tail;
        tail = tail.pre;
        tail.next = null;
        return tmp;
    }

    // 遍历链表
    public void searchLink() {
        Entry cur = head;
        while (cur.next != head) {
            cur = cur.next;
            System.out.println(cur.data);
        }
    }

    // 从尾部遍历链表
    public void searchLinkListByTail() {
        Entry cur = tail;
        while (!tail.equals(head)) {
            System.out.println(tail.getData());
            tail = tail.pre;
        }
    }

    // 定义链表内部类，实现链表节点定义
    public static class Entry {
        public Entry next;
        public Entry pre;
        protected int data;


        public Entry() {
            // 对新创建的链表节点进行初始化，方便直接插入
            next = null;
            pre = null;
            data = -1;
        }

        public Entry(int data) {
            this.data = data;
        }

        public Entry(Entry next, Entry pre) {
            this.next = next;
            this.pre = pre;
        }

        public Entry getNext() {
            return next;
        }

        public void setNext(Entry next) {
            this.next = next;
        }

        public Entry getPre() {
            return pre;
        }

        public void setPre(Entry pre) {
            this.pre = pre;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return data == entry.data &&
                    Objects.equals(next, entry.next) &&
                    Objects.equals(pre, entry.pre);
        }

        @Override
        public int hashCode() {
            return Objects.hash(next, pre, data);
        }
    }



}
