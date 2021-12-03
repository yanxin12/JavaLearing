// -*- coding: utf-8 -*- 
/**
 * Project: InnerClass
 * Creator: yanking
 * Create time: 2021-08-07 18:58
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package chapter10Homework.Homework03;

import javafx.scene.control.Cell;

public class main_ {
    public static void zz (Cellphone a){
        a.work();
    }
    public static void main(String[] args) {
        new Cellphone().testWork();
       zz( new Cellphone(){
           @Override
           public void work() {
               System.out.println("hello");
           }
       });
    }
}
