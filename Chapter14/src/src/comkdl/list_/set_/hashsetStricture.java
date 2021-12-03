// -*- coding: utf-8 -*- 
/**
 * Project: Chapter14
 * Creator: yanking
 * Create time: 2021-10-24 00:12
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package src.comkdl.list_.set_;
@SuppressWarnings({"all"})
public class hashsetStricture {
    public static void main(String[] args) {
//        模拟一个HashSet的底层（HashMap底层结果）
//        1.创建一个数组，数组的类型为Node
        Node[] tables = new Node[16];
        System.out.println("tables =" + tables);
//      2.创建节点
        Node john = new Node("John", null);
        tables[2] = john;
        System.out.println("tables =" + tables);
        Node jack = new Node("Jack", null);
        john.next = jack;




    }
}


class Node {
    Object item;
    Node next;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                ", next=" + next +
                '}';
    }
}