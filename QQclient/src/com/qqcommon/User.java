// -*- coding: utf-8 -*- 
/**
 * Project: QQserver
 * Creator: yanking
 * Create time: 2021-11-09 15:58
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.qqcommon;

import java.io.Serializable;

public class User  implements Serializable {
    private String id;
    private String pwd;

    public User() {
    }

    public User(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
