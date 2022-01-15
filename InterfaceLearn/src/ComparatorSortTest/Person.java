// -*- coding: utf-8 -*- 
/**
 * Project: InterfaceLearn
 * Creator: yanking
 * Create time: 2022-01-06 14:22
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package ComparatorSortTest;


// 重写比较器
class Persons implements Comparable<Persons> {
    String name;
    int age;

    public Persons(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 定义此方法接受单个参数keyExtractor，该参数是用于提取整数排序键的函数。
    public int getAge() {
        return this.age;
    }

    // 按姓氏ASCII降序，反过来升序
    @Override
    public int compareTo(Persons o) {
        return this.name.compareTo(o.name);
    }
}


