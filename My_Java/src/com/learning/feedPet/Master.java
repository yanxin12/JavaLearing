package com.learning.feedPet;

public class Master {
    private String name;
    int age;

    public Master(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void feed(Pet pet, Food food) {
        System.out.println(name + "给" + "宠物" + pet.getName() +
                "喂" + food.getName() );

    }
}
