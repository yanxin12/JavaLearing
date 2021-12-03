// -*- coding: utf-8 -*- 
/**
 * Project: MHL
 * Creator: yanking
 * Create time: 2021-11-21 00:02
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.domain;

public class loginView {
    private String empid;
    private String pwd;

    public loginView() {
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    @Override
    public String toString() {
        return "loginView{" +
                "empid='" + empid + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
