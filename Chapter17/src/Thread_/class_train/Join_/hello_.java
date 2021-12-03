// -*- coding: utf-8 -*- 
/**
 * Project: Chapter17
 * Creator: yanking
 * Create time: 2021-10-31 15:24
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Thread_.class_train.Join_;

public class hello_  implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("子线程结束！");
    }
}
