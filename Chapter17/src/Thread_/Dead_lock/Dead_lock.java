// -*- coding: utf-8 -*- 
/**
 * Project: Chapter17
 * Creator: yanking
 * Create time: 2021-11-01 15:35
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Thread_.Dead_lock;

@SuppressWarnings({"all"})
public class Dead_lock {
    public static void main(String[] args) {
        deadLock A = new deadLock(true);
        deadLock B = new deadLock(false);
        new Thread(A).start();
        new Thread(B).start();

    }
}

class deadLock implements Runnable {
    static Object o1 = new Object();
    static Object o2 = new Object();
    private boolean singal;


    public deadLock(boolean singal) {
        this.singal = singal;
    }

    @Override
    public void run() {
        if (singal) {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "进入了互斥区域o1");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "进入了互斥区域o2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "进入了互斥区域o2");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "进入了互斥区域o1");
                }
            }
        }
    }
}
