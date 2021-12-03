// -*- coding: utf-8 -*- 
/**
 * Project: Chapter17
 * Creator: yanking
 * Create time: 2021-11-01 16:41
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Homework.homework02;

public class homework02 {
    public static void main(String[] args) {
        getMoney gm = new getMoney();
        Thread A = new Thread(gm);
        A.setName("线程A");
        Thread B = new Thread(gm);
        B.setName("线程B");
        A.start();
        B.start();

    }
}

class getMoney extends Thread {
    private static boolean loop = true;
    private int money = 10000;

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public void get() {
        synchronized (this) {
            if (money <= 0) {
                this.setLoop(false);
                System.out.println("余额不足，无法取钱！");
                return;


            }
            System.out.println(Thread.currentThread().getName() +
                    "正在取钱，取出了1000元，现在剩下" + (money -= 1000) + "元");
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        super.run();
        while (loop) {
            get();
        }
    }
}
