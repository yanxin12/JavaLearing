// -*- coding: utf-8 -*- 
/**
 * Project: Chapter14
 * Creator: yanking
 * Create time: 2021-10-26 14:43
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package src.comkdl.Collection;

public class Teacher extends People{
    public Teacher(String name, int age, String job) {
        super(name, age, job);
    }
    private String teachclass;

    public Teacher(String name, int age, String job, String teachclass) {
        super(name, age, job);
        this.teachclass = teachclass;
    }

    public String getTeachclass() {
        return teachclass;
    }

    public void setTeachclass(String teachclass) {
        this.teachclass = teachclass;
    }

    @Override
    public String toString() {
        return   this.getName() +this.getAge()+
                "岁,"+"工作是”"+  this.getJob() + "教的课为"+teachclass + '\n';
    }
}
