// -*- coding: utf-8 -*- 
/**
 * Project: Chapter14
 * Creator: yanking
 * Create time: 2021-10-23 23:35
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package src.comkdl.list_.set_;

import java.util.HashSet;
import java.util.Set;

//1.不可以使用索引的方式对set元素取值
//2.不可以重复存储元素
//3.输出顺序和输入顺序可以不一致（无序）
//4.取出的顺序是一致的
//5、底层：数组+链表
@SuppressWarnings({"all"})
public class set_ {
    public static void main(String[] args) {
        Set hashSet = new HashSet();
//        set的遍历
//        1.迭代器
//        2.普通for循环（无法实现）
//        3.增强for循环
   /*     for (Object o :) {
        }
*/
        hashSet.add(null);
        hashSet.add("hello");
//        添加操作会返回一个bool值，如果添加成功则返回true否则返回false
//        可以通过remove指定删除元素
//        System.out.println(hashSet.add("hello"));
//        System.out.println(hashSet);

        hashSet.add(new Dog("lucy"));
        hashSet.add(new Dog("lucy"));
        System.out.println(hashSet);


        hashSet.add(new String("lucy"));
        System.out.println(hashSet.add(new String("lucy")));
        System.out.println(hashSet);







    }
}

class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}