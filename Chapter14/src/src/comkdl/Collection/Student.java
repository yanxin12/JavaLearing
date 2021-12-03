// -*- coding: utf-8 -*- 
/**
 * Project: Chapter14
 * Creator: yanking
 * Create time: 2021-10-26 14:37
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package src.comkdl.Collection;

public class Student  extends People{
    public Student(String name, int age, String job) {
        super(name, age, job);
    }
    private String majoy;

    public void setMajoy(String majoy) {
        this.majoy = majoy;
    }

    public String getMajoy() {
        return majoy;
    }

    public Student(String name, int age, String job, String majoy) {
        super(name, age, job);
        this.majoy = majoy;
    }

    @Override
    public String toString(){
        return    this.getName()  +this.getAge()+
                "岁,"+"工作是”"+  this.getJob() + ",专业是'" + majoy + '\n';
    }
}
