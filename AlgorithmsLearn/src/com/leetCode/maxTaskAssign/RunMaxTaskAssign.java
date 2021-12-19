// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-16 23:00
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.maxTaskAssign;

public class RunMaxTaskAssign {
    public static void main(String[] args) {
//        int[] tasks = {1, 2, 3};
//        int[] workers = {0, 3, 3};
//        int pills = 1;
//        int strength = 1;
//         workers[w]+strength 和 帮手之间的比较，谁接近用谁


//        int[] tasks = {2, 2, 4, 4, 5, 6};
//        int[] workers = {1, 2, 3};
//        int pills = 2;
//        int strength = 1;

//
//        int[] tasks = {5, 5, 8, 9, 9};
//        int[] workers = {1, 2, 2, 4, 6};
//        int pills = 1;
//        int strength = 5;

//        int[] tasks = {33, 58, 22, 87, 38};
//        int[] workers = {84, 46, 17, 58, 98, 30, 56, 78, 48};
//        int pills = 0;
//        int strength = 74;

//        int[] tasks = {35};
//        int[] workers = {83, 20, 4, 66};
//        int pills = 3;
//        int strength = 41;
////
//        int[] tasks = {1943, 2068, 4077, 7832, 8061, 6939, 6263, 8917, 8008, 5348, 8837, 4753, 4607, 7638, 9000, 7222, 4552, 1123, 9225, 6896, 4154, 6303, 3186, 2325, 9994, 5855, 8851, 7377, 1930, 1187, 5094, 2689, 8852, 1507, 1567, 9575, 1193, 1557, 8840, 9075, 5032, 3642, 6917, 7968, 5310, 2315, 7516, 4776, 3091, 7027, 1788, 2007, 2651, 6112, 4264, 5644, 3585, 9408, 7410, 9605, 8151, 1538, 6905, 6759, 4518, 3444, 5036, 1589, 3902, 3037, 1468, 9179, 3000, 5339, 6805, 7394, 9418, 9262, 2888, 4708, 3402, 5554, 8714, 7393, 2848, 5946, 9808, 4301, 6675, 8564, 6300, 4359, 9506, 1946, 9673, 7412, 1164, 2986, 2198, 5144, 3763, 4782, 8835, 6994, 8035, 3332, 2342, 5243, 3150, 9084, 6519, 9798, 7682, 9919, 7473, 7686, 9978, 8092, 9897, 3985, 9874, 5842, 9740, 2145, 2426, 7069, 8963, 9250, 4142, 9434, 1895, 6559, 3233, 8431, 6278, 6748, 7305, 4359, 2144, 8009, 4890, 6486, 7464, 8645, 1704, 5915, 9586, 1394, 7504, 2124, 3150, 2051, 5026, 7612, 3715, 5757, 4355, 6394, 3202, 2777, 3949, 2349, 7398, 3029, 3081, 5116, 5078, 8048, 9934, 4348, 8518, 5201, 1203, 7935, 5006, 6388, 8680, 3427, 6048, 1957, 4026, 4618, 4080};
//        int[] workers = {875, 2347, 939, 3664, 3926, 4555, 1947, 4406, 4601, 3502, 4964, 1307, 4232, 2968, 4572, 3139, 2788, 1847, 1208, 2019, 4184, 1664, 1747, 3690, 4333, 891, 686, 1959, 2218, 4972, 806, 741, 1490, 4529, 2909, 925, 2040, 1234, 1264, 1135, 3640, 1455, 2933, 3699, 2856, 3074, 4579, 2458, 2090, 833, 4140, 4534, 2336, 4363, 1948, 4546, 4155, 3735, 3577, 2780, 4874, 1747, 4844, 3482, 3053, 3534, 549, 4500, 2237, 2128, 1554, 3210, 4161, 2211, 950, 3732, 2182, 1148, 4368, 4050, 1452, 1015, 3192, 4318, 3908, 2590, 1103, 2811, 2821, 690, 2718, 3360, 2659, 3315, 579, 3108, 2979, 3903, 4367, 1906, 4964, 889, 4803, 825, 2270, 4794, 4825, 4485, 4461, 1639, 3857, 1330, 3169, 2425, 3694, 1980, 2268, 3002, 2177, 3225, 2499, 2517, 1916, 2844, 760, 2167, 1786, 3179, 3222, 1432, 3775, 4747, 1764, 690, 3223, 4684, 890, 2701, 1045, 3034, 1381, 1011, 2150, 4798, 2247, 1334, 3058, 934, 2895, 1484, 2784, 3341, 4412, 1748, 625, 2610, 3488, 4810, 669, 4275, 4929, 1014, 2104, 3111};
//        int pills = 122;
//        int strength = 3131;//
//
//        int[] tasks = {1123, 1164, 1187, 1193, 1203, 1394, 1468, 1507, 1538, 1557, 1567, 1589, 1704, 1788, 1895, 1930, 1943, 1946, 1957, 2007, 2051, 2068, 2124, 2144, 2145, 2198, 2315, 2325, 2342, 2349, 2426, 2651, 2689, 2777, 2848, 2888, 2986, 3000, 3029, 3037, 3081, 3091, 3150, 3150, 3186, 3202, 3233, 3332, 3402, 3427, 3444, 3585, 3642, 3715, 3763, 3902, 3949, 3985, 4026, 4077, 4080, 4142, 4154, 4264, 4301, 4348, 4355, 4359, 4359, 4518, 4552, 4607, 4618, 4708, 4753, 4776, 4782, 4890, 5006, 5026, 5032, 5036, 5078, 5094, 5116, 5144, 5201, 5243, 5310, 5339, 5348, 5554, 5644, 5757, 5842, 5855, 5915, 5946, 6048, 6112, 6263, 6278, 6300, 6303, 6388, 6394, 6486, 6519, 6559, 6675, 6748, 6759, 6805, 6896, 6905, 6917, 6939, 6994, 7027, 7069, 7222, 7305, 7377, 7393, 7394, 7398, 7410, 7412, 7464, 7473, 7504, 7516, 7612, 7638, 7682, 7686, 7832, 7935, 7968, 8008, 8009, 8035, 8048};
//        int[] workers = {1011, 1014, 1015, 1045, 1103, 1135, 1148, 1208, 1234, 1264, 1307, 1330, 1334, 1381, 1432, 1452, 1455, 1484, 1490, 1554, 1639, 1664, 1747, 1747, 1748, 1764, 1786, 1847, 1906, 1916, 1947, 1948, 1959, 1980, 2019, 2040, 2090, 2104, 2128, 2150, 2167, 2177, 2182, 2211, 2218, 2237, 2247, 2268, 2270, 2336, 2347, 2425, 2458, 2499, 2517, 2590, 2610, 2659, 2701, 2718, 2780, 2784, 2788, 2811, 2821, 2844, 2856, 2895, 2909, 2933, 2968, 2979, 3002, 3034, 3053, 3058, 3074, 3108, 3111, 3139, 3169, 3179, 3192, 3210, 3222, 3223, 3225, 3315, 3341, 3360, 3482, 3488, 3502, 3534, 3577, 3640, 3664, 3690, 3694, 3699, 3732, 3735, 3775, 3857, 3903, 3908, 3926, 4050, 4140, 4155, 4161, 4184, 4232, 4275, 4318, 4333, 4363, 4367, 4368, 4406, 4412, 4461, 4485, 4500, 4529, 4534, 4546, 4555, 4572, 4579, 4601, 4684, 4747, 4794, 4798, 4803, 4810, 4825, 4844, 4874, 4929, 4964, 4964, 4972};
        // 当数据跨度大的时候，因为前面数据被前部，导致力量小的工人即使在嗑药的情况下无法完成大任务
        int[] tasks =     {3642, 3715, 3763, 3902, 3949, 3985, 4026, 4077, 4080, 4142, 4154, 4264, 4301, 4348, 4355, 4359, 4359, 4518, 4552, 4607, 4618, 4708, 4753, 4776, 4782, 4890, 5006, 5026, 5032, 5036, 5078, 5094, 5116, 5144, 5201, 5243, 5310, 5339, 5348, 5554, 5644, 5757, 5842, 5855, 5915, 5946, 6048, 6112, 6263, 6278, 6300, 6303, 6388, 6394, 6486, 6519, 6559, 6675, 6748, 6759, 6805, 6896, 6905, 6917, 6939, 6994, 7027, 7069, 7222, 7305, 7377, 7393, 7394, 7398, 7410, 7412, 7464, 7473, 7504, 7516, 7612, 7638, 7682, 7686};
        int[] workers = {2659, 2701, 2718, 2780, 2784, 2788, 2811, 2821, 2844, 2856, 2895, 2909, 2933, 2968, 2979, 3002, 3034, 3053, 3058, 3074, 3108, 3111, 3139, 3169, 3179, 3192, 3210, 3222, 3223, 3225, 3315, 3341, 3360, 3482, 3488, 3502, 3534, 3577, 3640, 3664, 3690, 3694, 3699, 3732, 3735, 3775, 3857, 3903, 3908, 3926, 4050, 4140, 4155, 4161, 4184, 4232, 4275, 4318, 4333, 4363, 4367, 4368, 4406, 4412, 4461, 4485, 4500, 4529, 4534, 4546, 4555, 4572, 4579, 4601, 4684, 4747, 4794, 4798, 4803, 4810, 4825, 4844, 4874, 4929};
        int pills = 122;
        int strength = 3131;

        System.out.println(" tasks_length = " + tasks.length);
        System.out.println(" workers_length = " + workers.length);
        System.out.println(new maxTaskAssignUpdate().maxTaskAssign(tasks, workers, pills, strength));
        System.out.println("---------------------------------");
        System.out.println(new maxTaskAssign_v3().maxTaskAssign(tasks, workers, pills, strength));
        System.out.println("---------------------------------");
        System.out.println(new BigBull().maxTaskAssign(tasks, workers, pills, strength));

    }
}
//
//        System.out.println(" tasks_length = " + tasks.length);
//                System.out.println(" workers_length = " + workers.length);
//                Arrays.sort(tasks);
//                Arrays.sort(workers);
//                System.out.print("tasks:");
//                for (int i : tasks) {
//                System.out.print(i + ",");
//                }
//                System.out.println();
//                System.out.print("workers:");
//                for (int i : workers) {
//                System.out.print(i + ",");
//                }
