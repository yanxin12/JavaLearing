// -*- coding: utf-8 -*- 
/**
 * Project: Rent_Sys
 * Creator: yanking
 * Create time: 2021-08-04 10:50
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.RentSystem.domain;

public class House {
    private  int id;
    private String name;
    private  String phone;
    private  String addr;
    private  double rent;
    private String status;

    public House(int id, String name, String phone, String addr, double rent, String status) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.addr = addr;
        this.rent = rent;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  id +
                "\t\t" + name +
                "\t" + phone +
                "\t\t" + addr +
                "\t" + rent +
                "\t" + status ;
    }
}
