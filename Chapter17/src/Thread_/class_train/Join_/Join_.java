// -*- coding: utf-8 -*- 
/**
 * Project: Chapter17
 * Creator: yanking
 * Create time: 2021-10-31 15:23
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Thread_.class_train.Join_;

public class Join_ {
    public static void main(String[] args) throws InterruptedException {
        hello_ hello_ = new hello_();
        Thread thread = new Thread(hello_);

        for (int i = 0; i < 10; i++) {
            System.out.println("hi" + i);
            Thread.sleep(1000);
            if (i == 5) {
                thread.start();
                thread.join();
            }
        }
        System.out.println("主线程结束！");
    }
}
