// -*- coding: utf-8 -*- 
/**
 * Project: MHL
 * Creator: yanking
 * Create time: 2021-11-20 15:39
 * IDE: IntelliJ IDEA
 * Introduction:
 * id int primary key auto_increment, #自增
 * empId varchar(50) not null default '',#员工号
 * pwd char(32) not null default '',#密码md5
 * name varchar(50) not null default '',#姓名
 * job varchar(50) not null default '' #岗位
 */
package com.domain;

import java.util.Date;

public class employee {
    private Integer id;
    private String empid;
    private String pwd;
    private String name;
    private String job;
    private String sex;
    private String addr;
    private Date borndate;
    private String edu;


    public employee() {
    }

    public employee(Integer id, String empid, String pwd, String name, String job) {
        this.id = id;
        this.empid = empid;
        this.pwd = pwd;
        this.name = name;
        this.job = job;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Date getBorndate() {
        return borndate;
    }

    public void setBorndate(Date borndate) {
        this.borndate = borndate;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "employee{" +
                "id=" + id +
                ", empid='" + empid + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", sex='" + sex + '\'' +
                ", addr='" + addr + '\'' +
                ", borndate=" + borndate +
                ", edu='" + edu + '\'' +
                '}';
    }
}
