// -*- coding: utf-8 -*- 
/**
 * Project: Rent_Sys
 * Creator: yanking
 * Create time: 2021-08-05 10:09
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package InterFace;

public class main_ {
    public static void main(String[] args) {
        Student student = new Student("小王","2099102",18);
        student.jump();
        student.interest();
        student.show();
        Student b = (Student) student.getInterFace(student);
        


    }
}
