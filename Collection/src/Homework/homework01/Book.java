// -*- coding: utf-8 -*- 
/**
 * Project: Collection
 * Creator: yanking
 * Create time: 2021-08-15 20:40
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Homework.homework01;

public class Book {
    protected String name;
    protected double price;
    protected String writter;

    public Book(String name, double price, String writter) {
        this.name = name;
        this.price = price;
        this.writter = writter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getWritter() {
        return writter;
    }

    public void setWritter(String writter) {
        this.writter = writter;
    }

    @Override
    public String toString() {
        return "名称: " + name +"\t\t\t" + "价格: " + price +"\t\t\t作者:"  + writter   ;
    }
}


