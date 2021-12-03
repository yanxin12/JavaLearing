// -*- coding: utf-8 -*- 
/**
 * Project: Chapter17
 * Creator: yanking
 * Create time: 2021-10-31 10:08
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Thread_.Thread_method;


@SuppressWarnings({"all"})
public class Thread_method implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setPriority(Thread.MIN_PRIORITY);
//        Thread thread = new Thread(t);
//        thread.start();
        t.setName("老韩");
        t.start();
        System.out.println("main线程倒计时完之后中断子线程！");
        for (int i = 5; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000);
        }

        t.interrupt();
    }

    @Override
    public void run() {

    }
}

class T extends Thread {
    private int num = 0;

    @Override
    public void run() {
        super.run();
        while (true) {
            System.out.println("老韩吃包子，吃了" + (++num));
            try {
                System.out.println(Thread.currentThread().getName() + "休眠中");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被中断了！");
            }
        }
    }
}





