// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-01 20:59
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.DataStruct.LinkList;

public class LinkUse {
    public static void main(String[] args) {
        LinkList.Entry entry01 = null;
        LinkList.Entry entry02 = null;
        LinkList linkList = new LinkList();
        // 实现链表尾节点的插入操作
        for (int i = 1; i <= 10; i++) {
            linkList.insertDataTail(i);
        }
        // 遍历链表
        linkList.searchLink();
//        System.out.println(linkList.getLinkLength());
//        linkList.searchLinkListByTail();

    }
}
