// -*- coding: utf-8 -*- 
/**
 * Project: Chapter17
 * Creator: yanking
 * Create time: 2021-11-01 15:52
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Homework.homework01;

import java.util.Scanner;

public class homework01 {
    public static void main(String[] args) {
        A a = new A();
        Thread thread = new Thread(a);
        B b = new B(a);
        thread.start();
        b.start();
    }

}

class A implements Runnable {
    private boolean loop = true;

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public void printNum() throws InterruptedException {
        while (loop) {
            System.out.println((int) (Math.random() * 100) + 1);
            Thread.sleep(1000);
        }
        System.out.println("随机打印数字程序结束！");
    }

    @Override
    public void run() {
        try {
            printNum();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class B extends Thread {
    private char Q;
    private A a;

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            Scanner myScanner = new Scanner(System.in);
            System.out.println("Please input a char, to stop the thread a !");
            Q = myScanner.next().charAt(0);
            if (Q == 'Q' || Q == 'q') {
                a.setLoop(false);
                System.out.println("接收到Q指令，线程a停止!");
                break;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


