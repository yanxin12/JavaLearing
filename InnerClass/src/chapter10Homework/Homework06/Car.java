// -*- coding: utf-8 -*- 
/**
 * Project: InnerClass
 * Creator: yanking
 * Create time: 2021-08-07 19:41
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package chapter10Homework.Homework06;

public class Car {
    public  double temperature;

     class Air {
         String  flowAir;

        public void flow() {
            if (temperature < 0) {
                flowAir = "暖气";
            } else if (temperature > 40) {
                flowAir = "冷气";
            } else {
                flowAir = "空调关闭";
            }
            System.out.println("空调吹的风为： " + flowAir);

        }
    }

    public Car(double temperature) {
        this.temperature = temperature;
    }

    public  Air getclass_(){
         return new Air();
    }
}
