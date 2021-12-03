package com.learning.feedPet;

public class dog extends Pet{
    public void say(){
        System.out.println("小狗汪汪叫!");
    }

    public dog(String name) {
        this.setName(name);
    }
}
