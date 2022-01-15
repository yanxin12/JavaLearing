// -*- coding: utf-8 -*- 
/**
 * Project: InterfaceLearn
 * Creator: yanking
 * Create time: 2022-01-06 20:04
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package DomainSortTrain;

public class Student implements Comparable {
    // 实现使用自定义比较器对学生对象以年龄进行排序
    // 如果年龄相同则以名字进行排序
    private String name;
    private int age;
    /*private Student(){
        // 一直原先构造器，防止实例化无信息
    }*/

    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Student p = (Student) o;
        if (this.age == p.age) {
            return this.name.compareTo(p.name);
        }
        return this.age - p.age; // 小的在前大的在后
    }
}
