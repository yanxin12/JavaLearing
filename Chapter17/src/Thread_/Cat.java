// -*- coding: utf-8 -*- 
/**
 * Project: Chapter17
 * Creator: yanking
 * Create time: 2021-10-29 10:51
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Thread_;

public class Cat extends Thread {
    @Override
    public void run() {
        int times = 0;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("喵喵你好，我是猫猫！" + (++times) + "线程名称" + Thread.currentThread().getName());
            if (times == 80)
                break;
        }

    }
}
