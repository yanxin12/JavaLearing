// -*- coding: utf-8 -*- 
/**
 * Project: Chapter17
 * Creator: yanking
 * Create time: 2021-11-01 09:15
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Thread_.synchronize_;

@SuppressWarnings({"all"})
public class synchronize_m {
    //    实现synchrinized实现线程同步
    public static void main(String[] args) {
        sellTicket sellTicket01 = new sellTicket();
        Thread sT01 = new Thread(sellTicket01);
        Thread sT02 = new Thread(sellTicket01);
        Thread sT03 = new Thread(sellTicket01);
        sT01.start();
        sT01.setName("线程1");
        sT02.setName("线程2");
        sT03.setName("线程3");
        sT02.start();
        sT03.start();
    }
}


class sellTicket implements Runnable {
    Object object = new Object();
    private int tickets = 100;
    private boolean loop = true;

    public synchronized void m() {
        if (tickets <= 0) {
            loop = false;
            System.out.println("售票结束，当前票数为" + tickets);
            return;
        }
        System.out.println(Thread.currentThread().getName() +
                "售卖了一张票，当前还剩" + (tickets--) + "张票");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (loop) {
            m();
        }
    }
}