package com.learning.feedPet;

public class Poly {
    public static void main(String[] args) {
        // This progame is used to realize the function of poly feeding
        Master king = new Master("小李");
        dog dog1 = new dog("大黄");
        cat hua = new cat("小花");
        final fish smallFish = new fish("小黄鱼");
        bone bone_ = new bone("大棒骨");
        king.feed(hua,smallFish);
        king.feed(dog1,bone_);

    }
}
