// -*- coding: utf-8 -*- 
/**
 * Project: Chapter16
 * Creator: yanking
 * Create time: 2021-10-28 19:32
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.tank.draw;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings({"all"})
public class DrawCircle extends JFrame {
    private Mypanel md = null;

    public DrawCircle() {
        md = new Mypanel();
        this.add(md);
        this.setSize(400, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new DrawCircle();

    }
}


class Mypanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        System.out.println("调用paint!");
//        g.drawOval(0,0,100,100);
//        g.fillRect(10,10,100,100);
//        Image image = Toolkit .getDefaultToolkit().getImage(Panel.class.getResource("/证.JPG"));
//        Image image = Toolkit .getDefaultToolkit().getImage(Panel.class.getResource("C:\\Users\\hp\\Desktop\\PIC\\证.JPG"));
//        g.drawImage(image,10,10 ,480,640,this);
//        g.setColor(Color.red);
//        g.setFont(new Font("隶书",Font.BOLD,50));
//        g.drawString("北京明白！",100,100);
//        g.setColor(Color.cyan);
//        g.fillRect(40, 40, 10, 60);
//        g.fillRect(50, 50, 20, 40);
//        g.fillRect(70, 40, 10, 60);
//        g.fillOval(50, 60, 20, 20);
////        g.setColor(Color.red);
//        g.drawLine(60, 70, 60, 40);
    }

//    封装画坦克方法
    public void drawTank(){

    }
}