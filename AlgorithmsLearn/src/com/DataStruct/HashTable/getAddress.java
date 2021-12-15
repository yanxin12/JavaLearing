package com.DataStruct.HashTable;

public interface getAddress{
    // 线性探查法（一次群集）
    public default boolean lineFind() {
        return false;
    }

    // 二次探查法（二次群集）
    public default boolean quadraticFind() {
        return true;
    }

    // 双重散列法
    public default boolean lFind() {
        return true;
    }

     int shout();
    String smile();

}
