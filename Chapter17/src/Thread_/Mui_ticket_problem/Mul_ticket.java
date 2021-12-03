// -*- coding: utf-8 -*- 
/**
 * Project: Chapter17
 * Creator: yanking
 * Create time: 2021-10-31 09:12
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Thread_.Mui_ticket_problem;

public class Mul_ticket {
    public static void main(String[] args) {
        sellTicket sellTicket = new sellTicket();
        Thread thread01 = new Thread(sellTicket);
        Thread thread02 = new Thread(sellTicket);
        Thread thread03 = new Thread(sellTicket);
        thread01.start();
        thread02.start();
        thread03.start();


    }
}


class sellTicket implements Runnable {
    private int tickets = 100;

    @Override
    public void run() {
        while (tickets>0) {
            System.out.println("Sell one, There is leave " + (--tickets));
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}